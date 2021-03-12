package com.ben.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private Integer id;
    private String nickname;
    private String password;
}
