package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastLccpxsmxjl;
import resources.east.data.service.EastLccpxsmxjlService;

public class EastLccpxsmxjlOperation extends BaseOperation {
   
	public static final String ID = "EastLccpxsmxjlOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";

	@Override
	public void afterProc(OperationContext context) throws CommonException {

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {

	}

	@Override
	public void execute(OperationContext context) throws CommonException {

		String cmd = (String)context.getAttribute(CMD);
		EastLccpxsmxjl eastLccpxsmx  = (EastLccpxsmxjl) context.getAttribute(IN_PARAM);

		EastLccpxsmxjlService eastLccpxsmxService = EastLccpxsmxjlService.getInstance();

		if(CMD_INSERT.equalsIgnoreCase(cmd))
		{
			eastLccpxsmxService.addEntity(eastLccpxsmx);
		}else if(CMD_UPDATE.equalsIgnoreCase(cmd))
		{
			eastLccpxsmxService.modEntity(eastLccpxsmx);
		}else if(CMD_DELETE.equalsIgnoreCase(cmd))
		{
			eastLccpxsmxService.removeEntity(eastLccpxsmx);
		}
	}
	


}
