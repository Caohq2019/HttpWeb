package com.mysky.company.dao.iml;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import com.mysky.company.dao.DBDao;
import com.mysky.company.entity.PageBean;
import com.mysky.company.entity.staffBean;
import com.mysky.company.util.sqlUtil;

public class StaffDao implements DBDao
{
	/**
	 * 添加一条数据
	 */
	@Override
	public void AddData(staffBean bean) 
	{
		Connection conn= sqlUtil.GetConn();
		try {
			PreparedStatement st= conn.prepareStatement(
			"insert into employee values(?,?,?,?,?,?)");
			st.setInt(1, bean.getId());
			st.setString(2, bean.getName());
			st.setDate(3, bean.getBirthday());
			st.setString(4, bean.getSex());
			st.setString(5, bean.getLove());
			st.setInt(6, bean.getSeID());
			st.executeUpdate();
			if (st!=null) {
				st.close();
				st=null;
			}
			if (conn!=null&&!conn.isClosed()) {
				conn.close();
				conn=null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 删除一条数据
	 */
	@Override
	public void DelteData(int id) {
		// TODO Auto-generated method stub
		Connection conn= sqlUtil.GetConn();
		try {
			PreparedStatement st=conn.prepareStatement(
					"delete from employee where id=?");
			st.setInt(1, id);
			 st.executeUpdate();
			sqlUtil.CloseConn(conn, st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 修改一条数据
	 */
	@Override
	public void ModifyData(staffBean bean) {
		// TODO Auto-generated method stub
		Connection conn=sqlUtil.GetConn();
		try {
			PreparedStatement st= conn.prepareStatement(
					"update employee set name=?,birthday=?,sex=?,love=?,seID=? where id=?");
			st.setString(1, bean.getName());
			st.setDate(2, bean.getBirthday());
			st.setString(3, bean.getSex());
			st.setString(4, bean.getLove());
			st.setInt(5, bean.getSeID());
			st.setInt(6, bean.getId());
			sqlUtil.CloseConn(conn, st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	@Override
	/**条件查询函数
	 * date 参数为结束时间
	 */
	public List<staffBean> selectData(staffBean bean,Date date) {
		// TODO Auto-generated method stub
		
		String timeCase;
		String seIDCase;
		String nameCase;
		String sexCase;
		String loveCase;
		//日期查询
		if((bean.getBirthday()==null)||(date==null))
		{
			timeCase=" ";
		}else{
			timeCase="and birthday between "+bean.getBirthday()+ "  and  "+date+"";
		}
		//部门查询
		if(bean.getSeID()!=0)
		{
			seIDCase="  and seID="+"'"+bean.getSeID()+"'";
		}
		else{
			seIDCase=" ";
		}
		//姓名查询
		if(bean.getName()!=null){
			nameCase=" and name="+bean.getName();
		}
		else{
			nameCase=" ";
		}
		//性别查询
		if (bean.getSex()!=null) {
			sexCase="and sex="+bean.getSex();
		}else{
			sexCase="";
		}
		//爱好查询
		if(bean.getLove()!=null){
			loveCase="and love="+bean.getLove();
		}else{
			loveCase="";
		}
		
		
		
		Connection conn=sqlUtil.GetConn();
				 try {
					 
					 Statement st=conn.createStatement();
					 System.out.println("timeCase::"+timeCase);
						System.out.println("timeCase::"+timeCase);
						System.out.println("nameCase::"+nameCase);
						System.out.println("sexCase::"+sexCase);
						System.out.println("loveCase::"+loveCase);
					ResultSet rs=st.executeQuery(
					"select * from employee where id between 0 and 9999 "+timeCase+seIDCase+nameCase+sexCase+loveCase+" ");
					
					if(rs.next())
					{
						rs.beforeFirst();
						List<staffBean> list=new ArrayList<staffBean>();
						staffBean bean1=new staffBean();
						
						while(rs.next()){	
							bean1.setId(rs.getInt(1));
							bean1.setName(rs.getString(2));
							bean1.setBirthday(rs.getDate(3));
							bean1.setSex(rs.getString(4));
							bean1.setLove(rs.getString(5));
							bean1.setSeID(rs.getInt(6));
							list.add(bean1);
							
							System.out.print(bean1.getId()+"==");
							System.out.print(bean1.getName()+"==");
							System.out.print(bean1.getBirthday()+"==");
							System.out.print(bean1.getSex()+"==");
							System.out.print(bean1.getLove()+"==");
							System.out.print(bean1.getSeID()+"==");
							System.out.println();
							
						}
						sqlUtil.CloseConn(conn, st,rs);
						return list;
					}else{
						System.out.println("muhaha");
						sqlUtil.CloseConn(conn, st,rs);
						return null;
					}
				 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
		
	}

	/**
	 * 分页查找
	 */
	@Override
	public PageBean FindPage(int targetPage) {
		// TODO Auto-generated method stub
		PageBean pb=new PageBean();
		staffBean bean;
		List<staffBean> list=new ArrayList<staffBean>();
		
		int lastrow;
		int count=5;
		int target;
		String sql="select * from employee  limit ?,?";
		
		if (targetPage>pb.getTotalPage()&&(pb.getTotalPage()!=0)) {
			targetPage=pb.getTotalPage();
		}
			target=(targetPage-1)*count;
			System.out.println("targetPage is"+targetPage);
			
		try {
			Connection conn=sqlUtil.GetConn();
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,target);
			pst.setInt(2, count);
			ResultSet rs= pst.executeQuery();
			if (rs.next()) {
				rs.beforeFirst();
				
				while(rs.next()){
					bean=new staffBean();
					bean.setId(rs.getInt("id"));
					bean.setSeID(rs.getInt("seID"));
					bean.setBirthday(rs.getDate("birthday"));
					bean.setLove(rs.getString("love"));
					bean.setName(rs.getString("name"));
					bean.setSex(rs.getString("sex"));
					
					list.add(bean);
					bean=null;
//					System.out.println(bean.getName());
//					System.out.print(bean.getId());
//					System.out.print(bean.getLove());
//					System.out.print(bean.getBirthday());
//					System.out.println();
				}	
				
				rs.last();
				lastrow= rs.getRow();
//				if (bean.getId()==0) {
//					lastrow= rs.getRow();
//				}
//				else {
//					Statement sta= conn.createStatement();
//					ResultSet rs2= sta.executeQuery("select count(*) from employee");
//					lastrow=rs2.getInt(1);
//				}
				
				sqlUtil.CloseConn(conn, pst,rs);
				int totalPage=(int) Math.ceil((double)lastrow/count);

				pb.setCurrentPage(targetPage);
				pb.setPageData(list);
				pb.setPageCount(count);
				pb.setTotalCount(lastrow);
				pb.setTotalPage(totalPage);
			}
			else{
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return pb;
	}

}
