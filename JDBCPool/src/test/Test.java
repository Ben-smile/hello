package test;

import JDBCPool.ConnectionPool;
import JDBCPool.MyConnection;

import java.sql.*;

public class Test {

    public static void main(String[] args){

        String sql = "select username from person";
        //1.导包

        try {
            //2.加载驱动
            //Class.forName(name);
            //加载配置文件
            ConnectionPool pool = ConnectionPool.getInstance();



            //3.获取连接
            Connection conn = pool.getConnection();
            //4.获取状态参数
            PreparedStatement pstat = conn.prepareStatement(sql);
            //5.执行数据库操作
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                String username = rs.getString("username");
                System.out.println(username);
            }
            //6.关闭
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
