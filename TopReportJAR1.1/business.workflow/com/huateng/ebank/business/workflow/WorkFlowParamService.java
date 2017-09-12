/**
 *
 */
package com.huateng.ebank.business.workflow;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import resource.bean.pub.Bctl;
import resource.bean.pub.RoleInfo;
import resource.bean.pub.TlrInfo;
import resource.dao.base.HQLDAO;
import resource.dao.pub.BrhWorkFlowDefDAO;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.CommonFunctions;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.taskassign.TaskAssignService;
import com.huateng.ebank.business.workflow.bean.WorkFlowAssignedOprBean;
import com.huateng.ebank.business.workflow.bean.WorkflowParamBean;
import com.huateng.ebank.entity.dao.workflow.WorkflowAppInfoDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowInsRouteDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowParamDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowRouteBindingDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowTaskInfoDAO;
import com.huateng.ebank.entity.data.workflow.BrhWorkflowDef;
import com.huateng.ebank.entity.data.workflow.LimitParam;
import com.huateng.ebank.entity.data.workflow.WorkflowAppInfo;
import com.huateng.ebank.entity.data.workflow.WorkflowInsRoute;
import com.huateng.ebank.entity.data.workflow.WorkflowParam;
import com.huateng.ebank.entity.data.workflow.WorkflowRouteBinding;
import com.huateng.ebank.entity.data.workflow.WorkflowRouteParam;
import com.huateng.ebank.entity.data.workflow.WorkflowTaskInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.topbpm.TopBPMConfiguration;
import com.huateng.topbpm.TopBPMContext;
import com.huateng.topbpm.graph.def.Node;
import com.huateng.topbpm.graph.def.ProcessDefinition;

/**
 * Title: WorkFlowParamService Description:
 * 工作流参数配置查询服务:负责处理查询工作流符合参数要求和任务分配（节点是否处理问题） Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author chen_maik
 * @version 1.1, 2008-8-07
 */
public class WorkFlowParamService {


	public static final String BRCODE_TYPE_OFF = "0";// 0- 不指定到机构，根据上下级关系。

	public static final String BRCODE_TYPE_ON = "1"; // 1- 指定机构

	public static final String ASSIGN_TYPE_OFF = "0"; // 0- 指定到操作员列表

	public static final String ASSIGN_TYPE_ON = "1";// 1- 指定到岗位

	public static final String ASSIGN_TYPE_TWO = "2"; // 2-指定客户经理

	public static final String ASSIGN_TYPE_THREE = "3"; // 3-指定到发起人

	public static final String AMT_TYPE_OFF = "0"; // 0-按金额权限

	public static final String AMT_TYPE_ON = "1"; // 1-不按金额权限

	public static final String ASSIGN_MODE_ZERO = "0";// -抢件模式

	public static final String ASSIGN_MODE_PEPOLE = "1";// 1-分配到人(按工作两分配)

	public static final String ASSIGN_MODE_RAMDOM = "2"; // 2-完全随机分配

	public static final String BIZ_SUB_CLASS_TYPE = "000"; // 000表示其他 贷款品种类型

	public static final String BRCODE_TYPE_AUTO = "0";
	public static final String BRCODE_TYPE_ASSIGN = "1";
	public static final String ASSIGN_TYPE_TOLIST = "0";
	public static final String ASSIGN_TYPE_TOROLE = "1";
	public static final String BRCLASS_BRANCH = "1";
	public static final String BRCLASS_SUBBRANCH = "2";
	public static final String BRCLASS_BLNBRANCH = "3";
	public static final String BRCLASS_LOANCENTER = "4";

	/** memeber variable: Log log. */
	private static Log log = LogFactory.getLog(WorkFlowParamService.class);

	/** memeber variable: WorkFlowService single. */
	private static WorkFlowParamService single;

	/**
	 * Default constructor
	 */
	protected WorkFlowParamService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static WorkFlowParamService getInstance() {
  		if (null == single) {
			single = new WorkFlowParamService();
		}
		return single;
	}

	/**
	 * 工作流层次调用
	 *
	 * @param hashMap
	 * @title 传入的参数为Map,KEY值如下： APPNO ????申请编号 CUSTCD ????客户号(内部) CONTRACTNO
	 *        ????合同号(可能为借据号、项目编号) AMT ????贷款金额 APPTYPE ????申请类型（apptype） PROC_NAME
	 *        ????工作流模板（PROCESS_TEMPLATE） TASK_NAME ????下一任务名（TaskName） LAST_TLRNO
	 *        ????上一操作员（TLRNO） BRCLASS ????机构级别 BRCODE ????归属操作机构 BIZCLASS 审批类型
	 *        BIZ_SUBCLASS ????贷款品种类型
	 *
	 * @return
	 * @throws CommonException
	 */
	public Map getTlrnoRoleTaskOperate(Map hashMap) throws CommonException {
		Map hMap = new HashMap();

		// 参数配置表属性定义
		String apptype = DataFormat.trim((String) hashMap.get("APPTYPE")); // 申请类型（apptype）
		String processTemplate = DataFormat.trim((String) hashMap
				.get("PROC_NAME"));
		String taskName = DataFormat.trim((String) hashMap.get("TASK_NAME"));
		String brclass = DataFormat.trim((String) hashMap.get("BRCLASS"));// BRCLASS
		// ????机构级别
		String brcode = DataFormat.trim((String) hashMap.get("STARTBRCODE"));// 上传机构
		String bizClass = DataFormat.trim((String) hashMap.get("BIZCLASS"));// BIZCLASS
		// 审批类型
		String bizSubClass = DataFormat.trim((String) hashMap
				.get("BIZSUBCLASS"));
		String lastTlrno = DataFormat.trim((String) hashMap.get("LASTTLRNO"));// 上一操作员

		double amt = ((Double) hashMap.get("AMOUNT")).doubleValue();


		// 客户经理
		String mrgno = DataFormat.trim((String) hashMap.get("MGRNO"));

		// 发起人
		String starter = DataFormat.trim((String) hashMap.get("STARTER"));

		String brcode_type = ""; // 机构指定标志
		String brcode_list = "";// 指定的机构号列表
		String assign_type = "";// 任务分配原则
		String tlrno_list = "";// 操作员列表
		String role_type = "";// 岗位类型
		String amt_type = ""; // 金额策略
		String assign_mode = "";// 工作分配模式
		String pass = "";// 任务结点是否操作标志
		// 中间存放属性定义
		String brcodeList = ""; // 机构号存放List ，以“，”区分
		String tlrnoList = ""; // 操作员列表存放List，以“，”区分
		String bln_up_brcode = ""; // 归属上级行 管理机构关系（递归向上）

		List listwfp = new ArrayList();
		listwfp = BaseDAOUtils.getWorkflowParamDAO().queryByCondition(
				"po.processTemplate='" + processTemplate.trim()
						+ "' and po.taskName='" + taskName + "' "
						+ " and po.apptype='" + apptype + "' and po.brclass='"
						+ brclass + "' and po.bizClass='" + bizClass
						+ "' and po.bizSubclass='" + bizSubClass + "' ");
		// LIST SIZE= 0 000表示其他 贷款品种类型
		if (listwfp.size() == 0 || listwfp == null) {
			listwfp = BaseDAOUtils.getWorkflowParamDAO().queryByCondition(
					"po.processTemplate='" + processTemplate.trim()
							+ "' and po.taskName='" + taskName + "' "
							+ " and po.apptype='" + apptype
							+ "' and po.brclass='" + brclass
							+ "' and po.bizClass='" + bizClass
							+ "' and po.bizSubclass='" + BIZ_SUB_CLASS_TYPE
							+ "' ");
		}
		WorkflowParam wfp = (WorkflowParam) listwfp.get(0);
		brcode_type = DataFormat.trim(wfp.getBrcodeType());
		brcode_list = DataFormat.trim(wfp.getBrcodeList());
		assign_type = DataFormat.trim(wfp.getAssignType());
		tlrno_list = DataFormat.trim(wfp.getTlrnoList());
		role_type = DataFormat.trim(wfp.getWorkflowRole());
		amt_type = DataFormat.trim(wfp.getAmtType());
		assign_mode = DataFormat.trim(wfp.getAssignMode());
		pass = DataFormat.trim(wfp.getPass());

		// hashMap.put("ROLE_TYPE", role_type);

		if(WorkFlowConstants.ROLE_ID_LOAN_AUDIT==Integer.parseInt(role_type)){
			brcodeList = brcode;
		}

		// 机构指定标志
		if (brcode_type.equals(BRCODE_TYPE_OFF)) {// 0-
			// 不指定到机构，根据上下级关系。递归查询归属上级行
			//modified by jornezhang 去掉机构的影响
			//机构间已经只有归属总行的归属关系了 现在机构的归属关系对流程没有用了
			/*BctlService bctlService = BctlService.getInstance();

			if(WorkFlowConstants.ROLE_ID_LOAN_AUDIT==Integer.parseInt(role_type)){
				brcodeList = brcode;
			}else{
				brcodeList = bctlService.getUpBrcode(brclass, brcode);
			}*/

		} else {
			if (brcode_type.equals(BRCODE_TYPE_ON)) {// 1- 指定机构
				brcodeList = brcode_list; // 只有在BRCODE_TYPE为1时有效，存放以逗号分割的内部机构号
			}
		}

		// 任务分配原则
		if (assign_type.equals(ASSIGN_TYPE_OFF)) { // 0- 指定到操作员列表

			tlrnoList = this.getOnlyTlrno(tlrno_list);
		} else {
			if (assign_type.equals(ASSIGN_TYPE_ON)) { // 1- 指定到岗位
				List listRoleInfo = new ArrayList();
				listRoleInfo = BaseDAOUtils.getRoleInfoDAO().queryByCondition(
						"po.id='" + role_type + "'");
				String[] strRoleId = new String[listRoleInfo.size()];// 所有的对应的ROLE_ID(岗位编号)――存放到一个对应的数组
				for (int i = 0; i < listRoleInfo.size(); i++) {
					int roleid = ((RoleInfo) listRoleInfo.get(i)).getId();
					strRoleId[i] = String.valueOf(roleid);
				}
				//String[] brcodeArry = brcodeList.split(",");
				StringBuffer buffer = new StringBuffer();
				for (int m = 0; m < strRoleId.length; m++) {
					String roleStrid = strRoleId[m]; // 岗位编号
					//for (int n = 0; n < brcodeArry.length; n++) {
					//	String brcodeStr = brcodeArry[n].trim(); // 机构号
					StringBuffer hql = new StringBuffer();
					List tlrRoleList = new ArrayList();
					hql.append("select tlr.tlrno,tlr.brcode from TlrInfo as tlr,TlrRoleRel as rela where tlr.tlrno=rela.tlrno and rela.roleId=").append(roleStrid);
					if(!DataFormat.isEmpty(brcodeList)){
						hql.append(" and tlr.brcode in(").append(brcodeList).append(") ");
					}
					Iterator it = BaseDAOUtils.getHQLDAO().queryByQL(hql.toString());
					while (it.hasNext()) {
						Object[] result = (Object[]) it.next();
						if (tlrnoList.equals("")) {
							tlrnoList = ((String) result[0]).trim();
						} else
							tlrnoList = tlrnoList + ","
									+ ((String) result[0]).trim();
					}
						// tlrnoList = this.getOnlyTlrno(buffer.toString());//
						// tlrno 可能有重复，要过滤
					//}
				}
				tlrnoList = this.getOnlyTlrno(tlrnoList);
				// 可能有重复，要过滤
			}

			if (assign_type.equals(ASSIGN_TYPE_TWO)) {// 2-指定到客户经理
				tlrnoList = mrgno;
			}
			if (assign_type.equals(ASSIGN_TYPE_THREE)) {// 3-指定到发起人
				tlrnoList = starter;
			}
		}

		// 金额策略AMTTYPE
		if (amt_type.equals(AMT_TYPE_ON)) {// 1-不按金额权限
			tlrnoList = this.getOnlyTlrno(tlrnoList);
		} else {
			if (amt_type.equals(AMT_TYPE_OFF)) {// 0-按金额权限
				String[] tlrnoListArray = tlrnoList.split(",");// 操作人员数组
				String tlrnoListTemp = tlrnoList;
				String listTlrno = "";
				//1、处理对应的操作员  ---有贷款品种权限的操作
				for (int i = 0; i < tlrnoListArray.length; i++) {
					List tlrList = new ArrayList();
					tlrList = BaseDAOUtils
							.getLimitParamDAO()
							.queryByCondition(
									"po.tlrno='"
											+ tlrnoListArray[i]
											+ "' and po.status='1' and po.bizClass='"
											+ bizClass
											+ "' and po.bizSubclass='"
											+ bizSubClass
											+ "'  and (po.limitMaxamount>=" + amt
											+ " and po.limitMinamount<=" + amt
											+ ")");

					if (tlrList.size() > 0) {
						for (int j = 0; j < tlrList.size(); j++) {
							LimitParam lmtp = (LimitParam) tlrList.get(j);
							if (i == 0 && j == 0) {
								listTlrno = DataFormat.trim(lmtp.getTlrno());
							} else {
								listTlrno =listTlrno+ ","
										+ DataFormat.trim(lmtp.getTlrno());
							}
						}
					}
				}

				//2、用于操作员 审批贷款不限"000"的情况处理
				if(listTlrno.length()==0){
			    	for (int i = 0; i < tlrnoListArray.length; i++) {
					List tlrList = new ArrayList();
						tlrList = BaseDAOUtils
								.getLimitParamDAO()
								.queryByCondition(
										"po.tlrno='"
												+ tlrnoListArray[i]
												+ "' and po.status='1' and po.bizClass='"
												+ bizClass
												+ "' and (po.bizSubclass='000' or po.bizSubclass='0') and (po.limitMaxamount>="
												+ amt + " and po.limitMinamount<="
												+ amt + ")");

					if (tlrList.size() > 0) {
						for (int j = 0; j < tlrList.size(); j++) {
							LimitParam lmtp = (LimitParam) tlrList.get(j);
							if (i == 0 && j == 0) {
								listTlrno = DataFormat.trim(lmtp.getTlrno());
							} else {
								listTlrno =listTlrno+ ","
										+ DataFormat.trim(lmtp.getTlrno());
							}
						}
					}
				}

				}

				if (listTlrno.length() == 0) {//3、 查询结果TLRNO_LIST（上处理结果为空）为空,上述没有查询结果时
					List brList = new ArrayList();
					String listBrcode = "";
					brList = new ArrayList();
//					BaseDAOUtils
//							.getBrhLimitParamDAO()
//							.queryByCondition(
//									"po.bizClass='"
//											+ bizClass
//											+ "'"
//											+ " and (po.bizSubclass='"
//											+ bizSubClass
//											+ "' or po.bizSubclass='000') and po.limitMaxamount >="
//											+ amt);
					if (brList == null || brList.size() == 0) {
						String[] brcodeArray = brcodeList.split(",");
						// 在机构业务参数表brhlimit_param都没配置情况下，让流程继续操作，
						tlrnoList = this.getOnlyTlrno(this.doNotlrnoAmtList(
								tlrnoListTemp, bizClass, bizSubClass, amt));

					}
//					else {
//						for (int i = 0; i < brList.size(); i++) {
//							BrhLimitParam lmtp = (BrhLimitParam) brList.get(i);
//							if (i == 0) {
//								listBrcode = DataFormat.trim(lmtp.getBrcode());
//							} else {
//								listBrcode = ","
//										+ DataFormat.trim(lmtp.getBrcode());
//							}
//						}
//						String[] brcodeArray = listBrcode.split(",");
//						StringBuffer buffer = new StringBuffer();
//						for (int i = 0; i < brcodeArray.length; i++) {
//							List tlrRoleList1 = new ArrayList();
//							tlrRoleList1 = BaseDAOUtils.getTlrRoleRelationDAO()
//									.queryByCondition(
//											"po.brcode='" + brcodeArray[i]
//													+ "'");
//							if (tlrRoleList1.size() > 0) {
//								for (int m = 0; m < tlrRoleList1.size(); m++) {
//									TlrRoleRelation trlRoleRelation = (TlrRoleRelation) tlrRoleList1
//											.get(m);
//									String tlrnoi = trlRoleRelation.getTlrno();
//
//									if (i == 0 && m == 0) {
//										buffer.append(tlrnoi);
//									} else {
//										buffer.append(",").append(tlrnoi);
//									}
//								}
//							}
//
//						}
//						tlrnoList = this.getOnlyTlrno(buffer.toString());
//					}
				} else {
					tlrnoList = this.getOnlyTlrno(listTlrno);
				}

			}
		}

		// 工作分配模式
		// if (assign_mode.equals(ASSIGN_MODE_PEPOLE)) {// 1-分配到人(按工作量分配)
		//
		// List<String> listList = new ArrayList<String>();
		// listList.add(tlrnoList);
		// TaskAssignService taskAssignService = TaskAssignService
		// .getInstance();// .getAssignToTlrno();
		// hMap.put("TLRNO_LIST", taskAssignService.getAssignToTlrno(listList,
		// "01", "1", false, false));
		// hMap.put("PASS", pass);
		// // this.initInsertWorkFlowTaskInfo(hashMap);
		// return hMap;
		// } else {
		String tlrnoListTmp = getNotIncludeLastTlrno(tlrnoList, lastTlrno);
		if (tlrnoListTmp.trim().length() == 0)
			tlrnoListTmp = WorkFlowConstants.ROLE_DEFINFE_TLRNO;

		GlobalInfo glbinfo=GlobalInfo.getCurrentInstance();
//		glbinfo.setWorkflowTlrno("");
//		if(glbinfo.getWorkflowTlrno().length()==0||glbinfo.getWorkflowTlrno().equals("")){
//			glbinfo.setWorkflowTlrno(tlrnoListTmp);
//		}
		hMap.put("TLRNO_LIST", tlrnoListTmp);// 过滤上一操作员;
		hMap.put("PASS", pass);
		//默认审批意见
//		String attitudeno = DataFormat.trim(wfp.getPass());
//		String attitude = WorkflowStatusMap.getStatus(attitudeno);
//		hMap.put("ATTITUDE", attitude);
		// this.initInsertWorkFlowTaskInfo(hashMap);
		return hMap;
		// }

	}

