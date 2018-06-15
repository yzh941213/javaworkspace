package system.uitls;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
* @ClassName: ContextHolderUtils 
* @Description: TODO(上下文工具类) 
* @author  张代浩
* @date 2012-12-15 下午11:27:39 
*
 */
public class ContextHolderUtils {
	/**
	 * SpringMvc下获取request
	 * @return request
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;

	}
	/**
	 * SpringMvc下获取session
	 * 
	 * @return session
	 */
	public static HttpSession getSession() {
		HttpSession session = getRequest().getSession();
		return session;

	}

}
