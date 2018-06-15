package web.admin.menu;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.Model;
import com.common.Pager;
import com.web.entity.Menu;
import com.web.service.IMenuService;

import base.HttpServletBase;

@Controller("menu_do")
@RequestMapping("admin/menu/")
public class MenuDo extends HttpServletBase {
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping(value="menu.do", method=RequestMethod.GET)
	public ModelAndView menu(int page){
		int pagesize=20;
		Model<Menu> model=menuService.getMenuByPage(page, pagesize);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("list", model.getList());
		int count=model.getCount();
		Pager pager=Pager.Init(page, pagesize, count);
		Map<String, Object> map2=pager.getPagerMap(request);
		map.put("pager", map2);
		return new ModelAndView("admin/menu/menu", map);
	}
	
	@RequestMapping(value="addedit", method=RequestMethod.GET)
	public ModelAndView addedit(Integer menuAutoid){
		Map<String, Object> map=new HashMap<String, Object>();
		Menu menu;
		if(menuAutoid!=null){
			menu=menuService.getMenuByID(menuAutoid);
			map.put("action", "modify.do");
		}else{
			menu=new Menu();
			menu.setParentID(0);
			map.put("action", "create.do");
		}
		map.put("menu", menu);
		return new ModelAndView("admin/menu/addedit", map);
	}
	@RequestMapping(value="create.do", method=RequestMethod.POST)
	public ModelAndView create(Menu menu){
		Map<String, Object> map=new HashMap<String, Object>();
		Menu m=menuService.create(menu);
		if(m!=null){
			map.put("message", "保存成功！");
			map.put("url", "menu.do?page=1");
		}else {
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	@RequestMapping(value="modify.do", method=RequestMethod.POST)
	public ModelAndView modify(Menu menu){
		Map<String, Object> map=new HashMap<String, Object>();
		int result=menuService.modify(menu);
		if(result!=0){
			map.put("message", "保存成功！");
			map.put("url", "menu.do?page=1");
		}else {
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	@ResponseBody
	@RequestMapping(value="del.do", method=RequestMethod.POST)
	public String del(Integer menuAutoid){
		int result=menuService.delete(menuAutoid);
		return String.valueOf(result);
	}
	
	@ResponseBody
	@RequestMapping(value="hasModel.do", method=RequestMethod.POST)
	public String hasModel(String model, Integer menuAutoid){
		boolean b=menuService.hasModel(model, menuAutoid);
		if(b){
			return "1";
		}else{
			return "0";
		}
	}
}
