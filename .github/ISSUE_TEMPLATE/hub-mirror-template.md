---
name: Hub Mirror Request
about: 请求将镜像从 Docker Hub 推送到指定的目标仓库
title: '[hub-mirror] 请求执行任务'
labels: hub-mirror
assignees: ''
---

{
    "hub-mirrors": [
        "registry.k8s.io/kube-apiserver:v1.27.4",
        "registry.k8s.io/kube-apiserver:v1.27.4$my-kube-apiserver",
        "registry.k8s.io/kube-apiserver:v1.27.4$my-kube-apiserver:mytag",
        "要求：hub-mirror 标签是必选的，标题随意，内容严格按照该 json 格式，每次最多支持转换 11 个镜像",
        "错误的镜像都会被跳过",
        "请确保 json 格式是正确的，比如下面这个是最后一个，后面是没有逗号的",
        "好了，改成你想要转换的镜像吧"
    ]
}
