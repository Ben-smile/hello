package dao;

import domain.Emp;
import service.EmpService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpDao {
    private String forname = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test";
    private String user = "root";
    private String password =  "root";


    //设计一个方法 用来分页查询 每页显示 5行

    public ArrayList<Emp> selectLimit(int rowIndex){ //用户传入 指定的页数
        ArrayList<Emp> list = new ArrayList<>();

        String sql = "SELECT *FROM EMP ORDER BY SAL DESC LIMIT ?,5";
        try {
            Class.forName(forname);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1,rowIndex);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                Emp emp =  new Emp();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHiredate(rs.getDate(5));
                emp.setSal(rs.getFloat(6));
                emp.setComm(rs.getFloat(7));
                emp.setDeptno(rs.getInt(8));
                list.add(emp);
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
