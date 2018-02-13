package com.biyao.system.dao.impl;

import com.biyao.system.dao.ISysDictionaryDAO;
import com.biyao.system.model.SysDictionary;
import com.biyao.system.model.SysDictionaryExample;
import com.biyao.common.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iSysDictionaryDAO")
public class SysDictionaryDAOImpl extends BaseDaoImpl implements ISysDictionaryDAO {

    public SysDictionaryDAOImpl() {
        super();
    }

    public int countByExample(SysDictionaryExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_sys_dictionary.countByExample", example);
        return count;
    }

    public int deleteByExample(SysDictionaryExample example) {
        int rows = getSqlMapClientTemplate().delete("t_sys_dictionary.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        SysDictionary _key = new SysDictionary();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_sys_dictionary.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SysDictionary record) {
        getSqlMapClientTemplate().insert("t_sys_dictionary.insert", record);
    }

    public void insertSelective(SysDictionary record) {
        getSqlMapClientTemplate().insert("t_sys_dictionary.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<SysDictionary> selectByExample(SysDictionaryExample example) {
        List<SysDictionary> list = getSqlMapClientTemplate().queryForList("t_sys_dictionary.selectByExample", example);
        return list;
    }

    public SysDictionary selectByPrimaryKey(Integer id) {
        SysDictionary _key = new SysDictionary();
        _key.setId(id);
        SysDictionary record = (SysDictionary) getSqlMapClientTemplate().queryForObject("t_sys_dictionary.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(SysDictionary record, SysDictionaryExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_sys_dictionary.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(SysDictionary record, SysDictionaryExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_sys_dictionary.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(SysDictionary record) {
        int rows = getSqlMapClientTemplate().update("t_sys_dictionary.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SysDictionary record) {
        int rows = getSqlMapClientTemplate().update("t_sys_dictionary.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends SysDictionaryExample {
        private Object record;

        public UpdateByExampleParms(Object record, SysDictionaryExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}