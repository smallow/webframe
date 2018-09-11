package com.smallow.webframe.modular.system.mapper;

import com.smallow.webframe.common.mybatis.MyMapper;
import com.smallow.webframe.modular.system.model.SysPrivilege;
import com.smallow.webframe.modular.system.node.MenuNode;

import java.util.List;

public interface SysPrivilegeMapper extends MyMapper<SysPrivilege> {


    /**
     * 通过角色id获取资源url
     *
     * @param roleId
     * @return
     * @date 2017年2月19日 下午7:12:38
     */
    List<String> getResUrlsByRoleId(Integer roleId);

    List<MenuNode> getMenusByRoleIds(List<Integer> roleIds);
}