package com.oa.action;


import com.oa.model.Role;
import com.oa.service.RoleService;
import com.oa.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
