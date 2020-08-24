package controller;

import service.AtmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 控制层
 */
public class AtmController extends HttpServlet {

    private AtmService service = new AtmService();

    //service方法  doPost doGet
    //服务器只认识这一个方法
    //原来这个service方法是做具体的 取值 调业务 转发
    //从原来具体做控制  升级了  控制小主管  收发室老大爷
    //负责接收请求  分别找对应的小弟干活

    //  思想-->约定优于配置
    //  约定好 发送请求(发的就是方法名)
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1.接收请求的资源名(刚好就是方法名)
            //request.getRequestURL();//统一资源定位器  ip:port/content
            String uri = request.getRequestURI();//统一资源标识符  content
            //System.out.println(uri);//20200511MyMVC/login
            uri = uri.substring(uri.lastIndexOf("/")+1);
            //System.out.println(uri);//  uri变成一个请求名字了
            //2.通过方法名字找方法(反射方式)
            //先找类   Class.forName("");  类名.class;   对象.getClass();
            Class clazz = this.getClass();
            //找方法
            Method method = clazz.getMethod(uri,HttpServletRequest.class,HttpServletResponse.class);
            //3.通过反射执行找到的方法(方法内部是之前具体的控制 正常执行了)
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //================================================================================
    //设计一个方法 专门用来做登录那个功能的控制
    public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login方法执行了");
        //1.接收请求的参数  name  pass
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        //2.做业务(自己不做 找小弟帮忙 Service层的某一个方法)
        String result = service.login(name,pass);//对象 集合
        //3.拿到业务的结果 给予响应(写回浏览器 转发JSP 重定向)
        request.getRequestDispatcher("xxx").forward(request,response);
    }

    //设计一个方法 专门用来做查询那个功能的控制
    public void query(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        System.out.println("query方法执行了");
        //1.接收请求的参数  name
        //2.找业务层的方法做事   result = service.query(name);
        //3.给响应(转发)
        //request.getRequestDispatcher("路径").forward(request,response);
    }

}
