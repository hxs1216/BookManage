package com.biyao.system.dao.impl;

import com.biyao.common.BaseDaoImpl;
import com.biyao.system.dao.ISysUserInfoDAO;
import com.biyao.system.model.SysUserInfo;
import com.biyao.system.model.SysUserInfoExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iSysUserInfoDAO")
public class SysUserInfoDAOImpl extends BaseDaoImpl implements ISysUserInfoDAO {

    public SysUserInfoDAOImpl() {
        super();
    }

    public int countByExample(SysUserInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_sys_userinfo.countByExample", example);
        return count;
    }

    public int deleteByExample(SysUserInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("t_sys_userinfo.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        SysUserInfo _key = new SysUserInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_sys_userinfo.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SysUserInfo record) {
        getSqlMapClientTemplate().insert("t_sys_userinfo.insert", record);
    }

    public void insertSelective(SysUserInfo record) {
        getSqlMapClientTemplate().insert("t_sys_userinfo.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<SysUserInfo> selectByExample(SysUserInfoExample example) {
        List<SysUserInfo> list = getSqlMapClientTemplate().queryForList("t_sys_userinfo.selectByExample", example);
        return list;
    }

    public SysUserInfo selectByPrimaryKey(Integer id) {
        SysUserInfo _key = new SysUserInfo();
        _key.setId(id);
        SysUserInfo record = (SysUserInfo) getSqlMapClientTemplate().queryForObject("t_sys_userinfo.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(SysUserInfo record, SysUserInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_sys_userinfo.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(SysUserInfo record, SysUserInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_sys_userinfo.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(SysUserInfo record) {
        int rows = getSqlMapClientTemplate().update("t_sys_userinfo.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SysUserInfo record) {
        int rows = getSqlMapClientTemplate().update("t_sys_userinfo.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends SysUserInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, SysUserInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}