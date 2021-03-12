package com.ben.dao;

import com.ben.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    User findById(Integer id);
}