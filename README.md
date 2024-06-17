#  第一章： 需要配置的 `secrets` ，不同的目标仓库配置参数：

* Docker Hub（暂未实现）：

| Secret 名称           | 用途                    | 是否必须 |
| --------------------- | ----------------------- | -------- |
| `DOCKERHUB_USERNAME`  | Docker Hub 用户名       | √        |
| `DOCKERHUB_PASSWORD`  | Docker Hub 密码         | √        |
| `DOCKERHUB_REGISTRY`  | Docker Hub 镜像仓库地址 | ×        |
| `DOCKERHUB_NAMESPACE` | Docker Hub 镜像命名空间 | √        |

* 阿里云（测试通过）：

| Secret 名称        | 用途                 | 是否必须                                    | 示例         |
| ------------------ | -------------------- | ------------------------------------------- | ------------ |
| `ALIYUN_USERNAME`  | 阿里云镜像仓库用户名 | √                                           | abcefg       |
| `ALIYUN_PASSWORD`  | 阿里云镜像仓库密码   | √                                           | 123456       |
| `ALIYUN_REGISTRY`  | 阿里云镜像仓库地址   | ×，默认是 registry.cn-hangzhou.aliyuncs.com |              |
| `ALIYUN_NAMESPACE` | 阿里云镜像命名空间   | √                                           | aexia/docker |

* 腾讯云（测试通过）：

| Secret 名称         | 用途                 | 是否必须                         | 示例         |
| ------------------- | -------------------- | -------------------------------- | ------------ |
| `TENCENT_USERNAME`  | 腾讯云镜像仓库用户名 | √                                | abcefg       |
| `TENCENT_PASSWORD`  | 腾讯云镜像仓库密码   | √                                | 123456       |
| `TENCENT_REGISTRY`  | 腾讯云镜像仓库地址   | ×，默认是 ccr.ccs.tencentyun.com |              |
| `TENCENT_NAMESPACE` | 腾讯云镜像命名空间   | √                                | aexia/docker |

* 华为云：

| Secret 名称        | 用途                 | 是否必须                                   |
| ------------------ | -------------------- | ------------------------------------------ |
| `HUAWEI_USERNAME`  | 华为云镜像仓库用户名 | √                                          |
| `HUAWEI_PASSWORD`  | 华为云镜像仓库密码   | √                                          |
| `HUAWEI_REGISTRY`  | 华为云镜像仓库地址   | ×，默认是 swr.cn-north-4.myhuaweicloud.com |
| `HUAWEI_NAMESPACE` | 华为云镜像命名空间   | √                                          |

* 自定义（测试 quay.io 通过，没有测试 Harbor）：

| Secret 名称        | 用途                 | 是否必须 | 示例                                                         |
| ------------------ | -------------------- | -------- | ------------------------------------------------------------ |
| `CUSTOM_USERNAME`  | 自定义镜像仓库用户名 | √        | abcdef                                                       |
| `CUSTOM_PASSWORD`  | 自定义镜像仓库密码   | √        | 123456                                                       |
| `CUSTOM_REGISTRY`  | 自定义镜像仓库地址   | √        | quay.io                                                      |
| `CUSTOM_NAMESPACE` | 自定义镜像命名空间   | √        | library（在 Harbor 是项目名称，在 quay.io 中是用户名，也可以是其他的） |

# 第二章：仓库权限设置

* ① 开启 workflow permission 权限：

![image-20240615073108178](./assets/image-20240615073108178.png)

* ② 开启 issue ：

![image-20240615073014646](./assets/image-20240615073014646.png)

* ③ 配置 secret ：

![image-20240615073146328](./assets/image-20240615073146328.png)



# 第三章：Kubernetes 默认的组件镜像名称

## 3.1（v1.30.x）

* v1.30.0

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.30.0",
    "registry.k8s.io/kube-controller-manager:v1.30.0",
    "registry.k8s.io/kube-scheduler:v1.30.0",
    "registry.k8s.io/kube-proxy:v1.30.0",
    "registry.k8s.io/coredns/coredns:v1.11.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0"
  ]
}
```

* v1.30.1

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.30.1",
    "registry.k8s.io/kube-controller-manager:v1.30.1",
    "registry.k8s.io/kube-scheduler:v1.30.1",
    "registry.k8s.io/kube-proxy:v1.30.1",
    "registry.k8s.io/coredns/coredns:v1.11.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0"
  ]
}
```

* v1.30.2

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.30.2",
    "registry.k8s.io/kube-controller-manager:v1.30.2",
    "registry.k8s.io/kube-scheduler:v1.30.2",
    "registry.k8s.io/kube-proxy:v1.30.2",
    "registry.k8s.io/coredns/coredns:v1.11.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0"
  ]
}
```

## 3.2（v1.29.x）

* v1.29.0

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.29.0",
    "registry.k8s.io/kube-controller-manager:v1.29.0",
    "registry.k8s.io/kube-scheduler:v1.29.0",
    "registry.k8s.io/kube-proxy:v1.29.0",
    "registry.k8s.io/coredns/coredns:v1.11.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.10-0"
  ]
}
```

* v1.29.1

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.29.1",
    "registry.k8s.io/kube-controller-manager:v1.29.1",
    "registry.k8s.io/kube-scheduler:v1.29.1",
    "registry.k8s.io/kube-proxy:v1.29.1",
    "registry.k8s.io/coredns/coredns:v1.11.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.10-0"
  ]
}
```

* v1.29.2

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.29.2",
    "registry.k8s.io/kube-controller-manager:v1.29.2",
    "registry.k8s.io/kube-scheduler:v1.29.2",
    "registry.k8s.io/kube-proxy:v1.29.2",
    "registry.k8s.io/coredns/coredns:v1.11.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.10-0"
  ]
}
```

