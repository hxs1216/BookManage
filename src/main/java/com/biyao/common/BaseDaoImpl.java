package com.biyao.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;


/**
 * BaseDao实现类   对增删改查操作进行封装
 * @author hxs
 *
 */
public class BaseDaoImpl extends SqlMapClientDaoSupport implements IBaseDao
{
	@Resource(name="sqlMapClient")
    public void setSuperSqlMapClient(SqlMapClient sqlMapClient)
	{
		super.setSqlMapClient(sqlMapClient);
    }
	
	/**
	 * 添加记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void addObject(String value,Object obj)
	{
		super.getSqlMapClientTemplate().insert(value, obj);
	}
	
	/**
	 * 删除记录	
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void deleteObject(String value,Object obj)
	{
		super.getSqlMapClientTemplate().delete(value, obj);
	}
	
	/**
	 * 修改记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void updateObject(String value,Object obj)
	{
		super.getSqlMapClientTemplate().update(value, obj);
	}
	
	/**
	 * 查询单条记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 * @return      Object
	 */
	public Object queryObject(String value,Object obj)
	{
		return super.getSqlMapClientTemplate().queryForObject(value, obj);
	}
	
	/**
	 * 查询列表【用于条件查询】
	 * 
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 * @return      List
	 */
	public List queryObjects(String value,Object obj)
	{
		return super.getSqlMapClientTemplate().queryForList(value,obj);
		
	}
	
	/**
	 * 查询列表【用于无条件查询】
	 * 
	 * @param value  需要执行的语句名称
	 * @return       List
	 */
	public List queryObjects(String value)
	{
		return super.getSqlMapClientTemplate().queryForList(value);
	}
}
