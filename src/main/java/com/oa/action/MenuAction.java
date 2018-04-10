package com.oa.action;


import com.oa.model.Menu;
import com.oa.model.User;
import com.oa.service.MenuService;
import com.oa.util.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuAction {

	@Autowired
	private MenuService menuService ;

	@RequestMapping("/getMenuByRole.action")
	public @ResponseBody List<Menu> getMenuByRole(HttpSession session){

		User u = (User)session.getAttribute("user") ;

		List<Menu> list = menuService.getMenuByRole(u.getRoleId()) ;

		return list ;

	}

	@RequestMapping("/getMenu.action")
	public @ResponseBody List<MenuTree> getMenu(HttpSession session){

		List<MenuTree> lm = null;

		User u = (User)session.getAttribute("user") ;

		List<Menu> list = menuService.getMenuByRole(u.getRoleId()) ;

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

	@RequestMapping("/getAllMenu.action")
	public @ResponseBody List<MenuTree> getAllMenu(HttpSession session) {
		List<MenuTree> lm = null;

		User u = (User) session.getAttribute("user");

		List<Menu> list = menuService.getMenuByRole(u.getRoleId());

		if (list != null && list.size() > 0){
			lm = new ArrayList<>();
			for (int i = 0; i < list.size(); i++){
				Menu menu = list.get(i);
				// pid = 0说明是一级菜单
				if (menu.getPid() == 0){
					MenuTree m = new MenuTree();
					m.setId(menu.getId());
					m.setText(menu.getText());
					List<Menu> sublist = new ArrayList<>();
					for (Menu submenu : list){
						if (submenu.getPid() == m.getId()){
							sublist.add(submenu);
						}
					}
					m.setChildren(sublist);
					//把一级菜单添加到lm里面
					lm.add(m);
				}
			}
		}
		return lm;
	}


	@RequestMapping("/getAllMenuByRole.action")
	public @ResponseBody List<MenuTree> getAllMenuByRole(int roleid) throws SQLException {

		List<MenuTree> list = menuService.getAllMenuByRole(roleid) ;

		return list ;

	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}


}
