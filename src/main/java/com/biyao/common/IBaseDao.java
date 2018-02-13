package com.biyao.common;

import java.util.List;
import java.util.Map;

/**
 * BaseDao接口   对增删改查操作进行封装
 * @author hxs
 *
 */
public interface IBaseDao
{
	/**
	 * 添加记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void addObject(String value, Object obj);
	
	/**
	 * 删除记录 
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void deleteObject(String value, Object obj);
	
	/**
	 * 修改记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void updateObject(String value, Object obj);
	
	/**
	 * 查询单个记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 * @return      Object
	 */
	public Object queryObject(String value, Object obj);
	
	/**
	 * 查询列表【用于条件查询】
	 * 
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 * @return      List
	 */
	public List queryObjects(String value, Object obj);
	
	/**
	 * 查询列表【用于无条件查询】
	 * 
	 * @param value 需要执行的语句名称
	 * @return      List
	 */
	public List queryObjects(String value);
}
