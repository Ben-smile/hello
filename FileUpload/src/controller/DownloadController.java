package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
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

public class DownloadController extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //上传文件

        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upLoad = new ServletFileUpload(factory);
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
