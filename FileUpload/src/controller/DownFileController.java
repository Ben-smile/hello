package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class DownFileController extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求传递的文件名
        String fileName = request.getParameter("fileName");
        //2.通过文件名 找到真实的文件
        InputStream inputStream = new FileInputStream("D://test/"+fileName);
        //3.如果文件名含有中文，通过以下方式处理
        fileName = URLEncoder.encode(fileName,"UTF-8");
        //4.设置响应的contentType
        //  ServletFileUpload--->FileUpload--->FileUploadBase
        //  调用静态常量进行拼接字符串
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-disposition","attachment;filename="+fileName);
        //5.将内容响应回浏览器
        OutputStream outputStream = response.getOutputStream();
        byte[] b = new byte[1024];
        int length = inputStream.read(b);
        while(length!=-1){
            outputStream.write(b,0,length);
            outputStream.flush();
            length = inputStream.read(b);
        }
    }
}
