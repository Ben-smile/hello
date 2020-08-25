package mymvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 这个类是我们通过分析提炼出来的
 * 这个类中应该只有一个方法
 * 方法就是service方法    这个类是那个唯一的"小总管"
 * 小总管帮我们做请求的分发
 * 某一个具体的Controller类中具体的方法
 */
public class DispatcherServlet extends HttpServlet {

    //小总管   接收所有的.do请求  分发给不同类中的不同方法
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //0.找到请求的类
            String uri = request.getRequestURI();
            //System.out.println(uri);//  /20200511MyMVC/AtmController.do
            String className = uri.substring(uri.lastIndexOf("/")+1,uri.indexOf("."));
            System.out.println(className);//    类的简单名
            //参考文件  找到简单名对应的类全名
            Properties properties = new Properties();
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ApplicationContext.properties");
            properties.load(inputStream);
            String fullClassName = properties.getProperty(className);//类全名
            //1.找到请求的方法
            String methodName = request.getParameter("method");
            System.out.println(methodName);
            //2.反射找到方法
            Class clazz = Class.forName(fullClassName);
            Method method = clazz.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            //3.反射执行方法
            Object obj = clazz.newInstance();
            String methodResult = (String)method.invoke(obj,request,response);
            //4.处理返回的响应信息
            request.getRequestDispatcher(methodResult).forward(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    //==================================================================
    //service方法  doPost doGet
    //服务器只认识这一个方法
    //原来这个service方法是做具体的 取值 调业务 转发
    //从原来具体做控制  升级了  控制小主管  收发室老大爷
    //负责接收请求  分别找对应的小弟干活

    //  思想-->约定优于配置
    //  约定好 发送请求(发的就是方法名)
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            //1.接收请求的资源名(刚好就是方法名)
//            //request.getRequestURL();//统一资源定位器  ip:port/content
//            String uri = request.getRequestURI();//统一资源标识符  content
//            //System.out.println(uri);//20200511MyMVC/login
//            uri = uri.substring(uri.lastIndexOf("/")+1);
//            //System.out.println(uri);//  uri变成一个请求名字了
//            //2.通过方法名字找方法(反射方式)
//            //先找类   Class.forName("");  类名.class;   对象.getClass();
//            Class clazz = this.getClass();
//            //找方法
//            Method method = clazz.getMethod(uri,HttpServletRequest.class,HttpServletResponse.class);
//            //3.通过反射执行找到的方法(方法内部是之前具体的控制 正常执行了)
//            String methodResult = (String)method.invoke(this,request,response);//invoke真正执行小方法的地方
//            //4.处理一下最终转发的结果(不止是转发 重定向。。。健壮性 判断)
//            request.getRequestDispatcher(methodResult).forward(request,response);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
}
