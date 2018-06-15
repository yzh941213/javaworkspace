package com.common;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
/**
 * 分页类
 * */
public class Pager {

	public Pager(){}
	
	/**
	 * 初始化分页类
	 * @param pageindex当前页索引
	 * @param pagesize 每页数量
	 * @param count 总数量
	 * */
	public static Pager Init(int pageindex, int pagesize, int count){
		Pager pager=new Pager();
		pager.setCount(count);
		pager.setPageindex(pageindex);
		pager.setPagesize(pagesize);
		return pager;
	}
	private int pagesize;//每页数量
	private int pageindex;//页码
	private int count;//总数量
	
	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPageindex() {
		return pageindex;
	}

	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * 返回分页控件字符串
	 * */
	public String getPager(HttpServletRequest request) {
		String Url="";
		String queryString="";
		String pages=request.getParameter("page");
		String query="";
		Url=request.getContextPath() + request.getServletPath();
		queryString=request.getQueryString();//"page=2&mod=00&id=7"
		try{
			queryString=new String(queryString.getBytes("iso8859_1"),"utf-8");
		}catch (UnsupportedEncodingException e) {
			// TODO: handle exception
		}
		if(pages!=null){
			int page=Integer.parseInt(pages);
			query=queryString.replace("page="+page, "");
		}
		
		int rema = count % pagesize;
		int total = rema == 0 ? count / pagesize : count / pagesize + 1;
		if(total==0){
			total=1;
		}
		String pageInfo = "第" + pageindex + "页，";
		String pageTotal = "总共" + total + "页，";
		String totalNum = "总共" + count + "条，";
		String dropdownlist = "";
		StringBuilder sb=new StringBuilder();
		
		String firstPage="";//首页
		String nextPage="";//上一页
		String prevPage="";//下一页
		String lastPage="";//尾页
		if(pageindex > 1){
			prevPage = "<a href='" + Url + "?page=" + (pageindex - 1) + query + "'>上一页</a>&nbsp;";			
		}
		else{
			prevPage = "<a>上一页</a>&nbsp;";
		}
		if(pageindex < total){
			nextPage = "<a href='" + Url + "?page=" + (pageindex + 1) + query + "'>下一页</a>&nbsp;";
		}
		else{
			nextPage = "<a>下一页</a>&nbsp;";
		}
		firstPage = "<a href='" + Url + "?page=1" + query + "'>首页</a>&nbsp;";
		if(pageindex < total){
			String stp = pageindex != total ? Url + "?page=" + total + query : "";
			lastPage="<a href='" + stp + "'>尾页</a>&nbsp;";
		}
		else{
			lastPage="<a>尾页</a>&nbsp;";
		}
		
		sb.append("跳转到第\n<select id='selpage'>\n");
		for(int i=0;i<total;i++){
			String selected="";
			if(pageindex==(i+1)){
				selected="selected";
			}
			sb.append("<option "+selected+" value='"+Url+"?page="+(i+1)+query+"'>"+(i+1)+"</option>\n");
		}
		sb.append("</select>页");
		dropdownlist=sb.toString();
		String script=script().toString();
		return firstPage + prevPage + nextPage + lastPage + pageInfo + pageTotal + totalNum + dropdownlist+script;
	}
	private StringBuffer script(){
		StringBuffer sb=new StringBuffer();
		sb.append("\n<script type='text/javascript'>\n");
		//sb.append("$(document).ready(function(){\n");
		sb.append("//分页跳转函数\n");
		sb.append("$('#selpage').change(function(){\n");
		sb.append("window.location.href=$(this).val();\n");
		sb.append("});\n");
		//sb.append("});\n");
		sb.append("</script>");
		return sb;
	}
	public Map<String, Object> getPagerMap(HttpServletRequest request){
		Map<String, Object> map=new HashMap<String, Object>();
		String Url="";
		String queryString="";
		String pages=request.getParameter("page");
		String query="";
		Url=request.getContextPath() + request.getServletPath();
		queryString=request.getQueryString();//"page=2&mod=00&id=7"
		try{
			queryString=new String(queryString.getBytes("iso8859_1"),"utf-8");
		}catch (UnsupportedEncodingException e) {
			// TODO: handle exception
		}
		if(pages!=null){
			int page=Integer.parseInt(pages);
			query=queryString.replace("page="+page, "");
		}
		
		int rema = count % pagesize;
		int total = rema == 0 ? count / pagesize : count / pagesize + 1;
		if(total==0){
			total=1;
		}
		map.put("pagesize", pagesize);
		map.put("pageindex", pageindex);
		map.put("total", total);
		map.put("count", count);
		String pageInfo = "第" + pageindex + "页，";
		String pageTotal = "总共" + total + "页，";
		String totalNum = "总共" + count + "条，";
		String dropdownlist = "";
		StringBuilder sb=new StringBuilder();
		
		String firstPage="";//首页
		String nextPage="";//上一页
		String prevPage="";//下一页
		String lastPage="";//尾页
		if(pageindex > 1){
			//prevPage = "<a href='" + Url + "?page=" + (pageindex - 1) + query + "'>上一页</a>&nbsp;";
			map.put("prevPage", Url + "?page=" + (pageindex - 1) + query);
		}
		else{
			//prevPage = "<a>上一页</a>&nbsp;";
			map.put("prevPage", "#");
		}
		if(pageindex < total){
			//nextPage = "<a href='" + Url + "?page=" + (pageindex + 1) + query + "'>下一页</a>&nbsp;";
			map.put("nextPage", Url + "?page=" + (pageindex + 1) + query);
		}
		else{
			//nextPage = "<a>下一页</a>&nbsp;";
			map.put("nextPage", "#");
		}
		//firstPage = "<a href='" + Url + "?page=1" + query + "'>首页</a>&nbsp;";
		map.put("firstPage", Url + "?page=1" + query);
		if(pageindex < total){
			String stp = pageindex != total ? Url + "?page=" + total + query : "";
			lastPage="<a href='" + stp + "'>尾页</a>&nbsp;";
			map.put("lastPage", stp);
		}
		else{
			//lastPage="<a>尾页</a>&nbsp;";
			map.put("lastPage", "#");
		}
		
		sb.append("\n<select id='selpage'>\n");
		for(int i=0;i<total;i++){
			String selected="";
			if(pageindex==(i+1)){
				selected="selected";
			}
			sb.append("<option "+selected+" value='"+Url+"?page="+(i+1)+query+"'>"+(i+1)+"</option>\n");
		}
		sb.append("</select>");
		dropdownlist=sb.toString();
		map.put("dropDownList", dropdownlist);
		String script=script().toString();
		map.put("script", script);
		return map;
	}
}
