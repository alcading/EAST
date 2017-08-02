/*
 * Created on 2005-5-19
 * $Id: PageFlowManager.java,v 1.1.1.1 2005/05/24 06:04:49 liuwen Exp $
 * 
 * Copyright 2005 Shanghai Huateng Software, Limited. All rights reserved.
 * HUATENG PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 */
package com.huateng.ebank.framework.web.pageflow;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1.1.1 $
 * 
 * Manager class of page flow.
 * 一个页面流包含多个页面或者业务处理逻辑. 在这些页面和业务逻辑之间需要共享数据.
 * 传统意义上的Session Scope和Request Scope不能满足要求,所以增加了PageFlowScope这个概念.
 * Request Scope < PageFlowScope < Session Scope. 
 */
public class PageFlowManager {
    /**
     * key of page flow.
     */
    public final static String PAGEFLOW_KEY="_PAGE_FLOW_KEY_$$$$";
    
    public static void enterPageFlow(HttpServletRequest request, String pageFlowId){
        HttpSession session = request.getSession(true);
        if ( null == session ){
            return;
        }
        enterPageFlow(session, pageFlowId);
    }
    
    /**
     * 进入一个PageFlow.
     * @param session
     */
    public static void enterPageFlow(HttpSession session, String pageFlowId){
        PageFlowContext pfc = new PageFlowContext();
        pfc.setPageFlowId(pageFlowId);
        pfc.setSession(session);
        session.setAttribute(PAGEFLOW_KEY, pfc);
    }
    
    public static boolean inPageFlow(HttpSession session, String pageFlowId){
        if ( null == pageFlowId ) return false;
        PageFlowContext pfc = getPageFlowContext(session);
        if ( null == pfc ){
            return false;
        }
        if ( pageFlowId.equals(pfc.getPageFlowId()) ){
            return true;
        }
        return false;
    }
    
    public static boolean inPageFlow(HttpServletRequest request, String pageFlowId){
        HttpSession session = request.getSession(true);
        if ( null == session ){
            return false;
        }
        return inPageFlow(session,pageFlowId);
    }
    /**
     * 从指定的session中获得PageFlow信息, 如果事先没有设置， 返回为null。
     * @param session
     * @return PageFlowContext
     */
    public static PageFlowContext getPageFlowContext(HttpSession session){
        PageFlowContext pfc = (PageFlowContext)session.getAttribute(PageFlowManager.PAGEFLOW_KEY);
        return pfc;
    }
    
    public static PageFlowContext getPageFlowContext(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        if ( null == session ){
            return null;
        }
        return getPageFlowContext(session);
    }
    
    /**
     * 退出PageFlow.
     * @param session
     */
    public static void exitPageFlow(HttpSession session){
        session.removeAttribute(PageFlowManager.PAGEFLOW_KEY);
    }
    
    public static void exitPageFlow(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        if ( null != session ){
            session.removeAttribute(PageFlowManager.PAGEFLOW_KEY);
        }
    }
}
