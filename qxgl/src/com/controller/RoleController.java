package com.controller;

import com.domain.Role;
import com.service.RoleService;
import mymvc.ModelAndView;
import mymvc.Param;
import mymvc.RequestMapping;

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
        mv.setViewName("roleList.jsp");
        return mv;
    }

}
