package controller;

import domain.Atm;
import service.AtmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class DoRegistController extends HttpServlet {

    private AtmService service = new AtmService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //1.处理字符集
//        request.setCharacterEncoding("UTF-8");
//        //2.接收请求传递过来的参数   aname  apassword  abalance
//        String aname = request.getParameter("aname");
//        String apassword = request.getParameter("apassword");
//        String abalance = request.getParameter("abalance");
//        //3.将传递的请求包装成一个对象   domain javaBean pojo
//        //  view--请求-->controller--参数VO-->service--参数PO-->dao-->数据库
//        Atm atm = new Atm();
//        atm.setAname(aname);
//        atm.setApassword(apassword);
//        atm.setAbalance(Float.parseFloat(abalance));

        //接收前面传递的参数
        Enumeration en = request.getParameterNames();
        while(en.hasMoreElements()){
            String key = (String)en.nextElement();
            String value = request.getParameter(key);
            System.out.println(key+"---"+value);
        }
        //接收前面创建好的那个VO对象
        Atm atm = (Atm)request.getAttribute("atm");
        //4.调用业务层的一个方法处理逻辑
        service.insert(atm);
        //5.转发给JSP 处理响应信息拼接
        //out.write("<html>");
        request.getRequestDispatcher("welcome.jsp").forward(request,response);
    }
}
