package com.huateng.hibernate.dialect.seq;

import java.math.BigDecimal;
import org.hibernate.HibernateException;
import com.huateng.exception.AppException;

public class HTOracle10DialectSeq extends _DialectSeq {

	private String defaultCreateSequece ="CREATE SEQUENCE ${1} START WITH 1  INCREMENT BY 1 NOMAXVALUE  NOCYCLE NOCACHE";

	private String getNextSequence = "SELECT ${1}.nextval from dual";

	//当前无用
	public Integer getSeqNo(String sequenceName) throws AppException{
		String flag = (String) squenceMap.get(sequenceName);
		if(flag!=null && flag.equals("true")){
				getNextSequence = getNextSequence.replace("${1}", sequenceName);
			try {
				return ((BigDecimal)createSQLQuery(getNextSequence).get(0)).intValue();
			} catch (HibernateException e) {
				logger.error("取下个序号sequenceName :"+sequenceName+"失败" );
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				logger.error("取下个序号sequenceName :"+sequenceName+"失败" );
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			throw new AppException("当前序号没有在generatorRegister.xml 的sequenceList 定义过" + sequenceName);

		}
		return null;

	}

	/**
	 * 初始化话当前的生成器
	 */
	public void initSeqGenerator() {
		try{
			createAndCheckSequence(getNextSequence,defaultCreateSequece);
		}catch(AppException e){}
	}

}
