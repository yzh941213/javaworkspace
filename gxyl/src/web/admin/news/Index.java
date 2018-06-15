package web.admin.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.entity.NewsCls;
import com.web.service.INewsClsService;

@Controller("news_index")
@RequestMapping("admin/news/")
public class Index {
	@Autowired
	private INewsClsService newsClsService;
	
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public ModelAndView index(String model){
		List<NewsCls> list=newsClsService.getNewsCls(model);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("list", list);
		map.put("clsName", model);
		return new ModelAndView("admin/news/index", map);
	}
}
