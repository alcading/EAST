package com.huateng.ebank.business.common.service;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

import com.huateng.common.DateUtil;
import com.huateng.ebank.business.common.BaseGlobalData;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.entity.dao.mng.TblBizLogDAO;
import com.huateng.ebank.entity.data.mng.TblCsBizLog;
/**
 * 写日志任务具体线程
 * @author abudula add at 2010-08-20
 * @version 1.0
 */
public class BizLogTask implements Runnable,Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 *  全局变量
	 */
	private BaseGlobalData globalInfo ;
	/**
	 *  具体日志信息
	 */
	private String s;

	private String txnLogFlag;

	private String uuId;

	private String oprTxnCd;

	private String sequence;

	private static final Logger logger = Logger.getLogger(BizLogTask.class);

	BizLogTask(BaseGlobalData globalInfo,String s,String txnLogFlag,String uuId,String oprTxnCd,String sequence){

    	this.globalInfo= globalInfo;
    	this.txnLogFlag = txnLogFlag;
    	this.oprTxnCd = oprTxnCd;
    	this.uuId = uuId;
    	this.s = s;
    	this.sequence = sequence;

    }

    public void run(){

    try {
    	 String funcLogFlag = globalInfo.getFuncIdLogFlag();
    	 if(funcLogFlag!=null&&!funcLogFlag.equals("")){
		 if(txnLogFlag!=null && txnLogFlag.equals("true")&&funcLogFlag.equals("true")){
			 if (logger.isDebugEnabled()) {
    					logger.debug("BizLogTask  - start"); //$NON-NLS-1$
    			 }
		    		 TblBizLogDAO  tblBizLogDAO = DAOUtils.getTblBizLogDAO();
			    	 TblCsBizLog bizLog = new TblCsBizLog();
//			    	 UUID uid = UUID.randomUUID();
			    	 bizLog.setId(sequence);
			    	 //日志uuid
			    	 bizLog.setLogId(uuId);
			         //交易日期
			    	 bizLog.setTxnDate(DateUtil.dateToNumber(globalInfo.getTxnDate()));
			    	 //开始时间
			    	 bizLog.setTxnStartTime(DateUtil.onlyTimeToString(globalInfo.getTxnStartTime()));
			    	 Date endTime= new Date();
			    	 String endTimeString = DateUtil.onlyTimeToString(endTime);
			    	 //结束时间
			    	 bizLog.setTxnEndTime(endTimeString);
			    	 //时间
			    	// private java.lang.Long txnRunTime;
			    	 bizLog.setTxnRunTime(com.huateng.common.DateUtil.comparaTime(globalInfo.getTxnStartTime(),endTime));
			    	 //机构号
			    	 bizLog.setBrCode(globalInfo.getBrcode());
			    	 //操作员
			    	 bizLog.setOprCode(globalInfo.getTlrno());
			    	 //ip地址
			    	 bizLog.setIpAdr(globalInfo.getIp());
			    	 //funcid
			    	 bizLog.setFuncId(globalInfo.getFuncId());
			    	 bizLog.setOprTxnCd(oprTxnCd);
			    	 String[] txnDesc= getSubString(s,2048);
			    	 bizLog.setTxnBizLog1(txnDesc[0]);
			    	 bizLog.setTxnBizLog2(txnDesc[1]);
			    	 bizLog.setTxnStatus(globalInfo.getTxnStatus());
			    	 if(globalInfo.getTxnStatus()!=null&&!globalInfo.getTxnStatus().equals(BaseGlobalData.TXN_STATUS_02_S)){
			    		bizLog.setTxnFailLog(getSubString(globalInfo.getTxnFailLog(),2048)[0]);
			    	 }
			         tblBizLogDAO.insert(bizLog);

	         if (logger.isDebugEnabled()) {
 					logger.debug("BizLogTask  - end"); //$NON-NLS-1$
	         }

   			}
    	}
    	} catch (Exception e) {
    		e.printStackTrace();
			logger.error("BizLogTask 插入操作员日志信息失败 ",e); //$NON-NLS-1$

        }

    }

    /**
     * 截取包含中文的字符串，放回一个数组 只包0-limitLen,limitLen-最后
     * @param str
     * @param limitLen
     * @return abudula
     */
    public String[] getSubString(String str,int limitLen)
	{
		if(str == null || str.equals("")){
			return new String[]{"",""};
		}
		String sub = null;
		String[] sub1 = new String[2];
		int len = str.length();
		if(limitLen>len){
			sub1[0]=str;
			return  sub1;
		}
		byte[] bytes = str.getBytes();
		int num=0;
		for(int i=0;i<bytes.length;i++){
			if(bytes[i]<0)
				num+=2;
			else
				num++;

			if(num >= limitLen)
				break;
		}

		if(num > limitLen){
			num-=2;
		}

		sub = new String(bytes,0,num);
		sub1[0]=sub;
		if(str.length()-1<4091){
			sub = new String(bytes,num,str.length()-1);}
		else{
			sub = new String(bytes,num,4901);
		}
		sub1[1]=sub;
		return sub1;
	}

}
