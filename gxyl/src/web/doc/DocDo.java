package web.doc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.entity.Flow;
import com.web.service.IFlowService;

import base.HttpServletBase;

@Controller("doc_")
@RequestMapping("doc/")
public class DocDo extends HttpServletBase{
	@Autowired
	private IFlowService flowService;
	
	@RequestMapping(value="doc.do", method=RequestMethod.GET)
	public ModelAndView doc(Integer d){
		Map<String, Object> map=new HashMap<String, Object>();
		//仿真实验教学资源
		List<Flow> flowList=flowService.getFlowByNum(4);
		map.put("flowList", flowList);
		return new ModelAndView("doc/doc"+String.valueOf(d), map);
	}
}
