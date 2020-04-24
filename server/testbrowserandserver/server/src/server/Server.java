package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //模拟 服务器

    //启动服务器
    public void openServer(){

        try {
            System.out.println("服务器启动");
            //创建一个自己的服务
            ServerSocket serverSocket = new ServerSocket(9999);
            //等待连接
            while(true) {
                //服务器 一份就够 但是连接有很多个 所以创建线程
                Socket socket = serverSocket.accept();
                new ServerHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
