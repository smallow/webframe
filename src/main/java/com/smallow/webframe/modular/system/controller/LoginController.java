package com.smallow.webframe.modular.system.controller;

import com.smallow.webframe.common.controller.BaseController;
import com.smallow.webframe.core.shiro.ShiroKit;
import com.smallow.webframe.core.shiro.ShiroUser;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class LoginController extends BaseController {


    @GetMapping("/")
    public String index(Model model) {
        List<Integer> roleList = ShiroKit.getUser().getRoleList();
        if (roleList == null || roleList.size() == 0) {
            ShiroKit.getSubject().logout();
            model.addAttribute("tips", "该用户没有角色，无法登陆");
            return "login";
        }

        return "index";
    }


    @GetMapping("/login")
    public String login() {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return REDIRECT + "/";
        } else {
            return "login";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password) {
        Subject currentUser=ShiroKit.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(userName,password);
        token.setRememberMe(true);
        currentUser.login(token);
        ShiroUser shiroUser=ShiroKit.getUser();
        getSession().setAttribute("shiroUser",shiroUser);
        getSession().setAttribute("userName",shiroUser.getAccount());
        return REDIRECT + "/";
    }


}
