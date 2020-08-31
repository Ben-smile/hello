package com.dao;

import com.domain.User;
import orm.annotation.Delete;
import orm.annotation.Insert;
import orm.annotation.Select;

import java.util.List;
import java.util.Map;

public interface UserDao {


    //定义方法

    /**
     *  //通过名字密码查询单条
     * @param params
     * @return
     */
    @Select("select * from t_user where uname=#{uname} and upass=#{upass}")
    User findUserByNameAndPass(Map<String,String> params);

    /*
    全表通查
     */
    @Select("select * from t_user")
    List<User> findAllUsers();

    @Insert("insert into t_user (uname,upass,truename,age,sex,phone) values(#{uname},#{upass},#{truename},#{age},#{sex},#{phone})")
    void addUser(User user);

    //删除一个用户
    @Delete("delete from t_user where uno=#{uno}")
    void deleteUser(Integer uno);
}
