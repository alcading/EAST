/**
 * 
 */
package com.huateng.ebank.business.common.generator;

import com.huateng.commquery.cfieldmodel.base.IGenerator;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.hibernate.dialect.seq.IDialectSeq;

/**
 * Title: GenertorFactory
 * Description: 
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GeneratorFactory {
	/**序号生成器接口声明**/
	public static IDialectSeq dialectSeq ;
	/**
	 * @param beanId
	 * @return
	 */
	public static IGenerator getGenerator(String beanId){
		return (IGenerator)ApplicationContextUtils.getBean(beanId);
	}
	
	/**取得配置信息**/
	public static IDialectSeq getDialectSeq(){
		if(dialectSeq ==null){
			dialectSeq = (IDialectSeq) ApplicationContextUtils.getBean("GetDataSeqGenerator");
			dialectSeq.initSeqGenerator();
		}
		return dialectSeq;
	}
}
