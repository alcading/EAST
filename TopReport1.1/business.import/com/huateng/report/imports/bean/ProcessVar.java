package com.huateng.report.imports.bean;

import com.huateng.report.imports.common.Constants;
import com.huateng.report.imports.common.Publish;

public class ProcessVar {

	public int fileNum = 0;
	public String currentFile = "";
	public int startRow = 0;
	public int sumRow = 0;
	public int rightRow = 0;
	public int errorNumber = 0;
	public int filterRow = 0;
	public int errorRow = 0;
	public int seqNo = 0;
	public int progress = 0;
	public int totalProgress = 0;
	public String infoMessage = "";
	public String errorMessage = "";

	// public void toZero() {
	// currentFile = "";
	// startRow = 0;
	// sumRow = 0;
	// rightRow = 0;
	// filterRow = 0;
	// errorRow = 0;
	// seqNo = 0;
	// infoMessage = "";
	// errorMessage = "";
	// progress = 0;
	// totalProgress = 0;
	// }
	public void push(String... subject) {
		if (subject.length == 0) {
			Publish.push(Constants.IMPORT_SUBJECT, this);
		}
		for(String sub : subject) {
			Publish.push(sub, this);
		}
	}

}
