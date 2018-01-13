package com.aishidai.app.controller;

import com.aishidai.app.model.dto.UsersListDTO;
import com.aishidai.app.model.pojo.UsersDO;
import com.aishidai.app.service.UsersService;
import com.aishidai.app.utils.PasswordHash;
import com.alibaba.fastjson.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manager/users")
public class UsersManageController {

    @Autowired
    private UsersService usersService;

    private static final Logger logger = LoggerFactory.getLogger(UsersManageController.class);

   /* @RequestMapping("/queryList")
    @ResponseBody
    public String queryUsersDOList( @RequestParam(value = "aoData") String aoData,
                                    @RequestParam(value = "keywords", defaultValue = "") String keywords,
                                    @RequestParam(value = "sort", defaultValue = "userId", required = false) String sort,
                                    @RequestParam(value = "order", defaultValue = "desc", required = false) String order) {
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

        UsersQuery query = new UsersQuery();
        if (StringUtils.isNotBlank(keywords)) {
            query.setKeywords("%"+keywords+"%");
        }
        query.setStartRow(iDisplayStart);
        query.setPageSize(iDisplayLength);
        query.setOrder(order);
        query.setSortField(sort);

        Result<List<UsersListDTO>> result = usersService.queryUsersDOList(query);

        if (result != null && result.isSuccess()) {
            jsonObject.put("iTotalRecords", query.getTotalItem()); //实际的行数
            jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); //显示的行数,这个要和上面
            jsonObject.put("aaData", result.getResult());
            jsonObject.put("success", true);
            jsonObject.put("message", "查询成功");
            return jsonObject.toString();
        }
        
        jsonObject.put("message", "查询失败");
        return jsonObject.toString();
    }*/


    
    @RequestMapping("/queryDetail")
    @ResponseBody
    public String queryUsersDO(@RequestParam(value = "userId") long userId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        UsersListDTO dto = usersService.queryUsersDOById(userId);
        if (dto != null ) {
            jsonObject.put("success", true);
            jsonObject.put("data", dto);
            jsonObject.put("message", "查询成功");
            return jsonObject.toString();
        }
        jsonObject.put("message", "查询失败");
        return jsonObject.toString();
    }


	@RequestMapping("/edit")
	@ResponseBody
	public String updateUsersDO(UsersDO usersDO) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		boolean result = usersService.operatUsersDO(usersDO);
		if (result == true) {
			jsonObject.put("success", true);
			jsonObject.put("message", "更新成功");
			return jsonObject.toString();
		}
		jsonObject.put("message", "更新失败");
		return jsonObject.toString();
	}

    /*@RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUsersDOS(@RequestParam("file") MultipartFile file,
                              HttpServletRequest request ) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        if (file.isEmpty()) {
            jsonObject.put("message", "提交的数据中不包含文件");
            return jsonObject.toString();
        }

        String fileName = file.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        List<UsersDO> usersDOs;
        if ("xls".equals(fileSuffix)){ //2003
            usersDOs =  readXls(file);
        }else if ("xlsx".equals(fileSuffix)){ //2010
            usersDOs =  readXlsx(file);
        }else {
            jsonObject.put("message", "文件格式错误");
            return jsonObject.toString();
        }

        if(usersDOs.isEmpty() || usersDOs.size() < 0) {
           jsonObject.put("message", "文件中未解析出要注册的用户");
           return jsonObject.toString();
        }
        
        try {
            Result<Long> result = usersService.addUsersDOS(usersDOs);
            if (result != null && result.isSuccess()) {
                jsonObject.put("success", true);
                jsonObject.put("message", "添加成功");
                return jsonObject.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("message", "添加失败");
            return jsonObject.toString();
        }

        jsonObject.put("message", "添加失败");
        return jsonObject.toString();
    }*/

    private List<UsersDO> readXlsx(MultipartFile fileRead) {
        List<UsersDO> list = new ArrayList<UsersDO>();
        logger.info("fileName " ,fileRead.getName());
        try {
            InputStream in = fileRead.getInputStream();
            XSSFWorkbook xssfWorkBook = new XSSFWorkbook(in);
            logger.info("hang " ,xssfWorkBook.getNumberOfSheets());
            for (int numSheet = 0; numSheet < xssfWorkBook.getNumberOfSheets(); numSheet++){
                XSSFSheet xssfSheet = xssfWorkBook.getSheetAt(numSheet);
                if (xssfSheet == null) continue;
                logger.info("lie " ,xssfSheet.getLastRowNum());
                for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++){
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow != null){
                        UsersDO usersDO = new UsersDO();
                        usersDO.setUname(getValue(xssfRow.getCell(0)));
                        usersDO.setTrueName(getValue(xssfRow.getCell(1)));
                        usersDO.setPassword(PasswordHash.createHash("888888"));
                        list.add(usersDO);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    private List<UsersDO> readXls(MultipartFile fileRead) {
        List<UsersDO> list = new ArrayList<UsersDO>();
        try {
            InputStream in = fileRead.getInputStream();
            HSSFWorkbook hssfWorkBook = new HSSFWorkbook(in);
            for (int numSheet = 0; numSheet < hssfWorkBook.getNumberOfSheets(); numSheet++){
                HSSFSheet hssfSheet = hssfWorkBook.getSheetAt(numSheet);
                if (hssfSheet == null) continue;
                for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null){
                        UsersDO usersDO = new UsersDO();
                        usersDO.setUname(getValue(hssfRow.getCell(0)));
                        usersDO.setTrueName(getValue(hssfRow.getCell(1)));
                        usersDO.setPassword(PasswordHash.createHash("888888"));
                        list.add(usersDO);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            BigDecimal bigDecimal = new BigDecimal(xssfRow.getNumericCellValue());
            return String.valueOf(bigDecimal.toPlainString());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }


    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            BigDecimal bigDecimal = new BigDecimal(hssfCell.getNumericCellValue());
            return String.valueOf(bigDecimal.toPlainString());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }



}
