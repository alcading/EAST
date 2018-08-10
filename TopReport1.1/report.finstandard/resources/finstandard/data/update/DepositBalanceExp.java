package resources.finstandard.data.update;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.utils.ReportUtils;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import resources.finstandard.data.pub.DepositBalance;

public class DepositBalanceExp extends BaseUpdate {
	private static final Logger logger = Logger.getLogger(DepositBalanceExp.class);
	public static Session session = null;
	private static final String DATASET_ID = "DepositBalanceEntry";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		logger.info("DepositBalanceExp start");
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		BufferedWriter bw = null;
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		String sjrq = updateResultBean.getParameter("sjrq");
		
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		
		List<DepositBalance> depositBalances = rootDAO.queryByQL2List(" from DepositBalance la where la.sjrq= to_date("+sjrq+", 'yyyyMMdd')");
		
		String filePath = ReportUtils.getSysParamsValue(Constants.PARAM_DIR, Constants.PARAM_DIR_0104, "");
		filePath = filePath + File.separator + sjrq + File.separator;
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdir();
		}
		
		StringBuilder bf=new StringBuilder();
		bf.append("数据日期|金融机构编码|客户类型|存款账户代码|存款协议代码|产品类别|存款协议起始日期|存款协议到期日期|存款币种|存款余额|利率是否固定|利率水平");
		bf.append("\r\n");

		try {
			if (depositBalances.size() > 0) {
				for (DepositBalance depositBalance:depositBalances) {
					bf.append(depositBalance.getSjrq()+"|"+depositBalance.getJrjgbm()+"|"+depositBalance.getKhlx()+"|"+
							depositBalance.getCkzhdm()+"|"+depositBalance.getCkxydm()+"|"+depositBalance.getCplb()+"|"+
							depositBalance.getCkxyqsrq()+"|"+depositBalance.getCkxydqrq()+"|"+depositBalance.getCkbz()+"|"+
							depositBalance.getCkye()+"|"+depositBalance.getLlsfgd()+"|"+depositBalance.getLlsp());
					bf.append("\r\n");
				}
			}
			
			File txtFile = new File(filePath + ".txt");
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txtFile), "UTF-8"));
			bw.write(bf.toString());	
		    bw.flush();
		    bw.close(); 
		} catch (Exception e) {
			logger.error("DepositBalanceExp error", e);
		}
		
		logger.info("DepositBalanceExp end");
		return null;
	}

}
