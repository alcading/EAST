/**
 *
 */
package com.huateng.ebank.business.common.generator;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.dao.mng.SeqctlDAO;
import com.huateng.ebank.entity.data.mng.Seqctl;
import com.huateng.ebank.framework.exceptions.CommonException;

/**
 * Title: GetCoreReqSeqGenerator Description: 核心交易请求流水生成器 Copyright: Copyright
 * (c) 2008 Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetCoreReqSeqGenerator extends BaseGenerator {
	// 起始号
	private int beginNo = 0;
	// 结束号
	private int endNo = 0;

	/*
	 * 获取一个号段，供并发使用，当号段用完时，通过getSeqNo申请
	 *
	 * @see com.huateng.commquery.cfieldmodel.BaseGenerator#gen(java.util.Map)
	 */

	public synchronized String gen(Object paramMap)
			throws CommonException {
		int seqNo = 0;
		if (beginNo == endNo) {
			getSeqNo();
		}
		seqNo = beginNo;
		beginNo++;
		return String.valueOf(seqNo);
	}

	/**
	 * 获取流水号段
	 *
	 * @return
	 * @throws CommonException
	 */
	private synchronized int getSeqNo() throws CommonException {
		int valueNo = SystemConstant.VALUE_NO_CORESYS;
		String valueIndex = SystemConstant.VALUE_INDEX;
		// TODO Auto-generated method stub
		int seqNo = 0; // 取出的序号
		int seqRange = 100; //号段范围，可通过配置获取
		// 根据输入的机构号，序号种类，序号索引得到当前使用的序号。
		SeqctlDAO dao = BaseDAOUtils.getSeqctlDAO();
		Seqctl po = dao.query(valueNo, valueIndex);
		if (po != null) {
			// 如果存在该序号记录，则取出当前序号并将序号加1
			seqNo = po.getValueCurr();
			po.setValueCurr(seqNo + seqRange); // 序号加1
			//设置起始和结束号段
			beginNo = seqNo;
			endNo = beginNo + seqRange - 1;
			//
			if (po.getValueCurr() > po.getMaxValue()){
				po.setValueCurr(po.getMinValue() + seqRange);
				beginNo = po.getMinValue();
				endNo = beginNo + seqRange - 1;
			}
			dao.update(po); // 修改记录到数据库
			System.out.println("update seqctl beginNo = " + beginNo + " : endNo = " + endNo);
		} else {
			// 如果不存在这样一条记录，那么根据序号种类、序号索引查询对应的序号定义记录，得到默认的最大值和最小值
			// 然后根据当前序号种类、序号索引插入一条新记录，返回序号下限，序号加1
			Seqctl headPo = new Seqctl();
			headPo = dao.query(valueNo, SystemConstant.VALUE_INDEX);

			// 取得当前序号
			seqNo = headPo.getMinValue();
			beginNo = seqNo;
			endNo = beginNo + seqRange - 1;
			// 插入记录
			po = new Seqctl();
			po.setValueNo(valueNo);
			po.setValueIndex(valueIndex);
			po.setMaxValue(headPo.getMaxValue());
			po.setMinValue(headPo.getMinValue());
			po.setValueCurr(beginNo + seqRange);
			dao.insert(po);
		}
		return seqNo;
	}

}
