package com.controller;

import com.domain.Menu;
import com.service.MenuService;
import mymvc.Param;
import mymvc.RequestMapping;
import mymvc.ResponseBody;
import orm.annotation.Delete;

import javax.annotation.Resource;
import java.util.List;

public class MenuController {

    MenuService service = new MenuService();


    //返回所有的menu集合
    @RequestMapping("menuList.do")
    @ResponseBody
    public List<Menu> menuList (){
        return service.selectAllMenu();
    }

    //保存一条 菜单信息
    //还得返回这条保存的菜单的 编号
    @RequestMapping("addMenu.do")
    @ResponseBody
    public int addMenu(Menu menu){
        return service.addMenu(menu);
    }

    //查询一条信息
    @RequestMapping("selectOneMenu.do")
    @ResponseBody
    public Menu selectOneMenu(@Param("mno")Integer mno){
        System.out.println(service.selectOneMenu(mno));
       return  service.selectOneMenu(mno);

    }

    //修改一条信息
    @RequestMapping("updateMenu.do")
    public void updateMenu(Menu menu){
        service.updateMenu(menu);
    }

    //删除一个菜单
    @RequestMapping("deleteMenu.do")
    public void deleteMenu(@Param("mno")Integer mno){
        List<Menu> menus = menuList();
        for (Menu menu:menus){
            if (menu.getPno() == mno){
                deleteMenu(mno);
            }
        }
        service.deleteMenu(mno);
    }
}
