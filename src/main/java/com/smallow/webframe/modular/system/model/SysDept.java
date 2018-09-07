package com.smallow.webframe.modular.system.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_dept")
@Data
public class SysDept {
    @Id
    private Integer id;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 机构简称
     */
    @Column(name = "short_name")
    private String shortName;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;



    @Column(name = "parent_id")
    private Integer parentId;

}