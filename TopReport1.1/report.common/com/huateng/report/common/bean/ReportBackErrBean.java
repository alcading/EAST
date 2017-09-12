package com.huateng.report.common.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 错误说明显示bean
 * 
 * @author shishu.zhang
 * 
 *         2012-8-28上午11:01:10
 */
public class ReportBackErrBean {
	private String errType;
	private List<String> errMsg = new ArrayList<String>();
	private Map<String, String> errFiledMap = new HashMap<String, String>();
	private Map<String, String> errFiledContentMap = new HashMap<String, String>();

	public String getErrType() {
		return errType;
	}

	public void setErrType(String errType) {
		this.errType = errType;
	}

	public Map<String, String> getErrFiledMap() {
		return errFiledMap;
	}

	public void setErrFiledMap(Map<String, String> errFiledMap) {
		this.errFiledMap = errFiledMap;
	}

	public Map<String, String> getErrFiledContentMap() {
		return errFiledContentMap;
	}

	public void setErrFiledContentMap(Map<String, String> errFiledContentMap) {
		this.errFiledContentMap = errFiledContentMap;
	}

	public List<String> getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(List<String> errMsg) {
		this.errMsg = errMsg;
	}

	public ReportBackErrBean(String errType, List<String> errMsg,
			Map<String, String> errFiledMap,
			Map<String, String> errFiledContentMap) {
		super();
		this.errType = errType;
		this.errMsg = errMsg;
		this.errFiledMap = errFiledMap;
		this.errFiledContentMap = errFiledContentMap;
	}

	public ReportBackErrBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}