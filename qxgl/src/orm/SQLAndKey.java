package orm;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个自定义的类
 * 这个类的目的是为了存储  被解析后SQL上的那些信息
 *   一个是SQL中的好多key---->ArrayList<String>
 *   另一个是SQL带有问号结构的那种类型--->特殊结构的SQL还原回问号结构
 */
public class SQLAndKey {

    private StringBuilder sql = new StringBuilder();//以前那种带问号的
    private List<String> keyList = new ArrayList();//存储解析出来的#{key}

    public SQLAndKey(StringBuilder sql,List<String> keyList){
        this.sql = sql;
        this.keyList = keyList;
    }

    public String getSQL(){
        return sql.toString();
    }
    public List<String> getKeyList(){
        return keyList;
    }
}
