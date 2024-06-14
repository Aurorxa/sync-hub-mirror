package com.github.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cloud {
    private String username;
    private String password;
    private String registry;
    private String namespace;
}
