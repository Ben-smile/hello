package util;



import java.util.HashMap;

public class MySpring {

    //这个类用来管理dao  service 层对象的产生
    //IOC  生命周期托管方式实现对象的单例
    //我们认为dao  service层没有属性的冲突 为了减少资源的使用让对象变成一份

    //静态  集合只有一份
    private static HashMap<String, Object> beanBox = new HashMap<>();
    //利用一个map集合 来存储已经创建的对象 <String path,obj>


    //方法静态 可以直接用类名来调  不用创建对象
    public static <T>T getBean(String path){  //通过 类全名 用反射调用无参的构造方法来创建对象
        //1.直接从集合里面取
        T obj = (T)beanBox.get(path);

        try {
            //2.判断obj是否为空 如果为空就创建一个对象
            if(obj == null) {
                //3.利用类全名来获取类
                Class clazz = Class.forName(path);

                obj = (T) clazz.newInstance();

                beanBox.put(path,obj);//将第一次创建的对象 存入集合
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回 obj

        return obj;
    }
}
