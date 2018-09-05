package com.smallow.webframe.common.constant.enums;


import lombok.Getter;

@Getter
public enum ManagerStatus {
    OK(101, "启用"), FREEZED(102, "冻结"), DELETED(103, "删除");


    ManagerStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;
}
