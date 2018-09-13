package com.smallow.webframe.modular.system.controller;

import com.smallow.webframe.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SysRoleController extends BaseController {

    @GetMapping("/roleManage")
    public String list(){
        return "system/role/list";
    }
}
