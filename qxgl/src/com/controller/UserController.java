package com.controller;

import com.domain.User;
import com.service.UserService;
import mymvc.*;
import orm.annotation.Insert;
import orm.annotation.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionAttributes("loginUser")
public class UserController {
    private UserService service= UserService.getInstance();

    //登录
    @RequestMapping("login.do")
    public ModelAndView login(@Param("uname")String uname, @Param("upass")String upass){

        User user = service.checkLogin(uname,upass);

        if (user != null){
            //登录成功
            ModelAndView mv = new ModelAndView();
            mv.setViewName("main.jsp");
            mv.addAttribute("loginUser",user);
            return mv;
        }else {
            //登录失败
            ModelAndView mv = new ModelAndView();
            mv.setViewName("index.jsp");
            mv.addAttribute("flag","-1");
            return mv;
        }
    }

    //查询全表
    @RequestMapping("userList.do")
    public ModelAndView selectAllUser(){
        List<User> users = service.selectAllUser();
        ModelAndView mv = new ModelAndView();
        mv.addAttribute("users",users);
        mv.setViewName("users.jsp");
        return mv;
    }

    //新建用户
    @RequestMapping("createUser.do")
    @ResponseBody
    public String createUser(User user){
        System.out.println(user);
        service.addUser(user);
        return "添加成功";
    }

    //删除用户
    @RequestMapping("deleteUser.do")
    public void delete(@Param("uno")String uno){
        Integer value = Integer.parseInt(uno);
        service.deleteUser(value);
    }

}
