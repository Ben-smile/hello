package test;

import java.sql.*;
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
            //stat.executeUpdate("update person set salary = 100 where username = '苟犇'");
            //查询操作  Query  返回值 是一个结果集
            ResultSet rs =  stat.executeQuery("select *from person");
            while(rs.next()){
                String name = rs.getString("username");
                String address = rs.getString("address");
                int s = rs.getInt("salary");
                String dept =  rs.getString("department");
                System.out.println(name + "-"+address+"-"+s+"-"+dept);
            }
            //6.关闭 (先创建的后关闭)
            rs.close();
            stat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
