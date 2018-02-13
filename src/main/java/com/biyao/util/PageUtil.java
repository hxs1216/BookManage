package com.biyao.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 *@Author hxs
 */
public class PageUtil implements Serializable {
	/**
	 * 当前页
	 */
	private int currentPage = 1;

	/**
	 * 每页显示的记录数
	 */
	private int pageSize = 6;

	/**
	 * 总页数
	 */
	private int totalPage;

	/**
	 * 总记录数
	 */
	private int totalRecord;

	/**
	 * 起始记录
	 */
	private int startRow;

	/**
	 * 终止记录
	 */
	private int endRow;

	/**
	 * 上一页
	 */
	private int upPage;

	/**
	 * 下一页
	 */
	private int downPage;

	/**
	 * 访问路径
	 */
	private String accessUrl;

	//开始页数
	private int startPage;

	//结束页数
	private int endPage;

	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 当前页页码
	 */
	public void setCurrentPage(int currentPage) {
		if (currentPage <= 0) {
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 总页数，根据总记录数计算得出
	 */
	public int getTotalPage() {
		return this.totalRecord % this.pageSize == 0 ? this.totalRecord
				/ this.pageSize : (this.totalRecord / this.pageSize) + 1;
	}

	/**
	 * 总记录数
	 */
	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	/**
	 * 起始记录行,从0开始
	 */
	public int getStartRow() {
		return (this.currentPage - 1) * this.pageSize ;
	}

	/**
	 * 结束记录行
	 */
	public int getEndRow() {
		return this.currentPage * this.pageSize;
	}

	/**
	 * 上一页
	 */
	public int getUpPage() {
		return (this.currentPage == 1) ? 1 : (this.currentPage - 1);
	}

	/**
	 * 下一页
	 */
	public int getDownPage() {
		return (this.currentPage == this.totalPage) ? this.totalPage
				: (this.currentPage + 1);
	}

	public int getStartPage() {
		Map map = showStartOrEnd();
		return (Integer) map.get("start");
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		Map map = showStartOrEnd();
		return (Integer) map.get("end");
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	//获取第一页和最后一页
	public Map showStartOrEnd(){
		Map map = new HashMap();
		int curPage = getCurrentPage();
		int total = getTotalPage();
		int start = 0;
		int end = 0;
		if(total <= 6){
			start = 1;
			end = total;
		}else if(curPage<4){
			start = 1;
			end = 6;
		}else{
			start = curPage - 2;
			end = curPage + 3;
			if(end > total){
				int plus = end - total;
				start = start - plus;
				end = total;
			}
		}
		map.put("start",start);
		map.put("end",end);
		return map;
	}
}
