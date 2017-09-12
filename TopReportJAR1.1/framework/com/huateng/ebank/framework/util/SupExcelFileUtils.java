package com.huateng.ebank.framework.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;






/**
 * 使用poi技术创建xls文件下载 动态导出Excel文件
 *
 * @author wuzhiwei date 2008-10-1
 */
public class SupExcelFileUtils {

	// 设置cell编码解决中文高位字节截断
	private static short XLS_ENCODING = HSSFWorkbook.ENCODING_UTF_16;

	// 定制日期格式
	private static String DATE_FORMAT = " m/d/yy "; // "m/d/yy h:mm"

	// 定制浮点数格式
	private static String NUMBER_FORMAT = " #,##0.00 ";

	private String xlsFileName;

	private HSSFWorkbook workbook;

	private HSSFSheet sheet;

	private HSSFRow row;

	public SupExcelFileUtils() {
	}

	/** */
	/**
	 * 初始化Excel
	 *
	 * @param fileName
	 *            导出文件名
	 */
	public SupExcelFileUtils(String fileName) {
		this.xlsFileName = fileName;
		this.workbook = new HSSFWorkbook();
		this.sheet = workbook.createSheet();
	}

	/**
	 * 导出Excel文件
	 *
	 * @throws XLSException
	 */
	public void exportXLS(FileOutputStream fOut) throws Exception {
		try {
			// FileOutputStream fOut = new FileOutputStream(xlsFileName);
			/*
			 * sheet.autoSizeColumn(( short ) 0 ); // 调整第一列宽度
			 * sheet.autoSizeColumn(( short ) 1 ); // 调整第二列宽度
			 * sheet.autoSizeColumn(( short ) 2 ); // 调整第三列宽度
			 * sheet.autoSizeColumn(( short ) 3 ); // 调整第四列宽度
			 */workbook.write(fOut);
			// fOut.flush();
			// fOut.close();
		} catch (FileNotFoundException e) {
			throw new Exception(" 生成导出Excel文件出错! ", e);
		} catch (IOException e) {
			throw new Exception(" 写入Excel文件出错! ", e);
		} finally {

			if (fOut != null) {
				try {
					fOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	/** */
	/**
	 * 增加一行
	 *
	 * @param index
	 *            行号
	 * @return
	 */
	public HSSFRow createRow(int index) {
		this.row = this.sheet.createRow(index);
		return row;
	}

	/**
	 * 设置单元格
	 *
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, String value) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
		cellStyle.setWrapText(true);

		HSSFCell cell = this.row.createCell((short) index); // 创建新单元格
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);// 指定单元格格式：数值、公式或字符串
		cell.setEncoding(XLS_ENCODING);// 列的编码
		cell.setCellValue(value);// 设置单元格内容
		cell.setCellStyle(cellStyle); // 设置单元格样式
		int xx = cell.getStringCellValue().length(); // 当前列的宽度
		this.sheet.setColumnWidth((short) index, (short) (500 * xx)); // 重新设置列的宽度

	}

	/**
	 * 设置sheel列单元格
	 *
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setColumnCell(int index, String value) {
		// 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 11); // 字体高度
		// font.setColor(HSSFFont.COLOR_RED); // 字体颜色
		font.setFontName(" 黑体 "); // 字体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
		font.setItalic(false); // 是否使用斜体
		// font.setStrikeout(true); // 是否使用划线

		// 设置单元格类型
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION); // 水平布局：居中
		cellStyle.setWrapText(true);

		// 添加单元格注释 wuzhiwei 暂时不用注释 。。。。。.
		// 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器.
		// HSSFPatriarch patr = sheet.createDrawingPatriarch(); --需要注释打开
		// 定义注释的大小和位置,详见文档
		// HSSFComment comment = patr.createComment( new HSSFClientAnchor( 0 , 0
		// , 0 , 0 , ( short ) 4 , 2 , ( short ) 6 , 5 ));--需要注释打开
		// 设置注释内容
		// comment.setString( new HSSFRichTextString( " 可以在POI中添加注释！ " ));
		// --需要注释打开
		// 设置注释作者. 当鼠标移动到单元格上是可以在状态栏中看到该内容.
		// comment.setAuthor( " wuzhiwei. " ); --需要注释打开

		// //
		HSSFCell cell = this.row.createCell((short) index); // 创建新单元格
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);// 指定单元格格式：数值、公式或字符串
		cell.setEncoding(XLS_ENCODING);// 列的编码
		cell.setCellValue(value);// 设置单元格内容
		cell.setCellStyle(cellStyle); // 设置单元格样式
		// cell.setCellComment(comment); // 添加注释 --需要注释打开
		int xx = cell.getStringCellValue().length(); // 当前列的宽度
		this.sheet.setColumnWidth((short) index, (short) (500 * (xx + 2))); // 重新设置列的宽度
	}

	/** */
	/**
	 * 设置单元格
	 *
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, Calendar value) {
		HSSFCell cell = this.row.createCell((short) index);
		cell.setEncoding(XLS_ENCODING);
		cell.setCellValue(value.getTime());
		HSSFCellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT)); // 设置cell样式为定制的日期格式
		cell.setCellStyle(cellStyle); // 设置该cell日期的显示格式
	}

	/** */
	/**
	 * 设置单元格
	 *
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, int value) {
		HSSFCell cell = this.row.createCell((short) index);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		cell.setCellValue(value);
	}

	/** */
	/**
	 * 设置单元格
	 *
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, double value) {
		HSSFCell cell = this.row.createCell((short) index);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		cell.setCellValue(value);
		HSSFCellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
		HSSFDataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat(NUMBER_FORMAT)); // 设置cell样式为定制的浮点数格式
		cell.setCellStyle(cellStyle); // 设置该cell浮点数的显示格式
	}

	public void createTitle(HSSFRow rowtitle, String title, int columnNum) {
		// 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 10); // 字体高度
		font.setColor(HSSFFont.COLOR_NORMAL); // 字体颜色 HSSFFont.COLOR_RED
		font.setFontName(" 黑体 "); // 字体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
		font.setItalic(false); // 是否使用斜体
		// font.setStrikeout(true); // 是否使用划线

		// 设置单元格类型
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
		cellStyle.setWrapText(true);
		cellStyle.setFillBackgroundColor(HSSFFont.COLOR_RED);// 背景色
		cellStyle.setFillForegroundColor(HSSFFont.COLOR_RED);// 前景色

		// ---
		HSSFCell celltitle = rowtitle.createCell((short) 0);
		this.sheet.addMergedRegion(new Region(0, (short) 0, 0,
				(short) columnNum));// 合并第一行
		rowtitle = this.sheet.getRow(0);// 获得第一行的引用
		HSSFCell celltitle1 = rowtitle.getCell((short) 0);// 获得第一行第一个单元格的引用
		// ---
		// HSSFCell celltitle = rowtitle.createCell((short) 0);
		// celltitle1.setEncoding(HSSFCell.ENCODING_UTF_16);// 设置字体编码
		// celltitle1.setCellValue(title);// 设置表头内容
		// celltitle1.setCellStyle(cellStyle);
		celltitle.setCellType(HSSFCell.CELL_TYPE_STRING);// 指定单元格格式：数值、公式或字符串
		celltitle.setEncoding(XLS_ENCODING);// 列的编码
		celltitle.setCellValue(title);// 设置单元格内容
		celltitle.setCellStyle(cellStyle); // 设置单元格样式
		/*
		 * // 设置字体 HSSFFont font = workbook.createFont();
		 * font.setFontHeightInPoints((short) 18); // 字体高度
		 * //font.setColor(HSSFFont.COLOR_RED); // 字体颜色 font.setFontName(" 黑体
		 * "); // 字体 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
		 * font.setItalic(false); // 是否使用斜体 // font.setStrikeout(true); //
		 * 是否使用划线 // 设置单元格类型 HSSFCellStyle cellStyle =
		 * workbook.createCellStyle(); cellStyle.setFont(font);
		 * cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION); //
		 * 水平布局：居中 cellStyle.setWrapText(true);
		 *
		 *
		 * HSSFCell celltitle = rowtitle.createCell((short) 0);
		 * celltitle.setEncoding(HSSFCell.ENCODING_UTF_16);// 设置字体编码
		 * celltitle.setCellValue(title);// 设置表头内容
		 * celltitle.setCellStyle(cellStyle); this.sheet.addMergedRegion(new
		 * Region(0,(short)0,0,(short)columnNum));//合并第一行
		 */}

	public void createColumnTitle(HSSFRow rowtitle, String title) {
		// 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 12); // 字体高度
		// font.setColor(HSSFFont.COLOR_RED); // 字体颜色
		font.setFontName(" 黑体 "); // 字体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
		font.setItalic(false); // 是否使用斜体
		// font.setStrikeout(true); // 是否使用划线

		// 设置单元格类型
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
		cellStyle.setWrapText(true);

		HSSFCell celltitle = rowtitle.createCell((short) 0);
		celltitle.setEncoding(HSSFCell.ENCODING_UTF_16);// 设置字体编码
		celltitle.setCellValue(title);// 设置表头内容
		celltitle.setCellStyle(cellStyle);
	}

	/**
	 * 生成excle文件
	 * @param title
	 * @param path
	 * @param fos
	 * @param detailList
	 * @param sessionid
	 * @return
	 */
	public boolean makeXls(String title, String path, FileOutputStream fos,
			List detailList, String sessionid) {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * 生成贷款合同信息 xls
	 *
	 * @throws Exception
	 *//*
	public boolean exportLoaninfo(String title, String filename,
			FileOutputStream os, List list) throws Exception {
		// List list = examformDao.getAllFormsByExamid(examid);

		if (list == null || list.size() < 1) {
			return false; // 下载后 不再次执行以下工作 ( 数据量没达到几万条 )
		}
		SupExcelFileUtils excel = new SupExcelFileUtils(filename);


		 * HSSFWorkbook workbook = new HSSFWorkbook();
		 *
		 * HSSFSheet sheet = workbook.createSheet("sheet1"); //sheet
		 // 表头
		HSSFRow rowtitle = excel.createRow((short) 0);// 添加表头
		excel.createTitle(rowtitle, title, 8);// 行对象,表头名称,列头数量(统计列 ->合并列)

		HSSFRow columnTitle = excel.createRow((short) 1);// 新增一行用于存放列头内容
		excel.createColumnTitle(columnTitle, title);

		excel.setColumnCell(0, "贷款支行");
		excel.setColumnCell(1, "合同号");
		excel.setColumnCell(2, "客户号");
		excel.setColumnCell(3, "姓  名");
		excel.setColumnCell(4, "贷款种类");
		excel.setColumnCell(5, "贷款余额");
		excel.setColumnCell(6, "申请日期");
		excel.setColumnCell(7, "贷款审批状态");
		excel.setColumnCell(8, "五级分类");
		excel.setColumnCell(9, "是否过逾期");
		excel.setColumnCell(10, "有效状态");

		for (int i = 1; i < list.size() + 1; i++) {
			LoanSimpleInfoListView obj = (LoanSimpleInfoListView) list
					.get(i - 1);
			excel.createRow((short) i + 1);
			excel.setCell(0, obj.getBrname());// 贷款支行
			excel.setCell(1, obj.getContractno());
			excel.setCell(2, obj.getCustno());
			excel.setCell(3, obj.getName() + "   ");
			excel.setCell(4, obj.getLnidName());
			excel.setCell(5, obj.getLnbalStr());
			excel.setCell(6, obj.getApplyDate() + "");
			excel.setCell(7, obj.getAppstatName());
			excel.setCell(8, obj.getTrmClassName() + "   ");// 五级分类
			excel.setCell(9, obj.getTotOvdTimes()+"       ");
			excel.setCell(10, obj.getStatus() + "    ");
		}
		// brname,contractno,custno,name,lnidname,lnbalstr,applydate,appstatname,clrclassname
		excel.exportXLS(os);
		return true; // 正常下载
	}


	*//**
	 * 生成借据信息 xls
	 *
	 * @throws Exception
	 *//*
	public boolean exportLoancino(String title, String filename,
			FileOutputStream os, List list) throws Exception {
		// List list = examformDao.getAllFormsByExamid(examid);

		if (list == null || list.size() < 1) {
			return false; // 下载后 不再次执行以下工作 ( 数据量没达到几万条 )
		}
		SupExcelFileUtils excel = new SupExcelFileUtils(filename);


		 * HSSFWorkbook workbook = new HSSFWorkbook();
		 *
		 * HSSFSheet sheet = workbook.createSheet("sheet1"); //sheet
		 // 表头
		HSSFRow rowtitle = excel.createRow((short) 0);// 添加表头
		excel.createTitle(rowtitle, title, 11);// 行对象,表头名称,列头数量(统计列 ->合并列)

		HSSFRow columnTitle = excel.createRow((short) 1);// 新增一行用于存放列头内容
		excel.createColumnTitle(columnTitle, title);

		excel.setColumnCell(0, "贷款支行");
		excel.setColumnCell(1, "合同号");
		excel.setColumnCell(2, "借据号");
		excel.setColumnCell(3, "客户号");
		excel.setColumnCell(4, "姓名");
		excel.setColumnCell(5, "贷款种类");
		excel.setColumnCell(6, "贷款金额");
		excel.setColumnCell(7, "贷款余额");
		excel.setColumnCell(8, "发放状态");
		excel.setColumnCell(9, "发放日期");
		excel.setColumnCell(10, "五级分类");
		excel.setColumnCell(11, "是否过逾期");

		for (int i = 1; i < list.size() + 1; i++) {
			LoanSimpleInfoListView obj = (LoanSimpleInfoListView) list
					.get(i - 1);
			excel.createRow((short) i + 1);
			excel.setCell(0, obj.getBrname());// 贷款支行
			excel.setCell(1, obj.getContractno());
			excel.setCell(2, obj.getCino());
			excel.setCell(3, obj.getCustno());
			excel.setCell(4, obj.getName()+ "   ");
			excel.setCell(5, obj.getLnidName());
			excel.setCell(6, obj.getTotamtStr());
			excel.setCell(7, obj.getLnbalStr());
			excel.setCell(8, obj.getAppstatName());
			excel.setCell(9, obj.getApplyDate()+ "");
			excel.setCell(10, obj.getClrClassName());
			if(Integer.parseInt(obj.getTotOvdTimes()) > 0){
				excel.setCell(11, "有"+ "   ");
        	}else{
        		 excel.setCell(11, "无"+ "   ");
        	}
		}
		// brname,contractno,custno,name,lnidname,lnbalstr,applydate,appstatname,clrclassname
		excel.exportXLS(os);
		return true; // 正常下载
	}

	*//**
	 * 生成贷款合同信息 xls
	 *
	 * @throws Exception
	 *//*

	*//**
	 * 生成贷款还款计划信息 xls
	 *
	 * @throws Exception
	 *//*
	*//**
	 * 生成贷款合同信息 xls
	 *
	 * @throws Exception
	 *//*


	*//**
	 * 生成贷款逾期信息 xls
	 *
	 * @throws Exception
	 *//*
	public boolean exportMatureLoanQuery(String title, String filename,
			FileOutputStream os, List list) throws Exception {
		//LoanLogInfoQueryCondition loanLogInfoQueryCondition = (LoanLogInfoQueryCondition)input.get(0);

		if (list == null || list.size() < 1) {
			return false; // 下载后 不再次执行以下工作 ( 数据量没达到几万条 )
		}
		SupExcelFileUtils excel = new SupExcelFileUtils(filename);


		 * HSSFWorkbook workbook = new HSSFWorkbook();
		 *
		 * HSSFSheet sheet = workbook.createSheet("sheet1"); //sheet
		 // 表头
		HSSFRow rowtitle = excel.createRow((short) 0);// 添加表头
		excel.createTitle(rowtitle, title, 12);// 行对象,表头名称,列头数量(统计列 ->合并列)--改成了12列


		HSSFRow columnTitle = excel.createRow((short) 1);// 新增一行用于存放列头内容
		excel.createColumnTitle(columnTitle, title);

		excel.setColumnCell(0, "贷款支行");
		excel.setColumnCell(1, "贷款种类");
		excel.setColumnCell(2, "合同号");
		excel.setColumnCell(3, "借据号");
		excel.setColumnCell(4, "客户号");
		excel.setColumnCell(5, "姓名");
		excel.setColumnCell(6, "贷款金额");
		excel.setColumnCell(7, "贷款余额");
		excel.setColumnCell(8, "发放日期");
		excel.setColumnCell(9, "贷款到期日");
		excel.setColumnCell(10, "下一次还款日");
		excel.setColumnCell(11, "距离天数");
		excel.setColumnCell(12, "预计还本金额");
		excel.setColumnCell(13, "预计还息金额");
		excel.setColumnCell(14, "历史欠本金额");
		excel.setColumnCell(15, "历史欠息金额");
		excel.setColumnCell(16, "逾期状态");
		excel.setColumnCell(17, "五级分类");

		// 序号 申请机构 合同号 贷款品种 姓名 客户经理 起息日期 期限 年利率（%） 还款方式 贷款金额 未还本金 未还利息（含罚息与复利）
		// 已还本金 已还利息（含罚息与复利） 贷款余额 最高逾期日期 最高逾期天数 五级分类状态 手动分类/自动分类 合作商 合作项目 担保方式
		// 备注（担保内容）

		for (int i = 1; i < list.size() + 1; i++) {
			LoanSimpleInfoListView lsilv = (LoanSimpleInfoListView)list.get(i - 1);
			excel.createRow((short) i + 1);
			excel.setCell(0, lsilv.getBrname()+"");//--改成  获取机构名称
			excel.setCell(1, lsilv.getLnidName()+"");//
			excel.setCell(2, lsilv.getContractno()+"");//
			excel.setCell(3, lsilv.getCino()+"");
			excel.setCell(4, lsilv.getCustno());// add by weikun.wang 2008.3.25 还款帐号
			excel.setCell(5, lsilv.getName());
			excel.setCell(6, lsilv.getTotamtStr());
			excel.setCell(7, lsilv.getLnbalStr());
			excel.setCell(8, lsilv.getIsdate1());
			excel.setCell(9, lsilv.getDueDate());
			excel.setCell(10, lsilv.getTedate());
			excel.setCell(11, lsilv.getDays());
			excel.setCell(12, lsilv.getPlanAmt());
			excel.setCell(13, lsilv.getPlanInt());
			excel.setCell(14, lsilv.getTotoweamt());
			excel.setCell(15, lsilv.getTotoweint());
			excel.setCell(16, lsilv.getLnstatName());
			excel.setCell(17, lsilv.getClrClassName());

		}
		excel.exportXLS(os);
		return true; // 正常下载
	}
	*//**
	 * 生成贷款逾期信息 xls
	 *
	 * @throws Exception
	 *//*
	public boolean exportOveLoanQuery(String title, String filename,
			FileOutputStream os, List list) throws Exception {
		//LoanLogInfoQueryCondition loanLogInfoQueryCondition = (LoanLogInfoQueryCondition)input.get(0);

		if (list == null || list.size() < 1) {
			return false; // 下载后 不再次执行以下工作 ( 数据量没达到几万条 )
		}
		SupExcelFileUtils excel = new SupExcelFileUtils(filename);


		 * HSSFWorkbook workbook = new HSSFWorkbook();
		 *
		 * HSSFSheet sheet = workbook.createSheet("sheet1"); //sheet
		 // 表头
		HSSFRow rowtitle = excel.createRow((short) 0);// 添加表头
		excel.createTitle(rowtitle, title, 12);// 行对象,表头名称,列头数量(统计列 ->合并列)--改成了12列


		HSSFRow columnTitle = excel.createRow((short) 1);// 新增一行用于存放列头内容
		excel.createColumnTitle(columnTitle, title);

		excel.setColumnCell(0, "贷款支行");
		excel.setColumnCell(1, "贷款种类");
		excel.setColumnCell(2, "合同号");
		excel.setColumnCell(3, "借据号");
		excel.setColumnCell(4, "客户号");
		excel.setColumnCell(5, "姓名");
		excel.setColumnCell(6, "贷款金额");
		excel.setColumnCell(7, "贷款余额");
		excel.setColumnCell(8, "发放日期");
		excel.setColumnCell(9, "当前最早逾期日期");
		excel.setColumnCell(10, "逾期日期");
		excel.setColumnCell(11, "逾期期数");
		excel.setColumnCell(12, "历史欠本金额");
		excel.setColumnCell(13, "历史欠息金额");
		excel.setColumnCell(14, "逾期状态");
		excel.setColumnCell(15, "五级分类");

		// 序号 申请机构 合同号 贷款品种 姓名 客户经理 起息日期 期限 年利率（%） 还款方式 贷款金额 未还本金 未还利息（含罚息与复利）
		// 已还本金 已还利息（含罚息与复利） 贷款余额 最高逾期日期 最高逾期天数 五级分类状态 手动分类/自动分类 合作商 合作项目 担保方式
		// 备注（担保内容）

		for (int i = 1; i < list.size() + 1; i++) {
			LoanSimpleInfoListView lsilv = (LoanSimpleInfoListView)list.get(i - 1);
			excel.createRow((short) i + 1);
			excel.setCell(0, lsilv.getBrname()+"");//--改成  获取机构名称
			excel.setCell(1, lsilv.getLnidName()+"");//
			excel.setCell(2, lsilv.getContractno()+"");//
			excel.setCell(3, lsilv.getCino()+"");
			excel.setCell(4, lsilv.getCustno());// add by weikun.wang 2008.3.25 还款帐号
			excel.setCell(5, lsilv.getName());
			excel.setCell(6, lsilv.getTotamtStr());
			excel.setCell(7, lsilv.getLnbalStr());
			excel.setCell(8, lsilv.getIsdate1());
			excel.setCell(9, lsilv.getNearOvdDate());
			excel.setCell(10, lsilv.getOvdDays());
			excel.setCell(11, lsilv.getMaxOvdPeri());
			excel.setCell(12, lsilv.getTotoweamt());
			excel.setCell(13, lsilv.getTotoweint());
			excel.setCell(14, lsilv.getLnstatName());
			excel.setCell(15, lsilv.getClrClassName());

		}
		excel.exportXLS(os);
		return true; // 正常下载
	}

	*//**
	 * 生成贷款合同信息 xls
	 *
	 * @throws Exception
	 *//*

*//**
 * 生成个贷业务流水查询日报表
 *
 * @throws Exception
 *//*
public static boolean exportTlaLnplanmrRpt(String title, String filename,
		FileOutputStream os, List list) throws Exception {

	if (list == null || list.size() < 1) {
		return false; // 下载后 不再次执行以下工作 ( 数据量没达到几万条 )
	}
	SupExcelFileUtils excel = new SupExcelFileUtils(filename);


	 * HSSFWorkbook workbook = new HSSFWorkbook();
	 *
	 * HSSFSheet sheet = workbook.createSheet("sheet1"); //sheet
	 // 表头
	HSSFRow rowtitle = excel.createRow((short) 0);// 添加表头
	excel.createTitle(rowtitle, title, 13);// 行对象,表头名称,列头数量(统计列 ->合并列)--改成了12列

	HSSFRow columnTitle = excel.createRow((short) 1);// 新增一行用于存放列头内容
	excel.createColumnTitle(columnTitle, title);

	excel.setColumnCell(0, "机构号");
	excel.setColumnCell(1, "借据号");
	excel.setColumnCell(2, "交易日期");
	excel.setColumnCell(3, "客户姓名");
	excel.setColumnCell(4, "还款帐号");
	excel.setColumnCell(5, "  流水号  ");
	excel.setColumnCell(6, "交易类型");
	excel.setColumnCell(7, "交易名称");
	excel.setColumnCell(8, "交易标志");
	excel.setColumnCell(9, "本金");
	excel.setColumnCell(10, "利息");
	excel.setColumnCell(11, "交易来源");
	excel.setColumnCell(12, "备注");
	excel.setColumnCell(13, "时间戳");

	// 序号 申请机构 合同号 贷款品种 姓名 客户经理 起息日期 期限 年利率（%） 还款方式 贷款金额 未还本金 未还利息（含罚息与复利）
	// 已还本金 已还利息（含罚息与复利） 贷款余额 最高逾期日期 最高逾期天数 五级分类状态 手动分类/自动分类 合作商 合作项目 担保方式
	// 备注（担保内容）

	for (int i = 1; i < list.size() + 1; i++) {
		excel.createRow((short) i + 1);
		Map obj = (Map) list.get(i - 1);
		excel.createRow((short) i + 1);
		excel.setCell(0, obj.get("A1") +"");//--改成  获取机构名称
		excel.setCell(1, obj.get("A2") +"");//
		excel.setCell(2, obj.get("A3") +"");//
		excel.setCell(3, obj.get("A4") +"      ");
		excel.setCell(4, obj.get("A5")+"");
		excel.setCell(5, obj.get("A6") +"  ");
		excel.setCell(6, obj.get("A7") +"");
		excel.setCell(7, obj.get("A8") +"");
		excel.setCell(8, obj.get("A9") +"");
		excel.setCell(9, obj.get("A10") +"");
		excel.setCell(10, obj.get("A11") +"");
		excel.setCell(11, obj.get("A12") +"");
		excel.setCell(12, obj.get("A13") +"");
		excel.setCell(13, obj.get("A14") +"");
	}
	excel.exportXLS(os);
	return true; // 正常下载
}*/

}

/*
 * wuzhiwei文档 别删除
 *
 * HSSF提供给用户使用的对象在org.apache.poi.hssf.usermodel包中,主要部分包括Excell对象，样式和格式，还有辅助操作。有以下几种对象：
 * HSSFWorkbook 用于创建excel文件 HSSFSheet 用于创建excel的书册 HSSFRow 用于创建一行 HSSFCell
 * 用于创建一个单元格 HSSFFont 用于创建一个单元格的字体格式
 *
 *
 * HSSFName 名称 HSSFDataFormat 日期格式
 *
 * 在poi1.7中才有以下2项： HSSFHeader sheet头 HSSFFooter sheet尾
 *
 * 和这个样式 HSSFCellStyle cell样式 用于创建一个单元格的格式
 *
 * 辅助操作包括 HSSFDateUtil 日期 HSSFPrintSetup 打印 HSSFErrorConstants 错误信息表
 *
 *
 * Report.java 接口类，所有的获取数据的类必须实现这个接口，以便生成文件时统一管理； ExcelContent.java
 * 实现了Report接口，负责获取数据并组装到hashtable； ReportTool.java 根据传入的参数生成excel文件，并返回生成的文件名；
 * CreateReport.java 被外部程序调用，负责获取数据和把数据传递给ReportTool，最后生成excel文件，返回生成的文件名给调用者。
 */
