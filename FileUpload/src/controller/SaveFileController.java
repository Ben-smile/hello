package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

public class SaveFileController extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //上传文件

            DiskFileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upLoad = new ServletFileUpload(factory);

            //设置一个监听器
            upLoad.setProgressListener(new ProgressListener() {

                public void update(long l, long l1, int i) {
                    //  第一个参数表示 已经上传的字节个数   4096个字节
                    //  第二个参数表示 上传文件的总字节数
                    //  第三个参数表示 正在上传第几个组件
                    double progress = (double)l / (double)l1;
                    int percentage = (int)(progress * 100);
                    System.out.println("正在上传第"+i+"个组件,已经上传了:"+percentage);
                }
            });

        try {
            List<FileItem> list = upLoad.parseRequest(request);

            for (FileItem item : list){

                //表示是一个普通的组件
                if (item.isFormField()){
                    String name = item.getFieldName(); //获取名字
                    String value = item.getString("UTF-8"); //获取值
                }else { //是一个文件
                    //InputStream input = item.getInputStream();
                    String name = item.getName();
                    item.write(new File("D://test/"+name));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
