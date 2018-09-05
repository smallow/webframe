package com.smallow.webframe.modular.system.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "sys_role_pri")
@Data
public class SysRolePri {
    @Id
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "pri_id")
    private Integer priId;


}