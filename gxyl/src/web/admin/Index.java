package web.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import base.HttpServletBase;

import com.web.entity.Menu;
import com.web.entity.Person;
import com.web.service.IMenuService;
import com.web.service.IPersonService;

@Controller("admin_index")
@RequestMapping("admin/")
public class Index extends HttpServletBase {
	@Autowired
	private IPersonService personService;
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public ModelAndView index(){
		Map<String, Object> map=new HashMap<String, Object>();
		Person person=(Person) request.getSession().getAttribute("person");
		map.put("person", person);
		List<Menu> menuList=menuService.getAllMenu();
		map.put("menuList", menuList);
		return new ModelAndView("admin/index", map);
	}
	
	@RequestMapping(value="exit.do", method=RequestMethod.GET)
	public ModelAndView exit(){
		personService.signOut(request);
		String root=request.getContextPath();
		return new ModelAndView("redirect:"+"/index.do");
	}
	
}
