package com.example.demo.Service.sImp;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UService;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserImp implements UService{

    @Autowired
    private UserMapper userMapper;

    public List<UserEntity> queryUser(String username, String password) throws Exception {
        List<UserEntity> list = userMapper.queryUser(username,password);

        return list;
    }
}
