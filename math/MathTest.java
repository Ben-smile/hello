package math;

public class MathTest {
    public static void main (String[] args){
        //Math类属于 java.lang包  不用导包
        //Math类的构造方法是私有的 我们不能直接创建对象
        //Math类中提供的属性和方法都是静态static  不需要创建对象
        int value = Math.abs(-1); //返回给定数字的绝对值
        double value1= Math.ceil(2.5);    //向上取整  3.0
        double value2 = Math.floor(2.5);   //向下取整 2.0
        double value3 = Math.rint(2.5);   //临近的整数  如果两边距离一样 则返回偶数 2.0
        int value4 = Math.round(2.5f);    //四舍五入的整数 3
        double value5 = Math.round(2.5);  //3.0
        int value6 = Math.max(1,4);   //比较两个相同类型数字的大小 4
        double value7 = Math.min(2.0,2.5);// 2.0
        double value8 = Math.pow(2,5);  //2的5次方 参数double 返回值double 32.0
        double value9 = Math.sqrt(25); //获取给定参数的平方根 参数double 返回值double 5.0
        double value10 = Math.random();   //随机获取一个随机数 [0.0,1.0) 左闭右开

        System.out.println(value10);


    }
}
