package com.huateng.report.imports.bean;



public class ImportFileStatus implements java.io.Serializable{
	
	 private String id;
	 private String fileName;
	 private String isHave;
	 private String upStatus;
	 private String progress;
	 private String answer;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getIsHave() {
		return isHave;
	}
	public void setIsHave(String isHave) {
		this.isHave = isHave;
	}
	public String getUpStatus() {
		return upStatus;
	}
	public void setUpStatus(String upStatus) {
		this.upStatus = upStatus;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	 
	 
	
	
}