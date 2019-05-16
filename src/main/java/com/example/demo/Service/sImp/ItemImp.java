package com.example.demo.Service.sImp;

import com.example.demo.Mapper.ItemMapper;
import com.example.demo.Service.SService;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemImp implements SService{

    @Autowired
    private ItemMapper itemMapper;

    public List<ItemEntity> getValues() throws Exception {

        List<ItemEntity> list=itemMapper.getValues();

        return list;
    }

    public List<ItemEntity> getValue() throws Exception {

        List<ItemEntity> list=itemMapper.getValue();

        return list;
    }
}
