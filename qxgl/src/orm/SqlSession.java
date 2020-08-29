package orm;

import orm.annotation.Delete;
import orm.annotation.Insert;
import orm.annotation.Select;
import orm.annotation.Update;
import pool.ConnectionPool;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
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


    //===========================================================================

    //让SqlSession帮DAO创建一个小弟(代理对象)
    //  参数    到底是哪个DAO
    //  返回值  对象-代理对象-代理DAO做事
    public <T> T getMapper(Class clazz){//StudentDao.class
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //invoke方法是代理对象具体做事的方式
                //帮助原来的DAO做的事情  调用自己的增删改查方法啦
                //invoke方法中有三个参数
                // proxy代理对象
                // method被代理的那个方法
                // args被代理方法的参数

                //代理具体怎么做呢? DAO原来就调用了SqlSession中的某个方法
                //               代理也是调用SqlSession中的某个方法
                //1.需要帮助DAO调用哪个方法???----取决于注解名

                //获取方法上面的注解
                Annotation an = method.getAnnotations()[0];
                //获取找到这个注解的类型
                Class type = an.annotationType();
                //找到DAO方法上的注解类型---确定该调用哪个上面方法了
                //但是由于调用上面方法的时候需要SQL
                //  所以我们需要在调用上面方法之前  解析注解---得到SQL
                //找寻当前type注解类型中的那个value方法
                Method valueMethod = type.getDeclaredMethod("value");
                //执行这个value方法获取里面搬运过来的SQL
                String sql = (String)valueMethod.invoke(an);
                //调用DAO方法之前 除了方法名 和SQL以外 还需要提供SQL上面的值
                //  值只有几种情况 1.基本类型int float String 2.map 3.domain 4.没有
                Object param = args==null?null:args[0];
                //根据type判断该调用上述的哪个方法
                if(type == Insert.class){
                    SqlSession.this.insert(sql,param);
                }else if(type == Delete.class){
                    SqlSession.this.delete(sql,param);
                }else if(type == Update.class){
                    SqlSession.this.update(sql,param);
                }else if(type == Select.class){
                    //根据注解名字是无法确定该调用哪个方法
                    //可以根据method反射 寻找返回值来判断 domain  List<domain>
                    //获取method的返回值类型
                    Class methodReturnTypeClass = method.getReturnType();
                    if(methodReturnTypeClass==List.class){//多条
                        //解析methodReturnTypeClass里面的那个泛型
                        Type returnType = method.getGenericReturnType();//返回值的具体类型(java.util.List<domain.Student>)
                        //上述方法的返回值类型正常应该是个Class
                        //  由于这个Class没有办法操作泛型
                        //  Type是一个接口，好多子类实现
                        //  需要将type还原成可以操作泛型的那个类型
                        ParameterizedTypeImpl realReturnType = (ParameterizedTypeImpl)returnType;
                        //操作返回值类型中的泛型类
                        Type[] patternTypes = realReturnType.getActualTypeArguments();//获取到泛型类 []
                        //获取泛型类中的第一个元素
                        Type patternType = patternTypes[0];
                        //还原成需要的Class
                        Class resultType = (Class)patternType;
                        return SqlSession.this.selectList(sql,param,resultType);
                    }else{//单条
                        return SqlSession.this.selectOne(sql,param,methodReturnTypeClass);
                    }
                }else{
                    System.out.println("其他注解 没有你这个注解");
                }
                return null;
            }
        });


//        //如果想要使用动态代理对象帮忙做事  被代理的DAO必须是个接口
//        //3个条件
//        //  1.类加载器ClassLoader
//        ClassLoader loader = clazz.getClassLoader();
//        //  2.Class[] 加载的类  通常数组就一个元素
//        Class[] interfaces = new Class[]{clazz};
//        //  3.具体该怎么做事InvocationHandler 接口 具体实现接口 告知具体该如何做事
//        InvocationHandler h = new InvocationHandler(){
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                //用来描述代理对象具体如何做事
//                return null;
//            }
//        };
//        //创建一个代理对象
//        return (T)Proxy.newProxyInstance(loader,interfaces,h);
    }

}
