package com.service;

import com.dao.UserDao;
import com.domain.User;
import orm.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    //service 单例
    private UserService (){}
    private static UserService service= new UserService();
    public static UserService getInstance(){
        return service;
    }



    private UserDao dao= new SqlSession().getMapper(UserDao.class);

    //登录
    public User checkLogin(String uname, String upass){
        Map<String,String> map = new HashMap<>();
        map.put("uname",uname);
        map.put("upass",upass);
        User user = dao.findUserByNameAndPass(map);
        return user;
    }


    //查询所有的用户
    public List<User> selectAllUser(){
        List<User> users = dao.findAllUsers();
        return users;
    }

    //新增一条信息
    public void addUser(User user){
        dao.addUser(user);
    }

    //删除一个用户
    public void deleteUser(Integer uno){
        dao.deleteUser(uno);
    }

    //查询一条记录
    public User selectUser(Integer uno){
        User result = dao.selectUser(uno);

        return result;
    }

    //修改一条信息
    public void updateUser(User user){
        dao.updateUser(user);
    }
}
