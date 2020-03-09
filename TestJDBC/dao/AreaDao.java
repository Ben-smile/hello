package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class AreaDao {
    private String forname = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/unitequery";
    private String user = "root";
    private String password =  "root";

    //1.设计一个方法 查询人口数在1000到2000之间的城市所属在哪个地区
    //是否需要参数----> 区间 数有可能变化
    //是否需要返回值---> 需要 返回地区名 ArrayList<String>

    public ArrayList<String> selectNum1 (int begin,int end){
        ArrayList<String> list = new ArrayList<String>();

        String sql = "select distinct aname from area a \n" +
                     "inner join city c on a.aid = c.aid\n" +
                     "where c.citysize between ? and ?;";
        try {
            Class.forName(forname);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1,begin);
            pstat.setInt(2,end);
            ResultSet rs = pstat.executeQuery();

            while(rs.next()){
                list.add(rs.getString("aname"));
            }

            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }




    //3.查询各地区城市人口平均数 按照人口平均数降序排列
    //是否需要参数-----> 不需要
    //是否需要返回值 ---> 需要 返回地区名 及地区平均人数

    public ArrayList<HashMap<String,String>> selectNum3 (){
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        String sql = "select aname,avg(citysize) as avgcitysize from city c\n" +
                     "inner join area a on c.aid = a.aid\n" +
                     "group by aname order by avg(citysize) desc;";
        try {
            Class.forName(forname);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                HashMap<String,String> map = new HashMap<>();
                map.put("aname",rs.getString("aname"));
                map.put("avgcitysize",rs.getString("avgcitysize"));
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
