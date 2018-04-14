package com.oa.service.impl;


import com.oa.dao.MenuDao;
import com.oa.dao.OptDao;
import com.oa.model.Menu;
import com.oa.model.Opt;
import com.oa.service.MenuService;
import com.oa.util.MenuTree;
import com.oa.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao ;

	@Autowired
	private OptDao optDao;
	
	@Override
	public Menu get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getAll() throws SQLException {
		return menuDao.getAll();
	}


	@Override
	public void update(Menu t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() throws SQLException {
		return 0;
	}

	@Override
	public PageUtils<Menu> getPage(int pageno, int pagesize) throws SQLException {
		return null;
	}


	@Override
	public List<Menu> find(Menu t) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Menu menu) throws SQLException {

	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<Menu> getMenuByRole(int roleid) {
		return menuDao.getMenuByRole(roleid);
	}

	@Override
	public List<MenuTree> getAllMenuByRole(int roleid) throws SQLException {
		List<MenuTree> lm = null;

		List<Menu> list = menuDao.getAll() ;

		List<Menu> roleMenuList = menuDao.getMenuByRole(roleid) ;

		if(list != null && list.size() > 0){
			lm = new ArrayList<MenuTree>();
			for(int i = 0 ; i < list.size();i++){
				Menu menu = list.get(i) ;
				// pid = 0 说明是一级菜单
				if(menu.getPid() == 0){
					MenuTree m = new MenuTree();
					m.setId(menu.getId());
					m.setText(menu.getText());
					List<Menu> sublist = new ArrayList<Menu>();
					for(Menu submenu : list){
						if(submenu.getPid() == m.getId()){
							//判断以下,当前角色是否有相应权限,如果有,把ckecked属性设置为 true
							for(Menu mm :roleMenuList){
								if(mm.getId() == submenu.getId() ){
									submenu.setChecked(true);
								}

						}
							if (submenu.getId() == 9){
								List<Opt> optByRole = optDao.getOptByRole(100);
								List<Opt> optByRole1 = optDao.getOptByRole(roleid);
								for (Opt opt : optByRole1){
									if (opt.getId() == 3 ){
										opt.setChecked(true);
									}
									if (opt.getId() == 4 ){
										opt.setChecked(true);
									}

								}

								submenu.setChildren(optByRole);
							}
							else if (submenu.getId() == 8){
								List<Opt> optByRole = optDao.getOptByRole(99);
								submenu.setChildren(optByRole);
							}

							//二级菜单
							sublist.add(submenu) ;
						}
					}
					m.setChildren(sublist);
					//把一级菜单添加到lm
					lm.add(m) ;
				}



			}
		}

		return lm;
	}

}
