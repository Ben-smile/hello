package testfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {
    public static void main (String[] args){
        /*File对象不能操作文件中的内容--->通过流I/O的方式来完成

        流按照方向(功能)来区分
                in(读取)      out(写入)
        操作目标来区分
                文件流 数组流 字符串流 数据流 对象流 网络流....
       --------------------------------------------------------------
       学习文件流--->
            读取文件中的信息(in)      将信息写入文件中(out)
            文件流按照读取或写入的单位(字节数)大小来区分

            字节型文件流(1字节)
                    FileInputStream/FileOutputStream
            字符型文件流(2个字节--->1字符)
                    FileReader/FileWriter
       字节型文件输入流:
            FileInputStream
            1.java.io 包
            2. 继承InputStream类   字节型输入流的父类
            3. 创建对象
                    调用一个带File 类型的构造方法
                    调用一个带String (路径名)类型的构造方法
            4. 常用方法
                    int code = read(); 每次从流管道中读取一个字节  返回字节的code码
                    *int count = read(byte[]); 每次从流管道中读取若干个字节 存入数组内 返回有效元素个数
                    int count = available(); 返回流管道中还有多少缓存的字节数
                    skip(long n);   跳过几个字节  读取
                                    多线程---->利用几个线程同时读取文件
                                    例如:10000个字节   5个线程同时读取
                                    1-2000  2001-4000  4001-6000  6001-8000 8001-10000
                                    提高速度
                    *close();  将流管道关闭----必须要做   最好放在finally里  保持代码的健壮性  判断严禁



         */
        File file = new File("D://java//aaa//Test.txt");
        FileInputStream fis = null;        //写在上面为了最后能关闭流管道
        try {
            fis  = new FileInputStream(file);//创建一个字节型输入流的对象 去真实的读取文件
            fis.skip(5);   //跳过5个字节  开始读取
            int code = fis.read();
            System.out.println((char)code);  //f
        } catch (IOException e) {
            e.printStackTrace();
        }finally{    //关闭流管道
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




//        File file = new File("D://java//aaa//Test.txt");
//        FileInputStream fis = null;        //写在上面为了最后能关闭流管道
//        try {
//            fis  = new FileInputStream(file);//创建一个字节型输入流的对象 去真实的读取文件
//            byte[] b = new byte[5];
//            int count = fis.read(b);  //将数组以参数的形式传进去  用来接收读取到的字节 相当于返回值
//
//            while(count != -1){
//                String str = new String(b,0,count); //String构造方法 byte[] 从第0个位置开始 创建count的长度
//                System.out.print(str);
//                count = fis.read(b);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{    //关闭流管道
//            try {
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }






//        File file = new File("D://java//aaa//Test.txt");
//        FileInputStream fis = null;        //写在上面为了最后能关闭流管道
//        try {
//            fis  = new FileInputStream(file);//创建一个字节型输入流的对象 去真实的读取文件
//            int code = fis.read();
//            while(code != -1){
//                System.out.print((char)code);
//                code = fis.read();
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{    //关闭流管道
//            try {
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


    }
}
