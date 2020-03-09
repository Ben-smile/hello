package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class CountryDao {


    private String forname = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/unitequery";
    private String user = "root";
    private String password =  "root";

    //2.查询每个国家的城市个数 按照城市个数升序排列
    //是否需要参数--->不需要
    //是否需要返回值--->返回 国家名字和城市数目 因为城市数目不属于 原有的列 所以用map
    // ArrayList<map<String,String>>

    public ArrayList<HashMap<String,String>> selectNum2 (){
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        String sql = "select cname,count(cityid) as citycount from country ct\n" +
                "inner join area a on ct.cid = a.cid\n" +
                "inner join city c on a.aid = c.aid\n" +
                "group by cname;";
        try {
            Class.forName(forname);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                HashMap<String,String> map = new HashMap<>();
                map.put("cname",rs.getString("cname"));
                map.put("citycount",rs.getString("citycount"));
                list.add(map);
            }

            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
