package com.lzugis.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String realName;
    private  String mobile;
    private String email;
}
