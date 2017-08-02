package com.huateng.ebank.business.datadic.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.pub.DataDic;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.datadic.service.DataDicService;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 操作员管理中,查询后获得操作员对应岗位
 *
 * @author hyurain_yang
 *
 */
public class DataDicInfoGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			List list = getData();
			
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list,
					getResult());
			result.setContent(list);
			result.getPage().setTotalPage(list.size());
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}

	private List getData() throws Exception {
		List list = new ArrayList();
		String id = getCommQueryServletRequest().getParameter("id");
		String op = getCommQueryServletRequest().getParameter("op");
		DataDicService service = new DataDicService();
		if ("new".equals(op)) {
			
		} else if ("copynew".equals(op)) {
			DataDic dd = new DataDic();
			String dataTypeNo = getCommQueryServletRequest().getParameter("dataTypeNoCopy");
			String dataTypeName = getCommQueryServletRequest().getParameter("dataTypeName");
			String dataNoLen = getCommQueryServletRequest().getParameter("dataNoLen");
			if (StringUtils.isNotBlank(dataTypeNo)) {
				dd.setDataTypeNo(Integer.valueOf(dataTypeNo));
			}
			if (StringUtils.isNotBlank(dataTypeName)) {
				dd.setDataTypeName(dataTypeName);
			}
			if (StringUtils.isNotBlank(dataNoLen)) {
				dd.setDataNoLen(Integer.valueOf(dataNoLen));
			}
			list.add(dd);
		}else if ("mod".equals(op)) {
			list.add(service.load(Integer.valueOf(id)));
		}
		return list;
	}

}
