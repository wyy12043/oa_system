package com.oa.action;


import com.oa.model.Menu;
import com.oa.model.Opt;
import com.oa.model.User;
import com.oa.service.MenuService;
import com.oa.service.OptService;
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
@RequestMapping("/opt")
public class OptAction {

	@Autowired
	private OptService optService ;

	@RequestMapping("/getOptByRole.action")
	public @ResponseBody List<Opt> getMenuByRole(HttpSession session){

		User u = (User)session.getAttribute("user") ;

		List<Opt> list = optService.getOptByRole(u.getRoleId()) ;

		return list ;

	}


}
