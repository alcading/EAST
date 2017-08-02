package com.huateng.report.imports.operation;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BiImportFileConfig;
import resource.bean.report.BiImportLog;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.imports.bean.ImportFileBean;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.imports.common.FileImportUtil;
import com.huateng.report.imports.logic.ImportFile;
import com.huateng.report.imports.logic.ImportFileVar;
import com.huateng.report.imports.model.Constant;
import com.huateng.report.imports.model.SqlInfo;
import com.huateng.report.imports.model.TFileDataInfo;
import com.huateng.report.imports.service.FileImportService;

public class ImportFileOP extends BaseOperation {

	public static String ID = "ImportFileOP";
	public static String CMD = "CMD";
	public static String RESULT = "RESULT";

	public static String DO_UPD_IMP_STATUS_YES = "updateImpStatusYes";
	public static String DO_UPD_IMP_STATUS_NO = "updateImpStatusNo";
	public static String DO_GET_IMP_STATUS = "getImpStatus";
	public static String DO_IMPORT = "DO_IMPORT";
	public static String DO_MOD_IMPORT = "DO_MOD_IMPORT";
	public static String DO_SAVELOG = "DO_SAVELOG";
	public static String DO_EXESQL = "DO_EXESQL";
	public static String DO_EXEBATCHSQL = "DO_EXEBATCHSQL";

