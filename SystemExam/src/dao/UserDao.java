package dao;

import domain.User;
import util.UserFileReader;

public class UserDao {


     //只用来读写数据
     //负责查询一个人的信息
    public User selectOne (String account){

        return UserFileReader.getUser(account);
    }
}