	// ==================================================================================================================
	/**
	 * 应用层次调用
	 *
	 * @param hashMap
	 * @title Map 的KEY值如下：
	 * @see PROCESS_TEMPLATE(工作流模板名)
	 * @see TASK_NAME（任务名）
	 * @see APP_TYPE(申请类型)
	 * @see TLR_NO(操作员)
	 * @see AMT(贷款金额)
	 */

	public String getAttitude(Map hashMap) throws CommonException {
		String processTemplate = DataFormat.trim((String) hashMap
				.get("PROC_NAME"));
		String taskName = DataFormat.trim((String) hashMap.get("TASK_NAME"));
		String appType = DataFormat.trim((String) hashMap.get("APPTYPE")); // 申请类型
		String trlNo = DataFormat.trim((String) hashMap.get("TLR_NO"));
		String bizClass = DataFormat.trim((String) hashMap.get("BIZ_CLASS"));// 审批类型1-贷款业务，2-合作项目
		String bizSubClass = DataFormat.trim((String) hashMap
				.get("BIZ_SUBCLASS"));// 贷款大类 合作项目类型 000表示不限

		double amt = Double.valueOf(
				DataFormat.trim((String) hashMap.get("AMT"))).doubleValue();

		List wfaList = new ArrayList();
		wfaList = BaseDAOUtils.getWorkflowAttitudeDAO().queryByCondition(
				"po.processTemplate='" + processTemplate
						+ "' and po.taskName='" + taskName
						+ "' and po.apptype='" + appType + "'");
//		if (wfaList.size() == 1) {
//			WorkflowAttitude wfa = (WorkflowAttitude) wfaList.get(0);
//			if (wfa.getOverFlag().equals("0")) {// 0-不限，用于审查任务，无须判断超限
//				return DataFormat.trim(wfa.getAttitudelist());
//			} else {
//				ExceptionUtil.throwCommonException(
//						"工作流审批意见参数表OVERFLAG设置错误，因设置为0，用于审查任务",
//						ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
//				return "";
//			}
//		} else {
//			if (wfaList.size() > 1) {
//				List limitList = new ArrayList();
//				limitList = BaseDAOUtils.getLimitParamDAO().queryByCondition(
//						"po.tlrno='" + trlNo
//								+ "' and po.status='1' and po.bizClass='"
//								+ bizClass + "' and po.bizSubclass='"
//								+ bizSubClass + "'   order by po.bizClass");
//				if (limitList == null || limitList.size() == 0) {
//					limitList = BaseDAOUtils
//							.getLimitParamDAO()
//							.queryByCondition(
//									"po.tlrno='"
//											+ trlNo
//											+ "' and po.status='1' and po.bizClass='"
//											+ bizClass
//											+ "' and ( po.bizSubclass='000' or po.bizSubclass='0' ) and (po.limitAmount>="
//											+ amt + " and po.limitMinamt<="
//											+ amt + ") order by po.bizClass");
//				}
//				String checkFlag = "";
//				if (limitList.size() > 0) {
//					LimitParam lmtp = (LimitParam) limitList.get(0);
//					if (amt > lmtp.getLimitMaxamount().doubleValue()) {
//						checkFlag = "2";// 2-超限
//
//					} else
//						checkFlag = "1";// 1-权限范围内
//				}
//				//Added by UU_Wu 2008-12-19 如果默认000的那条记录未找到符合金额权限的记录，则直接判定是超限
//				else {
//					checkFlag = "2";// 2-超限
//				}
//				if ("1".equals(checkFlag)) {
//					List wfaListMore1 = new ArrayList();
//					wfaListMore1 = BaseDAOUtils.getWorkflowAttitudeDAO()
//							.queryByCondition(
//									"po.processTemplate='" + processTemplate
//											+ "' and po.taskName='" + taskName
//											+ "' and po.appType='" + appType
//											+ "' and po.overFlag='1'");// 1-权限范围内
//					WorkflowAttitude wfa = (WorkflowAttitude) wfaListMore1
//							.get(0);
//					return DataFormat.trim(wfa.getAttitudelist());
//				}else
//				  if ("2".equals(checkFlag)) {
//					List wfaListMore2 = new ArrayList();
//					wfaListMore2 = BaseDAOUtils.getWorkflowAttitudeDAO()
//							.queryByCondition(
//									"po.processTemplate='" + processTemplate
//											+ "' and po.taskName='" + taskName
//											+ "' and po.appType='" + appType
//											+ "' and po.overFlag='2'");// 2-超限
//					WorkflowAttitude wfa = (WorkflowAttitude) wfaListMore2
//							.get(0);
//					return DataFormat.trim(wfa.getAttitudelist());
//				  }else
//				  {
//					  ExceptionUtil.throwCommonException("工作流审批意见参数表配置错误",
//								ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
//					  return "";
//				  }
//				// if (limitList.size() > 0) {
//				// List wfaListMore1 = new ArrayList();
//				// wfaListMore1 = BaseDAOUtils.getWorkFlowAttitudeDAO()
//				// .queryByCondition(
//				// "po.processTemplate='" + processTemplate
//				// + "' and po.taskName='" + taskName
//				// + "' and po.appType='" + appType
//				// + "' and po.overFlag='1'");// 1-权限范围内
//				// WorkflowAttitude wfa = (WorkflowAttitude) wfaListMore1
//				// .get(0);
//				// return DataFormat.trim(wfa.getAttitudelist());
//				// } else {// limitList 没有查询到超权限
//				// List wfaListMore2 = new ArrayList();
//				// wfaListMore2 = BaseDAOUtils.getWorkFlowAttitudeDAO()
//				// .queryByCondition(
//				// "po.processTemplate='" + processTemplate
//				// + "' and po.taskName='" + taskName
//				// + "' and po.appType='" + appType
//				// + "' and po.overFlag='2'");// 2-超限
//				// WorkflowAttitude wfa = (WorkflowAttitude) wfaListMore2
//				// .get(0);
//				// return DataFormat.trim(wfa.getAttitudelist());
//				// }
//			} else {
//				ExceptionUtil.throwCommonException("工作流审批意见参数表配置错误",
//						ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
//				return "";
//			}
//		}
		return "";
	}

	// ============================================================================================
	/**
	 * @param tlrnoList
	 * @title 处理tlrnoList重复的字符串。[1003,2009,3212,1003,2009]->处理后：[1003,2009,3212]
	 * @auth chenjz
	 */
	public String getOnlyTlrno(String tlrnoList) throws CommonException {
		String[] tlrnoArry = tlrnoList.split(",");
		String onlyTlrno = "";
		if (tlrnoArry.length == 1) {
			return tlrnoList;
		} else {
			for (int i = 0; i < tlrnoArry.length; i++) {
				if (onlyTlrno.indexOf(tlrnoArry[i]) == -1) {
					if (onlyTlrno.length() != 0)

					{
						onlyTlrno += ",";
					}

					onlyTlrno += tlrnoArry[i];
				}
			}

			return onlyTlrno;
		}
	}

	// =====================================================================================================
	/**
	 * @TITLE :在提供一字符串中在比配的字符串存在则过滤， 如：提供的字符串"BB,AA,CC,DD,EE",比配的字符串"AA"
	 *        结果返回："BB,CC,DD,EE"
	 */
	public static String getNotIncludeLastTlrno(String alltlrnoList,
			String lastTlrno) throws CommonException {
		String[] tlrnoArry = alltlrnoList.split(",");
		StringBuffer returnTlrnoList = new StringBuffer();
		boolean checkflag = false;
		for (int i = 0; i < tlrnoArry.length; i++) {
			if (!tlrnoArry[i].equals(lastTlrno)) {
				if (i == 0) {
					returnTlrnoList.append(tlrnoArry[i]);
					checkflag = true;
				} else {
					if (checkflag)
						returnTlrnoList.append(",").append(tlrnoArry[i]);
					else
						returnTlrnoList.append(tlrnoArry[i]);
					checkflag = true;
				}
			}

		}
		return returnTlrnoList.toString();
	}

