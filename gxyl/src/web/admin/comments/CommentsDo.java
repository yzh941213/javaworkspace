package web.admin.comments;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

import com.common.Model;
import com.common.Pager;
import com.web.entity.Comments;
import com.web.entity.Person;
import com.web.entity.Reply;
import com.web.service.ICommentsService;
import com.web.service.IPersonService;
import com.web.service.IReplyService;

import base.HttpServletBase;

@Controller
@RequestMapping("admin/comments/")
public class CommentsDo extends HttpServletBase {
	
	@Autowired
	private ICommentsService commentsService;
	@Autowired
	private IPersonService personService;
	@Autowired
	private IReplyService replyService;
	
	/**
	 * 帖子首页
	 * @param page
	 * @return
	 */
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public ModelAndView index(int page){
		int pagesize = 20;
		Map<String, Object> map = new HashMap<String, Object>();
		Model<Comments> comments = commentsService.getCommentsByPage(page, pagesize);
		map.put("commentsList", comments.getList());
		Pager pager = Pager.Init(page, pagesize, comments.getCount());
		Map<String, Object> map2 = pager.getPagerMap(request);
		map.put("pager", map2);
		return new ModelAndView("admin/comments/index",map);
	}
	
	/**
	 * 跳转到 新建/编辑页面
	 * @param commentsAutoid
	 * @return
	 */
	@RequestMapping(value="edit.do", method=RequestMethod.GET)
	public ModelAndView edit(Integer commentsAutoid){
		Map<String, Object> map = new HashMap<String, Object>();
		if(commentsAutoid != 0){
			Comments comment = commentsService.getCommentsByID(commentsAutoid);
			map.put("comment", comment);
			map.put("action", "modify.do");
		}else{
			map.put("action", "create.do");
		}
		return new ModelAndView("admin/comments/edit",map);
	}
	
	/**
	 * 新建帖子
	 * @param comments
	 * @return
	 */
	@RequestMapping(value="create.do", method=RequestMethod.POST, produces={"text/html; charset=UTF-8"})
	public ModelAndView create(Comments comments){
		Map<String, Object> map = new HashMap<String, Object>();
		Person person = personService.getPerson(request);
		comments.setPersonAutoid(person.getPersonAutoid());
		Comments comment = commentsService.create(comments);
		if(comment != null){
			map.put("message", "保存成功！");
			map.put("url", "index.do?page=1");
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	/**
	 * 编辑帖子
	 * @param comments
	 * @return
	 */
	@RequestMapping(value="modify.do", method=RequestMethod.POST, produces={"text/html; charset=UTF-8"})
	public ModelAndView modify(Comments comments){
		Map<String, Object> map = new HashMap<String, Object>();
		int result = commentsService.modify(comments);
		if(result!=0){
			map.put("message", "保存成功！");
			map.put("url", "index.do?page=1");
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	/**
	 * 删除帖子
	 * @param autoids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="delete.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public String delete(String autoids){
		int result = commentsService.delete(autoids);
		return String.valueOf(result);
	}
	
	/**
	 * 根据Title模糊查询
	 * @param page
	 * @param title
	 * @return
	 */
	@RequestMapping(value="getCommentByTitle.do",method=RequestMethod.GET, produces={"text/html;charset=UTF-8"})
	public ModelAndView getCommentByTitle(int page,String title){
		int pagesize = 20;
		Map<String, Object> map = new HashMap<String, Object>();
		Model<Comments> comments = commentsService.getCommentByTitle(page, pagesize, title);
		map.put("commentsList", comments.getList());
		Pager pager = Pager.Init(page, pagesize, comments.getCount());
		Map<String, Object> map2 = pager.getPagerMap(request);
		map.put("pager", map2);
		return new ModelAndView("admin/comments/index",map);
	}
	
	/**
	 * 初始化查看帖子回复内容页面
	 * @param page
	 * @param commentsAutoid
	 * @return
	 */
	@RequestMapping(value="check.do",method=RequestMethod.GET)
	public ModelAndView check(int page,Integer commentsAutoid){
		int pagesize = 15;
		Map<String, Object> map = new HashMap<String, Object>();
		Comments comment = commentsService.getCommentsByID(commentsAutoid);
		map.put("comment", comment);
		Model<Reply> reply = replyService.getReplyByPage(page, pagesize, commentsAutoid);
		map.put("replyList", reply.getList());
		Pager pager = Pager.Init(page, pagesize, reply.getCount());
		Map<String, Object> map2 = pager.getPagerMap(request);
		map.put("pager", map2);
		return new ModelAndView("admin/comments/check",map);
	}
	
	@RequestMapping(value="addReply.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public ModelAndView addReply(Reply reply){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer personAutoid = personService.getPersonAutoid(request);
		reply.setPersonAutoid(personAutoid);
		Reply r = replyService.create(reply);
		if(r != null){
			map.put("message", "保存成功！");
			map.put("url", "check.do?page=1&commentsAutoid="+r.getCommentsAutoid());
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	@ResponseBody
	@RequestMapping(value="deleteReply.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public String deleteReply(String autoids){
		int result = replyService.delete(autoids);
		return String.valueOf(result);
	}
	
	@RequestMapping(value="editReply.do", method=RequestMethod.GET)
	public ModelAndView editReply(Integer replyAutoid){
		Map<String, Object> map = new HashMap<String, Object>();
		Reply reply = replyService.getReplyByID(replyAutoid);
		map.put("reply", reply);
		return new ModelAndView("admin/comments/editReply",map);
	}
	
	@RequestMapping(value="modifyReply.do", method=RequestMethod.POST, produces={"text/html; charset=UTF-8"})
	public ModelAndView modifyReply(Reply reply){
		Map<String, Object> map = new HashMap<String, Object>();
		int result = replyService.modify(reply);
		if(result!=0){
			map.put("message", "保存成功！");
			map.put("url", "check.do?page=1&commentsAutoid="+reply.getCommentsAutoid());
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	@InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    }

}
