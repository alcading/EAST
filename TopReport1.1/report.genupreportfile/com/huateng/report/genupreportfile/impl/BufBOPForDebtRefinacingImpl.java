package com.huateng.report.genupreportfile.impl;

import java.util.List;
import java.util.Map;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGetSubFileList;

public class BufBOPForDebtRefinacingImpl implements IGetSubFileList {

	@SuppressWarnings("unchecked")
	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		BufBOPForDebtOverseaLendingImpl impl = new BufBOPForDebtOverseaLendingImpl();
		return impl.getSubFileResultList(paramMap);
	}
}