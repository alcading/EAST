package com.huateng.report.scheduler.job;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import resource.bean.report.ReportJobConfig;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.scheduler.job.domain.UserAuthorityXMLDomain;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;
/**
 * 定时导出人员角色权限
 * @author NING-PENG
 *
 */
public class RbsExpUserPermJob implements Job{
	private Logger log = Logger.getLogger(this.getClass());
	public static final String RBS_EXP_USERPERM = "RBS_EXP_USERPERM";
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String onOff = ReportUtils.getSysParamsValue("EXP", "0001", "OFF");
		if ("ON".equalsIgnoreCase(onOff)) {
			ServletContext serContext = null;
			String result = null;
			Date startTm = null;
			Date endTm = null;
			String jobName = null;
			String jobId = null;
			String remark = "";
			try {
				serContext = (ServletContext) context.getScheduler().getContext().get("serContext");
				jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class, jobId);
				jobName = jobConfig.getJobName();
				boolean isdo = ReportJobUtil.isDoTaskJob(serContext, RBS_EXP_USERPERM, jobConfig);
				remark=jobConfig.getJobRemark();
				if (isdo) {
					startTm = new Date();
					serContext.setAttribute(RBS_EXP_USERPERM, false);
					log.info("==定时导出人员角色权限begin==");
					export();
					log.info("==定时导出人员角色权限end==");
					endTm = new Date();
					result = ReportEnum.REPORT_RESULT.SUCCESS.value;
					serContext.setAttribute(RBS_EXP_USERPERM, true);
				}
			} catch (Exception e) {
				result = ReportEnum.REPORT_RESULT.FAILD.value;
				remark+= ":定时导出人员角色权限异常,"+e.getMessage();
				log.error("定时导出人员角色权限异常" + e.getMessage());
				serContext.setAttribute(RBS_EXP_USERPERM, true);
			}
			ReportCommonService.getInstance().saveJobLog(startTm, endTm, jobId, result, jobName, remark);
		}

	}

	/**
	 * 执行导出方法
	 * @throws Exception
	 */
	private void export() throws Exception {
			String sql = "SELECT a.TLR_NAME,b.ROLE_ID,c.ROLE_NAME FROM TLR_INFO a JOIN TLR_ROLE_REL b ON a.TLRNO=b.TLRNO JOIN ROLE_INFO c ON c.ROLE_ID=b.ROLE_ID WHERE 1=1";
			Iterator userList = ROOTDAOUtils.getROOTDAO().queryBySQL(sql.toString());
			Map<String, List<String>> userMap = new HashMap<String, List<String>>();
			while (userList.hasNext()) {
				Object[] object = (Object[]) userList.next();
				String tlrName = (String) object[0];
				BigDecimal roleId = (BigDecimal) object[1];
				String roleName = (String) object[2];
				String privilege_container_name = roleName.trim() + "-" +roleId;
				List<String> list = null;
				if (userMap.containsKey(tlrName)) {
					list = userMap.get(tlrName);
					list.add(privilege_container_name);
				} else {
					list = new ArrayList<String>();
					list.add(privilege_container_name);
				}
				userMap.put(tlrName, list);
			}
			sql = "SELECT a.ROLE_ID, a.ROLE_NAME, c.funcid, c.FUNCName FROM ROLE_INFO a JOIN ROLE_FUNC_REL b ON a.ROLE_ID=b.ROLE_ID JOIN function_info c ON c.FUNCID=b.FUNCID WHERE 1=1";
			Iterator funcList = ROOTDAOUtils.getROOTDAO().queryBySQL(sql.toString());
			Map<String, List<String>> funcMap = new HashMap<String, List<String>>();
			while (funcList.hasNext()) {
				Object[] object = (Object[]) funcList.next();
				BigDecimal roleId = (BigDecimal) object[0];
				String roleName = (String) object[1];
				String funcId = (String) object[2];
				String funcName = (String) object[3];
				String privilege_container_name = roleName.trim() + "-" + roleId;
				String privilege_name = funcName.trim() + "-" + funcId.trim();
				List<String> list = null;
				if (funcMap.containsKey(privilege_container_name)) {
					list = funcMap.get(privilege_container_name);
					list.add(privilege_name);
				} else {
					list = new ArrayList<String>();
					list.add(privilege_name);
				}
				funcMap.put(privilege_container_name, list);
			}
			createMessage(userMap, funcMap);

	}

	/**
	 * 创建XML对象
	 * @param userMap
	 * @param funcMap
	 * @param response
	 * @throws Exception
	 */
	private void createMessage(Map<String, List<String>> userMap, Map<String, List<String>> funcMap) throws Exception {
		UserAuthorityXMLDomain uaxml = null;
		List<UserAuthorityXMLDomain> userAuthoritylist = new ArrayList<UserAuthorityXMLDomain>();
		for(String username : userMap.keySet()){
			List<String> privilege_container_nameList = userMap.get(username);
		    for(String privilege_container_name : privilege_container_nameList) {
		    	List<String> privilege_namelist = funcMap.get(privilege_container_name);
		    	for(String privilege_name: privilege_namelist) {
		    		uaxml = new UserAuthorityXMLDomain();
					uaxml.setUsername(username);
			    	uaxml.setPrivilegecontainername(privilege_container_name);
		    		uaxml.setPrivilegename(privilege_name);
		    		userAuthoritylist.add(uaxml);
		    	}
		    }
		}
		// 写XML文件
		writeXML(userAuthoritylist);
	}

	/**
	 * 写XML文件
	 * @param userAuthoritylist
	 * @throws Exception
	 */
	private void writeXML(List<UserAuthorityXMLDomain> userAuthoritylist) throws Exception {
			XMLWriter writer = null;// 声明写XML的对象
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");// 设置XML文件的编码格式
			Document document = DocumentHelper.createDocument();
			document.setXMLEncoding("utf-8");
			Element root = document.addElement("rbam");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd HH:mm");
			root.addElement("file_date").setText(sdf3.format(new Date()));
			root.addElement("business_date").setText(sdf.format(new Date()));
			String filePath = ReportUtils.getSysParamsValue("EXP", "PATH", "/home/topreport/");
			File file = new File(filePath);
			if (!file.exists() && !file.isDirectory()) {
				file.mkdirs();
			}

			//开始循环
			for(UserAuthorityXMLDomain userAuthority : userAuthoritylist) {
				String gelid = ReportUtils.getSysParamsValue("EXP", "0002", "XXXX");	// 系统ID，固定值，之后会提供
				String username = userAuthority.getUsername() == null ? "" : userAuthority.getUsername();	// 用户名
				String privilegecontainername = userAuthority.getPrivilegecontainername() == null ? "" : userAuthority.getPrivilegecontainername();// 角色名-角色编码
				String privilegename = userAuthority.getPrivilegename() == null ? "" : userAuthority.getPrivilegename();	// 具体功能名-功能编码
				String privilegevalue = "";	// 功能上的操作权限（如查询，执行），没有这一级别就留空
				Element privilege = root.addElement("privilege");

				privilege.addElement("gel_id").setText(gelid);
				privilege.addElement("user_name").setText(username);
				privilege.addElement("privilege_container_name").setText(privilegecontainername);
				privilege.addElement("privilege_name").setText(privilegename);
				privilege.addElement("privilege_value").setText(privilegevalue);
			}
			//结束循环
			//写入配置文件目录
			String filename = filePath + sdf2.format(new Date()) + ".xml";
			writer = new XMLWriter(new FileWriter(filename), format);
			writer.write(document);
			writer.close();
	}

}
