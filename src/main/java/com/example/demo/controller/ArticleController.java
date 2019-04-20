package com.example.demo.controller;

import com.auth0.jwt.interfaces.Claim;
import com.example.demo.Service.SService;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.util.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class ArticleController {

    @Autowired
    private SService service;

    private static final Logger _logger = LoggerFactory.getLogger(ArticleController.class);

    //ctrl+alt+shift+/ 进入Register 配置
    @GetMapping("/ccg/getValues/{id}")
    public List<String> get(@PathVariable int id) throws Exception{
        List<String> list = new ArrayList<>();

        System.out.println(id);

        list.add("ids");
        list.add("name");
        list.add("age");

        return list;

    }

//    @GetMapping("/ccg/getValues") 需修改
    @GetMapping("/article/get/{id}")
    public List<ItemEntity> getValues(@PathVariable int id) throws Exception{
        List<ItemEntity> entityList =service.getValues();

        System.out.println(id);

        return entityList;

    }

    @GetMapping("/article/get")
    public List<ItemEntity> getValue() throws Exception{
        List<ItemEntity> entityList =service.getValue();

        System.out.println(entityList.size());

       // Map<String,Claim> map = JWTUtils.verifyToken(token);

        //System.out.println(map);

        return entityList;
    }
}