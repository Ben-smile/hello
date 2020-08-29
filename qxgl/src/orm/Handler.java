package orm;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 是为了SqlSession的方案二服务的
 */
public class Handler {

    //为方案二提供一个小弟 解析一条特殊结构的SQL
    //  参数SQL
    //  返回值  包装对象SQLAndKey
    //      一堆key ArrayList<String>
    //      一条原来那样子的SQL语句
    SQLAndKey parseSQL(String sql){
        //解析之前有两个变量 存储解析SQL最终的两个部分
        StringBuilder newSQL = new StringBuilder();
        List<String> keyList = new ArrayList();
        //解析SQL
        // insert into student values(#{sid},#{sname},#{ssex},#{sage})
        while(true){
            //按照规定的索引位置寻找
            int left = sql.indexOf("#{");
            int right = sql.indexOf("}");
            //判断两个符号的位置是否是合法
            if(left!=-1 && right!=-1 && left<right){
                newSQL.append(sql.substring(0,left));//截取前面部分存入newSQL
                newSQL.append("?");//拼接一个问号
                keyList.add(sql.substring(left+2,right));//中间的key存到集合里
            }else{//证明此时SQL中已经没有key啦
                newSQL.append(sql);//最终的部分添加到newSQL
                break;//终止循环
            }
            sql = sql.substring(right+1);
        }
        //将上面解析过的两个变量组合成一个对象  返回
        return new SQLAndKey(newSQL,keyList);
    }

    //两个小小弟
    //分别负责 map 和 domain类型的拼接
    private void setMap(PreparedStatement pstat, Object obj, List<String> keyList) throws SQLException {
        Map map = (Map)obj;
        for(int i=0;i<keyList.size();i++){
            pstat.setObject(i+1,map.get(keyList.get(i)));
        }
    }
    private void setObject(PreparedStatement pstat,Object obj,List<String> keyList){
        try {
            Class clazz = obj.getClass();
            for (int i=0; i<keyList.size(); i++) {
                //先找到key
                String key = keyList.get(i);
                //通过key反射 找到obj对象中的属性  取值
                Field field = clazz.getDeclaredField(key);
                //设置私有属性的值      找到私有属性对应的那个get方法
                field.setAccessible(true);
                //获取私有属性的值
                Object value = field.get(obj);
                pstat.setObject(i+1,value);
            }
        }catch (Exception e){

        }
    }
    //为方案二提供第二个小弟 负责将SQL和问号组装完整
    //  参数  Pstat对象  Object对象  keyList全部的key
    void handleParameter(PreparedStatement pstat,Object obj,List<String> keyList) throws SQLException {
        //获取obj对应的那个Class
        Class clazz = obj.getClass();
        //clazz通常应该是什么类型的????
        //  基本类型 int--Integer  float--Float  String
        //  domain类型  Student  Teacher  Atm
        //  map类型
        if(clazz==int.class || clazz==Integer.class){
            pstat.setInt(1,(Integer)obj);
        }else if(clazz==float.class || clazz==Float.class){
            pstat.setFloat(1,(Float)obj);
        }else if(clazz==double.class || clazz==Double.class){
            pstat.setDouble(1,(Double)obj);
        }else if(clazz==String.class){
            pstat.setString(1,(String)obj);
        }else if(clazz.isArray()){
            //数组  我不支持
        }else{
            //剩下的只有两种可能
            //1.map
            if(obj instanceof Map){
                //再找个小小弟
                this.setMap(pstat,obj,keyList);
            }else{//2.domain
                //再找个小小弟
                this.setObject(pstat,obj,keyList);
            }
        }
    }
    //上面这个过程是解析对象 对象中的数据取出来 交给pstat进行拼接

    //--------------------------------------------------------------------------

    //下面这个过程是解析对象 将结果集的信息取出来 交给对象组合

    //小小弟
    //将结果集的信息组合成一个map
    private Map getMap(ResultSet rs) throws SQLException {
        //创建map
        Map result = new HashMap<String,Object>();
        //获取结果集中的全部信息
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        //遍历结果集中的全部列
        for(int i=1;i<=resultSetMetaData.getColumnCount();i++){
            //获取每一个列名字
            String columnName = resultSetMetaData.getColumnName(i);
            //根据每一个列名 获取值
            Object value = rs.getObject(columnName);
            //存入map中
            result.put(columnName,value);
        }
        return result;
    }
    //将结果集的信息组合成一个domain
    private Object getObject(ResultSet rs,Class resultType) throws SQLException {
        Object obj = null;
        try {
            //通过反射创建对象
            obj = resultType.newInstance();
            //获取结果集中的全部信息
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            //遍历循环结果集
            for(int i=1;i<=resultSetMetaData.getColumnCount();i++){
                //获取结果集的每一个列名字
                String columnName = resultSetMetaData.getColumnName(i);
                //反射找到列名字对应的那个属性
                Field field = resultType.getDeclaredField(columnName);
                //操作私有属性
                field.setAccessible(true);
                //给属性赋值
                field.set(obj,rs.getObject(columnName));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return obj;
    }
    //方法负责将结果集的值组合成一个domain对象
    //  参数  ResultSet   Class
    Object handleResult(ResultSet rs,Class resultType) throws SQLException {
        //1.反射创建对象  int String  Map  domain
        Object result = null;
        if(resultType==int.class || resultType==Integer.class){
            result = rs.getInt(1);
        }else if(resultType==float.class || resultType==Float.class){
            result = rs.getFloat(1);
        }else if(resultType==double.class || resultType==Double.class){
            result = rs.getDouble(1);
        }else if(resultType==String.class){
            result = rs.getString(1);
        }else{
            //是个对象  map  domain
            if(resultType==Map.class){
                result = this.getMap(rs);
            }else{
                result = this.getObject(rs,resultType);
            }
        }
        return result;
    }

}







