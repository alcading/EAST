package resources.finstandard.data.operation;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resources.finstandard.data.pub.LoanAmount;
import resources.finstandard.data.service.LoanAmountService;

public class LoanAmountOperation extends BaseOperation{

	public static final HtLog htLog = HtLogFactory.getLogger(LoanAmountOperation.class);
	
	public static final String ID = "LoanAmountOperation";
	public static final String CMD = "CMD";
	
	public static final String OP_MOD_LOAF = "OP_MOD_LOAF";   //修改贷款发生额信息
	public static final String OP_DEL_LOAF = "OP_DEL_LOAF";   //删除贷款发生额信息
	public static final String OP_QRY_LOAF = "OP_QRY_LOAF";   //查询贷款发生额概要信息
	public static final String OP_QDL_LOAF = "OP_QDL_LOAF";   //查询贷款发生额详细信息

	public static final String IN_MOD_LOAF = "OP_MOD_LOAF";   //修改贷款发生额信息
	public static final String IN_DEL_LOAF = "OP_DEL_LOAF";   //删除贷款发生额信息
	public static final String IN_QRY_LOAF = "OP_QRY_LOAF";   //查询贷款发生额概要信息
	public static final String IN_QDL_LOAF = "OP_QDL_LOAF";   //查询贷款发生额详细信息

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		LoanAmountService loanAmountService = LoanAmountService.getInstance();
		if(OP_QRY_LOAF.equals(cmd)){
			LoanAmount loanAmount = (LoanAmount)context.getAttribute(IN_QRY_LOAF);
		}
	}
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
	}
}
