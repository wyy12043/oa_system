package com.oa.dao;


import com.oa.model.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Map;

/**
 * @author wyy
 * @date 2018/3/20
 */
@Repository
public interface UserDao extends BaseDao<User>{
    public User login(Map<String, String> map) throws SQLException;

    //保存用户角色
    public void saveRole(Map<String, Integer> map) throws SQLException ;
}
