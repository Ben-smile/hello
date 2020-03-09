package test;

import dao.CountryDao;
import domain.Atm;
import domain.Country;
import domain.Emp;
import service.AreaService;
import service.CountryService;
import service.EmpService;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args){
        AreaService  as = new AreaService();
        CountryService cs = new CountryService();
        //3.
        ArrayList<HashMap<String,String>> list = as.select3();
        for(HashMap<String,String> map :list){
           System.out.println(map.get("aname")+"-"+map.get("avgcitysize"));
       }


        //2.

//        ArrayList<HashMap<String,String>> list = cs.select2();
//        for(HashMap<String,String> map :list){
//            System.out.println(map.get("cname")+"-"+map.get("citycount"));
//        }



        //1.

//        ArrayList<String> list = as.select1(1000,2000);
//        for (String str:list){
//            System.out.println(str);
//        }




        //分页查询
//       EmpService tl = new EmpService();
//       ArrayList<Emp> list = tl.getRowIndex(2);
//       for (Emp e : list){
//           System.out.println(e);
//       }




    }




}
