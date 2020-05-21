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
            //找一个小弟负责拼接成功以后的相应信息-----转发
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request,response);//真正的转发走啦
        }else{
            //找一个小弟负责拼接失败的相应信息
            request.getRequestDispatcher("index.html").forward(request,response);
        }
    }

}
