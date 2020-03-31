package orm;

import pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("all")
public class SqlSession {

    private Handler handler = new Handler();

    //负责读写数据库
    //类中全部都是纯粹的JDBC操作+SQL语句

    //封装一个方法 负责支持增删改的操作
    //  是否有参数2个  String sql ????? , sql语句上面的值
    //  是否有返回值   void
    //  方案一     SpringJDBC
    public void update(String sql,Object... objs){
        try {
            //1.导包
            //2.加载驱动 做配置 driver url username password
            //3.连接池对象
            ConnectionPool pool = ConnectionPool.getInstance();
            //4.获取连接
            Connection connection = pool.getConnection();
            //5.状态参数
            PreparedStatement pstat = connection.prepareStatement(sql);
            //6.将SQL语句和那些问号值组装完整
            //      ?值有几个   不确定  Student对象   student.getSid();   Teacher对象
            //      当前这个小弟除了能为下面学生的增删改支持    支持别人

            //      问号的值不止一个  中间有个包装对象的过程  我们这里还需要拆开
            //      一包一拆产生一个domain类型的问题  类型不通用
            //      1.不包装了(中间不产生那个domain类型)  数组Object[]
            for(int i=0;i<objs.length;i++){
                pstat.setObject(i+1,objs[i]);
            }
            //7.组合完毕 可以执行了
            pstat.executeUpdate();
            //8.关闭
            pstat.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert(String sql,Object... objs){this.update(sql,objs);}
    public void delete(String sql,Object... objs){this.update(sql,objs);}
    //  上述方案有两个不好的地方
    //  1.传递objs数组里面的值有顺序
    //  2.objs参数可读性不强---->都是一个domain对象来的  为了中间不造型  退而求其次  改成了数组  Object[]

    //  方案一 查询单条
    //  参数  1.String sql  2.SQL语句上的值Object...
    //  返回值  Object
    //  select * from student where sid = ? and sname = ?   Student对象
    //  这个方法是支持着以后任何一个表格的单条查询
    //  任何一个单条查询之间有什么区别???  SQL不一样 SQL上的值不一样
    //  上述两个不一样已经解决了(通过参数解决)
    //  以后的任何一个查询单条 流程都是固定的  就中间的组合对象不同
    //      策略模式    银行 老太太
    public <T> T selectOne(String sql,RowMapper rm,Object... objs){//流程
        return (T)this.selectList(sql,rm,objs).get(0);



//        Object obj = null;
//        try {
//            //1.导包
//            //2.加载配置文件
//            //3.获取连接池对象
//            ConnectionPool pool = ConnectionPool.getInstance();
//            //4.获取连接
//            Connection connection = pool.getConnection();
//            //5.创建状态参数
//            PreparedStatement pstat = connection.prepareStatement(sql);
//            //6.拼接sql和问号信息
//            for(int i=0;i<objs.length;i++){
//                pstat.setObject(i+1,objs[i]);
//            }
//            //7.RS = 执行查询操作
//            ResultSet rs = pstat.executeQuery();
//            //8.处理结果集(将结果集的数据取出来 放在一个domain对象中)
//            if(rs.next()){
//                //将结果集的数据取出来 放在一个domain对象中
//                //  解决方案3，策略模式
//                obj = rm.mapperRow(rs);//按照这个规则组装
//            }
//            //      解决方案 1.不要domain类型 用map取代
//            //结果集的全部列获取出来
////            Map map = new HashMap();
////            ResultSetMetaData rsmd = rs.getMetaData();
////            for(int i=1;i<rsmd.getColumnCount();i++){
////                String columnName = rsmd.getColumnName(i);
////                Object value = rs.getObject(columnName);
////                map.put(columnName,value);
////            }
//            //      解决方案 2.分析SQL语句from关键字后面的表名字----反射
//            //9.关闭  结果集  状态参数  连接"关闭"(释放)
//            rs.close();
//            pstat.close();
//            connection.close();//底层是一个释放
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (T)obj;
    }
    public <T> List<T> selectList(String sql, RowMapper rm, Object... objs){//流程
        List<T> list = new ArrayList();
        try {
            //1.导包
            //2.加载配置文件
            //3.获取连接池对象
            ConnectionPool pool = ConnectionPool.getInstance();
            //4.获取连接
            Connection connection = pool.getConnection();
            //5.创建状态参数
            PreparedStatement pstat = connection.prepareStatement(sql);
            //6.拼接sql和问号信息
            for(int i=0;i<objs.length;i++){
                pstat.setObject(i+1,objs[i]);
            }
            //7.RS = 执行查询操作
            ResultSet rs = pstat.executeQuery();
            //8.处理结果集(将结果集的数据取出来 放在一个domain对象中)
            while(rs.next()){
                //将结果集的数据取出来 放在一个domain对象中
                //  解决方案3，策略模式
                T obj = (T)rm.mapperRow(rs);//按照这个规则组装
                list.add(obj);
            }
            //      解决方案 1.不要domain类型 用map取代
            //结果集的全部列获取出来
//            Map map = new HashMap();
//            ResultSetMetaData rsmd = rs.getMetaData();
//            for(int i=1;i<rsmd.getColumnCount();i++){
//                String columnName = rsmd.getColumnName(i);
//                Object value = rs.getObject(columnName);
//                map.put(columnName,value);
//            }
            //      解决方案 2.分析SQL语句from关键字后面的表名字----反射
            //9.关闭  结果集  状态参数  连接"关闭"(释放)
            rs.close();
            pstat.close();
            connection.close();//底层是一个释放
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //===================================================================================

    //方案二       MyBatis
    public void update(String sql,Object obj){//obj--->domain对象  Student
        try {
            //0.需要将用户提供给我们的特殊结构的SQL先做一个解析
            //  SQL语句上有问号  不止一个        问号本身没有名字
            //  insert into student values(#{sid},#{sname},#{ssex},#{sage});
            //  obj对象中属性的值给某一个问号附上  反射找到属性名字
            //  解析这个SQL语句
            //  1.将这个SQL中的4个key获取出来
            //  2.将这个SQL中的4个key替换成四个问号

            //调用小弟解析
            SQLAndKey sqlAndKey = handler.parseSQL(sql);
            //1.导包
            //2.加载驱动 做配置 driver url username password
            //3.连接池对象
            ConnectionPool pool = ConnectionPool.getInstance();
            //4.获取连接
            Connection connection = pool.getConnection();
            //5.状态参数
            PreparedStatement pstat = connection.prepareStatement(sqlAndKey.getSQL());
            //6.将SQL语句和那些问号值组装完整---反射
            //  pstat已经拿到了一条带有问号的sql
            //  pstat负责的事情是将新的sql和obj对象中的值组合在一起
            if(obj!=null){
                handler.handleParameter(pstat,obj,sqlAndKey.getKeyList());
            }
            //7.组合完毕 可以执行了
            pstat.executeUpdate();
            //8.关闭
            pstat.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insert(String sql,Object obj){this.update(sql,obj);}
    public void delete(String sql,Object obj){this.update(sql,obj);}

    //参数1.sql  参数2.sql上面的值  参数3.查询以后的返回结果
    public <T> T selectOne(String sql,Object obj,Class resultType){
        Object result = null;
        try {
            //sql--select sid from student where sid = #{sid} and sname = #{sname}
            //1.解析sql
            SQLAndKey sqlAndKey = handler.parseSQL(sql);
            //2.获取连接
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            //3.状态参数
            PreparedStatement pstat = connection.prepareStatement(sqlAndKey.getSQL());
            //4.把sql和问号拼接在一起
            if(obj!=null){
                handler.handleParameter(pstat,obj,sqlAndKey.getKeyList());
            }
            //5.执行操作
            ResultSet rs = pstat.executeQuery();
            //6.处理结果(将结果集的值取出来 存入一个domain对象)
            if(rs.next()){
                result = handler.handleResult(rs,resultType);
            }
            //7.关闭
            rs.close();
            pstat.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T)result;
    }
    public <T> List<T> selectList(String sql,Object obj,Class resultType){
        List<T> list = new ArrayList<T>();
        try {
            //sql--select sid from student where sid = #{sid} and sname = #{sname}
            //1.解析sql
            SQLAndKey sqlAndKey = handler.parseSQL(sql);
            //2.获取连接
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            //3.状态参数
            PreparedStatement pstat = connection.prepareStatement(sqlAndKey.getSQL());
            //4.把sql和问号拼接在一起
            if(obj!=null){
                handler.handleParameter(pstat,obj,sqlAndKey.getKeyList());
            }
            //5.执行操作
            ResultSet rs = pstat.executeQuery();
            //6.处理结果(将结果集的值取出来 存入一个domain对象)
            while(rs.next()){
                list.add((T)handler.handleResult(rs,resultType));
            }
            //7.关闭
            rs.close();
            pstat.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(String sql){this.update(sql,null);}
    public void insert(String sql){this.insert(sql,null);}
    public void delete(String sql){this.delete(sql,null);}
    public <T> T selectOne(String sql,Class resultType){
        return this.selectOne(sql,null,resultType);
    }
    public <T> List<T> selectList(String sql,Class resultType){
        return this.selectList(sql,null,resultType);
    }
}
