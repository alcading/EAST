package resources.east.data.operation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.basis.operation.BiDayExchangeRateOperation;
import com.huateng.report.basis.service.BiAccountService;
import com.huateng.report.basis.service.BiDayExchangeRateService;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.pub.Bctl;
import resource.bean.report.BiAccount;
import resource.bean.report.BiDayexchangerate;
import resource.bean.report.SysTaskInfo;
import resource.dao.pub.BctlDAO;
import resources.east.data.pub.EastJgxxbTmp;
import resources.east.data.service.EastJgxxbTmpService;
import resources.east.data.update.BranchManageUpdateOperation;

public class EastJgxxbOperation extends BaseOperation {
   
	private static final HtLog htlog=HtLogFactory.getLogger(EastJgxxbOperation.class);
	public static final String ID = "EastJgxxbOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {

		String cmd = (String)context.getAttribute(CMD);
		EastJgxxbTmp eastJgxxb  = (EastJgxxbTmp) context.getAttribute(IN_PARAM);

		EastJgxxbTmpService eastJgxxbService = EastJgxxbTmpService.getInstance();

		if(CMD_INSERT.equalsIgnoreCase(cmd))
		{
			eastJgxxbService.addEntity(eastJgxxb);
		}else if(CMD_UPDATE.equalsIgnoreCase(cmd))
		{
			eastJgxxbService.modEntity(eastJgxxb);
		}else if(CMD_DELETE.equalsIgnoreCase(cmd))
		{
			eastJgxxbService.removeEntity(eastJgxxb);
		}
	}

}