* v1.29.3

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.29.3",
    "registry.k8s.io/kube-controller-manager:v1.29.3",
    "registry.k8s.io/kube-scheduler:v1.29.3",
    "registry.k8s.io/kube-proxy:v1.29.3",
    "registry.k8s.io/coredns/coredns:v1.11.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0"
  ]
}
```

* v1.29.4

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.29.4",
    "registry.k8s.io/kube-controller-manager:v1.29.4",
    "registry.k8s.io/kube-scheduler:v1.29.4",
    "registry.k8s.io/kube-proxy:v1.29.4",
    "registry.k8s.io/coredns/coredns:v1.11.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0"
  ]
}
```

* v1.29.5

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.29.5",
    "registry.k8s.io/kube-controller-manager:v1.29.5",
    "registry.k8s.io/kube-scheduler:v1.29.5",
    "registry.k8s.io/kube-proxy:v1.29.5",
    "registry.k8s.io/coredns/coredns:v1.11.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0"
  ]
}
```

* v1.29.6

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.29.6",
    "registry.k8s.io/kube-controller-manager:v1.29.6",
    "registry.k8s.io/kube-scheduler:v1.29.6",
    "registry.k8s.io/kube-proxy:v1.29.6",
    "registry.k8s.io/coredns/coredns:v1.11.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0"
  ]
}
```

## 3.3（v1.28.x）

* v1.28.0

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.0",
    "registry.k8s.io/kube-controller-manager:v1.28.0",
    "registry.k8s.io/kube-scheduler:v1.28.0",
    "registry.k8s.io/kube-proxy:v1.28.0",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.28.1

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.1",
    "registry.k8s.io/kube-controller-manager:v1.28.1",
    "registry.k8s.io/kube-scheduler:v1.28.1",
    "registry.k8s.io/kube-proxy:v1.28.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.28.2

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.2",
    "registry.k8s.io/kube-controller-manager:v1.28.2",
    "registry.k8s.io/kube-scheduler:v1.28.2",
    "registry.k8s.io/kube-proxy:v1.28.2",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.28.3

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.3",
    "registry.k8s.io/kube-controller-manager:v1.28.3",
    "registry.k8s.io/kube-scheduler:v1.28.3",
    "registry.k8s.io/kube-proxy:v1.28.3",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.28.4

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.4",
    "registry.k8s.io/kube-controller-manager:v1.28.4",
    "registry.k8s.io/kube-scheduler:v1.28.4",
    "registry.k8s.io/kube-proxy:v1.28.4",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.28.5

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.5",
    "registry.k8s.io/kube-controller-manager:v1.28.5",
    "registry.k8s.io/kube-scheduler:v1.28.5",
    "registry.k8s.io/kube-proxy:v1.28.5",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.28.6

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.6",
    "registry.k8s.io/kube-controller-manager:v1.28.6",
    "registry.k8s.io/kube-scheduler:v1.28.6",
    "registry.k8s.io/kube-proxy:v1.28.6",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.10-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.28.7

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.7",
    "registry.k8s.io/kube-controller-manager:v1.28.7",
    "registry.k8s.io/kube-scheduler:v1.28.7",
    "registry.k8s.io/kube-proxy:v1.28.7",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.10-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.28.8

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.8",
    "registry.k8s.io/kube-controller-manager:v1.28.8",
    "registry.k8s.io/kube-scheduler:v1.28.8",
    "registry.k8s.io/kube-proxy:v1.28.8",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.28.9

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.9",
    "registry.k8s.io/kube-controller-manager:v1.28.9",
    "registry.k8s.io/kube-scheduler:v1.28.9",
    "registry.k8s.io/kube-proxy:v1.28.9",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.28.10

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.10",
    "registry.k8s.io/kube-controller-manager:v1.28.10",
    "registry.k8s.io/kube-scheduler:v1.28.10",
    "registry.k8s.io/kube-proxy:v1.28.10",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.28.11

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.28.11",
    "registry.k8s.io/kube-controller-manager:v1.28.11",
    "registry.k8s.io/kube-scheduler:v1.28.11",
    "registry.k8s.io/kube-proxy:v1.28.11",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

## 3.4（v1.27.x）

* v1.27.0

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.0",
    "registry.k8s.io/kube-controller-manager:v1.27.0",
    "registry.k8s.io/kube-scheduler:v1.27.0",
    "registry.k8s.io/kube-proxy:v1.27.0",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.7-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.1

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.1",
    "registry.k8s.io/kube-controller-manager:v1.27.1",
    "registry.k8s.io/kube-scheduler:v1.27.1",
    "registry.k8s.io/kube-proxy:v1.27.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.7-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.2

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.2",
    "registry.k8s.io/kube-controller-manager:v1.27.2",
    "registry.k8s.io/kube-scheduler:v1.27.2",
    "registry.k8s.io/kube-proxy:v1.27.2",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.7-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.3

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.3",
    "registry.k8s.io/kube-controller-manager:v1.27.3",
    "registry.k8s.io/kube-scheduler:v1.27.3",
    "registry.k8s.io/kube-proxy:v1.27.3",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.7-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.4

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.4",
    "registry.k8s.io/kube-controller-manager:v1.27.4",
    "registry.k8s.io/kube-scheduler:v1.27.4",
    "registry.k8s.io/kube-proxy:v1.27.4",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.7-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.5

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.5",
    "registry.k8s.io/kube-controller-manager:v1.27.5",
    "registry.k8s.io/kube-scheduler:v1.27.5",
    "registry.k8s.io/kube-proxy:v1.27.5",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.7-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.6

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.6",
    "registry.k8s.io/kube-controller-manager:v1.27.6",
    "registry.k8s.io/kube-scheduler:v1.27.6",
    "registry.k8s.io/kube-proxy:v1.27.6",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.7-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.7

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.7",
    "registry.k8s.io/kube-controller-manager:v1.27.7",
    "registry.k8s.io/kube-scheduler:v1.27.7",
    "registry.k8s.io/kube-proxy:v1.27.7",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.8

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.8",
    "registry.k8s.io/kube-controller-manager:v1.27.8",
    "registry.k8s.io/kube-scheduler:v1.27.8",
    "registry.k8s.io/kube-proxy:v1.27.8",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.9

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.9",
    "registry.k8s.io/kube-controller-manager:v1.27.9",
    "registry.k8s.io/kube-scheduler:v1.27.9",
    "registry.k8s.io/kube-proxy:v1.27.9",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.10

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.10",
    "registry.k8s.io/kube-controller-manager:v1.27.10",
    "registry.k8s.io/kube-scheduler:v1.27.10",
    "registry.k8s.io/kube-proxy:v1.27.10",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.10-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.11

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.11",
    "registry.k8s.io/kube-controller-manager:v1.27.11",
    "registry.k8s.io/kube-scheduler:v1.27.11",
    "registry.k8s.io/kube-proxy:v1.27.11",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.10-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.12

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.12",
    "registry.k8s.io/kube-controller-manager:v1.27.12",
    "registry.k8s.io/kube-scheduler:v1.27.12",
    "registry.k8s.io/kube-proxy:v1.27.12",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.13

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.13",
    "registry.k8s.io/kube-controller-manager:v1.27.13",
    "registry.k8s.io/kube-scheduler:v1.27.13",
    "registry.k8s.io/kube-proxy:v1.27.13",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.14

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.14",
    "registry.k8s.io/kube-controller-manager:v1.27.14",
    "registry.k8s.io/kube-scheduler:v1.27.14",
    "registry.k8s.io/kube-proxy:v1.27.14",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

