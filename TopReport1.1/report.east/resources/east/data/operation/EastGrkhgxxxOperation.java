package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastGrkhgxxx;
import resources.east.data.service.EastGrkhgxxxService;

public class EastGrkhgxxxOperation extends BaseOperation {
   
	public static final String ID = "EastGrkhgxxxOperation";
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

		EastGrkhgxxx eastGrkhgxxx  = (EastGrkhgxxx) context.getAttribute(IN_PARAM);

		EastGrkhgxxxService eastGrkhgxxxService = EastGrkhgxxxService.getInstance();

			eastGrkhgxxxService.modEntity(eastGrkhgxxx);
	}
	


}
