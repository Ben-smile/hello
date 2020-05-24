package controller;

import service.AtmService;
import util.MySpring;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("all")
public class LoginController extends HttpServlet {

    //Model One模式   控制层+视图层
    //Model Two模式   控制层Servlet --转发--> 视图层JSP
    //控制层-----根据请求的参数 控制最终响应信息
    //  0.处理接受信息的字符集(post--->   request.setCharacterEncoding("UTF-8");)
    //  1.获取请求发送过来的信息   String value = request.getParameter("key");
    //  2.找寻一个业务层的处理方法    结果 = service.xxxx(value);
    //  3.根据业务层的处理结果  给予响应  动态响应   out.write("<>");
    //      由于第3步的拼接信息很麻烦   第3步就不自己拼接  找一个小弟JSP

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //0.告诉request才用如下的字符集进行组合
        request.setCharacterEncoding("UTF-8");//get请求也没有影响
        //1.获取请求发送过来的账号和密码
        String aname = request.getParameter("aname");
        String apassword = request.getParameter("apassword");
        System.out.println("接受到了浏览器发送过来的请求信息:"+aname+"--"+apassword);
        //2.负责处理一个业务判断---调用业务层的登录方法
        AtmService service = MySpring.getBean("service.AtmService");
        String result = service.login(aname,apassword);
        System.out.println("业务逻辑的判定结果最终为:"+result);
        //3.根据业务方法的执行结果  给予响应
        if(result.equals("登录成功")){
            //控制响应信息是welcome---->转发给一个JSP小弟 帮我拼接响应信息
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");//告知
            rd.forward(request,response);//真正转发走啦
        }else{
            //控制响应信息是重新登录
            request.getRequestDispatcher("index.html").forward(request,response);
        }
    }

}
