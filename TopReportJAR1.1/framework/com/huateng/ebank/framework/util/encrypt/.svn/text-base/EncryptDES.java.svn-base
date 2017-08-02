/*
 * Created on 2005-2-21
 * $Id: EncryptDES.java,v 1.1 2005/06/21 10:45:27 liuwen Exp $
 *
 * Copyright 2005 Shanghai Huateng Software, Limited. All rights reserved.
 * HUATENG PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * $Log: EncryptDES.java,v $
 * Revision 1.1  2005/06/21 10:45:27  liuwen
 * *** empty log message ***
 *
 * Revision 1.1.1.1  2005/06/13 12:36:59  liuwen
 * import
 *
 * Revision 1.1  2005/04/05 08:29:57  liuwen
 * adding workflow related functionality.
 *
 * Revision 1.1.1.1  2005/03/21 06:21:07  liuwen
 * Initialization.
 *
 */
package com.huateng.ebank.framework.util.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

/**
 * @author liu_wen@huateng.com
 *
 * Standard DES method implementation.
 */


public class EncryptDES {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EncryptDES.class);

    private String key;
    private String iv;
    private String operMode;

    public EncryptDES() {
        key         = "12345678";
        iv          = "12345678";
        operMode    = "DES/CBC/NoPadding";
    }

	//加密
	private byte[] inDES(byte[] sourceByte, SecretKey key, String operMode, IvParameterSpec iv) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("inDES(byte[], SecretKey, String, IvParameterSpec) - start"); //$NON-NLS-1$
		}

        Cipher cipher = Cipher.getInstance(operMode);
        //初始化加密类，定义模式，密匙，IV
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		byte[] returnbyteArray = cipher.doFinal(sourceByte);
		if (logger.isDebugEnabled()) {
			logger.debug("inDES(byte[], SecretKey, String, IvParameterSpec) - end"); //$NON-NLS-1$
		}
        return returnbyteArray;

	}

	//解密
	private byte[] outDes(byte[] sourceByte, SecretKey key, String operMode, IvParameterSpec iv) throws Exception{
		if (logger.isDebugEnabled()) {
			logger.debug("outDes(byte[], SecretKey, String, IvParameterSpec) - start"); //$NON-NLS-1$
		}

        Cipher cipher = Cipher.getInstance(operMode);
        //初始化加密类，定义模式，密匙，IV
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] returnbyteArray = cipher.doFinal(sourceByte);
		if (logger.isDebugEnabled()) {
			logger.debug("outDes(byte[], SecretKey, String, IvParameterSpec) - end"); //$NON-NLS-1$
		}
        return returnbyteArray;
	}

	//按8的倍数补位0x00
	public static byte[] doPadding(byte[] sourceByte)throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("doPadding(byte[]) - start"); //$NON-NLS-1$
		}

		byte[] returnByte;
		int bytelen;
		int intValue;
		double douValue;

		bytelen = sourceByte.length;
		douValue =(double)bytelen/8;
		intValue = (int)douValue;

		//判断是否是整数
		if (douValue > intValue) {

			intValue = intValue +1;
			returnByte = new byte[intValue*8];

			for (int i=0; i<bytelen; i++) {
				returnByte[i] = sourceByte[i];
			}

			for (int i=bytelen; i<intValue*8; i++) {
				returnByte[i] = 0x00;
			}
		}
		else {
			returnByte = new byte[intValue*8];
			returnByte = sourceByte;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("doPadding(byte[]) - end"); //$NON-NLS-1$
		}
		return returnByte;
	}

	//切除0x00
	public static byte[] cutPadding(byte[] sourceByte) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("cutPadding(byte[]) - start"); //$NON-NLS-1$
		}

		int bytelen = 0;
		for (int i = 0; i < sourceByte.length; i++) {
			if (sourceByte[i] == (byte) 0x00) {
          		bytelen = i;
          		break;
        	}
        	else {
          		bytelen = sourceByte.length;
        	}
      	}

      	byte[] returnByte = new byte[bytelen];

      	for (int i = 0; i < bytelen; i++) {
			returnByte[i] = sourceByte[i];
      	}

		if (logger.isDebugEnabled()) {
			logger.debug("cutPadding(byte[]) - end"); //$NON-NLS-1$
		}
      	return returnByte;
    }

	//获取密钥
  	public static SecretKey genDESKey(byte[] keyByte) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("genDESKey(byte[]) - start"); //$NON-NLS-1$
		}

    	SecretKey key = null;
    	key = new SecretKeySpec(keyByte, "DES");

		if (logger.isDebugEnabled()) {
			logger.debug("genDESKey(byte[]) - end"); //$NON-NLS-1$
		}
    	return key;
  	}

	//产生偏移量
  	public static IvParameterSpec genDESIv(byte[] ivByte) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("genDESIv(byte[]) - start"); //$NON-NLS-1$
		}

    	IvParameterSpec iv = null;
    	iv = new IvParameterSpec(ivByte);

		if (logger.isDebugEnabled()) {
			logger.debug("genDESIv(byte[]) - end"); //$NON-NLS-1$
		}
    	return iv;
  	}

	//加密
    public byte[] doEncrypt(byte[] inByte) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("doEncrypt(byte[]) - start"); //$NON-NLS-1$
		}

        //System.out.println("取得的密钥:"+byte2hex(inInfo.getBytes()));

        byte[] useSource = doPadding(inByte);

        SecretKey useKey = genDESKey(key.getBytes());

        IvParameterSpec useIv = genDESIv(iv.getBytes());

        String useOperMode	= operMode;

        byte[] byteOut = inDES(useSource, useKey, useOperMode, useIv);

        //System.out.println("加密后的二进串:"+byte2hex(byteOut));


		if (logger.isDebugEnabled()) {
			logger.debug("doEncrypt(byte[]) - end"); //$NON-NLS-1$
		}
        return byteOut;
	}

    //解密
    public byte[] doDecrypt(byte [] inByte) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("doDecrypt(byte[]) - start"); //$NON-NLS-1$
		}

			SecretKey useKey = genDESKey(key.getBytes());

			IvParameterSpec useIv = genDESIv(iv.getBytes());

			String useOperMode	= operMode;

			byte[] byteOut = outDes(inByte, useKey, useOperMode, useIv);

			byteOut = cutPadding(byteOut);

			//System.out.println("解密后的二进串:"+byte2hex(byteOut));


		if (logger.isDebugEnabled()) {
			logger.debug("doDecrypt(byte[]) - end"); //$NON-NLS-1$
		}
			return byteOut;
    }

	//二行制转字符串
	public	static String byte2hex(byte[] b){
		if (logger.isDebugEnabled()) {
			logger.debug("byte2hex(byte[]) - start"); //$NON-NLS-1$
		}

		String hs="";
		String stmp="";

		for (int n=0;n<b.length;n++){
			stmp=(java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length()==1) hs=hs+"0"+stmp;
			else hs=hs+stmp;
			if (n<b.length-1)  hs=hs+":";
		}


		String returnString = hs.toUpperCase();
		if (logger.isDebugEnabled()) {
			logger.debug("byte2hex(byte[]) - end"); //$NON-NLS-1$
		}
		return returnString;

	}
	/**
	 * @return Returns the iv.
	 */
	public String getIv() {
		return iv;
	}
	/**
	 * @param iv The iv to set.
	 */
	public void setIv(String iv) {
		this.iv = iv;
	}
	/**
	 * @return Returns the key.
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key The key to set.
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return Returns the operMode.
	 */
	public String getOperMode() {
		return operMode;
	}
	/**
	 * @param operMode The operMode to set.
	 */
	public void setOperMode(String operMode) {
		this.operMode = operMode;
	}

	public static void main(String s[])	{
		if (logger.isDebugEnabled()) {
			logger.debug("main(String[]) - start"); //$NON-NLS-1$
		}

		try {
			EncryptDES ee = new EncryptDES();

			String a = new String();

			//a ="<?xml abc !@%^^*^*I*>12124";

			a = "中国123法国浦发银行abcd单证中心系统";
			byte[] abc = a.getBytes("UTF-8");
			abc = ee.doEncrypt(abc);

			byte[] tempEncodeByte = Base64Encode.byBase64Encode(abc);
			//String testStr = new String(tempEncodeByte,"UTF-8");

			String testStr = "S078JKKtSvAMWap/sIGpd4eiphXoB0MB8EfFuFogsz8J06DWPBdsx13JqPWTLIL76I8uvZFcxeYtPuL2CxviLXrTAXa6SIO6U7pzErlCJYRFMwYCnLby25Jh0HIxv+nVJ76rJSryt/fPpRmCxqPbPuw1+MB+Zvz+vKO/G/CyUqnUMa4K7ZHZ/x7hUogg3bGxfKO0u/G9Qx3R50RlZP+IOMFAaz7GF/N2zSWLjZh0E/1eAwXvQjXpa4cV1czMe0oRdgxBGjOepMDszuJSGwLXuThC84IhGpZNVG5Em3bvWAOPJflyrbBDSRv7t2tloJJgNUg4BIZPPIqnqBPraQ12jxdPTNno5wvihUBBcKjeN4JjLX+OpF0IpE+Pse7RBdw2wyG6FiWiEPPcqbfe8LxGIU+4VS9O4H7Hf5CP401lM1+rcqqcTaL+IDqHyoerZwZTgpUpwi1nbNlIOFVNOjosqfJU66FzQ4dMs3uvAgWZsAraMtTpO80Q/iKsNNLR3NsfcJCgpBlaIA+OIgexBcTPsd1nk9wu/5p3s0W9c9224O4Nft9u/butTrBzFpwV2usIXNcTaSG8KvOOgDHY6Q2Kt7DAxfCGqka+WcXwKiwh4ws5fgmVEBmwHjLxrNezkuJU+/TAmh6EBt2kpNnUBbRPSRS6PbYQx47NLNhsT929aeHjOE3cHtfPPRCmz8ZgeoCpViR0MR9OmN5ULvyftuBLMidTt5PaRVTGcshxQjNO+X9c7gEGgpK6qDKirh9ySZvAjhgc79i3cEsmM6rU1weQRaYj9BnzRUq4gB9OClTeuZTAamTc0ywRM/XS0RmWHlZAc5XYKwZ05S4rLgMIKFdcKMNHDItRViETo0oHXRKuhDjmMO0SmXviNmrALsXtvNaJFNjO20TgXuzjLOSnVF4hLyHXoz4IkyljQ8kScSkpCDSDpVpfPTcKuage385014ZLccWV6+DY2yacLOgWuLxHA1kMwtjXBCGF4vNGg3dPY2vhMkTe2UYj+3eMMH34fdgu3leY+e/RbaskQa+caOxp/7S+gKnLO4miwcIUTfTTKzBIAU3MmaYPC4QqZ+8HvQw/ZQn/IjlNe5B9W0nJU/xapoV1vKNUdBLR7oq6FJ9JQOsGNBL0fA0KAtjRowYSpWyEgEXRPQx8rr6CyK7bdrFPi/ZY8/dWqC0dXpXDidWQQtemlbl8mxz9mg==";
			//System.out.println("testStr is " + testStr);
			byte[] tempDescodeByte = Base64Encode.byBase64Descode(testStr.getBytes());
			//abc = tempDescodeByte;
			abc = ee.doDecrypt(tempDescodeByte);
			String b = new String(abc,"UTF-8");
			if (logger.isDebugEnabled()) {
				logger.debug("main(String[]) - result is " + b); //$NON-NLS-1$
			}
		}
		catch (Exception e) {
			logger.error("main(String[])", e); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("main(String[]) - end"); //$NON-NLS-1$
		}
	}
}
