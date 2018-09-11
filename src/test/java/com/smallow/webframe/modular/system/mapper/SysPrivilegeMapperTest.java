package com.smallow.webframe.modular.system.mapper;

import com.smallow.webframe.modular.system.node.MenuNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SysPrivilegeMapperTest {

    @Autowired
    private SysPrivilegeMapper sysPrivilegeMapper;

    @Test
    public void insertTest() {
        List<String> list=sysPrivilegeMapper.getResUrlsByRoleId(2);
        log.info("TTTT",list);
    }

    @Test
    public void findMenuByRoleIds(){
        List<Integer> roleIds=new ArrayList<Integer>(){{
            add(2);
        }};
        List<MenuNode> list=sysPrivilegeMapper.getMenusByRoleIds(roleIds);
        log.info("TTTTT",list);
    }
}