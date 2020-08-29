package pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 这个类是为了读取properties配置文件而设立的
 * 整个项目启动的时候读取一次就够了
 * 将文件中的数据临时的存储在一个Map集合中------缓存
 */
public class ConfigurationReader {

    //属性----缓存
    private static Map<String,String> map = new HashMap<String,String>();

    //在类加载的时候 一次性读取文件中的所有数据 存入map集合
    static{
        try {
            Properties pro = new Properties();//本身来讲是一个map集合  读取数据是文件中的
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.properties");
            pro.load(inputStream);
            //读取文件中的全部内容----相当于对文件做了个遍历
            Enumeration en = pro.propertyNames();//相当于是map集合的keySet()方法
            //en的使用方式类Iterator  ResultSet
            while(en.hasMoreElements()){
                String key = (String)en.nextElement();
                String value = pro.getProperty(key);//相当于是map集合的get方法
                map.put(key,value);//文件数据存储在临时的缓存集合中
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //提供一个方法 可以从缓存map集合中获取元素
    public static String getStringValue(String key){
        return map.get(key);
    }
    public static int getIntValue(String key){
        return Integer.parseInt(map.get(key));
    }
}
