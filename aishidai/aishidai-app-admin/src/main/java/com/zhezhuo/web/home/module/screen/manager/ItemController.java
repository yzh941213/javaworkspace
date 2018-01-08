package com.zhezhuo.web.home.module.screen.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.dao.AttributeDAO;
import com.zhezhuo.biz.dao.PropertyDAO;
import com.zhezhuo.biz.dao.SkuDAO;
import com.zhezhuo.biz.dao.SysUsersDAO;
import com.zhezhuo.biz.manager.ItemManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ItemDO;
import com.zhezhuo.model.query.ItemQuery;
import com.zhezhuo.web.util.PhotoUtil;

@Controller
@RequestMapping("/manager/item")
public class ItemController {

	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	@Autowired
	private ItemManager itemManager;
	@Autowired
	private AttributeDAO attributeDAO;
	
	@Autowired
	private PropertyDAO propertyDAO;
	@Autowired
	private SkuDAO skuDAO;
	@Autowired
	private SysUsersDAO sysUsersDAO;

	
	
	@RequestMapping("/list.do")
	@ResponseBody
	public String queryItemDOList(
			@RequestParam(value = "cid", defaultValue = "", required = false) String categoryId,//类目
			@RequestParam(value = "recommend", defaultValue = "0", required = false) int recommend,//是否推荐
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,//
			@RequestParam(value = "order", defaultValue = "desc", required = false) String order,
			@RequestParam(value="itemId",defaultValue="",required=false) String itemId,
			@RequestParam(value="itemName",defaultValue="",required=false) String itemName,
			@RequestParam(value="itemStatus",defaultValue="-8",required=false)int itemStatus) {//

		JSONArray jsonarray = JSONArray.parseArray(aoData);
		String sEcho = null;
		int iDisplayStart = 0; // 起始索引
		int iDisplayLength = 0; // 每页显示的行数
		
		for (int i = 0; i < jsonarray.size(); i++) {
			JSONObject obj = (JSONObject) jsonarray.get(i);
			if (obj.get("name").equals("sEcho")) {
				sEcho = obj.get("value").toString();
			}
			if (obj.get("name").equals("iDisplayStart")) {
				iDisplayStart = obj.getIntValue("value");
			}
			if (obj.get("name").equals("iDisplayLength")) {
				iDisplayLength = obj.getIntValue("value");
			}
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("pageSize", iDisplayLength);
		jsonObject.put("sEcho", sEcho);
		jsonObject.put("success", false);

		ItemQuery query = new ItemQuery();
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);
		
		query.setCategoryIds(categoryId);
		query.setItemStatus(itemStatus);
		query.setItemCode(itemId);
		query.setItemName(itemName);
		
		query.setOrder(order);
		
		query.setSortField("itemId");
		Result<List<ItemDO>> result = null;
		try {
			result = itemManager.queryItemDOList(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnString(result, jsonObject, query);
	}
	
	@RequestMapping("/listDel.do")
	@ResponseBody
	public String queryItemDODelList(
			@RequestParam(value = "cid", defaultValue = "0", required = false) int categoryId,//类目
			@RequestParam(value = "recommend", defaultValue = "0", required = false) int recommend,//是否推荐
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,//
			@RequestParam(value = "order", defaultValue = "desc", required = false) String order) {//

		JSONArray jsonarray = JSONArray.parseArray(aoData);
		String sEcho = null;
		int iDisplayStart = 0; // 起始索引
		int iDisplayLength = 0; // 每页显示的行数
		
		for (int i = 0; i < jsonarray.size(); i++) {
			JSONObject obj = (JSONObject) jsonarray.get(i);
			if (obj.get("name").equals("sEcho")) {
				sEcho = obj.get("value").toString();
			}
			if (obj.get("name").equals("iDisplayStart")) {
				iDisplayStart = obj.getIntValue("value");
			}
			if (obj.get("name").equals("iDisplayLength")) {
				iDisplayLength = obj.getIntValue("value");
			}
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("pageSize", iDisplayLength);
		jsonObject.put("sEcho", sEcho);
		jsonObject.put("success", false);

		ItemQuery query = new ItemQuery();
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);

		query.setOrder(order);
		query.setSortField("itemId");
		Result<List<ItemDO>> result = null;
		try {
			result = itemManager.queryItemDODelList(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnString(result, jsonObject, query);
	}
	
	@RequestMapping("/list5.do")
	@ResponseBody
	public String queryItemDOList2(
			@RequestParam(value = "cid", defaultValue = "0", required = false) int categoryId,//类目
			@RequestParam(value = "recommend", defaultValue = "0", required = false) int recommend,//是否推荐（字段原来是设计为多种状态、可以排序的）
			@RequestParam(value = "nameId", defaultValue = "-1", required = false) long nameId,//品名
			@RequestParam(value = "price", defaultValue = "0", required = false) String price,//价格
			@RequestParam(value = "ageId", defaultValue = "0", required = false) int ageId,//年龄段?
			@RequestParam(value = "sizeId", defaultValue = "0", required = false) long sizeId,
			@RequestParam(value = "colourId", defaultValue = "0", required = false) long colourId,//
			@RequestParam(value = "occasionId", defaultValue = "0", required = false) long occasionId,//场合
			@RequestParam(value = "search", defaultValue = "", required = false) String search,//
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,//
			@RequestParam(value = "sort", defaultValue = "itemId", required = false) String sort,//
			@RequestParam(value = "order", defaultValue = "desc", required = false) String order,//
			@RequestParam(value = "status", defaultValue = "10", required = false) int status) {//

		JSONArray jsonarray = JSONArray.parseArray(aoData);
		String sEcho = null;
		int iDisplayStart = 0; // 起始索引
		int iDisplayLength = 0; // 每页显示的行数
		
		for (int i = 0; i < jsonarray.size(); i++) {
			JSONObject obj = (JSONObject) jsonarray.get(i);
			if (obj.get("name").equals("sEcho")) {
				sEcho = obj.get("value").toString();
			}
			if (obj.get("name").equals("iDisplayStart")) {
				iDisplayStart = obj.getIntValue("value");
			}
			if (obj.get("name").equals("iDisplayLength")) {
				iDisplayLength = obj.getIntValue("value");
			}
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("pageSize", iDisplayLength);
		jsonObject.put("sEcho", sEcho);
		jsonObject.put("success", false);

		ItemQuery query = new ItemQuery();
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);
		query.setCategoryId(categoryId);
		if (categoryId > 0) {
			query.setCategoryIds("%-" + categoryId + "-%");
		}
		if (StringUtils.isNotEmpty(search)) {
			query.setSearch("%" + search + "%");
		} else {
			query.setSearch(search);
		}

		query.setNameId(nameId);

		query.setPrice(price);
		query.setColourId(colourId);
		query.setRecommend(recommend);
		query.setSortField(sort);
		query.setOrder(order);
		if (sizeId > 0) {
			query.setSizeId("%\"sizeId\":" + sizeId + "%");
		} else {
			query.setSizeId("");
		}
		if (occasionId > 0) {
			query.setOccasionId("%-" + occasionId + "-%");
		} else {
			query.setOccasionId("");
		}
		if (ageId > 0) {
			query.setAgeId("%\"ageId\":" + ageId + "%");
		} else {
			query.setAgeId("");
		}
		if (colourId > 0 || sizeId > 0) {
			query.setCondition(1);
		} else {
			query.setCondition(0);
		}
		List<Integer> statuss = new ArrayList<Integer>();
		if (status == 10) {
			statuss.add(0);
			statuss.add(1);
			statuss.add(3);
			statuss.add(4);
		} else if (status == 5) {
			statuss.add(3);
			statuss.add(4);
		} else {
			statuss.add(status);
		}
		query.setStatus(statuss);

		Result<List<ItemDO>> result = null;
		try {
			result = itemManager.queryItemDOList(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnString(result, jsonObject, query);
	}
	
	/**
	 * 查询
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/detail.do")
	@ResponseBody
	public String queryItemDOById(@RequestParam(value = "itemId") long itemId) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		Result<ItemDO> result = null;
		try {
			result = itemManager.queryItemDOById(itemId);
			if (result == null || !result.isSuccess() || result.getResult() == null) {
				jsonObject.put("message", "查询失败");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject item = new JSONObject();
		ItemDO itemDO = result.getResult();
		item.put("itemId", itemDO.getItemId());
		item.put("nameId", itemDO.getNameId());
		item.put("name",itemDO.getNameId() > 0 ? propertyDAO.queryPropertyNameById(itemDO.getNameId()) : ""); // TODO:
		item.put("price", itemDO.getPrice());
		item.put("salesPrice", itemDO.getSalesPrice());
		item.put("categoryId", itemDO.getCategoryId());
		item.put("categoryName",StringUtils.isNotBlank(itemDO.getCategoryId()) ? attributeDAO
						.queryAttrNameById(Long.parseLong(itemDO
								.getCategoryId().split("-")[itemDO
								.getCategoryId().split("-").length - 1])) : "");
		//TODO
		item.put("stock", skuDAO.queryCountStock(itemDO.getItemId()));
		item.put("occasionId", itemDO.getOccasionId());
		item.put(
				"occasionName",
				StringUtils.isNotBlank(itemDO.getOccasionId()) ? attributeDAO
						.queryAttrNameById(Long.parseLong(itemDO
								.getOccasionId().split("-")[itemDO
								.getOccasionId().split("-").length - 1])) : "");
		item.put("image", itemDO.getImage());
		item.put("thumbnail", itemDO.getThumbnail());
		item.put("itemCode", itemDO.getItemCode());
		item.put("supplier", itemDO.getSupplier());
		item.put("supplierName", itemDO.getSupplier() > 0 ? sysUsersDAO
				.querySysUsersById(itemDO.getSupplier()).getName() : "");
		item.put("itemName", itemDO.getItemName());
		item.put("itemTag", itemDO.getItemTag());
		item.put("itemStatus", itemDO.getItemStatus());
		item.put("deleteIs", itemDO.getDeleteIs());
		item.put("itemsModel", itemDO.getItemsModel());
		item.put("stratification", itemDO.getStratification());
		item.put("suitImage", itemDO.getSuitImage());
		item.put("summary", itemDO.getSummary());
		item.put("recommend", itemDO.getRecommend());
		item.put("age", itemDO.getAge());
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");
		jsonObject.put("data", item);
		return jsonObject.toString();
	}

	/**
	 * 删除和恢复商品
	 * @param itemId
	 * @param itemStatus
	 * @return
	 */
	@RequestMapping(value = { "/delItemDO.do"}, method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String delItemDO(@RequestParam("itemId") long itemId,
			@RequestParam("deleteIs") int deleteIs) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		ItemDO itemDO = new ItemDO();
		itemDO.setItemId(itemId);
		
		if (deleteIs == 0) {
			itemDO.setDeleteIs(1);
		}else{
			itemDO.setDeleteIs(0);
		}
		Result<Integer> result = null;
		try {
			result = itemManager.delItemDO(itemDO);
			if (result == null || !result.isSuccess() || result.getResult() <= 0) {
				jsonObject.put("message", result.getErrorInfo());
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}
	
	/**
	 * 处理商品的上下架
	 * @param itemId
	 * @param itemStatus
	 * @return
	 */
	@RequestMapping(value = { "/itemStatus.do"}, method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String updateItemDOItemStatus(@RequestParam("itemId") long itemId,
			@RequestParam("itemStatus") int itemStatus) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		ItemDO itemDO = new ItemDO();
		itemDO.setItemId(itemId);
		
		if (itemStatus == 0) {
			itemDO.setItemStatus(1);
		}else{
			itemDO.setItemStatus(0);
		}

		Result<Integer> result = null;
		try {
			result = itemManager.updateItemDOItemStatus(itemDO);
			if (result == null || !result.isSuccess() || result.getResult() <= 0) {
				jsonObject.put("message", result.getErrorInfo());
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("success", true);
		jsonObject.put("message", "修改成功");
		return jsonObject.toString();
	}
	/**
	 * 修改商品的价格状态
	 * @param itemId
	 * @param itemStatus
	 * @return
	 */
	@RequestMapping(value = { "/itemsModel.do"}, method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String editItemDOItemsModel(@RequestParam("itemId") long itemId,
			@RequestParam("itemsModel") int itemsModel) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		ItemDO itemDO = new ItemDO();
		itemDO.setItemId(itemId);
		itemDO.setItemsModel(itemsModel);
		
		Result<Integer> result = null;
		try {
			result = itemManager.updateItemsModel(itemDO);
			if (result == null || !result.isSuccess() || result.getResult() <= 0) {
				jsonObject.put("message", result.getErrorInfo());
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}
	/**
	 * 审核
	 * @return
	 */
	@RequestMapping(value = { "/audit.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateShopDOAudit(@RequestParam("itemId") Long itemId,
			@RequestParam("audit") Integer audit) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		ItemDO itemDO = new ItemDO();
		itemDO.setItemId(itemId);		
		itemDO.setAudit(audit);

		Result<Integer> result = itemManager.updateItemAudit(itemDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	/**
	 * 添加或者修改商品信息
	 * @return
	 */
	
	@RequestMapping(value = { "/edit.do", "/save.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editItemDO(
			@RequestParam(value = "itemId", defaultValue = "0", required = false) long itemId,
			@RequestParam(value = "nameId", defaultValue = "0") long nameId,
			@RequestParam(value = "itemCode", defaultValue = "") String itemCode,
			@RequestParam(value = "price", defaultValue = "") String price,
			@RequestParam(value = "salesPrice", defaultValue = "") String salesPrice,
			@RequestParam(value = "categoryId", defaultValue = "") String categoryId,
			@RequestParam(value = "occasionId", defaultValue = "") String occasionId,
			@RequestParam(value = "itemName", defaultValue = "") String itemName,
			@RequestParam(value = "age", defaultValue = "") String age,
			@RequestParam(value = "image", defaultValue = "") String image,
			@RequestParam(value = "supplier", defaultValue = "") long supplier,
			@RequestParam(value = "stratification", defaultValue = "0") int stratification,
			@RequestParam(value = "suitImage", defaultValue = "") String suitImage,
			@RequestParam(value = "summary", defaultValue = "") String summary,
			@RequestParam(value = "recommend", required = false) Integer recommend) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		//这里只判断了商品的名称是否为空
		if (StringUtils.isEmpty(itemName)) {
			jsonObject.put("message", "操作失败,商品名称不能为空");
			return jsonObject.toString();
		}
		//处理上传图片的地址
		if (suitImage != null && !"".equals(suitImage)) {
			suitImage = PhotoUtil.addPhoto(suitImage);
		}
		//处理上传图片的地址
		if (image != null && !"".equals(image)) {
			image = PhotoUtil.addPhoto(image);
		}

		ItemDO itemDO = new ItemDO();
		itemDO.setItemId(itemId);
		itemDO.setAge(age);
		itemDO.setNameId(nameId);
		itemDO.setItemCode(itemCode);
		itemDO.setStratification(stratification);
		itemDO.setSuitImage(suitImage);
		itemDO.setPrice(price);
		itemDO.setSupplier(supplier);
		itemDO.setSalesPrice(salesPrice);
		itemDO.setCategoryId(categoryId);
		itemDO.setOccasionId(occasionId);
		itemDO.setItemName(itemName);
		itemDO.setImage(image);
		itemDO.setSummary(summary);
		if (recommend != null) {
			itemDO.setRecommend(recommend);
		} else {
			itemDO.setRecommend(new Integer(0));
		}
		Result<Long> result = null;
		try {
			result = itemManager.editItemDO(itemDO);
			if (result == null || !result.isSuccess() || result.getResult() == null) {
				jsonObject.put("message", "操作失败");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		jsonObject.put("success", true);
		jsonObject.put("itemId", result.getResult());
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	/**
	 * 查询返回的每条数据的状态
	 * @param result
	 * @param jsonObject
	 * @param query
	 * @return
	 */
	public String returnString(Result<List<ItemDO>> result,
			JSONObject jsonObject, ItemQuery query) {
		if (result != null && result.isSuccess()) {
			if (result.getResult() == null) {
				jsonObject.put("message", "没有符合条件的宝贝");
				return jsonObject.toString();
			}
			List<ItemDO> itemDOList = result.getResult();
			JSONArray itemList = new JSONArray();
			for (ItemDO itemDO : itemDOList) {
				JSONObject item = new JSONObject();

				item.put("itemId", itemDO.getItemId());
				item.put("nameId", itemDO.getNameId());
				item.put("name",itemDO.getNameId() > 0 ? propertyDAO.queryPropertyNameById(itemDO.getNameId()) : "");
				item.put("price", itemDO.getPrice());
				item.put("salesPrice", itemDO.getSalesPrice());
				String[] categoryIds = itemDO.getCategoryId().split("-");
				item.put("categoryId", StringUtils.isNotBlank(itemDO
						.getCategoryId()) ? categoryIds[categoryIds.length - 1]
						: "");
				item.put("categoryName",
						StringUtils.isNotBlank(itemDO.getCategoryId()) ? attributeDAO.queryAttrNameById(Long
								.parseLong(itemDO.getCategoryId().split("-")[itemDO
										.getCategoryId().split("-").length - 1]))
								: "");
				item.put("skuStock", itemDO.getSkuStock());
				item.put("stock", itemDO.getStock());
				item.put("audit", itemDO.getAudit());
				item.put("image", itemDO.getImage());
				item.put("itemCode", itemDO.getItemCode());
				item.put("itemName", itemDO.getItemName());
				item.put("salseVolume", itemDO.getSalseVolume());
				item.put("itemStatus", itemDO.getItemStatus());
				item.put("deleteIs", itemDO.getDeleteIs());
				item.put("itemsModel", itemDO.getItemsModel());
				
				if (itemDO.getItemStatus() == 0) {
					item.put("isUp", true);
				}else{
					item.put("isUp", false);
				}
				itemList.add(item);
			}
			jsonObject.put("iTotalRecords", query.getTotalItem()); // 实际的行数
			jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); // 显示的行数,这个要和上面
			jsonObject.put("aaData", itemList);
			jsonObject.put("success", true);
		} else {
			jsonObject.put("message", "找不到宝贝");
		}
		return jsonObject.toString();
	}

}
