package dao;

import domain.Atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AtmDao {

    //持久层   负责数据的读写  全都是纯粹的JDBC  SQL

    //如上的项目部署过程如果理解的话  注意导入.jar文件的时候与之前的操作不一致
    //需要将.jar文件放置在web文件夹下的WEB-INF文件夹下
    //创建lib文件夹  将需要的.jar文件存入

    public Atm selectOne(String aname){
        Atm atm = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/atm?serverTimezone=CST";
        String user = "root";
        String password = "root";
        String sql = "SELECT ANAME,APASSWORD,ABALANCE FROM ATM WHERE ANAME = ?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,aname);
            ResultSet rs = pstat.executeQuery();
            if(rs.next()){
                //将结果集中的信息取出来 存入另一个小容器内(domain对象)
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
}
