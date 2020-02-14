package testfile;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main (String[] args){
        /*文件:一种电脑的储存形式
          文件夹-------目录路径
         File---->与电脑上的文件或者文件夹产生一一对应的映射关系
         File 是一个类
          1.java.io包中
          2.文件或目录路径的抽象表示形式
          3.File与真实硬盘中的文件或文件夹不是一个东西  只是产生映射关系可以间接操控
            File是在内存中的一个 对象<--映射-->硬盘上的文件或者文件夹
          4.File 中的常用方法
            canRead()   canWrite()  isHidden()  isFile()  isDirectory()
            length() 获取文件中字节的个数
            lastModified() 获取文件的最后修改时间--->毫秒值  可以同过Date 转换成我们想要的时间格式
            *String path = getAbsolutePath()  获取文件的绝对路径  例如:D://test//Test.txt
                绝对路径<--->相对路径
                绝对路径可以通过完整的字符串  定位盘符  文件夹  文件
                相对路径是没有盘符的写法        默认去当前工程(项目)所在的位置找寻
            String  = getName() ; 获取文件的名字  Text.txt
            *boolean = createNewFile(); 创建一个新的文件
            *boolean = mkdir(); 创建一个新的文件夹  如果外层没有 不能创建
            *boolean = mkdirs(); 创建新的文件夹  外层没有可以自动创建
            String = getParent(); 获取file父亲的名字
            *File file = getParentFile(); 获取当前file父亲的File对象
            String[] = list(); 获取当前file的所有儿子名字
            *File files = listFiles(); 获取当前file的所有儿子对象
            *boolean = delete();  删除文件或者空的文件夹  不能删除有元素的文件夹

            ----------------
   补充:    若要创建File 对象时 路径为D://java//aaa 不带后缀 调用createNewFile()
            和路径为D://java//aaa.txt  调用 mkdir()方法时结果为什么
            调用什么方法就创建什么  所以第一个创建一个没有后缀的 aaa文件
                                       第二个创建一个名字是aaa.txt的文件夹

            */
        File file = new File("D://java");
        TestFile tf = new TestFile();
        tf.deleteDirectory(file);
    }
    //设计一个方法用来遍历文件夹(递归)

    //文件夹的遍历和删除不能用普通的循环来完成  需要通过递归的方式
     //递归的本质就是方法调用  所以递归只能写在方法之中
    public void showFile (File file) {
        File[] files = file.listFiles();
        if(files != null && files.length != 0){
            for (File f:files){
                this.showFile(f);
            }
        }
        System.out.println(file.getAbsoluteFile());
    }

    public void deleteDirectory (File file){
        File[] files = file.listFiles();
        if(files != null && files.length != 0){
            for(File f : files){
                this.deleteDirectory(f);
            }
        }
        //file 是一个文件或者是一个空的文件夹  删除
        file.delete();
    }


}
