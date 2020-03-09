package service;

import dao.AreaDao;

import java.util.ArrayList;
import java.util.HashMap;

public class AreaService {
    private AreaDao dao = new AreaDao();

    // 1.
    public ArrayList<String> select1(int begin,int end){
        return dao.selectNum1(begin,end);
    }

    //3.
    public ArrayList<HashMap<String,String>> select3(){
        return dao.selectNum3();
    }
}
