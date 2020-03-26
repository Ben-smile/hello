package pool;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * 这个类是我自己描述的       10个MyConnection
 * 他的目的是为了将一个真实连接和一个状态绑定在一起
 * 这个类中的每一个对象   都有一个真实连接并且绑定着一个状态
 */
public class MyConnection extends AbstractConnection{

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

    //==============================================================

    @Override
    public Statement createStatement() throws SQLException {
        return this.connection.createStatement();
    }
    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        //需要这个自己的子类中真正的做事
        //需要创建一个状态参数
        //  1.抄一下  别人的C 自己的V    原来的代码是哪个类的呢???
        //  Connection conn = DriverManager.getConnection();//多态
        //  Class clazz = conn.getClass();//
        //  String className = clazz.getName();//   JDBC4Connection
        //  即便是反射获取了这个类   想要抄的是源代码   导入的那个.jar里面的字节码文件
        //  2.继承JDBC4Connection
        //  super调用了
        //  是否能继承   这个类是否有final修饰   这个类的修饰符是不是public
        //  3.找人帮忙---找那个真实会做事的人来帮忙  JDBC4Connection类的对象
        PreparedStatement pstat = this.connection.prepareStatement(sql);
        return pstat;
    }
    @Override
    public void close() throws SQLException {
        this.used = false;//释放连接
    }

}
