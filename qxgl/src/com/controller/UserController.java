package com.controller;

import com.domain.User;
import com.service.UserService;
import mymvc.ModelAndView;
import mymvc.Param;
import mymvc.RequestMapping;
import mymvc.SessionAttributes;

@SessionAttributes("loginUser")
public class UserController {
    private UserService service= new UserService();

    @RequestMapping("login.do")
    public ModelAndView login(@Param("uname")String uname, @Param("upass")String upass){
        System.out.println(uname);
        System.out.println(upass);
        User user = service.checkLogin(uname,upass);
        System.out.println(user);
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

}
