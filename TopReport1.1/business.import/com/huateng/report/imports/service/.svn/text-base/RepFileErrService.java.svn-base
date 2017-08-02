package com.huateng.report.imports.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import resource.bean.report.RepFileErrDet;
import resource.bean.report.SubFileConf;
import resource.bean.report.SubFileInfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.imports.bean.ReportFeedBackBean;
import com.huateng.report.send.bean.ReportFeedBackCtrl;
import com.huateng.report.send.bean.ReportFeedBackErrField;
import com.huateng.report.send.bean.ReportFeedBackErrRec;
import com.huateng.report.send.bean.ReportFeedBackInfo;
import com.huateng.report.send.parse.XmlBeanParser;
import com.huateng.report.send.translate.ITranslate;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

public class RepFileErrService {
	private static final HtLog htlog = HtLogFactory.getLogger(RepFileErrService.class);
	private static final String HQL_TABLENAME = "TABLENAME";

	/**
	 * Default constructor
	 */
	protected RepFileErrService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static RepFileErrService getInstance() {
		return (RepFileErrService) ApplicationContextUtils.getBean(RepFileErrService.class.getName());
	}

	/**
	 * 获取下载到本地后文件全路径
	 *
	 * @param srcpath
	 * @param repPack
	 * @param fileName
	 * @return
	 */
	private String getFeedbackFilePath(String srcpath, String repPack, String fileName) {
		StringBuffer ttFilePath = new StringBuffer();
		String feedbackPath = ReportUtils.getSysParamsValue("DIR", "0004", "Feedback/");
		ttFilePath.append(srcpath).append(feedbackPath);
		ttFilePath.append(repPack + "/");
		ttFilePath.append(fileName);
		return ttFilePath.toString();
	}

	/**
	 * 根据报送文件名计算回执文件名
	 *
	 * @param sendFileName
	 * @param errSign
	 * @return
	 */
	private String getRepFileNameBySendFileName(String sendFileName, String errSign) {
		String[] fs = sendFileName.split("\\.");
		StringBuffer tempFileName = new StringBuffer();
		tempFileName.append(fs[0]);
		tempFileName.append(errSign);
		tempFileName.append("." + fs[1]);
		return tempFileName.toString();
	}


	public String importRepFile(String repPackName,String srcpath,ReportFeedBackBean bean,String errSign,String tlrNo){
		String ret = null;
		// 2.读取TT文件
		String repTtFileName = repPackName + ".xml";
		String ttFilePath = getFeedbackFilePath(srcpath, repPackName, repTtFileName);
		if (ReportUtils.isFileExist(ttFilePath)) {
			XmlBeanParser parser = new XmlBeanParser();
			try {
				parser.setBuffBeanId(ReportFeedBackCtrl.ID);
				Object object = parser.convert2BeanByFile(ttFilePath);
				ReportFeedBackCtrl reportFeedBackCtrl = (ReportFeedBackCtrl) object;
				// 3.查询相关文件及记录进行更新或写入
				updateSubFileInfoByFeedBack(bean, errSign, srcpath, repPackName, repTtFileName, reportFeedBackCtrl,
						tlrNo);
				ret = ITranslate.RESCODE_SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				ret = repPackName + "处理回执信息出错，" + e.getMessage();
				htlog.error(ret);
			}
		} else {
			ret = repPackName + "接口控制文件不存!";
		}
		return ret;
	}

	public String repFileDownAndImportByBop(String repPackName,ITranslate translate, ReportFeedBackBean bean, String srcpath,
			String destpath, String errSign, String tlrNo) throws CommonException {
		if (translate == null) {
			ExceptionUtil.throwCommonException("服务器连接异常！");
		}
		// 1.下载
		String ret = translate.feedBack(srcpath, destpath, repPackName);
		if (ret.equals(ITranslate.RESCODE_SUCCESS)) {// 下载成功，开始执行导入
			importRepFile(repPackName, srcpath, bean, errSign, tlrNo);
		}
		return ret;
	}

