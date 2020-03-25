package pool;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 这个类是我自己描述的       10个MyConnection
 * 他的目的是为了将一个真实连接和一个状态绑定在一起
 * 这个类中的每一个对象   都有一个真实连接并且绑定着一个状态
 */
public class MyConnection {

    //真实连接
    private Connection connection;
    //连接的状态     false表示空闲(可用)   true表示被占用(不能用)
    private boolean used = false;

    //下面那些加载驱动和创建连接需要的字符串
    private static String driver = ConfigurationReader.getStringValue("driver");
    private static String url = ConfigurationReader.getStringValue("url");
    private static String username = ConfigurationReader.getStringValue("username");
    private static String password = ConfigurationReader.getStringValue("password");


    //静态块目的     为了让加载驱动这件事情只执行一次
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //一般块的目的    为了给connection属性赋值   属性中不能处理异常
    {
        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //以下是两个私有属性对应的get和set方法
    public Connection getConnection() {
        return connection;
    }
    public boolean isUsed() {//特殊写法的规约 属性是boolean get方法叫做isXxx
        return used;
    }
    public void setUsed(boolean used) {
        this.used = used;
    }

}
