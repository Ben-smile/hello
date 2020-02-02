package math;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args){
        //Random 类属于 java.util包 需要导包
        //没有任何继承关系 默认继承 Object类
        //可以创建对象
        //专门 用来产生随机数
        Random r = new Random();
        r.nextInt();//随机产生 int范围的整数 有正有负
        r.nextInt(10);//方法重载 随机产生[0,bound)的整数 没有负数
        r.nextFloat();//随机产生 [0.0,1.0)
        r.nextBoolean(); // 随机产生 boolean值 true/false
        //我们如果要产生小数 为了不丢失精度 整数用整数 小数用小数 相加
        //随机产生 0.0-0.9 之间的随机数
        System.out.println(r.nextInt(10)+r.nextFloat());
    }
}
