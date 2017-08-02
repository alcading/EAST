package com.huateng.report.imports.model;

/**
 * 文件导入日志־
 * 
 * @author Administrator
 * 
 */
public class TImportLog {

	private String workDate;
	private String departCode;
	private String fileName;
	private String tableName;
	private String fileOwner;
	private int batchNo;
	private int sericalNo;
	private String importStatus;
	private int errorNumber;
	private String errorMessage;
	private int totalRows;
	private int correctRows;
	private int filterRows;
	private String beginTime;
	private String endTime;
	//2009-01-09 001 lyg add start 导入数据库记日志时添加username到filler1
	private String filler1;
	
	public void setfiller1(String filler1) {
		this.filler1 = filler1;
	}
	public String getfiller1() {
		return filler1;
	}
	//2009-01-09 001 lyg add end
	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public String getDepartCode() {
		return departCode;
	}

	public void setDepartCode(String departCode) {
		this.departCode = departCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFileOwner() {
		return fileOwner;
	}

	public void setFileOwner(String fileOwner) {
		this.fileOwner = fileOwner;
	}

	public int getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}

	public int getSericalNo() {
		return sericalNo;
	}

	public void setSericalNo(int sericalNo) {
		this.sericalNo = sericalNo;
	}

	public String getImportStatus() {
		return importStatus;
	}

	public void setImportStatus(String importStatus) {
		this.importStatus = importStatus;
	}

	public int getErrorNumber() {
		return errorNumber;
	}

	public void setErrorNumber(int errorNumber) {
		this.errorNumber = errorNumber;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getCorrectRows() {
		return correctRows;
	}

	public void setCorrectRows(int correctRows) {
		this.correctRows = correctRows;
	}

	public int getFilterRows() {
		return filterRows;
	}

	public void setFilterRows(int filterRows) {
		this.filterRows = filterRows;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
