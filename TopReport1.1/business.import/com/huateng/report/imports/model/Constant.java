package com.huateng.report.imports.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @function 静态导入文件列表
 * @author lrushing
 * @date 2008年11月4日
 */
@SuppressWarnings("unchecked")
public class Constant {
	
	public String id;
	public static Map<String, Constant> sessionMap = new HashMap<String, Constant>(10);
	public List<Map> constantFileList;
	public String branch;
	public String filePath;
	public String currentFile;
	public String logName;
	public int startRow = 0;
	public int sumRow = 0;
	public int rightRow = 0;
	public int filterRow = 0;
	public int errorNumber = 0;
	public int sericalNo=0;
	public String errorMessage = "";
	public String progress="0%";
	public boolean stopFlag=false;
	
	public void toZero() {
		startRow = 0;
		sumRow = 0;
		rightRow = 0;
		filterRow = 0;
		errorNumber = 0;
		sericalNo=0;
		errorMessage = "";
		progress="0%";
	}
	
//	public void push(String... subject) {
//		if (subject.length == 0) {
//			Publish.push(Constants.IMPORT_SUBJECT, this);
//		}
//		for(String sub : subject) {
//			Publish.push(sub, this);
//		}
//	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public boolean isStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(boolean stopFlag) {
		this.stopFlag = stopFlag;
	}
	
}