	/**	在流程的每个任务创建的时候插入WorkFlowTaskInfo记录该任务信息
	 *
	 */
	public void initInsertWorkFlowTaskInfoForRoute(Map map) throws CommonException {

		GlobalInfo globalData = GlobalInfo.getCurrentInstanceWithoutException();

		String apptype = DataFormat.trim((String) map.get("APPTYPE")); // 申请类型（apptype）
		String processTemplate = DataFormat.trim((String) map.get("PROC_NAME"));
		String taskName = DataFormat.trim((String) map.get("TASK_NAME"));
//		String brclass = DataFormat.trim((String) map.get("BRCLASS"));// BRCLASS
		String roletype = DataFormat.trim((String) map.get("ROLETYPE"));
//		String bizClass = DataFormat.trim((String) map.get("BIZCLASS"));// BIZCLASS
//		// 审批类型
//		String bizSubClass = DataFormat.trim((String) map.get("BIZSUBCLASS"));

		String taskId = (String) map.get("TASKID");

		//得到当前时间(系统时间的date+系统时间的time)
//		Calendar rightNow = Calendar.getInstance();
//		if(){
//			rightNow.set(globalData.getTxdate().getYear(), globalData.getTxdate()
//					.getMonth(), globalData.getTxdate().getDate(), globalData
//					.getTxtime().getHours(), globalData.getTxtime().getMinutes(),
//					globalData.getTxtime().getSeconds());
//		}
//

		List listwkfp = new ArrayList();

		String tlrnolist = (String) map.get("OPRNO_ARR");
		String[] tlrnoArg = tlrnolist.split(",");

		if (tlrnoArg.length == 1) {
			map.put("TLR_NO_DO", tlrnoArg[0]);
		} else {
			map.put("TLR_NO_DO", tlrnolist);// 操作员(处理人)
		}


		WorkflowTaskInfo wftInfo = new WorkflowTaskInfo();
		WorkflowTaskInfoDAO wftInfoDao = DAOUtils.getWorkflowTaskInfoDAO();
		String procInsId = (String) map.get("PROC_INS_ID");
		List procInsList = wftInfoDao.queryByProcInsId(procInsId);
		if(procInsList.size() == 0){
			wftInfo.setProcStartTime(new Timestamp(System.currentTimeMillis()));
		}
		else {

			WorkflowTaskInfo wftInfotmp = (WorkflowTaskInfo) procInsList.get(0);
			wftInfo.setProcStartTime(wftInfotmp.getProcStartTime());
		}
		wftInfo.setAppno(DataFormat.trim((String) map.get("APPNO")));
		wftInfo.setContractno((String)map.get("CONTRACTNO"));
		wftInfo.setCustcd((String) map.get("CUSTCD"));
		//wftInfo.setTransno(DataFormat.trim((String) map.get("TRANSNO")));
		wftInfo.setProcInsId(DataFormat.trim(procInsId));
		//wftInfo.setTaskId(DataFormat.trim(taskId));
		// wftInfo.setTaskId(DataFormat.trim((String) map.get("TASKID")));
		wftInfo.setTaskName(DataFormat.trim((String) map.get("TASK_NAME")));
		wftInfo.setProcessTemplate(DataFormat.trim((String) map
				.get("PROC_NAME")));
		wftInfo.setApptype(map.get("APPTYPE").toString());
		wftInfo.setWorkflowRole(map.get("ROLE_TYPE").toString());
		wftInfo.setProcEndFlag(SystemConstant.FLAG_OFF);// 0-未结束
		wftInfo.setTaskStartTime(new Timestamp(System.currentTimeMillis()));
		wftInfo.setTaskEndFlag(SystemConstant.FLAG_OFF);// 0-未完成
		wftInfo.setTlrnoList(DataFormat.trim((String) map.get("TLR_NO_DO")));
		//wftInfo.setWorkflowRole(roletype);
		wftInfo.setMisc((String) map.get("STARTER"));

//		//如果是自动审批任务，则同步更新任务结束相关字段
//		if(taskName.equals("AutoApprove")){
//			wftInfo.setTaskEndFlag(SystemConstant.FLAG_ON);
////			wftInfo.setTaskEndTime(globalData.getTxdate());
//		}
		wftInfoDao.insert(wftInfo);
	}

	// =========================================================================================
	// 工作流任务信息表
	/**
	 *
	 */
	public void initInsertWorkFlowTaskInfo(Map map) throws CommonException {

		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();

		String apptype = DataFormat.trim((String) map.get("APPTYPE")); // 申请类型（apptype）
		String processTemplate = DataFormat.trim((String) map.get("PROC_NAME"));
		String taskName = DataFormat.trim((String) map.get("TASK_NAME"));
		String brclass = DataFormat.trim((String) map.get("BRCLASS"));// BRCLASS

		String bizClass = DataFormat.trim((String) map.get("BIZCLASS"));// BIZCLASS
		// 审批类型
		String bizSubClass = DataFormat.trim((String) map.get("BIZSUBCLASS"));
		//Long preTaskIdStr =  (Long) map.get("PRE_TASK_ID");


		List listwkfp = new ArrayList();
		listwkfp = BaseDAOUtils.getWorkflowParamDAO().queryByCondition(
				"po.processTemplate='" + processTemplate.trim()
						+ "' and po.taskName='" + taskName + "' "
						+ " and po.apptype='" + apptype
						//+ "' and po.brclass='"+ brclass
						//+ "' and po.bizClass='" + bizClass
						//+ "' and po.bizSubclass='" + bizSubClass
						+ "' ");

		if (listwkfp.size() == 0 || listwkfp == null) {
			listwkfp = BaseDAOUtils.getWorkflowParamDAO().queryByCondition(
					"po.processTemplate='" + processTemplate.trim()
							+ "' and po.taskName='" + taskName + "' "
							+ " and po.apptype='" + apptype
							//+ "' and po.brclass='" + brclass
							+ "' and po.bizClass='" + bizClass
							+ "' and po.bizSubclass='" + BIZ_SUB_CLASS_TYPE
							+ "' ");
		}
		WorkflowParam wfp = (WorkflowParam) listwkfp.get(0);
		String role_type = wfp.getWorkflowRole();
		String tlrnolist = (String) map.get("TLRNO_LIST");
		String[] tlrnoArg = tlrnolist.split(",");

		if (tlrnoArg.length == 1) {
			map.put("TLR_NO_DO", tlrnoArg[0]);
		} else {
			map.put("TLR_NO_DO", tlrnolist);// 操作员(处理人)
		}


		WorkflowTaskInfo wftInfo = new WorkflowTaskInfo();
		WorkflowTaskInfoDAO wftInfoDao = BaseDAOUtils.getWorkflowTaskInfoDAO();
		String procInsId = String.valueOf(((Long) map.get("PROC_INS_ID")).longValue());
		List procInsList = wftInfoDao.queryByProcInsId(procInsId);
		if(procInsList.size() == 0){
			wftInfo.setProcStartTime(new java.util.Date());
		}else {
			//先更新之前任务的信息 Added by UU_Wu 2009-3-17
			WorkflowTaskInfoDAO workflowTaskInfoDAO = BaseDAOUtils.getWorkflowTaskInfoDAO();
			//WorkflowTaskInfo workflowTaskInfo = BaseDAOUtils.getWorkflowTaskInfoDAO().queryById(preTaskIdStr);
			List undoWorkflowTaskInfoList = workflowTaskInfoDAO.queryByCondition("po.procInsId = '" + procInsId + "' and po.taskEndFlag ='"+SystemConstant.FLAG_OFF+"' ");
			if(undoWorkflowTaskInfoList!=null&&undoWorkflowTaskInfoList.size()>0){
				WorkflowTaskInfo workflowTaskInfo = (WorkflowTaskInfo)undoWorkflowTaskInfoList.get(0);
				if(workflowTaskInfo != null){
					workflowTaskInfo.setTlrno(globalInfo.getTlrno());
					workflowTaskInfo.setTaskEndFlag(SystemConstant.VALID_FLAG_VALID);
					workflowTaskInfo.setTaskEndTime(new Timestamp(System.currentTimeMillis()));
					workflowTaskInfoDAO.update(workflowTaskInfo);
					}
			}

			WorkflowTaskInfo wftInfotmp = (WorkflowTaskInfo) procInsList.get(0);
			wftInfo.setProcStartTime(wftInfotmp.getProcStartTime());
		}
		wftInfo.setAppno(DataFormat.trim((String) map.get("APPNO")));
		wftInfo.setCustcd(DataFormat.trim((String) map.get("CUSTCD")));
		wftInfo.setContractno(DataFormat.trim((String) map.get("CONTRACTNO")));
		wftInfo.setProcInsId(DataFormat.trim(procInsId));
		wftInfo.setId((Long) map
				.get("TASKID"));
		// wftInfo.setTaskId(DataFormat.trim((String) map.get("TASKID")));
		wftInfo.setTaskName(DataFormat.trim((String) map.get("TASK_NAME")));
		wftInfo.setProcessTemplate(DataFormat.trim((String) map
				.get("PROC_NAME")));
		wftInfo.setApptype(DataFormat.trim((String) map.get("APPTYPE")));
		wftInfo.setTaskEndFlag(SystemConstant.FLAG_OFF);// 0-未结束
		wftInfo.setTaskStartTime(new java.util.Date());

		wftInfo.setTaskEndFlag(SystemConstant.FLAG_OFF);// 0-未完成
		//wftInfo.setTlrno(DataFormat.trim((String) map.get("TLR_NO_DO")));
		wftInfo.setTlrnoList(DataFormat.trim((String) map.get("TLR_NO_DO")));
		wftInfo.setWorkflowRole(role_type);
		wftInfo.setMisc((String) map.get("MGRNO"));
		wftInfoDao.insert(wftInfo);
	}

	// =====================================================================================================
	/**
	 * @title 用于在没有权限审批一定的金额时（超出审批金额）,此时获取符合查询出来的记录，如果获取最高金额对于的操作员
	 *        有两个（同一金额），那么都要把该符合条件的操作员返回
	 */
	public String doNotlrnoAmtList(String tlrnoListTemp, String bizClass,
			String bizSubClass, double amt) throws CommonException {
		List amtlist = new ArrayList();
		String nullString = "'  '";
		if (tlrnoListTemp.length() == 0) {
			tlrnoListTemp = nullString;
		}
		StringBuffer tlrnoList = new StringBuffer();
		double limitAmt;

		// '000':查询贷款业务情况下 '0':查询合作项目情况下 都表示不限情况
		amtlist = BaseDAOUtils.getLimitParamDAO().queryByCondition(
				"po.bizClass='" + bizClass + "' and po.status='1' "
						+ " and (po.bizSubclass='" + bizSubClass
						+ "' or po.bizSubclass='000' or  po.bizSubclass='0' ) "
						+ " and po.tlrno in (" + tlrnoListTemp
						+ ") order by po.limitMinamount desc ");

		// if (amtlist.size() > 0) {
		// for (int i = 0; i < amtlist.size(); i++) {
		// LimitParam lmtp2 = (LimitParam) amtlist.get(i);
		// if (i == 0)
		// tlrnoList.append(lmtp2.getTlrno());
		// else
		// tlrnoList.append(",").append(lmtp2.getTlrno());
		// }
		// }
		if (amtlist == null || amtlist.size() == 0) {
			return WorkFlowConstants.ROLE_DEFINFE_TLRNO;
		}
		if (amtlist.size() == 1) {
			LimitParam lmtp = (LimitParam) amtlist.get(0);
			tlrnoList.append(lmtp.getTlrno());
			// return tlrnoList.toString();
		} else {
			if (amtlist.size() > 1) {// 如果有相同的最高金额，所对应的操作员都获取到
				LimitParam lmtp = (LimitParam) amtlist.get(0);
				limitAmt = lmtp.getLimitMaxamount().doubleValue();
				List amtlist2 = new ArrayList();
				// '000':查询贷款业务情况下 '0':查询合作项目情况下
				amtlist2 = BaseDAOUtils
						.getLimitParamDAO()
						.queryByCondition(
								"po.bizClass='"
										+ bizClass
										+ "' and po.status='1' "
										+ " and (po.bizSubclass='"
										+ bizSubClass
										+ "' or po.bizSubclass='000' or po.bizSubclass='0' ) and po.tlrno in ("
										+ tlrnoListTemp
										+ ") and po.limitMinamount=" + limitAmt);

				if (amtlist2.size() > 0) {
					for (int i = 0; i < amtlist2.size(); i++) {
						LimitParam lmtp2 = (LimitParam) amtlist.get(i);
						if (i == 0)
							tlrnoList.append(lmtp2.getTlrno());
						else
							tlrnoList.append(",").append(lmtp2.getTlrno());

						// return tlrnoList.toString();
					}
				}
			}

		}
		return tlrnoList.toString();

	}

	/**
	 * @title 处理workflowparam.properties将英文转变中文
	 * @param englist
	 * @return
	 * @throws CommonException
	 */
	public String fromEnToCn(String english) throws CommonException {
		try{
			String engStr = "";
			if (english == null || english.length() == 0) {
				return "";
			}
			engStr = WorkFlowParamConfigReader.getProperty(english + "_NAME");
			return engStr;
		}catch(CommonException e){
			e.printStackTrace();
			return english + "[nf]";
		}
	}

	/**
	 *
	 * @title 用于工作流查询，根据工作流到那个表去查询相应信息
	 * @param procName
	 *            工作流name
	 * @return
	 * @throws CommonException
	 */
	public int flowApplyDoTable(String procName) throws CommonException {
		String tableCheck = "";
		if (procName == null || procName.length() == 0) {
			return WorkFlowConstants.CHECK_ISERROR;
		}
		tableCheck = WorkFlowParamConfigReader.getProperty(procName + "_CHECK");
		if (tableCheck == null) {
			return WorkFlowConstants.CHECK_ISERROR;
		}
		if (tableCheck.equals("IS_CON")) {// 对于合同表
			return WorkFlowConstants.CHECK_ISCON;
		} else if (tableCheck.equals("IS_JJ")) {// 对于借据表
			return WorkFlowConstants.CHECK_ISJJ;
		} else if (tableCheck.equals("IS_PROJ")) {// 对于合作项目表
			return WorkFlowConstants.CHECK_ISPROJ;
		} else
			return WorkFlowConstants.CHECK_ISERROR;

	}

	public static void main(String[] args) throws CommonException {
		String test = "AA";

		String out = getNotIncludeLastTlrno(test, "AA");
		System.out.println("out:" + out);
	}

