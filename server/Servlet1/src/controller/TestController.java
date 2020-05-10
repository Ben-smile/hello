package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestController extends HttpServlet {

    public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        System.out.println("TestController类执行啦");
        response.setCharacterEncoding("UTF-8");//流写回浏览器时用的
        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write(" <head>");
        out.write("     <meta charset=\"UTF-8\">");//为了让浏览器解析时候用的
        out.write(" </head>");
        out.write(" <body>");
        out.write("     响应信息，你们听懂了吗？");
        out.write(" </body>");
        out.write("</html>");
        out.flush();
    }

}
