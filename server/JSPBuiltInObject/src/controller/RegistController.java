package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class RegistController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //0.设置字符集
        request.setCharacterEncoding("UTF-8");
        //1.接受请求携带的信息
//        String name = request.getParameter("name");
//        String sex = request.getParameter("sex");
//        System.out.println(name+"--"+sex);

//        Enumeration en = request.getParameterNames();//获取全部的key
//        while(en.hasMoreElements()){
//            String key = (String)en.nextElement();//获取某一个key
//            String value = request.getParameter(key);
//            System.out.println(key+"--"+value);
//        }

        String[] values = request.getParameterValues("hobby");
        for(String value:values){
            System.out.println(value);
        }
    }
}
