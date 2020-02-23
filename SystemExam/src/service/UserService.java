package service;

import dao.UserDao;
import domain.User;
import util.MySpring;

public class UserService {
    private UserDao dao = (UserDao)MySpring.getBean("dao.UserDao");
    //设计一个方法---负责登录
    public String login(String account,String password){

        User message = dao.selectOne(account);
        if (message != null && message.getPassword().equals(password)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }
}

