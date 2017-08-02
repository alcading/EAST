package com.huateng.report.common.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.bean.SubFileChangeDateBean;

public class SubFileChangeFileDateGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			List list=new ArrayList();

			String fileDate = GlobalInfo.getCurrentInstance().getFileDate();
			SubFileChangeDateBean bean = new SubFileChangeDateBean(fileDate,fileDate);
			list.add(bean);

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(),list, getResult());
			getResult().setContent(list);
			getResult().getPage().setTotalPage(1);
			getResult().init();
			return getResult();
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
