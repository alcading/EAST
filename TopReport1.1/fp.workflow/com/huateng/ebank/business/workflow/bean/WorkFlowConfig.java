package com.huateng.ebank.business.workflow.bean;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class WorkFlowConfig {
	private static final String BUNDLE_NAME = "resources/workFlowConfig"; //外系统名称-地址配置
	private static final String nameSuffix = "_NAME"; //外系统名称-地址配置
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	public static  String getValue(String key){
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return key;
        }
	}
	
	public static  String getValueName(String key){
        try {
        	String subkey = key + nameSuffix;
            return RESOURCE_BUNDLE.getString(subkey);
        } catch (MissingResourceException e) {
            return key;
        }
	}
	
	public static void main(String arg[]){
//		String[] templateName=WorkFlowConfig.getValue("templateName").split(",");
//		for(String s :templateName){
//			System.out.println(s);
//		}
		System.out.println(WorkFlowConfig.getValue("CreditApplyProcess_NAME"));
	}
}
