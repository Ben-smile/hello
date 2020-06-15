package service;

import dao.UserDao;
import domain.User;
import util.MySpring;

public class UserService {

    private UserDao dao = MySpring.getBean("dao.UserDao");

    //登录判断的业务
    public String login(String uname,String upassword){
        //查询真实的数据
        User user = dao.selectOne(uname);
        if(user!=null && user.getUpassword().equals(upassword)){
            return "登录成功";
        }
        return "账号或密码错误";
    }
}
