package web.admin.news;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import base.HttpServletBase;

import com.web.entity.NewsCls;
import com.web.service.INewsClsService;

@Controller("newscls")
@RequestMapping("admin/news/newscls/")
public class NewsClsDo extends HttpServletBase {
	@Autowired
	private INewsClsService newsClsService;
	//返回到编辑视图
	@RequestMapping(value="add.do", method=RequestMethod.GET)
	public ModelAndView add(String clsName){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("action", "create.do");
		NewsCls newsCls=new NewsCls();
		newsCls.setClsName(clsName);
		map.put("newsCls", newsCls);
		return new ModelAndView("admin/news/editNewsCls", map);
	}
	//执行创建
	@RequestMapping(value="create.do", method=RequestMethod.POST)
	public ModelAndView create(NewsCls newsCls){
		NewsCls cls=newsClsService.create(newsCls);
		Map<String, Object> map=new HashMap<String, Object>();
		if(cls!=null){
			map.put("message", "保存成功！");
			map.put("url", request.getContextPath()+"/admin/news/index.do?page=1&model="+newsCls.getClsName());
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	//返回到编辑视图
	@RequestMapping(value="edit.do", method=RequestMethod.GET)
	public ModelAndView edit(Integer newsClsAutoid){
		NewsCls newsCls=newsClsService.getNewsClsByID(newsClsAutoid);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("action", "modify.do");
		map.put("newsCls", newsCls);
		return new ModelAndView("admin/news/editNewsCls", map);
	}
	//执行修改
	@RequestMapping(value="modify.do", method=RequestMethod.POST)
	public ModelAndView modify(NewsCls newsCls){
		int result=newsClsService.modify(newsCls);
		Map<String, Object> map=new HashMap<String, Object>();
		if(result!=0){
			map.put("message", "保存成功！");
			map.put("url", request.getContextPath()+"/admin/news/index.do?page=1&model="+newsCls.getClsName());
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	//执行删除
	@ResponseBody
	@RequestMapping(value="delete.do", method=RequestMethod.POST)
	public String delete(Integer newsClsAutoid){
		int result=newsClsService.delete(newsClsAutoid);
		return String.valueOf(result);
	}
}
