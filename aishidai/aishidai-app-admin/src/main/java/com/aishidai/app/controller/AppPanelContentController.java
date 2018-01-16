package com.aishidai.app.controller;

import com.aishidai.app.model.pojo.AppPanelContentDO;
import com.aishidai.app.service.AppPanelContentService;
import com.aishidai.common.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manage/appPanelContent")
public class AppPanelContentController {

    @Autowired
    AppPanelContentService appPanelContentService;


    @GetMapping(value = "getAll")
    public JsonResult getAll(){

        return  JsonResult.buildSuccess(appPanelContentService.getAll());
    }



    @GetMapping(value = "update")
    public JsonResult update(AppPanelContentDO  appPanelContentDO){
        try {
            return JsonResult.buildSuccess( appPanelContentService.update(appPanelContentDO));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }



    @GetMapping(value = "del")
    public JsonResult del(Long attributeId){
        try {
            return JsonResult.buildSuccess(null);
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }

    @GetMapping(value = "add")
    public JsonResult add(AppPanelContentDO appPanelContentDO){
        try {
            return JsonResult.buildSuccess(appPanelContentService.add(appPanelContentDO));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }

    @GetMapping(value = "getById")
    public JsonResult getById(Long appPanelContentId){
        try {
            return JsonResult.buildSuccess(appPanelContentService.getById(appPanelContentId));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }
}
