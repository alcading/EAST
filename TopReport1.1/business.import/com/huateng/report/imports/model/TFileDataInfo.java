/**
 * 
 */
package com.huateng.report.imports.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.huateng.report.imports.logic.ImportFileVar;

/**
 * 文件配置信息
 * 
 * @author Administrator
 * 
 */
public class TFileDataInfo {

	private List fRowValue = new ArrayList(); // 记录分隔后的值列表
	private ImportFileVar importFileVar = new ImportFileVar();
	private Hashtable fFieldList = new Hashtable(); // 存放字段配置
	private Hashtable fKeyFieldList = new Hashtable(); // 存放主关键字段配置
	private Hashtable fFilterList = new Hashtable(); // 存放过滤字段配置
	private Hashtable fUpdateFieldsValue = new Hashtable(); // 存放要入库字段最终值列表
	private Hashtable fKeyFieldsValue = new Hashtable(); // 存放主关键字段最终值列表
	private Hashtable fFilterFieldsValue = new Hashtable(); // 存放过滤字段最终值列表
	public List<String> fileContentList = new ArrayList();

	private String guid;
	private String departId;
	private String fileName;
	private String fileFullName;
	private String tableName;
	private int batchNo;
	private String fileOwner;
	private String formatType;
	private String splitType;
	private String listSeparator;
	private int sequenceNo;
	private String importTime;
	private int keyFlag;
	private int startRow;
	private int startColumn;
	private String endRowFlag;
	private int endColumn;
	private int sheetNum;
	private String mainFlag;
	private String fuid;
	private String comments;
	private int errFlg = 0;
	private String tradeDate;
	private String formate_date;
	private String beginTime;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileFullName() {
		return fileFullName;
	}

	public void setFileFullName(String fileFullName) {
		this.fileFullName = fileFullName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}

	public String getFileOwner() {
		return fileOwner;
	}

	public void setFileOwner(String fileOwner) {
		this.fileOwner = fileOwner;
	}

	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	public String getSplitType() {
		return splitType;
	}

	public void setSplitType(String splitType) {
		this.splitType = splitType;
	}

	public String getListSeparator() {
		return listSeparator;
	}

	public void setListSeparator(String listSeparator) {
		this.listSeparator = listSeparator;
	}

	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getImportTime() {
		return importTime;
	}

	public void setImportTime(String importTime) {
		this.importTime = importTime;
	}

	public int getKeyFlag() {
		return keyFlag;
	}