* v1.27.15

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.27.15",
    "registry.k8s.io/kube-controller-manager:v1.27.15",
    "registry.k8s.io/kube-scheduler:v1.27.15",
    "registry.k8s.io/kube-proxy:v1.27.15",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.12-0",
    "registry.k8s.io/coredns/coredns:v1.10.1"
  ]
}
```

## 3.5（v1.26.x）

* v1.26.0

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.0",
    "registry.k8s.io/kube-controller-manager:v1.26.0",
    "registry.k8s.io/kube-scheduler:v1.26.0",
    "registry.k8s.io/kube-proxy:v1.26.0",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.1

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.1",
    "registry.k8s.io/kube-controller-manager:v1.26.1",
    "registry.k8s.io/kube-scheduler:v1.26.1",
    "registry.k8s.io/kube-proxy:v1.26.1",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.2

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.2",
    "registry.k8s.io/kube-controller-manager:v1.26.2",
    "registry.k8s.io/kube-scheduler:v1.26.2",
    "registry.k8s.io/kube-proxy:v1.26.2",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.3

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.3",
    "registry.k8s.io/kube-controller-manager:v1.26.3",
    "registry.k8s.io/kube-scheduler:v1.26.3",
    "registry.k8s.io/kube-proxy:v1.26.3",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.4

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.4",
    "registry.k8s.io/kube-controller-manager:v1.26.4",
    "registry.k8s.io/kube-scheduler:v1.26.4",
    "registry.k8s.io/kube-proxy:v1.26.4",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.5

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.5",
    "registry.k8s.io/kube-controller-manager:v1.26.5",
    "registry.k8s.io/kube-scheduler:v1.26.5",
    "registry.k8s.io/kube-proxy:v1.26.5",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.6

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.6",
    "registry.k8s.io/kube-controller-manager:v1.26.6",
    "registry.k8s.io/kube-scheduler:v1.26.6",
    "registry.k8s.io/kube-proxy:v1.26.6",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.7

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.7",
    "registry.k8s.io/kube-controller-manager:v1.26.7",
    "registry.k8s.io/kube-scheduler:v1.26.7",
    "registry.k8s.io/kube-proxy:v1.26.7",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.8

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.8",
    "registry.k8s.io/kube-controller-manager:v1.26.8",
    "registry.k8s.io/kube-scheduler:v1.26.8",
    "registry.k8s.io/kube-proxy:v1.26.8",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.9

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.9",
    "registry.k8s.io/kube-controller-manager:v1.26.9",
    "registry.k8s.io/kube-scheduler:v1.26.9",
    "registry.k8s.io/kube-proxy:v1.26.9",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.10

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.10",
    "registry.k8s.io/kube-controller-manager:v1.26.10",
    "registry.k8s.io/kube-scheduler:v1.26.10",
    "registry.k8s.io/kube-proxy:v1.26.10",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.11

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.11",
    "registry.k8s.io/kube-controller-manager:v1.26.11",
    "registry.k8s.io/kube-scheduler:v1.26.11",
    "registry.k8s.io/kube-proxy:v1.26.11",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.12

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.12",
    "registry.k8s.io/kube-controller-manager:v1.26.12",
    "registry.k8s.io/kube-scheduler:v1.26.12",
    "registry.k8s.io/kube-proxy:v1.26.12",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.13

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.13",
    "registry.k8s.io/kube-controller-manager:v1.26.13",
    "registry.k8s.io/kube-scheduler:v1.26.13",
    "registry.k8s.io/kube-proxy:v1.26.13",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.10-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.14

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.14",
    "registry.k8s.io/kube-controller-manager:v1.26.14",
    "registry.k8s.io/kube-scheduler:v1.26.14",
    "registry.k8s.io/kube-proxy:v1.26.14",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.10-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.26.15

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.26.15",
    "registry.k8s.io/kube-controller-manager:v1.26.15",
    "registry.k8s.io/kube-scheduler:v1.26.15",
    "registry.k8s.io/kube-proxy:v1.26.15",
    "registry.k8s.io/pause:3.9",
    "registry.k8s.io/etcd:3.5.10-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

## 3.6（v1.25.x）

* v1.25.0

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.0",
    "registry.k8s.io/kube-controller-manager:v1.25.0",
    "registry.k8s.io/kube-scheduler:v1.25.0",
    "registry.k8s.io/kube-proxy:v1.25.0",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.4-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.1

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.1",
    "registry.k8s.io/kube-controller-manager:v1.25.1",
    "registry.k8s.io/kube-scheduler:v1.25.1",
    "registry.k8s.io/kube-proxy:v1.25.1",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.4-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.2

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.2",
    "registry.k8s.io/kube-controller-manager:v1.25.2",
    "registry.k8s.io/kube-scheduler:v1.25.2",
    "registry.k8s.io/kube-proxy:v1.25.2",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.4-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.3

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.3",
    "registry.k8s.io/kube-controller-manager:v1.25.3",
    "registry.k8s.io/kube-scheduler:v1.25.3",
    "registry.k8s.io/kube-proxy:v1.25.3",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.4-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.4

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.4",
    "registry.k8s.io/kube-controller-manager:v1.25.4",
    "registry.k8s.io/kube-scheduler:v1.25.4",
    "registry.k8s.io/kube-proxy:v1.25.4",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.5-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.5

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.5",
    "registry.k8s.io/kube-controller-manager:v1.25.5",
    "registry.k8s.io/kube-scheduler:v1.25.5",
    "registry.k8s.io/kube-proxy:v1.25.5",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.6

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.6",
    "registry.k8s.io/kube-controller-manager:v1.25.6",
    "registry.k8s.io/kube-scheduler:v1.25.6",
    "registry.k8s.io/kube-proxy:v1.25.6",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.7

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.7",
    "registry.k8s.io/kube-controller-manager:v1.25.7",
    "registry.k8s.io/kube-scheduler:v1.25.7",
    "registry.k8s.io/kube-proxy:v1.25.7",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.8

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.8",
    "registry.k8s.io/kube-controller-manager:v1.25.8",
    "registry.k8s.io/kube-scheduler:v1.25.8",
    "registry.k8s.io/kube-proxy:v1.25.8",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.9

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.9",
    "registry.k8s.io/kube-controller-manager:v1.25.9",
    "registry.k8s.io/kube-scheduler:v1.25.9",
    "registry.k8s.io/kube-proxy:v1.25.9",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.10

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.10",
    "registry.k8s.io/kube-controller-manager:v1.25.10",
    "registry.k8s.io/kube-scheduler:v1.25.10",
    "registry.k8s.io/kube-proxy:v1.25.10",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.11

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.11",
    "registry.k8s.io/kube-controller-manager:v1.25.11",
    "registry.k8s.io/kube-scheduler:v1.25.11",
    "registry.k8s.io/kube-proxy:v1.25.11",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.12

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.12",
    "registry.k8s.io/kube-controller-manager:v1.25.12",
    "registry.k8s.io/kube-scheduler:v1.25.12",
    "registry.k8s.io/kube-proxy:v1.25.12",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.13

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.13",
    "registry.k8s.io/kube-controller-manager:v1.25.13",
    "registry.k8s.io/kube-scheduler:v1.25.13",
    "registry.k8s.io/kube-proxy:v1.25.13",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.14

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.14",
    "registry.k8s.io/kube-controller-manager:v1.25.14",
    "registry.k8s.io/kube-scheduler:v1.25.14",
    "registry.k8s.io/kube-proxy:v1.25.14",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.15

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.15",
    "registry.k8s.io/kube-controller-manager:v1.25.15",
    "registry.k8s.io/kube-scheduler:v1.25.15",
    "registry.k8s.io/kube-proxy:v1.25.15",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

* v1.25.16

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.25.16",
    "registry.k8s.io/kube-controller-manager:v1.25.16",
    "registry.k8s.io/kube-scheduler:v1.25.16",
    "registry.k8s.io/kube-proxy:v1.25.16",
    "registry.k8s.io/pause:3.8",
    "registry.k8s.io/etcd:3.5.9-0",
    "registry.k8s.io/coredns/coredns:v1.9.3"
  ]
}
```

