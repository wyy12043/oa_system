package com.oa.service;

import com.oa.model.Opt;

import java.util.List;

/**
 * @author wyy
 * @date 2018/4/9
 */
public interface OptService extends BaseService<Opt>{
    public List<Opt> getOptByRole(int roleid);
}
