package com.smallow.webframe.modular.system.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "sys_privilege")
@Data
public class SysPrivilege {
    @Id
    private Integer id;

    /**
     * 权限代码
     */
    private String code;

    /**
     * 父级权限代码
     */
    @Column(name = "parent_code")
    private String parentCode;

    /**
     * 权限名称
     */
    private String name;

    /**
     * url路径
     */
    private String url;

    /**
     * 权限排序序号
     */
    private Integer orders;

    /**
     * 权限层级
     */
    private Integer level;

    /**
     * 是否是菜单
     */
    @Column(name = "is_menu")
    private Integer isMenu;

    /**
     * 备注
     */
    private String tips;


}