## 3.7（v1.24.x）

* v1.24.0

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.24.0",
    "k8s.gcr.io/kube-controller-manager:v1.24.0",
    "k8s.gcr.io/kube-scheduler:v1.24.0",
    "k8s.gcr.io/kube-proxy:v1.24.0",
    "k8s.gcr.io/pause:3.7",
    "k8s.gcr.io/etcd:3.5.3-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.1

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.24.1",
    "k8s.gcr.io/kube-controller-manager:v1.24.1",
    "k8s.gcr.io/kube-scheduler:v1.24.1",
    "k8s.gcr.io/kube-proxy:v1.24.1",
    "k8s.gcr.io/pause:3.7",
    "k8s.gcr.io/etcd:3.5.3-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.2

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.24.2",
    "k8s.gcr.io/kube-controller-manager:v1.24.2",
    "k8s.gcr.io/kube-scheduler:v1.24.2",
    "k8s.gcr.io/kube-proxy:v1.24.2",
    "k8s.gcr.io/pause:3.7",
    "k8s.gcr.io/etcd:3.5.3-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.3

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.24.3",
    "k8s.gcr.io/kube-controller-manager:v1.24.3",
    "k8s.gcr.io/kube-scheduler:v1.24.3",
    "k8s.gcr.io/kube-proxy:v1.24.3",
    "k8s.gcr.io/pause:3.7",
    "k8s.gcr.io/etcd:3.5.3-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.4

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.24.4",
    "k8s.gcr.io/kube-controller-manager:v1.24.4",
    "k8s.gcr.io/kube-scheduler:v1.24.4",
    "k8s.gcr.io/kube-proxy:v1.24.4",
    "k8s.gcr.io/pause:3.7",
    "k8s.gcr.io/etcd:3.5.3-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.5

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.24.5",
    "k8s.gcr.io/kube-controller-manager:v1.24.5",
    "k8s.gcr.io/kube-scheduler:v1.24.5",
    "k8s.gcr.io/kube-proxy:v1.24.5",
    "k8s.gcr.io/pause:3.7",
    "k8s.gcr.io/etcd:3.5.3-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.6

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.24.6",
    "k8s.gcr.io/kube-controller-manager:v1.24.6",
    "k8s.gcr.io/kube-scheduler:v1.24.6",
    "k8s.gcr.io/kube-proxy:v1.24.6",
    "k8s.gcr.io/pause:3.7",
    "k8s.gcr.io/etcd:3.5.3-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.7

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.24.7",
    "k8s.gcr.io/kube-controller-manager:v1.24.7",
    "k8s.gcr.io/kube-scheduler:v1.24.7",
    "k8s.gcr.io/kube-proxy:v1.24.7",
    "k8s.gcr.io/pause:3.7",
    "k8s.gcr.io/etcd:3.5.3-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.8

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.24.8",
    "k8s.gcr.io/kube-controller-manager:v1.24.8",
    "k8s.gcr.io/kube-scheduler:v1.24.8",
    "k8s.gcr.io/kube-proxy:v1.24.8",
    "k8s.gcr.io/pause:3.7",
    "k8s.gcr.io/etcd:3.5.5-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.9

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.24.9",
    "registry.k8s.io/kube-controller-manager:v1.24.9",
    "registry.k8s.io/kube-scheduler:v1.24.9",
    "registry.k8s.io/kube-proxy:v1.24.9",
    "registry.k8s.io/pause:3.7",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.10

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.24.10",
    "registry.k8s.io/kube-controller-manager:v1.24.10",
    "registry.k8s.io/kube-scheduler:v1.24.10",
    "registry.k8s.io/kube-proxy:v1.24.10",
    "registry.k8s.io/pause:3.7",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.11

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.24.11",
    "registry.k8s.io/kube-controller-manager:v1.24.11",
    "registry.k8s.io/kube-scheduler:v1.24.11",
    "registry.k8s.io/kube-proxy:v1.24.11",
    "registry.k8s.io/pause:3.7",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.12

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.24.12",
    "registry.k8s.io/kube-controller-manager:v1.24.12",
    "registry.k8s.io/kube-scheduler:v1.24.12",
    "registry.k8s.io/kube-proxy:v1.24.12",
    "registry.k8s.io/pause:3.7",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.13

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.24.13",
    "registry.k8s.io/kube-controller-manager:v1.24.13",
    "registry.k8s.io/kube-scheduler:v1.24.13",
    "registry.k8s.io/kube-proxy:v1.24.13",
    "registry.k8s.io/pause:3.7",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.14

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.24.14",
    "registry.k8s.io/kube-controller-manager:v1.24.14",
    "registry.k8s.io/kube-scheduler:v1.24.14",
    "registry.k8s.io/kube-proxy:v1.24.14",
    "registry.k8s.io/pause:3.7",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.15

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.24.15",
    "registry.k8s.io/kube-controller-manager:v1.24.15",
    "registry.k8s.io/kube-scheduler:v1.24.15",
    "registry.k8s.io/kube-proxy:v1.24.15",
    "registry.k8s.io/pause:3.7",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.16

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.24.16",
    "registry.k8s.io/kube-controller-manager:v1.24.16",
    "registry.k8s.io/kube-scheduler:v1.24.16",
    "registry.k8s.io/kube-proxy:v1.24.16",
    "registry.k8s.io/pause:3.7",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.24.17

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.24.17",
    "registry.k8s.io/kube-controller-manager:v1.24.17",
    "registry.k8s.io/kube-scheduler:v1.24.17",
    "registry.k8s.io/kube-proxy:v1.24.17",
    "registry.k8s.io/pause:3.7",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}

