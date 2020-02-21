package service;

public class UserService {

    //设计一个方法---负责登录
    public String login(String account,String password){
        if(account.equals("zhangsan")&&password.equals("333")){
            return "登录成功";
        }
        return "用户名或密码错误";
    }
}
