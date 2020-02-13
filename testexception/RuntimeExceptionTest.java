package testexception;

import com.sun.javaws.exceptions.ErrorCodeResponseException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class RuntimeExceptionTest {
    public static void main (String[] args) throws Exception {
       /* 异常/错误
        程序运行过程中，可能会发生一些不被期望的效果，肯定会阻止我们的程序按照指令去执行
        这种不被预期出现的效果，肯定需要抛出来告诉我们

        在Java中有一个定义好的规则Throwable（可以抛出的）

 Error错误
        通常是一些物理性的，JVM虚拟机本身出现的问题，程序指令是处理不了的

                Exception异常
        通常是一种人为规定的不正常的现象，通常是给定的程序指令产生了一些不符合规范的事情

                Throwable类 实现了一个序列化接口
        Error(错误)			      Exception(异常)
     StackOverflowError(栈内存溢出)		 RuntimeException(运行时)   IOException。。。。。
     OutOfMemoryError(堆内存溢出)

                异常的分支体系
        运行时异常(非检查异常)
        Error和RuntimeException都算作运行时异常
        javac编译的时候，不会提示和发现的，
        在程序编写时不要求必须做处理，如果我们愿意可以添加处理手段(try throws)
        要求大家出现这样异常的时候 知道怎么产生及如何修改
        1.InputMisMatchException 输入不匹配
            int value = input.nextInt();//   abc
		*2.NumberFormatException 数字格式化
            int value = Integer.parseInt("123.45");
        3.NegativeArraySizeException 数组长度负数
            int[] array = new int[-2];
		*4.ArrayIndexOutOfBoundsException 数组索引越界
            int[] array = {1,2,3};
            array[5];
		*5.NullPointerException 空指针异常
            int[][] array = new int[3][];
            array[0][0] =10;
            Person p = null;
            p.getName();
        6.ArithmeticException 数字异常
            10/0	整数不允许除以0	Infinity小数除以0会产生无穷
		*7.ClassCastException 造型异常
            Person p = new Teacher();
            Student s = (Student)p;
		*8.StringIndexOutOfBoundsException 字符串越界
            String str = "abc";
            str.charAt(5);
		*9.IndexOutOfBoundsException 集合越界
        List家族
        ArrayList  list = new ArrayList();
        list.add(); list.add(); list.add();
        list.get(5);
        10.IllegalArgumentException 非法参数异常
        ArrayList  list = new ArrayList(-1);
 编译时异常(检查异常)
        除了Error和RuntimeException以外其他的异常
        javac编译的时候  强制要求我们必须为这样的异常做处理(try或throws)
                因为这样的异常在程序运行过程中极有可能产生问题的
        异常产生后后续的所有执行就停止啦

     处理异常的手段:

        1.try{}}catch(){}finally{}
            try{
                Thread.sleep(5000);
            }catch(Exception e){

            }
            1.try不能单独出现 后面必须跟着一个其他的结构 catch或者finally 否可以
            2.catch可以出现多个 多个要捕获的异常没有继承关系否则先捕获大的 再捕获小的
            3.finally可有可无 若添加了这个结构 则必须执行 即便是放在方法中 之前有return 也会执行
            4.方法内部返回值
            5.final(特征修饰符) finally(块) finalize(方法) 的区别
        2. throws
            1.只能在方法结构上存在(抛出异常)
            2.谁调用此方法 谁处理异常
            3.抛出的异常可以有多个 用,来隔开
     自定义异常:
            1.写一个类 继承Exception(若继承此 则为编译时异常必须处理)
                      继承RuntimeException 则为运行时异常 可以不用处理
            2.类中可以写带String 参数的构造方法 可以做细致的说明(通过super 来传递给父类)
            3.new一个自定义异常的对象   通过throw关键字来抛出
        */

    }
}
