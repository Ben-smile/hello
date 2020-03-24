package JDBCPool;

import java.sql.*;

public class Test {

    public static void main(String[] args){

        String name = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";
        String sql = "select username from person";
        //1.导包

//        try {
//            //2.加载驱动
//            Class.forName(name);
//            //3.获取连接
//            Connection conn = DriverManager.getConnection(url,user,password);
//            //4.获取状态参数
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            //5.执行数据库操作
//            ResultSet rs = pstat.executeQuery();
//            while(rs.next()){
//                String username = rs.getString("username");
//                System.out.println(username);
//            }
//            //6.关闭
//            rs.close();
//            pstat.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
            long time4 = System.currentTimeMillis();
            ConnectionPool cp = new ConnectionPool();
        try {

            MyConnection mc = cp.getConnection();
            Connection conn = mc.getConn();
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                String username = rs.getString("username");
                System.out.println(username);
            }
            rs.close();
            pstat.close();
            mc.setState(false);
            long time5 = System.currentTimeMillis();
            long  time6 = time5 - time4;
            System.out.println(time6);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            long time1 = System.currentTimeMillis();
            MyConnection mc = cp.getConnection();
            Connection conn = mc.getConn();
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                String username = rs.getString("username");
                System.out.println(username);
            }
            rs.close();
            pstat.close();
            mc.setState(false);
            long time2 = System.currentTimeMillis();
            long time3= time2 - time1;
            System.out.println(time3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
