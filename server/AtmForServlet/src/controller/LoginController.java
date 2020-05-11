package controller;

import service.AtmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.获取请求发送过来的账号和密码
        String aname = request.getParameter("aname");
        String apassword = request.getParameter("apassword");
        System.out.println("接受到了浏览器发送过来的请求信息"+aname+"--"+apassword);
        //2.负责处理一个业务判断---调用业务层的登录方法
        AtmService service = new AtmService();
        String result = service.login(aname,apassword);
        //3.根据业务方法的执行结果  给予响应
    }

}
