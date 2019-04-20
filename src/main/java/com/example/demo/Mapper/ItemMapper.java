package com.example.demo.Mapper;

import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ItemMapper {

    @Select("select * from items")
    public List<ItemEntity> getValues()throws Exception;

    @Select("select * from items")
    public List<ItemEntity> getValue()throws Exception;
}
