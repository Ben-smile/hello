package orm;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 * 这个类用来 服务 SQLSession
 */
public class Handler {

    // 设计一个方法 用来map 赋值 服务于handleParameter
    void setMap(ArrayList<String> keys, Object obj, PreparedStatement pstat) throws SQLException {
        Map map = (Map)obj;
        for(int i = 0;i<keys.size();i++){
            pstat.setObject(i+1,map.get(keys.get(i)));
        }
    }

    //设计一个方法 用来 domian 赋值 服务于handleParameter
    void setDomain(ArrayList<String> keys,Object obj,PreparedStatement pstat){
        for (int i = 0;i<keys.size();i++){
            try {
                String key = keys.get(i); //获取一个key

                Class clazz = obj.getClass();
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);
                pstat.setObject(i+1,field.get(obj));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //设计一个方法 用来解析sql
    //得到两个返回值  1.正常的sql(String)  2.所有的key(ArrayList<String>)
    //所以我们将两个值包装成一个对象  SQLAndKey
    SQLAndKey parseSQL(String sql){
        StringBuilder newSQL = new StringBuilder();
        ArrayList<String> keys = new ArrayList<>();
        //String sql = "insert into student values(#{sid},#{sname},#{ssex},#{sage})"

        while(true) {
            int left = sql.indexOf("#{");
            int right = sql.indexOf("}");
            //找到#{}的 索引 并判断索引是否合法
            if (left != -1 && right != -1 && left < right) {
                newSQL.append(sql.substring(0, left));
                newSQL.append("?");
                keys.add(sql.substring(left + 2, right));
                sql = sql.substring(right + 1);
            } else {
                newSQL.append(sql);
                break;
            }
        }
        return new SQLAndKey(newSQL.toString(),keys);
    }




    //设计一个方法 用来 给 问号赋值
    void handleParameter(String sql,ArrayList<String> keys,Object obj,PreparedStatement pstat) throws SQLException {

        //obj 参数 可能有一下几种情况
        //1. 一个参数  基本类型/String
        //2. map 集合
        //3. domain 对象

        if(int.class == obj.getClass() || Integer.class == obj.getClass()){
            pstat.setInt(1,(Integer) obj);
        }else if(float.class == obj.getClass() || Float.class == obj.getClass()){
            pstat.setFloat(1,(Float) obj);
        }else if(double.class == obj.getClass() || Double.class == obj.getClass()){
            pstat.setDouble(1,(Double) obj);
        }else if(boolean.class == obj.getClass() || Boolean.class == obj.getClass()){
            pstat.setBoolean(1,(Boolean) obj);
        }else if(String.class == obj.getClass()){
            pstat.setString(1,(String) obj);
        }else{
            //1.map
            if(obj instanceof Map){
                //设计一个方法
                this.setMap(keys,obj,pstat);

            }else{
                //2.domain
                //设计一个方法

                this.setDomain(keys,obj,pstat);
            }

        }
    }
}
