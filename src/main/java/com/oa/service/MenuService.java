package com.oa.service;


import com.oa.model.Menu;
import com.oa.util.MenuTree;

import java.sql.SQLException;
import java.util.List;


public interface MenuService extends BaseService<Menu>{

	public List<Menu> getMenuByRole(int roleid);

	public List<MenuTree> getAllMenuByRole(int roleid) throws SQLException;
}
