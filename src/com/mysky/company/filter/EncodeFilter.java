package com.mysky.company.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter
{
	private  String encoding;
	private Map<String, String> params = new HashMap<String, String>();  
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
        //System.out.println("end do the encoding filter!");  
        params=null;  
        encoding=null;  
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		   //UtilTimerStack.push("EncodingFilter_doFilter:");  
        //System.out.println("before encoding " + encoding + " filter！");  
        req.setCharacterEncoding(encoding); 
        resp.setCharacterEncoding(encoding);
        resp.setContentType("text/html");
        // resp.setCharacterEncoding(encoding);  
        // resp.setContentType("text/html;charset="+encoding);  
        chain.doFilter(req, resp);        
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
        System.out.println("begin do the encoding filter!");  
       encoding = config.getInitParameter("encoding");  
       for (Enumeration e = config.getInitParameterNames(); e.hasMoreElements();) {  
           String name = (String) e.nextElement();  
           String value = config.getInitParameter(name);  
           params.put(name, value);  
       }  
	}

}
