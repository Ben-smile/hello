package util;

import java.util.HashMap;

public class MySpring {

    //设计这个类 用来创建并管理对象
    //IOC 利用反射机制
    //实现多个类的单例模式


    //静态属性 保证只有一个
    private static HashMap<String,Object> domain = new HashMap<>(); //用来储存创建出来的对象

    public static Object getBean(String className){ //静态方法不用创建对象
        Object obj = null;
        try {    //如果要创建对象 先判断集合内有没有 如果有就将集合内的对象引用返回
            obj = domain.get(className);
            if (obj == null){  //如果没有 就创建一个对象
                Class clazz = Class.forName(className);
                obj = clazz.newInstance();
                domain.put(className,obj);  //将第一次创建的对象存入集合
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
