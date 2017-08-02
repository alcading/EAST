/**
 *
 */
package com.huateng.ebank.business.workflow.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: WorkflowStatusMap
 * Description:
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-25
 */
public class WorkflowStatusMap {

	public static Map statusMap = new HashMap();
	static{
		statusMap.put(new Integer(0), "Agree");
		statusMap.put(new Integer(1), "ToSubCtr");
		statusMap.put(new Integer(2), "ToCtr");
		statusMap.put(new Integer(3), "SubBrhPreApv");
		statusMap.put(new Integer(4), "SubBrhMeeting");
		statusMap.put(new Integer(5), "SubBrhApv");
		statusMap.put(new Integer(6), "TotBrhPreApv");
		statusMap.put(new Integer(7), "TotBrhApv");
		statusMap.put(new Integer(8), "Loan");
		statusMap.put(new Integer(9), "Refuse");
		statusMap.put(new Integer(10), "GoBack");
		statusMap.put(new Integer(11), "Submit");
		statusMap.put(new Integer(12), "Skip");
		statusMap.put(new Integer(99), "ToEnd");
		statusMap.put(new Integer(100),"ToNext");
	}
	public static String getStatus(Integer status){
		return (String)statusMap.get(status);
	}

}
