package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ItemEntity {
    private Integer id;
    private String name;
    private float price;
    private String detail;
    private String pic;
    private Date createtime;

}
