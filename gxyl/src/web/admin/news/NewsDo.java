package web.admin.news;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import base.HttpServletBase;

import com.common.Json;
import com.common.Model;
import com.common.Pager;
import com.google.gson.reflect.TypeToken;
import com.web.entity.Attach;
import com.web.entity.News;
import com.web.entity.NewsCls;
import com.web.service.IAttachService;
import com.web.service.INewsClsService;
import com.web.service.INewsService;
import com.web.service.IPersonService;

@Controller("news_do")
@RequestMapping("admin/news/")
public class NewsDo extends HttpServletBase {
	@Autowired
	private INewsService newsService;
	@Autowired
	private INewsClsService newsClsService;
	@Autowired
	private IPersonService personService;
	@Autowired
	private IAttachService attachService;
	
	@RequestMapping(value="news.do", method=RequestMethod.GET)
	public ModelAndView news(int page, Integer newsClsAutoid, String clsName, String title){
		int pagesize=20;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("clsName", clsName);
		Model<News> model=newsService.getNewsByPage(page, pagesize, newsClsAutoid, clsName, title);
		List<News> list=model.getList();
		int count=model.getCount();
		map.put("list", list);
		Pager pager=Pager.Init(page, pagesize, count);
		Map<String, Object> map2=pager.getPagerMap(request);//分页数据
		map.put("pager", map2);
		map.put("title", title);
		return new ModelAndView("admin/news/news", map);
	}
	
	@RequestMapping(value="addedit.do", method=RequestMethod.GET)
	public ModelAndView addedit(Integer newsClsAutoid, String clsName, Integer newsAutoid){
		Map<String, Object> map=new HashMap<String, Object>();
		List<NewsCls> clsList=newsClsService.getNewsCls(clsName);
		map.put("clsList", clsList);
		if(newsAutoid==null){
			News news=new News();
			news.setNewsAutoid(0);
			news.setNewsClsAutoid(newsClsAutoid);
			Date date=new Date();
			news.setDate(date);
			map.put("news", news);
			map.put("action", "create.do");
		}else{
			News news=newsService.getNewsByID(newsAutoid);
			List<Attach> list=attachService.getAttach(newsAutoid);
			map.put("news", news);
			map.put("attachList", list);
			map.put("action", "modify.do");
		}
		
		return new ModelAndView("admin/news/editnews", map);
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
	@RequestMapping(value="create.do", method=RequestMethod.POST, produces={"text/html; charset=UTF-8"})
	public ModelAndView create(News news){
		Map<String, Object> map=new HashMap<String, Object>();
		Integer personAutoid=personService.getPersonAutoid(request);
		//Map<String, String> mapDate=Json.getGson().fromJson(data, new TypeToken<Map<String, String>>(){}.getType());
		//String strNews=mapDate.get("news");
		String strAttachs=news.getAttachs();		
		//News news=Json.getGson().fromJson(strNews, News.class);
		news.setPersonAutoid(personAutoid);
		List<Attach> list=Json.getGson().fromJson(strAttachs, new TypeToken<List<Attach>>(){}.getType());
		News ns=newsService.create(news, list);
		
		if(ns!=null){
			map.put("message", "保存成功！");
			map.put("url", "news.do?page=1&newsClsAutoid="+news.getNewsClsAutoid()+"&clsName="+ns.getNewsCls().getClsName()+"&title=");
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	@RequestMapping(value="modify.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public ModelAndView modify(News news){
		Map<String, String> map= new HashMap<String, String>();
		//String strNews=mapDate.get("news");
		String strAttachs=news.getAttachs();		
		//News news=Json.getGson().fromJson(strNews, News.class);
		List<Attach> list=Json.getGson().fromJson(strAttachs, new TypeToken<List<Attach>>(){}.getType());
		int result=newsService.modify(news, list);
		String clsName=newsClsService.getNewsClsByID(news.getNewsClsAutoid()).getClsName();
		if(result!=0){
			map.put("message", "保存成功！");
			map.put("url", request.getContextPath()+"/admin/news/news.do?page=1&newsClsAutoid="+news.getNewsClsAutoid()+"&clsName="+clsName+"&title=");
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	@ResponseBody
	@RequestMapping(value="delete.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public String delete(String autoids){
		int result=newsService.delete(autoids);
		return String.valueOf(result);
	}
	
	@ResponseBody
	@RequestMapping(value="setShowIndex.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public String setShowIndex(Integer newsAutoid){
		News news=newsService.getNewsByID(newsAutoid);
		int newsClsAutoid=news.getNewsClsAutoid();
		int result=newsService.setShowIndex(newsClsAutoid, newsAutoid);
		return String.valueOf(result);
	}
	
	@InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    }
}
