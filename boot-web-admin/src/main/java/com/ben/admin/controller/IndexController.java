package com.ben.admin.controller;

import com.ben.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }


    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model){
        if (StringUtils.hasLength(user.getUserName()) && "666".equals(user.getPassword())) {
            //登录成功，把用户信息存入session
            session.setAttribute("loginUser", user);
            //重定向到主页，没有用转发是为了防止表单重复提交
            return "redirect:/main.html";
        }
        model.addAttribute("msg", "用户名或密码错误");
        return "login";
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){
        /* 登陆检查  -->  交给拦截器处理
        if (session.getAttribute("loginUser") == null) {
            model.addAttribute("msg","尚未登陆，请先登录");
            return "login";
        }
        */
        return "main";
    }

}
