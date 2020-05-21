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
public class DoDepositController extends HttpServlet {

    private AtmService service = MySpring.getBean("service.AtmService");

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aname = request.getParameter("aname");
        String depositBalance = request.getParameter("depoistBalance");
        System.out.println("接收到了名字和存款金额:"+aname+"--"+depositBalance);
        //调用业务层的方法负责存钱
        service.deposit(aname,new Float(depositBalance));
        //--------------------------------------------------------------
        response.setCharacterEncoding("UTF-8");//设置 服务器向浏览器发送响应信息的字符集
        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("<meta charset=\"UTF-8\">");//告诉浏览器 按照这种字符集解析
        out.write("</head>");
        out.write("<body>");
        out.write("****************************<br>");
        out.write("欢迎"+aname+"进入ATM系统<br>");
        out.write("****************************<br>");
        out.write("请输入操作选项<br>");
        out.write("<a href=\"inquiry?aname="+aname+"\">查询</a><br>");//请求操作资源
        out.write("<a href=\"deposit?aname="+aname+"\">存款</a><br>");//请求操作资源
        out.write("<a href=\"\">取款</a><br>");
        out.write("<a href=\"\">转账</a><br>");
        out.write("</body>");
        out.write("</html>");
        out.flush();
    }
}
