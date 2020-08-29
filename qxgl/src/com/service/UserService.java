package com.service;

import com.dao.UserDao;
import com.domain.User;
import orm.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private UserDao dao= new SqlSession().getMapper(UserDao.class);

    public User checkLogin(String uname, String upass){
        Map<String,String> map = new HashMap<>();
        map.put("uname",uname);
        map.put("upass",upass);
        User user = dao.findUserByNameAndPass(map);
        return user;

        
    }

}
