package com.oa.service.impl;

import com.oa.dao.OptDao;
import com.oa.model.Opt;
import com.oa.service.OptService;
import com.oa.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**x
 * @author wyy
 * @date 2018/4/9
 */
@Service
public class OptServiceImpl implements OptService {

    @Autowired
    private OptDao optDao;

    @Override
    public List<Opt> getOptByRole(int roleid) {
        return optDao.getOptByRole(roleid);
    }

    @Override
    public Opt get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Opt> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Opt> find(Opt opt) throws SQLException {
        return null;
    }

    @Override
    public void save(Opt opt) throws SQLException {

    }

    @Override
    public void update(Opt opt) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public int count() throws SQLException {
        return 0;
    }

    @Override
    public PageUtils<Opt> getPage(int pageno, int pagesize) throws SQLException {
        return null;
    }
}
