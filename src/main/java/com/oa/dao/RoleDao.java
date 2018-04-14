package com.oa.dao;


import com.oa.model.Role;

/**
 * @author wyy
 * @date 2018/3/30
 */
public interface RoleDao extends BaseDao<Role>  {
	/**
	 * 保存角色的菜单权限
	 */
    public void savePerm(int roleid, int menuid);
	/**
	 * 保存角色的操作权限
	 */
    public void saveOpt(int roleid, int optid);
	/**
	 * 删除角色的菜单权限
	 */
	public void deletePerm(int roleid);
	/**
	 * 删除角色的操作权限
	 */
	public void deleteOpt(int roleid);

}
