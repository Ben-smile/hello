package math;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerTest {

    public static void main(String[] args){
        //属于 java.math包 需要导包
        //继承Number类
        //构造方法都是带参数的 我们通常利用 带String 参数的构造方法创建对象
        //大整数  理论上能够表示无限大的数 只要内存足够
        BigInteger bi = new BigInteger("123");
        //常用方法  用来做四则运算  返回值类型为 BigInteger类型
        bi.add(bi);//加
        bi.subtract(bi);//减
        bi.multiply(bi);//乘
        bi.divide(bi);//除


        //BigDecimal 类 大浮点数  属于java.math包
        //继承Number类
        //通常也是用带String类型的参数 构架对象

        BigDecimal bigDecimal = new BigDecimal("12.32");
        bigDecimal.setScale(2,BigDecimal.ROUND_DOWN);  //对象.setScale 方法可以处理小数点后的位数
        //第一个数表示需要保留 小数点后几位
        //第二个数通过类名调用静态常量  roundingMode 模式(ceil向上取整.....)
    }
}
