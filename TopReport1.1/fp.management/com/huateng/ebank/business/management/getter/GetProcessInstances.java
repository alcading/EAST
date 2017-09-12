/**
 *
 */
package com.huateng.ebank.business.management.getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.xpath.DefaultXPath;

import resource.dao.base.HQLDAO;

import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.topbpm.TopBPMConfiguration;
import com.huateng.topbpm.TopBPMContext;
import com.huateng.topbpm.file.def.FileDefinition;
import com.huateng.topbpm.graph.def.ProcessDefinition;
import com.huateng.topbpm.graph.exe.ProcessInstance;
import com.huateng.topbpm.graph.exe.Token;
import com.huateng.topbpm.taskmgmt.exe.TaskInstance;

/**
 * Title: GetProcessInstances
 * Description:
 * Copyright: Copyright (c) 2007
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2007-11-26
 */
public class GetProcessInstances {

	private ProcessDefinition processDefinition = null;

	  private static final long serialVersionUID = 1L;
	  private long taskInstanceId = -1;
	  private long tokenInstanceId = -1;
	  private String ctx  = "";

	  private byte[] gpdBytes = null;
	  private byte[] imageBytes = null;
	  private Token currentToken = null;
	  private java.lang.StringBuffer  sb = new StringBuffer();

	  static String currentTokenColor = "red";
	  static String childTokenColor = "blue";
	  static String tokenNameColor = "blue";

