package com.github.web;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.text.StrPool;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.InspectImageCmd;
import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.api.model.AuthResponse;
import com.github.dockerjava.api.model.PullResponseItem;
import com.github.dockerjava.api.model.PushResponseItem;
import com.github.dto.Cloud;
import com.github.dto.ImageRequest;
import com.github.ex.BizException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@Slf4j
@RestController
@RequestMapping("/process")
public class ImageProcessingController {

    @Resource
    private DockerClient dockerClient;

    @Resource
    private Map<String, Cloud> cloud;


    @Value("${output.file.path}")
    private String outputPath;


    @PostMapping
    public String processImages(@RequestBody ImageRequest request) {
        log.info("请求的数据 ==> {}", request);

        try {
            // 调用 Docker 命令处理镜像
            processDockerImages(request);
            return "Images processed and pushed successfully.";
        } catch (Exception e) {
            log.error("Error processing images: {}", e.getMessage());
            throw new BizException(e.getMessage());
        }
    }

    private void processDockerImages(ImageRequest request) throws InterruptedException, IOException {
        List<String> commands = new ArrayList<>();

        for (Map.Entry<String, Cloud> stringCloudEntry : cloud.entrySet()) {
            String provider = stringCloudEntry.getKey();
            Cloud config = stringCloudEntry.getValue();

            log.info("Processing images for provider: {}", provider);

            // 只要有一项为空，则跳过
            if (CharSequenceUtil.isBlank(config.getUsername()) || CharSequenceUtil.isBlank(config.getPassword()) || CharSequenceUtil.isBlank(config.getRegistry()) || CharSequenceUtil.isBlank(config.getNamespace())) {
                continue;
            }

            AuthConfig authConfig = new AuthConfig()
                    .withRegistryAddress(config.getRegistry())
                    .withUsername(config.getUsername())
                    .withPassword(config.getPassword());

            List<String> images = request.getImages();

            for (String image : images) {
                // 根据冒号拆分
                String[] parts = image.split(StrPool.COLON);
                log.info("images parts ==> {}", Arrays.toString(parts));
                // 获取镜像名称，如：nginx
                String repository = parts[0];
                log.info("images repository ==> {}", repository);
                // 获取镜像标签，如：1.18.0
                String tag = parts[1];
                log.info("images tag ==> {}", tag);

                // 格式化镜像名称，将 / 替换为 - ，如：registry.k8s.io-kube-apiserver:v1.27.2 -> registry.k8s.io-kube-apiserver:v1.27.2
                String formattedRepository = repository.replace(StrPool.SLASH, StrPool.DASHED);
                log.info("formattedRepository ==> {}", formattedRepository);
                // 获取目标镜像标签，如：registry.k8s.io-kube-apiserver:v1.27.2 --> registry.k8s.io-kube-apiserver_v1.27.2
                String targetTag = formattedRepository + StrPool.UNDERLINE + tag;
                log.info("targetTag ==> {}", targetTag);

                // 拉取不同架构的镜像
                processPullImage(image);

                processTagImage(image, config.getRegistry() + StrPool.SLASH + config.getNamespace(), targetTag);
                // // 推送镜像 -->
                String targetImage = config.getRegistry() + StrPool.SLASH + config.getNamespace() + StrPool.COLON + targetTag;
                processPushImage(targetImage, authConfig);

                String command = "docker pull " + targetImage + " && docker tag " + targetImage + " " + repository + ":" + tag;
                commands.add(command);

                log.info("command ==> {}", command);
            }
        }

        // 生成 output.md 文件
        generateOutputFile(commands);

    }


    private void generateOutputFile(List<String> commands) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath), StandardOpenOption.CREATE)) {
            for (String command : commands) {
                writer.write(command);
                writer.newLine();
            }
        }
    }

    /**
     * 处理推送镜像
     *
     * @param targetImage 目标镜像名称
     */
    private void processPushImage(String targetImage, AuthConfig authConfig) {

        InspectImageCmd inspectImageCmd = dockerClient.inspectImageCmd(targetImage);
        if (inspectImageCmd.exec() == null) {
            log.info("镜像不存在，跳过推送 ==> {}", targetImage);
        }
        try {
            log.info("推送镜像开始 ==> {}", targetImage);
            CountDownLatch latch = new CountDownLatch(1);

            dockerClient
                    .pushImageCmd(targetImage)
                    .withAuthConfig(authConfig)
                    .exec(new ResultCallback.Adapter<PushResponseItem>() {
                        @Override
                        public void onNext(PushResponseItem item) {
                            log.info("PushResponseItem next ==> {}", item);
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            log.error("PushResponseItem next error ==> {}", throwable.getMessage());
                            latch.countDown();  // 出现错误时减少计数，确保退出等待
                        }

                        @Override
                        public void onComplete() {
                            log.info("PushResponseItem Image pushed: {}", targetImage);
                            latch.countDown();  // 拉取完成时减少计数，确保退出等待
                        }

                    });
            latch.await();  // 等待推送完成或出现错误
            log.info("推送镜像结束 ==> {}", targetImage);
        } catch (Exception ex) {
            log.error("推送镜像失败 ==> {} ", ex.getMessage());
        }
    }

    /**
     * 处理打标签
     *
     * @param image          镜像名称
     * @param targetRegistry 目标仓库地址
     * @param tag            镜像标签
     */
    private void processTagImage(String image, String targetRegistry, String tag) {
        try {
            log.info("镜像打标签开始 ==> {} as {}", image, tag);
            InspectImageCmd inspectImageCmd = dockerClient.inspectImageCmd(image);
            dockerClient
                    .tagImageCmd(inspectImageCmd.getImageId(), targetRegistry, tag)
                    .exec();
            log.info("镜像打标签结束 ==> {} as {}", image, tag);
        } catch (Exception e) {
            log.error("打标签失败 ==> {} as {}: {}", image, tag, e.getMessage());
        }
    }

    /**
     * 处理拉取镜像
     *
     * @param image 镜像名称
     */
    private void processPullImage(String image) {
        try {
            // 如果本地有该镜像，则跳过拉取
            InspectImageCmd inspectImageCmd = dockerClient.inspectImageCmd(image);
            if (inspectImageCmd.exec() != null) {
                log.info("镜像已存在，跳过拉取 ==> {}", image);
            }
        } catch (NotFoundException e) {
            try {
                // 如果本地没有该镜像，再拉取
                log.info("镜像拉取开始 ==> {}", image);
                CountDownLatch latch = new CountDownLatch(1);
                dockerClient
                        .pullImageCmd(image)
                        .exec(new ResultCallback.Adapter<PullResponseItem>() {
                            @Override
                            public void onNext(PullResponseItem item) {
                                log.info("PullResponseItem next ==> {}", item);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                log.error("PullResponseItem next error ==> {}", throwable.getMessage());
                                latch.countDown();  // 出现错误时减少计数，确保退出等待
                            }

                            @Override
                            public void onComplete() {
                                log.info("PullResponseItem Image pulled: {}", image);
                                latch.countDown();  // 拉取完成时减少计数，确保退出等待
                            }
                        });
                latch.await();  // 等待拉取完成或出现错误
                log.info("镜像拉取结束 ==> {}", image);
            } catch (Exception ex) {
                log.error("镜像拉取失败 ==> {}: {}", image, ex.getMessage());
                throw new BizException("镜像拉取失败", ex);
            }

        } catch (Exception e) {
            log.error("检查镜像是否存在失败 ==> {}: {}", image, e.getMessage());
            throw new BizException("检查镜像是否存在失败", e);
        }

    }
}
