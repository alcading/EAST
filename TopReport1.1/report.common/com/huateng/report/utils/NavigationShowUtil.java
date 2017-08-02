package com.huateng.report.utils;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import resource.bean.pub.FunctionInfo;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.common.service.ReportCommonService;

public class NavigationShowUtil {

	public static String showNavigationXml(String tlrNo, String contextPath) {
		String result = null;
		ReportCommonService commonService = ReportCommonService.getInstance();
		try {
			List mainList = commonService.getFunctionNavList("0");// 主菜单
			Document document = DocumentHelper.createDocument();
			document.setXMLEncoding("utf-8");
			Element root = document.addElement("root");
			Element mainmenu = root.addElement("mainMenu");
			Element submenu = root.addElement("subMenu");
			for (int i = 0; i < mainList.size(); i++) {
				FunctionInfo info = (FunctionInfo) mainList.get(i);
				Element item = mainmenu.addElement("item");
				item.addAttribute("titleLabel", info.getFuncname().trim());
				item.addAttribute("imgUrl", info.getIconCls().trim());
				item.addAttribute("menucode", info.getId().trim());
				if (i == 0) {
					item.addAttribute("defaultopen", "1");
				} else {
					item.addAttribute("defaultopen", "0");
				}
				List subList = commonService.getFunctionNavList(info.getId().trim());// 子菜单
				for (int j = 0; j < subList.size(); j++) {
					FunctionInfo subInfo = (FunctionInfo) subList.get(j);
					Element subItem = submenu.addElement("item");
					subItem.addAttribute("titleLabel", subInfo.getFuncname().trim());
					subItem.addAttribute("parentMenucode", subInfo.getLastdirectory().trim());
					String iconcls = subInfo.getIconCls();
					String[] tmp = iconcls.split("\\.");
					String blkIconcls = tmp[0] + "_black." + tmp[1];
					String src = subInfo.getPagepath();
					if (src == null || src.trim().length() == 0) {
						subItem.addAttribute("imgUrl", blkIconcls);
						subItem.addAttribute("addDesc", "功能尚未(购买)加载!");
						subItem.addAttribute("menucode", "");
					} else {
						int count = commonService.getFunctionCountByTlrNo(tlrNo, subInfo.getId().trim());
						if (count > 0) {
							subItem.addAttribute("imgUrl", iconcls);
							subItem.addAttribute("addDesc", "");
							if (src.indexOf(contextPath) < 0) {
								src = contextPath + src;
							}
							subItem
									.addAttribute("menucode", src + "?type="+subInfo.getId().trim());
						} else {
							subItem.addAttribute("imgUrl", blkIconcls);
							subItem.addAttribute("addDesc", "没有操作该功能的权限!");
							subItem.addAttribute("menucode", "");
						}
					}
					subItem.addAttribute("textLabel", subInfo.getMisc());
				}
			}
			result = document.asXML();
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public static List<FunctionInfo> getUserNavgFuncList(String tlrNo) throws CommonException {
		List<FunctionInfo> navgList = new ArrayList<FunctionInfo>();

		ReportCommonService commonService = ReportCommonService.getInstance();
		List mainList = commonService.getFunctionNavList("0");// 主菜单
		for (int i = 0; i < mainList.size(); i++) {
			FunctionInfo info = (FunctionInfo) mainList.get(i);
			List subList = commonService.getFunctionNavList(info.getId().trim());// 子菜单
			for (int j = 0; j < subList.size(); j++) {
				FunctionInfo subInfo = (FunctionInfo) subList.get(j);
				String src = subInfo.getPagepath();
				if (src != null && src.trim().length() > 0) {
					int count = commonService.getFunctionCountByTlrNo(tlrNo, subInfo.getId().trim());
					if (count > 0) {
						navgList.add(subInfo);
					}
				}
			}
		}
		return navgList;
	}
}
