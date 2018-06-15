package web.admin.flow;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.entity.Flowcls;
import com.web.service.IFlowclsService;

import base.HttpServletBase;

@Controller("admin_flow_flowcls")
@RequestMapping("admin/flowcls/")
public class FlowclsDo extends HttpServletBase{
	@Autowired
	private IFlowclsService flowclsService;
	
	private Map<String, Object> map=new HashMap<String, Object>();
	//导航到编辑视图
	@RequestMapping(value="addedit.do", method=RequestMethod.GET)
	public ModelAndView addeidt(Integer fcAutoid){
		//Map<String, Object> map=new HashMap<String, Object>();
		if(fcAutoid!=null){
			Flowcls flowcls=flowclsService.getFlowclsByID(fcAutoid);
			map.put("flowcls", flowcls);
			map.put("action", "modify.do");
		}else{
			Flowcls flowcls=new Flowcls();
			map.put("flowcls", flowcls);
			map.put("action", "create.do");
		}
		return new ModelAndView("admin/flow/editcls", map);
	}
	
	//创建
	@RequestMapping(value="create.do", method=RequestMethod.POST)
	public ModelAndView create(Flowcls flowcls){
		//Map<String, Object> map=new HashMap<String, Object>();
		Flowcls cls=flowclsService.create(flowcls);
		if(cls!=null){
			map.put("message", "保存成功！");
			map.put("url", "../flow/index.do?page=1");
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	//修改
	@RequestMapping(value="modify.do",method=RequestMethod.POST)
	public ModelAndView modify(Flowcls flowcls){
		int result=flowclsService.modify(flowcls);
		if(result==1){
			map.put("message", "保存成功！");
			map.put("url", "../flow/index.do?page=1");
		}else {
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	//删除
	@RequestMapping(value="delete.do", method=RequestMethod.POST)
	public String delete(Integer fcAutoid){
		int result=flowclsService.delete(fcAutoid);
		return String.valueOf(result);
	}
}
