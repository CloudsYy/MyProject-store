package com.example.demo.entity;

import lombok.Data;
import java.util.List;

@Data
public class ManagerEntity {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private List<UserEntity> roles;

}
