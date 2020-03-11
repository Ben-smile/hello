package service;

import dao.AtmDao;
import domain.Atm;
import util.MySpring;

public class AtmService {


    //Service层 用来处理逻辑
    private AtmDao dao = MySpring.getBean("dao.AtmDao");

    //设计一个登录方法
    public String login(String aname,String apassword){
        Atm atm = dao.selectOne(aname);
        if(atm!=null && atm.getApassword().equals(apassword)){
            return "登录成功";//登录 登陆
        }
        return "用户名或密码错误";
    }

    //设计一个查询余额方法
    public Float inquire(String aname){
        return dao.selectOne(aname).getAbalance();
    }

    //设计一个注册新用户的方法
    public int regist(String aname,String apassword,Float abalance){
        Atm atm = new Atm(aname,apassword,abalance);
        return dao.insert(atm);
    }

    //设计一个方法 判断账号名是否存在
    public boolean isExist(String aname){
        if(dao.selectOne(aname)!=null){
            return true;//当前账号存在
        }
        return false;//账号不存在
    }

    //设计一个方法 存款
    public int deposit(String aname,Float depositMoney){
        Atm atm = dao.selectOne(aname);
        atm.setAbalance(atm.getAbalance()+depositMoney);
        return dao.update(atm);
    }

    //设计一个方法 取款
    public int withdrawal(String aname,Float withdrawalMoney){
        Atm atm = dao.selectOne(aname);
        if(atm.getAbalance()>=withdrawalMoney){
            atm.setAbalance(atm.getAbalance()-withdrawalMoney);
            return dao.update(atm);//1成功  0没有成功
        }else{
            return -1;//余额不足
        }
    }

    //设计一个方法 转账
    public int transfer(String outName,String inName,Float transferMoney){
        Atm outAtm = dao.selectOne(outName);
        Atm inAtm = dao.selectOne(inName);
        if(outAtm.getAbalance()>=transferMoney){
            outAtm.setAbalance(outAtm.getAbalance() - transferMoney);
            inAtm.setAbalance(inAtm.getAbalance() + transferMoney);
            return dao.update(outAtm) + dao.update(inAtm);//2成功
        }else{
            return -1;//余额不足
        }
    }

    //设计一个方法 销户
    public int closeAccount(String aname){
        return dao.delete(aname);
    }


}
