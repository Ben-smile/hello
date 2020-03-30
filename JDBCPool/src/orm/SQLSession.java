package orm;


import JDBCPool.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * 用来处理方法二中 sql解析 和 问号赋值
 */
public class SQLSession {

    private Handler handler = new Handler();

    //方式一
    // 不传domain对象 直接传值 依次赋值
//    public void MyUpdate(String sql,Object...objs){
//        try {
//            //1.导包
//            //2.配置文件
//            ConnectionPool pool = ConnectionPool.getInstance();
//            //3.获取连接
//            Connection conn = pool.getConnection();
//            //4.获取状态参数
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            if(objs != null) {
//                for (int i = 0; i < objs.length; i++) {
//                    pstat.setObject(i + 1, objs[i]);
//                }
//            }
//            //5.执行sql
//            pstat.executeUpdate();
//            //6.关闭连接
//            pstat.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

//    public void insert(String sql,Object...objs){
//        this.MyUpdate(sql,objs);
//    }
//    public void delete(String sql,Object...objs){
//        this.MyUpdate(sql,objs);
//    }
//    public void update(String sql,Object...objs){
//        this.MyUpdate(sql,objs);
//    }

//===============================================================================
    //方式二
    //  方式一的问题
    //  1.动态参数列表 可读性不高
    //  2.参数必须有顺序
    //  为了解决问题 我们仍然采用 传递domian 对象方式
    // 为了解决 问好赋值的问题 我们改变规则 让用户传递sql时将 ? 替换成#{属性名} 方式
    public void Update (String sql,Object obj){
        //String sql = "insert into student values(#{sid},#{sname},#{ssex},#{sage})"
        //   首先 得解析sql  将我们定义规则的sql  变成正常的sql 交给PreparedStatement预处理
        //   再得到 每一个#{属性名}  里面的属性名(key)  通过反射找到obj里面的属性值 赋给问号
        // 0. 设计一个方法 用来解析sql
        SQLAndKey result = handler.parseSQL(sql);
        //获得了 正常的sql  和  所有的属性名

        try {
            //1.导包
            //2.配置文件
            ConnectionPool pool = ConnectionPool.getInstance();
            //3.获取连接
            Connection conn = pool.getConnection();
            //4.获取状态参数
            PreparedStatement pstat = conn.prepareStatement(result.getSQL());
            //5.给问号赋值
            if(obj != null){
                //赋值 设计一个方法
                handler.handleParameter(sql,result.getKeys(),obj,pstat);
            }
            //6.执行sql
            pstat.executeUpdate();
            //7.关闭连接
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void delete (String sql,Object obj){
        this.Update(sql,obj);
    }
    public void insert (String sql,Object obj){
        this.Update(sql,obj);
    }


}
