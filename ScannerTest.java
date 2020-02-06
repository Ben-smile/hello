package classtest;

import java.util.Scanner;

public class ScannerTest {
    //1.所属的包java.util包  需要import导包
    //2.通过一个带输入流的构造方法创建对象(System.in)
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        input.nextLine(); //以回车符作为结束 并且读取掉回车符并扔掉
        input.next();
        //1、一定要读取到有效字符后才可以结束输入。
        //2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
        //3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
        //next() 不能得到带有空格的字符串
        input.nextFloat(); //以回车符结束 但不会读取掉回车符
        input.nextInt();//以回车符结束 但不会读取掉回车符
        //String类  "abc"是对象  在常量区
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s3==s4);//false
        System.out.println(s1.equals(s2));//true   String类将继承自Object中的equals方法重写啦
        System.out.println(s1.equals(s3));//true   将原有比较==的方式改为比较字符值
        System.out.println(s3.equals(s4));//true

    }


}
