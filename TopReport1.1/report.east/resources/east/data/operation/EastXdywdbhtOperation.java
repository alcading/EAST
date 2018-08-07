package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastXdywdbht;
import resources.east.data.service.EastXdywdbhtService;

public class EastXdywdbhtOperation extends BaseOperation {

	public static final String ID = "EastXdywdbhtOperation";
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
		EastXdywdbht eastXdywdbht = (EastXdywdbht) context.getAttribute(IN_PARAM);

		EastXdywdbhtService eastXdywdbhtService = EastXdywdbhtService.getInstance();

		if (CMD_INSERT.equalsIgnoreCase(cmd)) {
			eastXdywdbhtService.addEntity(eastXdywdbht);
		} else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
			eastXdywdbhtService.modEntity(eastXdywdbht);
		} else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
			eastXdywdbhtService.removeEntity(eastXdywdbht);
		}
	}

}
