package com.dao;

import com.domain.Role;
import orm.annotation.Select;

import java.util.List;
import java.util.Map;

public interface RoleDao {


    //查询 分页 模糊查询 动态sql
    List<Role> findRoles(Map<String,Object> params);

    //找到查询的 所有记录总数
    int listCount(Map<String, Object> params);
}
