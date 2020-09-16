package com.controller;

import com.domain.Role;
import com.service.RoleService;
import mymvc.ModelAndView;
import mymvc.Param;
import mymvc.RequestMapping;
import mymvc.ResponseBody;

import java.util.List;

public class RoleController {

    private RoleService service = new RoleService();
    //查询所有role信息

    @RequestMapping("roleList.do")
    public ModelAndView roleList(@Param("page")Integer page, @Param("rows")Integer rows, @Param("rno")Integer rno, @Param("rname")String rname, @Param("description")String description){

        if(page == null){
            page = 1 ;
        }
        if(rows == null){
            rows = 3 ;
        }
        ModelAndView mv = new ModelAndView();

        List<Role> rolesList = service.findRoles(page,rows,rno,rname,description);
        long maxPage = service.findMaxPage(page,rows,rno,rname,description);
        mv.addAttribute("rolesList",rolesList);
        mv.addAttribute("page",page);
        mv.addAttribute("rows",rows);
        mv.addAttribute("maxPage",maxPage);
        mv.addAttribute("rno",rno);
        mv.addAttribute("rname",rname);
        mv.addAttribute("description",description);
        mv.setViewName("roleList.jsp");
        return mv;
    }

    //获取指定编号的用户 还没有的角色
    @RequestMapping("selectNotAddedRoles.do")
    @ResponseBody
    public List<Role> selectNotAddedRoles(@Param("uno")Integer uno){
        return service.selectNotAddedRoles(uno);
    }


    //获取指定编号的用户 已有的角色
    @RequestMapping("selectAddRoles.do")
    @ResponseBody
    public List<Role> selectAddedRoles(@Param("uno")Integer uno){
        return service.selectAddedRoles(uno);
    }

    //修改用户-角色 信息
    @RequestMapping("updateUserAndRole.do")
    @ResponseBody
    public void updateUserAndRole(@Param("uno")Integer uno,@Param("rnos")String rnos){
        //先删除
        service.deleteUserAndRole(uno);
        service.updateUserAndRole(uno,rnos);
    }
}
