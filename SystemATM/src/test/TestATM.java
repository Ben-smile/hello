package test;

import domain.Atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestATM {

    //设计一个方法  连接数据库 获取一行用户名对应的atm表中 信息

    public Atm selectOne(String aname){
        Atm atm = null;
        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "zzt";
        String password = "123";
        String sql = "SELECT ANAME,APASSWORD,ABALANCE FROM ATM WHERE ANAME = '"+aname+"'";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url,user,password);
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if(rs.next()){
                //证明用户名存在 查询到了一行记录  返回值?
                //将结果集内的数据取出来 数据存在一个容器里  对象domain
                atm = new Atm();
                atm.setAname(rs.getString("aname"));
                atm.setApassword(rs.getString("apassword"));
                atm.setAbalance(rs.getFloat("abalance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(stat!=null) {
                    stat.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return atm;
    }
}
