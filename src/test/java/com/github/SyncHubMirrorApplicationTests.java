package com.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class SyncHubMirrorApplicationTests {

    public static void main(String[] args) {
        SpringApplication
                .from(SyncHubMirrorApplication::main)
                .with(MySQLDBContainerDevMode.class)
                .run(args);
    }

    @TestConfiguration(proxyBeanMethods = false)
    static class MySQLDBContainerDevMode {

        @Bean
        @RestartScope
        @ServiceConnection(name = "mysql")
        public MySQLContainer<?> mysql() {
            return new MySQLContainer<>("mysql:8")
                    .withEnv("ALIYUN_REPO", "")
                    .withEnv("ALIYUN_USERNAME", "1900919313@qq.com")
                    .withEnv("ALIYUN_PASSWORD", "Sunxiaping1991&");
        }
    }
}
