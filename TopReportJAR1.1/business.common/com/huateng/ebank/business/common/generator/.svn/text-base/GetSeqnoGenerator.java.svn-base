/**
 *
 */
package com.huateng.ebank.business.common.generator;

import java.util.HashMap;
import java.util.Map;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.dao.mng.SeqctlDAO;
import com.huateng.ebank.entity.data.mng.Seqctl;
import com.huateng.ebank.framework.exceptions.CommonException;

/**
 * Title: GetSeqnoGenerator
 * Description:
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetSeqnoGenerator extends BaseGenerator {
	private Map seqnoMap = new HashMap();

	/**
	 * 得到序号
	 * @param valueNo
	 * @param valueIndex
	 * @return
	 * @throws CommonException
	 */
	@Override
	public String gen(Object paramMap) throws CommonException {
		int valueNo = ((Integer)((Map)paramMap).get("valueNo")).intValue();
		String valueIndex = (String)((Map)paramMap).get("valueIndex");
		// TODO Auto-generated method stub
		int seqNo = 1; // 取出的序号

		// 构造key值.
		StringBuffer sb = new StringBuffer();
		sb.append(valueNo).append("-").append(valueIndex);
		String key = sb.toString();

		// 根据key值获得对应的锁.
		Object objLocker = null;
		synchronized (seqnoMap) {
			objLocker = seqnoMap.get(key);
			if (null == objLocker) {
				objLocker = new Object();
				seqnoMap.put(key, objLocker);
			}
		}

		// 进行加锁保护.
		synchronized (objLocker) {
			// 根据输入的机构号，序号种类，序号索引得到当前使用的序号。
			SeqctlDAO dao = BaseDAOUtils.getSeqctlDAO();
			Seqctl po = dao.query(valueNo, valueIndex);
			if (po != null) {
				// 如果存在该序号记录，则取出当前序号并将序号加1
				seqNo = po.getValueCurr().intValue();
				po.setValueCurr( new Integer(po.getValueCurr().intValue() + 1) ); // 序号加1
				if (po.getValueCurr().intValue() > po.getMaxValue().intValue())
					po.setValueCurr(po.getMinValue());
				dao.update(po); // 修改记录到数据库
			} else {
				// 如果不存在这样一条记录，那么根据序号种类、序号索引查询对应的序号定义记录，得到默认的最大值和最小值
				// 然后根据当前序号种类、序号索引插入一条新记录，返回序号下限，序号加1
				Seqctl headPo = new Seqctl();
				headPo = dao.query(valueNo, SystemConstant.VALUE_INDEX);
				po = new Seqctl();

				if(headPo == null){
					po.setValueNo( new Integer(valueNo) );
					po.setValueIndex(valueIndex);
					po.setMaxValue(999999999);
					po.setMinValue(1);
					po.setValueCurr(seqNo+1);
				}else{
					// 取得当前序号
					seqNo = headPo.getMinValue().intValue();
					po.setValueNo( new Integer(valueNo) );
					po.setValueIndex(valueIndex);
					po.setMaxValue(headPo.getMaxValue());
					po.setMinValue(headPo.getMinValue());
					po.setValueCurr( new Integer(headPo.getMinValue().intValue() + 1) );
				}

				dao.insert(po);
			}
		}
		return String.valueOf(seqNo);
	}

}
