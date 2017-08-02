package com.huateng.report.imports.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.imports.bean.ImportFileBean;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.imports.model.Constant;

import east.utils.tools.ToolUtils;

public class ImportBadFileUpdate extends BaseUpdate {

	private static Logger logger = Logger.getLogger(ImportFileUpdate.class
			.getName());

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		List<Constant> progress = new ArrayList<Constant>();
		setSessionObject(Constants.PROGRESS, progress);
		Constant pv = null;
		try {

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("ImportBadFile");

			ImportFileBean bean = null;
			String workdate = DataFormat.dateToNumber(DateUtil.getTbsDay());
			while (updateResultBean.hasNext()) {
				Map<String, String> map = updateResultBean.next();
				bean = new ImportFileBean();
				mapToObject(bean, map);
				bean.setSeperator((String) map.get("seperator"));
				if (bean.isSelect()) {
					//重新导入文件
					String fileName = bean.getFileName();
					if(fileName.startsWith("cpwj")){
						System.out.println("注意：传票文件["+fileName+"]出错，不允许手工导入，请联系科技人员!");
						continue;
					}
					String command = "sh /home/jgbs/shell/badSqlLdrEast.sh " + workdate + " " + fileName;
					System.out.println("ImportBadFileUpdate调用shell:"+command);
					ToolUtils.exeShell(command);
				}
			}

			return updateReturnBean;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		} finally {
			// 结束导入
			setSessionObject(Constants.IS_IMPORTING, Constants.NO);
		}
	}
	
}

