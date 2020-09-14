package com.service;

import com.dao.MenuDao;
import com.domain.Menu;
import orm.SqlSession;

import java.util.List;

public class MenuService {

    MenuDao dao = new SqlSession().getMapper(MenuDao.class);


    public List<Menu> selectAllMenu(){
        return dao.selectAllMenu();
    }

    //新建一个菜单
    public int addMenu(Menu menu){
        dao.addMenu(menu);
        return dao.findIdByMname(menu.getMname());
    }

    //查询一个菜单

    public Menu selectOneMenu(Integer mno){
        return dao.selectOneMenu(mno);
    }

    //修改一个菜单

    public void updateMenu(Menu menu){
        dao.updateMenu(menu);
    }

    //删除一个菜单
    public void deleteMenu(Integer mno){
        dao.deleteMenu(mno);
    }

}
