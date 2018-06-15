package system.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * yzh
 * 2017年9月6日15:57:38
 * 拦截器
 */
public class Interceptors extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path =  request.getServletPath();
        // TODO: 2017/9/6 待处理的路径匹配规则

        return true;
    }

}
