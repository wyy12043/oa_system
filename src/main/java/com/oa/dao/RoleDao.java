package com.oa.dao;


import com.oa.model.Role;

/**
 * @author wyy
 * @date 2018/3/30
 */
public interface RoleDao extends BaseDao<Role>  {
    public void savePerm(int roleid, int menuid);
}
