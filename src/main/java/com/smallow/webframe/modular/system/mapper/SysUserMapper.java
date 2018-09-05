package com.smallow.webframe.modular.system.mapper;

import com.smallow.webframe.common.mybatis.MyMapper;
import com.smallow.webframe.modular.system.model.SysUser;

public interface SysUserMapper extends MyMapper<SysUser> {

    SysUser getByAccount(String account);
}