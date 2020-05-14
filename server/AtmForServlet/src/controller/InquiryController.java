package controller;

import service.AtmService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InquiryController extends HttpServlet {

    //控制层--- 接受请求发送过来的信息  找寻业务层的方法干活  给予响应信息

    private AtmService service = MySpring.getBean("service.AtmService");

    //doGet  doPost
    public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        //0.处理中文字符集
        //1.接受请求发送过来的账号--->
        String aname = request.getParameter("aname");
        System.out.println("接收到了请求发送的名字"+aname);
        //2.调用业务层的方法 ---> 负责查询
        Float abalance = service.inquiry(aname);
        System.out.println("通过业务方法查询到了余额"+abalance);
        //3.根据结果给予响应
        response.setCharacterEncoding("UTF-8");//按照这样的字符集响应
        PrintWriter out = response.getWriter();//获取输出流对象
        out.write("<html>");
        out.write(" <head>");
        out.write("     <meta charset=\"UTF-8\">");//告诉浏览器 以 这样的字符集进行解析
        out.write("     <script type=\"text/javascript\">");
        out.write("         window.onload = function(){");
        out.write("             var inputButton = document.getElementById(\"back\");");
        out.write("             inputButton.onclick = function(){");
        out.write("                 window.history.back();");
        out.write("             }");
        out.write("         }");
        out.write("     </script>");
        out.write(" </head>");
        out.write(" <body>");
        out.write("     尊敬的"+aname+"用户,您的可用余额为:"+abalance+"<br>");
        out.write("     <input id=\"back\" type=\"button\" value=\"回去\">");
        out.write(" </body>");
        out.write(" </html>");
        out.flush();
    }
}
