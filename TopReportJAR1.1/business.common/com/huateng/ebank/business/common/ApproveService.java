
package com.huateng.ebank.business.common;

import java.util.ArrayList;
import java.util.List;

import resource.bean.pub.RoleInfo;
import resource.bean.pub.TlrInfo;

import com.huateng.ebank.business.common.service.DataDicService;
import com.huateng.ebank.entity.dao.flowManagement.ApplydtlDAO;
import com.huateng.ebank.entity.data.flowManagement.Applydtl;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * @author valley
 * @date 2005-6-8
 * @desc 审批时公用Service
 */
public class ApproveService {


    protected ApproveService() {
    }

    public synchronized static ApproveService getInstance() {
    	return (ApproveService)ApplicationContextUtils.getBean("ApproveService");
    }

    /**
     * 查询审批历史意见
     *
     * @param appno
     * @return 包含HistoryAppInfo的List
     * @throws CommonException
     */
    public List queryHistoryAppInfo(String appno) throws CommonException {
        List list = new ArrayList();

        DataDicService ds = DataDicService.getInstance();
        ApplydtlDAO applydtlDAO = BaseDAOUtils.getApplydtlDAO();

        List applydtlList = applydtlDAO.queryByCondition(" tpci.appno = '" + appno
        		+ "' order by tpci.txnDate, tpci.timestamps, tpci.id");

        for (int i = 0; i < applydtlList.size(); i++) {
            Applydtl applydtl = (Applydtl) applydtlList.get(i);

            com.huateng.ebank.business.common.HistoryAppInfo historyAppInfo = new com.huateng.ebank.business.common.HistoryAppInfo();
            historyAppInfo.setTxdate(applydtl.getTxnDate());
            if(applydtl.getTimestamps()!=null)
            historyAppInfo.setTxtime(applydtl.getTimestamps().toString().substring(0,19));
            historyAppInfo.setTlrno(applydtl.getApprover());
            if(!DataFormat.isEmpty(applydtl.getApprover())){
            	try {
					TlrInfo info = BaseDAOUtils.getTlrInfoDAO().query(applydtl.getApprover());
					historyAppInfo.setName(info.getTlrName());
				} catch (Exception e) {
					// TODO: handle exception
				}
            }
            if(applydtl.getRoleId()!=null && applydtl.getRoleId()!=0){
            	try {
					RoleInfo role =BaseDAOUtils.getRoleInfoDAO().query(applydtl.getRoleId());
					historyAppInfo.setPost(role.getRoleName());
				} catch (Exception e) {
					// TODO: handle exception
				}
            }

//            historyAppInfo.setAttitude(ds.getNameByTypeNo(
//                    SystemConstant.DATADIC_TYPE_ATTITUDE_JZ_ALL, applydtl
//                            .getAttitude()));
            historyAppInfo.setAttitude(applydtl.getAttitude());
            historyAppInfo.setReason(applydtl.getReason());
            historyAppInfo.setMisc(applydtl.getMisc());

            /*added by shaoguangyu 2010-10-9 START*/
//            if(SystemConstant.ROLE_CUST_ZONGJINGLI == applydtl.getRoleId() && SystemConstant.APP_ATTITUDE_AGREE_TO_NEXT.equals(applydtl.getAttitude())) {
//
//            	historyAppInfo.setAttitude(ds.getNameByTypeNo(SystemConstant.DATADIC_TYPE_ATTITUDE_JZ_ALL, SystemConstant.APP_ATTITUDE_AGREE_TO_END));
//            }
            /*END*/
            list.add(historyAppInfo);
        }

        return list;
    }

//    /**
//     * 查询合作项目审批历史意见
//     *
//     * @param projectno
//     * @return 包含HistoryAppInfo的List
//     * @throws CommonException
//     */
//    public List queryProjectHistoryAppInfo(String projectno)
//            throws CommonException {
//        List list = new ArrayList();
//
//        DataDicService ds = DataDicService.getInstance();
//        TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
//        RoleInfoDAO roleInfoDAO = DAOUtils.getRoleInfoDAO();
//        ApplydtlDAO applydtlDAO = DAOUtils.getApplydtlDAO();
//
//        List applydtlList = applydtlDAO.queryByCondition("po.contractno = '"
//                + projectno + "' and po.apptype = '"
//                + SystemConstant.APPLY_TYPE_PROJECT_APPLY + "' order by po.txdate, po.txtime,po.id");
//
//        for (int i = 0; i < applydtlList.size(); i++) {
//            Applydtl applydtl = (Applydtl) applydtlList.get(i);
//            TlrInfo tlrInfo = tlrInfoDAO.query(applydtl.getTlrno());
//            RoleInfo roleInfo = roleInfoDAO.query(applydtl.getRoleId());
//
//            HistoryAppInfo historyAppInfo = new HistoryAppInfo();
//            historyAppInfo.setTxdate(applydtl.getTxdate());
//            historyAppInfo.setTxtime(applydtl.getTxtime());
//            historyAppInfo.setTlrno(applydtl.getTlrno());
//            historyAppInfo.setName(tlrInfo.getTlrnoName());
//            historyAppInfo.setPost(roleInfo.getRoleName());
//            historyAppInfo.setAttitude(ds.getNameByTypeNo(
//                    SystemConstant.DATADIC_TYPE_ATTITUDE_JZ_ALL, applydtl
//                            .getAttitude()));
//            historyAppInfo.setReason(applydtl.getReason());
//            historyAppInfo.setMisc(applydtl.getMisc());
//            list.add(historyAppInfo);
//        }
//
//        return list;
//    }
//
//    /**
//     * 查询贷款审批历史意见
//     *
//     * @param contractno
//     * @return 包含HistoryAppInfo的List
//     * @throws CommonException
//     */
//    public List queryLoanHistoryAppInfo(String contractno)
//            throws CommonException {
//        List list = new ArrayList();
//
//        DataDicService ds = DataDicService.getInstance();
//        TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
//        RoleInfoDAO roleInfoDAO = DAOUtils.getRoleInfoDAO();
//        ApplydtlDAO applydtlDAO = DAOUtils.getApplydtlDAO();
//
//        Loaninfo loaninfo = DAOUtils.getLoaninfoDAO().query(contractno);
//        if (loaninfo.getNature().equals(SystemConstant.LOAN_NATURE_COMB)
//                && loaninfo.getLntype()
//                        .equals(SystemConstant.LNTYPE_ACCUM_FUND))
//            contractno = loaninfo.getCocontractno();
//
//        List applydtlList = applydtlDAO.queryByCondition("po.contractno = '"
//                + contractno + "' and po.apptype in ('"
//                + SystemConstant.APPLY_TYPE_NORMAL_LOAN + "', '"
//                + SystemConstant.APPLY_TYPE_COMBINATION_LOAN + "', '"
//                + SystemConstant.APPLY_TYPE_ADDITION_LOAN + "', '"
//                + SystemConstant.APPLY_TYPE_TRANSFER_LOAN + "', '"
//                + SystemConstant.APPLY_TYPE_CREDIT_APPLY + "', '"
//                + SystemConstant.APPLY_TYPE_LOAN_CARD_APPLY + "') order by po.txdate, po.txtime, po.timestamps");
//
//        for (int i = 0; i < applydtlList.size(); i++) {
//            Applydtl applydtl = (Applydtl) applydtlList.get(i);
//            TlrInfo tlrInfo = tlrInfoDAO.query(applydtl.getTlrno());
//            RoleInfo roleInfo = roleInfoDAO.query(applydtl.getRoleId());
//
//            HistoryAppInfo historyAppInfo = new HistoryAppInfo();
//            historyAppInfo.setTxdate(applydtl.getTxdate());
//            historyAppInfo.setTxtime(applydtl.getTxtime());
//            historyAppInfo.setTlrno(applydtl.getTlrno());
//            historyAppInfo.setName(tlrInfo.getTlrnoName());
//            historyAppInfo.setPost(roleInfo.getRoleName());
//            historyAppInfo.setAttitude(applydtl
//                            .getAttitude());
//            historyAppInfo.setReason(applydtl.getReason());
//            historyAppInfo.setMisc(applydtl.getMisc());
//            list.add(historyAppInfo);
//        }
//
//        return list;
//    }
//
//    /**
//     * 审批退回时更新审批历史意见的退回标志
//     * @param appno 申请编号
//     * @throws CommonException
//     */
//    //退回标志 不存在了
//    /*public void updateHistoryWhenUntread(String appno) throws CommonException {
//        ApplydtlDAO dao = DAOUtils.getApplydtlDAO();
//        List list = dao.queryByCondition("po.appno = '" + appno
//                + "' and po.untread <> '" + SystemConstant.APPLYDTL_UNTREAD_YES
//                + "'");
//        for (int i = 0; i < list.size(); i++) {
//            Applydtl po = (Applydtl) list.get(i);
//            if (DataFormat.isEmpty(po.getUntread()))
//                po.setUntread(SystemConstant.APPLYDTL_UNTREAD_NO);
//            if (po.getUntread().equals(SystemConstant.APPLYDTL_UNTREAD_LAST))
//                po.setUntread(SystemConstant.APPLYDTL_UNTREAD_YES);
//            else if (po.getUntread().equals(SystemConstant.APPLYDTL_UNTREAD_NO))
//                po.setUntread(SystemConstant.APPLYDTL_UNTREAD_LAST);
//            dao.update(po);
//        }
//    }*/
//
//    /**
//     * 更新支行个贷业务统计表的申请、拒绝、放款笔数和金额
//     * @param brcode
//     * @param lntype
//     * @param totamt
//     * @param operation 0-申请 1-放款 2-拒绝
//     * @throws CommonException
//     */
//    public void updateBranchLoanStat(String brcode, String lntype,
//            double totamt, String operation) throws CommonException {
//        String reportDate = DataFormat.dateToNumber(
//                GlobalInfo.getCurrentInstance().getTxdate()).substring(0, 6);
//        BranchLoanStatDAO dao = DAOUtils.getBranchLoanStatDAO();
//        BranchLoanStat po = dao.query(reportDate, brcode, lntype);
//        if (po == null) {
//            po = new BranchLoanStat();
//            po.setReportDate(reportDate);
//            po.setBrcode(brcode);
//            po.setLntype(lntype);
//            if (operation.equals(SystemConstant.FLOW_STATUS_APPROVING)) {
//                po.setApplyCount(1);
//                po.setApplyAmt(totamt);
//            } else if (operation.equals(SystemConstant.FLOW_STATUS_FINISH)) {
//                po.setGrantCount(1);
//                po.setGrantAmt(totamt);
//            } else if (operation.equals(SystemConstant.FLOW_STATUS_REJECT)) {
//                po.setRejectCount(1);
//                po.setRejectAmt(totamt);
//            }
//
//            dao.insert(po);
//        } else {
//            if (operation.equals(SystemConstant.FLOW_STATUS_APPROVING)) {
//                po.setApplyCount(po.getApplyCount() + 1);
//                po.setApplyAmt(po.getApplyAmt() + totamt);
//            } else if (operation.equals(SystemConstant.FLOW_STATUS_FINISH)) {
//                po.setGrantCount(po.getGrantCount() + 1);
//                po.setGrantAmt(po.getGrantAmt() + totamt);
//            } else if (operation.equals(SystemConstant.FLOW_STATUS_REJECT)) {
//                po.setRejectCount(po.getRejectCount() + 1);
//                po.setRejectAmt(po.getRejectAmt() + totamt);
//            }
//
//            dao.update(po);
//        }
//    }
}
