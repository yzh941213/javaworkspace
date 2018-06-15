package web.comments;

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
import com.web.entity.Comments;
import com.web.service.ICommentsService;
import com.web.service.IPersonService;

import base.HttpServletBase;

@Controller("comments_do")
@RequestMapping("comments/")
public class IndexDo extends HttpServletBase{
	@Autowired
	private ICommentsService commentsService;
	@Autowired
	private IPersonService personService;
	
	private Map<String, Object> map=new HashMap<String, Object>();
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public ModelAndView index(int page){
		map.clear();
		int pagesize=20;
		Model<Comments> model=commentsService.getCommentsByPage(page, pagesize);
		List<Comments> list=model.getList();
		map.put("list", list);
		int count=model.getCount();
		Pager pager=Pager.Init(page, pagesize, count);
		String strPager=pager.getPager(request);
		map.put("strPager", strPager);
		return new ModelAndView("comments/index", map);
	}
	@RequestMapping(value="comments.do", method=RequestMethod.GET)
	public ModelAndView comments(){
		return new ModelAndView("comments/comments");
	}
	@RequestMapping(value="add.do",method=RequestMethod.POST)
	public ModelAndView add(Comments comments){
		map.clear();
		Integer personAutoid=personService.getPersonAutoid(request);
		comments.setPersonAutoid(personAutoid);
		Comments c=commentsService.create(comments);
		if(c!=null){
			map.put("message", "提交成功！");
			map.put("result", "right");
			map.put("url", "index.do?page=1");
		}else {
			map.put("message", "提交失败！");
			map.put("result", "error");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("comments/result", map);
	}
}
