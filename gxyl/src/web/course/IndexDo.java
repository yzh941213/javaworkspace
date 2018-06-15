package web.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.common.Model;
import com.common.Pager;
import com.web.entity.Flow;
import com.web.entity.Flowcls;
import com.web.entity.Item;
import com.web.entity.NewsCls;
import com.web.entity.Soft;
import com.web.service.IFlowService;
import com.web.service.IFlowclsService;
import com.web.service.INewsClsService;
import com.web.service.IPersonService;
import com.web.service.ISoftService;

import base.HttpServletBase;

@Controller("course_index_do")
@RequestMapping("course/")
public class IndexDo extends HttpServletBase{
	@Autowired
	private IFlowclsService flowclsService;
	@Autowired
	private IFlowService flowService;
	@Autowired
	private IPersonService personService;
	@Autowired
	private ISoftService softService;
	@Autowired
	private INewsClsService newsClsService;
	
	private Map<String, Object> map=new HashMap<String, Object>();
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public ModelAndView index(int page, Integer fcAutoid){
		map.clear();
		map.put("fcAutoid", fcAutoid);
		Flowcls flowcls = new Flowcls();
		if(fcAutoid != 0){
			flowcls=flowclsService.getFlowclsByID(fcAutoid);
		}
		map.put("flowcls", flowcls);
		List<Flowcls> flowclsList=flowclsService.getFlowcls("asc");
		map.put("flowclsList", flowclsList);
		int pagesize=9;
		String state="已启用";
		Integer personAutoid=0;
		String del="false";
		Model<Map<String, Object>> model=flowService.getFlowMapByPage(page, pagesize, fcAutoid, state, personAutoid, del);
		List<Map<String, Object>> list=model.getList();
		map.put("flowList", list);
		int count=model.getCount();
		Pager pager=Pager.Init(page, pagesize, count);
		String strPager=pager.getPager(request);
		map.put("strPager", strPager);
		List<NewsCls> newsClsList = newsClsService.getNewsCls("teacher");
		map.put("newsClsList", newsClsList);
		return new ModelAndView("course/index", map);
	}
	
	@RequestMapping(value="flowinfo.do", method=RequestMethod.GET)
	public ModelAndView flowinfo(Integer flowAutoid){
		map.clear();
		Integer personAutoid=personService.getPersonAutoid(request);
		map.put("personAutoid", personAutoid);
		List<Flowcls> flowclsList=flowclsService.getFlowcls("asc");
		map.put("flowclsList", flowclsList);
		Flow flow=flowService.getFlowByID(flowAutoid);
		map.put("flow", flow);
		List<Item> itemList=flowService.getItemByFlow(flowAutoid, "false");
		map.put("itemList", itemList);
		List<NewsCls> newsClsList = newsClsService.getNewsCls("teacher");
		map.put("newsClsList", newsClsList);
		return new ModelAndView("course/soft", map);
	}
	
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public ModelAndView view(Integer flowAutoid){
		map.clear();
		List<Flowcls> flowclsList=flowclsService.getFlowcls("asc");
		map.put("flowclsList", flowclsList);
		Flow flow=flowService.getFlowByID(flowAutoid);
		map.put("flow", flow);
		List<NewsCls> newsClsList = newsClsService.getNewsCls("teacher");
		map.put("newsClsList", newsClsList);
		return new ModelAndView("course/video", map);
	}
	
	@RequestMapping(value="soft.do", method=RequestMethod.GET)
	public ModelAndView soft(int page,int clsID){
		map.clear();
		List<Flowcls> flowclsList=flowclsService.getFlowcls("asc");
		map.put("flowclsList", flowclsList);
		map.put("clsID", clsID);
		int pagesize=10;
		Model<Soft> model=softService.getSoftByPage(page, pagesize, clsID);
		List<Soft> list=model.getList();
		int count=model.getCount();
		Pager pager=Pager.Init(page, pagesize, count);
		map.put("softList", list);
		map.put("strPager", pager.getPager(request));
		return new ModelAndView("course/soft", map);
	}
	
}
