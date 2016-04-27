package com.mysky.company.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mysky.company.dao.DBDao;
import com.mysky.company.dao.iml.StaffDao;
import com.mysky.company.entity.staffBean;

/**
 * 测试数据添加
 * @author jeck
 *
 */
public class testAddData 
{
	public static void main(String argus[]) throws ParseException
	{
		//testselect();
		//TestDelete(12);
//		String str="1923-01-03";
//	    String[] strArr=str.split("-");
//	    StringBuffer sb = new StringBuffer();
//	    for(String s: strArr){
//	    sb.append(s);
//	    }
//	    str=sb.toString();
//		//long timer=Long.parseLong(str);
//		//Date date=new Date(timer);
//		System.out.println(str);
		
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
	}
	
	static void testselect(){
		staffBean bean=new staffBean();
		bean.setBirthday(new Date(00000000));
		Date date=new Date(1999-02-01);
		
		
		DBDao dao=new StaffDao();
		dao.selectData(bean, date);
	}
	
	static void TestDelete(int id)
	{
		
		StaffDao dao=new StaffDao();
		dao.DelteData(id);
	}
	
	void testadd()
	{
		int a=12;
		staffBean bean=new staffBean(a,"郭嘉",new Date(19830305),"男","害人",3);
		
		StaffDao staf=new StaffDao();
		staf.AddData(bean);
	}
}
