package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class TestJDBC {

    public static void main(String[] args){
        //1.导包

        try {
            //2.加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //3.创建连接
            String url ="jdbc:mysql://localhost:3306/test" ;
            String user = "root";
            String password = "root";
            Connection conn = DriverManager.getConnection(url,user,password);

            //4.创建 状态参数
            Statement stat =  conn.createStatement();
            //5.执行操作
            stat.executeUpdate("update person set salary = 100 where username = '苟犇'");

            //6.关闭 (先创建的后关闭)
            stat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HashSet set = new HashSet();
        
    }
}
