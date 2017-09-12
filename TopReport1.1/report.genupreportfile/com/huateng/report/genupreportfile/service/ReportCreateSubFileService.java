package com.huateng.report.genupreportfile.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;

import resource.bean.report.AlreadySubInfo;
import resource.bean.report.SubFileConf;
import resource.bean.report.SubFileInfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.genupreportfile.bean.ReportWaitToFileBean;
import com.huateng.report.genupreportfile.utils.SubFileShowAware;
import com.huateng.report.send.bean.ReportBeanIn;
import com.huateng.report.send.translate.ITranslate;
import com.huateng.report.send.utils.ReportParser;
import com.huateng.report.system.common.ExecuteSubFileConf;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

public class ReportCreateSubFileService {
	private static final HtLog htlog = HtLogFactory.getLogger(ReportCreateSubFileService.class);
	private static final String HQL_TABLENAME = "TABLENAME";

	protected ReportCreateSubFileService() {
	}

	public synchronized static ReportCreateSubFileService getInstance() {
		return (ReportCreateSubFileService) ApplicationContextUtils.getBean(ReportCreateSubFileService.class.getName());
	}

	public int getSubFileCountAndSaveSubFile(String busiType, String appType, String workDate) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer querySql = new StringBuffer();
		querySql.append(" select count(model) from ").append(HQL_TABLENAME).append(" model ");
		querySql.append(" where model.recStatus='" + TopReportConstants.REPORT_RECSTATUS_05 + "'");// 审核已确认
		if (ReportConstant.CREATE_SUB_FILE_IS_WORKDATE) {
			querySql.append(" and model.workDate='" + workDate + "'");
		}
		Set<String> tableNmSet = ReportUtils.getQueryTableSet(busiType, appType);
		int total = 0;
		for (Iterator<String> it = tableNmSet.iterator(); it.hasNext();) {
			String tnm = it.next();
			String hql = querySql.toString().replaceAll(HQL_TABLENAME, tnm);
			int count = rootdao.queryByHqlToCount(hql);
			total += count;
			if (total > 0) {
				break;
			}
		}
		return total;
	}

	public List getSubFileConfrim(String busiType, String appType, String workDate) throws CommonException {
		List retlist = new ArrayList();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer countHql = new StringBuffer();
		countHql.append("select model.apptype as aptype,model.currentfile as ftype,count(model) as tpcount from ").append(HQL_TABLENAME)
				.append(" model where 1=1 ");
		if (ReportConstant.CREATE_SUB_FILE_IS_WORKDATE) {
			countHql.append(" and model.workDate='" + workDate + "'");
		}
		countHql.append(" and model.recStatus.recStatus='" + TopReportConstants.REPORT_RECSTATUS_05 + "'");// 审核已确认，待生成上报文件
		countHql.append(" group by model.apptype,model.currentfile");
		Set<String> tableNmSet = ReportUtils.getQueryTableSet(busiType, appType);
		for (Iterator<String> it = tableNmSet.iterator(); it.hasNext();) {
			String tnm = it.next();
			String hql = countHql.toString().replaceAll(HQL_TABLENAME, tnm);
			List list = rootdao.queryByQL2List(hql);
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Object[] obj = (Object[]) list.get(i);
					ReportWaitToFileBean info = new ReportWaitToFileBean();
					info.setFileDate(workDate);
					info.setAppType(obj[0].toString());
					info.setFileType(obj[1].toString());
					int rowCount = Integer.parseInt(obj[2].toString());
					info.setRecCount(rowCount);
					int filecount = rowCount / ReportConstant.SUB_FILE_REC_ROW;
					if (rowCount % ReportConstant.SUB_FILE_REC_ROW > 0) {
						filecount += 1;
					}
					info.setFileCount(filecount);
					retlist.add(info);
				}
			}
		}
		return retlist;
	}

	/**
	 * 生成上报文件
	 * 
	 * @param fileDate
	 * @param busiType
	 * @return
	 * @throws CommonException
	 */
	public List<String> createSubFile(String fileDate, String busiType, String appType) throws CommonException {
		// 存储上传文件包
		List<String> uploadPackList = new ArrayList<String>();

		GlobalInfo info = GlobalInfo.getCurrentInstance();
		String brNo = info.getBrno().trim();
		ReportCommonService commService = ReportCommonService.getInstance();
		Date startTm = new Date();
		// 上报日期
		String subDate = ReportUtils.getSubFileDate6(info);
		// 存储生成文件
		Set<String> sendFileSet = new LinkedHashSet<String>();

		List subFileList = commService.getSubFileConfByAppType(TopReportConstants.REPORT_BUSITYPE_BOP, appType);

		// 控制文件
		SubFileConf confControl = commService.getSubFileConfByAppTypeByControl(busiType, appType);
		if (confControl == null) {
			ExceptionUtil.throwCommonException(appType + "控制文件未设置!");
		}
		String controlFileTypeName = confControl.getId().getFileType();// 控制文件类型名称TT/T

		// 上报文件包名
		String pack = getSubFileNameOrPack(appType, subDate, brNo, controlFileTypeName, null);
		uploadPackList.add(pack);
		// 上报文件本地路径
		String basePath = ReportUtils.getSysParamsValue(ReportConstant.REPORT_LOACL_DATA_PARAMGROUP, appType);
		for (int j = 0; j < subFileList.size(); j++) {
			SubFileConf conf = (SubFileConf) subFileList.get(j);
			if (conf != null && conf.getFileResultPath() != null && conf.getFileResultPath().trim().length() > 0 && conf.getXmlFileId() != null) {
				String xmlId = conf.getXmlFileId();
				String fileType = conf.getId().getFileType();

				List dsDataList = ExecuteSubFileConf.execute(fileDate, sendFileSet, conf, pack, controlFileTypeName);

				if (dsDataList != null && dsDataList.size() > 0) {
					// 1.生成文件
					List<SubFileInfo> subFileInfo = CreateFileByDataList(info, dsDataList, subDate, brNo, appType, fileType, xmlId, basePath, pack,
							busiType);
					if (!fileType.equals(controlFileTypeName)) {
						for (int k = 0; k < subFileInfo.size(); k++) {
							SubFileInfo retInfo = subFileInfo.get(k);
							sendFileSet.add(retInfo.getId());
						}
					}
					// 1.1更新记录状态并写入相关表
					saveSubFileInfo(info, conf, dsDataList, subFileInfo, controlFileTypeName);
				}
			}
		}
		Date endTm = new Date();
		ReportCommonService.getInstance().saveBiProcessLog(DateUtil.dateToNumber(info.getTxdate()), busiType, appType, brNo,
				TopReportConstants.REPORT_PROCESS_EXECTYPE_GENREPORT, startTm, endTm, TopReportConstants.REPORT_PROCESS_OPERTYPE_MANU);

		info.addBizLog("Updater.log", new String[] { info.getTlrno(), brNo, "上报文件生成，业务类型【" + busiType + "】，应用类型【" + appType + "】" });
		htlog.info("Updater.log", new String[] { info.getTlrno(), brNo, "上报文件生成，业务类型【" + busiType + "】，应用类型【" + appType + "】" });

		return uploadPackList;
	}

	public void saveSubFileInfo(GlobalInfo info, SubFileConf conf, List dataList, List<SubFileInfo> subFileList, String controlFileTypeName)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if (subFileList != null && subFileList.size() > 0) {
			for (int i = 0; i < subFileList.size(); i++) {
				// 1.写入文件表
				SubFileInfo subFileInfo = subFileList.get(i);
				subFileInfo.setIsImpRep(ReportEnum.REPORT_IS.NO.value);// 未导入回执
				subFileInfo.setIsSub(ReportEnum.REPORT_IS.NO.value);// 未上报
				rootdao.saveOrUpdate(subFileInfo);
				try {
					// 2.写入已报送文件表
					if (!conf.getId().getFileType().equals(controlFileTypeName)) {
						int datalen = dataList.size();
						for (int j = ReportConstant.SUB_FILE_REC_ROW * i; j < datalen; j++) {
							Object obj = dataList.get(j);

							String recId = (String) PropertyUtils.getNestedProperty(obj, "id");
							String bussNo = null;
							if (conf.getBusiPkStr() != null && conf.getBusiPkStr().trim().length() > 0) {
								bussNo = ReportUtils.getBopDsBusiNo(obj, conf.getBusiPkStr(), conf);
							}
							// 判断已报送文件是否已经生成过
							List alreadySubInfoList = rootdao.queryByQL2List(" from AlreadySubInfo model where model.apptype='"
									+ conf.getId().getAppType() + "' and model.currentfile='" + conf.getId().getFileType() + "' and model.recId='"
									+ recId + "'");
							AlreadySubInfo alInfo = null;
							if (alreadySubInfoList.size() == 1) {
								alInfo = (AlreadySubInfo) alreadySubInfoList.get(0);
							} else {
								alInfo = new AlreadySubInfo();
								alInfo.setId(ReportUtils.getUUID());
								alInfo.setApptype(conf.getId().getAppType());
								alInfo.setCurrentfile(conf.getId().getFileType());
								alInfo.setRecId(recId);
								alInfo.setRecDate(subFileInfo.getFileDate());
								alInfo.setBrNo(info.getBrno());
							}
							alInfo.setBussno(bussNo);
							alInfo.setFileName(subFileInfo.getId());
							alInfo.setFileSeq(subFileInfo.getSubFileSeq());
							rootdao.saveOrUpdate(alInfo);
							// 3.更新记录状态
							PropertyUtils.setNestedProperty(obj, "recStatus", TopReportConstants.REPORT_RECSTATUS_06);// 已生成文件
							PropertyUtils.setNestedProperty(obj, "lstUpdTlr", info.getTlrno());
							PropertyUtils.setNestedProperty(obj, "lstUpdTm", new Date());
							rootdao.saveOrUpdate(obj);

							// 4.写入数据处理日志
							ReportCommonService.getInstance().saveBiDataProcessLog(conf.getId().getAppType(), conf.getId().getFileType(), recId,
									bussNo, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_GENREPORT, subFileInfo.getId(), subFileInfo.getFilePack());
						}
					}
				} catch (Exception e) {
					ExceptionUtil.throwCommonException(e.getMessage());
				}
			}
		}
	}

	/**
	 * 加载包或文件名称
	 * 
	 * @param appType
	 * @param fileDate
	 * @param brNo
	 * @param fileType
	 * @param ext
	 * @return
	 * @throws CommonException
	 */
	public String getSubFileNameOrPack(String appType, String fileDate, String brNo, String fileType, String ext) throws CommonException {
		String btl = brNo;
		if (!ReportConstant.BOP_SUB_FILE_BRNO_TYPE) {
			btl = ReportUtils.getSysParamsValue("SUB", "BOP", brNo);
		}
		StringBuffer str = new StringBuffer(appType);
		str.append(fileType);
		str.append(btl);
		str.append(fileDate);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Object maxObj = rootdao.queryByHqlMax(" select max(subFileSeq) from SubFileInfo where fileDate='" + fileDate + "' and apptype='" + appType
				+ "' and currentfile='" + fileType + "' and brNo='" + btl + "'");
		if (maxObj == null || maxObj.toString().trim().length() == 0) {
			str.append("01");
		} else {
			int seq = Integer.parseInt(maxObj.toString()) + 1;
			if (seq < 10) {
				str.append("0" + seq);
			} else {
				str.append(seq);
			}
		}
		if (ext != null && ext.trim().length() > 0) {
			str.append("." + ext);
		}
		return str.toString();
	}

	/**
	 * 生成文件
	 * 
	 * @param info
	 * @param list
	 * @param subDate
	 * @param brNo
	 * @param appType
	 * @param fileType
	 * @param xmlId
	 * @param basePath
	 * @param pack
	 * @return
	 * @throws CommonException
	 */
	public List<SubFileInfo> CreateFileByDataList(GlobalInfo info, List list, String subDate, String brNo, String appType, String fileType,
			String xmlId, String basePath, String pack, String busiType) throws CommonException {
		String workdate = DateUtil.dateToNumber(info.getTxdate());
		ReportBeanIn repBean = new ReportBeanIn();
		repBean.setAppType(appType);
		repBean.setInOut(ReportEnum.REPORT_FILE_INOUT.IN.value);
		for (int i = 0; i < list.size(); i++) {
			repBean.getRecords().add(list.get(i));
		}
		String fileName = getSubFileNameOrPack(appType, subDate, brNo, fileType, "xml");
		repBean.setBeanId(xmlId);
		repBean.setBasePath(basePath);
		repBean.setFilePath(pack);
		repBean.setFileName(fileName);
		repBean.setWorkDate(workdate);
		repBean.setBrNo(brNo);
		repBean.setFileDate(subDate);
		repBean.setCurrentFile(fileType);
		repBean.setBusiType(busiType);
		SubFileShowAware.putEvent("生成：" + fileName + " 文件成功!");
		try {
			List<SubFileInfo> subFileList = ReportParser.getInstance().generateFile(repBean);
			return subFileList;
		} catch (Exception e) {
			SubFileShowAware.putEvent("生成" + fileName + "上报文件错误!");
			ExceptionUtil.throwCommonException("生成上报文件错误", e, null);
		}
		return null;
	}

	public List<SubFileInfo> getSubFileInfoListByPack(String packName) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.queryByQL2List(" from SubFileInfo model where model.filePack='" + packName.trim() + "'");
	}

	/**
	 * 对生成文件进行上传
	 * 
	 * @return
	 */
	public boolean subFileUpLoad(ITranslate tran, String packName) throws CommonException {
		boolean bl = false;
		String localFilePath = null;
		String serverFilePath = null;
		List<SubFileInfo> subFileInfoList = getSubFileInfoListByPack(packName);
		if (subFileInfoList != null && subFileInfoList.size() > 0) {
			SubFileInfo info = subFileInfoList.get(0);
			String appType = info.getApptype();
			localFilePath = ReportUtils.getSysParamsValue(ReportConstant.REPORT_LOACL_DATA_PARAMGROUP, appType);
			serverFilePath = ReportUtils.getSysParamsValue(ReportConstant.REPORT_REMOTE_DATA_PARAMGROUP, appType);
			
			// 开始上传
			for (int i = 0; i < subFileInfoList.size(); i++) {
				SubFileInfo subFile = subFileInfoList.get(i);
				// 页面显示开始上传
				boolean isSend = tran.send(localFilePath, serverFilePath, subFile.getFilePack(), subFile.getId());
				if (!isSend) {
					ExceptionUtil.throwCommonException(subFile.getId() + "上报出错！");
				}
			}
			try {
				tran.unlock(serverFilePath);// 去除tonke锁
			} catch (Exception e) {
				ExceptionUtil.throwCommonException(e.getMessage());
			}
			// 更新相关记录
			updateSubFileInfoBySend(subFileInfoList);
			bl = true;
		}
		return bl;
	}

	public void updateSubFileInfoBySend(List<SubFileInfo> subFileList) throws CommonException {
		GlobalInfo info = GlobalInfo.getCurrentInstance();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if (subFileList != null && subFileList.size() > 0) {
			for (int i = 0; i < subFileList.size(); i++) {
				// 1.更新文件表
				SubFileInfo subFileInfo = subFileList.get(i);
				subFileInfo.setIsSub(ReportEnum.REPORT_IS.YES.value);// 已上报
				subFileInfo.setSubTlr(info.getTlrno());
				subFileInfo.setSubTm(new Date());
				subFileInfo.setSubType(TopReportConstants.REPORT_SUB_FILE_TYPE_01);
				rootdao.saveOrUpdate(subFileInfo);
			}
		}
	}
}