```

## 3.8（v1.23.x）

* v1.23.0

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.0",
    "k8s.gcr.io/kube-controller-manager:v1.23.0",
    "k8s.gcr.io/kube-scheduler:v1.23.0",
    "k8s.gcr.io/kube-proxy:v1.23.0",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.1

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.1",
    "k8s.gcr.io/kube-controller-manager:v1.23.1",
    "k8s.gcr.io/kube-scheduler:v1.23.1",
    "k8s.gcr.io/kube-proxy:v1.23.1",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.2

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.2",
    "k8s.gcr.io/kube-controller-manager:v1.23.2",
    "k8s.gcr.io/kube-scheduler:v1.23.2",
    "k8s.gcr.io/kube-proxy:v1.23.2",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.3

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.3",
    "k8s.gcr.io/kube-controller-manager:v1.23.3",
    "k8s.gcr.io/kube-scheduler:v1.23.3",
    "k8s.gcr.io/kube-proxy:v1.23.3",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.4

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.4",
    "k8s.gcr.io/kube-controller-manager:v1.23.4",
    "k8s.gcr.io/kube-scheduler:v1.23.4",
    "k8s.gcr.io/kube-proxy:v1.23.4",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.5

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.5",
    "k8s.gcr.io/kube-controller-manager:v1.23.5",
    "k8s.gcr.io/kube-scheduler:v1.23.5",
    "k8s.gcr.io/kube-proxy:v1.23.5",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.6

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.6",
    "k8s.gcr.io/kube-controller-manager:v1.23.6",
    "k8s.gcr.io/kube-scheduler:v1.23.6",
    "k8s.gcr.io/kube-proxy:v1.23.6",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.7

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.7",
    "k8s.gcr.io/kube-controller-manager:v1.23.7",
    "k8s.gcr.io/kube-scheduler:v1.23.7",
    "k8s.gcr.io/kube-proxy:v1.23.7",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.8

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.8",
    "k8s.gcr.io/kube-controller-manager:v1.23.8",
    "k8s.gcr.io/kube-scheduler:v1.23.8",
    "k8s.gcr.io/kube-proxy:v1.23.8",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.9

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.9",
    "k8s.gcr.io/kube-controller-manager:v1.23.9",
    "k8s.gcr.io/kube-scheduler:v1.23.9",
    "k8s.gcr.io/kube-proxy:v1.23.9",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.10

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.10",
    "k8s.gcr.io/kube-controller-manager:v1.23.10",
    "k8s.gcr.io/kube-scheduler:v1.23.10",
    "k8s.gcr.io/kube-proxy:v1.23.10",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.11

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.11",
    "k8s.gcr.io/kube-controller-manager:v1.23.11",
    "k8s.gcr.io/kube-scheduler:v1.23.11",
    "k8s.gcr.io/kube-proxy:v1.23.11",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.12

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.12",
    "k8s.gcr.io/kube-controller-manager:v1.23.12",
    "k8s.gcr.io/kube-scheduler:v1.23.12",
    "k8s.gcr.io/kube-proxy:v1.23.12",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/c
```

