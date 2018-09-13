package com.smallow.webframe.modular.system.controller;

import com.smallow.webframe.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SysUserController extends BaseController {

    @GetMapping("/userManage")
    public String list() {

        return "system/user/list";
    }

}
