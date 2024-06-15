package com.github.config;

import cn.hutool.core.text.CharSequenceUtil;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import com.github.dto.Cloud;
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
        String aliyunUsername = System.getenv("ALIYUN_USERNAME");
        log.info("ALIYUN_USERNAME: {}", aliyunUsername);
        String aliyunPassword = System.getenv("ALIYUN_PASSWORD");
        log.info("ALIYUN_PASSWORD: {}", aliyunPassword);
        String aliyunRegistry = System.getenv("ALIYUN_REGISTRY");
        log.info("ALIYUN_REGISTRY: {}", aliyunRegistry);
        String aliyunNamespace = System.getenv("ALIYUN_NAMESPACE");
        log.info("ALIYUN_NAMESPACE: {}", aliyunNamespace);
        if (CharSequenceUtil.isNotBlank(aliyunUsername) && CharSequenceUtil.isNotBlank(aliyunPassword) && CharSequenceUtil.isNotBlank(aliyunNamespace)) {
            if (CharSequenceUtil.isBlank(aliyunRegistry)) {
                aliyunRegistry = "registry.cn-hangzhou.aliyuncs.com";
            }
            cloudConfigs.put("ALIYUN", new Cloud(aliyunUsername, aliyunPassword, aliyunRegistry, aliyunNamespace));
        }

        // 腾讯云
        String tencentUsername = System.getenv("TENCENT_USERNAME");
        log.info("TENCENT_USERNAME: {}", tencentUsername);
        String tencentPassword = System.getenv("TENCENT_PASSWORD");
        log.info("TENCENT_PASSWORD: {}", tencentPassword);
        String tencentRegistry = System.getenv("TENCENT_REGISTRY");
        log.info("TENCENT_REGISTRY: {}", tencentRegistry);
        String tencentNamespace = System.getenv("TENCENT_NAMESPACE");
        log.info("TENCENT_NAMESPACE: {}", tencentNamespace);
        if (CharSequenceUtil.isNotBlank(tencentUsername) && CharSequenceUtil.isNotBlank(tencentPassword) && CharSequenceUtil.isNotBlank(tencentNamespace)) {
            if (CharSequenceUtil.isBlank(tencentRegistry)) {
                tencentRegistry = "ccr.ccs.tencentyun.com";
            }
            cloudConfigs.put("TENCENT", new Cloud(tencentUsername, tencentPassword, tencentRegistry, tencentNamespace));
        }

        // 华为云
        String huaweiUsername = System.getenv("HUAWEI_USERNAME");
        log.info("HUAWEI_USERNAME: {}", huaweiUsername);
        String huaweiPassword = System.getenv("HUAWEI_PASSWORD");
        log.info("HUAWEI_PASSWORD: {}", huaweiPassword);
        String huaweiRegistry = System.getenv("HUAWEI_REGISTRY");
        log.info("HUAWEI_REGISTRY: {}", huaweiRegistry);
        String huaweiNamespace = System.getenv("HUAWEI_NAMESPACE");
        log.info("HUAWEI_NAMESPACE: {}", huaweiNamespace);

        if (CharSequenceUtil.isNotBlank(huaweiUsername) && CharSequenceUtil.isNotBlank(huaweiPassword) && CharSequenceUtil.isNotBlank(huaweiNamespace)) {
            if (CharSequenceUtil.isBlank(huaweiRegistry)) {
                huaweiRegistry = "swr.cn-north-4.myhuaweicloud.com";
            }
            cloudConfigs.put("TENCENT", new Cloud(huaweiUsername, huaweiPassword, huaweiRegistry, huaweiNamespace));
        }

        // 自定义
        String customUsername = System.getenv("CUSTOM_USERNAME");
        log.info("CUSTOM_USERNAME: {}", customUsername);
        String customPassword = System.getenv("CUSTOM_PASSWORD");
        log.info("CUSTOM_PASSWORD: {}", customPassword);
        String customRegistry = System.getenv("CUSTOM_REGISTRY");
        log.info("CUSTOM_REGISTRY: {}", customRegistry);
        String customNamespace = System.getenv("CUSTOM_NAMESPACE");
        log.info("CUSTOM_NAMESPACE: {}", customNamespace);

        if (CharSequenceUtil.isNotBlank(customUsername) && CharSequenceUtil.isNotBlank(customPassword) && CharSequenceUtil.isNotBlank(customRegistry) && CharSequenceUtil.isNotBlank(customNamespace)) {
            cloudConfigs.put("CUSTOM", new Cloud(customUsername, customPassword, customRegistry, customNamespace));
        }

        return cloudConfigs;
    }


}
