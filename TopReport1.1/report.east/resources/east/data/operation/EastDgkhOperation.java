package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastDgkh;
import resources.east.data.service.EastDgkhService;

public class EastDgkhOperation extends BaseOperation {

	public static final String ID = "EastDgkhOperation";
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

		EastDgkh eastDgkh = (EastDgkh) context.getAttribute(IN_PARAM);

		EastDgkhService eastDgkhService = EastDgkhService.getInstance();

			eastDgkhService.modEntity(eastDgkh);
	}

}
