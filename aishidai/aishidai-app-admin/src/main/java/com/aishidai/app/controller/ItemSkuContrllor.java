package com.aishidai.app.controller;
import com.aishidai.app.dao.ItemSkuDOMapper;
import com.aishidai.app.model.dto.Size;
import com.aishidai.app.model.dto.SkuDetailDTO;
import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.pojo.ItemDO;
import com.aishidai.app.model.pojo.ItemSkuDO;
import com.aishidai.app.model.vo.ItemSkuVO;
import com.aishidai.app.model.vo.SkuData;
import com.aishidai.app.model.vo.SkuSize;
import com.aishidai.app.service.AttributeService;
import com.aishidai.app.service.ItemSkuService;
import com.aishidai.app.service.ItemSuitService;
import com.aishidai.common.json.JsonResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("manage/itemSku")
public class ItemSkuContrllor {

    @Autowired
    ItemSkuService itemSkuService;
    @Autowired
    ItemSuitService itemSuitService;

    @GetMapping(value = "update")
    public JsonResult update(ItemSkuDO itemSkuDO){

        return JsonResult.buildSuccess( itemSkuService.update(itemSkuDO));
    }

    @Transactional
    @PostMapping(value = "add")
    public JsonResult add(String data){
        try {
            data=new String(Base64.decodeBase64(data.getBytes()));
            SkuData skuData1 =new SkuData();
            boolean isDel=false;
            boolean suitIsDel=false;
            List<JSONObject>  list= (List<JSONObject>) JSONArray.parse(data);
            //  List<SkuDetailDTO> list=skuData.getSkuDetailList();
            for (int i=0; i<list.size();i++){
                JSONObject jsonObject=(JSONObject)JSONObject.parse(list.get(i).toJSONString());
                List<JSONObject> list1=(List<JSONObject>) JSONArray.parse(jsonObject.get("sizeList").toString());
                Long itemId=  Long.valueOf(jsonObject.get("itemId")+"");
                // 删除改颜色 对应的试穿图
                if(!suitIsDel){
                    suitIsDel=true;
                    itemSuitService.delByItemId(itemId);
                }
                // 先进行删除
                if(!isDel){
                    itemSkuService.delByItemId(itemId);
                    isDel=true;
                }
                for (int j=0; j<list1.size();j++){
                    JSONObject jsonObject1=(JSONObject)JSONObject.parse(list1.get(i).toJSONString());
                    ItemSkuDO itemSkuDO=new ItemSkuVO();
                    itemSkuDO.setSizeId(Long.valueOf(jsonObject1.get("sizeId")+""));
                    itemSkuDO.setColorId(Long.valueOf(jsonObject.get("colorId").toString()));
                    itemSkuDO.setPrice(jsonObject.get("price")+"");
                    itemSkuDO.setSalesPrice(jsonObject1.get("salesPrice")+"");
                    itemSkuDO.setItemId(itemId);
                    itemSkuDO.setImage(jsonObject.get("image")+"");
                    itemSkuDO.setDescription(jsonObject.get("description")+"");
                    itemSkuDO.setStock(Integer.valueOf(jsonObject1.get("stock")+""));
                    //itemSkuDO.setSalseVolume(Integer.valueOf(jsonObject1.get("salseVolume")+""));
                    itemSkuDO.setCreated(new Date());
                    itemSkuDO.setUpdated(new Date());
                    itemSkuDO.setSuitImage(jsonObject.get("suitImage")+"");
                    itemSkuService.add(itemSkuDO);

                }


            }

            return JsonResult.buildSuccess( true);
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }

    @Autowired
    AttributeService attributeService;
    @GetMapping(value = "getByItemId")
    public SkuData getByItemId(Long itemId){
      List<ItemSkuDO> list= itemSkuService.getByItem(itemId);
        SkuData skuData=new SkuData();
        List<SkuDetailDTO> skuDetailDTOList=new ArrayList<SkuDetailDTO>();
        Map<Long,SkuDetailDTO> colors=new HashMap<Long, SkuDetailDTO>();
        for (ItemSkuDO itemSkuDO:list){
            SkuDetailDTO skuDetailDTO1=new SkuDetailDTO();
            skuDetailDTO1.setPrice(itemSkuDO.getPrice());
            skuDetailDTO1.setSalesPrice(itemSkuDO.getSalesPrice());
            skuDetailDTO1.setImage(itemSkuDO.getImage());
            skuDetailDTO1.setDescription(itemSkuDO.getDescription());
            skuDetailDTO1.setColorId(skuDetailDTO1.getColorId());
            skuDetailDTO1.setSalseVolume(itemSkuDO.getSalseVolume());
            skuDetailDTO1.setCreated(new Date());
            skuDetailDTO1.setUpdated(new Date());
            AttributeDO attributeDO=  attributeService.getById(itemSkuDO.getColorId());
            skuDetailDTO1.setColourName(attributeDO.getAttrName());
            skuDetailDTO1.setSizeList(new ArrayList<Size>());
            colors.put(itemSkuDO.getColorId(),skuDetailDTO1);
        }

        for (ItemSkuDO itemSkuDO:list){
            SkuDetailDTO skuDetailDTO1=   colors.get(itemSkuDO.getColorId());
            Size size=new Size();
            size.setSizeId(itemSkuDO.getSizeId());
            size.setStock(itemSkuDO.getStock());
            skuDetailDTO1.getSizeList().add(size);
            AttributeDO attributeDO=  attributeService.getById(itemSkuDO.getSizeId());
            if(attributeDO!=null) {
                size.setSizeName(attributeDO.getAttrName());
            }

            colors.put(itemSkuDO.getColorId(),skuDetailDTO1);
        }
        for (Map.Entry<Long, SkuDetailDTO> entry : colors.entrySet()) {
                  //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
                   //entry.getKey() ;entry.getValue(); entry.setValue();
                      //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
                       System.out.println("key= " + entry.getKey() + " and value= "
                                        + entry.getValue());
            skuDetailDTOList.add( entry.getValue());
      }



        skuData.setSkuDetailList(skuDetailDTOList);
        return skuData;
    }
}
