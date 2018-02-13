package com.biyao.system.dao;

import com.biyao.system.model.SysUserInfo;
import com.biyao.system.model.SysUserInfoExample;
import java.util.List;

public interface ISysUserInfoDAO {
    int countByExample(SysUserInfoExample example);

    int deleteByExample(SysUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(SysUserInfo record);

    void insertSelective(SysUserInfo record);

    List<SysUserInfo> selectByExample(SysUserInfoExample example);

    SysUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(SysUserInfo record, SysUserInfoExample example);

    int updateByExample(SysUserInfo record, SysUserInfoExample example);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);
}