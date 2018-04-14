package com.oa.action;


import com.oa.model.Role;
import com.oa.model.User;
import com.oa.service.RoleService;
import com.oa.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wyy
 * @date 2018/3/30
 */
@Controller
@RequestMapping("/role")
public class RoleAction {
    @Autowired
    private RoleService roleService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    @RequestMapping("/getAll.action")
    public @ResponseBody List<Role> getAll(){
        List<Role> list = null;
        try {
            list = roleService.getAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list ;
    }


    @RequestMapping("/getPage.action")
    public @ResponseBody
    PageUtils<Role> getPage(int page, int rows){
        try {
            PageUtils<Role> p = roleService.getPage(page, rows) ;
            return p ;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 保存权限
     * @param roleid  角色ID
     * @param ids      所有被选中的菜单ＩＤ
     * @return
     */
    @RequestMapping("/savePerm.action")
    public @ResponseBody String savePerm(int roleid,String ids){

		roleService.deletePerm(roleid);
		try {
			String[] s = ids.split(",") ;
			for(String id : s){
                roleService.savePerm(roleid, Integer.parseInt(id));
            }
            return "yes" ;
        } catch (Exception e) {
            e.printStackTrace();
            return "no" ;

        }

    }

    /**
     * 保存权限
     * @param roleid  角色ID
     * @param ids      所有被选中的操作ＩＤ
     * @return
     */
    @RequestMapping("/saveOpt.action")
    public @ResponseBody String saveOpt(int roleid,String ids){

		roleService.deleteOpt(roleid);
		try {
			String[] s = ids.split(",") ;
			for(String id : s){
				int id1 = Integer.parseInt(id);
				if (id1 <= 5){
					roleService.saveOpt(roleid,id1 );
				}
            }
            return "yes" ;
        } catch (Exception e) {
            e.printStackTrace();
            return "no" ;

        }

    }

    @RequestMapping(value = "/save.action", produces = "text/html;charset=utf-8")
    public @ResponseBody
    String save(Role role) throws IOException {
        String message = "";
        try {
            roleService.save(role);
            message = "保存角色成功";
        } catch (Exception e) {
            e.printStackTrace();
            message = "操作失败";
        }
        return message;
    }

    @RequestMapping(value = "/update.action", produces = "text/html;charset=utf-8")
    public @ResponseBody
    String update(Role role) throws IOException {
        String message = "";
        try {
            roleService.update(role);
            message = "修改角色成功";
        } catch (Exception e) {
            e.printStackTrace();
            message = "操作失败";
        }
        return message;
    }


    @RequestMapping(value = "/delete.action", produces = "text/html;charset=utf-8")
    public @ResponseBody
    String delete(String ids) throws IOException {
        String str = "";
        String[] sa = ids.split(",");
        try {
            for (String s : sa) {
                int id = Integer.parseInt(s);
                roleService.delete(id);
                str = "删除角色成功";
            }
            return str;
        } catch (SQLException e) {
            e.printStackTrace();
            return "删除失败";
        }
    }

}