* v1.23.13

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.13",
    "k8s.gcr.io/kube-controller-manager:v1.23.13",
    "k8s.gcr.io/kube-scheduler:v1.23.13",
    "k8s.gcr.io/kube-proxy:v1.23.13",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.1-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.14

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.23.14",
    "k8s.gcr.io/kube-controller-manager:v1.23.14",
    "k8s.gcr.io/kube-scheduler:v1.23.14",
    "k8s.gcr.io/kube-proxy:v1.23.14",
    "k8s.gcr.io/pause:3.6",
    "k8s.gcr.io/etcd:3.5.5-0",
    "k8s.gcr.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.15

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.23.15",
    "registry.k8s.io/kube-controller-manager:v1.23.15",
    "registry.k8s.io/kube-scheduler:v1.23.15",
    "registry.k8s.io/kube-proxy:v1.23.15",
    "registry.k8s.io/pause:3.6",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.16

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.23.16",
    "registry.k8s.io/kube-controller-manager:v1.23.16",
    "registry.k8s.io/kube-scheduler:v1.23.16",
    "registry.k8s.io/kube-proxy:v1.23.16",
    "registry.k8s.io/pause:3.6",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}
```

* v1.23.17

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.23.17",
    "registry.k8s.io/kube-controller-manager:v1.23.17",
    "registry.k8s.io/kube-scheduler:v1.23.17",
    "registry.k8s.io/kube-proxy:v1.23.17",
    "registry.k8s.io/pause:3.6",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.6"
  ]
}
```

## 3.9（v1.22.x）

* v1.22.0

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.0",
    "k8s.gcr.io/kube-controller-manager:v1.22.0",
    "k8s.gcr.io/kube-scheduler:v1.22.0",
    "k8s.gcr.io/kube-proxy:v1.22.0",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.1

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.1",
    "k8s.gcr.io/kube-controller-manager:v1.22.1",
    "k8s.gcr.io/kube-scheduler:v1.22.1",
    "k8s.gcr.io/kube-proxy:v1.22.1",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.2

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.2",
    "k8s.gcr.io/kube-controller-manager:v1.22.2",
    "k8s.gcr.io/kube-scheduler:v1.22.2",
    "k8s.gcr.io/kube-proxy:v1.22.2",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.3

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.3",
    "k8s.gcr.io/kube-controller-manager:v1.22.3",
    "k8s.gcr.io/kube-scheduler:v1.22.3",
    "k8s.gcr.io/kube-proxy:v1.22.3",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.4

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.4",
    "k8s.gcr.io/kube-controller-manager:v1.22.4",
    "k8s.gcr.io/kube-scheduler:v1.22.4",
    "k8s.gcr.io/kube-proxy:v1.22.4",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.5

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.5",
    "k8s.gcr.io/kube-controller-manager:v1.22.5",
    "k8s.gcr.io/kube-scheduler:v1.22.5",
    "k8s.gcr.io/kube-proxy:v1.22.5",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.6

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.6",
    "k8s.gcr.io/kube-controller-manager:v1.22.6",
    "k8s.gcr.io/kube-scheduler:v1.22.6",
    "k8s.gcr.io/kube-proxy:v1.22.6",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.7

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.7",
    "k8s.gcr.io/kube-controller-manager:v1.22.7",
    "k8s.gcr.io/kube-scheduler:v1.22.7",
    "k8s.gcr.io/kube-proxy:v1.22.7",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.8

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.8",
    "k8s.gcr.io/kube-controller-manager:v1.22.8",
    "k8s.gcr.io/kube-scheduler:v1.22.8",
    "k8s.gcr.io/kube-proxy:v1.22.8",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.9

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.9",
    "k8s.gcr.io/kube-controller-manager:v1.22.9",
    "k8s.gcr.io/kube-scheduler:v1.22.9",
    "k8s.gcr.io/kube-proxy:v1.22.9",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.10

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.10",
    "k8s.gcr.io/kube-controller-manager:v1.22.10",
    "k8s.gcr.io/kube-scheduler:v1.22.10",
    "k8s.gcr.io/kube-proxy:v1.22.10",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.11

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.11",
    "k8s.gcr.io/kube-controller-manager:v1.22.11",
    "k8s.gcr.io/kube-scheduler:v1.22.11",
    "k8s.gcr.io/kube-proxy:v1.22.11",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.12

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.12",
    "k8s.gcr.io/kube-controller-manager:v1.22.12",
    "k8s.gcr.io/kube-scheduler:v1.22.12",
    "k8s.gcr.io/kube-proxy:v1.22.12",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.13

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.13",
    "k8s.gcr.io/kube-controller-manager:v1.22.13",
    "k8s.gcr.io/kube-scheduler:v1.22.13",
    "k8s.gcr.io/kube-proxy:v1.22.13",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.14

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.14",
    "k8s.gcr.io/kube-controller-manager:v1.22.14",
    "k8s.gcr.io/kube-scheduler:v1.22.14",
    "k8s.gcr.io/kube-proxy:v1.22.14",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.15

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.15",
    "k8s.gcr.io/kube-controller-manager:v1.22.15",
    "k8s.gcr.io/kube-scheduler:v1.22.15",
    "k8s.gcr.io/kube-proxy:v1.22.15",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.16

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.22.16",
    "k8s.gcr.io/kube-controller-manager:v1.22.16",
    "k8s.gcr.io/kube-scheduler:v1.22.16",
    "k8s.gcr.io/kube-proxy:v1.22.16",
    "k8s.gcr.io/pause:3.5",
    "k8s.gcr.io/etcd:3.5.0-0",
    "k8s.gcr.io/coredns/coredns:v1.8.4"
  ]
}
```

* v1.22.17

```json
{
  "hub-mirrors": [
    "registry.k8s.io/kube-apiserver:v1.22.17",
    "registry.k8s.io/kube-controller-manager:v1.22.17",
    "registry.k8s.io/kube-scheduler:v1.22.17",
    "registry.k8s.io/kube-proxy:v1.22.17",
    "registry.k8s.io/pause:3.5",
    "registry.k8s.io/etcd:3.5.6-0",
    "registry.k8s.io/coredns/coredns:v1.8.4"
  ]
}
```

## 3.10（v1.21.x）

* v1.21.0

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.0",
    "k8s.gcr.io/kube-controller-manager:v1.21.0",
    "k8s.gcr.io/kube-scheduler:v1.21.0",
    "k8s.gcr.io/kube-proxy:v1.21.0",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.1

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.1",
    "k8s.gcr.io/kube-controller-manager:v1.21.1",
    "k8s.gcr.io/kube-scheduler:v1.21.1",
    "k8s.gcr.io/kube-proxy:v1.21.1",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.2

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.2",
    "k8s.gcr.io/kube-controller-manager:v1.21.2",
    "k8s.gcr.io/kube-scheduler:v1.21.2",
    "k8s.gcr.io/kube-proxy:v1.21.2",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.3

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.3",
    "k8s.gcr.io/kube-controller-manager:v1.21.3",
    "k8s.gcr.io/kube-scheduler:v1.21.3",
    "k8s.gcr.io/kube-proxy:v1.21.3",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.4

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.4",
    "k8s.gcr.io/kube-controller-manager:v1.21.4",
    "k8s.gcr.io/kube-scheduler:v1.21.4",
    "k8s.gcr.io/kube-proxy:v1.21.4",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.5

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.5",
    "k8s.gcr.io/kube-controller-manager:v1.21.5",
    "k8s.gcr.io/kube-scheduler:v1.21.5",
    "k8s.gcr.io/kube-proxy:v1.21.5",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.6

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.6",
    "k8s.gcr.io/kube-controller-manager:v1.21.6",
    "k8s.gcr.io/kube-scheduler:v1.21.6",
    "k8s.gcr.io/kube-proxy:v1.21.6",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.7

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.7",
    "k8s.gcr.io/kube-controller-manager:v1.21.7",
    "k8s.gcr.io/kube-scheduler:v1.21.7",
    "k8s.gcr.io/kube-proxy:v1.21.7",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.8

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.8",
    "k8s.gcr.io/kube-controller-manager:v1.21.8",
    "k8s.gcr.io/kube-scheduler:v1.21.8",
    "k8s.gcr.io/kube-proxy:v1.21.8",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.9

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.9",
    "k8s.gcr.io/kube-controller-manager:v1.21.9",
    "k8s.gcr.io/kube-scheduler:v1.21.9",
    "k8s.gcr.io/kube-proxy:v1.21.9",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.10

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.10",
    "k8s.gcr.io/kube-controller-manager:v1.21.10",
    "k8s.gcr.io/kube-scheduler:v1.21.10",
    "k8s.gcr.io/kube-proxy:v1.21.10",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.11

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.11",
    "k8s.gcr.io/kube-controller-manager:v1.21.11",
    "k8s.gcr.io/kube-scheduler:v1.21.11",
    "k8s.gcr.io/kube-proxy:v1.21.11",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.12

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.12",
    "k8s.gcr.io/kube-controller-manager:v1.21.12",
    "k8s.gcr.io/kube-scheduler:v1.21.12",
    "k8s.gcr.io/kube-proxy:v1.21.12",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.13

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.13",
    "k8s.gcr.io/kube-controller-manager:v1.21.13",
    "k8s.gcr.io/kube-scheduler:v1.21.13",
    "k8s.gcr.io/kube-proxy:v1.21.13",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

* v1.21.14

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.21.14",
    "k8s.gcr.io/kube-controller-manager:v1.21.14",
    "k8s.gcr.io/kube-scheduler:v1.21.14",
    "k8s.gcr.io/kube-proxy:v1.21.14",
    "k8s.gcr.io/pause:3.4.1",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns/coredns:v1.8.0"
  ]
}
```

