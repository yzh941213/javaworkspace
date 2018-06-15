package com.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.entity.Person;

public class StudentFilter implements Filter {
	private List list=null;
	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,	FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request= (HttpServletRequest) arg0;
		HttpServletResponse response= (HttpServletResponse) arg1;
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		List<String> powerList=new ArrayList<String>(list);
		if(session.getAttribute("power")!=null){
			powerList.addAll((List<String>) session.getAttribute("power"));
		}
		String contextPath=request.getContextPath()+"/";
		String path=request.getRequestURI();
		path=path.replace(contextPath, "");
		String ajax=request.getHeader("x-Requested-with");
		Person person=(Person)session.getAttribute("person");
		if(ajax==null){
			if(person==null){
				response.getWriter().print("<script>alert('您没有登陆或登陆已超时，请重新登陆');top.window.location.href='"+contextPath+"index.do';</script>");
				return;
			}else{
				chain.doFilter(request, response);
			}
		}else{
			if(person==null){
				response.getWriter().print("{\"flag\":\"您没有登陆\",\"action\":\"\",\"session\":\"timeout\",\"url\":\""+contextPath+"index.do\"}");
				return;
			}else {
				chain.doFilter(request, response);
			}
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		Properties prop=new Properties();
		InputStream in = PowerFilter.class.getResourceAsStream("student.properties" );    
		try{    
			prop.load(in);
			Collection<Object> coll=prop.values();
			list=new ArrayList<Object>(coll);
		}catch(IOException e) {    
		    e.printStackTrace();    
		}
	}

}
