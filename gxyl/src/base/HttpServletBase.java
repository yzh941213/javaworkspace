package base;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

public class HttpServletBase {
	protected HttpSession session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,HttpServletResponse response){
		try{
			this.request=request;
			this.response=response;	
			this.response.setContentType("content-type:text/html; charset=utf-8");
			this.request.setCharacterEncoding("UTF-8");
			this.session=request.getSession();
			this.session.setMaxInactiveInterval(60*60*2);//2个小时
			/*try{
				//this.writer=response.getWriter();
			}catch (IOException e) {
				
			}*/
		}catch(UnsupportedEncodingException ue){
			
		}
	}
}