## 3.11（v1.20.x）

* v1.20.0

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.0",
    "k8s.gcr.io/kube-controller-manager:v1.20.0",
    "k8s.gcr.io/kube-scheduler:v1.20.0",
    "k8s.gcr.io/kube-proxy:v1.20.0",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.1

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.1",
    "k8s.gcr.io/kube-controller-manager:v1.20.1",
    "k8s.gcr.io/kube-scheduler:v1.20.1",
    "k8s.gcr.io/kube-proxy:v1.20.1",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.2

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.2",
    "k8s.gcr.io/kube-controller-manager:v1.20.2",
    "k8s.gcr.io/kube-scheduler:v1.20.2",
    "k8s.gcr.io/kube-proxy:v1.20.2",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.3

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.3",
    "k8s.gcr.io/kube-controller-manager:v1.20.3",
    "k8s.gcr.io/kube-scheduler:v1.20.3",
    "k8s.gcr.io/kube-proxy:v1.20.3",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.4

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.4",
    "k8s.gcr.io/kube-controller-manager:v1.20.4",
    "k8s.gcr.io/kube-scheduler:v1.20.4",
    "k8s.gcr.io/kube-proxy:v1.20.4",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.5

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.5",
    "k8s.gcr.io/kube-controller-manager:v1.20.5",
    "k8s.gcr.io/kube-scheduler:v1.20.5",
    "k8s.gcr.io/kube-proxy:v1.20.5",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.6

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.6",
    "k8s.gcr.io/kube-controller-manager:v1.20.6",
    "k8s.gcr.io/kube-scheduler:v1.20.6",
    "k8s.gcr.io/kube-proxy:v1.20.6",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.7

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.7",
    "k8s.gcr.io/kube-controller-manager:v1.20.7",
    "k8s.gcr.io/kube-scheduler:v1.20.7",
    "k8s.gcr.io/kube-proxy:v1.20.7",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.8

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.8",
    "k8s.gcr.io/kube-controller-manager:v1.20.8",
    "k8s.gcr.io/kube-scheduler:v1.20.8",
    "k8s.gcr.io/kube-proxy:v1.20.8",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.9

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.9",
    "k8s.gcr.io/kube-controller-manager:v1.20.9",
    "k8s.gcr.io/kube-scheduler:v1.20.9",
    "k8s.gcr.io/kube-proxy:v1.20.9",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.10

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.10",
    "k8s.gcr.io/kube-controller-manager:v1.20.10",
    "k8s.gcr.io/kube-scheduler:v1.20.10",
    "k8s.gcr.io/kube-proxy:v1.20.10",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.11

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.11",
    "k8s.gcr.io/kube-controller-manager:v1.20.11",
    "k8s.gcr.io/kube-scheduler:v1.20.11",
    "k8s.gcr.io/kube-proxy:v1.20.11",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.12

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.12",
    "k8s.gcr.io/kube-controller-manager:v1.20.12",
    "k8s.gcr.io/kube-scheduler:v1.20.12",
    "k8s.gcr.io/kube-proxy:v1.20.12",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.13

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.13",
    "k8s.gcr.io/kube-controller-manager:v1.20.13",
    "k8s.gcr.io/kube-scheduler:v1.20.13",
    "k8s.gcr.io/kube-proxy:v1.20.13",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.14

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.14",
    "k8s.gcr.io/kube-controller-manager:v1.20.14",
    "k8s.gcr.io/kube-scheduler:v1.20.14",
    "k8s.gcr.io/kube-proxy:v1.20.14",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.20.15

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.20.15",
    "k8s.gcr.io/kube-controller-manager:v1.20.15",
    "k8s.gcr.io/kube-scheduler:v1.20.15",
    "k8s.gcr.io/kube-proxy:v1.20.15",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

