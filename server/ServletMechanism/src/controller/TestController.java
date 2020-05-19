package controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class TestController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    //Servlet对象创建的时候调用的   像是构造方法
//    public void init(){
//        System.out.println("controller被创建啦");
//    }
    public void init(ServletConfig config){//用来读取配置文件中携带的信息
        //config.getInitParameter();
        //config.getInitParameterNames();
        //String name = config.getServletName();//获取当前Servlet类的名字
        //ServletContext application = config.getServletContext();//全局上下文对象

        //Properties pro = new Properties();
        //pro.load(new FileReader(""));
        //String value = pro.getProperty("key");
        //Enumeration en = pro.propertyNames();//获取全部的key

        System.out.println("controller被创建啦");
        Enumeration en = config.getInitParameterNames();//类似于map中的keySet方法   pro.propertyNames();
        while(en.hasMoreElements()){
            String key = (String)en.nextElement();
            String value = config.getInitParameter(key);
            System.out.println(key+"--"+value);
        }
        //String result = config.getInitParameter("key1");//value1
        //System.out.println("读取到了init-param中的配置信息"+result);
    }

    //Servlet对象被回收的时候调用的  像是finalize方法
    public void destroy(){
        System.out.println("controller被回收啦");
    }

    //私有构造方法
    //私有静态当前类对象作为属性
    //公有静态的方法将属性对象返回

    //添加一个属性 用来测试
    private int count = 1;

    //每一次发送请求 都执行一次
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getParameter("");//读取 请求发送时候携带的信息  key=value
        System.out.println("我是控制层的方法 点我干嘛呀???"+ count++ );
    }
}
