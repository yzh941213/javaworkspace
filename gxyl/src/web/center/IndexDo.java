package web.center;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.entity.Attach;
import com.web.entity.Flow;
import com.web.entity.Menu;
import com.web.entity.News;
import com.web.entity.NewsCls;
import com.web.service.IAttachService;
import com.web.service.IFlowService;
import com.web.service.IMenuService;
import com.web.service.INewsClsService;
import com.web.service.INewsService;

import base.HttpServletBase;
@Controller("center_index")
@RequestMapping("center/")
public class IndexDo extends HttpServletBase{
	
	@Autowired
	private INewsClsService newsClsService;
	@Autowired
	private INewsService newsService;
	@Autowired
	private IAttachService attachService;
	@Autowired
	private IFlowService flowService;
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public  ModelAndView index(Integer newsClsAutoid,String clsName) {
		Map<String, Object> map=new HashMap<String, Object>();
		Menu menu=menuService.getMenuByModel(clsName);
		map.put("menu", menu);
		NewsCls newsCls=newsClsService.getNewsClsByID(newsClsAutoid);
		map.put("newsCls", newsCls);
		map.put("newsClsAutoid", newsClsAutoid);
		List<NewsCls> newsClsList=newsClsService.getNewsCls(clsName);
		map.put("newsClsList", newsClsList);
		List<News> newsList=newsService.getNewsByNewsClsAutoid(newsClsAutoid);
		if(newsList!=null && newsList.size()==1){
			Integer newsAutoid=newsList.get(0).getNewsAutoid();
			return new ModelAndView("redirect:content.do?newsAutoid="+newsAutoid+"&clsName="+clsName);
		}
		map.put("newsList", newsList);
		//仿真实验教学资源
		List<Flow> flowList=flowService.getFlowByNum(4);
		map.put("flowList", flowList);
		return new ModelAndView("center/index", map);
	}
	
	@RequestMapping(value="content.do", method=RequestMethod.GET)
	public ModelAndView content(Integer newsAutoid,String clsName){
		Map<String, Object> map=new HashMap<String, Object>();
		Menu menu=menuService.getMenuByModel(clsName);
		map.put("menu", menu);
		List<NewsCls> clsList=newsClsService.getNewsCls(clsName);
		map.put("newsClsList", clsList);
		News news=newsService.getNewsByID(newsAutoid);
		map.put("news", news);
		List<Attach> list=attachService.getAttach(newsAutoid);
		map.put("list", list);
		//仿真实验教学资源
		List<Flow> flowList=flowService.getFlowByNum(4);
		map.put("flowList", flowList);
		return new ModelAndView("center/content", map);
	}
	
	
	
	//==============================================================================================
	
	@RequestMapping(value="info.do", method=RequestMethod.GET)
	public ModelAndView info(String clsName){
		Map<String, Object> map=new HashMap<String, Object>();
		List<NewsCls> clsList=newsClsService.getNewsCls(clsName);
		map.put("newsClsList", clsList);
		News news=newsService.getNewsByShowIndex(clsName);
		Integer newsAutoid=0;
		if(news!=null){
			newsAutoid=news.getNewsAutoid();
		}else{
			List<News> list=newsService.getNewsByClsNum(clsName, 1);
			if(list!=null && list.size()>0){
				news=list.get(0);
				newsAutoid=news.getNewsAutoid();
			}
		}
		return new ModelAndView("redirect:/center/content.do?newsAutoid="+newsAutoid+"&clsName="+clsName);
	}
}
