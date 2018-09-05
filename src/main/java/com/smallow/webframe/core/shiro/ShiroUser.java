package com.smallow.webframe.core.shiro;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public Integer id;          // 主键ID
    public String account;      // 账号
    public String name;         // 姓名
    public Integer deptId;      // 部门id
    public String deptName;        // 部门名称
    public List<Integer> roleList; // 角色集
    public List<String> roleNames; // 角色名称集

}
