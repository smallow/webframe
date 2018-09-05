package com.smallow.webframe.common.constant.enums;


import lombok.Getter;

@Getter
public enum RoleType {
    SysManage(301,"超级系统管理")
    ;


    RoleType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private int code;
    private String name;
}
