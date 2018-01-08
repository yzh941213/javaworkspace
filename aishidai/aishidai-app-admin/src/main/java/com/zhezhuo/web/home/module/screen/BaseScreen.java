package com.zhezhuo.web.home.module.screen;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.web.home.common.session.SessionKeeper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Shaka on 15/4/5.
 */
public class BaseScreen {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Autowired
	protected HttpServletRequest request;

	// @Autowired
	protected HttpServletResponse response;

	protected final String tokenKey = "_tb_token_";

	public static final String ATTRIBUTE_ACOOKIEID_CNA = "cna";

	protected Logger getLogger() {
		return logger;
	}

	public String getSessionKey(String key) {
		return request.getParameter(key) == null ? null : String
				.valueOf(request.getParameter(key));
	}

	/**
	 *
	 * @param response
	 * @param resultCode
	 * @param resultText
	 */
	protected void resultJson(HttpServletResponse response, int resultCode,
			String resultText) {
		ServletOutputStream os = null;
		try {
			JSONObject json = new JSONObject();
			json.put("resultCode", resultCode);
			json.put("resultText", resultText);
			os = response.getOutputStream();
			os.write(json.toString().getBytes());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (null != os) {
				try {
					os.flush();
				} catch (IOException e1) {
					logger.error(e1.getMessage(), e1);
				}
				try {
					os.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * 获取请求的真实ip地址
	 * 
	 * @return
	 */
	protected String getIpAddr() {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 输出
	 * 
	 * @param result
	 * @param callBack
	 */
	public void convertJsonP(String result, String callBack) {
		// /oh my god.....我加的
		response.setHeader("Access-Control-Allow-Origin", "*");

		convertJsonP(result, callBack, "application/json");
	}

	public void convertJsonP(String result, String callBack, String contentType) {
		try {
			response.setContentType(contentType);
			if (!StringUtils.isBlank(callBack)) {
				this.response.getWriter().write(
						"\r\n" + callBack + "(" + result.toString() + ");");
			} else {
				this.response.getWriter().write(result.toString());
			}
		} catch (IOException e) {
			logger.error("get 0 items !");
		}
	}

	public long getUserIdFromSession() {
		HttpSession session = request.getSession();

		if (session != null
				&& session.getAttribute(SessionKeeper.ATTRIBUTE_USER_ID_NUM) != null) {
			return ((Long) session
					.getAttribute(SessionKeeper.ATTRIBUTE_USER_ID_NUM))
					.longValue();
		}

		return 0;
	}

}
