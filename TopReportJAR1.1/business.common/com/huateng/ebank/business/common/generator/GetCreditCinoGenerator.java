/**
 *
 */
package com.huateng.ebank.business.common.generator;

import java.util.Iterator;
import java.util.Map;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * Title: GetCreditCinoGenerator
 * Description:授信贷款借据号生成器
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetCreditCinoGenerator extends BaseGenerator {

	@Override
	public String gen(Object paramMap) throws CommonException {
		String contractno = (String)((Map) paramMap).get("contractno");
		int seqno = ((Integer)((Map) paramMap).get("seqno")).intValue();
		if (seqno > 99) {
			ExceptionUtil.throwCommonException("同一笔合同下借据数不能超过99笔",
					ErrorCode.ERROR_CODE_GEN_CINO_ERROR);
		}
		Double objLocker = 0.00; //20090327 加锁保护
		synchronized (objLocker) {
			String tempContractno = contractno.substring(0,
					SystemConstant.CONTRACTNO_LENGTH);

			Iterator it = DAOUtils.getHQLDAO().queryByQL(
					"select po.cino from Loancino po where po.cino like '"
							+ tempContractno + "%' order by substring(po.cino, "
							+ (SystemConstant.CONTRACTNO_LENGTH + 1) + ", 4) desc");
			if (it.hasNext()) {
				int maxSeqno = Integer.parseInt(((String) it.next())
						.substring(SystemConstant.CONTRACTNO_LENGTH).trim());
				return tempContractno + DataFormat.intToString(maxSeqno + 1, 4);
			} else {
				return tempContractno + DataFormat.intToString(seqno, 4);
			}
		}
	}
}
