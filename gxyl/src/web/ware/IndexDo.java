package web.ware;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.entity.Flowcls;
import com.web.entity.NewsCls;
import com.web.entity.Ware;
import com.web.service.IFlowclsService;
import com.web.service.INewsClsService;
import com.web.service.IWareService;

import base.HttpServletBase;

@Controller("ware_index_do2")
@RequestMapping("ware/")
public class IndexDo extends HttpServletBase{
	@Autowired
	private IWareService wareService;
	@Autowired
	private IFlowclsService flowclsService;
	@Autowired
	private INewsClsService newsClsService;
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public ModelAndView index(String type){
		Map<String, Object> map=new HashMap<String, Object>();
		Ware ware=wareService.getWare(type).get(0);
		map.put("ware", ware);
		map.put("type", type);
		List<Flowcls> flowclsList=flowclsService.getFlowcls("asc");
		map.put("flowclsList", flowclsList);
		List<NewsCls> newsClsList = newsClsService.getNewsCls("teacher");
		map.put("newsClsList", newsClsList);
		return new ModelAndView("ware/index", map);
	}
}
