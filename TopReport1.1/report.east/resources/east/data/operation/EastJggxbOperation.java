package resources.east.data.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.east.data.pub.EastJggxb;
import resources.east.data.service.EastJggxbService;

public class EastJggxbOperation extends BaseOperation {
   
	public static final String ID = "EastJggxbOperation";
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
		
		EastJggxb eastJggxb  = (EastJggxb) context.getAttribute(IN_PARAM);

		EastJggxbService eastJggxbService = EastJggxbService.getInstance();
		
		if(CMD_INSERT.equalsIgnoreCase(cmd))
		{
			eastJggxbService.addEntity(eastJggxb);
		}else if(CMD_UPDATE.equalsIgnoreCase(cmd))
		{
			eastJggxbService.saveOrUpdateEntity(eastJggxb);
		}else if(CMD_DELETE.equalsIgnoreCase(cmd))
		{
			eastJggxbService.removeEntity(eastJggxb);
		}
		
		
	}
	


}
