import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Browser {

    //模拟一个浏览器 和 服务器交互的过程


    private Scanner input = new Scanner(System.in);

    public void openBrowser(){
        //输入一个url--->统一资源定位符
        //ip:port/资源名?参数
        System.out.println("打开浏览器");
        System.out.print("请输入url");
        String URL = input.nextLine();

    }

    //设计一个方法 用来解析 url-->ip   port  contentAndParams
    private void parseURL(String url){
        int colonIndex = url.indexOf(":");
        int slashIndex = url.indexOf("/");

        String IP = url.substring(0,colonIndex);
        int port = Integer.parseInt(url.substring(colonIndex+1,slashIndex));
        String contentAndParams = url.substring(slashIndex+1);
    }

    //设计一个方法 用来 创建连接并将content发送给服务器
    private void createSocketAndSendRequest(String IP,int port,String contentAndParams){
        try {
            //通过IP 和 port 创建一个socket连接
            Socket socket = new Socket(IP,port);
            //创建一个流 将content发送出去
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(contentAndParams);
            out.flush();
            //浏览器等待响应信息
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
