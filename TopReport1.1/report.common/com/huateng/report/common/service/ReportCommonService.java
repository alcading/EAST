package com.huateng.report.common.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import resource.bean.pub.Bctl;
import resource.bean.pub.DataDic;
import resource.bean.report.BiBusiNoConf;
import resource.bean.report.BiBusiNoConfPK;
import resource.bean.report.BiDataProcessLog;
import resource.bean.report.BiExecConfirm;
import resource.bean.report.BiExecConfirmPK;
import resource.bean.report.BiProcessLog;
import resource.bean.report.BiQuartzJobLog;
import resource.bean.report.BiTlrFavt;
import resource.bean.report.NoticeParam;
import resource.bean.report.SubFileConf;
import resource.bean.report.SubFileConfPK;
import resource.bean.report.SysBusinavConf;
import resource.bean.report.SysParams;
import resource.bean.report.SysParamsPK;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.common.bean.UndoConfirmTaskBean;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.imports.bean.ReportFeedBackBean;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

public class ReportCommonService {
	private static final HtLog htlog = HtLogFactory.getLogger(ReportCommonService.class);

	protected ReportCommonService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static ReportCommonService getInstance() {
		return (ReportCommonService) ApplicationContextUtils.getBean(ReportCommonService.class.getName());
	}
	public DataDic getDataDic(int dataTypeNo,String dataNo) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = " from DataDic model where model.dataTypeNo=" + dataTypeNo+" and model.dataNo='" + dataNo.trim() + "'";
		List<DataDic> list = rootdao.queryByQL2List(hql);
		if (list.size()==1) {
			return list.get(0);
		}
		return null;
	}
		public List<DataDic> getDataDic(int dataTypeNo) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = " from DataDic model where model.dataTypeNo=" + dataTypeNo;
		List<DataDic> list = rootdao.queryByQL2List(hql);
		return list;
	}

	public List getConfList(String code) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List list = rootdao.queryByQL2List(" from SysBusinavConf model where model.parentCode='" + code
				+ "' order by model.showSeq");
		return list;
	}
	public List getConfList(String code,List codeList) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer result = new StringBuffer("from SysBusinavConf model where model.parentCode='" + code+"'");
		if (codeList!=null && codeList.size()>0) {
			result.append(" and model.id in "+ReportUtils.getStrCodes(codeList));
		}
		result.append("  order by model.showSeq");
		List list = rootdao.queryByQL2List(result.toString());
		return list;
	}

	public int getImportLogByWorkDate(String workDate) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.queryByHqlToCount("select count(model) from BiImportLog model where model.workDate='" + workDate
				+ "' and model.importStatus='1'");
	}

	public SysParams getSysparamsByPk(String groupId, String paramId) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return (SysParams) rootdao.query(SysParams.class, new SysParamsPK(groupId, paramId));
	}

	public SysBusinavConf getSysBusinavConf(String code) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return (SysBusinavConf) rootdao.query(SysBusinavConf.class, code.trim());
	}

	public List getDataAnaly(String busitype) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List list = rootdao.queryByQL2List(" from BiAnalyConf model where model.confVaild='"
				+ ReportEnum.REPORT_VAILD.YES.value + "' and model.busiType='" + busitype + "' order by model.confSeq");
		return list;
	}

	public List<DataDic> getBusinessByTypeNo() throws CommonException{
		List<DataDic> busiList = getDataDicList(ReportConstant.DATA_DIC_BUSI_TYPE_NO, null);
		return busiList;
	}
	/**
	 * 导出项目list
	 * */
	public String getProjectNamesToStr(String recId) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List projectList = rootdao.queryByQL2List(" from BopProjectInfo model where model.recId='"+recId.trim()+"'");
		return ReportUtils.getProjectNamesByList(projectList);
	}
	/**
	 * 导出债权人list
	 * */
	public String getBopCreditorsToStr(String recId) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List creditorsList = rootdao.queryByQL2List(" from BopCfaCreditorDs model where model.recId='"+recId.trim()+"'");
		return ReportUtils.getBopCreditorsByList(creditorsList);
	}
	/**
	 * 导出境外担保人list
	 * */
	public String getBopCfaFoguinfoToStr(String recId) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List foguinfoList = rootdao.queryByQL2List(" from BopCfaFogucodeinfo model where model.recId='"+recId.trim()+"'");
		return ReportUtils.getFogucodeinfoByList(foguinfoList);
	}
	/**
	 * 导出担保人list
	 * */

	public String getBopExguTorsToStr(String recId) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List exguTorList = rootdao.queryByQL2List(" from BopExguTorDs model where model.recId='"+recId.trim()+"' and torType = '03'");
		return ReportUtils.getBopExguTorDsByList(exguTorList);
	}
	/**
	 * 导出对外担保被担保人list
	 * */
	public String getBopExguTorGua(String recId) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List exguTorList = rootdao.queryByQL2List(" FROM BopExguTorDs model WHERE model.recId = '"+recId.trim()+"' AND torType = '01' ");
		return ReportUtils.getBopExguTorDsByList(exguTorList);
	}
	/**
	 * 导出对外担保受益人list
	 * */
	public String getBopExguTorBen(String recId) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List exguTorList = rootdao.queryByQL2List(" FROM BopExguTorDs model WHERE model.recId = '"+recId.trim()+"' AND torType = '02' ");
		return ReportUtils.getBopExguTorDsByList(exguTorList);
	}


	/**
	 * 导出外汇质押-签约信息 质押list
	 *
	 * */
	public String getConExplbalainfoToStr(String recId) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List explbaList = rootdao.queryByQL2List(" from BopCfaExplbalainfo model where model.recId='"+recId.trim()+"'");
		return ReportUtils.getConExplbalainfoByList(explbaList);
	}
	/**
	 * 导出外汇质押-变动信息 质押list
	 *
	 * */
	public String getChangExplbalainfoToStr(String recId) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List explbaList = rootdao.queryByQL2List(" from BopCfaExplbalainfo model where model.recId='"+recId.trim()+"'");
		return ReportUtils.getChangExplbalainfoByList(explbaList);
	}





	/**
	 * 从数据字典查询所有应用类型及文件类型
	 *
	 * @return
	 * @throws CommonException
	 */
	public Map<String, List<DataDic>> getAppAndFileTypeByDataDic(String busiType, String appType, String fileType)
			throws CommonException {
		Map<String, List<DataDic>> map = new LinkedHashMap<String, List<DataDic>>();
		List<DataDic> busiList = getDataDicList(ReportConstant.DATA_DIC_BUSI_TYPE_NO, busiType);
		if (busiList.size() == 1) {
			int typeNo = Integer.parseInt(busiList.get(0).getMiscflgs().trim());
			List<DataDic> list = getDataDicList(typeNo, appType);
			for (int i = 0; i < list.size(); i++) {
				DataDic dd = list.get(i);
				String mf = dd.getMiscflgs();
				if (mf != null && mf.trim().length() > 0) {
					List<DataDic> fileList = getDataDicList(Integer.parseInt(mf.trim()), fileType);
					map.put(dd.getDataNo().trim(), fileList);
				}
			}
		}
		return map;
	}

	public String getAppAndFileNameByType(String appType, String fileType) throws CommonException {
		StringBuffer name = new StringBuffer(appType + "-" + fileType);
		List<DataDic> busiList = getDataDicList(ReportConstant.DATA_DIC_BUSI_TYPE_NO,
				TopReportConstants.REPORT_BUSITYPE_BOP);
		if (busiList.size() == 1) {
			int typeNo = Integer.parseInt(busiList.get(0).getMiscflgs().trim());
			List<DataDic> list = getDataDicList(typeNo, appType);
			if (list.size() == 1) {
				DataDic dd = list.get(0);
				name.append(" 【" + dd.getDataName());
				String mf = dd.getMiscflgs();
				if (mf != null && mf.trim().length() > 0) {
					if (fileType.equals(TopReportConstants.REPORT_FILE_TYPE_ACC_TT)) {
						name.append("-接口控制文件】");
					} else {
						List<DataDic> fileList = getDataDicList(Integer.parseInt(mf.trim()), fileType);
						if (fileList.size() == 1) {
							DataDic fd = fileList.get(0);
							name.append("-" + fd.getDataName() + "】");
						}
					}
				}
			}
		}
		return name.toString();
	}

	public List<DataDic> getDataDicList(int typeNo, String dataNo) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = " from DataDic model where model.dataTypeNo=" + typeNo;
		if (dataNo != null && dataNo.trim().length() > 0) {
			hql += " and model.dataNo='" + dataNo.trim() + "'";
		}
		hql += " order by model.dataNo";
		List<DataDic> list = rootdao.queryByQL2List(hql);
		return list;
	}

	public String getAppTypeName(String appType) throws CommonException {
		List<DataDic> diclist = getDataDicList(ReportConstant.DATA_DIC_BOP_APP_TYPE_NO, appType);
		String appTypeName = appType;
		if (diclist.size()==1) {
			appTypeName = diclist.get(0).getDataName();
		}
		return appTypeName;
	}

	/**
	 * 保存定时任务执行日志
	 * @param startTm
	 * @param endTm
	 * @param quartId
	 * @param result
	 * @param jobName
	 * @param remarak
	 * @throws CommonException
	 */
	public void saveJobLog(Date startTm,Date endTm,String quartId,String result,String jobName,String remark) {
		BiQuartzJobLog joblog = new BiQuartzJobLog();
		joblog.setId(ReportUtils.getUUID());
		joblog.setExecTm(startTm);
		joblog.setEndTm(endTm==null?new Date():endTm);
		joblog.setQuartzId(quartId);
		joblog.setQuartzResult(result);
		joblog.setQuartzName(jobName);
		joblog.setRemark(remark);

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		try {
			rootdao.save(joblog);
		} catch (CommonException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 流程操作记录保存
	 *
	 * @param workDate
	 *            工作日期
	 * @param busiType
	 *            业务类型 如 BOP 01:TopReportConstants.REPORT_BUSITYPE_BOP
	 * @param appType
	 *            应用类型 如BOP，JSH，ACC，CFA
	 * @param brNo
	 *            机构号
	 * @param executeType
	 *            执行类型 如 导入 01:TopReportConstants.REPORT_PROCESS_EXECTYPE_IMP
	 * @param startTm
	 *            开始时间
	 * @param endTm
	 *            结束时间
	 * @param operType
	 *            操作类型 如 手动 01:TopReportConstants.REPORT_PROCESS_OPERTYPE_MANU
	 * @throws CommonException
	 */
	public void saveBiProcessLog(String workDate, String busiType, String appType, String brNo, String executeType, Date startTm,
			Date endTm, String operType) throws CommonException {

		GlobalInfo gi = GlobalInfo.getCurrentInstance();

		BiProcessLog biProcessLog = new BiProcessLog();
		biProcessLog.setBrNo(gi.getBrno());
		biProcessLog.setBusiType(busiType);
		biProcessLog.setEndTm(endTm);
		biProcessLog.setExecuteId(gi.getTlrno());
		biProcessLog.setExecuteTm(new Date());
		biProcessLog.setExecuteType(executeType);
		biProcessLog.setId(ReportUtils.getUUID());
		biProcessLog.setOperType(operType);
		biProcessLog.setStartTm(startTm);
		biProcessLog.setWorkDate(workDate);
		biProcessLog.setIp(gi.getIp());

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		rootdao.save(biProcessLog);
	}

	/**
	 * 数据处理记录表保存
	 *
	 * @param appType
	 *            应用类型 如 外汇账户 ACC: TopReportConstants.REPORT_APP_TYPE_ACC
	 * @param currentFile
	 *            文件类型 如 CA 账户开关户信息 CB 账户收支余信息 等
	 * @param recId
	 *            记录主键
	 * @param busiNo
	 *            业务编号
	 * @param execType
	 *            执行类型 如 00-删除
	 *            TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL
	 * @param execResult
	 *            执行结果
	 * @param execRemark
	 *            执行说明
	 * @throws CommonException
	 */
	public void saveBiDataProcessLog(String appType, String currentFile, String recId, String busiNo, String execType,
			String execResult, String execRemark) throws CommonException {

		GlobalInfo gi = GlobalInfo.getCurrentInstance();

		BiDataProcessLog biDataProcessLog = new BiDataProcessLog();
		biDataProcessLog.setApptype(appType);
		biDataProcessLog.setBusiNo(busiNo);
		biDataProcessLog.setCurrentfile(currentFile);
		biDataProcessLog.setExecRemark(execRemark);
		biDataProcessLog.setExecResult(execResult);
		biDataProcessLog.setExecTlr(gi.getTlrno());
		biDataProcessLog.setExecTm(new Date());
		biDataProcessLog.setExecType(execType);
		biDataProcessLog.setId(ReportUtils.getUUID());
		biDataProcessLog.setRecId(recId);

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		rootdao.save(biDataProcessLog);
	}

	public BiBusiNoConf getBiBusiNoConfByPk(String busiType, String appType, String fileType) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.query(BiBusiNoConf.class, new BiBusiNoConfPK(appType, fileType, busiType));
	}

	public SubFileConf getSubFileConfByPk(String busiType, String appType, String fileType) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.query(SubFileConf.class, new SubFileConfPK(fileType, busiType, appType));
	}

	public List getSubFileConfByAppType(String busiType, String appType) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List list = rootdao.queryByQL2List(" from SubFileConf model where model.id.busiType='" + busiType
				+ "' and model.id.appType='" + appType + "' order by execSeq");
		return list;
	}

	public SubFileConf getSubFileConfByAppTypeByControl(String busiType, String appType) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List list = rootdao.queryByQL2List(" from SubFileConf model where model.id.busiType='" + busiType
				+ "' and model.id.appType='" + appType + "' and model.confIsControl='"+ReportEnum.REPORT_IS_STR.YES.value+"'");
		if (list.size()==1) {
			return (SubFileConf) list.get(0);
		}
		return null;
	}
	/**
	 * 首页回执信息
	 * @return
	 * @throws CommonException
	 */
	public List<ReportFeedBackBean> getRepBackInfo() throws CommonException{
		/*return FileImportService.getInstance().getFeedbackImportByPack(DateUtil.dateToNumber(DateUtil.getTbsDay()),
				DateUtil.dateToNumber(DateUtil.getTbsDay()), null, null, null);*/
		return null;
	}

	/**
	 * 首页补录审核进度
	 * @return
	 * @throws CommonException
	 */
	public List<BiExecConfirm> getAllBrNoBiExecConfirm() throws CommonException{
		Map<String, List<BiExecConfirm>> map = new HashMap<String, List<BiExecConfirm>>();
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		List<Bctl> bctls = BctlService.getInstance().getAllEnableBctl();
		List<String> brNoList = new ArrayList<String>();
		Map<String, String> brNameMap = new HashMap<String, String>();
		for(Bctl bc : bctls){
			brNoList.add(bc.getBrno());
			brNameMap.put(bc.getBrno(), bc.getBrname());

		}

		List<String> busiTypsList = new ArrayList<String>();
		List<DataDic> busiTyps = this.getDataDic(ReportConstant.DATA_DIC_BUSI_TYPE_NO);
		for(DataDic dd : busiTyps){
			busiTypsList.add(dd.getDataNo());
		}

		String hql = " from BiExecConfirm model where model.id.busiType in" + ReportUtils.toInString(busiTypsList)+ " and model.id.workDate='" + DateUtil.dateToNumber(DateUtil.getTbsDay())
				+ "' and model.id.brNo in" + ReportUtils.toInString(brNoList) + " order by model.id.brNo";
		List<BiExecConfirm> list = rootDao.queryByQL2List(hql);
		for(BiExecConfirm bec : list){
			String key = bec.getId().getBusiType()+"|"+bec.getId().getBrNo();
			if(map.containsKey(key)){
				List<BiExecConfirm> tempList = map.get(key);
				tempList.add(bec);
			} else {
				List<BiExecConfirm> tempList = new ArrayList<BiExecConfirm>();
				tempList.add(bec);
				map.put(key, tempList);
			}
		}

		List<BiExecConfirm> resList = new ArrayList<BiExecConfirm>();
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			boolean flag = true;
			List<BiExecConfirm> tempList = map.get(key);
			for(BiExecConfirm ec : tempList){
				if(!ec.getConfirmStatus().equals("01") || !ec.getSubfileStatus().equals("01")){
					flag = false;
					break;
				}
			}
			BiExecConfirm confirm = tempList.get(0);

			BiExecConfirm biExecConfirm = new BiExecConfirm();
			BiExecConfirmPK pk = new BiExecConfirmPK();
			pk.setBrNo(confirm.getId().getBrNo());
			pk.setBusiType(confirm.getId().getBusiType());
			pk.setWorkDate(confirm.getId().getWorkDate());
			biExecConfirm.setId(pk);
			biExecConfirm.setBrNoName(brNameMap.get(pk.getBrNo()));
			if(flag){
				biExecConfirm.setFinishStatus("01");
			} else {
				biExecConfirm.setFinishStatus("02");
			}
			resList.add(biExecConfirm);
		}

		return resList;
	}

	public boolean isAllOrgFinished() throws CommonException{
		List<BiExecConfirm> list = this.getAllBrNoBiExecConfirm();
		boolean flag = true;
		for (BiExecConfirm biExecConfirm : list) {
			if(biExecConfirm.getFinishStatus().equals("02")){
				flag = false;
				break;
			}
		}
		return flag;

	}

	/**
	 * 首页主管确认信息
	 * @return
	 * @throws CommonException
	 */
	public List<UndoConfirmTaskBean> getUndoConfirmTask(HttpSession httpSession) throws CommonException{
		GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
		GlobalInfo.setCurrentInstance(globalInfo);
		List confrimCodeList = globalInfo.getConfrimCodeList();
		List<UndoConfirmTaskBean> list = new ArrayList<UndoConfirmTaskBean>();
		if (confrimCodeList!=null && confrimCodeList.size()>0) {
			String codes = ReportUtils.getConfrimCodes(confrimCodeList);
			ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
			String hql = "select new com.huateng.report.common.bean.UndoConfirmTaskBean(dd.intInsId,count(dd)) from SysTaskInfo dd where dd.intInsId in "+codes+" group by dd.intInsId";
			list = rootDao.queryByQL2List(hql);
			List<DataDic> dds = getDataDicList(300001, null);
			Map<String, String> ddMap = new HashMap<String, String>();
			for (DataDic dd : dds) {
				ddMap.put(dd.getDataNo(), dd.getDataName());
			}
			for(UndoConfirmTaskBean bean : list){
				bean.setIntInsIdName(ddMap.get(bean.getIntInsId()));
			}
		}
		return list;
	}


	public List getFunctionInfoListByFavt(HttpSession httpSession) throws CommonException{
		GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
		GlobalInfo.setCurrentInstance(globalInfo);
		Map funmap = globalInfo.getAllFunctions();
		List funcList = new ArrayList();
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		List favtList = dao.queryByQL2List(" from BiTlrFavt model where model.tlrNo='"+globalInfo.getTlrno()+"' and model.funcType='"+globalInfo.getMenuCode()+"' order by model.showSeq");
		for (int i = 0; i < favtList.size(); i++) {
			BiTlrFavt favt = (BiTlrFavt) favtList.get(i);
			if(funmap.containsKey(favt.getFuncId().trim())){
				funcList.add(funmap.get(favt.getFuncId().trim()));
			}
		}
		return funcList;
	}

	public void saveOrUpdateFavt(String tlrNo,String funcType,List<String> funcId) throws CommonException{
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		List oldList = dao.queryByQL2List(" from BiTlrFavt model where model.tlrNo='"+tlrNo+"' and model.funcType='"+funcType+"'");
		if (oldList!=null) {
			for (int i = 0; i < oldList.size(); i++) {
				dao.delete(oldList.get(i));
			}
		}
		for (int i = 0; i < funcId.size(); i++) {
			BiTlrFavt ft = new BiTlrFavt();
			ft.setId(ReportUtils.getUUID());
			ft.setFuncId(funcId.get(i).trim());
			ft.setTlrNo(tlrNo);
			ft.setShowSeq(i);
			ft.setFuncType(funcType);
			dao.saveOrUpdate(ft);
		}

	}

	/**
	 * 校验当前时间是否为工作日期
	 * @param date
	 * @return
	 * @throws CommonException
	 */
	public boolean checkWorkDate(Date date) throws CommonException {
		boolean bl = false;
		String hql = "select count(model) from BiWorkdate model where model.id='" + DateUtil.dateToNumber(date) + "' and model.workFlag='1'";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if (rootdao.queryByHqlToCount(hql) > 0) {
			bl = true;
		}
		return bl;
	}

	/**
	 * 首页显示定时任务日志
	 * @return
	 * @throws CommonException
	 */
	public List<BiQuartzJobLog> getQuartzJobLog() throws CommonException{
		StringBuffer hql = new StringBuffer("select model from BiQuartzJobLog model where model.execTm>=? and model.execTm<=? order by model.execTm desc");
		List<Object> objlist = new ArrayList<Object>();
		String curDateStr = DateUtil.dateToNumber(new Date());
		objlist.add(DateUtil.getStartDateByDays(DateUtil.stringToDate2(curDateStr), +1));
		objlist.add(DateUtil.getStartDateByDays(DateUtil.stringToDate2(curDateStr), -1));
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.queryByQL2List(hql.toString(), objlist.toArray(), null);
	}
	public List getReportBopJshList() throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List list = rootdao.queryByQL2List(" from BiBopjshRetNo");
		return list;
	}

	/**
	 * 业绩标准
	 * @return
	 * @throws CommonException
	 */
	public List<NoticeParam> getNoticeParam() throws CommonException{
		StringBuffer hql = new StringBuffer("select model from NoticeParam model where 1=1 order by model.createdt ");
		List<Object> objlist = new ArrayList<Object>();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<NoticeParam> abc= rootdao.queryByQL2List(hql.toString(), objlist.toArray(), null);
		for(NoticeParam bean : abc){
			bean.setNoticeFlg(bean.getNoticeFlg().equals("1") ? "有效" :"无效");
			bean.setNoticeAmt(bean.getNoticeAmt()==null? new BigDecimal(0) :bean.getNoticeAmt());
		}
		return abc;
	}

	public List getFunctionNavList(String parentCode) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List list = rootdao.queryByQL2List(" from FunctionInfo model where model.lastdirectory='"+parentCode+"' order by model.showseq");
		return list;
	}

	public int getFunctionCountByTlrNo(String tlrNo,String parentCode) throws CommonException{

		String funcIds = ReportUtils.getConfrimCodes(getFunctionNavList(parentCode));

		StringBuffer hql = new StringBuffer();
		hql.append("select count(rr) from TlrRoleRel tr,RoleFuncRel rr");
		hql.append(" where tr.roleId=rr.roleId ");
		hql.append("and tr.tlrno='").append(tlrNo).append("'");
		if(funcIds!=null&&!"()".equals(funcIds)){
			hql.append("and rr.funcid in "+funcIds);
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.queryByHqlToCount(hql.toString());
	}

}
