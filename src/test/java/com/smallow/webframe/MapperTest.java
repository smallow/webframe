package com.smallow.webframe;

import com.smallow.webframe.common.constant.enums.RoleType;
import com.smallow.webframe.core.shiro.ShiroKit;
import com.smallow.webframe.modular.system.mapper.SysPrivilegeMapper;
import com.smallow.webframe.modular.system.mapper.SysRoleMapper;
import com.smallow.webframe.modular.system.mapper.SysRolePriMapper;
import com.smallow.webframe.modular.system.mapper.SysUserMapper;
import com.smallow.webframe.modular.system.model.SysPrivilege;
import com.smallow.webframe.modular.system.model.SysRole;
import com.smallow.webframe.modular.system.model.SysRolePri;
import com.smallow.webframe.modular.system.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import netscape.security.PrivilegeManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysPrivilegeMapper privilegeManager;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysPrivilegeMapper privilegeMapper;

    @Autowired
    private SysRolePriMapper sysRolePriMapper;


    @Test
    public void insertTest() {
        SysUser user = new SysUser();
        user.setAccount("101010");
        user.setSalt(ShiroKit.getRandomSalt(10));
        user.setPwd(ShiroKit.md5("19860122", user.getSalt()));
        user.setStatus(1);
        sysUserMapper.insert(user);
    }

    @Test
    public void getTest() {
        SysUser user = sysUserMapper.selectByPrimaryKey(16);
        System.out.println(user);
    }

    @Test
    public void roleInsertTest() {
        SysRole role = new SysRole();
        role.setName("用户管理员");
        role.setTips("");
        role.setCreateTime(new Timestamp(new Date().getTime()));
        role.setUpdateTime(new Timestamp(new Date().getTime()));
        roleMapper.insert(role);

    }

    @Test
    public void priInsertTest() {
        SysPrivilege sysPrivilege = new SysPrivilege();
        SysPrivilege sysPrivilege1 = new SysPrivilege();
        SysPrivilege sysPrivilege2 = new SysPrivilege();
//        sysPrivilege.setCode("system");
//        sysPrivilege.setParentCode("0");
//        sysPrivilege.setName("系统管理");
//        sysPrivilege.setUrl("#");
//        sysPrivilege.setOrders(1);
//        sysPrivilege.setIsMenu(0);
//        sysPrivilege.setLevel(1);
//        sysPrivilege.setTips("ceshi");

//        sysPrivilege.setCode("userManage");
//        sysPrivilege.setParentCode("system");
//        sysPrivilege.setName("用户管理");
//        sysPrivilege.setUrl("/userManage");
//        sysPrivilege.setOrders(1);
//        sysPrivilege.setIsMenu(0);
//        sysPrivilege.setLevel(2);
//        sysPrivilege.setTips("");

//        sysPrivilege.setCode("userManage_add");
//        sysPrivilege.setParentCode("userManage");
//        sysPrivilege.setName("添加用户");
//        sysPrivilege.setUrl("/userManage/add");
//        sysPrivilege.setOrders(1);
//        sysPrivilege.setIsMenu(1);
//        sysPrivilege.setLevel(3);
//        sysPrivilege.setTips("");
//
//
//        sysPrivilege1.setCode("userManage_del");
//        sysPrivilege1.setParentCode("userManage");
//        sysPrivilege1.setName("删除用户");
//        sysPrivilege1.setUrl("/userManage/del");
//        sysPrivilege1.setOrders(2);
//        sysPrivilege1.setIsMenu(1);
//        sysPrivilege1.setLevel(3);
//        sysPrivilege1.setTips("");
//
//        sysPrivilege2.setCode("userManage_edit");
//        sysPrivilege2.setParentCode("userManage");
//        sysPrivilege2.setName("删除用户");
//        sysPrivilege2.setUrl("/userManage/edit");
//        sysPrivilege2.setOrders(3);
//        sysPrivilege2.setIsMenu(1);
//        sysPrivilege2.setLevel(3);
//        sysPrivilege2.setTips("");

        sysPrivilege.setCode("roleManage");
        sysPrivilege.setParentCode("system");
        sysPrivilege.setName("角色管理");
        sysPrivilege.setUrl("/roleManage");
        sysPrivilege.setOrders(2);
        sysPrivilege.setIsMenu(0);
        sysPrivilege.setLevel(2);
        sysPrivilege.setTips("");
        List<SysPrivilege> privilegeList = new ArrayList<SysPrivilege>() {{
            add(sysPrivilege);
            //add(sysPrivilege1);
            // add(sysPrivilege2);
        }};
        privilegeMapper.insertList(privilegeList);
    }


    @Test
    public void relationInsertTest() {
        SysRolePri sysRolePri = new SysRolePri();
        sysRolePri.setPriId(4);
        sysRolePri.setRoleId(2);

        SysRolePri sysRolePri1 = new SysRolePri();
        sysRolePri1.setPriId(5);
        sysRolePri1.setRoleId(2);

        SysRolePri sysRolePri2 = new SysRolePri();
        sysRolePri2.setPriId(7);
        sysRolePri2.setRoleId(2);

        SysRolePri sysRolePri3 = new SysRolePri();
        sysRolePri3.setPriId(8);
        sysRolePri3.setRoleId(2);

        SysRolePri sysRolePri4 = new SysRolePri();
        sysRolePri4.setPriId(9);
        sysRolePri4.setRoleId(2);

        List<SysRolePri> sysRolePriList = new ArrayList<SysRolePri>() {{
            add(sysRolePri);
            add(sysRolePri1);
            add(sysRolePri2);
            add(sysRolePri3);
            add(sysRolePri4);
        }};

        sysRolePriMapper.insertList(sysRolePriList);

    }
}
