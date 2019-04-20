package com.example.demo.controller;

import com.example.demo.Service.UService;
import com.example.demo.entity.UserEntity;
import com.example.demo.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
* token 步骤
一、首先写一个token的实体类，存数据库，设置属性
二、写controller等验证用户名是否存在
三、若二成立则服务端生成一个token，传给客户端，并存在本地，
四、次token放着uuid，秘钥，即为header，payload，签名(sign)
五、验证token到服务器，然后检验成功，则返回数据，页面数据显示
六、如果验证不成功，则返回401，返回错误页面
七、生成token后在存到客户端之后，实现单点登录，刷新的时候，携带链接+ 签名验证，
验证成功，返回数据，验证失败，返回401错误码，显示错误信息页面*/

@RestController
public class TController {

    @Autowired
    private UService uService;

    private String token;

    @GetMapping("/user/login/{username},{password}")
    public Map validUser(@PathVariable String username, @PathVariable String password) throws Exception{
        List<UserEntity> List = uService.queryUser(username,password);

        if (List.size()==0){
            System.out.println(0);
            return null;
        }

        token = JWTUtils.createToken();

        Map<String, Object> map = new HashMap<>();

        map.put("token",token);
        map.put("List",List);
        //map.put("UserList",UserList);

        System.out.println(List.size());

        return map;
    }
}
