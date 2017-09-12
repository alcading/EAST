package com.huateng.report.dataAnaly.util;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import org.hibernate.SessionFactory;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;

import resource.bean.report.BiAnalyDetail;
import resource.bean.report.BiAnalyDetailPars;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.report.service.AnalyProService;
import com.huateng.report.utils.ListSort;
import com.huateng.report.utils.ReportEnum;

/**
 * 调用开始执行分析
 *
 * @author NING-PENG
 *
 */
public class ExecuteDataAnalysis {
	private static final HtLog htlog = HtLogFactory.getLogger(ExecuteDataAnalysis.class);

	public static void execute(BiAnalyDetail detail) throws Exception{
		String confType = detail.getConfType();
		String classAndMethod = detail.getConfClassPath().trim();
		List<BiAnalyDetailPars> parsList = AnalyProService.getInstance().getAnalyDetailParList(detail.getId());
		if (parsList != null && parsList.size() > 0) {// 对参数进行排序
			ListSort<BiAnalyDetailPars> listSort = new ListSort<BiAnalyDetailPars>();
			listSort.Sort(parsList, "getParSeq", "asc");
		}
		Object retobj = null;
		if (confType.equals(ReportEnum.REPORT_ANALY_CONF_TYPE.JAVA.value)) {// 执行java进行分析
			htlog.info(" execute "+classAndMethod);
			String[] strs = classAndMethod.split(":");
			String classNm = strs[0].trim();
			String methodNm = strs[1].trim();
			try {
				Class cls = Class.forName(classNm);
				Object clsObj = cls.newInstance();
				Method method = getClsMethod(cls,classNm, methodNm);
				if (parsList != null && parsList.size() > 0) {
					retobj = method.invoke(clsObj, getAnalyParams(parsList));
				} else {
					retobj = method.invoke(clsObj);
				}
			} catch (Exception e) {
				throw new Exception("执行："+classAndMethod+"出错!");
			}
		} else if (confType.equals(ReportEnum.REPORT_ANALY_CONF_TYPE.PROC.value)) {// 执行存储过程//FIXME 复杂存储过程未实现（可实现java类进行扩展)
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			SessionFactory sf = rootdao.getSessionFactory();
			ConnectionProvider cp = ((SessionFactoryImplementor) sf).getConnectionProvider();
			Connection conn = null;
			CallableStatement callst = null;
			ResultSet rs = null;
			String proc = null;
			try {
				conn = cp.getConnection();
				proc = getCallableStatementSql(detail,parsList);
				callst = conn.prepareCall(proc);
				htlog.info(" execute "+proc);
				int parLen = getCallableStaParLen(detail,parsList);

				if (parsList != null && parsList.size() > 0) {
					for (int i = 0; i < parsList.size(); i++) {
						BiAnalyDetailPars par = parsList.get(i);
						callst.setString(par.getParSeq(), par.getParValue());
					}
				}
				if (detail.getConfIsRet().equals(ReportEnum.REPORT_ANALY_CONF_RETTYPE.NORET.value)) {
					callst.execute();
				} else if (detail.getConfIsRet().equals(ReportEnum.REPORT_ANALY_CONF_RETTYPE.RET_SET.value)) {
					callst.registerOutParameter(parLen, OracleTypes.CURSOR);// FIXME oracle返回游标特定类型
					callst.execute();
					rs = (ResultSet) callst.getObject(parLen);
				} else if (detail.getConfIsRet().equals(ReportEnum.REPORT_ANALY_CONF_RETTYPE.RET_VAL.value)) {
					callst.registerOutParameter(parLen, Types.VARCHAR);
					callst.execute();
					retobj = callst.getString(parLen);
				} else if (detail.getConfIsRet().equals(ReportEnum.REPORT_ANALY_CONF_RETTYPE.RET_LIST.value)) {
					callst.execute();
					rs = callst.getResultSet();
				}
				if (rs != null) {
					List<Map<String, Object>> retlist = new ArrayList<Map<String, Object>>();
					ResultSetMetaData rsmd = rs.getMetaData();
					int numberOfColumns = rsmd.getColumnCount();
					while (rs.next()) { // 将查询结果取出
						Map<String, Object> rsMap = new HashMap<String, Object>();
						for (int i = 1; i <= numberOfColumns; i++) {
							Object data = null;
							if (rsmd.getColumnType(i)==Types.TIMESTAMP) {
								data = rs.getTimestamp(i);
							}else{
								data = rs.getObject(i);
							}
							rsMap.put(rsmd.getColumnName(i), data);
						}
						retlist.add(rsMap);
					}
					retobj = retlist;
				}
			} catch (SQLException e) {
				throw new Exception("执行存储过程："+proc+"出错!");
			}finally{
				if (rs!=null) {
					rs.close();
				}
				if (callst!=null) {
					callst.close();
				}
				if (conn!=null) {
					if(cp!=null){
						cp.closeConnection(conn);
					}
				}
			}

		} else if (confType.equals(ReportEnum.REPORT_ANALY_CONF_TYPE.BATCH.value)) {// 执行批处理
			try {
				/*int jobNo = Integer.parseInt(classAndMethod);
				APPPLStartBatch startBatch = new APPPLStartBatch(jobNo);
				startBatch.startJob();*/
			} catch (Exception e) {
				throw new Exception("执行批处理步骤"+classAndMethod+"出错:"+e.getMessage());
			}
		}
		// 对返回值进行处理
		if (detail.getConfRetClass() != null && detail.getConfRetClass().trim().length() > 0) {
			String retclassnm = detail.getConfRetClass().trim();
			String[] strs = retclassnm.split(":");
			String classNm = strs[0].trim();
			String methodNm = strs[1].trim();
			try {
				Class cls = Class.forName(classNm);
				Object clsObj = cls.newInstance();
				Method method = getClsMethod(cls,classNm, methodNm);
				if (!detail.getConfIsRet().equals(ReportEnum.REPORT_ANALY_CONF_RETTYPE.NORET.value)) {
					method.invoke(clsObj, retobj,detail);
				} else {
					method.invoke(clsObj,detail);
				}
			} catch (Exception e) {
				throw new Exception("处理返回值执行："+retclassnm+"出错!");
			}
		}
	}

