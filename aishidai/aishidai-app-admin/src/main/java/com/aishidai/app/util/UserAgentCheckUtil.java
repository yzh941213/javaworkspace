package com.aishidai.app.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shaka on 15/4/20.
 */
public class UserAgentCheckUtil {
    static String mobilePattern = "\\b(ip(hone|od)|android|opera m(ob|in)i"
            + "|windows (phone|ce)|blackberry"
            + "|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
            + "|laystation portable)|nokia|fennec|htc[-_]"
            + "|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
    static String tabletPattern = "\\b(ipad|tablet|(Nexus 7)|up.browser"
            + "|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

    static Pattern phonePat = Pattern.compile(mobilePattern, Pattern.CASE_INSENSITIVE);
    static Pattern tablePat = Pattern.compile(tabletPattern, Pattern.CASE_INSENSITIVE);

    public boolean check(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean isFromMobile = false;

        HttpSession session = request.getSession();
        //检查是否已经记录访问方式（移动端或pc端）
        if (null == session.getAttribute("ua")) {
            try {
                //获取ua，用来判断是否为移动端访问
                String userAgent = request.getHeader("USER-AGENT").toLowerCase();
                if (null == userAgent) {
                    userAgent = "";
                }
                isFromMobile = isMobileDevice(userAgent);
                //判断是否为移动端访问
                if (isFromMobile) {
                    session.setAttribute("ua", "mobile");
                } else {
                    session.setAttribute("ua", "pc");
                }
            } catch (Exception e) {
            }
        } else {
            isFromMobile = session.getAttribute("ua").equals("mobile");
        }

        return isFromMobile;
    }

    /**
     * 检测访问的user-agent
     */
    public static boolean isMobileDevice(String userAgent) {
        if (null == userAgent) {
            userAgent = "";
        }
        // 匹配
        Matcher matcherPhone = phonePat.matcher(userAgent);
        Matcher matcherTable = tablePat.matcher(userAgent);
        if (matcherPhone.find() || matcherTable.find()) {
            return true;
        } else {
            return false;
        }
    }
}
