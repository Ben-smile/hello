package dao;

import domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/shopping?serverTimezone=CST";
    private String user = "root";
    private String password = "root";

    //设计一个查询单条记录的方法
    public User selectOne(String uname){
        User result = null;
        String sql = "SELECT UNAME,UPASSWORD FROM USER WHERE UNAME = ?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,uname);
            ResultSet rs = pstat.executeQuery();
            if(rs.next()){
                result = new User();
                result.setUname(rs.getString("uname"));
                result.setUpassword(rs.getString("upassword"));
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
