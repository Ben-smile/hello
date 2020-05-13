package service;

import dao.AtmDao;
import domain.Atm;
import util.MySpring;

public class AtmService {

    //业务层   负责数据的处理    比较 判断 计算 等等一些逻辑

    private AtmDao dao = MySpring.getBean("dao.AtmDao");

    public String login(String aname,String apassword){
        //查询数据库中真实的账号和密码
        Atm atm = dao.selectOne(aname);
        //做比对
        if(atm!=null && atm.getApassword().equals(apassword)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }

    public Float query(String aname){
        return dao.selectOne(aname).getAbalance();
    }
}
