package controller;

import service.AtmService;
import util.MySpring;

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
        response.setCharacterEncoding("UTF-8");//设置 服务器向浏览器发送响应信息的字符集
        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("<meta charset=\"UTF-8\">");//告诉浏览器 按照这种字符集解析
        out.write("</head>");
        out.write("<body>");
        if(result.equals("登录成功")){
            out.write("****************************<br>");
            out.write("欢迎"+aname+"进入ATM系统<br>");
            out.write("****************************<br>");
            out.write("请输入操作选项<br>");
            out.write("<a href=\"inquiry?aname="+aname+"\">查询</a><br>");//请求操作资源
            out.write("<a href=\"deposit?aname="+aname+"\">存款</a><br>");//请求操作资源
            out.write("<a href=\"\">取款</a><br>");
            out.write("<a href=\"\">转账</a><br>");
        }else{
            out.write("对不起,"+result);
        }
        out.write("</body>");
        out.write("</html>");
        out.flush();
    }

}
