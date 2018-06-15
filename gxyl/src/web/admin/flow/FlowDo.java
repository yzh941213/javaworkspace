package web.admin.flow;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.IniReader;
import com.common.Json;
import com.common.Model;
import com.common.Pager;
import com.google.gson.reflect.TypeToken;
import com.web.entity.Flow;
import com.web.entity.Flowcls;
import com.web.entity.Item;
import com.web.service.IFlowService;
import com.web.service.IFlowclsService;
import com.web.service.IItemService;
import com.web.service.IPersonService;

import base.HttpServletBase;

@Controller("admin_flow_do")
@RequestMapping("admin/flow/")
public class FlowDo extends HttpServletBase{
	@Autowired
	private IFlowService flowService;
	@Autowired
	private IItemService itemService;
	@Autowired
	private IPersonService personService;
	@Autowired
	private IFlowclsService flowclsService;
	private	Map<String, Object> map= new HashMap<String, Object>();
	
	@RequestMapping(value="flow.do", method=RequestMethod.GET)
	public ModelAndView flow(int page,Integer fcAutoid, String flowName){
		int pagesize=20;
		String state="";
		Integer personAutoid=personService.getPersonAutoid(request);
		map.clear();
		Model<Map<String, Object>> model=flowService.getFlowMapByPage(page, pagesize, fcAutoid, state, personAutoid, "false");
		List<Map<String, Object>> list=model.getList();
		int count=model.getCount();
		Pager pager=Pager.Init(page, pagesize, count);
		Map<String, Object> pMap=pager.getPagerMap(request);
		map.put("list", list);
		map.put("pager", pMap);
		Flowcls flowcls=flowclsService.getFlowclsByID(fcAutoid);
		if(fcAutoid.equals(0)){
			flowcls=new Flowcls();
			flowcls.setFcAutoid(0);
		}
		map.put("flowcls", flowcls);
		return new ModelAndView("admin/flow/flow", map);
	}
	@RequestMapping(value="editflow.do", method=RequestMethod.GET)
	public ModelAndView editflow(Integer flowAutoid, Integer fcAutoid){
		map.clear();
		List<Flowcls> flowclsList=flowclsService.getFlowcls("asc");
		map.put("flowclsList", flowclsList);
		if(flowAutoid==null){
			Flow flow =new Flow();
			flow.setFcAutoid(fcAutoid);
			flow.setFlowType("soft");
			flow.setImageUrl("/images/co2.png");
			map.put("flow", flow);
			map.put("action", "create.do");
		}else{
			Flow flow=flowService.getFlowByID(flowAutoid);
			map.put("flow", flow);
			List<Item> itemList=itemService.getItemByFlow(flow.getFlowAutoid(), "");
			map.put("itemList", itemList);
			map.put("action", "modify.do");
		}
		return new ModelAndView("admin/flow/editflow", map);
	}
	
	@ResponseBody
	@RequestMapping(value="readini.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public String readIni(String filePath){
		String str="";
		Map<String, Object> data=new HashMap<String, Object>();
		String realPath=request.getSession().getServletContext().getRealPath("");
		String contextPath=request.getContextPath();
		//realPath=realPath.replace(contextPath, "");
		filePath=realPath+filePath.replace("/", File.separator);
		IniReader iniReader=new IniReader(filePath);
		String appName=iniReader.getValue("info", "AppName");
		data.put("appName", appName);
		String AppAuth=iniReader.getValue("info", "AppAuth");
		data.put("appAuth", AppAuth);
		String AppDesc = iniReader.getValue("info", "AppDesc");
		data.put("appDesc", AppDesc);
		Map<String, String> item=iniReader.getValue("Item");
		if(item==null){
			return "bad";
		}
		String ID=item.get("ID");
		data.put("itemID", ID);
		//String strItem="";
		String alr="";
		Integer flowAutoid = 0;
		List<Map<String, Object>> listMaps=new ArrayList<Map<String,Object>>();
		if(item.size()>0){
			for(int i=0;i<item.size()-1;i++){
				//System.out.println(item.get("Item"+String.valueOf(i)));
				String itemID=ID;
				int subID=i;
				List<Map<String, Object>> list = flowService.getFlowByItemID(itemID, subID);
				if(list.size()>0)
					flowAutoid = (Integer) list.get(0).get("flowAutoid");
				alr=list.size()>0?"y":"n";
				String cname=item.get("Item"+String.valueOf(i));
				Map<String, Object> cMap=new HashMap<String, Object>();
				cMap.put("itemID", itemID);
				cMap.put("subID", subID);
				cMap.put("itemName", cname);
				cMap.put("appName", appName);
				cMap.put("alr", alr);
				listMaps.add(cMap);
			}
			Map<String, Object> maps=new HashMap<String, Object>();
			maps.put("total", listMaps.size());
			maps.put("rows", listMaps);
			//System.out.println(flowAutoid);
			data.put("flowAutoid", flowAutoid);
			data.put("grid", maps);
			str=Json.getGson().toJson(data);
		}
		return str;
	}
	
