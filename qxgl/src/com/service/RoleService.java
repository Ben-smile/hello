package com.service;

import com.dao.impl.RoleDaoImpl;
import com.domain.Role;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleService {

    private RoleDaoImpl dao = new RoleDaoImpl();
    public List<Role> findRoles(int page, int rows, Integer rno, String rname, String description){
        //page 当前页 rows记录数  rno,rname,description 过滤信息
        //通过 page  和 rows  计算出 数据库所需要的 start 和 length
        int start = (page - 1)*rows;
        int length = rows;
        //将参数组成一个集合
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("rno",rno);
        params.put("rname",rname);
        params.put("description",description);

        return dao.findRoles(params);
    }

    //根据查询总数 计算最大页
    public int findMaxPage(int page, int rows, Integer rno, String rname, String description){
        Map<String,Object> params = new HashMap<>();

        params.put("rno",rno);
        params.put("rname",rname);
        params.put("description",description);
        //查询到的所有记录的数量
        int count = dao.listCount(params);

        int maxPage = count%rows == 0 ? count/rows : (count/rows +1);

        return maxPage;
    }

    //查询还未有的角色
    public List<Role> selectNotAddedRoles(Integer uno){
        return dao.selectNotAddedRoles(uno);
    }

    public List<Role> selectAddedRoles(Integer uno){
        return dao.selectAddedRoles(uno);
    }

    //修改user_role信息

    public void updateUserAndRole(Integer uno,String params){
        String[] rnos = params.split(",");
        for (String rno:rnos){
            Map<String,Integer> map = new HashMap<>();
            map.put("uno",uno);
            map.put("rno",Integer.parseInt(rno));
            System.out.println(rno);

        }
    }

    public void deleteUserAndRole(Integer uno){
        dao.deleteUserAndRole(uno);
    }
}
