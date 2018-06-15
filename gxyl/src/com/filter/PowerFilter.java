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

public class PowerFilter implements Filter {

	private List list=null;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,	FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request= (HttpServletRequest) arg0;
		HttpServletResponse response= (HttpServletResponse) arg1;
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		Person person=(Person) session.getAttribute("person");
		String contextPath=request.getContextPath()+"/";
		String path=request.getRequestURI();
		path=path.replace(contextPath, "");
		String ajax=request.getHeader("x-Requested-with");
		if(ajax==null){
			if(session.getAttribute("person")==null){
				response.getWriter().print("<script>alert('您没有登陆或登陆超时，请重新登陆');top.window.location.href='"+contextPath+"index.do';</script>");
				return;
			}
			if(person.getPersonType().equals("admin")){
				chain.doFilter(request, response);
				return;
			}else{
				response.getWriter().print("您没有权限，action="+path+"<a href='javascript:history.back();'>返回</a>");
			}
		}else{
			if(session.getAttribute("person")==null){
				response.getWriter().print("{\"flag\":\"您没有登陆\",\"action\":\"\",\"session\":\"timeout\"}");
				return;
			}
			if(person.getPersonType().equals("admin")){
				chain.doFilter(request, response);
				return;
			}else{
				response.getWriter().print("{\"flag\":\"您没有权限\",\"action\":\""+path+"\"}");
			}
			
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		Properties prop=new Properties();
		InputStream in = PowerFilter.class.getResourceAsStream("admin.properties" );    
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
