package com.dao;

import com.domain.Menu;
import orm.annotation.Delete;
import orm.annotation.Insert;
import orm.annotation.Select;
import orm.annotation.Update;

import java.util.List;

public interface MenuDao {

    @Select("select * from t_menu")
    List<Menu> selectAllMenu ();


    //保存一个菜单信息
    @Insert("insert into t_menu (mname,mhref,mtarget,pno) values (#{mname},#{mhref},#{mtarget},#{pno})")
    void addMenu(Menu menu);

    @Select("select mno from t_menu where mname = #{mname}")
    int findIdByMname(String mname) ;


    //查询一个菜单
    @Select("select * from t_menu where mno=#{mno}")
    Menu selectOneMenu(Integer mno);

    //修改一个菜单
    @Update("update t_menu set mname=#{mname},mhref=#{mhref},mtarget=#{mtarget} where mno=#{mno}")
    void updateMenu(Menu menu);

    //删除一个菜单
    @Delete("delete from t_menu where mno=#{mno}")
    void deleteMenu(Integer mno);
}
