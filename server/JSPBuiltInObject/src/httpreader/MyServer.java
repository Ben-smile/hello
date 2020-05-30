package httpreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void main(String[] args){
        try {
            //模拟一个我自己的服务  读取一次浏览器发送的请求
            //开启一个服务
            System.out.println("我自己的服务器开启啦");
            ServerSocket server = new ServerSocket(9999);
            //等待客户端连接
            Socket socket = server.accept();
            //通过socket对象读取浏览器发送的请求
            InputStream is = socket.getInputStream();//通过socket获取一个字节输入流
            InputStreamReader isr = new InputStreamReader(is);//字节转化成字符的流
            BufferedReader br = new BufferedReader(isr);//只是为了要里面的readLine方法
            //读取请求协议头信息
            String value = br.readLine();
            while(value!=null && ""!=value){
                System.out.println(value);
                value = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
