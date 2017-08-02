package com.huateng.report.imports.model;

import java.util.Map;

public class SqlInfo {

	private int rowNumber;
	
	private String sql;
	
	private Map<String,Object> paramMap;
	
	private Map<String,Object> logDtlMap;
	
	private byte flag;  //1新增 2修改 3删除
	
	public SqlInfo(int rowNumber,String sql,Map<String,Object> paramMap,byte flag,Map<String,Object> logDtlMap){
		this.rowNumber=rowNumber;
		this.sql=sql;
		this.paramMap=paramMap;
		this.flag=flag;
		this.logDtlMap=logDtlMap;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Map<String, Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}

	public byte getFlag() {
		return flag;
	}

	public void setFlag(byte flag) {
		this.flag = flag;
	}

	public Map<String, Object> getLogDtlMap() {
		return logDtlMap;
	}

	public void setLogDtlMap(Map<String, Object> logDtlMap) {
		this.logDtlMap = logDtlMap;
	}
}
