package server;

import java.net.Socket;

public class ServerHandler extends Thread{

    //接收信息需要socket对象 但是run方法不能传参数 所以放在属性
    private Socket socket;

    public ServerHandler (Socket socket){
        this.socket = socket;
    }
    public void run(){
        //1.接收信息
        //2.解析
        //3.干活
        //4.将响应信息 返回给浏览器
    }

}
