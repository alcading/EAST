package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastDkzq;
import resources.east.data.service.EastDkzqService;

public class EastDkzqOperation extends BaseOperation {

	public static final String ID = "EastDkzqOperation";
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

		String cmd = (String) context.getAttribute(CMD);
		EastDkzq eastDkzq = (EastDkzq) context.getAttribute(IN_PARAM);

		EastDkzqService eastDkzqService = EastDkzqService.getInstance();

		eastDkzqService.modEntity(eastDkzq);
		
		/*if (CMD_INSERT.equalsIgnoreCase(cmd)) {
			eastDkzqService.addEntity(eastDkzq);
		} else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
			eastDkzqService.modEntity(eastDkzq);
		} else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
			eastDkzqService.removeEntity(eastDkzq);
		}*/
	}

}
