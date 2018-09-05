package com.smallow.webframe.modular.system.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
@Data
public class SysUser {
    @Id
    private Integer id;

    private String account;

    private String name;

    private String pwd;

    private String salt;

    private String avatar;

    private Integer sex;

    private String phone;

    private String email;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private String roleId;

    /**
     * 部门ID
     */
    @Column(name = "dept_id")
    private Integer deptId;

    /**
     * 状态 1启用 2 冻结 3删除
     */
    private Integer status;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;


}