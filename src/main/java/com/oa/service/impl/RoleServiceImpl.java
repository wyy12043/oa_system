package com.oa.service.impl;


import com.oa.dao.RoleDao;
import com.oa.model.Role;
import com.oa.service.RoleService;
import com.oa.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wyy
 * @date 2018/3/30
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return roleDao.getAll();
    }

    @Override
    public List<Role> find(Role role) throws SQLException {
        return null;
    }

    @Override
    public void save(Role role) throws SQLException {
        if (role.getId() == null){
            roleDao.insert(role);
        }else {
            roleDao.update(role);
        }
    }

    @Override
    public void update(Role role) throws SQLException {
        roleDao.update(role);
    }

    @Override
    public void delete(int id) throws SQLException {
        roleDao.delete(id);
    }

    @Override
    public int count() throws SQLException {
        return roleDao.count();
    }


    @Override
    public PageUtils<Role> getPage(int pageno, int pagesize) throws SQLException {
        PageUtils<Role> p = new PageUtils<Role>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        int totalNum = roleDao.count() ;
        int totalPage = totalNum % pagesize == 0 ? totalNum / pagesize : totalNum / pagesize + 1 ;

        if(pageno > totalPage){
            pageno = totalPage ;
        }
        if(pageno <= 0){
            pageno = 1 ;
        }
        map.put("start", (pageno-1)*pagesize) ;
        map.put("end", pagesize) ;


        List<Role> list = roleDao.getPage(map);
        p.setPages(totalPage);
        p.setTotal(totalNum);
        p.setRows(list);
        return p ;
    }

    @Override
    public void savePerm(int roleid, int menuid) {
        roleDao.savePerm(roleid,menuid);
    }

    @Override
    public void saveOpt(int roleid, int optid) {
        roleDao.saveOpt(roleid,optid);
    }

    @Override
    public void deletePerm(int roleid) {
        roleDao.deletePerm(roleid);
    }

    @Override
    public void deleteOpt(int roleid) {
        roleDao.deleteOpt(roleid);
    }
}
