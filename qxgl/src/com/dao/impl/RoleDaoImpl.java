package com.dao.impl;

import com.dao.RoleDao;
import com.domain.Role;
import orm.SqlSession;

import java.util.List;
import java.util.Map;

public class RoleDaoImpl implements RoleDao {

//这个类用来实现动态sql
    @Override
    public List<Role> findRoles(Map<String, Object> params) {
        SqlSession session = new SqlSession();
        StringBuilder sql = new StringBuilder();
        //where 1=1 不妨碍查询结果 也不用判断有没有where
        sql.append("select * from t_role where 1=1 ");
        if (params.get("rno") != null){
            sql.append("and rno=#{rno} ");
        }
        if (params.get("rname") !=null){
            sql.append("and rname like concat('%',concat(#{rname},'%')) ");
        }
        if (params.get("description") != null){
            sql.append("and description like concat('%',concat(#{description},'%')) ");
        }

        sql.append("limit #{start},#{length}");
        return session.selectList(sql.toString(),params,Role.class);
    }

    @Override
    public int listCount(Map<String, Object> params) {
        SqlSession session = new SqlSession();
        StringBuilder sql = new StringBuilder();
        //where 1=1 不妨碍查询结果 也不用判断有没有where
        sql.append("select count(*) from t_role where 1=1 ");
        if (params.get("rno") != null){
            sql.append("and rno=#{rno} ");
        }
        if (params.get("rname") !=null){
            sql.append("and rname like concat('%',concat(#{rname},'%')) ");
        }
        if (params.get("description") != null){
            sql.append("and description like concat('%',concat(#{description},'%')) ");
        }
        return session.selectOne(sql.toString(),params,int.class);
    }

    //从 user_role表中查出 所有 uno的rno 然后排除这些 rno 返回剩余的角色
    public List<Role> selectNotAddedRoles(Integer uno){
        SqlSession session = new SqlSession();
        String sql = "select * from t_role where rno not in(select rno from t_user_role where uno=#{uno})";
        return session.selectList(sql,uno,Role.class);
    }

    public List<Role> selectAddedRoles(Integer uno){
        SqlSession session = new SqlSession();
        String sql = "select * from t_role where rno in(select rno from t_user_role where uno=#{uno})";
        return session.selectList(sql,uno,Role.class);
    }

    //修改user_role 信息

    public void updateUserAndRole(Map<String,Integer> params){
        SqlSession session = new SqlSession();
        String sql = "insert into t_user_role values(#{uno},#{rno})";
        session.insert(sql,params);
    }

    //删除
    public void deleteUserAndRole(Integer uno){
        SqlSession session = new SqlSession();
        String sql = "delete from t_user_role where uno=#{uno}";
        session.delete(sql,uno);
    }
}
