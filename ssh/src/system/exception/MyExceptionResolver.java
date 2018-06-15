package system.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * user:yzh
 * date:2017年10月19日14:52:00
 * qq:963485106
 * info:spring-mvc 统一异常处理
 *
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println("-----------------异常开始-------------");
        e.printStackTrace();
        System.out.println("-----------------异常结束-------------");
        ModelAndView mv = new ModelAndView("/system/error");
        mv.addObject("error","出错了哦");
        return mv;
    }
}