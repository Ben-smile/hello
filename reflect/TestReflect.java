package reflect;

import java.lang.reflect.Field;

public class TestReflect {

    public static void main(String[] args){

        String str = "abc";
        System.out.println(str);
        Class clazz = String.class;  //获取String类的对象
        try {
            Field f = clazz.getDeclaredField("value"); //获取String类的value属性
            f.setAccessible(true); //设置允许访问私有属性
            char[] c = (char[])f.get(str);  //得到str的value数组 注意得造型
            c[0]= '我';
            c[1] = '是';
            c[2] = '谁';
            System.out.println(str);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
