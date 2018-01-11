package com.aishidai.app.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns="/*")
public class SessionFilter implements Filter {

    public void destroy() {
        System.out.println("过滤器销毁");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("执行过滤操作");
        chain.doFilter(request, response);
    }


    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }
}
