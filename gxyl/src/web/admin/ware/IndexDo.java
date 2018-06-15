package web.admin.ware;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import base.HttpServletBase;

@Controller("ware_index_do")
@RequestMapping("admin/ware/")
public class IndexDo extends HttpServletBase{
	
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public ModelAndView index(){
		Map<String, Object> map=new HashMap<String, Object>();
		return new ModelAndView("admin/ware/index", map);
	}
}
