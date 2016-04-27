package com.mysky.company.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.management.RuntimeErrorException;

/**
 * mysql工具类 用于mysql数据库的连接和关闭
 * @author jeck  
 * @qq 1925777105
 *
 */
public class sqlUtil 
{
	private sqlUtil(){	}
	
	private static String url="jdbc:mysql:///company?useUnicode=true&amp;characterEncoding=UTF-8";
	private static String user="root";
	private static String pwd="1234";
	private static String driver="com.mysql.jdbc.Driver";
	
	/**
	 * 得到一个mysql数据库连接
	 * @return a connection;
	 */
	public static Connection GetConn()
	{
		Connection conn;
		try {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
				conn=DriverManager.getConnection(url,user,pwd);
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return conn;
	}
	
	/**
	 * 关闭连接
	 * @param conn connection 
	 * @param st   statement
	 * @param rs  result
	 */
	public static void CloseConn(Connection conn,Statement st,ResultSet rs)
	{
		
			try {
				if(rs!=null)
				{
				rs.close();
				rs=null;
				}
				if(st!=null)
				{
					st.close();
					st=null;
				}
				if(conn!=null&&!conn.isClosed())
				{
					conn.close();
					conn=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		
	}

	public static void CloseConn(Connection conn,Statement st)
	{
		
			try {
			if (st!=null) 
			{
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
				throw new RuntimeException(e); 
				
			}
		
		
	}
}
