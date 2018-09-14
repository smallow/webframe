package com.smallow.webframe.modular.enums;


import com.smallow.webframe.common.constant.enums.CodeEnum;
import lombok.Getter;

@Getter
public enum GroupStateEnum implements CodeEnum {

    NORMAL(0, "已开通"), APPLY(1, "已申请"),DELETED(2, "已注销");


    private Integer code;
    private String msg;

    GroupStateEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
