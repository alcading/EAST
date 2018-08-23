package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastDgxdfhz;
import resources.east.data.service.EastDgxdfhzService;

public class EastDgxdfhzOperation extends BaseOperation {
   
	public static final String ID = "EastDgxdfhzOperation";
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
		EastDgxdfhz eastDgxdfhz  = (EastDgxdfhz) context.getAttribute(IN_PARAM);

		EastDgxdfhzService eastDgxdfhzService = EastDgxdfhzService.getInstance();

			eastDgxdfhzService.modEntity(eastDgxdfhz);
	}
	


}