	/**
	 * @title 得到所有流程模板名称
	 * @param
	 * @return
	 * @throws CommonException
	 */
	public List getAllProcName() throws CommonException {
		List resultlist = new ArrayList();
		String[] template = DataFormat
				.trim(
						WorkFlowParamConfigReader
								.getProperty("PROCESS.TEMPLATGE.LIST")).split(
						",");
		for (int i = 0; i < template.length; i++) {
			WorkFlowParamSelectBean wfpSelectBean = new WorkFlowParamSelectBean();
			wfpSelectBean.setProcName(template[i]);
			String templateName = DataFormat.trim(WorkFlowParamConfigReader
					.getProperty(template[i] + "_NAME"));
			wfpSelectBean.setProcNameName(templateName);
			resultlist.add(wfpSelectBean);
		}
		return resultlist;
	}
//
//	// ================================================================================================
//	/**
//	 * @title 根据机构、贷款品种查询流程名称
//	 * @param
//	 * @return
//	 * @throws CommonException
//	 */
//	public BrhWorkflowDef getProcNameByLnid(String brcode, String apptype,
//			String lnid, String nature) throws CommonException {
//
//		BrhWorkFlowDefDAO brhWorkFlowDefDAO = BaseDAOUtils.getBrhWorkFlowDefDAO();
//
//		BrhWorkflowDef brhWorkflowDef = brhWorkFlowDefDAO.queryByUk(brcode,
//				apptype, lnid, nature);
//
//		if (brhWorkflowDef == null) {
//
//			brhWorkflowDef = brhWorkFlowDefDAO.queryByUk(brcode, apptype,
//					"000000", nature);
//		}
//		if (brhWorkflowDef == null) {
//
//			brhWorkflowDef = brhWorkFlowDefDAO.queryByUk(brcode, apptype, "000000",
//					nature);
//		}
//		if (brhWorkflowDef == null) {
//
//			brhWorkflowDef = brhWorkFlowDefDAO.queryByUk("0000", apptype,
//					"000000",nature);
//		}
//		if (brhWorkflowDef == null) {
//
//			brhWorkflowDef = brhWorkFlowDefDAO.queryByUk("0000", apptype, "000000"
//					,nature);
//		}
//		if (brhWorkflowDef == null) {
//
//			brhWorkflowDef = brhWorkFlowDefDAO.queryByUk("0000", apptype, "000000");
//
//		}
//		if (brhWorkflowDef == null) {
//			ExceptionUtil.throwCommonException("贷款品种流程配置表查询错误.",
//					ErrorCode.ERROR_CODE_BRH_WORKFLOW_DEF_SELECT);
//		}
//		return brhWorkflowDef;
//	}


	/**
	 * @title 根据机构、贷款品种查询流程名称
	 * @param
	 * @return
	 * @throws CommonException
	 */
	public BrhWorkflowDef getProcNameByLnid(String brcode, String apptype,
			String lnid) throws CommonException {

		BrhWorkFlowDefDAO brhWorkFlowDefDAO = BaseDAOUtils.getBrhWorkFlowDefDAO();

		BrhWorkflowDef brhWorkflowDef = brhWorkFlowDefDAO.queryByUk(brcode,
				apptype, lnid);

		if (brhWorkflowDef == null) {

			brhWorkflowDef = brhWorkFlowDefDAO.queryByUk(brcode, apptype,
					"000000");
		}
		if (brhWorkflowDef == null) {

			brhWorkflowDef = brhWorkFlowDefDAO.queryByUk(brcode, apptype, "0");
		}
		if (brhWorkflowDef == null) {

			brhWorkflowDef = brhWorkFlowDefDAO.queryByUk("0000", apptype,
					"000000");
		}
		if (brhWorkflowDef == null) {

			brhWorkflowDef = brhWorkFlowDefDAO.queryByUk("0000", apptype, "0");
		}
		if (brhWorkflowDef == null) {
			ExceptionUtil.throwCommonException("贷款品种流程配置表查询错误.",
					ErrorCode.ERROR_CODE_BRH_WORKFLOW_DEF_SELECT);
		}
		return brhWorkflowDef;
	}

	/**
	 * @param
	 * @title 通过appno得到未完成的任务
	 * @auth
	 */
	public WorkflowTaskInfo getUnEndTaskInfoByAppno(String appno) throws CommonException{
		WorkflowTaskInfo workflowTaskInfo = null;
		List workflowTaskInfolist = new ArrayList();
		workflowTaskInfolist = BaseDAOUtils.getWorkflowTaskInfoDAO().queryByCondition(" po.appno ='"+ appno+"' order by id");


		for(int i =0; i<workflowTaskInfolist.size();i++){
			workflowTaskInfo = new WorkflowTaskInfo();
			workflowTaskInfo = (WorkflowTaskInfo) workflowTaskInfolist.get(i);
			if(workflowTaskInfo.getTaskEndFlag().equals(SystemConstant.FLAG_OFF)){
				return workflowTaskInfo;
			}else{
				continue;
			}

		}
		return null;
	}


	/**
	 * Description: 根据数据库配置工作流任务分配
	 *
	 * @param
	 * @return String
	 * @exception
	 * @author richmond_liu
	 * @version v1.0,2008-8-18
	 */
	public String taskAssign(String appno, String appType, String taskName,
			String brcode) throws CommonException {

		WorkflowParamDAO dao = BaseDAOUtils.getWorkflowParamDAO();
		List list = dao.queryByCondition("po.taskName = ? and po.apptype = ?",
				new Object[] { taskName, appType });
		if (list.size() == 0) {
			ExceptionUtil.throwCommonException("没有找到任务分配参数！ taskName: "
					+ taskName, ErrorCode.ERROR_CODE_TASK_ASSIGN_ERROR);
		}

		WorkflowParam param = (WorkflowParam) list.get(0);

		String result = "";

		String code = "";
		if (param.getBrcodeType().equals(BRCODE_TYPE_AUTO)) {
			String brclass = param.getBrclass();
			if (brclass.equals(BRCLASS_SUBBRANCH)) {
				code = brcode;
			} else if (brclass.equals(BRCLASS_BRANCH)) {
				code = BctlService.getInstance().getMngBranchBrcode(brcode).getBrcode();
			}else if (brclass.equals(BRCLASS_BLNBRANCH)){
				code = BctlService.getInstance().getBlnBranchBrcode(brcode).getBrcode();
			}else if (brclass.equals(BRCLASS_LOANCENTER)){
				code = BctlService.getInstance().getLoanCenterBrcode(brcode).getBrcode();
			}
		}

		if (param.getAssignType().equals(ASSIGN_TYPE_TOROLE)) {
			String role = param.getWorkflowRole();
			result = code + role;
			WorkflowTaskInfoService.getInstance().markTaskAssigned(appno,
					appType, taskName, role);
		} else if (param.getAssignType().equals(ASSIGN_TYPE_TOLIST)) {

		}

		return result;
	}

	/**
	 * Description: 查询所有流程参数配置
	 *
	 * @param
	 * @return WorkflowParam
	 * @exception
	 * @author byron_lu
	 * @version v1.0,2008-10-21
	 */
	public List queryAllWorkflowParam() throws CommonException {

		WorkflowParamDAO dao = BaseDAOUtils.getWorkflowParamDAO();
		List list = dao.queryAll();
        return list;
	}
	/**
	 * Description: 根据条件查询流程参数配置
	 *
	 * @param
	 * @return WorkflowParam
	 * @exception
	 * @author byron_lu
	 * @version v1.0,2008-10-21
	 */
	public List queryByCondition(String procName) throws CommonException {

		WorkflowParamDAO dao = BaseDAOUtils.getWorkflowParamDAO();
		List list = dao.queryByCondition("po.processTemplate = ?",
				new Object[] { procName});
        return list;
	}

