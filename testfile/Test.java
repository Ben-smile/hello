package testfile;

import java.io.*;

public class Test {
    //设计一个方法  文件的复制
            //从C: 的某一个位置 ----->复制到D://的某一个位置
            //找到C盘的 源文件    内容读一遍
            //在D盘创建一个新文件  将内容写进去

//    public boolean copyFile (File file,String pathNameFor){
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        try {
//            fis = new FileInputStream(file);
//            fos = new FileOutputStream(pathNameFor+file.getName(),true);
//            byte[] b = new byte[1024];
//            int count = fis.read(b);
//            while (count != -1){
//                fos.write(b,0,count);
//                fos.flush();
//                count = fis.read(b);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                fis.close();
//            }catch(IOException e){
//                e.printStackTrace();
//            }
//            try {
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return true;
//    }


        //设计一个方法 用来进行文件夹的复制

    //文件夹的复制    file可以代表文件  可以代表文件夹
    public void superCopyFile(File file,String newPath){
        //获取file的绝对路径  拼串的方式获取新文件的名字
        String oldFilePath = file.getAbsolutePath();//   C://aaa//bbb文件夹--->D://test//aaa//bbb
        String[] strs = oldFilePath.split("//");
        String newFilePath = newPath+"//"+strs[strs.length-1];
        System.out.println(newFilePath);
        System.out.println(strs[strs.length-1]);
        //创建一个新的file对象
//        File newFile = new File(newFilePath);
//        //判断当前传递进来的file是个文件还是文件夹  isFile isDirectory listFiles
//        File[] files = file.listFiles();//获取当前传递进来的file对象所有子元素
//        if(files!=null){//file是一个文件夹  才有数组对象
//            //通过新的file对象操作 在硬盘上创建一个文件夹
//            newFile.mkdir();
//            System.out.println(newFile.getName()+"文件夹复制完毕");
//            //里面的元素
//            if(files.length!=0){
//                for(File f:files){
//                    this.superCopyFile(f,newPath);
//                }
//            }
//        }else{//file是一个文件  没有子元素  不需要数组对象
//            //创建两个文件流 分别读取旧的file和写入新的newFile
//            FileInputStream fis = null;
//            FileOutputStream fos = null;
//            try {
//                fis = new FileInputStream(file);
//                fos = new FileOutputStream(newFile);
//                byte[] b = new byte[1024];
//                int count = fis.read(b);
//                while(count!=-1){
//                    fos.write(b,0,count);
//                    fos.flush();
//                    count = fis.read(b);//别忘了再读一遍
//                }
//                System.out.println(newFile.getName()+"文件复制完毕");
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if(fis!=null) {
//                        fis.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    if(fos!=null) {
//                        fos.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    public static void main (String[] args){
        Test t = new Test();
        //t.copyFile(new File("C://AppData//Test.txt"),"D://java//aaa");
        t.superCopyFile(new File("C://Users//Test"),"D://java");
    }
}
