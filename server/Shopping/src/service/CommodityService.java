package service;

import dao.CommodityDao;
import domain.Commodity;
import util.MySpring;

import java.util.ArrayList;

public class CommodityService {

    private CommodityDao dao = MySpring.getBean("dao.CommodityDao");

    //设计一个方法 根据种类编号kid 查询对应的所有具体商品
    public ArrayList<Commodity> selectCommodityById(int kid){
        return dao.selectCommodityByKid(kid);
    }
}