	public static String PARAM = "PARAM";
	public static String PROGRESS = "PROGRESS_VAR";

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		// if (DO_UPD_IMP_STATUS_YES.equalsIgnoreCase(cmd)) {
		// FileImportService.getInstance().updateImportStatus(Constants.YES);
		// } else if (DO_UPD_IMP_STATUS_NO.equalsIgnoreCase(cmd)) {
		// FileImportService.getInstance().updateImportStatus(Constants.NO);
		// } else
		if (DO_IMPORT.equalsIgnoreCase(cmd)) {
			doImport(context);
		} else if (DO_SAVELOG.equalsIgnoreCase(cmd)) {
			Object log = context.getAttribute(PARAM);
			if (log instanceof BiImportLog) {
				GlobalInfo gi = GlobalInfo.getCurrentInstanceWithoutException();
				if(gi!=null){
					((BiImportLog) log).setIp(gi.getIp());
				}
				ROOTDAOUtils.getROOTDAO().saveOrUpdate(log);
			}
		} else if (DO_EXESQL.equalsIgnoreCase(cmd)) {
			List<SqlInfo> list = (List<SqlInfo>) context.getAttribute(PARAM);
			Object[] obj = new Object[list.size()];
			int i = 0;
			for (SqlInfo sql : list) {
				int n = FileImportService.getInstance().executeUpdate(
						(String) sql.getParamMap().get("strSql"));
				obj[i++] = n;
			}
			context.setAttribute(RESULT, obj);

		} else if (DO_MOD_IMPORT.equalsIgnoreCase(cmd)) {
			doModImport(context);
		}

	}

	private void doModImport(OperationContext context) throws CommonException {
		BiImportLog log = (BiImportLog) context.getAttribute(PARAM);
		Constant constant = (Constant) context.getAttribute(PROGRESS);
		BiImportFileConfig bean = ROOTDAOUtils.getROOTDAO().query(
				BiImportFileConfig.class, log.getFuid());
		TFileDataInfo curImpFileInfo = new TFileDataInfo();
		curImpFileInfo.setGuid(bean.getId());
		curImpFileInfo.setFileName(log.getErrFile());
		curImpFileInfo.setTableName(bean.getTableName());
		if (bean.getBatchNo() != null) {
			curImpFileInfo.setBatchNo(bean.getBatchNo());
		}
		curImpFileInfo.setFileOwner(bean.getFileOwner());
		curImpFileInfo.setFormatType(ImportFileVar.FILEDATA_FORMATTYPE_SYMBOL);
		curImpFileInfo.setListSeparator(bean.getSeperator() == null ? "" : bean
				.getSeperator());
		if (bean.getSeqNo() != null) {
			curImpFileInfo.setSequenceNo(bean.getSeqNo());
		}
		curImpFileInfo.setImportTime(bean.getImportTime());
		if (bean.getUpdateType() != null) {
			curImpFileInfo.setKeyFlag(Integer.valueOf(bean.getUpdateType()));
		}
		if (bean.getStartRow() != null) {
			curImpFileInfo.setStartRow(bean.getStartRow());
		}
		if (bean.getStartColumn() != null) {
			curImpFileInfo.setStartColumn(bean.getStartColumn());
		}
		curImpFileInfo.setEndRowFlag(bean.getEndrowFlag());
		if (bean.getEndColumn() != null) {
			curImpFileInfo.setEndColumn(bean.getEndColumn());
		}
		if (bean.getSheetNum() != null) {
			curImpFileInfo.setSheetNum(bean.getSheetNum());
		}
		curImpFileInfo.setMainFlag(bean.getMainFlag());
		curImpFileInfo.setFuid(bean.getFuid());
		curImpFileInfo.setTradeDate(FileImportUtil.getWorkDate(null));
		curImpFileInfo.setErrFlg(1);
		ImportFile importFile = new ImportFile();
		String modFlg = log.getModFlg();
		String errFilenamepath = log.getErrFilePath();
		if (StringUtils.isEmpty(errFilenamepath)) {
			ExceptionUtil.throwCommonException("EIMP005");
		}
		curImpFileInfo.setFileFullName(log.getErrFile());
		if (!Constants.MOD_FLG_FINISH.equals(modFlg)) {
			ExceptionUtil.throwCommonException("EIMP004");
		}
		curImpFileInfo.setBeginTime(FileImportUtil.getCurTime());
		try {
			boolean flag = importFile.importFile(curImpFileInfo,
					errFilenamepath, constant);
			log.setModFlg(Constants.MOD_FLG_IMPORT);
			ROOTDAOUtils.getROOTDAO().saveOrUpdate(log);
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionUtil.throwCommonException("EIMP003",
					new Object[] { log.getErrFile() });
		}

	}

	private void doImport(OperationContext context) throws CommonException {
		ImportFileBean bean = (ImportFileBean) context.getAttribute(PARAM);
		Constant pv = (Constant) context.getAttribute(PROGRESS);
		pv.currentFile = bean.getFileNameFull();
		pv.id = bean.getId();

		// 文件全称没有赋值
		if (DataFormat.isEmpty(bean.getFileNameFull())) {
			bean.setFileNameFull(FileImportUtil.getFileNameFull(
					bean.getWorkDate(), bean.getFileName()));
		}
		// 文件不存在
		if (!bean.isExist()
				|| !FileImportUtil.isExist(bean.getWorkDate(),
						bean.getFileNameFull())) {
			ExceptionUtil.throwCommonException("EIMP002",
					new Object[] { bean.getFileNameFull() });
		}

		if (bean.isReImport()) {// 重新导入
//			FileImportService.getInstance().deleteOldRecords(
//					bean.getTableName(), bean.getWorkDate());
		}
		if((bean.getImpStatus()!=null &&  !bean.getImpStatus().equals("2")) && !bean.isReImport()){
			ExceptionUtil.throwCommonException("文件名:["+pv.currentFile+"],导入状态:[已导入],请勿重复导入!",new Object[] { bean.getFileNameFull() });
		}
		importData(bean, pv);

	}

	private void importData(ImportFileBean bean, Constant pv)
			throws CommonException {
		TFileDataInfo curImpFileInfo = new TFileDataInfo();
		curImpFileInfo.setGuid(bean.getId());
		curImpFileInfo.setFileName(bean.getFileNameFull());
		curImpFileInfo.setTableName(bean.getTableName());
		if (bean.getBatchNo() != null) {
			curImpFileInfo.setBatchNo(bean.getBatchNo());
		}
		curImpFileInfo.setFileOwner(bean.getFileOwner());
		curImpFileInfo.setFormatType(bean.getFileType());// TODO
															// 或bean.getSplitType()
		curImpFileInfo.setListSeparator(bean.getSeperator());
		if (bean.getSeqNo() != null) {
			curImpFileInfo.setSequenceNo(bean.getSeqNo());
		}
		curImpFileInfo.setImportTime(bean.getImportTime());// 导入时机(每日/每月),不是导入时间
		if (bean.getUpdateType() != null) {
			curImpFileInfo.setKeyFlag(Integer.valueOf(bean.getUpdateType()));
		}
		if (bean.getStartRow() != null) {
			curImpFileInfo.setStartRow(bean.getStartRow());
		}
		if (bean.getStartColumn() != null) {
			curImpFileInfo.setStartColumn(bean.getStartColumn());
		}
		curImpFileInfo.setEndRowFlag(bean.getEndrowFlag());
		if (bean.getEndColumn() != null) {
			curImpFileInfo.setEndColumn(bean.getEndColumn());
		}
		if (bean.getSheetNum() != null) {
			curImpFileInfo.setSheetNum(bean.getSheetNum());
		}
		curImpFileInfo.setMainFlag(bean.getMainFlag());
		curImpFileInfo.setFuid(bean.getFuid());
		curImpFileInfo.setTradeDate(bean.getWorkDate());
		// curImpFileInfo.setFormate_date(formate_date);
		// String filePath = (String)
		// item.getItemProperty("fileName").getValue();
		// String fileNameFomat = (String)
		// item.getItemProperty("FILENAME_FORMAT")
		// .getValue();
		// String workDate = (String) map.get("importDate");
		// if (fileNameFomat != null) {
		// fileNameFomat = fileNameFomat.substring(0,
		// fileNameFomat.lastIndexOf(")"))
		// + ",\"" + filePath + "\"" + ",\"" + workDate + "\")";
		// try {
		// filePath = (String) ExpressionEvaluator.evaluate(fileNameFomat);
		// } catch (IllegalExpressionException e1) {
		// e1.printStackTrace();
		// }
		// }
		curImpFileInfo.setFileFullName(bean.getFileNameFull());

		curImpFileInfo.setBeginTime(FileImportUtil.getCurTime());
		ImportFile importFile = new ImportFile();
		boolean fileFlag = false;
		try {
			// 文件导入处理
			fileFlag = importFile.importFile(curImpFileInfo,
					FileImportUtil.getFilePath(curImpFileInfo.getTradeDate()),
					pv);
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionUtil.throwCommonException("EIMP003",
					new Object[] { bean.getFileNameFull() });
		}
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
