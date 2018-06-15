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
import com.web.entity.Person;
import com.web.entity.Reply;
import com.web.service.ICommentsService;
import com.web.service.IPersonService;
import com.web.service.IReplyService;

import base.HttpServletBase;

@Controller("reply_do")
@RequestMapping("comments/")
public class ReplyDo extends HttpServletBase{
	@Autowired
	private IPersonService personService;
	@Autowired
	private IReplyService replyService;
	@Autowired
	private ICommentsService commentsService;
	
	
	@RequestMapping(value="reply.do", method=RequestMethod.GET)
	public ModelAndView reply(int page, Integer commentsAutoid){
		Map<String, Object> map=new HashMap<String, Object>();
		Person person=personService.getPerson(request);
		map.put("person", person);
		int pagesize=20;
		Model<Reply> model=replyService.getReplyByPage(page, pagesize, commentsAutoid);
		List<Reply> list=model.getList();
		int count=model.getCount();
		map.put("list", list);
		Pager pager=Pager.Init(page, pagesize, count);
		String strPager=pager.getPager(request);
		map.put("strPager", strPager);
		Comments comments=commentsService.getCommentsByID(commentsAutoid);
		map.put("comments", comments);
		return new ModelAndView("comments/reply", map);
	}
	
	@RequestMapping(value="addreply.do", method=RequestMethod.POST)
	public ModelAndView addreply(Reply reply){
		Map<String, Object> map=new HashMap<String, Object>();
		Integer personAutoid=personService.getPersonAutoid(request);
		reply.setPersonAutoid(personAutoid);
		Reply r=replyService.create(reply);
		if(r!=null){
			map.put("message", "回复成功！");
			map.put("result", "right");
			map.put("url", "reply.do?page=1&commentsAutoid="+reply.getCommentsAutoid());
		}else{
			map.put("message", "回复失败！");
			map.put("result", "error");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("comments/result", map);
	}
}
