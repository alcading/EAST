/*
 * Created on 2005-5-19
 * $Id: PageFlowContext.java,v 1.1.1.1 2005/05/24 06:04:49 liuwen Exp $
 * 
 * Copyright 2005 Shanghai Huateng Software, Limited. All rights reserved.
 * HUATENG PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 */
package com.huateng.ebank.framework.web.pageflow;

import javax.servlet.http.HttpSession;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1.1.1 $
 * 
 * Context of pageflow.
 */
public class PageFlowContext extends java.util.HashMap{
    private HttpSession session;
    private String pageFlowId;
    
    /**
     * default constructor
     */
    public PageFlowContext(){        
    }
    
    /**
     * 设置session.
     * @param session
     */
    public void setSession(HttpSession session){
        this.session = session;
    }
    
    /**
     * 获取和当前context相关的session.
     * @return HttpSession
     */
    public HttpSession getSession(){
        return this.session;
    }
    /**
     * @return Returns the pageFlowId.
     */
    public String getPageFlowId() {
        return pageFlowId;
    }
    /**
     * @param pageFlowId The pageFlowId to set.
     */
    public void setPageFlowId(String pageFlowId) {
        this.pageFlowId = pageFlowId;
    }
}
