package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理字符集
        request.setCharacterEncoding("UTF-8");
        //获取请求的信息
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name+"--"+password);
        //找寻业务层的方法做业务处理  调用result = service.login();
        //转发给JSP帮我们拼接响应    另外一个操作资源
        //  请求转发rd.forward();    请求重定向response.sendRedirect();

        //请求转发  传递request和response参数
        //RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");//目的是为了告知 转发的路径
        //rd.forward(request,response);//真的转发走啦

        //请求重定向 没有传递request参数
        //浏览器login 重定向welcome-->服务器告诉浏览器你需要找welcome 让浏览器再发一遍
        response.sendRedirect("welcome.jsp");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
