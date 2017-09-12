package com.huateng.ebank.framework.util;

import com.huateng.hibernate.dialect.HTDB2Dialect;

public class NHTDB2Dialect extends HTDB2Dialect {
	
    public String getForUpdateString()
    {
        return " for update with rs";
    }

}
