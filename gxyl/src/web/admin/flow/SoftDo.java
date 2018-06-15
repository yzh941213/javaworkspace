package web.admin.flow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import base.HttpServletBase;

import com.common.Model;
import com.common.Pager;
import com.web.entity.Soft;
import com.web.service.ISoftService;

@Controller("soft")
@RequestMapping("admin/soft/")
public class SoftDo extends HttpServletBase{
	@Autowired
	private ISoftService softService;
	
	@RequestMapping(value="soft.do", method=RequestMethod.GET)
	public ModelAndView soft(int page, Integer clsID){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("clsID", clsID);
		int pagesize=20;
		Model<Soft> model=softService.getSoftByPage(page, pagesize, clsID);
		List<Soft> list=model.getList();
		int count=model.getCount();
		map.put("list", list);
		Pager pager=Pager.Init(page, pagesize, count);
		Map<String, Object> pMap=pager.getPagerMap(request);
		map.put("pager", pMap);
		return new ModelAndView("admin/flow/soft", map);
	}
	
	@RequestMapping(value="editsoft.do", method=RequestMethod.GET)
	public ModelAndView addedit(Integer softAutoid, Integer clsID){
		Map<String, Object> map=new HashMap<String, Object>();
		if(softAutoid==null){
			Soft soft=new Soft();
			soft.setClsID(clsID);
			map.put("soft", soft);
			map.put("action", "create.do");
		}else {
			Soft soft=softService.getSoftByID(softAutoid);
			map.put("soft", soft);
			map.put("action", "modify.do");
		}
		return new ModelAndView("admin/flow/editsoft", map);
	}
	@RequestMapping(value="create.do", method=RequestMethod.POST, produces={"text/html; charset=UTF-8"})
	public ModelAndView create(Soft soft){
		Map<String, Object> map=new HashMap<String, Object>();
		Soft newSoft=softService.create(soft);
		if(newSoft!=null){
			map.put("message", "保存成功！");
			map.put("url", "soft.do?page=1&clsID="+soft.getClsID());
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	@RequestMapping(value="modify.do", method=RequestMethod.POST, produces={"text/html; charset=UTF-8"})
	public ModelAndView modify(Soft soft){
		Map<String, Object> map=new HashMap<String, Object>();
		int result=softService.modify(soft);
		if(result!=0){
			map.put("message", "保存成功！");
			map.put("url", "soft.do?page=1&clsID="+soft.getClsID());
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	@ResponseBody
	@RequestMapping(value="delete.do",method=RequestMethod.POST,produces={"text/html;charset=UTF-8"})
	public String delete(String autoids){
		int result=softService.delete(autoids);
		return String.valueOf(result);
	}
}
