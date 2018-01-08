package com.zhezhuo.biz.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zhezhuo.model.GpsDO;
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

import static java.nio.file.Paths.get;

public class GaodeMapUtil {
    private static String key="cb649a25c1f81c1451adbeca73623251";


    public static GpsDO addressToGPS(String address){
        GpsDO gpsDO=new GpsDO();

        //String url= "http://restapi.amap.com/v3/geocode/geo?address=%E5%8C%97%E4%BA%AC%E5%B8%82&key=";
        Map<String,String> map=new HashMap();
        map.put("key",key);
        map.put("address",address);
        try {
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Authorization", "APPCODE b35496fe3afb4eda9c70255c498e8c68");
            HttpResponse response= HttpUtils.doGet("http://restapi.amap.com","/v3/geocode/geo","GET",headers,map);
            String jsonStr= HttpUtils.responseToString(response);
            JSONObject jsonObject=(JSONObject)JSONObject.parse(jsonStr);
            JSONArray jsonArray= (JSONArray)JSONArray.parse(jsonObject.get("geocodes").toString());
            JSONObject geocodes=(JSONObject)JSONObject.parse( jsonArray.get(0).toString());
            String strGps=geocodes.getString("location");
            gpsDO.setLng(strGps.split(",")[0]);
            gpsDO.setLat(strGps.split(",")[1]);
        }catch (Exception e){
            e.printStackTrace();
        }


        return gpsDO;
    }



    public static void main(String[] args) {
        addressToGPS("北京市");
    }


}
