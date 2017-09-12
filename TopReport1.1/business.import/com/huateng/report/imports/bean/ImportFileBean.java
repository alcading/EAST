package com.huateng.report.imports.bean;

import resource.bean.report.BiImportFileConfig;

public class ImportFileBean extends BiImportFileConfig {
	private boolean reImport;

	private boolean select;

	private boolean exist;

	private String impStatus;

	private String fileNameFull;

	private String workDate;

	private boolean importing;

	public boolean isReImport() {
		return reImport;
	}

	public void setReImport(boolean reImport) {
		this.reImport = reImport;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public String getImpStatus() {
		return impStatus;
	}

	public void setImpStatus(String impStatus) {
		this.impStatus = impStatus;
	}

	public String getFileNameFull() {
		return fileNameFull;
	}

	public void setFileNameFull(String fileNameFull) {
		this.fileNameFull = fileNameFull;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public boolean isImporting() {
		return importing;
	}

	public void setImporting(boolean importing) {
		this.importing = importing;
	}

}
