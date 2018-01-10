package com.aishidai.app.filter;

import com.aishidai.app.common.LoginConstant;
import com.aishidai.app.common.LoginUser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

	private static final Logger logger = LoggerFactory
			.getLogger(AuthFilter.class);

	private String sessionKey;
	private String brokerId;
	private String returnKey;

	public void init(FilterConfig config) throws ServletException {
		if (sessionKey == null) {
			sessionKey = LoginConstant.USER_SESSION_KEY;
		}

		if (brokerId == null) {
			brokerId = LoginConstant.LOGIN_LINK;
		}

		if (returnKey == null) {

		}
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// check if user login
		Status status = onStart((HttpServletRequest) request);

		if (status == null || status.user == null) {
			// 到登陆页面
			((HttpServletResponse) response).sendRedirect("/login.htm");
			return;
		}

		chain.doFilter(request, response);
	}

	public Status onStart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginUser user = null;

		try {
			user = (LoginUser) session.getAttribute(sessionKey);
		} catch (Exception e) {
			logger.error("", e);
		}

		// 将user设置到rundata中，以便其它程序使用。
		LoginUser.setCurrentUser(user);

		return new Status(user);
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = StringUtils.trimToNull(sessionKey);
	}

	public void setRedirectURI(String brokerId) {
		this.brokerId = StringUtils.trimToNull(brokerId);
	}

	public void setReturnKey(String returnKey) {
		this.returnKey = StringUtils.trimToNull(returnKey);
	}

	public String getUserName(Status status) {
		return status.user.getId();
	}

	public String[] getActions(Status status) {
		return null;
	}

	public void onAllow(Status status) throws Exception {

	}

	static class Status {
		private LoginUser user;

		public Status(LoginUser user) {
			this.user = user;
		}
	}

}
