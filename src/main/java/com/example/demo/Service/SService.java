package com.example.demo.Service;

import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SService {

    public List<ItemEntity> getValues()throws Exception;

    public List<ItemEntity> getValue()throws Exception;
}