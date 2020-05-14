package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("all")
public class DepositController extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aname = request.getParameter("aname");
         //将响应信息拼接一下
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write(" <head>");
        out.write("     <meta charset=\"UTF-8\">");
        out.write(" </head>");
        out.write(" <body>");
        out.write("     <form action=\"doDeposit\" method=\"post\">");
        out.write("         请输入存款金额:<input type=\"text\" name=\"depoistBalance\" value=\"\"><br>");
        out.write("         <input type=\"submit\" value=\"确定\">");
        out.write("         <input type=\"hidden\" name=\"aname\" value=\""+aname+"\">");
        out.write("     </form>");
        out.write(" </body>");
        out.write("</html>");
        out.flush();
    }
}