## 3.12（v1.19.x）

* v1.19.0

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.0",
    "k8s.gcr.io/kube-controller-manager:v1.19.0",
    "k8s.gcr.io/kube-scheduler:v1.19.0",
    "k8s.gcr.io/kube-proxy:v1.19.0",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.9-1",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.1

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.1",
    "k8s.gcr.io/kube-controller-manager:v1.19.1",
    "k8s.gcr.io/kube-scheduler:v1.19.1",
    "k8s.gcr.io/kube-proxy:v1.19.1",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.2

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.2",
    "k8s.gcr.io/kube-controller-manager:v1.19.2",
    "k8s.gcr.io/kube-scheduler:v1.19.2",
    "k8s.gcr.io/kube-proxy:v1.19.2",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.3

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.3",
    "k8s.gcr.io/kube-controller-manager:v1.19.3",
    "k8s.gcr.io/kube-scheduler:v1.19.3",
    "k8s.gcr.io/kube-proxy:v1.19.3",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.4

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.4",
    "k8s.gcr.io/kube-controller-manager:v1.19.4",
    "k8s.gcr.io/kube-scheduler:v1.19.4",
    "k8s.gcr.io/kube-proxy:v1.19.4",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.5

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.5",
    "k8s.gcr.io/kube-controller-manager:v1.19.5",
    "k8s.gcr.io/kube-scheduler:v1.19.5",
    "k8s.gcr.io/kube-proxy:v1.19.5",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.6

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.6",
    "k8s.gcr.io/kube-controller-manager:v1.19.6",
    "k8s.gcr.io/kube-scheduler:v1.19.6",
    "k8s.gcr.io/kube-proxy:v1.19.6",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.7

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.7",
    "k8s.gcr.io/kube-controller-manager:v1.19.7",
    "k8s.gcr.io/kube-scheduler:v1.19.7",
    "k8s.gcr.io/kube-proxy:v1.19.7",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.8

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.8",
    "k8s.gcr.io/kube-controller-manager:v1.19.8",
    "k8s.gcr.io/kube-scheduler:v1.19.8",
    "k8s.gcr.io/kube-proxy:v1.19.8",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.9

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.9",
    "k8s.gcr.io/kube-controller-manager:v1.19.9",
    "k8s.gcr.io/kube-scheduler:v1.19.9",
    "k8s.gcr.io/kube-proxy:v1.19.9",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.10

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.10",
    "k8s.gcr.io/kube-controller-manager:v1.19.10",
    "k8s.gcr.io/kube-scheduler:v1.19.10",
    "k8s.gcr.io/kube-proxy:v1.19.10",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.11

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.11",
    "k8s.gcr.io/kube-controller-manager:v1.19.11",
    "k8s.gcr.io/kube-scheduler:v1.19.11",
    "k8s.gcr.io/kube-proxy:v1.19.11",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.12

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.12",
    "k8s.gcr.io/kube-controller-manager:v1.19.12",
    "k8s.gcr.io/kube-scheduler:v1.19.12",
    "k8s.gcr.io/kube-proxy:v1.19.12",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.13

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.13",
    "k8s.gcr.io/kube-controller-manager:v1.19.13",
    "k8s.gcr.io/kube-scheduler:v1.19.13",
    "k8s.gcr.io/kube-proxy:v1.19.13",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.14

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.14",
    "k8s.gcr.io/kube-controller-manager:v1.19.14",
    "k8s.gcr.io/kube-scheduler:v1.19.14",
    "k8s.gcr.io/kube-proxy:v1.19.14",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.15

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.15",
    "k8s.gcr.io/kube-controller-manager:v1.19.15",
    "k8s.gcr.io/kube-scheduler:v1.19.15",
    "k8s.gcr.io/kube-proxy:v1.19.15",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

* v1.19.16

```json
{
  "hub-mirrors": [
    "k8s.gcr.io/kube-apiserver:v1.19.16",
    "k8s.gcr.io/kube-controller-manager:v1.19.16",
    "k8s.gcr.io/kube-scheduler:v1.19.16",
    "k8s.gcr.io/kube-proxy:v1.19.16",
    "k8s.gcr.io/pause:3.2",
    "k8s.gcr.io/etcd:3.4.13-0",
    "k8s.gcr.io/coredns:1.7.0"
  ]
}
```

