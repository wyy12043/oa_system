package com.oa.dao;

import com.oa.model.Opt;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OptDao extends BaseDao<Opt>{
	public List<Opt> getOptByRole(int roleid);

}
