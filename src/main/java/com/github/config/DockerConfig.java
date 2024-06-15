package com.github.config;

import cn.hutool.core.text.CharSequenceUtil;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import com.github.dto.Cloud;
import com.github.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class DockerConfig {

    @Bean
    public DockerClient dockerClient() {
        String osName = System
                .getProperty("os.name")
                .toLowerCase();
        String dockerHost;
        if (osName.contains("win")) {
            dockerHost = "tcp://localhost:2375"; // Windows
        } else {
            dockerHost = "unix:///var/run/docker.sock"; // Linux/Mac
        }
        DefaultDockerClientConfig config = DefaultDockerClientConfig
                .createDefaultConfigBuilder()
                .withDockerHost(dockerHost)
                .build();

        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .sslConfig(config.getSSLConfig())
                .maxConnections(100)
                .connectionTimeout(Duration.ofSeconds(30))
                .responseTimeout(Duration.ofSeconds(45))
                .build();
        return DockerClientBuilder
                .getInstance(config)
                .withDockerHttpClient(httpClient)
                .build();
    }

    @Bean
    public Map<String, Cloud> cloud() {
        Map<String, Cloud> cloudConfigs = new HashMap<>();

        // 阿里云
        String aliyunUsername = System.getenv(Constant.ALIYUN_USERNAME);
        log.info("ALIYUN_USERNAME: {}", aliyunUsername);
        String aliyunPassword = System.getenv(Constant.ALIYUN_PASSWORD);
        log.info("ALIYUN_PASSWORD: {}", aliyunPassword);
        String aliyunRegistry = System.getenv(Constant.ALIYUN_REGISTRY);
        log.info("ALIYUN_REGISTRY: {}", aliyunRegistry);
        String aliyunNamespace = System.getenv(Constant.ALIYUN_NAMESPACE);
        log.info("ALIYUN_NAMESPACE: {}", aliyunNamespace);
        if (CharSequenceUtil.isNotBlank(aliyunUsername) && CharSequenceUtil.isNotBlank(aliyunPassword) && CharSequenceUtil.isNotBlank(aliyunNamespace)) {
            if (CharSequenceUtil.isBlank(aliyunRegistry)) {
                aliyunRegistry = "registry.cn-hangzhou.aliyuncs.com";
            }
            cloudConfigs.put(Constant.ALIYUN_PROVIDER, new Cloud(aliyunUsername, aliyunPassword, aliyunRegistry, aliyunNamespace));
        }

        // 腾讯云
        String tencentUsername = System.getenv(Constant.TENCENT_USERNAME);
        log.info("TENCENT_USERNAME: {}", tencentUsername);
        String tencentPassword = System.getenv(Constant.TENCENT_PASSWORD);
        log.info("TENCENT_PASSWORD: {}", tencentPassword);
        String tencentRegistry = System.getenv(Constant.TENCENT_REGISTRY);
        log.info("TENCENT_REGISTRY: {}", tencentRegistry);
        String tencentNamespace = System.getenv(Constant.TENCENT_NAMESPACE);
        log.info("TENCENT_NAMESPACE: {}", tencentNamespace);
        if (CharSequenceUtil.isNotBlank(tencentUsername) && CharSequenceUtil.isNotBlank(tencentPassword) && CharSequenceUtil.isNotBlank(tencentNamespace)) {
            if (CharSequenceUtil.isBlank(tencentRegistry)) {
                tencentRegistry = "ccr.ccs.tencentyun.com";
            }
            cloudConfigs.put(Constant.TENCENT_PROVIDER, new Cloud(tencentUsername, tencentPassword, tencentRegistry, tencentNamespace));
        }

        // 华为云
        String huaweiUsername = System.getenv(Constant.HUAWEI_USERNAME);
        log.info("HUAWEI_USERNAME: {}", huaweiUsername);
        String huaweiPassword = System.getenv(Constant.HUAWEI_PASSWORD);
        log.info("HUAWEI_PASSWORD: {}", huaweiPassword);
        String huaweiRegistry = System.getenv(Constant.HUAWEI_REGISTRY);
        log.info("HUAWEI_REGISTRY: {}", huaweiRegistry);
        String huaweiNamespace = System.getenv(Constant.HUAWEI_NAMESPACE);
        log.info("HUAWEI_NAMESPACE: {}", huaweiNamespace);

        if (CharSequenceUtil.isNotBlank(huaweiUsername) && CharSequenceUtil.isNotBlank(huaweiPassword) && CharSequenceUtil.isNotBlank(huaweiNamespace)) {
            if (CharSequenceUtil.isBlank(huaweiRegistry)) {
                huaweiRegistry = "swr.cn-north-4.myhuaweicloud.com";
            }
            cloudConfigs.put(Constant.HUAWEI_PROVIDER, new Cloud(huaweiUsername, huaweiPassword, huaweiRegistry, huaweiNamespace));
        }

        // 自定义
        String customUsername = System.getenv(Constant.CUSTOM_USERNAME);
        log.info("CUSTOM_USERNAME: {}", customUsername);
        String customPassword = System.getenv(Constant.CUSTOM_PASSWORD);
        log.info("CUSTOM_PASSWORD: {}", customPassword);
        String customRegistry = System.getenv(Constant.CUSTOM_REGISTRY);
        log.info("CUSTOM_REGISTRY: {}", customRegistry);
        String customNamespace = System.getenv(Constant.CUSTOM_NAMESPACE);
        log.info("CUSTOM_NAMESPACE: {}", customNamespace);

        if (CharSequenceUtil.isNotBlank(customUsername) && CharSequenceUtil.isNotBlank(customPassword) && CharSequenceUtil.isNotBlank(customRegistry) && CharSequenceUtil.isNotBlank(customNamespace)) {
            cloudConfigs.put(Constant.CUSTOM_PROVIDER, new Cloud(customUsername, customPassword, customRegistry, customNamespace));
        }

        return cloudConfigs;
    }


}
