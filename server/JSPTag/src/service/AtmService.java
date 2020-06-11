package service;

import domain.Atm;

public class AtmService {

    //dao

    public void insert(Atm atm){
        //dao.insert(atm);
        System.out.println("atm对象接收到啦,下面就可以做dao操作啦");
        System.out.println(atm);
    }
}