	public void saveSubFileErr(String repFileName, ReportFeedBackInfo reportFeedBackInfo) throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		if (reportFeedBackInfo.getFormatErrs() > 0) {// 格式错误
			List<String> errList = reportFeedBackInfo.getFormats();
			for (int i = 0; i < errList.size(); i++) {
				RepFileErrDet det = new RepFileErrDet();
				det.setId(ReportUtils.getUUID());
				det.setRepFileName(repFileName);
				det.setApptype(reportFeedBackInfo.getAppType());
				det.setCurrentfile(reportFeedBackInfo.getCurrentFile());
				det.setRepErrType(ReportEnum.REPORT_ERR_TYPE.FORMAT_ERR.value);
				det.setErrdesc(errList.get(i));
				rootDao.saveOrUpdate(det);
			}
		} else {// 记录错误
			List<ReportFeedBackErrRec> recErrList = reportFeedBackInfo.getErrRecords();
			if (recErrList.size() > 0) {
				for (int i = 0; i < recErrList.size(); i++) {
					ReportFeedBackErrRec rec = recErrList.get(i);
					List<ReportFeedBackErrField> fieldList = rec.getErrFields();
					for (int j = 0; j < fieldList.size(); j++) {
						ReportFeedBackErrField errField = fieldList.get(j);
						RepFileErrDet det = new RepFileErrDet();
						det.setId(ReportUtils.getUUID());
						det.setRepFileName(repFileName);
						det.setApptype(reportFeedBackInfo.getAppType());
						det.setCurrentfile(reportFeedBackInfo.getCurrentFile());
						det.setRepErrType(ReportEnum.REPORT_ERR_TYPE.REC_ERR.value);
						det.setBussno(rec.getBussno()==null?rec.getRptno():rec.getBussno());
						det.setErrfield(errField.getErrField());
						det.setErrfieldcn(errField.getErrFieldCn());
						det.setErrdesc(errField.getErrDesc());
						rootDao.saveOrUpdate(det);
					}
				}
			}
		}
	}

	public void updateBopDsStatus(SubFileInfo retSubFileInfo, List<ReportFeedBackErrRec> errRecords, String tlrNo)
			throws Exception {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(" from " + HQL_TABLENAME).append(" model ");
		hql.append(" where model.id in (");
		hql.append("select recId from AlreadySubInfo where fileName='" + retSubFileInfo.getId() + "' and apptype='"
				+ retSubFileInfo.getApptype() + "' and currentfile='" + retSubFileInfo.getCurrentfile() + "')");

		String errType = retSubFileInfo.getRepErrType();
		Set<String> errBusiNoSet = new HashSet<String>();
		if (errRecords != null && errRecords.size() > 0) {
			for (int i = 0; i < errRecords.size(); i++) {
				ReportFeedBackErrRec errRec = errRecords.get(i);
				if (StringUtils.isNotEmpty(errRec.getBussno())) {
					errBusiNoSet.add(errRec.getBussno());
				} else if (StringUtils.isNotEmpty(errRec.getRptno())) {
					errBusiNoSet.add(errRec.getRptno());
				}
			}
		}

		String tableName = ReportUtils.getBopDsBeanName(retSubFileInfo.getApptype(), retSubFileInfo.getCurrentfile());
		if (tableName != null) {
			SubFileConf conf = ReportUtils.getSubFileConfByBopPk(retSubFileInfo.getApptype(), retSubFileInfo
					.getCurrentfile());
			List list = rootDao.queryByQL2List(hql.toString().replaceAll(HQL_TABLENAME, tableName));
			for (int i = 0; i < list.size(); i++) {
				Object obj = list.get(i);
				String remark = null;
				String recId = (String) PropertyUtils.getNestedProperty(obj, "id");
				String bussNo = null;
				if (conf.getBusiPkStr() != null && conf.getBusiPkStr().trim().length() > 0) {
					bussNo = ReportUtils.getBopDsBusiNo(obj, conf.getBusiPkStr(), conf);
				}
				if (errType.equals(ReportEnum.REPORT_ERR_TYPE.NO_ERR.value)) {// 无错误
					String actionType = (String) PropertyUtils.getNestedProperty(obj, "actiontype");
					if (actionType.equals(TopReportConstants.REPORT_ACTIONTYPE_D)) {// 上报状态为删除
						PropertyUtils.setNestedProperty(obj, "recStatus", TopReportConstants.REPORT_RECSTATUS_07);// 已删除
					} else {
						PropertyUtils.setNestedProperty(obj, "recStatus", TopReportConstants.REPORT_RECSTATUS_01);// 可编辑
					}
					PropertyUtils.setNestedProperty(obj, "subSuccess", TopReportConstants.REPORT_IS_SUB_SUCCESS_YES);// 已成功上报过
					PropertyUtils.setNestedProperty(obj, "repStatus", TopReportConstants.REPORT_REPSTATUS_01);// 回执成功

					remark = retSubFileInfo.getTotalrecords().toString();

				} else if (errType.equals(ReportEnum.REPORT_ERR_TYPE.FORMAT_ERR.value)) {// 格式错误
					PropertyUtils.setNestedProperty(obj, "recStatus", TopReportConstants.REPORT_RECSTATUS_01);// 可编辑
					PropertyUtils.setNestedProperty(obj, "repStatus", TopReportConstants.REPORT_REPSTATUS_02);// 回执失败

					remark = retSubFileInfo.getTotalrecords().toString();

				} else if (errType.equals(ReportEnum.REPORT_ERR_TYPE.REC_ERR.value)) {// 记录错误
					if (bussNo != null && errBusiNoSet.contains(bussNo)) {// 业务主键存在错误信息中
						PropertyUtils.setNestedProperty(obj, "recStatus", TopReportConstants.REPORT_RECSTATUS_01);// 可编辑
						PropertyUtils.setNestedProperty(obj, "repStatus", TopReportConstants.REPORT_REPSTATUS_02);// 回执失败
					} else {
						String actionType = (String) PropertyUtils.getNestedProperty(obj, "actiontype");
						if (actionType.equals(TopReportConstants.REPORT_ACTIONTYPE_D)) {// 上报状态为删除
							PropertyUtils.setNestedProperty(obj, "recStatus", TopReportConstants.REPORT_RECSTATUS_07);// 已删除
						} else {
							PropertyUtils.setNestedProperty(obj, "recStatus", TopReportConstants.REPORT_RECSTATUS_01);// 可编辑
						}
						PropertyUtils
								.setNestedProperty(obj, "subSuccess", TopReportConstants.REPORT_IS_SUB_SUCCESS_YES);// 已成功上报过
						PropertyUtils.setNestedProperty(obj, "repStatus", TopReportConstants.REPORT_REPSTATUS_01);// 回执成功
					}
					remark = "总记录数：" + retSubFileInfo.getTotalrecords() + ",错误记录数:" + errRecords.size();
				}
				PropertyUtils.setNestedProperty(obj, "lstUpdTlr", tlrNo);
				PropertyUtils.setNestedProperty(obj, "lstUpdTm", new Date());
				rootDao.saveOrUpdate(obj);

				// 写入数据处理日志
				ReportCommonService.getInstance()
						.saveBiDataProcessLog(retSubFileInfo.getApptype(), retSubFileInfo.getCurrentfile(), recId,
								bussNo, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_LOADBACK,
								retSubFileInfo.getRepErrType(), remark);
			}
		}

	}

	public void updateSubFileInfoByFeedBack(ReportFeedBackBean bean, String errSign, String srcpath,
			String repPackName, String repTtFileName, ReportFeedBackCtrl reportFeedBackCtrl, String tlrNo)
			throws Exception {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		XmlBeanParser parser = new XmlBeanParser();
		// 1.查询包相关文件列表
		List list = rootDao.queryByQL2List(" from SubFileInfo model where model.apptype='" + bean.getAppType()
				+ "' and model.filePack='" + bean.getPackName() + "'");
		for (int i = 0; i < list.size(); i++) {
			SubFileInfo info = (SubFileInfo) list.get(i);
			String sendFileName = info.getId();// 上报文件名称
			// 计算回执文件名
			String tmpFileName = getRepFileNameBySendFileName(sendFileName, errSign);
			// TT接口控制文件
			info.setRepTm(new Date());
			info.setIsImpRep(ReportEnum.REPORT_IS.YES.value);

			// 控制文件
			SubFileConf confControl = ReportCommonService.getInstance().getSubFileConfByAppTypeByControl(bean.getBusiType(), bean.getAppType());
			if (confControl == null) {
				ExceptionUtil.throwCommonException(bean.getAppType() + "控制文件未设置!");
			}
			String controlFileTypeName = confControl.getId().getFileType();// 控制文件类型名称TT/T

			if (info.getCurrentfile().equals(controlFileTypeName)
					&& tmpFileName.equals(repTtFileName)) {
				info.setRepErrType(ReportEnum.REPORT_ERR_TYPE.NO_ERR.value);
				info.setRepFileName(repTtFileName);
				info.setFalrecords(reportFeedBackCtrl.getFiles().size());
				rootDao.saveOrUpdate(info);
			} else {
				List<String> repFileList = reportFeedBackCtrl.getFiles();
				if (repFileList.contains(tmpFileName)) {// 回执文件列表中包含错误文件信息
					// 1.读取文件写入错误
					String filepath = getFeedbackFilePath(srcpath, repPackName, tmpFileName);
					if (ReportUtils.isFileExist(filepath)) {
						parser.setBuffBeanId(ReportFeedBackInfo.ID);// 开始解析错误文件
						Object object = parser.convert2BeanByFile(filepath);
						ReportFeedBackInfo reportFeedBackInfo = (ReportFeedBackInfo) object;

						info.setRepFileName(tmpFileName);
						if (reportFeedBackInfo.getFormatErrs() > 0) {// 格式错误
							info.setRepErrType(ReportEnum.REPORT_ERR_TYPE.FORMAT_ERR.value);
							info.setSucrecords(0);
							info.setFalrecords(info.getTotalrecords());
							// 更新subFileInfo
							SubFileInfo retSubFileInfo = (SubFileInfo) rootDao.saveOrUpdate(info);
							updateBopDsStatus(retSubFileInfo, null, tlrNo);
						} else {
							if (!info.getTotalrecords().equals(reportFeedBackInfo.getTotalRecords())) {
								htlog.warn(info.getId() + "回执文件记录总数与数据库中记录总数不符！数据库记录数：" + info.getTotalrecords()
										+ ",回执记录总数:" + reportFeedBackInfo.getTotalRecords());
							}
							info.setRepErrType(ReportEnum.REPORT_ERR_TYPE.REC_ERR.value);
							info.setSucrecords(reportFeedBackInfo.getSucRecords());
							info.setFalrecords(reportFeedBackInfo.getFalRecords());

							// 更新subFileInfo
							SubFileInfo retSubFileInfo = (SubFileInfo) rootDao.saveOrUpdate(info);
							updateBopDsStatus(retSubFileInfo, reportFeedBackInfo.getErrRecords(), tlrNo);

						}
						// 写入错误信息表
						saveSubFileErr(tmpFileName, reportFeedBackInfo);

					} else {
						ExceptionUtil.throwCommonException("回执文件不存在!", tmpFileName);
					}
				} else {// 不包含错误文件信息<即全部成功>
					info.setRepErrType(ReportEnum.REPORT_ERR_TYPE.NO_ERR.value);
					info.setRepFileName(repTtFileName);// 回执文件名为TT文件
					info.setSucrecords(info.getTotalrecords());
					info.setFalrecords(0);
					// 更新subFileInfo
					SubFileInfo retSubFileInfo = (SubFileInfo) rootDao.saveOrUpdate(info);
					updateBopDsStatus(retSubFileInfo, null, tlrNo);
				}
			}
		}
	}

}
