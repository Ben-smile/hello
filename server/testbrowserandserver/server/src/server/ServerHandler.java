package server;

import controller.IndexController;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;
import java.util.Properties;

public class ServerHandler extends Thread {

    private Socket socket;
    public ServerHandler(Socket socket){
        this.socket = socket;
    }

    public void run(){
        this.receiveRequest();
    }

    //读取消息
    private void receiveRequest(){
        try {
            InputStream is  = socket.getInputStream();//最基本的字节流
            InputStreamReader isr = new InputStreamReader(is);//将字节流转化成字符流
            BufferedReader reader = new BufferedReader(isr);//包装成高级流 可以读取一行
            //读取消息  content?key=value&key=value
            String contentAndParams = reader.readLine();
            //调用一个方法解析读取过来的信息
            this.parseContentAndParams(contentAndParams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //解析
    private void parseContentAndParams(String contentAndParams){
        //创建两个变量  存储请求的资源名  携带的参数
        String content = null;
        HashMap<String,String> paramsMap = null;
        //  content?key=value&key=value
        //找寻问号所在的位置
        int questionMarkIndex = contentAndParams.indexOf("?");
        //判断是否携带了参数
        if(questionMarkIndex!=-1){
            //携带了参数 截取问号前面的信息-->请求资源名 问号后面的信息拆分存入map集合里
            content = contentAndParams.substring(0,questionMarkIndex);
            paramsMap = new HashMap<String,String>();
            //处理问号后面的参数 拆分存入map集合   key=value&key=value
            String params = contentAndParams.substring(questionMarkIndex+1);
            String[] keyAndValues = params.split("&");
            for(String keyAndValue : keyAndValues){
                String[] KV = keyAndValue.split("=");
                paramsMap.put(KV[0],KV[1]);
            }
        }else{
            //没有携带参数 请求发过来的信息就是完整的资源名
            content = contentAndParams;
        }
        //-----至此将请求发送过来的字符串解析完毕(content,paramsMap)------------------
        //自己创建两个对象
        // 一个是为了包含所有请求携带的信息
        // 另一个是为了接受响应回来的结果  创建时是空对象 在Controller执行完毕后 将其填满
        HttpServletRequest request = new HttpServletRequest(content,paramsMap);
        HttpServletResponse response = new HttpServletResponse();//空的
        this.findController(request,response);
    }
    //找人干活---控制层    (controller  action  servlet)
    //content----index     map-----{{name,zzt},{},{}}
    private void findController(HttpServletRequest request,HttpServletResponse response){
        try {
            //获取request对象中的请求名字
            String content = request.getContent();
            //参考配置文件
            Properties pro = new Properties();
            pro.load(new FileReader("src//web.properties"));
            String realControllerName = pro.getProperty(content);
            //反射获取类
            Class clazz = Class.forName(realControllerName);
            Object obj = clazz.newInstance();
            //反射找寻类中的方法
            Method method = clazz.getMethod("test",HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(obj,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //将最终的响应信息 写回浏览器
    private void responseToBrowser(){

    }

}
