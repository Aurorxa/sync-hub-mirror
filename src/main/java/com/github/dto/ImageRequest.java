package com.github.dto;

import lombok.Data;

import java.util.List;

@Data
public class ImageRequest {
    // 镜像的名称，如：nginx:1.18.0
    private List<String> images;
}
