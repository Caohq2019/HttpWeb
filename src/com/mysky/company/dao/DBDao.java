package com.mysky.company.dao;

import java.sql.Date;
import java.util.List;

import com.mysky.company.entity.PageBean;
import com.mysky.company.entity.staffBean;

public interface DBDao 
{
	public void AddData(staffBean bean);
	public void DelteData(int id);
	public void ModifyData(staffBean bean);
	public List<staffBean> selectData(staffBean bean,Date date);
	public  PageBean FindPage(int currentPage);
	
}
