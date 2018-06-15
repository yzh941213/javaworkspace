package web.admin.friend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.Model;
import com.common.Pager;
import com.web.entity.Friend;
import com.web.service.IFriendService;

import base.HttpServletBase;

@Controller("friend_do")
@RequestMapping("admin/friend/")
public class FriendDo extends HttpServletBase{
	@Autowired
	private IFriendService friendService;
	
	@RequestMapping(value="friend.do", method=RequestMethod.GET)
	public ModelAndView friend(int page){
		int pagesize=20;
		Map<String, Object> map=new HashMap<String, Object>();
		Model<Friend> model=friendService.getFriendByPage(page, pagesize);
		List<Friend> list=model.getList();
		map.put("list", list);
		int count=model.getCount();
		Pager pager=Pager.Init(page, pagesize, count);
		Map<String, Object> pagerMap=pager.getPagerMap(request);
		map.put("pager", pagerMap);
		return new ModelAndView("admin/friend/friend", map);
	}
	//返回到编辑视图
	@RequestMapping(value="addedit.do", method=RequestMethod.GET)
	public ModelAndView addedit(Integer friendAutoid){
		Map<String, Object> map=new HashMap<String, Object>();
		Friend friend;
		if(friendAutoid==null){
			friend=new Friend();
			map.put("friend", friend);
			map.put("action", "create.do");
		}else {
			friend=friendService.getFriendByID(friendAutoid);
			map.put("friend", friend);
			map.put("action", "modify.do");
		}
		return new ModelAndView("admin/friend/addedit", map);
	}
	//
	@RequestMapping(value="create.do", method=RequestMethod.POST)
	public ModelAndView create(Friend friend){
		Map<String, Object> map=new HashMap<String, Object>();
		Friend f=friendService.create(friend);
		if(f!=null){
			map.put("message", "保存成功！");
			map.put("url", request.getContextPath()+"/admin/friend/friend.do?page=1");
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	@RequestMapping(value="modify.do", method=RequestMethod.POST)
	public ModelAndView modify(Friend friend){
		Map<String, Object> map=new HashMap<String, Object>();
		int result=friendService.modify(friend);
		if(result==1){
			map.put("message", "保存成功！");
			map.put("url", request.getContextPath()+"/admin/friend/friend.do?page=1");
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	@ResponseBody
	@RequestMapping(value="del.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public String del(Integer friendAutoid){
		int result=friendService.delete(friendAutoid);
		return String.valueOf(result);
	}
}
