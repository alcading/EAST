package com.huateng.report.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resource.bean.report.BiBopjshRetNo;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.common.bean.ReportBopAndJshRetNoBean;
import com.huateng.report.common.service.ReportCommonService;

public class ReportBopJshRetNoUtil {
	public static Map<String, ReportBopAndJshRetNoBean> RET_NO_MAP;

	/**
	 * 加载国际收支申报号码生成规则
	 * @throws CommonException
	 */
	public static Map<String, ReportBopAndJshRetNoBean> getReportBopJshMap() throws CommonException {
		if (RET_NO_MAP == null || RET_NO_MAP.size()==0) {
			RET_NO_MAP = new HashMap<String, ReportBopAndJshRetNoBean>();
			List list = ReportCommonService.getInstance().getReportBopJshList();
			for (int i = 0; i < list.size(); i++) {
				BiBopjshRetNo retNo = (BiBopjshRetNo) list.get(i);
				ReportBopAndJshRetNoBean bean = new ReportBopAndJshRetNoBean();
				bean.setAppType(retNo.getId().getAppType());
				bean.setFileType(retNo.getId().getFileType());
				bean.setDistCusType(ReportEnum.REPORT_IS_STR.YES.value.equals(retNo.getDistCusType()));
				String cusTypes = retNo.getCusTypes();
				if (cusTypes != null && cusTypes.length() > 0) {
					if (bean.isDistCusType()) {
						String[] strs = cusTypes.split(";");
						for (int j = 0; j < strs.length; j++) {
							String str = strs[j];
							if (str != null && str.trim().length() > 0) {
								String[] st = str.trim().split("=");
								if (st.length > 1) {
									String[] types = st[1].split(",");
									bean.getCusTypeMap().put(st[0], types);
								}
							}
						}
					} else {
						String[] types = cusTypes.split(",");
						bean.setCusTypes(types);
					}
				}
				bean.setMaxSeq(retNo.getSeqMax());
				bean.setRetNoComb(retNo.getNoComb());
				RET_NO_MAP.put(bean.getAppType() + bean.getFileType(), bean);
			}
		}
		return RET_NO_MAP;
	}

	public static void main(String[] args) {
		int seq = 2899;
		int maxseq = 999;
		System.out.println(seq/maxseq);
		System.out.println(seq%maxseq);
	}

}
