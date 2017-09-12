package com.huateng.ebank.framework.proxool;

import org.bouncycastle.util.encoders.Hex;

import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.util.encrypt.CryptoUtil;

public class EbankProxoolDataSource extends org.logicalcobwebs.proxool.ProxoolDataSource {

	@Override
	public void setPassword(String password) {
		super.setPassword(new String(CryptoUtil.decrypt(Hex.decode(password), SystemConstant.DEFAULT_PASSWORD_KEY)));
	}

}
