package com.huateng.ebank.framework.util;

import org.hibernate.LockMode;
import org.hibernate.dialect.SQLServerDialect;

public class HTSQLServerDialect extends SQLServerDialect {

	public String appendLockHint(LockMode mode, String tableName) {
		if ( mode.greaterThan(LockMode.READ) ) {
			if(mode == LockMode.UPGRADE){
				return tableName + " with (xlock, rowlock)";
			}else{
				return tableName + " with (updlock, rowlock)";
			}
		}
		else {
			return tableName;
		}
	}

}
