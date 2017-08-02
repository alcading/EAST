/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.huateng.ebank.business.workflow;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import resource.dao.base.HQLDAO;

import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.topbpm.TopBPMConfiguration;
import com.huateng.topbpm.TopBPMContext;
import com.huateng.topbpm.graph.def.ProcessDefinition;

public class ProcessImageByProcNameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		Session session = null;
		try{
		 TopBPMConfiguration topbpmConfiguration = TopBPMConfiguration.getInstance();

		 TopBPMContext topBPMContext= topbpmConfiguration.createTopBPMContext();
		 HQLDAO dao = DAOUtils.getHQLDAO();
		 session = dao.getHibernateTemplate().getSessionFactory().openSession();
		 topBPMContext.setSession(session);
		 ProcessDefinition processDefinition = null;
		 processDefinition = topBPMContext.getGraphSession().findLatestProcessDefinition(request.getParameter("procName"));

	    byte[] bytes = processDefinition.getFileDefinition().getBytes("processimage.jpg");
	    OutputStream out = response.getOutputStream();
	    out.write(bytes);
	    out.flush();
	}catch (RuntimeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(session != null){
			session.close();
		}
	}


    // leave this in.  it is in case we want to set the mime type later.
    // get the mime type
    // String contentType = URLConnection.getFileNameMap().getContentTypeFor( fileName );
    // set the content type (=mime type)
    // response.setContentType( contentType );
	}
}
