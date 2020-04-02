package pool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个用来管理连接的类
 * 连接默认先创建10个----->放在一个集合里
 * 用户使用的时候  去集合里寻找可用连接拿去使用啦
 */
public class ConnectionPool {

    //实现一个单例设计模式
    //1.构造方法私有
    private ConnectionPool(){}
    //2.私有静态的当前类对象作为属性
    private static volatile ConnectionPool connectionPool;//延迟加载机制
    //3.共有静态的方法返回当前对象
    public static ConnectionPool getInstance(){
        if(connectionPool == null){
            synchronized(ConnectionPool.class) {
                if(connectionPool == null) {
                    connectionPool = new ConnectionPool();//创建对象内存中3个指令
                }
            }
        }
        return connectionPool;
    }

    private static final int DEFAULT_CONNECTION = 10;
    //属性---集合
    private List<Connection> connectionList = new ArrayList<Connection>();

    //设计一个块
    {
        int count = 0;
        String minCount = ConfigurationReader.getStringValue("minCount");
        if(minCount==null){
            count = DEFAULT_CONNECTION;
        }else{
            count = Integer.parseInt(minCount);
            System.out.println("创建时采用配置文件中的数据"+count+"个");
        }
        for(int i=1;i<=count;i++){
            connectionList.add(new MyConnection());
        }
    }

    //需要给用户提供一个方法   获取一个可用连接的
    //  参数      没有
    //  返回值    MyConnection
    private synchronized Connection getMC(){
        Connection result = null;
        for(int i=0;i<connectionList.size();i++){
            //去连接池中 每次循环获取一个连接·
            MyConnection mc = (MyConnection) connectionList.get(i);
            //判断mc的状态
            if(mc.isUsed() == false){//当前获取的连接是空闲
                mc.setUsed(true);//据为己有
                result = mc;
                break;
            }
        }
        return result;
    }

    //为了让用户体验更好 添加一个排队等待的机制
    //  5秒钟比较合适
    public Connection getConnection(){
        Connection result = this.getMC();
        int count = 0;
        while(result==null && count<ConfigurationReader.getIntValue("waitTime")*10){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = this.getMC();
            count++;
        }
        if(result == null){//等待5秒后还是没有连接
            //1.输出告诉用户
            //2.自定义异常告诉用户   系统正忙 请刷新重试
            throw new ConnectionPoolBusyException("系统正忙 请刷新重试");
        }
        return result;
    }


}
