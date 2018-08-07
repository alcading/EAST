package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastPjpmxxb;
import resources.east.data.service.EastPjpmxxbService;

public class EastPjpmxxbOperation extends BaseOperation {

	public static final String ID = "EastPjpmxxbOperation";
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
		EastPjpmxxb eastPjpmxxb = (EastPjpmxxb) context.getAttribute(IN_PARAM);

		EastPjpmxxbService eastPjpmxxbService = EastPjpmxxbService.getInstance();

		if (CMD_INSERT.equalsIgnoreCase(cmd)) {
			eastPjpmxxbService.addEntity(eastPjpmxxb);
		} else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
			eastPjpmxxbService.modEntity(eastPjpmxxb);
		} else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
			eastPjpmxxbService.removeEntity(eastPjpmxxb);
		}
	}

}
