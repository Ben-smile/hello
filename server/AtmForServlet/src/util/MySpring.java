package util;

import java.util.HashMap;

public class MySpring {

    //对象的管理  单例模式的体现

    private static HashMap<String,Object> beanMap = new HashMap<String,Object>();

    public static <T>T getBean(String className){
        T obj = (T)beanMap.get(className);
        if(obj==null){
            try {
                Class clazz = Class.forName(className);
                obj = (T)clazz.newInstance();
                beanMap.put(className,obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
