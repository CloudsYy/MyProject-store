package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private String password;

}