	/**
	 * 更新工作流参数配置
	 *
	 * @param insertList
	 * @param
	 * @param delList
	 * @throws CommonException
	 */
	public void updateParam(List insertList, List delList)
			throws CommonException {
		WorkflowParamDAO dao = BaseDAOUtils.getWorkflowParamDAO();
		// 删除操作.
		for (Iterator it = delList.iterator(); it.hasNext();) {
			WorkflowParam param = (WorkflowParam) it.next();
			dao.delete(param);
		}

		BaseDAOUtils.getHQLDAO().flush();

		// 增加操作.
		for (Iterator it = insertList.iterator(); it.hasNext();) {
			WorkflowParam param = (WorkflowParam) it.next();
			String processTemplate=param.getProcessTemplate();
			String taskName=param.getTaskName();
			String whereString="po.processTemplate=? and po.taskName=?";
			Object[] objList={processTemplate,taskName};
			List list= dao.queryByCondition(whereString, objList);
			if (list.size()>0) {
				ExceptionUtil.throwCommonException("已经存在任务：" + taskName
						+ "，不能新增此任务", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}else
			dao.insert(param);
		}
	}



	/**
	 * Description: 查询流程参数配置
	 *
	 * @param
	 * @return WorkflowParam
	 * @exception
	 * @author byron_lu
	 * @version v1.0,2008-10-21
	 */
	public WorkflowParam queryWorkflowParam(String procName, String taskName) throws CommonException {

		WorkflowParamDAO dao = BaseDAOUtils.getWorkflowParamDAO();
//		List list = dao.queryByCondition("po.processTemplate = ? and po.taskName = ?",
//				new Object[] { procName, taskName });
		//String sql = "where po.processTemplate = '"+procName+"' and po.taskName = '"+taskName+"'";
		String sql = " po.processTemplate = '"+procName+"' and po.taskName = '"+taskName+"'";
		List list = dao.queryByCondition(sql);
		if (list.size() == 0) {
			ExceptionUtil.throwCommonException("没有找到任务分配参数！ taskName: "
					+ taskName, ErrorCode.ERROR_CODE_TASK_ASSIGN_ERROR);
		}

		WorkflowParam param = (WorkflowParam) list.get(0);
        return param;
	}

	/** 合并票据工作流到信贷系统 by zhouxuejing 20101026 begin*/
	/**	在每个流程任务时操作WorkFlowAppInfo表，没记录时插入，有记录则更新
	 *
	 *
	 */
	public void OprWorkFlowAppInfo(Map map) throws CommonException {
		String busstype = (String) map.get("BIZCLASS");
		String custcd = (String) map.get("CUSTCD");
		String appno = (String) map.get("APPNO");
		String proInsId =   (String)(map.get("PROC_INS_ID"));
		String starter = (String) map.get("STARTER");
		String procName = (String) map.get("PROC_NAME");
		String roletype = (String) map.get("ROLETYPE");
		String apptype = (String)map.get("APPTYPE");
		String brcode = (String)map.get("STARTBRCODE");
//		GlobalData GlobalData = GlobalData.getCurrentInstance();
		WorkflowAppInfo wftInfo = new WorkflowAppInfo();
		WorkflowAppInfoDAO wftInfoDao = BaseDAOUtils.getWorkflowAppInfoDAO();
		List list = wftInfoDao.queryByCondition("po.piid=?", new Object[]{proInsId});

		//没找到则插入
		if(list==null || list.size() == 0){
			wftInfo = new  WorkflowAppInfo();
			wftInfo.setApptype(apptype);
			wftInfo.setBrcode(brcode);
			wftInfo.setCurrRole("");
			wftInfo.setTlrno(starter);
			wftInfo.setCustno(custcd);
			wftInfo.setAppno(appno);
			wftInfo.setPiid(proInsId);
			wftInfo.setStartTime(new Timestamp(System.currentTimeMillis()));
			wftInfo.setProcName(procName);
			wftInfo.setStatus("0");//未完成
			wftInfoDao.insert(wftInfo);
		}else{
			wftInfo = (WorkflowAppInfo)list.get(0);
			wftInfo.setCurrRole(roletype);
			wftInfoDao.update(wftInfo);
		}

	}

	/**
	 * @param
	 * @title 把数组转化为string
	 * @auth
	 */
	public String transArrayToString(String[] inarr){
		if(inarr == null || inarr.length==0){
			return "";
		}
		else{
			StringBuffer sb= new StringBuffer();
			for(int i = 0; i<inarr.length;i++){
				sb.append(inarr[i]+ ",");
			}
			String result = sb.toString();
			if(result.endsWith(",")){
				result = result.substring(0, result.length()-1);
			}
			return result;
		}

	}


	/**
	 * @param
	 * @title 把list转化为数组
	 * @auth
	 */
	public String[] transListToArg(List list){
		int size =list.size();
		String[] arr = (String[])list.toArray(new String[size]);
		return arr;
	}

	/**
	 * @param
	 * @title 把数组转化为list<String>
	 * @auth
	 */
	public List transArgToList(String[] arg){
		List list = new ArrayList();
		for (int i = 0; i < arg.length; i++) {
			list.add(arg[i]);
		}
		return list;
	}

	/**
	 * @param
	 * @title 把list转化为string
	 * @auth
	 */
	public String transListToString(List list){
		StringBuffer sb= new StringBuffer();
		for(int i = 0; i<list.size();i++){
			sb.append(list.get(i)+ ",");
		}
		String result = sb.toString();
		if(result.endsWith(",")){
			result = result.substring(0, result.length()-1);
		}
		return result;
	}

	/**
	 * @param XXX,XXX,XXX
	 * @title 把string转化为list
	 * @auth
	 */
	public List transStringToList(String str){
		List result = new ArrayList();
		String[] strs = str.split(",");
		for (int i = 0; i < strs.length; i++) {
			result.add(strs[i]);
		}

		return result;
	}

	/**
	 * @param
	 * @title 根据机构和岗位找到对应的操作员
	 * @auth
	 */
	public List getTlrnolistByBrcodeRole(String brcode, Integer roleId) throws CommonException{
		HQLDAO hqldao = BaseDAOUtils.getHQLDAO();
		StringBuffer buffer = new StringBuffer();
		buffer.append("select t.tlrno from TlrInfo t,TlrRoleRel tr where t.tlrno = tr.tlrno ")
		      .append(" and t.brcode = '").append(brcode).append("'")
		      .append(" and tr.roleId = ").append(roleId);
		List list = new ArrayList();
		Iterator it = hqldao.queryByQL(buffer.toString());
		while(it.hasNext()){
			list.add(it.next());
		}
		return list;
	}

	/** modify by shen_antonio 20091214 jira: BMS-2334 begin .*/

	/**	得到该流程实例适用的审批路线定义
	 *
	 */

	public Integer getWorkflowRouteInfoNew(String bussType, BigDecimal amount,String startbrcode) throws CommonException{
		Integer routeId =0;
		WorkflowRouteBindingDAO workflowRouteBindingDAO = BaseDAOUtils.getWorkflowRouteBindingDAO();
		Bctl bctl = BctlService.getInstance().queryByBrcode(startbrcode);
		String brhClass = bctl.getBrclass();

		String flowType = bussType.substring(0, 4);//4位的流程类型
		String bizType = bussType.substring(4);//4位的业务品种

		List workflowRouteBindinglist = null;
		/** 1.找到流程类型，业务类型，指定机构完全匹配的路线 */
		workflowRouteBindinglist = workflowRouteBindingDAO.queryByCondition(
				" po.bussType = ? and po.maxAmt >= ? and po.startBrhid = ? and po.routeId <> ? order by po.maxAmt",
				new Object[] {bussType, amount,startbrcode, 0},null);
		if(workflowRouteBindinglist != null && workflowRouteBindinglist.size() > 0){
			WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist.get(0);
			routeId = workflowRouteBinding.getRouteId();
			return routeId;
		}
		/** 2.找到流程类型，指定机构完全匹配，但业务类型为默认的路线 */
		workflowRouteBindinglist = workflowRouteBindingDAO.queryByCondition(
				" po.bussType = ? and po.maxAmt >= ? and po.startBrhid = ? and po.routeId <> ? order by po.maxAmt",
				new Object[] {flowType + SystemConstant.DEFAULT_BIZTYPE, amount,startbrcode, 0},null);
		if(workflowRouteBindinglist != null && workflowRouteBindinglist.size() > 0){
			WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist.get(0);
			routeId = workflowRouteBinding.getRouteId();
			return routeId;
		}
		/** 3.找到业务类型，指定机构完全匹配，但流程类型为默认的路线 */
		workflowRouteBindinglist = workflowRouteBindingDAO.queryByCondition(
				" po.bussType = ? and po.maxAmt >= ? and po.startBrhid = ? and po.routeId <> ? order by po.maxAmt",
				new Object[] {SystemConstant.DEFAULT_BUSSTYPE + bizType, amount,startbrcode, 0},null);
		if(workflowRouteBindinglist != null && workflowRouteBindinglist.size() > 0){
			WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist.get(0);
			routeId = workflowRouteBinding.getRouteId();
			return routeId;
		}
		/** 4.找到指定机构完全匹配，但流程类型，业务类型为默认的路线 */
		workflowRouteBindinglist = workflowRouteBindingDAO.queryByCondition(
				" po.bussType = ? and po.maxAmt >= ? and po.startBrhid = ? and po.routeId <> ? order by po.maxAmt",
				new Object[] {SystemConstant.DEFAULT_BUSSTYPE + SystemConstant.DEFAULT_BIZTYPE , amount,startbrcode, 0},null);
		if(workflowRouteBindinglist != null && workflowRouteBindinglist.size() > 0){
			WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist.get(0);
			routeId = workflowRouteBinding.getRouteId();
			return routeId;
		}
		/** 5.找到流程类型，业务类型，机构级别匹配的路线 */
		workflowRouteBindinglist = workflowRouteBindingDAO.queryByCondition(
				" po.bussType = ? and po.maxAmt >= ? and po.startBrhid = ? and po.routeId <> ? order by po.maxAmt",
				new Object[] {bussType, amount,"-"+brhClass, 0},null);
		if(workflowRouteBindinglist != null && workflowRouteBindinglist.size() > 0){
			WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist.get(0);
			routeId = workflowRouteBinding.getRouteId();
			return routeId;
		}
		/** 6.找到流程类型，机构级别匹配,但业务类型为默认的路线 */
		workflowRouteBindinglist = workflowRouteBindingDAO.queryByCondition(
				" po.bussType = ? and po.maxAmt >= ? and po.startBrhid = ? and po.routeId <> ? order by po.maxAmt",
				new Object[] {flowType + SystemConstant.DEFAULT_BIZTYPE, amount,"-"+brhClass, 0},null);
		if(workflowRouteBindinglist != null && workflowRouteBindinglist.size() > 0){
			WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist.get(0);
			routeId = workflowRouteBinding.getRouteId();
			return routeId;
		}
		/** 7.找到业务类型，机构级别匹配,但流程类型为默认的路线 */
		workflowRouteBindinglist = workflowRouteBindingDAO.queryByCondition(
				" po.bussType = ? and po.maxAmt >= ? and po.startBrhid = ? and po.routeId <> ? order by po.maxAmt",
				new Object[] {SystemConstant.DEFAULT_BUSSTYPE + bizType, amount,"-"+brhClass, 0},null);
		if(workflowRouteBindinglist != null && workflowRouteBindinglist.size() > 0){
			WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist.get(0);
			routeId = workflowRouteBinding.getRouteId();
			return routeId;
		}
		/** 8.找到机构级别完全匹配，但流程类型，业务类型为默认的路线 */
		workflowRouteBindinglist = workflowRouteBindingDAO.queryByCondition(
				" po.bussType = ? and po.maxAmt >= ? and po.startBrhid = ? and po.routeId <> ? order by po.maxAmt",
				new Object[] {SystemConstant.DEFAULT_BUSSTYPE + SystemConstant.DEFAULT_BIZTYPE , amount,"-"+brhClass, 0},null);
		if(workflowRouteBindinglist != null && workflowRouteBindinglist.size() > 0){
			WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist.get(0);
			routeId = workflowRouteBinding.getRouteId();
			return routeId;
		}
		return routeId;
	}

	/**	得到该流程实例适用的审批路线定义
	 *
	 */

	public Integer getWorkflowRouteInfo(String bussType, BigDecimal amount,String startbrcode) throws CommonException{
		Integer routeId =0;
		WorkflowRouteBindingDAO workflowRouteBindingDAO = BaseDAOUtils.getWorkflowRouteBindingDAO();
		Bctl bctl = BctlService.getInstance().queryByBrcode(startbrcode);
		/**
		 * 查询原则：按照下面原则先后次序查询
		 * 1. 查询指定机构、指定业务品种的审批路线
		 * 2. 查询指定机构、不指定业务品种的审批路线
		 * 3. 查询制定机构级别、指定业务品种的审批路线
		 * 4. 查询指定机构级别、不指定业务品种的审批路线
		 */
		/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/
		//1. 查询指定机构、指定业务品种的审批路线
		List workflowRouteBindinglist1 = workflowRouteBindingDAO
			.queryByCondition(" po.bussType = ? and po.maxAmt >= ? and po.startBrhid = ? and po.routeId <> ? order by po.maxAmt",
							new Object[] {bussType, amount,Integer.valueOf(startbrcode), 0},
							null);
		//2. 查询指定机构、不指定业务品种的审批路线
		if(workflowRouteBindinglist1.size()==0){
			List workflowRouteBindinglist2 = workflowRouteBindingDAO
			.queryByCondition(" po.bussType = ? and po.maxAmt >= ? and po.startBrhid = ?  and po.routeId <> ? order by po.maxAmt",
					new Object[] {SystemConstant.DEFAULT_BUSSTYPE, amount, Integer.valueOf(startbrcode), 0},
					null);
			if(workflowRouteBindinglist2.size()>0){
				WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist2.get(0);
				routeId = workflowRouteBinding.getRouteId();
		//3. 查询制定机构级别、指定业务品种的审批路线
			}else{
				String brhClass = bctl.getBrclass();
				List workflowRouteBindinglist3 = workflowRouteBindingDAO
				.queryByCondition(" po.bussType = ? and po.startBrhid = ? and po.maxAmt >= ?  and po.routeId <> ? order by po.maxAmt",
							new Object[] {bussType, Integer.parseInt(brhClass)*-1, amount, 0},
							null);
				//有适用的审批路线记录,则取金额最接近的那条
				if(workflowRouteBindinglist3.size()>0){
					WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist3.get(0);
					routeId = workflowRouteBinding.getRouteId();
				}
		//4. 查询指定机构级别、不指定业务品种的审批路线
				else{
					List workflowRouteBindinglist4 =  workflowRouteBindingDAO
						.queryByCondition(" po.bussType = ?  and po.startBrhid = ? and po.maxAmt >= ? and po.routeId <> ? order by po.maxAmt",
								new Object[] {SystemConstant.DEFAULT_BUSSTYPE,Integer.parseInt(brhClass)*-1,amount, 0},
								null);
					if(workflowRouteBindinglist4.size()>0){
						WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist4.get(0);
						routeId = workflowRouteBinding.getRouteId();
					}
				}
			}

		}
		else{
			WorkflowRouteBinding workflowRouteBinding = (WorkflowRouteBinding) workflowRouteBindinglist1.get(0);
			routeId = workflowRouteBinding.getRouteId();
		}
		return routeId;

	}
	/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/

	/**
	 * @param
	 * @throws CommonException
	 * @title 在刚得到适用的审批路线时，记录当前流程实例所用的审批路线明细
	 * @auth
	 */
	public void insertWorkflowInsRoute(String piid,Integer routeId) throws CommonException{
		WorkflowInsRouteDAO workflowInsRouteDAO = BaseDAOUtils.getWorkflowInsRouteDAO();
		List routeParamlist = new ArrayList();
		try {
			routeParamlist = BaseDAOUtils.getWorkflowRouteParamDAO()
				.queryByCondition(" po.routeId = ? order by po.stopId",
						new Object[] {routeId},
						new Type[] {Hibernate.INTEGER});
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		WorkflowInsRoute workflowInsRoute = null;
		for(int i =0;i<routeParamlist.size();i++){
			WorkflowRouteParam workflowRouteParam = (WorkflowRouteParam) routeParamlist.get(i);
			workflowInsRoute = new WorkflowInsRoute();
			workflowInsRoute.setPiid(piid);
			workflowInsRoute.setRouteId(routeId);
			workflowInsRoute.setAmtType(workflowRouteParam.getAmtType());
			workflowInsRoute.setApproveAmt(workflowRouteParam.getApproveAmt());
			workflowInsRoute.setBrhClass(workflowRouteParam.getBrhClass());
			workflowInsRoute.setNeed(workflowRouteParam.getNeed());
			workflowInsRoute.setPass(workflowRouteParam.getPass());
			workflowInsRoute.setRoleId(workflowRouteParam.getRoleId());
			workflowInsRoute.setStopId(workflowRouteParam.getStopId());
			try {
				workflowInsRouteDAO.insert(workflowInsRoute);
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
		}
	}

	/**
	 * @param
	 * @title 按照金额权限，去limit_param中找符合金额权限的操作员
	 * @auth
	 * bussType 目前是8位的。BIZ_CLASS(4位)+BIZ_SUBCLASS(4位)
	 */

	public List getOprlistByAmt(List oprnolist1,String bussType,BigDecimal amount) throws CommonException{
		List oprnolist2 = new ArrayList();
		String tlrno =null;
		String bizSubclass = null;
		String bizClass = null;
		log.warn("按照金额权限，去limit_param中找符合金额权限的操作员 start");
		log.warn("amount :" +amount);
		try{
		if(bussType != null &&!bussType.equals("")&& bussType.length()==8){
			bizClass = bussType.substring(0,4);
			bizSubclass = bussType.substring(4);
			log.warn("bizClass :" +bizClass);
			log.warn("bizSubclass:" + bizSubclass);
		}else{
			log.warn("bussType 不合法");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		for(int k =0; k<oprnolist1.size();k++){
			Integer tempoprno = Integer.parseInt((String) oprnolist1.get(k));
			/**mod by abudula at 20101118 start*/
			tlrno = String.valueOf(tempoprno);
			List tempLimitParamlist = BaseDAOUtils.getLimitParamDAO()
			.queryByCondition(" po.tlrno =? and po.status=? and po.bizClass= ? and po.bizSubclass= ?",
					new Object[] {tlrno,SystemConstant.VALID_FLAG_VALID,bizClass,bizSubclass},
					new Type[] {Hibernate.STRING, Hibernate.STRING,Hibernate.STRING,Hibernate.STRING});
			//能在limit_param中找到对应bussType+机构+岗位的操作员
			if(tempLimitParamlist.size()>=1){
				//
				LimitParam tempLimitParam = (LimitParam) tempLimitParamlist.get(0);
				if(tempLimitParam.getLimitMaxamount().compareTo(amount)>=0){
					oprnolist2.add(tempLimitParam.getTlrno());
				}
				else{
					continue;
				}
			}
			else{
				//大类匹配，小类不匹配的情况下 比较金额
				List tempLimitParamlist2 = BaseDAOUtils.getLimitParamDAO()
					.queryByCondition(" po.tlrno =? and po.status=? and po.bizClass=? and po.bizSubclass=? and po.limitMaxamount >= ?" ,
						new Object[] {tlrno,SystemConstant.VALID_FLAG_VALID,bizClass,SystemConstant.DEFAULT_BUSSTYPE,amount},
						new Type[] {Hibernate.STRING, Hibernate.STRING,Hibernate.STRING,Hibernate.STRING,Hibernate.BIG_DECIMAL});
				if(tempLimitParamlist2.size()>=1){
					LimitParam tempLimitParam2 = (LimitParam) tempLimitParamlist2.get(0);
					oprnolist2.add(tempLimitParam2.getTlrno());
				}
				else{
					//大类不匹配，小类匹配的情况下 比较金额
					List tempLimitParamlist3 = BaseDAOUtils.getLimitParamDAO()
						.queryByCondition(" po.tlrno =? and po.status=? and po.bizClass=? and po.bizSubclass=? and po.limitMaxamount >= ?" ,
							new Object[] {tlrno,SystemConstant.VALID_FLAG_VALID,SystemConstant.DEFAULT_BUSSTYPE,bizSubclass,amount},
							new Type[] {Hibernate.STRING, Hibernate.STRING,Hibernate.STRING,Hibernate.STRING,Hibernate.BIG_DECIMAL});
					if(tempLimitParamlist3.size()>=1){
						LimitParam tempLimitParam3 = (LimitParam) tempLimitParamlist3.get(0);
						oprnolist2.add(tempLimitParam3.getTlrno());
					}
					//大类不匹配，小类不匹配的情况下
					else{
						//如果有大类不限制，有小类不限制的话
						List tempLimitParamlist4 = BaseDAOUtils.getLimitParamDAO()
						.queryByCondition(" po.tlrno =? and po.status=? and po.bizClass=? and po.bizSubclass=? and po.limitMaxamount >= ?" ,
							new Object[] {tlrno,SystemConstant.VALID_FLAG_VALID,SystemConstant.DEFAULT_BUSSTYPE,SystemConstant.DEFAULT_BUSSTYPE,amount},
							new Type[] {Hibernate.STRING, Hibernate.STRING,Hibernate.STRING,Hibernate.STRING,Hibernate.BIG_DECIMAL});
						if(tempLimitParamlist4.size()>=1){
							LimitParam tempLimitParam4 = (LimitParam) tempLimitParamlist4.get(0);
							oprnolist2.add(tempLimitParam4.getTlrno());
						}else{
							continue;
						}
					}
				}
			}
		}
		/**mod by abudula at 20101118 end*/
		return oprnolist2;
	}

	//BMS-1457	UU_Wu	2009-10-12	Start
	/**	多级审批时，得到当前适合的操作员列表
	 *
	 */

	public Map getAssignedOprnoList(Integer routeId, Integer stopId,  String startbrcode,String bussType,String manualAssigned,String piid,BigDecimal amount) throws CommonException{
		Map resultMap = new HashMap();
		List InsRouteList = new ArrayList();
		/**mod by abudula at 20101120 STL-94 start 直接使用业务金额与操作员对比*/
		//BigDecimal amount = new BigDecimal(0);
		/**mod by abudula at 20101120 STL-94 end 直接使用业务金额与操作员对比*/
		//StopId为空或为0，说明是第一次进入审批节点
		if(stopId==null || stopId.equals(0)){
			InsRouteList = BaseDAOUtils.getWorkflowInsRouteDAO()
				.queryByCondition(" po.routeId = ? and po.piid = ? order by po.stopId",
							new Object[] {routeId,piid},
							new Type[] {Hibernate.INTEGER,Hibernate.STRING});
		}
		else{
			InsRouteList = BaseDAOUtils.getWorkflowInsRouteDAO()
				.queryByCondition(" po.routeId = ? and po.stopId > ? and po.piid = ? order by po.stopId",
							new Object[] {routeId,stopId,piid},
							new Type[] {Hibernate.INTEGER,Hibernate.INTEGER,Hibernate.STRING});
		}

		WorkflowInsRoute workflowInsRoute = null;
		List opratorlist =  new ArrayList();
		List oprnolist1 = new ArrayList();//机构+岗位操作员列表
		List oprnolist2 = new ArrayList();//有金额权限的操作员列表
		for(int i =0; i<InsRouteList.size(); i++){
			workflowInsRoute = new WorkflowInsRoute();
			workflowInsRoute = (WorkflowInsRoute) InsRouteList.get(i);
			resultMap.put("ROLE_TYPE", workflowInsRoute.getRoleId());
			/**mod by abudula at 20101120 STL-94 start 直接使用业务金额与操作员对比*/
			//amount = workflowInsRoute.getApproveAmt();
			/**mod by abudula at 20101120 STL-94 end 直接使用业务金额与操作员对比*/
			String  currBrhid = BctlService.getInstance().getUpBrcode(workflowInsRoute.getBrhClass(), startbrcode);
			resultMap.put("CURR_STOPID", workflowInsRoute.getStopId());
				//Added By UU 当前明细的是否必经，当前分配岗位，当前分配机构记入流程中 2009-9-27
				String roleId =  workflowInsRoute.getRoleId().toString();
				resultMap.put(WorkFlowConstants.WORKFLOW_ATTRIBUTE_ISNEED, workflowInsRoute.getNeed());
				resultMap.put(WorkFlowConstants.WORKFLOW_ATTRIBUTE_ROLEID, roleId);
				resultMap.put(WorkFlowConstants.WORKFLOW_ATTRIBUTE_CURRBRHID, currBrhid.toString());
			//必经站点
			if(workflowInsRoute.getNeed().equals(SystemConstant.FLAG_ON)){

				oprnolist1 = getTlrnolistByBrcodeRole(currBrhid, workflowInsRoute.getRoleId());
				String currBrhno = "";
				//不按金额权限直接找对应机构+岗位的操作员
				if(workflowInsRoute.getAmtType().equals(SystemConstant.FLAG_OFF)){
					resultMap.put("OPRNO_ARR", transListToArg(oprnolist1));
					resultMap.put("CAN_FINAL_APPROVE", SystemConstant.FLAG_ON);
					return resultMap;
				}
				//按照金额权限，去limit_param中找符合金额权限的操作员
				else{
					oprnolist2 = getOprlistByAmt(oprnolist1,bussType,amount);
					//能找到具有金额权限的操作员
					if(oprnolist2.size()>=1){
						resultMap.put("OPRNO_ARR", transListToArg(oprnolist2));
						resultMap.put("CAN_FINAL_APPROVE", SystemConstant.FLAG_ON);
						return resultMap;
					}
					//找不到则返回该岗位+机构的操作员
					else{
						System.out.print("----------按金额分配必经岗位未能找到 符合金额权限的操作员-----------");
						resultMap.put("OPRNO_ARR", transListToArg(oprnolist1));
						resultMap.put("CAN_FINAL_APPROVE", SystemConstant.FLAG_OFF);
						return resultMap;
					}
				}
			}
			//跳过站点直接跳过到下个站点
			else if(workflowInsRoute.getPass().equals(SystemConstant.FLAG_ON)){
				continue;
			}
			//非必经非跳过站点，检查是否适用
			else{
				oprnolist1 = getTlrnolistByBrcodeRole(currBrhid, workflowInsRoute.getRoleId());
				//无需按照金额权限进行分配直接找对应机构+岗位的操作员
				if(workflowInsRoute.getAmtType().equals(SystemConstant.FLAG_OFF)){

					resultMap.put("OPRNO_ARR", transListToArg(oprnolist1));
					resultMap.put("CAN_FINAL_APPROVE", SystemConstant.FLAG_ON);
					return resultMap;
				}
				//需按照金额权限分配
				else{
					oprnolist2 = getOprlistByAmt(oprnolist1,bussType,amount);
					//能够找到则返回
					if(oprnolist2.size()>=1){
						resultMap.put("OPRNO_ARR", transListToArg(oprnolist2));
						resultMap.put("CAN_FINAL_APPROVE", SystemConstant.FLAG_ON);
						return resultMap;
					}
					//找不到则进入下个审批路线站点id
					else{
						continue;
					}
				}
			}
		}

		return resultMap;

	}


	//替换方法getCommonTaskAssign，记录当前流程操作员岗位 UU_Wu  2009-10-10 Start BMS-1457
	/**
	 * @param
	 * @title 获取一般任务（审批任务和自动任务除外）的任务分配
	 * @auth
	 */
	public Map getCommonTaskAssign(Map map) throws CommonException{
		Map resultMap = new HashMap();
		String bizclass = (String) map.get("BUSS_TYPE");
		BigDecimal amount = new BigDecimal(map.get("AMOUNT").toString());
		String startbrcode = map.get("STARTBRCODE").toString();
		String piid = (String) map.get("PROC_INS_ID");
		String nodeName = (String) map.get("TASK_NAME");
		String procName = (String) map.get("PROC_NAME");
		String starter =  map.get("STARTER").toString();
		WorkflowParam workflowParam =null;
		Integer roleId = null;
		List tlrnolist = new ArrayList();
		/** 按照模板名，任务名，机构级别查找复核条件的记录 */
		List workflowparamList = BaseDAOUtils.getWorkflowParamDAO().queryByCondition(
				" po.processTemplate = ? and po.taskName = ? and po.bizClass = ? ",
				new Object[] {procName,nodeName,bizclass},
				new Type[] {Hibernate.STRING,Hibernate.STRING,Hibernate.STRING});
		String brcode = "";
		//没记录则去找 业务种类不限的记录
		if(workflowparamList == null || workflowparamList.size() == 0){
			workflowparamList = BaseDAOUtils.getWorkflowParamDAO().queryByCondition(
				" po.processTemplate = ? and po.taskName = ? and po.bizClass = ? ",
				new Object[] {procName, nodeName, SystemConstant.DEFAULT_BUSSTYPE},
				new Type[] {Hibernate.STRING, Hibernate.STRING, Hibernate.STRING});
			// 找到一条记录
			if(workflowparamList.size() == 1){
				workflowParam = (WorkflowParam) workflowparamList.get(0);
				tlrnolist = new ArrayList();
				String workflowRole = workflowParam.getWorkflowRole();
				if(workflowRole.startsWith("ROLE")){
					roleId = new Integer(workflowRole.substring(4));
				}else{
					roleId = new Integer(workflowRole);
				}
				//分配方式 1-分配到岗位
				if(workflowParam.getAssignType().equals(WorkFlowServiceHelper.WORKFLOWPARAM_ASSIGNTYPE_1)){
					String brclass = workflowParam.getBrclass();

					//机构级别为发起行同级
					if(StringUtils.isEmpty(brclass) || brclass.equals(SystemConstant.BRCODE_CLASS_SELF)){
						TlrInfo tlrInfo = BaseDAOUtils.getTlrInfoDAO().queryById(starter);
						brcode = tlrInfo.getBrcode();
					}
					//其他情况为指定具体机构级别
					else{
						brcode = BctlService.getInstance().getUpBrcode(brclass, startbrcode);
					}

					tlrnolist = getTlrnolistByBrcodeRole(brcode, roleId);
				}
				//2-分配给发起人
				else if(workflowParam.getAssignType().equals(WorkFlowServiceHelper.WORKFLOWPARAM_ASSIGNTYPE_2)){
					String stater = (String) map.get("STARTER");
					TlrInfo tlrInfo = BaseDAOUtils.getTlrInfoDAO().queryById(starter);
					brcode = tlrInfo.getBrcode();
					tlrnolist.add(stater);
				}
			}
		}
		//有一条记录
		else if(workflowparamList.size()==1){
			workflowParam = (WorkflowParam) workflowparamList.get(0);
			String workflowRole = workflowParam.getWorkflowRole();
			if(workflowRole.startsWith("ROLE")){
				roleId = new Integer(workflowRole.substring(4));
			}else{
				roleId = new Integer(workflowRole);
			}
			tlrnolist = new ArrayList();
			//分配方式 1-分配到岗位
			if(workflowParam.getAssignType().equals(WorkFlowServiceHelper.WORKFLOWPARAM_ASSIGNTYPE_1)){
				String brclass = workflowParam.getBrclass();
				//机构级别为发起行同级
				if(brclass.equals(SystemConstant.BRCODE_CLASS_SELF)){
					TlrInfo tlrInfo = BaseDAOUtils.getTlrInfoDAO().queryById(starter);
					brcode = tlrInfo.getBrcode();
				}
				//其他情况为指定具体机构级别
				else{
					brcode = BctlService.getInstance().getUpBrcode(brclass, startbrcode);
				}

				tlrnolist = getTlrnolistByBrcodeRole(brcode, roleId);
			}
			//2-分配给发起人
			else if(workflowParam.getAssignType().equals(WorkFlowServiceHelper.WORKFLOWPARAM_ASSIGNTYPE_2)){
				String stater = (String) map.get("STARTER");
				TlrInfo tlrInfo = BaseDAOUtils.getTlrInfoDAO().queryById(stater);
				brcode = tlrInfo.getBrcode();
				tlrnolist.add(stater);
			}
		}
		else{
			tlrnolist.add(WorkFlowServiceHelper.TASKASSIGN_NONE2);
		}

		/* add by kangbyron 2011-2-22 在此基础上增加操作员审批阀值控制 begin */
		TaskAssignService taskAssignService = TaskAssignService.getInstance();
		String tlrno = taskAssignService.getAssignToTlrnoGZ(tlrnolist, null,
				SystemConstant.TASK_ASSIGN_MODE_1, false, true,map);
		//resultMap.put("OPRNO_ARR", transListToArg(tlrnolist));
		resultMap.put("OPRNO_ARR", new String[]{tlrno});
		/* add by kangbyron 2011-2-22 在此基础上增加操作员审批阀值控制 end */
		if(resultMap.get("OPRNO_ARR")==null || resultMap.get("OPRNO_ARR").equals("")){

			resultMap.put("OPRNO_ARR", WorkFlowServiceHelper.TASKASSIGN_NONE3);
		}

		//当前岗位
		resultMap.put(WorkFlowConstants.WORKFLOW_ATTRIBUTE_ROLEID, roleId);
		//当前机构
		resultMap.put(WorkFlowConstants.WORKFLOW_ATTRIBUTE_CURRBRHID, brcode);

		//把分配结果存入全局变量
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstanceWithoutException();
		if(globalInfo!=null){
			globalInfo.getCurrentInstance().setWorkflowTlrno(transArrayToString((String[]) resultMap.get("OPRNO_ARR")));
		}
		resultMap.put("ROLE_TYPE", roleId);
		return resultMap;
	}

	/**
	 * @param
	 * @title 确定多级审批流转(继续审批还是审批结束)
	 * @auth
	 */
	public Map getApproveTaskAssign(Map map) throws CommonException{
		Map resultMap = new HashMap();
		String bussType = (String) map.get("BIZCLASS");
		BigDecimal amountTmp = new BigDecimal(map.get("AMOUNT").toString());
		BigDecimal amount = amountTmp.setScale(2, BigDecimal.ROUND_HALF_UP);
		String startbrcode = map.get("STARTBRCODE").toString();
		String piid = (String) map.get("PROC_INS_ID");
		Integer stopId = 0;
		if(map.get("CURR_STOPID")!=null){
			stopId =  new Integer(map.get("CURR_STOPID").toString());
		}
		Integer routeId = null;
		//第一次进入，得到适用的审批路线模板
		if(map.get("ROUTE_ID")==null||( Integer)(map.get("ROUTE_ID"))==0){
			routeId = getWorkflowRouteInfoNew(bussType,amount,startbrcode);
			//插入审批路线实例表
			insertWorkflowInsRoute(piid,routeId);
		}
		else{
			routeId =  new Integer(map.get("ROUTE_ID").toString());
		}

		String manualAssigned = (String) map.get("MANUAL_ASSIGNED");
		//得到操作员列表
		/**mod by abudula at 20101120 STL-94 start 直接使用业务金额与操作员对比*/
		resultMap = getAssignedOprnoList(routeId, stopId, startbrcode, bussType,manualAssigned,piid,amount);
		/* add by kangbyron 2011-2-22 在此基础上增加操作员审批阀值控制 begin */
		List tlrnolist = transArgToList((String[])resultMap.get("OPRNO_ARR"));
		TaskAssignService taskAssignService = TaskAssignService.getInstance();
		String tlrno = taskAssignService.getAssignToTlrnoGZ(tlrnolist, null,
				SystemConstant.TASK_ASSIGN_MODE_1, false, true,map);
		//resultMap.put("OPRNO_ARR", transListToArg(tlrnolist));
		resultMap.put("OPRNO_ARR", new String[]{tlrno});
		/* add by kangbyron 2011-2-22 在此基础上增加操作员审批阀值控制 end */
		/**mod by abudula at 20101120 STL-94 start 直接使用业务金额与操作员对比*/
		resultMap.put("ROUTE_ID", routeId);

		//把分配结果存入全局变量
		GlobalInfo globalData = GlobalInfo.getCurrentInstanceWithoutException();
		if(globalData!=null){
			GlobalInfo.getCurrentInstance().setWorkflowTlrno(transArrayToString((String[]) resultMap.get("OPRNO_ARR")));
		}
		return resultMap;
	}

	/**
	 * @param
	 * @throws CommonException
	 * @title 预检查是否有符合审批路线条件的操作员
	 * @auth
	 */
	public boolean checkRouteHasOpr(Map map) throws CommonException{
		try{
			Map resultMap = new HashMap();
			List oprnolist1 = new ArrayList();//机构+岗位操作员列表
			List oprnolist2 = new ArrayList();//有金额权限的操作员列表
			if(map!=null){
				String bussType = (String) map.get("BUSS_TYPE");
				BigDecimal amountTmp = new BigDecimal(map.get("AMOUNT").toString());
				BigDecimal amount = amountTmp.setScale(2, BigDecimal.ROUND_HALF_UP);
				String startbrcode = map.get("START_BRHID").toString();
				Integer routeId = getWorkflowRouteInfoNew( bussType,  amount, startbrcode);
				List routelist = BaseDAOUtils.getWorkflowRouteParamDAO().queryByCondition(" po.routeId = " + routeId);
				for(int i =0; i<routelist.size();i++){
					WorkflowRouteParam workflowRouteParam = (WorkflowRouteParam) routelist.get(i);
					/**mod by abudula at 20101120 STL-94 start 直接使用业务金额与操作员对比*/
					//amount = workflowRouteParam.getApproveAmt();
					/**mod by abudula at 20101120 STL-94 end*/
					resultMap.put("CURR_STOPID", workflowRouteParam.getStopId());

					//必经站点
					if(workflowRouteParam.getNeed().equals(SystemConstant.FLAG_ON)){
						String  currBrhid = BctlService.getInstance().getUpBrcode(workflowRouteParam.getBrhClass(), startbrcode);
						oprnolist1 = getTlrnolistByBrcodeRole(currBrhid, workflowRouteParam.getRoleId());
						String currBrhno = "";
						//不按金额权限直接找对应机构+岗位的操作员
						if(workflowRouteParam.getAmtType().equals(SystemConstant.FLAG_OFF)){
							resultMap.put("OPRNO_ARR", transListToArg(oprnolist1));
							resultMap.put("CAN_FINAL_APPROVE", SystemConstant.FLAG_ON);
						}
						//按照金额权限，去limit_param中找符合金额权限的操作员
						else{
							oprnolist2 = getOprlistByAmt(oprnolist1,bussType,amount);
							//能找到具有金额权限的操作员
							if(oprnolist2.size()>=1){
								resultMap.put("OPRNO_ARR", transListToArg(oprnolist2));
								resultMap.put("CAN_FINAL_APPROVE", SystemConstant.FLAG_ON);

							}
							//找不到则返回该岗位+机构的操作员
							else{
								System.out.print("----------按金额分配必经岗位未能找到 符合金额权限的操作员-----------");
								resultMap.put("OPRNO_ARR", transListToArg(oprnolist1));
								resultMap.put("CAN_FINAL_APPROVE", SystemConstant.FLAG_OFF);

							}
						}
					}
					//跳过站点直接跳过到下个站点
					else if(workflowRouteParam.getPass().equals(SystemConstant.FLAG_ON)){
						continue;
					}
					//非必经非跳过站点，检查是否适用
					else{
						//Modified by UU_Wu		BMS-2474	2010-2-10	Start
						String  currBrhid = BctlService.getInstance().getUpBrcode(workflowRouteParam.getBrhClass(), startbrcode);
						oprnolist1 = getTlrnolistByBrcodeRole(currBrhid, workflowRouteParam.getRoleId());
						//无需按照金额权限进行分配直接找对应机构+岗位的操作员
						if(workflowRouteParam.getAmtType().equals(SystemConstant.FLAG_OFF)){
							resultMap.put("OPRNO_ARR", transListToArg(oprnolist1));
							resultMap.put("CAN_FINAL_APPROVE", SystemConstant.FLAG_ON);

						}
						//Modified by UU_Wu		BMS-2474	2010-2-10	End
						else{
							oprnolist2 = getOprlistByAmt(oprnolist1,bussType,amount);
							//能够找到则返回
							if(oprnolist2.size()>=1){
								resultMap.put("OPRNO_ARR", transListToArg(oprnolist2));
								resultMap.put("CAN_FINAL_APPROVE", SystemConstant.FLAG_ON);

							}
						}
					}

					//判断是否操作员有终审权
					if(((String)resultMap.get("CAN_FINAL_APPROVE")).equals(SystemConstant.FLAG_ON)){
						return true;
					}else{
						continue;
					}
				}
			}
			else{
				return false ;
			}

		}catch(Exception ex){
			ExceptionUtil.throwCommonException(ex.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_KEEPTASK_ERROR);
		}


		return false;
	}

	/**
	 * @param
	 * @title 判断剩余的审批路线有无必经站点
	 * @auth
	 */
	public boolean hasNeedStop(Integer routeId, Integer stopId) throws CommonException{
		List routeParamlist = BaseDAOUtils.getWorkflowRouteParamDAO()
			.queryByCondition(" po.routeId = ? and po.stopId > ? order by po.stopId",
							new Object[] {routeId,stopId},
							new Type[] {Hibernate.INTEGER,Hibernate.INTEGER});
		for(int i =0; i<routeParamlist.size(); i++){
			WorkflowRouteParam workflowRouteParam = (WorkflowRouteParam) routeParamlist.get(i);
			if(workflowRouteParam.getNeed().equals(SystemConstant.FLAG_ON)){
				return true;
			}
			else{
				continue;
			}

		}
		return false;
	}

	/**
	 * @param
	 * @title 得到topbpm流程定义的任务名
	 * @auth
	 */
	public PageQueryResult queryWorkflowParamAll( WorkflowParamBean inbean) throws CommonException{
		List resultlist = new ArrayList();
		String procName = inbean.getProcName();
		PageQueryResult pageQueryResult = new PageQueryResult();
		TopBPMConfiguration topbpmConfiguration = TopBPMConfiguration.getInstance();
		HQLDAO dao = DAOUtils.getHQLDAO();
		TopBPMContext topBPMContext= topbpmConfiguration.createTopBPMContext();
		topBPMContext.setSession(dao.getHibernateTemplate().getSessionFactory().getCurrentSession());
		ProcessDefinition processDefinition = new ProcessDefinition();
		List proclist = topBPMContext.getGraphSession().findLatestProcessDefinitions();
		processDefinition = topBPMContext.getGraphSession().findLatestProcessDefinition(inbean.getProcName());
		List nodelist = processDefinition.getNodes();
		WorkflowParamBean outbean = null ;
		for(int i =0; i<nodelist.size();i++){
			outbean = new WorkflowParamBean();
			Node node = (Node) nodelist.get(i);
			String nodeName = node.getName();
			String desc = node.getDescription();
			if(nodeName.equals("Start")||nodeName.equals("End")){
				continue;
			}
			else{
				String nodeType = "";
				if(!DataFormat.isEmpty(desc)){
					String[] descArr = desc.split(";");
					//节点类型描述
					nodeType = descArr[0].substring(descArr[0].lastIndexOf("=")+1);

				}
				outbean.setNodeType1(nodeType);
				outbean.setNodeName(nodeName);
				outbean.setProcName(procName);
				List workflowparamList = DAOUtils.getWorkflowParamDAO().queryByCondition(" po.processTemplate = ? and po.taskName = ?",
														new Object[] {procName,nodeName},
														new Type[] {Hibernate.STRING,Hibernate.STRING});
				if(workflowparamList.size()==0){
					resultlist.add(outbean);
				}
				else{
					WorkflowParam workflowParam = null;
					WorkflowParamBean outbean2 = null ;
					for(int j=0;j<workflowparamList.size();j++){
						workflowParam = new WorkflowParam();
						outbean2 = new WorkflowParamBean();
						workflowParam  = (WorkflowParam) workflowparamList.get(j);
						outbean2.setNodeType1(nodeType);
						outbean2.setNodeName(nodeName);
						outbean2.setProcName(procName);
						outbean2.setWorkflowParam(workflowParam);
						resultlist.add(outbean2);
					}
				}


				}
			}
		pageQueryResult.setQueryResult(resultlist);
		pageQueryResult.setTotalCount(resultlist.size());

		return pageQueryResult;
	}

	/**
	 * 保存工作流参数配置
	 *
	 * @param delList
	 * @param insertList
	 * @param updateList
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 *
	 */
	public void saveWorkflowParamEntry(List delList,List insertList,List updateList) throws CommonException, IllegalAccessException, InvocationTargetException{
		WorkflowParamDAO  workflowParamDAO = DAOUtils.getWorkflowParamDAO();

		//新增
		for(Iterator it = insertList.iterator();it.hasNext();)
		{
			WorkflowParamBean insbean =(WorkflowParamBean) it.next();;
			WorkflowParam workflowParam = new WorkflowParam();
			workflowParam = insbean.getWorkflowParam();
			workflowParam.setProcessTemplate(insbean.getProcName());
			workflowParam.setTaskName(insbean.getNodeName());
			workflowParam.setApptype("-");
			workflowParam.setAppTypeName("-");
			workflowParam.setBizSubclass("-");
			workflowParamDAO.insert(workflowParam);
			workflowParamDAO.getHibernateTemplate().flush();

		}
		//修改
		for(Iterator it = updateList.iterator();it.hasNext();)
		{
			WorkflowParamBean updatebean =(WorkflowParamBean) it.next();;
			WorkflowParam workflowParam = new WorkflowParam();
			List list =  workflowParamDAO.queryByCondition(" po.processTemplate = ? and po.taskName = ?",
							new Object[] {updatebean.getProcName(),updatebean.getNodeName()},
							new Type[] {Hibernate.STRING,Hibernate.STRING});
			//正常情况只会找到一条记录
			if(list.size()==1){
				workflowParam = (WorkflowParam) list.get(0);

				Integer id = Integer.valueOf((int)workflowParam.getId());
//				try {
//					BeanUtils.copyProperties(workflowParam, updatebean.getWorkflowParam());
//				} catch (IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					throw e;
//				} catch (InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					throw e;
//				}
//				workflowParam.setId(id);
//				workflowParam.setProcessTemplate(updatebean.getProcName());
//				workflowParam.setTaskName(updatebean.getNodeName());
				workflowParam.setApptype("-");
				workflowParam.setAppTypeName("-");
				workflowParam.setBizSubclass("-");
				workflowParam.setBrclass(updatebean.getWorkflowParam().getBrclass());
				workflowParam.setBrclassName(updatebean.getWorkflowParam().getBrclassName());
				workflowParam.setBizClass(updatebean.getWorkflowParam().getBizClass());
				workflowParam.setBizClassName(updatebean.getWorkflowParam().getBizClassName());
				workflowParam.setAssignType(updatebean.getWorkflowParam().getAssignType());
				workflowParam.setWorkflowRole(updatebean.getWorkflowParam().getWorkflowRole());
				workflowParam.setLimitation(updatebean.getWorkflowParam().getLimitation());
				//workflowParam.setAssignType(assignType)
				workflowParamDAO.update(workflowParam);
			}
			else if(list.size()>1){
				ExceptionUtil.throwCommonException("已存在一条流程为"+ updatebean.getProcName() + "任务为" +
						updatebean.getNodeName() + "业务种类为" + updatebean.getWorkflowParam().getBizClass() + "的记录"
						, ErrorCode.ERROR_CODE_WORKFLOW_PARAM_INSERT);
			}
			//没找到则插入
			else{
				workflowParam = updatebean.getWorkflowParam();
				workflowParam.setApptype("-");
				workflowParam.setAppTypeName("-");
				workflowParam.setBizSubclass("-");
				workflowParam.setProcessTemplate(updatebean.getProcName());
				workflowParam.setTaskName(updatebean.getNodeName());
				workflowParamDAO.insert(workflowParam);
			}



		}
		//删除
		for(Iterator it = delList.iterator();it.hasNext();)
		{
			WorkflowParamBean delbean =(WorkflowParamBean) it.next();;
			WorkflowParam workflowParam = new WorkflowParam();
			List list =  workflowParamDAO.queryByCondition(" po.processTemplate = ? and po.taskName = ? and bussType = ?",
					new Object[] {delbean.getProcName(),delbean.getNodeName(),delbean.getWorkflowParam().getBizClass()},
					new Type[] {Hibernate.STRING,Hibernate.STRING,Hibernate.STRING});
			if(list.size()>0){
				workflowParam = (WorkflowParam) list.get(0);
				try {
					BeanUtils.copyProperties(workflowParam, delbean.getWorkflowParam());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw e;
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw e;
				}
				workflowParam.setProcessTemplate(delbean.getProcName());
				workflowParam.setTaskName(delbean.getNodeName());
				workflowParamDAO.delete(workflowParam);
			}
//			workflowParam = delbean.getWorkflowParam();
//			workflowParam.setProcessTemplate(delbean.getProcName());
//			workflowParam.setTaskName(delbean.getNodeName());
//			workflowParamDAO.delete(workflowParam);
		}
	}

	/**
	 * @param
	 * @throws CommonException
	 * @title 清除某一流程实例的审批路线
	 * @auth
	 */
	public void delWorkflowInsRoute(String piid) throws CommonException{
			WorkflowInsRouteDAO workflowInsRouteDAO = DAOUtils.getWorkflowInsRouteDAO();
			try {
				List insroutelist = workflowInsRouteDAO.queryByCondition(" po.piid = '" +  piid + "'");
				for(int i =0; i<insroutelist.size(); i++){
					WorkflowInsRoute workflowInsRoute = (WorkflowInsRoute) insroutelist.get(i);
					workflowInsRouteDAO.delete(workflowInsRoute);
				}
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
	}
	/** 合并票据工作流到信贷系统 by zhouxuejing 20101026 end*/

	/**
	 * @param piid	流程实例号
	 * @param taskId	任务实例号
	 * @title 得到指定流程实例的所有审批路线节点的人员分配
	 * @auth UU_Wu
	 */
	public List getAllApproveTaskAssignOprList(Map map,String approvePosition) throws CommonException{
		List resultlist =  new ArrayList();

		Integer stopId = (Integer) map.get("CURR_STOPID");
		String bussType = (String) map.get("BIZCLASS");
		BigDecimal amountTmp = new BigDecimal(((Double)map.get("AMOUNT")).toString());
		BigDecimal amount = new BigDecimal(CommonFunctions.formatLoaclAmt2ReqAmt(amountTmp));
		Integer startBrhId = new Integer(map.get("STARTBRCODE").toString());
		String manualAssigned = (String) map.get("MANUAL_ASSIGNED");
		//Integer routeId = new Integer(map.get("ROUTE_ID").toString());
		String piid = (String) map.get("PROC_INS_ID");
		//得到当前流程实例的审批路线实例信息
		List currRouteList = DAOUtils.getWorkflowInsRouteDAO().queryByCondition(" po.piid = '" + piid + "' order by po.stopId");

		WorkflowInsRoute workflowInsRoute = null;
		for(int i = 0; i < currRouteList.size(); i++){
			workflowInsRoute = new WorkflowInsRoute();
			workflowInsRoute = (WorkflowInsRoute) currRouteList.get(i);
			Map resultMap  = getAssignedOprnoList(workflowInsRoute.getRouteId(), workflowInsRoute.getStopId(), startBrhId.toString(), bussType,manualAssigned,piid,amount);
			WorkFlowAssignedOprBean workFlowAssignedOprBean = new WorkFlowAssignedOprBean();
			workFlowAssignedOprBean.setCurrStopId(resultMap.get("CURR_STOPID").toString());
			//workFlowAssignedOprBean.setNowStopId(stopId.toString());
			workFlowAssignedOprBean.setOprId((String[]) resultMap.get("OPRNO_ARR"));
			workFlowAssignedOprBean.setPiid(piid);
			workFlowAssignedOprBean.setRouteId(workflowInsRoute.getRouteId().toString());
			String position = "";

			//审批节点在当前节点之前
			if(approvePosition.equals("1")){
				position = "1"; //之前
			}
			//当前节点为审批节点
			else if(approvePosition.equals("2")){
				if(workflowInsRoute.getStopId().compareTo(stopId) == 0){
					position = "2"; //当前
				}else if(workflowInsRoute.getStopId().compareTo(stopId) < 0){
					position = "1"; //之前
				}else{
					position = "3"; //之后
				}
			}
			//审批节点在当前节点之后
			else{
				position = "3"; //之后
			}

			workFlowAssignedOprBean.setPosition(position);
			resultlist.add(workFlowAssignedOprBean);
		}

		return resultlist;
	}


	/**
	 * @param piid	流程实例号
	 * @param taskId	任务实例号
	 * @title 得到指定流程实例的所有一般节点的人员分配
	 * @auth UU_Wu
	 */
	public List getAllCommonTaskAssignOprList(Map map,int currTaskIndex,List hashedWorkflowParamList) throws CommonException{
		List resultlist =  new ArrayList();

		String piid = (String) map.get("PROC_INS_ID");

//		List hashedWorkflowParamList = new ArrayList();//有顺序的流程参数设置list
		for(int i = 0; i < hashedWorkflowParamList.size(); i++){
			WorkflowParam workflowParam = (WorkflowParam) hashedWorkflowParamList.get(i);
			String position = "";//该节点是否在当前节点后
			//判断节点是否为审批节点（使用审批路线作为任务分配原则的节点）
			if(workflowParam.getTaskName().equals("Approve")){
				continue;
			}else{
				Map resultMap = getCommonTaskAssign(map);
				WorkFlowAssignedOprBean workFlowAssignedOprBean = new WorkFlowAssignedOprBean();
				workFlowAssignedOprBean.setCurrStopId("0");
				workFlowAssignedOprBean.setNowStopId("0");
				workFlowAssignedOprBean.setOprId((String[]) resultMap.get("OPRNO_ARR"));
				workFlowAssignedOprBean.setPiid(piid);
				workFlowAssignedOprBean.setRouteId("0");

				if(i < currTaskIndex){
					position = "1";
				}else if(i == currTaskIndex){
					position = "2";
				}else{
					position = "3";
				}
				workFlowAssignedOprBean.setPosition(position);
				resultlist.add(workFlowAssignedOprBean);
			}
		}

		return resultlist;
	}


	/**
	 * @param piid	流程实例号
	 * @param taskId	任务实例号
	 * @title 得到指定流程实例的所有人员分配
	 * @auth UU_Wu
	 */
	public List getAllTaskAssignOprList(String taskId) throws CommonException{
		List resultlist =  new ArrayList();
		//得到当前任务实例对应的流程变量
		Map map = WorkFlowService.getInstance().getTaskValue(taskId);
		String currNodeName = (String)map.get("TASK_NAME");
		String procName =(String)map.get("PROC_NAME");
		int currTaskIndex = 0;
		int approveTaskIndex = 0;
		String approvePosition = "";//审批节点对于当前节点的顺序（1-之前，2-当前，3-之后）
		//有顺序的流程参数设置list
		List hashedWorkflowParamList = getSortedWorkflowParam(procName);
		for(int i = 0; i < hashedWorkflowParamList.size(); i++){
			WorkflowParam workflowParam = (WorkflowParam)hashedWorkflowParamList.get(i);
			if(workflowParam.getTaskName().equals(currNodeName)){
				currTaskIndex = i;
			}
			if(workflowParam.getTaskName().equals("Approve")){
				approveTaskIndex = i;
			}
			if(approveTaskIndex < currTaskIndex){
				approvePosition = "1";
			}else if(approveTaskIndex == currTaskIndex){
				approvePosition = "2";
			}else{
				approvePosition = "3";
			}
		}
		List approveOprList = getAllApproveTaskAssignOprList(map,approvePosition);
		List commonOprList = getAllCommonTaskAssignOprList(map,currTaskIndex,hashedWorkflowParamList);
		int index =0;//判断审批节点所在的位置
		for(int j = 0; j < commonOprList.size(); j++){
			WorkFlowAssignedOprBean workFlowAssignedOprBean = (WorkFlowAssignedOprBean)commonOprList.get(j);
			if(workFlowAssignedOprBean.getPosition().equals("3")){
				index = j;
			}
		}
		resultlist = commonOprList;
		resultlist.add(index, approveOprList);
		return resultlist;
	}

	private List getSortedWorkflowParam(String procName) throws CommonException{
		List list = new ArrayList();
		String taskNameStr = "Upload,Approve,Insure";
		String[] taskNames = taskNameStr.split("\\,");
		for(int i = 0; i < taskNames.length; i++){
			String taskName = taskNames[i];
			List workflowparamList = BaseDAOUtils.getWorkflowParamDAO().queryByCondition("po.processTemplate ='" + procName + "' and taskName = '" + taskName + "'");
			if(workflowparamList != null && workflowparamList.size() > 0){
				list.add(workflowparamList.get(0));
			}
		}
		return list;
	}
	/**
	 * 获得所有流程模板
	 */
	public PageQueryResult queryWorkflowParamListAll() throws CommonException{
		List resultlist = new ArrayList();
		String procName = "";
		PageQueryResult pageQueryResult = new PageQueryResult();
		TopBPMConfiguration topbpmConfiguration = TopBPMConfiguration.getInstance();
		HQLDAO dao = DAOUtils.getHQLDAO();
		TopBPMContext topBPMContext= topbpmConfiguration.createTopBPMContext();
		topBPMContext.setSession(dao.getHibernateTemplate().getSessionFactory().getCurrentSession());
		ProcessDefinition processDefinition = new ProcessDefinition();
		List proclist = topBPMContext.getGraphSession().findLatestProcessDefinitions();
		Iterator iter = proclist.iterator();
		while(iter.hasNext()){
			processDefinition = (ProcessDefinition)iter.next();
			procName = processDefinition.getName();
			List nodelist = processDefinition.getNodes();
			WorkflowParamBean outbean = null ;
			for(int i =0; i<nodelist.size();i++){
				outbean = new WorkflowParamBean();
				Node node = (Node) nodelist.get(i);
				String nodeName = node.getName();
				String desc = node.getDescription();
				if(nodeName.equals("Start")||nodeName.equals("End")){
					continue;
				}
				else{
					String nodeType = "";
					if(!DataFormat.isEmpty(desc)){
						String[] descArr = desc.split(";");
						//节点类型描述
						nodeType = descArr[0].substring(descArr[0].lastIndexOf("=")+1);

					}
					outbean.setNodeType1(nodeType);
					outbean.setNodeName(nodeName);
					outbean.setProcName(procName);
					outbean.setSelected(false);

					List workflowparamList = DAOUtils.getWorkflowParamDAO().queryByCondition(" po.processTemplate = ? and po.taskName = ?",
															new Object[] {procName,nodeName},
															new Type[] {Hibernate.STRING,Hibernate.STRING});
					if(workflowparamList.size()==0){
						resultlist.add(outbean);
					}
					else{
						WorkflowParam workflowParam = null;
						WorkflowParamBean outbean2 = null ;
						for(int j=0;j<workflowparamList.size();j++){
							workflowParam = new WorkflowParam();
							outbean2 = new WorkflowParamBean();
							workflowParam  = (WorkflowParam) workflowparamList.get(j);
							outbean2.setNodeType1(nodeType);
							outbean2.setNodeName(nodeName);
							outbean2.setProcName(procName);
							outbean2.setWorkflowParam(workflowParam);

							outbean2.setSelected(false);

							resultlist.add(outbean2);
						}
					}


					}
				}
		}
		pageQueryResult.setQueryResult(resultlist);
		pageQueryResult.setTotalCount(resultlist.size());

		return pageQueryResult;
	}
}
