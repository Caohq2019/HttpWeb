package com.mysky.company.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysky.company.entity.PageBean;
import com.mysky.company.entity.staffBean;
import com.mysky.company.server.Server;
import com.mysky.company.server.imp.ServerInfo;

public class Command extends HttpServlet {

	private String uri;
	
	/**
	 * Constructor of the object.
	 */
	public Command() {
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
		try {
			
			//1. 获取“当前页”参数；  (第一次访问当前页为null) 
			String currPage = request.getParameter("currentPage");
			// 判断
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// 第一次访问，设置当前页为1;
			}
			// 转换
			int currentPage = Integer.parseInt(currPage);
			if (request.getParameter("next")!=null) {
				System.out.println("next is ok");
				currentPage +=1;
				System.out.println("nextcurrentPage is "+currentPage);
			}
			if (request.getParameter("back")!=null) {
				System.out.println("back is ok");
				currentPage -=1;
				if (currentPage<1) {
					currentPage =1;
				}
				System.out.println("backcurrentPage is "+currentPage);
			}
			if (request.getParameter("first")!=null) {
				//System.out.println("next is ok");
				currentPage =1;
				System.out.println("firstcurrentPage is "+currentPage);
			}
			
			//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
			PageBean pageBean = new PageBean();
			pageBean.setCurrentPage(currentPage);;
			
			//3. 调用service  
			Server server=new ServerInfo();
			pageBean= server.FindAll(currentPage);    // 【pageBean已经被dao填充了数据】
			List<staffBean> list= pageBean.getPageData();
			
				//System.out.println("test"+list.get(0).getName()); 
				//System.out.println(list.get(1).getName()); 
				//System.out.println(list.get(2).getName()); 
			
		
			
			//4. 保存pageBean对象，到request域中
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("list", list);
			
			

			
			//5. 跳转 
			uri = "main.jsp";
		} catch (Exception e) {
			e.printStackTrace();  // 测试使用
			// 出现错误，跳转到错误页面；给用户友好提示
			//uri = "ErrorPage.jsp";
			throw new RuntimeException();
		}

		request.getRequestDispatcher(uri).forward(request, response);
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
		
		doGet(request, response);

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
