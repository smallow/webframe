package com.smallow.webframe.modular.system.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "sys_dict")
@Data
public class SysDict {
    @Id
    private Integer id;

    /**
     * 字典代码
     */
    private Integer code;

    /**
     * 父级代码
     */
    private Integer pcode;

    private String name;

    /**
     * 描述
     */
    private String tips;


}