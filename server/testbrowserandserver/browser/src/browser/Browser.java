package browser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

@SuppressWarnings("all")
public class Browser {

    private Scanner input = new Scanner(System.in);
    private Socket socket;
    private String ip;
    private int port;

    //打开浏览器窗口
    public void openBrowser(){
        //输入一个URL统一资源定位符
        //  ip:port/index.html?key=value&key=value
        //  localhost:9999/controller.IndexController?name=zzt
        //  请求是一个资源名IndexController  反射进行查找
        System.out.print("URL:");
        String url = input.nextLine();
        this.parseURL(url);
    }

    //设计一个方法 解析url
    private void parseURL(String url){
        //找寻冒号和第一个斜杠所在的位置
        int colonIndex = url.indexOf(":");
        int slashIndex = url.indexOf("/");
        //获取IP port contentAndParams
        ip = url.substring(0,colonIndex);
        port = Integer.parseInt(url.substring(colonIndex+1,slashIndex));
        String contentAndParams = url.substring(slashIndex+1);
        this.createSocketAndSendRequest(ip,port,contentAndParams);
    }

    //设计一个方法 创建一个socket 将contentAndParams发送给服务器
    private void createSocketAndSendRequest(String ip,int port,String contentAndParams){
        try {
            //通过ip和port创建一个socket
            socket = new Socket(ip,port);
            //将contentAndParams发送出去(给服务器)
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(contentAndParams);//    资源名?key=value&key=value
            out.flush();
            //浏览器等待响应信息
            this.receiveResponseContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //设计一个方法 接受服务器回写的响应信息
    private void receiveResponseContent(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseContent = reader.readLine();
            //解析响应信息并展示
            this.parseResponseContentAndShow(responseContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //设计一个方法 解析响应信息并展示
    private void parseResponseContentAndShow(String responseContent){
        //创建两个新的变量 用于存储新一次的请求和参数
        String content = null;
        HashMap<String,String> paramsMap = null;

        //解析一个<br>标签
        responseContent = responseContent.replace("<br>","\r\n");
        while(true){
            //解析其他的标签
            int lessThanIndex = responseContent.indexOf("<");
            int greaterThenIndex = responseContent.indexOf(">");
            //如果两个符号成对 证明存在一个有意义的标签
            if(lessThanIndex!=-1 && greaterThenIndex!=-1 && lessThanIndex<greaterThenIndex){
                //输出小于号前面的内容
                System.out.println(responseContent.substring(0,lessThanIndex));
                //分析标签是什么类型 做相应的处理  <input name="" value="">
                String tag = responseContent.substring(lessThanIndex,greaterThenIndex+1);
                if(tag.contains("input")){
                    String value = input.nextLine();
                    if(paramsMap==null){
                        paramsMap = new HashMap<String,String>();
                    }// <input name="xxx" value="">
                    String[] keyAndValues = tag.split(" ");//将一个大的标记按照空格拆分
                    for(String keyAndValue : keyAndValues){//循环每一组键值对
                        if(keyAndValue.contains("=")){//如果当前的一组中包含有等号 证明是正常的参数
                            String[] KV = keyAndValue.split("=");//按照等号拆分
                            if("name".equals(KV[0])){
                                paramsMap.put(KV[1].substring(1,KV[1].length()-1),value);
                            }
                        }
                    }
                }else if(tag.contains("form")){//<form action="" method="">
                    String[] keyAndValues = tag.split(" ");//将一个大的标记按照空格拆分
                    for(String keyAndValue : keyAndValues){//循环每一组键值对
                        if(keyAndValue.contains("=")){//如果当前的一组中包含有等号 证明是正常的参数
                            String[] KV = keyAndValue.split("=");//按照等号拆分
                            if("action".equals(KV[0])){
                                //产生一个新的请求
                                content = KV[1].substring(1,KV[1].length()-1);
                            }
                        }
                    }
                }
                responseContent = responseContent.substring(greaterThenIndex+1);
            }else{//如果符号不成对 证明不存在其他标签
                //则直接输出全部的内容
                System.out.print(responseContent);
                break;
            }
        }
        //------至此将所有的响应信息解析完毕--------------------------------------
        //如果标签中遇到了<form>表示我还有一次新的请求
        this.sendNewRequest(content,paramsMap);
    }

    private void sendNewRequest(String content,HashMap<String,String> paramsMap){
        if(content!=null){//遇到了一个form标签 还需要发送下一次请求
            StringBuilder url = new StringBuilder(ip);
            url.append(":");
            url.append(port);
            url.append("/");
            url.append(content);
            if(paramsMap!=null){//证明新情求还有参数
                url.append("?");
                Iterator<String> it = paramsMap.keySet().iterator();
                while(it.hasNext()){
                    String key = it.next();
                    String value = paramsMap.get(key);
                    url.append(key);
                    url.append("=");
                    url.append(value);
                    url.append("&");
                }
                //循环执行完毕后 最终多了一个&符号 将其删除
                url.delete(url.length()-1,url.length());
            }
            this.parseURL(url.toString());
        }
    }

}
