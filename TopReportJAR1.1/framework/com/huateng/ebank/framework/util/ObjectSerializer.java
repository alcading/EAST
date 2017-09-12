/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.framework.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.xerces.impl.dv.util.Base64;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1 $
 * @date 2005-7-14
 *  
 * 把一个类的实例与String之间互相转换.
 */
public class ObjectSerializer {
	public static String serialize(Object obj) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//GZIPOutputStream gos = new GZIPOutputStream(baos);
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		try {
			oos.writeObject(obj);
			//gos.finish();
			byte abyte0[] = baos.toByteArray();
			return new String(Base64.encode(abyte0));
		} finally {			
			oos.close();
			//gos.close();
			baos.close();
		}
	}//--serialize

	public static Object unserialize(String objectString) throws IOException,
			ClassNotFoundException {
		byte[] abyte1 = Base64.decode(objectString);
		ByteArrayInputStream bais = new ByteArrayInputStream(abyte1);
		//GZIPInputStream gis = new GZIPInputStream(bais);
		ObjectInputStream ois = new ObjectInputStream(bais);
		try {
			Object obj = ois.readObject();
			return obj;
		} finally {
			ois.close();
		}
	}//--unserialize

	
	public static void main(String[] argv) {
		try {
			/*
			 Loaninfo loaninfo = new Loaninfo();

			String nIStr = ObjectSerializer.serialize(loaninfo);
			System.out.println("nIStr.length = " + nIStr.length());
			loaninfo = (Loaninfo) ObjectSerializer.unserialize(nIStr);
			*/
			//System.out.println("nI.value = " + nI.intValue());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}