	  private TopBPMContext context = null;
	  private TopBPMConfiguration topbpmConfiguration = TopBPMConfiguration.getInstance();
	  private TaskInstance taskid = null;
	public GetProcessInstances() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	public String getProcessInstances(String contractNo,String procNo,String doTlrno,String taskId,HttpServletRequest req,HttpServletResponse rsp){
		ctx = req.getContextPath();
		boolean suc = initialize(contractNo,procNo,doTlrno,taskId);
		if( suc ){
		retrieveByteArrays();
		try{
	    if (gpdBytes != null && imageBytes != null) {
	    	writeTable();
	    	return sb.toString();
	    }else{
	    	return null;
	    }
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		}else{
			return null;
		}
	}
	*/


	public String getProcessInstances(String piid,HttpServletRequest req,HttpServletResponse rsp){
		ctx = req.getContextPath();
		boolean suc = initialize(piid);
		if( suc ){
		retrieveByteArrays();
		try{
	    if (gpdBytes != null && imageBytes != null) {
	    	writeTable();
	    	return sb.toString();
	    }else{
	    	return null;
	    }
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		}else{
			return null;
		}
	}

	 private void retrieveByteArrays() {
		    try {

		      FileDefinition fileDefinition = processDefinition.getFileDefinition();
		      gpdBytes = fileDefinition.getBytes("gpd.xml");
		      imageBytes = fileDefinition.getBytes("processimage.jpg");
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}

	 private int[] extractImageDimension(Element root) {
		    int[] result = new int[2];
		    result[0] = Integer.valueOf(root.attribute("width").getValue()).intValue();
		    result[1] = Integer.valueOf(root.attribute("height").getValue()).intValue();
		    return result;
	}

	 private void walkTokens(Token parent, List allTokens)
	  {
	      Map children = parent.getChildren();
	      if(children != null && children.size() > 0)
	      {
	          Collection childTokens = children.values();
	          for (Iterator iterator = childTokens.iterator(); iterator.hasNext();)
	          {
	              Token child = (Token) iterator.next();
	              walkTokens(child,  allTokens);
	          }
	      }

	      allTokens.add(parent);
	  }

	 private int[] extractBoxConstraint(Element root, Token token) {
		    int[] result = new int[4];
		    String nodeName = token.getNode().getName();
		    XPath xPath = new DefaultXPath("//node[@name='" + nodeName + "']");
		    Element node = (Element) xPath.selectSingleNode(root);
		    result[0] = Integer.valueOf(node.attribute("x").getValue()).intValue();
		    result[1] = Integer.valueOf(node.attribute("y").getValue()).intValue();
		    result[2] = Integer.valueOf(node.attribute("width").getValue()).intValue();
		    result[3] = Integer.valueOf(node.attribute("height").getValue()).intValue();
		    return result;
		  }

	 private void writeTable() throws IOException, DocumentException {

		    int borderWidth = 4;
		    Element rootDiagramElement = DocumentHelper.parseText(new String(gpdBytes)).getRootElement();
		    int[] boxConstraint;
		    int[] imageDimension = extractImageDimension(rootDiagramElement);
		    String imageLink = ctx+"/processimage?definitionId=" + processDefinition.getId();

		    if (tokenInstanceId > 0) {

		        List allTokens = new ArrayList();
		        walkTokens(currentToken, allTokens);

		    	sb.append("<div style='position:relative; background-image:url(" + imageLink + "); width: " + imageDimension[0] + "px; height: " + imageDimension[1] + "px;'>");

		        for (int i = 0; i < allTokens.size(); i++)
		        {
		            Token token = (Token) allTokens.get(i);

		          //check how many tokens are on teh same level (= having the same parent)
		          int offset = i;
		          if(i > 0) {
		            while(offset > 0 && ((Token) allTokens.get(offset - 1)).getParent().equals(token.getParent())) {
		              offset--;
		            }
		          }
		            boxConstraint = extractBoxConstraint(rootDiagramElement, token);

		            //Adjust for borders
		            //boxConstraint[2]-=borderWidth*2;
		            //boxConstraint[3]-=borderWidth*2;

		        	sb.append("<div style='position:absolute; left: "+ boxConstraint[0] +"px; top: "+ boxConstraint[1] +"px; ");

		            if (i == (allTokens.size() - 1)) {
		            	sb.append("border: " + currentTokenColor);
		            }
		            else {
		            	sb.append("border: " + childTokenColor);
		            }

		            	sb.append(" " + borderWidth + "px groove; "+
		            			"width: "+ boxConstraint[2] +"px; height: "+ boxConstraint[3] +"px;'>");

		            if(token.getName()!=null)
		            {
		            	sb.append("<span style='color:" + tokenNameColor + ";font-style:italic;position:absolute;left:"+ (boxConstraint[2] + 10) +"px;top:" +((i - offset) * 20) +";'>&nbsp;" + token.getName() +"</span>");
		            }

		            sb.append("</div>");
		        }
		        sb.append("</div>");
		    }
		    else
		    {
		    	boxConstraint = extractBoxConstraint(rootDiagramElement);

		    	sb.append("<table border=0 cellspacing=0 cellpadding=0 width=" + imageDimension[0] + " height=" + imageDimension[1] + ">");
		    	sb.append("  <tr>");
			    sb.append("    <td width=" + imageDimension[0] + " height=" + imageDimension[1] + " style=\"background-image:url(" + imageLink + ")\" valign=top>");
			    sb.append("      <table border=0 cellspacing=0 cellpadding=0>");
			    sb.append("        <tr>");
			    sb.append("          <td width=" + (boxConstraint[0] - borderWidth) + " height=" + (boxConstraint[1] - borderWidth)
			            + " style=\"background-color:transparent;\"></td>");
			    sb.append("        </tr>");
			    sb.append("        <tr>");
			    sb.append("          <td style=\"background-color:transparent;\"></td>");
			    sb.append("          <td style=\"border-color:" + currentTokenColor + "; border-width:" + borderWidth + "px; border-style:groove; background-color:transparent;\" width="
			            + boxConstraint[2] + " height=" + (boxConstraint[3] + (2 * borderWidth)) + ">&nbsp;</td>");
			    sb.append("        </tr>");
			    sb.append("      </table>");
			    sb.append("    </td>");
			    sb.append("  </tr>");
			    sb.append("</table>");
		    }
		  }

	 /*
	 private boolean initialize(String contractNo,String procNo,String doTlrno,String taskId2) {
//			WorkflowCallerNew workflowCallerNew = new WorkflowCallerNew();
			long taskid1 = Long.valueOf(taskId2);
			ProcessInstance processInstance = this.GetProcessInstrance(procNo, contractNo,doTlrno,taskid1);
			if( processInstance == null ){
				return false;
			}
			this.taskInstanceId = -1;
			tokenInstanceId = processInstance.getId();
		    if (this.taskInstanceId > 0) {
		    	TaskInstance taskInstance = this.getContext().getTaskMgmtSession().loadTaskInstance(taskInstanceId);
		    	currentToken = taskInstance.getToken();
		    }
		    else
		    {
		    	if (this.tokenInstanceId > 0)
		    		currentToken = this.getContext().getGraphSession().loadToken(this.tokenInstanceId);
		    }
		    processDefinition = currentToken.getProcessInstance().getProcessDefinition();
		    return true;
	 }
	 */
	 private boolean initialize(String piid) {
//			WorkflowCallerNew workflowCallerNew = new WorkflowCallerNew();
			ProcessInstance processInstance = this.GetProcessInstrance(piid);
			if( processInstance == null ){
				return false;
			}
			this.taskInstanceId = -1;
			//tokenInstanceId = processInstance.getId();
			tokenInstanceId = processInstance.getRootToken().getId();
		    if (this.taskInstanceId > 0) {
		    	TaskInstance taskInstance = this.getContext().getTaskMgmtSession().loadTaskInstance(taskInstanceId);
		    	currentToken = taskInstance.getToken();
		    }
		    else
		    {
		    	if (this.tokenInstanceId > 0)
		    		currentToken = this.getContext().getGraphSession().loadToken(this.tokenInstanceId);
		    }
		    processDefinition = currentToken.getProcessInstance().getProcessDefinition();
		    return true;
	 }

	 private int[] extractBoxConstraint(Element root) {
		    int[] result = new int[4];
		    String nodeName = currentToken.getNode().getName();
		    XPath xPath = new DefaultXPath("//node[@name='" + nodeName + "']");
		    Element node = (Element) xPath.selectSingleNode(root);
		    result[0] = Integer.valueOf(node.attribute("x").getValue()).intValue();
		    result[1] = Integer.valueOf(node.attribute("y").getValue()).intValue();
		    result[2] = Integer.valueOf(node.attribute("width").getValue()).intValue();
		    result[3] = Integer.valueOf(node.attribute("height").getValue()).intValue();
		    return result;
	}

	public ProcessInstance GetProcessInstrance( String piid){
			HQLDAO dao = DAOUtils.getHQLDAO();
			context = topbpmConfiguration.createTopBPMContext();
//			context.setSession(dao.getSessionFactory().getCurrentSession());
			context.setSession(dao.getHibernateTemplate().getSessionFactory().openSession());
			//context.setSession(dao.getHibernateTemplate().getSessionFactory().getCurrentSession());
//			context.getProcessInstance(9);
			//List tasks = context.getTaskList(null);

			ProcessInstance processInstance = context.getProcessInstance(Long.parseLong(piid));
			processDefinition = processInstance.getProcessDefinition();
//			Iterator iter = tasks.iterator();

			/*
			while(iter.hasNext()){
				taskid = (TaskInstance)iter.next();
				processInstance = taskid.getContextInstance().get;
				processInstance.getId();
//				ProcNameTmp = (String)processInstance.getProcessDefinition().getName();
//				ContractTmp = (String)taskid.getVariable("contractno");
//				System.out.println("ProcName = " + ProcNameTmp + ": ContractTmp = " + ContractTmp);
				if( ProcNameTmp.equals(sProcName) && ContractTmp!= null && ContractTmp.equals(sContract)  ){
					return processInstance;
				}
			}

			*/
			context.close();
			return processInstance;
	}
	public TopBPMContext getContext() {
		return context;
	}
	public TopBPMConfiguration getTopbpmConfiguration() {
		return topbpmConfiguration;
	}
}
