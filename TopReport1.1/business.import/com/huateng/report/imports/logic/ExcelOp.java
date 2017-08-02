package com.huateng.report.imports.logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.huateng.report.imports.model.Constant;
import com.huateng.report.imports.model.TFileDataInfo;


/**
 * @author Administrator
 * 
 */
@SuppressWarnings("unchecked")
public class ExcelOp {


	private List fileContentList = new ArrayList();

	/**
	 * 读取Excel文件
	 * @param constant2 
	 * 
	 * @return 是否成功
	 */
	public boolean readFileContent(TFileDataInfo curImpFileInfo,
			String fPath, String fFName, Constant constant) throws IOException {

		int fStartColumn = curImpFileInfo.getStartColumn() - 1;
		int fEndColumn = curImpFileInfo.getEndColumn() - 1;
		int fStartRow = curImpFileInfo.getStartRow() - 1;
		int fSheetNum = curImpFileInfo.getSheetNum() - 1;
		
//		fileContentList.clear();
		String line = "";
		String tmplin = "";
		FileInputStream fis=new FileInputStream(fFName);
		try {
			HSSFWorkbook hsWorkBook = new HSSFWorkbook(new POIFSFileSystem(
					fis));// 指定xls文件;
			HSSFSheet hsSheet = hsWorkBook.getSheetAt(fSheetNum);
			 
			for (int i = 0; i < i + 1; i++) {
				line = "";
				tmplin = "";
				HSSFRow hsRow = hsSheet.getRow(fStartRow + i);
				if ((hsRow == null) || (hsRow.toString().trim().equals(""))) {
					break;
				}
				for (int j = fStartColumn; j <= fEndColumn; j++) {
					if (hsRow.getCell((short) j) != null) {
						switch (hsRow.getCell((short) j).getCellType()) {
						case 0: { // CELL_TYPE_NUMERIC
							if (hsRow.getCell((short) j).getNumericCellValue()
									- (int) hsRow.getCell((short) j)
											.getNumericCellValue() == 0) {
								line = line
										+ (int) hsRow.getCell((short) j)
												.getNumericCellValue() + "|";
								tmplin = tmplin
										+ (int) hsRow.getCell((short) j)
												.getNumericCellValue();
							} else {
								line = line
										+ hsRow.getCell((short) j)
												.getNumericCellValue() + "|";
								tmplin = tmplin
										+ hsRow.getCell((short) j)
												.getNumericCellValue();
							}
							break;
						}
						case 1: { // CELL_TYPE_STRING
							line = line
									+ hsRow.getCell((short) j)
											.getStringCellValue() + "|";
							tmplin = tmplin
									+ hsRow.getCell((short) j)
											.getStringCellValue();
							break;
						}
						case 2: { // CELL_TYPE_FORMULA
							line = line
									+ hsRow.getCell((short) j).getCellFormula()
									+ "|";
							tmplin = tmplin
									+ hsRow.getCell((short) j).getCellFormula();
							break;
						}
						case 3: { // CELL_TYPE_BLANK
							line = line + " |";
							tmplin = tmplin + "";
							break;
						}
						case 4: { // CELL_TYPE_BOOLEAN
							line = line
									+ hsRow.getCell((short) j)
											.getBooleanCellValue() + "|";
							tmplin = tmplin
									+ hsRow.getCell((short) j)
											.getBooleanCellValue();
							break;
						}
						case 5: { // CELL_TYPE_ERROR
							line = line
									+ hsRow.getCell((short) j)
											.getErrorCellValue() + "|";
							tmplin = tmplin
									+ hsRow.getCell((short) j)
											.getErrorCellValue();
							break;
						}
						default: {
							line = line
									+ hsRow.getCell((short) j)
											.getStringCellValue() + "|";
							tmplin = tmplin
									+ hsRow.getCell((short) j)
											.getStringCellValue();
							break;
						}
						}

					} else {
						line = line + "|";
						tmplin = tmplin + "";
					}

				}
				if (tmplin.trim().equals("")) {
					break;
				}
				if (line != null && !"".equals(line)) {
					fileContentList.add(line.substring(0, line.length()-1));
				}

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			fis.close();
		}

	}

	/**
	 * 取得导入文件内容列表
	 * 
	 * @param sFileFullName
	 *            文件路径名称
	 * @throws IOException
	 */
	public List getFileContentList() {
		return fileContentList;
	}

	/**
	 * 返回文件行数
	 * 
	 * @return 文件行数
	 * 
	 */
	public int getFileRowCount() {
		return fileContentList.size();
	}

}
