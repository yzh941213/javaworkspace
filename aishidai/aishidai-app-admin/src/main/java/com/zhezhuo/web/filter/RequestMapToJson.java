package com.zhezhuo.web.filter;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public class RequestMapToJson {

	public static String readJSONString(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
			if (json.length() < 1) {
				Map<String, String[]> hm = request.getParameterMap();
				if (hm != null && hm.size() > 0) {
					json.append(readjson(hm).toString());
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return json.toString();
	}

	public static JSONObject readjson(Map<String, String[]> hm) {
		JSONObject jobj = new JSONObject();
		// 通过循环遍历的方式获得key和value并set到JSONObject中
		Iterator it = hm.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			String[] values = (String[]) hm.get(key);
			jobj.put(key, values[0]);
		}
		return jobj;
	}

	public static JSONObject readjson(HttpServletRequest request) {
		JSONObject JSONObject = new JSONObject();
		Map pmap = request.getParameterMap();
		// 通过循环遍历的方式获得key和value并set到jsonobject中
		Iterator it = pmap.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			String[] values = (String[]) pmap.get(key);
			JSONObject.put(key, values[0]);
		}
		return JSONObject;
	}
}
