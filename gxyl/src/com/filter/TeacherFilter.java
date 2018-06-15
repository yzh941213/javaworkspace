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

public class TeacherFilter implements Filter {
	private List list=null;
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
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
				response.getWriter().print("<script>alert('您没有登陆或登陆超时，请重新登陆');top.window.location.href='"+contextPath+"login.jsp';</script>");
				return;
			}
			if(powerList!=null){
				if(powerList.contains(path) || person.getPersonType().equals("admin")){
					chain.doFilter(request, response);
					return;
				}else{
					response.getWriter().print("您没有权限，action="+path+"<a href='javascript:history.back();'>返回</a>");
				}
			}
		}else{
			if(person==null){
				response.getWriter().print("{\"flag\":\"您没有登陆\",\"action\":\"\",\"session\":\"timeout\",\"url\":\""+contextPath+"login.jsp\"}");
				return;
			}
			if(powerList!=null){
				if(powerList.contains(path) || person.getPersonType().equals("admin")){
					chain.doFilter(request, response);
					return;
				}else{
					response.getWriter().print("{\"flag\":\"您没有权限\",\"action\":\""+path+"\"}");
				}
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		Properties prop=new Properties();
		InputStream in = PowerFilter.class.getResourceAsStream("teacher.properties" );    
		try{    
			prop.load(in);
			Collection coll=prop.values();
			list=new ArrayList<String>(coll);
			String str="";
		}catch(IOException e) {    
		    e.printStackTrace();    
		}    

	}

}
