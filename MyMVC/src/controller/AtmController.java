package controller;

import service.AtmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制层
 *
 * 很多规则
 *      继承父类        不用了
 *      重写方法        不用了
 *      方法有2个参数    还在
 *      方法有2个异常    还在
 *      返回值          String
 *
 *      原来Servlet的管理机制
 *      Servlet对象是个单例的
 *      Servlet对象默认是延迟加载的
 */
public class AtmController {

    private AtmService service = new AtmService();

    //设计一个方法 专门用来做登录那个功能的控制
    public String login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AtmController类中的login方法执行了");
        //1.接收请求的参数  name  pass
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        //2.做业务(自己不做 找小弟帮忙 Service层的某一个方法)
        String result = service.login(name,pass);//对象 集合
        //3.拿到业务的结果 给予响应(写回浏览器 转发JSP 重定向)
        return "welcome.jsp";//必须得知道该如何转发  forward  现在通过一个基础的String
    }

    //设计一个方法 专门用来做查询那个功能的控制
    public String query(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AtmController的查询执行了");
        //1.接收请求的参数  name
        //2.找业务层的方法做事   result = service.query(name);
        //3.给响应(转发)
        return "query.jsp";
    }

}
