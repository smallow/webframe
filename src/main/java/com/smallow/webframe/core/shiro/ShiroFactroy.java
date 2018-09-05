package com.smallow.webframe.core.shiro;


import com.smallow.webframe.common.constant.enums.ManagerStatus;
import com.smallow.webframe.common.constant.factory.ConstantFactory;
import com.smallow.webframe.core.util.SpringContextHolder;
import com.smallow.webframe.modular.system.mapper.SysPrivilegeMapper;
import com.smallow.webframe.modular.system.mapper.SysUserMapper;
import com.smallow.webframe.modular.system.model.SysUser;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactroy implements IShiro {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysPrivilegeMapper sysPrivilegeMapper;

    public static IShiro newInstance() {
        return SpringContextHolder.getBean(IShiro.class);
    }


    @Override
    public SysUser user(String account) {
        SysUser user = sysUserMapper.getByAccount(account);

        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        //账号被冻结
        if (user.getStatus() != ManagerStatus.OK.getCode()) {
            throw new LockedAccountException();
        }
        return user;
    }

    @Override
    public ShiroUser shiroUser(SysUser user) {
        ShiroUser shiroUser = new ShiroUser();

        shiroUser.setId(user.getId());            // 账号id
        shiroUser.setAccount(user.getAccount());// 账号
        shiroUser.setDeptId(user.getDeptId());    // 部门id
        shiroUser.setDeptName(ConstantFactory.newInstance().getDeptName(user.getDeptId()));// 部门名称
        shiroUser.setName(user.getName());        // 用户名称
        String roleIds = user.getRoleId();
        List<Integer> roleList = new ArrayList<Integer>();
        List<String> roleNameList = new ArrayList<String>();
        if (!StringUtils.isEmpty(roleIds)) {
            String[] tmpArray = roleIds.split(",");
            if (tmpArray.length > 0) {
                Integer roleId = 0;
                for (String s : tmpArray) {
                    try {
                        roleId = Integer.parseInt(s);
                        roleList.add(roleId);
                        roleNameList.add(ConstantFactory.newInstance().getRoleName(roleId));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        shiroUser.setRoleList(roleList);
        shiroUser.setRoleNames(roleNameList);

        return shiroUser;
    }

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        return sysPrivilegeMapper.getResUrlsByRoleId(roleId);
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
        return ConstantFactory.newInstance().getRoleName(roleId);
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, SysUser user, String realmName) {
        return null;
    }
}
