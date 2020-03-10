package dao;

import domain.Atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AtmDao {

    //dao层负责 数据的增删改查 不负责逻辑处理
    private String driver = "com.mysql.jdbc.Driver";
    private  String url = "jdbc:mysql://localhost:3306/atm?useUnicode=true&characterEncoding=utf-8";
    private String user = "root";
    private String password = "root";
    private String sql = "SELECT ANAME,APASSWORD,ABALANCE FROM ATM WHERE ANAME = ?";


//设计一个方法  连接数据库 获取一行用户名对应的atm表中 信息

    public Atm selectOne(String aname){
        Atm atm = null;


        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,aname);
            ResultSet rs = pstat.executeQuery();
            if(rs.next()){
                atm = new Atm();
                atm.setAname(rs.getString("aname"));
                atm.setApassword(rs.getString("apassword"));
                atm.setAbalance(rs.getFloat("abalance"));
            }

            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return atm;
    }

    //设计一个方法 新增一行记录
    public int insert(Atm atm){
        int count = 0;//数据库更改的行数==1
        String sql = "INSERT INTO ATM VALUES(?,?,?)";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,atm.getAname());
            pstat.setString(2,atm.getApassword());
            pstat.setFloat(3,atm.getAbalance());
            count = pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    //设计一个方法 做数据库更新
    public int update(Atm atm){
        int count = 0;//记录更改的行数
        String sql = "UPDATE ATM SET APASSWORD = ? , ABALANCE = ? WHERE ANAME = ?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,atm.getApassword());
            pstat.setFloat(2,atm.getAbalance());
            pstat.setString(3,atm.getAname());
            count = pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    //设计一个方法 删除记录
    public int delete(String aname){
        int count = 0;//数据库更改的行数==1
        String sql = "DELETE FROM ATM WHERE ANAME = ?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,aname);
            count = pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