	public void setKeyFlag(int keyFlag) {
		this.keyFlag = keyFlag;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getStartColumn() {
		return startColumn;
	}

	public void setStartColumn(int startColumn) {
		this.startColumn = startColumn;
	}

	public String getEndRowFlag() {
		return endRowFlag;
	}

	public void setEndRowFlag(String endRowFlag) {
		this.endRowFlag = endRowFlag;
	}

	public int getEndColumn() {
		return endColumn;
	}

	public void setEndColumn(int endColumn) {
		this.endColumn = endColumn;
	}

	public int getSheetNum() {
		return sheetNum;
	}

	public void setSheetNum(int sheetNum) {
		this.sheetNum = sheetNum;
	}

	public String getMainFlag() {
		return mainFlag;
	}

	public void setMainFlag(String mainFlag) {
		this.mainFlag = mainFlag;
	}

	public String getFuid() {
		return fuid;
	}

	public void setFuid(String fuid) {
		this.fuid = fuid;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List getFRowValue() {
		return fRowValue;
	}

	public void setFRowValue(List rowValue) {
		fRowValue = rowValue;
	}

	public ImportFileVar getImportFileVar() {
		return importFileVar;
	}

	public void setImportFileVar(ImportFileVar importFileVar) {
		this.importFileVar = importFileVar;
	}

	public Hashtable getFFieldList() {
		return fFieldList;
	}

	public Hashtable getFKeyFieldList() {
		return fKeyFieldList;
	}

	public void setFKeyFieldList(Hashtable keyFieldList) {
		fKeyFieldList = keyFieldList;
	}

	public Hashtable getFFilterList() {
		return fFilterList;
	}

	public void setFFilterList(Hashtable filterList) {
		fFilterList = filterList;
	}

	public Hashtable getFUpdateFieldsValue() {
		return fUpdateFieldsValue;
	}

	public void setFUpdateFieldsValue(Hashtable updateFieldsValue) {
		fUpdateFieldsValue = updateFieldsValue;
	}

	public Hashtable getFKeyFieldsValue() {
		return fKeyFieldsValue;
	}

	public void setFKeyFieldsValue(Hashtable keyFieldsValue) {
		fKeyFieldsValue = keyFieldsValue;
	}

	public Hashtable getFFilterFieldsValue() {
		return fFilterFieldsValue;
	}

	public void setFFilterFieldsValue(Hashtable filterFieldsValue) {
		fFilterFieldsValue = filterFieldsValue;
	}

	public void setFFieldList(Hashtable fieldList) {
		fFieldList = fieldList;
	}

	public int getErrFlg() {
		return errFlg;
	}

	public void setErrFlg(int errFlg) {
		this.errFlg = errFlg;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getFormate_date() {
		return formate_date;
	}

	public void setFormate_date(String formate_date) {
		this.formate_date = formate_date;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * 取得导入文件内容列表
	 * 
	 * @param sFileFullName文件路径名称
	 * @throws IOException
	 */
	public List getFileContentList() {
		return fileContentList;
	}

	/**
	 * 返回文件行数
	 * 
	 * @return 文件行数
	 */
	public int getFileRowCount() {
		return fileContentList.size();
	}

	public List<String> readFileContent(int StartRow, String sFileFullName,
			String ListSeparator) throws IOException {

		byte[] bs = new byte[3];
		InputStream is = new FileInputStream(sFileFullName);
		is.read(bs);
		is.close();
		String encode = "";

		// 或者文件类型
		int index = sFileFullName.lastIndexOf(".");// 得到'.'所在的位置
		String fileType = sFileFullName.substring(index + 1);

		String line;
		// fileContentList.clear();
		List<String> tFileContentList = new ArrayList();

		String s0 = Long.toHexString(bs[0]);
		String s1 = Long.toHexString(bs[1]);
		String s2 = Long.toHexString(bs[2]);
		// 文本文件编码格式为UTF-8
		if ("ffffffffffffffef".equals(s0) && "ffffffffffffffbb".equals(s1)
				&& "ffffffffffffffbf".equals(s2)) {
			encode = "UTF-8";
			// 文本文件编码格式为Unicode
		} else if ("ffffffffffffffc4".equals(s0)
				&& "ffffffffffffffe3".equals(s1)
				&& "ffffffffffffffca".equals(s2)) {
			encode = "GB2312";
		} else if ("ffffffffffffffff".equals(s0)
				&& "fffffffffffffffe".equals(s1)) {
			encode = "Unicode";
			// 文本文件编码格式为Unicode big endian
		} else if ("fffffffffffffffe".equals(s0)
				&& "ffffffffffffffff".equals(s1)) {
			encode = "Unicode";
		} else {
			if ("txt".equals(fileType)) {
				// txt文件编码格式为ANSI时
				encode = "other";
			} else if ("csv".equals(fileType)) {
				// csv文件默认为UTF-8 //csv 指定为UTF-8时为乱码，所以去掉指定的转码格式
				encode = "";
			}
		}

		InputStream is2 = new FileInputStream(sFileFullName);
		BufferedReader reader = null;
		if ("".equals(encode)) {
			reader = new BufferedReader(new InputStreamReader(is2));
		} else if ("UTF-8".equals(encode)) {
			reader = new BufferedReader(new InputStreamReader(is2, encode));
			reader.read(new char[1]);
		} else if ("other".equals(encode)) {
			reader = new BufferedReader(new InputStreamReader(is2, "UTF-8"));
		} else {
			reader = new BufferedReader(new InputStreamReader(is2, encode));
		}
		try {
			int bindex = 0;
			int eindex = 0;
			String tmpString;
			String tmp;

			line = reader.readLine();
			for (int i = 1; i < StartRow; i++) {
				line = reader.readLine();
			}
			while (line != null) {
				if (",".equals(ListSeparator)) {
					line = line.replaceAll(",", "\\|");
					while (line.indexOf("\"") != -1
							&& line.indexOf("\"|") > line.indexOf("\"")) {
						bindex = line.indexOf("\"");
						eindex = line.indexOf("\"|") + 1;
						tmpString = line.substring(bindex, eindex);
						tmp = tmpString.replaceAll("\\|", ",");
						tmp = tmp.substring(1, tmp.length() - 1);
						line = line.replace(tmpString, tmp);
					}
					line = line.replaceAll("\"", "");
				}

				tFileContentList.add(line);
				line = reader.readLine();
				// kycCommon.readLineCount ++;
			}
			return tFileContentList;
		} finally {
			is2.close();
			reader.close();
		}
	}

	//扩展 参数
	private String modType; //I - insert; U - update; D - delete

	public String getModType() {
		return modType;
	}

	public void setModType(String modType) {
		this.modType = modType;
	}
	
}