	private static Method getClsMethod(Class cls,String classNm,String methodNm) throws Exception{
		Method[] mt = cls.getMethods();
		Method md = null;
		for (int i = 0; i < mt.length; i++) {
			if(mt[i]!=null && mt[i].getName().equals(methodNm)){
				md = mt[i];
				break;
			}
		}
		if (md==null) {
			throw new Exception(classNm+"类中方法"+methodNm+"不存在！");
		}
		return md;
	}

	private static Object[] getAnalyParams(List<BiAnalyDetailPars> parsList) {
		// 对参数进行排序
		Object[] obj = new Object[parsList.size()];
		for (int i = 0; i < parsList.size(); i++) {
			BiAnalyDetailPars par = parsList.get(i);
			obj[i] = par.getParValue();
		}
		return obj;
	}



	private static int getCallableStaParLen(BiAnalyDetail detail,List<BiAnalyDetailPars> parsList) {
		int len = 0;
		if (parsList != null && parsList.size() > 0) {
			len = parsList.size();
		}
		if (detail.getConfIsRet().equals(ReportEnum.REPORT_ANALY_CONF_RETTYPE.RET_SET.value)
				|| detail.getConfIsRet().equals(ReportEnum.REPORT_ANALY_CONF_RETTYPE.RET_VAL.value)) {
			len += 1;
		}
		return len;
	}

	private static String getCallableStatementSql(BiAnalyDetail detail,List<BiAnalyDetailPars> parsList) {
		StringBuffer parsql = new StringBuffer();
		StringBuffer sql = new StringBuffer("{ call ");
		sql.append(detail.getConfClassPath());
		sql.append("(");
		if (parsList != null && parsList.size() > 0) {
			int len = parsList.size();
			for (int i = 0; i < len; i++) {
				parsql.append("?");
				if (i < len - 1) {
					parsql.append(",");
				}
			}
		}
		// out参数形式返回
		if (detail.getConfIsRet().equals(ReportEnum.REPORT_ANALY_CONF_RETTYPE.RET_SET.value)
				|| detail.getConfIsRet().equals(ReportEnum.REPORT_ANALY_CONF_RETTYPE.RET_VAL.value)) {
			if (parsql.toString().length() > 0) {
				parsql.append(",");
			}
			parsql.append("?");
		}
		sql.append(parsql.toString());
		sql.append(")");
		sql.append(" }");
		return sql.toString();
	}

}
