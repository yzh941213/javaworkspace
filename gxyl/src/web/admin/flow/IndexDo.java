package web.admin.flow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.entity.Flowcls;
import com.web.service.IFlowclsService;

import base.HttpServletBase;

@Controller("admin_flow_index")
@RequestMapping("admin/flow/")
public class IndexDo extends HttpServletBase{
	@Autowired
	private IFlowclsService flowclsService;
	
	private Map<String, Object> map=new HashMap<String, Object>();
	
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public ModelAndView index(){
		List<Flowcls> list=flowclsService.getFlowcls("asc");
		
		map.put("list", list);
		return new ModelAndView("admin/flow/index", map);
	}
	
	
}
