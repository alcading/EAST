package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastDkwjxtbd;
import resources.east.data.service.EastDkwjxtbdService;

public class EastDkwjxtbdOperation extends BaseOperation {

	public static final String ID = "EastDkwjxtbdOperation";
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
		EastDkwjxtbd eastDkwjxtbd = (EastDkwjxtbd) context.getAttribute(IN_PARAM);

		EastDkwjxtbdService eastDkwjxtbdService = EastDkwjxtbdService.getInstance();

		eastDkwjxtbdService.modEntity(eastDkwjxtbd);
		
		/*if (CMD_INSERT.equalsIgnoreCase(cmd)) {
			eastDkwjxtbdService.addEntity(eastDkwjxtbd);
		} else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
			eastDkwjxtbdService.modEntity(eastDkwjxtbd);
		} else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
			eastDkwjxtbdService.removeEntity(eastDkwjxtbd);
		}*/
	}

}
