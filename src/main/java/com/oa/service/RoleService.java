package com.oa.service;


import com.oa.model.Role;

/**
 * @author wyy
 * @date 2018/3/30
 */
public interface RoleService extends BaseService<Role>{
    public void savePerm(int roleid, int menuid);
}
