package JDBCPool;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {


    //创建 一个类  用来获取连接 并创建 状态的属性
    private Connection conn;

    //用false 来表示 空闲  true 来表示 占用
    private boolean state = false;


    //属性不能处理异常所以获取连接在块里


    //加载驱动 一份
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getConn() {
        return conn;
    }


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
