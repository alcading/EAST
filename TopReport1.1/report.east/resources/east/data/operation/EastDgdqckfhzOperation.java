package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastDgdqckfhz;
import resources.east.data.service.EastDgdqckfhzService;

public class EastDgdqckfhzOperation extends BaseOperation {
   
	public static final String ID = "EastDgdqckfhzOperation";
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
		EastDgdqckfhz eastDgdqckfhz  = (EastDgdqckfhz) context.getAttribute(IN_PARAM);

		EastDgdqckfhzService eastDgdqckfhzService = EastDgdqckfhzService.getInstance();

		if(CMD_INSERT.equalsIgnoreCase(cmd))
		{
			eastDgdqckfhzService.addEntity(eastDgdqckfhz);
		}else if(CMD_UPDATE.equalsIgnoreCase(cmd))
		{
			eastDgdqckfhzService.modEntity(eastDgdqckfhz);
		}else if(CMD_DELETE.equalsIgnoreCase(cmd))
		{
			eastDgdqckfhzService.removeEntity(eastDgdqckfhz);
		}
	}
	


}
