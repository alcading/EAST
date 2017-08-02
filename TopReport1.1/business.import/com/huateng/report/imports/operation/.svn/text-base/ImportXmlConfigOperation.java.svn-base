package com.huateng.report.imports.operation;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.imports.service.ImportXmlConfigService;


public class ImportXmlConfigOperation extends BaseOperation {
    private static Log log = LogFactory.getLog(ImportXmlConfigOperation.class);

    public static final String IN_DEL = "IN_DEL";

    public static final String IN_INSERT = "IN_INSERT";

    public static final String IN_UPDATE = "IN_UPDATE";

    /* (non-Javadoc)
     * @see com.huateng.ebank.framework.operation.BaseOperation#beforeProc(com.huateng.ebank.framework.operation.OperationContext)
     */
    @Override
	public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see com.huateng.ebank.framework.operation.BaseOperation#execute(com.huateng.ebank.framework.operation.OperationContext)
     */
    @Override
	public void execute(OperationContext context) throws CommonException {
        if (log.isDebugEnabled()) {
            log.debug("enter into execute");
        }
//        /** add by jornezhang 20100108 BMS-2362  增加交易流水记录 begin */
//        TxtNumRecordUtil.getInstance().resetGlobalDataAllBlank();
//        /** add by jornezhang 20100108 BMS-2362  增加交易流水记录 end */

        List delList = (List) context.getAttribute(IN_DEL);

        List insertList = (List) context.getAttribute(IN_INSERT);

        List updateList = (List) context.getAttribute(IN_UPDATE);

        ImportXmlConfigService importConfigService = ImportXmlConfigService.getInstance();

        importConfigService.saveDelUpdata(delList,insertList,updateList);


//        context.setAttribute(OUT_PARAM_All_RESULT,result);

        if (log.isDebugEnabled()) {
            log.debug("Exit execute");
        }
    }

    /* (non-Javadoc)
     * @see com.huateng.ebank.framework.operation.BaseOperation#afterProc(com.huateng.ebank.framework.operation.OperationContext)
     */
    @Override
	public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }

}