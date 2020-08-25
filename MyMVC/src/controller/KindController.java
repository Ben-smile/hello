package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KindController {

    //一个方法种类查询
    public String kindQuery(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        System.out.println("KindController的查询种类执行了");
        return "kindQuery.jsp";
    }

    public String kindUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        System.out.println("KindController的修改种类执行了");
        return "kindUpdate.jsp";
    }
}
