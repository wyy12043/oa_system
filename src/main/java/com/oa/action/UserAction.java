package com.oa.action;



import com.oa.model.User;
import com.oa.service.UserService;
import com.oa.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired       //根据类型注入
    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/getAll.action")
    public @ResponseBody
    List<User> getAll() throws Exception {

        List<User> list = userService.getAll();

        return list;
    }

    @RequestMapping("/login.action")
    public String login(String username, String password, HttpSession session) throws Exception {


        User u = userService.login(username, password);
        if (u != null) {
            session.setAttribute("user", u);
            return "redirect:/index.html";
        } else {
            return "error";
        }

    }

    @RequestMapping("/getPage.action")
    public @ResponseBody
    PageUtils<User> getPage(int page, int rows) {
/*        List<User> list = null;
        try {
            list = userService.getPage(page, rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;*/

        PageUtils<User> p = new PageUtils<User>();
        try {
            p = userService.getPage(page, rows);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/reg.action")
    public String reg(User user, Model model) throws ServletException, IOException {
        if (user.getSex() != 1 && user.getSex() != 2) {

            model.addAttribute("user", user);


            return "reg";
        }
        return "redirect:getAll.action";
    }


    @RequestMapping(value = "/save.action", produces = "text/html;charset=utf-8")
    public @ResponseBody
    String save(User user) throws IOException {
        String message = "";
        try {

            userService.save(user);
            message = "保存用户成功";
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
                userService.delete(id);
                str = "删除成功";
            }
            return str;
        } catch (SQLException e) {
            e.printStackTrace();
            return "删除失败";
        }
    }


    @RequestMapping(value="/saveRole.action",produces="text/html;charset=utf-8")
    public @ResponseBody String saveRole(String ids,int roleid){
        String str = "" ;
        String[] sa = ids.split(",");
        try {
            for(String s : sa){
                int userid = Integer.parseInt(s) ;
                userService.saveRole(userid, roleid);
                str = "分配角色成功" ;
            }
            return str ;
        } catch (Exception e) {
            return "操作失败" ;
        }
    }
}
