package com.github.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShellCommandResult {
    // 命令执行状态，0 表示成功，1 表示失败
    private int exitCode;
    // 命令执行输出
    private String output;
    // 命令执行错误
    private String error;
}
