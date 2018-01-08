package com.zhezhuo.biz.dao;

//import org.apache.commons.lang.ClassUtils;


import com.zhezhuo.biz.dao.impl.SqlMapClientTemplate;

import java.io.Serializable;
import java.util.HashMap;

/**
 * DAO的基类
 * @author 51147
 *
 */
public class BaseDAO {

	private SqlMapClientTemplate sqlMapClientTemplate;

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}


	protected Parameter createParameter(String key, Object value) {
		return new Parameter().addParam(key, value);
	}

	/**
	 * 用来辅助sql参数连写
	 */
	public static class Parameter extends HashMap<String, Object> implements Serializable {

		public Parameter addParam(String key, Object value) {
			this.put(key, value);
			return this;
		}
	}
	
}
