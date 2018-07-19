package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastNbfhz;
import resources.east.data.service.EastNbfhzService;

public class EastNbfhzOperation extends BaseOperation {
   
	public static final String ID = "EastNbfhzOperation";
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
		EastNbfhz eastNbfhz  = (EastNbfhz) context.getAttribute(IN_PARAM);

		EastNbfhzService eastNbfhzService = EastNbfhzService.getInstance();

		if(CMD_INSERT.equalsIgnoreCase(cmd))
		{
			eastNbfhzService.addEntity(eastNbfhz);
		}else if(CMD_UPDATE.equalsIgnoreCase(cmd))
		{
			eastNbfhzService.modEntity(eastNbfhz);
		}else if(CMD_DELETE.equalsIgnoreCase(cmd))
		{
			eastNbfhzService.removeEntity(eastNbfhz);
		}
	}
	


}
