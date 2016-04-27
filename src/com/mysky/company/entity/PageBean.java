package com.mysky.company.entity;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable
{
	/**
	 * hash得到的verID
	 */
	private static final long serialVersionUID = 5428477810243896210L;
	
	//当前页数 每页容量 总的条目数 总页数 
	private int currentPage=1;
	private int pageCount=5;
	private int totalCount;
	private int totalPage;
	private List<staffBean> pageData;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		if ((totalCount % pageCount == 0)) {
			totalPage = totalCount / pageCount;
		} else {
			totalPage = totalCount / pageCount + 1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<staffBean> getPageData() {
		return pageData;
	}
	public void setPageData(List<staffBean> pageData) {
		this.pageData = pageData;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	
}
