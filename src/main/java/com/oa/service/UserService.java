package com.oa.service;




import com.oa.model.User;
import com.oa.util.PageUtils;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author wyy
 * @date 2018/3/20
 */
public interface UserService extends BaseService<User>{
    /**
     * 列出所有用户
     * @return
     * @throws IOException
     */
    public User login(String username, String password) throws Exception ;

    public PageUtils<User> getPage(int pageno, int pagesize) throws SQLException;

    public void saveRole(int roleid, int userid) throws SQLException ;
}
