package web.news;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import base.HttpServletBase;

import com.common.Model;
import com.common.Pager;
import com.web.entity.Attach;
import com.web.entity.Flow;
import com.web.entity.News;
import com.web.entity.NewsCls;
import com.web.service.IAttachService;
import com.web.service.IFlowService;
import com.web.service.INewsClsService;
import com.web.service.INewsService;

@Controller("stu_news_do")
@RequestMapping("news/")
public class NewsDo extends HttpServletBase {
	
	@Autowired
	private INewsService newsService;
	@Autowired
	private INewsClsService newsClsService;
	@Autowired
	private IAttachService attachService;
	@Autowired
	private IFlowService flowService;
	
	@RequestMapping(value="news.do", method=RequestMethod.GET)
	public ModelAndView news(int page,String clsName){
		Map<String, Object> map=new HashMap<String, Object>();
		int pagesize=20;
		Model<News> model=newsService.getNewsByPage(page, pagesize, 0, clsName, "");
		List<News> list=model.getList();
		map.put("list", list);
		int count=model.getCount();
		Pager pager=Pager.Init(page, pagesize, count);
		String strPage=pager.getPager(request);
		map.put("strPager", strPage);
		List<NewsCls> newsClsList = newsClsService.getNewsCls(clsName);
		map.put("newsClsList", newsClsList);
		map.put("newsCls", newsClsList.get(0));
		//仿真实验教学资源
		List<Flow> flowList=flowService.getFlowByNum(4);
		map.put("flowList", flowList);
		return new ModelAndView("news/news", map);
	}
	
	@RequestMapping(value="content.do", method=RequestMethod.GET)
	public ModelAndView content(Integer newsAutoid){
		Map<String, Object> map=new HashMap<String, Object>();
		News news=newsService.getNewsByID(newsAutoid);
		map.put("news", news);
		List<Attach> list=attachService.getAttach(newsAutoid);
		map.put("list", list);
		//仿真实验教学资源
		List<Flow> flowList=flowService.getFlowByNum(4);
		map.put("flowList", flowList);
		return new ModelAndView("news/content", map);
	}
	
	@RequestMapping(value="down.do", method=RequestMethod.GET)
	public ModelAndView down(String path)throws IOException{
		String realPath=request.getSession().getServletContext().getRealPath("");
		realPath=realPath+path.replace("/", File.separator);
		File f=new File(realPath);
		response.setHeader("content-type","text/html; charset=ISO-8859-1");
		response.setContentType("APPLICATION/OCTET-STREAM");	
		response.setHeader("Content-Disposition","attachment; filename=\""+f.getName()+"\"");
		try{
			FileInputStream fileInputStream =new FileInputStream(f.getAbsolutePath());		
			int i;		
			while ((i=fileInputStream.read()) != -1){
				response.getWriter().write(i);	
			}
			fileInputStream.close();
			response.getWriter().close();
			return new ModelAndView();
		}catch (FileNotFoundException e) {
			return new ModelAndView("student/news/error");
		}
	}
}
