package com.zhezhuo.biz.dao;

//import org.apache.commons.lang.ClassUtils;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.io.Serializable;
import java.util.HashMap;

/**
 * DAO基类
 * 
 * @author Shaka
 */
public class BaseDAO2 {

	private SqlMapClientTemplate sqlMapClientTemplate;

	protected SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	/**
	 * 生成sql id
	 * 
	 * // * @param operation
	 * 
	 * @return
	 */
	// protected String getSqlId(String operation) {
	// return ClassUtils.getShortClassName(getClass()) + "." + operation;
	// }

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
