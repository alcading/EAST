package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastDgbwsxyw;
import resources.east.data.service.EastDgbwsxywService;

public class EastDgbwsxywOperation extends BaseOperation {

	public static final String ID = "EastDgbwsxywOperation";
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

		EastDgbwsxyw eastDgbwsxyw = (EastDgbwsxyw) context.getAttribute(IN_PARAM);

		EastDgbwsxywService eastDgbwsxywService = EastDgbwsxywService.getInstance();

		eastDgbwsxywService.modEntity(eastDgbwsxyw);
	}

}
