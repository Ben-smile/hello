package math;

import java.text.DecimalFormat;

public class DecimalFormatTest {
    public static void main(String[] args){
        //DecimalFormat 类 所属java.test包
        //小数点前和小数点之后的位数都能处理 ------>格式化
        //通过带String 参数的构造方法创建一个格式化对象  0  #
        //0 表示必须存在 #表示可有可无
        DecimalFormat df = new DecimalFormat("000.###");
        String value = df.format(12.4556);
        //若超过规定的位数 四舍五入 不够会添加0
        System.out.println(value);//012.456
        }
}
