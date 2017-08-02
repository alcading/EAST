package com.huateng.ebank.topbpm.handle;

import java.sql.Statement;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.workflow.WorkFlowParamService;
import com.huateng.ebank.business.workflow.WorkFlowServiceHelper;
import com.huateng.topbpm.graph.def.ActionHandler;
import com.huateng.topbpm.graph.exe.ExecutionContext;

public class SetApproveTrans implements ActionHandler {
	private static final Logger logger = Logger.getLogger(SetApproveTrans.class);

	private static final long serialVersionUID = 1L;

	public void execute(ExecutionContext arg0) throws Exception {
		// TODO Auto-generated method stub
		logger.info("---------------Before TaskEnd---------------");
		Statement statement = null;
		try{
			Map map = arg0.getTaskInstance().getVariables();
			long taskId = arg0.getTaskInstance().getId();
			String procName = arg0.getProcessDefinition().getName();
			String nodeName = arg0.getNode().getName();
			long procInsId = arg0.getProcessInstance().getId();
			map.put("TASKID", Long.toString(taskId));
			map.put("PROC_NAME", procName);
			map.put("TASK_NAME", nodeName);
			map.put("PROC_INS_ID", Long.toString(procInsId));
			//当前岗位的roletype
			String roletype = "";
			map.put("ROLETYPE", roletype);
			map.put("LASTTLRNO", GlobalInfo.getCurrentInstance().getTlrno());
			map.put("MANUAL_ASSIGNED", "");
			//审批意见
			String status = (String) map.get("STATUS");
			Integer routeId = new Integer(map.get("ROUTE_ID").toString());
			Integer stopId =  new Integer(map.get("CURR_STOPID").toString());

			WorkFlowParamService workFlowParamService = WorkFlowParamService.getInstance();
			//同意则判断审批路线
			if(status.equals(WorkFlowServiceHelper.WORKFLOW_TRANS_AGREE)){
				//如果是手工指定下个分配人，则肯定要进行下次审批
				if(map.get("MANUAL_ASSIGNED").equals(SystemConstant.FLAG_ON)){
					status = WorkFlowServiceHelper.WORKFLOW_TRANS_AGREETOSUBMIT;

				}
				//不手工指定下个分配人
				else{
					//如果不能终审，也要进行下次审批
					if(map.get("CAN_FINAL_APPROVE").equals(SystemConstant.FLAG_OFF)){
						status = WorkFlowServiceHelper.WORKFLOW_TRANS_AGREETOSUBMIT;

					}
					//如果可以终审，判断剩余的审批路线有无必经站点
					else{
						boolean flag = workFlowParamService.hasNeedStop(routeId, stopId);
						//剩余有必经站点，则要进行下次审批
						if(flag == true ){
							status = WorkFlowServiceHelper.WORKFLOW_TRANS_AGREETOSUBMIT;

						}
						//剩余无必经站点，则审批结束
						else{
							status = WorkFlowServiceHelper.WORKFLOW_TRANS_AGREE;

						}
					}

				}

			}
			//拒绝则判断剩余的审批路线有无必经站点
			else if(status.equals(WorkFlowServiceHelper.WORKFLOW_TRANS_REFUSE)){
				boolean flag = workFlowParamService.hasNeedStop(routeId, stopId);
				//剩余有必经站点，则要进行下次审批
				if(flag == true ){
					status = WorkFlowServiceHelper.WORKFLOW_TRANS_AGREETOSUBMIT;

				}
				//剩余无必经站点，则审批结束
				else{
					status = WorkFlowServiceHelper.WORKFLOW_TRANS_REFUSE;

				}
			}
			map.put("STATUS", status);

			//流转
			arg0.getNode().leave(arg0, status);
//			arg0.getTaskInstance().end(status);

			logger.info("---------------TaskEnd---------------");
			logger.info("nextNode = " + arg0.getNode().getName());

		}catch(Exception ex){
			throw ex;
		}
	}
}