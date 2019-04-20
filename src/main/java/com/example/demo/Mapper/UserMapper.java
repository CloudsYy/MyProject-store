package com.example.demo.Mapper;


import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE username=#{username} AND password=#{password}")
    public List<UserEntity> queryUser(@Param("username") String username, @Param("password") String password) throws Exception;
}
