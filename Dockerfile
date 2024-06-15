FROM gradle:8.8-jdk17 AS build
WORKDIR /app
COPY . .
ENV GRADLE_OPTS="-Xmx2048m"
RUN gradle clean build -x test -i
FROM docker:24.0.5-dind
RUN apk update \
    && apk add --no-cache curl tar bash \
    && apk add --no-cache openjdk17 \
    && rm -rf /var/cache/apk/*
WORKDIR /app
COPY --from=build /app/build/libs/*.jar ./app.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' > /etc/timezone && touch ./app.jar

ENV PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/local/libexec/docker:/usr/libexec/docker:$PATH"
ENV JAVA_OPTS=""
ENV PARAMS=""
ENV DOCKERHUB_USERNAME=""
ENV DOCKERHUB_PASSWORD=""
ENV DOCKERHUB_REGISTRY=""
ENV DOCKERHUB_NAMESPACE=""
ENV ALIYUN_USERNAME=""
ENV ALIYUN_PASSWORD=""
ENV ALIYUN_REGISTRY=""
ENV ALIYUN_NAMESPACE=""
ENV TENCENT_USERNAME=""
ENV TENCENT_PASSWORD=""
ENV TENCENT_REGISTRY=""
ENV TENCENT_NAMESPACE=""
ENV HUAWEI_USERNAME=""
ENV HUAWEI_PASSWORD=""
ENV HUAWEI_REGISTRY=""
ENV HUAWEI_NAMESPACE=""
ENV CUSTOM_USERNAME=""
ENV CUSTOM_PASSWORD=""
ENV CUSTOM_REGISTRY=""
ENV CUSTOM_NAMESPACE=""

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "\
    dockerd-entrypoint.sh && \
    [ ! -z \"$DOCKERHUB_USERNAME\" ] && echo ALIYUN_USERNAME: $DOCKERHUB_USERNAME || true && \
    [ ! -z \"$DOCKERHUB_PASSWORD\" ] && echo ALIYUN_PASSWORD: $DOCKERHUB_PASSWORD || true && \
    [ ! -z \"$DOCKERHUB_REGISTRY\" ] && echo ALIYUN_REGISTRY: $DOCKERHUB_REGISTRY || true && \
    [ ! -z \"$DOCKERHUB_NAMESPACE\" ] && echo ALIYUN_NAMESPACE: $DOCKERHUB_NAMESPACE || true && \
    [ ! -z \"$ALIYUN_USERNAME\" ] && echo ALIYUN_USERNAME: $ALIYUN_USERNAME || true && \
    [ ! -z \"$ALIYUN_PASSWORD\" ] && echo ALIYUN_PASSWORD: $ALIYUN_PASSWORD || true && \
    [ ! -z \"$ALIYUN_REGISTRY\" ] && echo ALIYUN_REGISTRY: $ALIYUN_REGISTRY || true && \
    [ ! -z \"$ALIYUN_NAMESPACE\" ] && echo ALIYUN_NAMESPACE: $ALIYUN_NAMESPACE || true && \
    [ ! -z \"$TENCENT_USERNAME\" ] && echo TENCENT_USERNAME: $TENCENT_USERNAME || true && \
    [ ! -z \"$TENCENT_PASSWORD\" ] && echo TENCENT_PASSWORD: $TENCENT_PASSWORD || true && \
    [ ! -z \"$TENCENT_REGISTRY\" ] && echo TENCENT_REGISTRY: $TENCENT_REGISTRY || true && \
    [ ! -z \"$TENCENT_NAMESPACE\" ] && echo TENCENT_NAMESPACE: $TENCENT_NAMESPACE || true && \
    [ ! -z \"$HUAWEI_USERNAME\" ] && echo HUAWEI_USERNAME: $HUAWEI_USERNAME || true && \
    [ ! -z \"$HUAWEI_PASSWORD\" ] && echo HUAWEI_PASSWORD: $HUAWEI_PASSWORD || true && \
    [ ! -z \"$HUAWEI_REGISTRY\" ] && echo HUAWEI_REGISTRY: $HUAWEI_REGISTRY || true && \
    [ ! -z \"$HUAWEI_NAMESPACE\" ] && echo HUAWEI_NAMESPACE: $HUAWEI_NAMESPACE || true && \
    [ ! -z \"$CUSTOM_USERNAME\" ] && echo CUSTOM_USERNAME: $CUSTOM_USERNAME || true && \
    [ ! -z \"$CUSTOM_PASSWORD\" ] && echo HUAWEI_NAMESPACE: $CUSTOM_PASSWORD || true && \
    [ ! -z \"$CUSTOM_REGISTRY\" ] && echo HUAWEI_NAMESPACE: $CUSTOM_REGISTRY || true && \
    [ ! -z \"$CUSTOM_NAMESPACE\" ] && echo HUAWEI_NAMESPACE: $CUSTOM_NAMESPACE || true && \
    java $JAVA_OPTS -jar app.jar $PARAMS \
"]