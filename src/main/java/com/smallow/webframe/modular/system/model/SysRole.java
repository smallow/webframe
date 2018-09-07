package com.smallow.webframe.modular.system.model;

import lombok.Data;

import java.sql.Timestamp;
import javax.persistence.*;

@Table(name = "sys_role")
@Data
public class SysRole {
    @Id
    private Integer id;

    private String name;

    /**
     * 父级角色ID
     */
    private Integer pid;

    /**
     * 角色描述
     */
    private String tips;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;




}