package com.biyao.system.dao;

import com.biyao.system.model.SysDictionary;
import com.biyao.system.model.SysDictionaryExample;
import java.util.List;

public interface ISysDictionaryDAO {
    int countByExample(SysDictionaryExample example);

    int deleteByExample(SysDictionaryExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(SysDictionary record);

    void insertSelective(SysDictionary record);

    List<SysDictionary> selectByExample(SysDictionaryExample example);

    SysDictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(SysDictionary record, SysDictionaryExample example);

    int updateByExample(SysDictionary record, SysDictionaryExample example);

    int updateByPrimaryKeySelective(SysDictionary record);

    int updateByPrimaryKey(SysDictionary record);
}