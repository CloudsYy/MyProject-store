package com.example.demo.Service;

import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UService {

    public List<UserEntity> queryUser(String username, String password)throws Exception;
}