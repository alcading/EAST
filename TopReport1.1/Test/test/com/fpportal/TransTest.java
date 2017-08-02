package test.com.fpportal;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huateng.report.send.translate.ITranslate;
import com.huateng.report.send.translate.TransFactory;
import com.huateng.util.ContextUtil;

public class TransTest extends TestCase {
	//
	// public void testFileTrans() throws Exception {
	// ITranslate tran = new FILETranslate();
	// if (tran.init("D:/Datas/", "D:/Datas2/")) {
	// tran.send("tt", "BopCfaDofoexloDs01.xml");
	// tran.send("tt", "BopCfaDofoexloDs02.xml");
	// tran.send("tt", "BopCfaDofoexloDs03.xml");
	// tran.send("tt2", "BopCfaDofoexloDs01.xml");
	// tran.send("tt2", "BopCfaDofoexloDs02.xml");
	// tran.send("tt2", "BopCfaDofoexloDs03.xml");
	//
	// Map<String, List<String>> m = new HashMap<String, List<String>>();
	// m.put("tt", null);
	// m.put("tt2", null);
	// tran.feedBack(m);
	// tran.close();
	// }
	//
	// }

	public void testFtpTrans() throws Exception {
		ApplicationContext c = new ClassPathXmlApplicationContext(
				"com/huateng/report/imports/services.xml");
		ContextUtil.setContext(c);
		ITranslate tran = TransFactory.getInstence();
		// FTPTranslate tran = new FTPTranslate();
		// tran.setUrl("127.0.0.1");
		// tran.setUsername("test");
		// tran.setPassword("test");
		// tran.setPort(21);

		if (tran.init("D:/Datas/CFAData/", "ACCData/")) {
			//tran.send("tt", "BopCfaDofoexloDs01.xml");
//			tran.send("tt", "BopCfaDofoexloDs02.xml");
//			tran.send("D:/Datas/", "CFAData/", "tt", "BopCfaDofoexloDs03.xml");
//			tran.send("D:/Datas/", "CFAData/", "tt2", "BopCfaDofoexloDs01.xml");
//			tran.send("tt2", "BopCfaDofoexloDs02.xml");
//			tran.send("tt2", "BopCfaDofoexloDs03.xml");
//
//			try {
//				m.put("tt2", null);
				tran.feedBack("tt");
//				tran.feedBack("D:/Datas/ACCData/", "ACCData", m);
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
				tran.close();
//			}
		}

	}
}
