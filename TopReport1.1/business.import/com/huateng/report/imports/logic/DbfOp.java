package com.huateng.report.imports.logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huateng.report.imports.model.Constant;
import com.linuxense.javadbf.DBFReader;

/**
 * @读取DBF文件到内存fileContentList中
 * @author Lrushing
 * @日期 2008-9-8 14：15
 * @最后修改：
 */
@SuppressWarnings("unchecked")
public class DbfOp {

	// 用于存储读取DBF的数据
	private List<String> fileContentList = new ArrayList<String>();

	/**
	 * @param constant 
	 * @function 读取DBF文件，将内同以标准字符串存在数组中
	 * @param 文件所在路径
	 *            fpath
	 * @throws IOException
	 */
	public boolean readFileContent(String fpath, Constant constant) throws IOException {
		

		fileContentList.clear();
		FileInputStream dbfFile = null;
		// 第三方类
		DBFReader dbfReader = null;

		try {
			// 初始化变量建立读如文件流
			dbfFile = new FileInputStream(fpath);
			dbfReader = new DBFReader(dbfFile);

			// 循环读取DBF文件中记录并包装成标准字符串存在内存中
			for (int i = 0; i < dbfReader.getRecordCount(); i++) {

				// 获取每条记录中的所有字段值
				Object[] fields = dbfReader.nextRecord();
				StringBuffer line = new StringBuffer("");
				// 遍历单条记录中各个字段
				for (Object field : fields) {
					if (field == null) {
						line.append(" |");
					}
					// 如果字段为日期类型则转化为yyyyMMdd格式
					if (field instanceof Date) {
						Date date = (Date) field;
						String d = (new SimpleDateFormat("yyyyMMdd"))
								.format(date);
						line.append(d);
						line.append("|");
						// 如果字段为数字类型，则分辨是整数还是小数分别储存
					} else if (field instanceof Number) {
						Double dou = (Double) field;
						Number number = null;
						if (dou == dou.intValue()) {
							number = dou.intValue();
						} else {
							number = dou;
						}
						DecimalFormat df = new DecimalFormat("#.######");
						line.append(df.format(number));
						line.append("|");
						// 其他类型都按字符串进行存储
					} else {
						line.append(field.toString().trim());
						line.append("|");
					}
				}
				// 将包装好的字符串添加到内存数组中
				if (line != null && !"".equals(line)) {
					fileContentList.add(line.toString().substring(0, line.toString().length()-1));	
				}

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			dbfFile.close();
		}
	}

	/**
	 * @function 取得导入文件内容列表
	 */
	public List getFileContentList() {
		return fileContentList;
	}

	/**
	 * @function 返回文件行数
	 */
	public int getFileRowCount() {
		return fileContentList.size();
	}

}
