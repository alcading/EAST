package com.huateng.report.dataAnaly.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import resource.bean.report.BiAnalyDetail;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.dataAnaly.bean.DataAnalysisTool;

/**
 * 数据分析执行测试类，继承工具类，获取connection
 * @author NING-PENG
 *
 */
public class DataAnalysisTest extends DataAnalysisTool{
	public Object testExecuteAnaly(String workdate,String busiType,String appType,String analyNo){
		System.out.println("执行分析处理工作日期："+workdate);

		return analyNo;
	}

	public void retTestExecuteAnaly(Object obj,BiAnalyDetail detail) throws CommonException{
		String analyNo = (String) obj;
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		detail.setExecRemark("执行分析结果返回成功，分析明细："+detail.getId());
		dao.saveOrUpdate(detail);

		System.out.println("执行分析返回结果：数据分析编号："+analyNo);
	}


	public void test(){
		System.out.println("无参数，无返回值");
	}

	public void retTestProc(Object obj,BiAnalyDetail detail) throws Exception{
		if (obj!=null) {
			List<Map<String, Object>> list = (List<Map<String, Object>>) obj;

			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);
				for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
					String name = iterator.next();
					System.out.println("第"+i+"行：字段名称："+name+",值："+map.get(name).toString());
				}
			}
		}
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		detail.setExecRemark("执行分析结果返回成功，执行方法："+detail.getConfClassPath());
		dao.saveOrUpdate(detail);
//		throw new Exception("错误！");
	}





}
