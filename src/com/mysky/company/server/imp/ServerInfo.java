package com.mysky.company.server.imp;

import java.sql.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysky.company.dao.DBDao;
import com.mysky.company.dao.iml.StaffDao;
import com.mysky.company.entity.PageBean;
import com.mysky.company.entity.staffBean;
import com.mysky.company.server.Server;

public class ServerInfo implements Server
{
	

	
	@Override
	public void AddInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteInfo(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ModifyInfo(staffBean bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageBean SelectInfo(staffBean bean, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public staffBean PackBean(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String strdate=req.getParameter("date");
		String[] strArr=strdate.split("-");
	    StringBuffer sb = new StringBuffer();
	    for(String s: strArr){
	    sb.append(s);
	    }
	    long date=Long.parseLong(sb.toString());
		
		staffBean bean=new staffBean();
		bean.setId(Integer.parseInt(req.getParameter("id")));
		bean.setName(req.getParameter("name"));
		bean.setBirthday(new Date(date));
		bean.setLove(req.getParameter("love"));
		bean.setSeID(Integer.parseInt(req.getParameter("seID")));
		bean.setSex(req.getParameter("sex"));
		return bean;
	}

	@Override
	public PageBean FindAll(int targetPage) {
		// TODO Auto-generated method stub
		DBDao dao=new StaffDao();
		PageBean pb=dao.FindPage(targetPage);
		
		
		return pb;
	}

}
