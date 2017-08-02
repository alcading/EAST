package com.huateng.report.genupreportfile.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.Beneficiary;
import resource.bean.report.BopCfaExguDs;
import resource.bean.report.BopExguTorDs;
import resource.bean.report.Guarantor;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BufCfaBABopCFAExguDsImpl implements IGetSubFileList {

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		// TODO Auto-generated method stub

		BopCfaExguDs bopCfaExguDs = new BopCfaExguDs();
		String fileDate = (String) paramMap.get(IN_FILE_DATE);
		String appType = (String) paramMap.get(IN_APP_TYPE);
		String fileType = (String) paramMap.get(IN_FILE_TYPE);
		String hql = "from BopCfaExguDs model";
		hql += " where model.recStatus='"
				+ TopReportConstants.REPORT_RECSTATUS_05 + "'";// 审核已确认
		if (fileDate!=null && fileDate.trim().length()>0) {
			hql += " and model.workDate='" + fileDate + "'";
		}
		hql += " and model.currentfile='" + fileType + "'";
		hql += " and model.apptype='" + appType + "'";
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();

		List<BopCfaExguDs> ob = dao.queryByQL2List(hql);
		for (int i = 0; i < ob.size(); i++) {
			String torHql = "from BopExguTorDs model where model.recId = '"
					+ ob.get(i).getId() + "'";
			torHql += " and torType = '03'";
			List<BopExguTorDs> danBaoRen = dao.queryByQL2List(torHql);//担保人查询list 与主表1对1
			if (danBaoRen.size() > 0) {
				ob.get(i).setGuappcode(danBaoRen.get(0).getTorCode());
				ob.get(i).setGuappname(danBaoRen.get(0).getTorName());
				ob.get(i).setGuappnamen(danBaoRen.get(0).getTorEnname());
			}
			String torBenHql = "from BopExguTorDs model where model.recId = '"
					+ ob.get(i).getId() + "'";
			torBenHql += " and torType = '01'";
			List<BopExguTorDs> torBen = dao.queryByQL2List(torBenHql);//受益人list 与主表多对1
			List<Beneficiary> beneficiarys = new ArrayList<Beneficiary>();
			for (int j = 0; j < torBen.size(); j++) {
				Beneficiary beneficiary = new Beneficiary();
				beneficiary.setBencode(torBen.get(j).getTorCode());
				beneficiary.setBename(torBen.get(j).getTorName());
				beneficiary.setBenamen(torBen.get(j).getTorEnname());
				beneficiary.setBentype(torBen.get(j).getTorTypeCode());
				beneficiary.setBencountrycode(torBen.get(j).getCountryCode());
				beneficiarys.add(beneficiary);
			}
			ob.get(i).setBeneficiarys(beneficiarys);
			String torGuaHql = "from BopExguTorDs model where model.recId = '"
					+ ob.get(i).getId() + "'";
			torGuaHql += " and torType = '02'";
			List<BopExguTorDs> torGua = dao.queryByQL2List(torGuaHql);//被担保人list  与主表多对1
			List<Guarantor> guarantors = new ArrayList<Guarantor>();
			for (int k = 0; k < torGua.size(); k++) {
				Guarantor guarantor = new Guarantor();
				guarantor.setGuedcode(torGua.get(k).getTorCode());
				guarantor.setGuedname(torGua.get(k).getTorName());
				guarantor.setGuednamen(torGua.get(k).getTorEnname());
				guarantor.setGuedtype(torGua.get(k).getTorTypeCode());
				guarantor.setGuedcouncode(torGua.get(k).getCountryCode());
				guarantors.add(guarantor);
			}
			ob.get(i).setGuarantores(guarantors);
		}
		return ob;
	}

}