	@RequestMapping(value="create.do", method=RequestMethod.POST)
	public ModelAndView create(Flow flow){
		map.clear();
		Integer personAutoid=personService.getPersonAutoid(request);
		flow.setPersonAutoid(personAutoid);
		String strItem=flow.getItems();
		List<Item> list=Json.getGson().fromJson(strItem, new TypeToken<List<Item>>(){}.getType());
		Flow f=flowService.create(flow, list);
		if(f!=null){
			map.put("message", "保存成功！");
			map.put("url", "flow.do?page=1&fcAutoid="+f.getFcAutoid());
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back()");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	@RequestMapping(value="modify.do", method=RequestMethod.POST)
	public ModelAndView modify(Flow flow){
		String strItem=flow.getItems();
		List<Item> list=Json.getGson().fromJson(strItem, new TypeToken<List<Item>>(){}.getType());
		Flow f=flowService.modify(flow, list);
		if(f!=null){
			map.put("message", "保存成功！");
			map.put("url", "flow.do?page=1&fcAutoid="+f.getFcAutoid());
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back()");
		}
		return new ModelAndView("admin/common/result", map);
	}
	
	@ResponseBody
	@RequestMapping(value="del.do", method=RequestMethod.POST)
	public String del(String autoids){
		int result=flowService.setFlowDel("true", autoids);
		return String.valueOf(result);
	}
	
///////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="editres.do", method=RequestMethod.GET)
	public ModelAndView editres(Integer flowAutoid, Integer fcAutoid, String flowType){
		map.clear();
		List<Flowcls> flowclsList=flowclsService.getFlowcls("asc");
		map.put("flowclsList", flowclsList);
		if(flowAutoid==null){
			Flow flow =new Flow();
			flow.setFcAutoid(fcAutoid);
			flow.setFlowType(flowType);
			flow.setImageUrl("/images/co2.png");
			map.put("flow", flow);
			map.put("action", "createres.do");
		}else{
			Flow flow=flowService.getFlowByID(flowAutoid);
			map.put("flow", flow);
			map.put("action", "modifyres.do");
		}
		return new ModelAndView("admin/flow/editres", map);
	}
	
	@RequestMapping(value="createres.do", method=RequestMethod.POST)
	public ModelAndView createres(Flow flow){
		map.clear();
		Integer personAutoid=personService.getPersonAutoid(request);
		flow.setPersonAutoid(personAutoid);
		Flow f=flowService.create(flow, null);
		if(f!=null){
			map.put("message", "保存成功！");
			map.put("url", "flow.do?page=1&fcAutoid="+f.getFcAutoid());
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back()");
		}
		return new ModelAndView("admin/common/result", map);
	}
	@RequestMapping(value="modifyres.do", method=RequestMethod.POST)
	public ModelAndView modifyres(Flow flow){
		int f=flowService.modify(flow);
		if(f!=0){
			map.put("message", "保存成功！");
			map.put("url", "flow.do?page=1&fcAutoid="+flow.getFcAutoid());
		}else{
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back()");
		}
		return new ModelAndView("admin/common/result", map);
	}
}
