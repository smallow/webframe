package com.smallow.webframe.common.constant.factory;

import com.smallow.webframe.core.util.SpringContextHolder;
import com.smallow.webframe.modular.system.mapper.SysDeptMapper;
import com.smallow.webframe.modular.system.mapper.SysRoleMapper;
import com.smallow.webframe.modular.system.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("springContextHolder")
public class ConstantFactory implements IConstantFactory {


    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysDeptMapper deptMapper;

    public static IConstantFactory newInstance() {
        return SpringContextHolder.getBean("constantFactory");
    }


    @Override
    public String getDeptName(Integer deptId) {

        return deptMapper.selectByPrimaryKey(deptId).getName();
    }

    @Override
    public String getRoleName(Integer roleId) {
        SysRole role = sysRoleMapper.selectByPrimaryKey(roleId);
        if (role != null)
            return role.getName();
        return null;
    }
}
