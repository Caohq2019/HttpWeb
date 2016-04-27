package com.mysky.company.server;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysky.company.entity.PageBean;
import com.mysky.company.entity.staffBean;

public interface Server {
	public void AddInfo();
	public void DeleteInfo(int id);
	public void ModifyInfo(staffBean bean);
	public PageBean SelectInfo(staffBean bean,Date date);
	public PageBean FindAll(int currentPage);
	public staffBean PackBean(HttpServletRequest request);
}
