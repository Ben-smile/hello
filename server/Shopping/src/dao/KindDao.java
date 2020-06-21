package dao;

import domain.Kind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KindDao {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/shopping?serverTimezone=CST";
    private String user = "root";
    private String password = "root";

    //查询全部种类数据
    public ArrayList<Kind> selectAllKind(){
        ArrayList<Kind> kindList = new ArrayList<Kind>();
        String sql = "SELECT KID,KNAME FROM KIND";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                Kind kind = new Kind();
                kind.setKid(rs.getInt("kid"));
                kind.setKname(rs.getString("kname"));
                kindList.add(kind);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kindList;
    }

}
