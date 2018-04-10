package com.oa.service.impl;



import com.oa.dao.UserDao;
import com.oa.model.User;
import com.oa.service.UserService;
import com.oa.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
	
   @Autowired
	private UserDao userDao ;
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	@Override
	public User login(String username, String password) throws Exception {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("username", username) ;
		map.put("password", password) ;
		
		return userDao.login(map);
	}

	@Override
	public PageUtils<User> getPage(int pageno, int pagesize) throws SQLException {
		PageUtils<User> p = new PageUtils<User>();

		Map<String,Integer> map = new HashMap<>();
		int totalNum = userDao.count();
		int totalPage = totalNum % pagesize == 0 ? totalNum / pagesize : totalNum / pagesize+1;
		if (pageno > totalPage){
			pageno = totalPage;
		}
		if (pageno <= 0){
			pageno = 1;
		}
		map.put("start",(pageno - 1)*pagesize);

		map.put("end",pagesize);

		p.setRows(userDao.getPage(map));
		p.setPages(totalPage);
		p.setTotal(totalNum);
		return p;
	}


	@Override
	public User get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> getAll() throws SQLException {
		
		return userDao.getAll();
	}




	@Override
	public void update(User t) throws SQLException {
		// TODO Auto-generated method stub

	}


	@Override
	public void delete(int id) throws SQLException {
			userDao.delete(id);
	}

	@Override
	public int count() throws SQLException {
		return userDao.count();
	}

	@Override
	public List<User> find(User t) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) throws SQLException {
		if (user.getId() == null){
			userDao.insert(user);
		}else {
			userDao.update(user);
		}
	}

	@Override
	public void saveRole(int userid, int roleid) throws SQLException {

		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("roleid", roleid) ;
		userDao.saveRole(map);
	}


}
