package com.dao.impl;

import com.dao.RoleDao;
import com.domain.Role;
import orm.SqlSession;

import java.util.List;
import java.util.Map;

public class RoleDaoImpl implements RoleDao {


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
}
