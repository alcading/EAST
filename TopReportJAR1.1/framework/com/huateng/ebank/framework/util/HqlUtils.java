/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package com.huateng.ebank.framework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**   
* @Title: HqlUtils.java 
* @Package com.huateng.ebank.framework.util 
* @Description: HQL 解析类 
* @author shenantonio   
* @date 2009-10-30 下午03:04:19
* Copyright: Copyright (c) 2009
* Company: Shanghai Huateng Software Systems Co., Ltd. 
* @version V1.0   
*/ 
public class HqlUtils {

    /** 
    * @Title: removeSelect 
    * @Description: 去除HQL语句中的select部分 
    * @param @param hql
    * @param @return     
    * @return String
    * @author shen_antonio 
    * @date 2009-10-30 下午03:05:45 
    * @throws 
    */ 
    private static String removeSelect(String hql) {
            int beginPos = hql.toLowerCase().indexOf("from ");
            return hql.substring(beginPos);
    }
   
    /** 
    * @Title: removeOrders 
    * @Description: 去除HQL语句中的order部分 
    * @param @param hql
    * @param @return     
    * @return String
    * @author shen_antonio 
    * @date 2009-10-30 下午03:05:50 
    * @throws 
    */ 
    private static String removeOrders(String hql) {
        Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(hql);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
                m.appendReplacement(sb, "");
        }
        m.appendTail(sb);
        return sb.toString();
    }
    
    /** 
    * @Title: transferCountHQL 
    * @Description: 转换HQL为COUNT(*)模式 
    * @param @param hql
    * @param @return     
    * @return String
    * @author shenantonio
    * @date 2009-10-30 下午05:41:08 
    * @throws 
    */ 
    public static String transferCountHQL(String hql){
    	/** BMS-2275 修改新分页查询方法对sqlserver数据库的支持问题 20091127 Begin */
    	return "SELECT COUNT(*) " + removeOrders(removeSelect(hql));
    	/** BMS-2275 Modified by HuangWeijing 2009-11-27 End */
    }

}
