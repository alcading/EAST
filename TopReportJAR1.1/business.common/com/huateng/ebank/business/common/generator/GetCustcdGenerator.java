/**
 *
 */
package com.huateng.ebank.business.common.generator;

import java.util.Map;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

/**
 *
 * <p>
 *
 * @Title: GetCustcdGenerator
 *                                </p>
 *                                <p>
 * @Created time: 下午04:24:04 2011-1-22
 *          </p>
 *          <p>
 * @Company:上海华腾软件系统有限公司
 *          </p>
 *          <p>
 * @description:创建客户号
 *          </p>
 *          <p>
 * @Author: zhushijie
 *          </p>
 *          <p>
 * @Version: 1.0
 *           </p>
 */

public class GetCustcdGenerator extends BaseGenerator{

	/* (non-Javadoc)
	 * @see com.huateng.commquery.cfieldmodel.BaseGenerator#gen(java.util.Map)
	 */
	public String gen(Object obj) throws CommonException{
		// TODO Auto-generated method stub
		Map paramMap = (Map)obj;
//		String corpCodeType = (String)paramMap.get("corpCodeType");
//		String regNo = (String)paramMap.get("regNo");
		String custType = (String)paramMap.get("custType");
		String corpCodeType = (String)paramMap.get("corpCodeType");
		StringBuffer buffer = new StringBuffer("");

		//判断
		if(SystemConstant.CUST_TYPE_NATURAL.equals(custType)){  // 自然人。
			buffer.append("G");
			buffer.append(DataFormat.intToString(CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_CUSTCD, "0" ), 7));
		}
		if(SystemConstant.CUST_TYPE_ARTIFICIAL.equals(custType) ){ // 对公客户 (内部客户)
			//产生新客户编号，编号规则：客户编码类型（1位）+顺序号（7位）
			if(corpCodeType!=null){  //
				buffer.append(corpCodeType);
				buffer.append(DataFormat.intToString(CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_CUSTCD, "0"),7));
			}
		}

		return buffer.toString();
	}

}
