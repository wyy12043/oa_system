package com.oa.dao;

import com.oa.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MenuDao extends BaseDao<Menu>{

	public List<Menu> getMenuByRole(int roleid);
}
