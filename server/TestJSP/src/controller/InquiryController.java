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
        Float abalance = service.inquiry(aname);//请求的时候没有发送钱
        //我们调用了业务逻辑来的
        request.setAttribute("abalance",abalance);//从业务层来的钱 自己带走
        System.out.println("通过业务方法查询到了余额"+abalance);
        //3.根据结果给予响应
        request.getRequestDispatcher("showBalance.jsp").forward(request,response);
    }
}
