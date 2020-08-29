package com.dao;

import com.domain.User;
import orm.annotation.Select;

import java.util.Map;

public interface UserDao {


    //定义方法

    /**
     *
     * @param params
     * @return
     */
    @Select("select * from t_user where uname=#{uname} and upass=#{upass}")
    User findUserByNameAndPass(Map<String,String> params);
}
