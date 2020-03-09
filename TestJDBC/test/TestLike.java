
package test;

import domain.Atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TestLike {
    //设计一个方法 用来模糊查询

    public ArrayList<Atm> selectLike(String letter){
        ArrayList<Atm> arrayList = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "root";
        String password = "root";
        String sql = "SELECT ANAME,APASSWORD,ABALANCE FROM ATM WHERE ANAME like ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,"%"+letter+"%");
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                Atm atm = new Atm();
                atm.setAname(rs.getString("aname"));
                atm.setApassword(rs.getString("apassword"));
                atm.setAbalance(rs.getFloat("abalance"));
                arrayList.add(atm);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
