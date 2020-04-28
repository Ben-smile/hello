package server;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

//这个类的目的是为了管理  findController方法
//1.方法与之前服务器Handler做的事情不一致   抽离出来
//2.每一次找寻Controller类的时候都需要参考一下web.properties
//      读取文件性能会比较低  增加一个缓存机制
//3.每一个Controller类都是由findController方法来找寻
//      找到了Controller类的目的是为了执行里面的方法
//      让类中的方法有一个统一的规则----便于查找和使用
//4.发现Controller类与之前的Service和Dao相似  只有方法执行  没有属性
//      让Controller类的对象变成单例模式

public class ServletController {

    //添加一个缓存 用来存储web.properties配置文件中的信息(请求名字=真实Controller类名)
    private static HashMap<String,String> controllerNameMap = new HashMap<>();
    //添加一个集合 存储被管理的所有Controller类对象
    private static HashMap<String,HttpServlet> controllerObjectMap = new HashMap<>();
    //延迟加载对象的方式

    //创建一个静态块 在当前类加载的时候将配置文件中的所有信息读取出来存入缓存集合中
    static{
        try {
            Properties pro = new Properties();
            pro.load(new FileReader("src//web.properties"));
            Enumeration en = pro.propertyNames();
            while(en.hasMoreElements()){
                String content = (String)en.nextElement();
                String realControllerName = pro.getProperty(content);
                controllerNameMap.put(content,realControllerName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //找人干活---控制层    (controller  action  servlet)
    //content----index     map-----{{name,zzt},{},{}}
    public static void findController(HttpServletRequest request,HttpServletResponse response){
        //获取request对象中的请求名字
        String content = request.getContent();
        try {
            //先去objectMap中找寻需要的对象
            HttpServlet controllerObject = controllerObjectMap.get(content);
            //若对象不存在 证明之前没有使用过
            if(controllerObject==null){
                //参考配置文件(缓存) 真实类名
                String realControllerName = controllerNameMap.get(content);
                //请求对应的真实类名是否存在
                if(realControllerName!=null){
                    //反射获取类
                    Class clazz = Class.forName(realControllerName);
                    controllerObject = (HttpServlet) clazz.newInstance();
                    //将新创建的对象放在上面的对象集合内
                    controllerObjectMap.put(content,controllerObject);
                }
            }
            //----以上可以确保controllerObject对象肯定存在-------------
            //反射找寻类中的方法
            Class controllerClass = controllerObject.getClass();
            Method serviceMethod = controllerClass.getMethod("service",HttpServletRequest.class,HttpServletResponse.class);
            serviceMethod.invoke(controllerObject,request,response);
        } catch (ClassNotFoundException e) {
            response.write("请求的"+content+"Controller不存在");
        } catch (NoSuchMethodException e){
            response.write("405 没有可以执行的方法");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
