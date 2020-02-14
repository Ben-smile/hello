package testfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
    public static void main (String[] args){
        /*
        字节型文件输出流
            FileOutputStream    将数据写入文件中
        1. java.io 包中
        2. 继承OutputStream 类 所有字节型文件输出流的父类
        3.创建对象
                调用一个带File参数  还有File  boolean 重载(时候在后面追加)
                调用一个带String参数 还有String boolean 重载
        4.常用方法
                write(int code); 将给定code对应的字符写入文件
                write(byte[]);  将数组中的全部字节写入文件   getByte()
                flush();   将管道内的字节推入(刷新)文件
                close();   关闭流管道   注意在finally中关闭
         */

        File file = new File("D://java//aaa//Test1.txt");
        //若创建的是输入文件流  若路径有问题 会直接抛出异常
        //若创建的是输出文件流  若路径有问题 则直接帮我们创建一个新的文件 但是不能创建文件夹
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file,true);
            String str = "1+1=2";
            byte[] b = str.getBytes();
            fos.write(b);

            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
