package com.mysky.company.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysky.company.entity.staffBean;
import com.mysky.company.server.Server;
import com.mysky.company.server.imp.ServerInfo;

public class CommandPage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommandPage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id;
		Date date;
		Server server=new ServerInfo();
		staffBean bean=null;
		String CURD=request.getParameter("CURD");
		//String CURD= request.getParameter("CURD");
		System.out.println(CURD);

		
//		if (CURD.equalsIgnoreCase("點擊查詢")) {
//			bean=server.PackBean(request);
//			date=new Date( Long.parseLong(request.getParameter("dateEnd")));
//		}
//		if (CURD.equalsIgnoreCase("修改")) {
//			bean=server.PackBean(request);
//		}
//		if (CURD.equalsIgnoreCase("删除")) {
//			id=0;
//		}
//		if (CURD.equalsIgnoreCase("增加")) {
//			bean=server.PackBean(request);
//		}
		
		
		switch (CURD) {
//		case "增加":System.out.println("增加case1测试");request.getRequestDispatcher("AddInfo.jsp").forward(request, response);
//			break;
		case "确认增添":System.out.println("增加case测试");//server.AddInfo();
			break;
		case "刪除":System.out.println("刪除case测试");//server.DeleteInfo(id);
			break;
		case "修改"	:System.out.println("修改case测试");//server.ModifyInfo(bean);
			break;
		case "點擊查詢":System.out.println("點擊查詢case测试");//server.SelectInfo(bean, date);
			break;
//		case "首頁": doGet(request, response);
//			break;
//		case "上一頁": doGet(request, response);
//			break;
//		case "下一頁": doGet(request, response);
//			break;	
		default:
			break;
		}
		

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
