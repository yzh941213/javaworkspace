package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.common.Json;
import com.web.entity.Flow;
import com.web.entity.Flowcls;
import com.web.entity.Friend;
import com.web.entity.News;
import com.web.entity.NewsCls;
import com.web.entity.Person;
import com.web.service.IFlowService;
import com.web.service.IFlowclsService;
import com.web.service.IFriendService;
import com.web.service.INewsClsService;
import com.web.service.INewsService;
import com.web.service.IPersonService;

import base.HttpServletBase;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller("index_do")
@RequestMapping("/")
public class Index extends HttpServletBase{
	@Autowired
	private INewsService newsService;
	@Autowired
	private IFriendService friendService;
	@Autowired
	private INewsClsService newsClsService;
	@Autowired
	private IPersonService personService;
	@Autowired
	private IFlowService flowService;
	@Autowired
	private IFlowclsService flowclsService;
	
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public ModelAndView index(){
		Map<String, Object> map=new HashMap<String, Object>();
		Person person=personService.getPerson(request);
		map.put("state", person==null?"0":"1");
		map.put("person", person);
		//校园风光
		List<News> schoolList=newsService.getNewsByClsNum("school", 0);
		map.put("schoolList", schoolList);
		//新闻资讯
		List<News> centerNewsList=newsService.getNewsByClsNum("centernews", 6);
		map.put("centerNewsList", centerNewsList);
		//中心简介
		List<News> introdeList=newsService.getNewsByClsNum("introde", 1);
		if(introdeList!=null && introdeList.size()>0){
			News introde=introdeList.get(0);
			//String content=Tools.Html2Text(introde.getContent());
			//String con=content.length()>150?content.substring(0,140)+"...":content;
			map.put("introde", introde);
			//map.put("inAutoid", introde.getNewsAutoid());
		}
		//合作企业
		List<News> oopList=newsService.getNewsByClsNum("company", 4);
		map.put("listOop", oopList);
		//虚拟仿真化工实验及过程仿真系统
		List<News> experimentList=newsService.getNewsByClsNum("experiment", 1);
		if(experimentList!=null && experimentList.size()>0){
			News experiment=experimentList.get(0);
			//String content=Tools.Html2Text(experiment.getContent());
			//String con=content.length()>150?content.substring(0,140)+"...":content;
			map.put("experiment", experiment);
			//map.put("exAutoid", experiment.getNewsAutoid());
		}
		//仿真实验教学资源
		List<Flow> flowList=flowService.getFlowByNum(4);
		map.put("flowList", flowList);
		
		//通知公告
		List<News> noticeList=newsService.getNewsByClsNum("notice", 10);
		map.put("noticeList", noticeList);
		//成果展示
		List<News> resultsList=newsService.getNewsByClsNum("results", 0);
		map.put("resultsList", resultsList);
		//相关链接
		List<Friend> friendList=friendService.getFriendByNum(6);
		map.put("friendList", friendList);
		return new ModelAndView("index", map);
	}
	
	@ResponseBody
	@RequestMapping(value="getNewsCls.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public String getNewsCls(String clsName){
		List<NewsCls> list=newsClsService.getNewsCls(clsName);
		String str=Json.getGson().toJson(list);
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value="getFooter.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public String getFooter(){
		News news = newsService.getNewsByShowIndex("bottom");
		String content=news.getContent();
		return content;
	}
	
	@ResponseBody
	@RequestMapping(value="getFlowcls.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public String getFlowcls(){
		List<Flowcls> list=flowclsService.getFlowcls("asc");
		String str=Json.getGson().toJson(list);
		return str;
	}
}
