package math;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args){
        //UUID 属于java.util包  需要导包
        //没有任何继承关系 默认继承Object类
        //有构造方法 没有无参数的 我们一般不会创建对象
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
        //数据库表格主键  primary key
        //随机产生一个 32位的随机元素 每一个位置是一个 十六进制的数字

    }
}
