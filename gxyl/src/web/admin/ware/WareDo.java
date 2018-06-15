package web.admin.ware;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.entity.Ware;
import com.web.service.IWareService;

import base.HttpServletBase;

@Controller("ware_do")
@RequestMapping("admin/ware/")
public class WareDo extends HttpServletBase{
	@Autowired
	private IWareService wareService;
	
	@RequestMapping(value="ware.do", method=RequestMethod.GET)
	public ModelAndView ware(String type){
		Map<String, Object> map=new HashMap<String, Object>();
		List<Ware> list=wareService.getWare(type);
		map.put("list", list);
		return new ModelAndView("admin/ware/ware", map);
	}
	
	@RequestMapping(value="addedit.do", method=RequestMethod.GET)
	public ModelAndView addedit(Integer wareAutoid){
		Map<String, Object> map=new HashMap<String, Object>();
		Ware ware=new Ware();
		if(wareAutoid!=null && wareAutoid!=0){
			ware=wareService.getWareByID(wareAutoid);
			map.put("ware", ware);
			map.put("action", "modify.do");
		}
		return new ModelAndView("admin/ware/addedit", map);
	}
	@RequestMapping(value="modify.do", method=RequestMethod.POST)
	public ModelAndView modify(Ware ware){
		Map<String, Object> map=new HashMap<String, Object>();
		int result=wareService.modify(ware);
		if(result==1){
			map.put("message", "保存成功！");
			map.put("url", "ware.do?page=1&type=");
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
}
