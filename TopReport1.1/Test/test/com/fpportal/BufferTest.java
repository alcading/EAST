package test.com.fpportal;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huateng.report.send.bean.ReportBeanIn;
import com.huateng.report.send.utils.ReportParser;
import com.huateng.util.ContextUtil;

public class BufferTest extends TestCase {

//	public void testBufferMap() throws AppException {
//		ApplicationContext c = new ClassPathXmlApplicationContext("test/com/fpportal/buffer-AS400-0101.xml");
//		Buffer buf = (Buffer)(c.getBean("BUF_AS400_0101"));
//		Map map = new HashMap();
//		map.put("KHH", "0123456789");
//		map.put("ZJNX", "01");
//		buf.loadObject(map);
//		System.out.println(buf.outputString());
//	}
	public void testBufferObj() throws Exception {
		ApplicationContext c = new ClassPathXmlApplicationContext("test/com/fpportal/buffer-demo-0001.xml");
		ContextUtil.setContext(c);
		
		ReportBeanIn bb = new ReportBeanIn();
//		bb.setAppType("AC");
//		bb.setInOut("IN");
//		bb.getRecords().add(new BopCfaDofoexloDs());
//		bb.setBeanId("BUF_REPORT_0001");
//		bb.setBasePath("D:/Datas");
//		bb.setFilePath("tt");
//		bb.setFileName("BopCfaDofoexloDs01.xml");
////		ReportParser.getInstance().generateFile(bb);
//		
		
		bb = new ReportBeanIn();
		bb.setAppType("TT");
		bb.setInOut("IN");
		bb.getRecords().add("file1");
		bb.getRecords().add("file2");
		bb.setBeanId("tttt");
		bb.setBasePath("D:/Datas");
		bb.setFilePath("tt");
		bb.setFileName("tttt.txt");
		ReportParser.getInstance().generateFile(bb);
		
//		
//		XmlBeanParser parser = new XmlBeanParser();
//		parser.setBuffBeanId(ReportFeedBackCtrl.ID);
//		ReportFeedBackCtrl rfb = new ReportFeedBackCtrl();
//		rfb.setAppType("AA");
//		rfb.getFiles().add("aaa");
//		rfb.getFiles().add("222");
////		
////		System.out.println("CTRL:\n\r"+parser.convert2String(rfb));
////		Object o = parser.convert2Bean("<MSG><APPTYPE>应用类型</APPTYPE><CURRENTFILE>当前文件类型</CURRENTFILE><INOUT>输入/输出</INOUT><TOTALFILES>24</TOTALFILES><FILES><FILENAME>文件名1</FILENAME><FILENAME>文件名2</FILENAME></FILES></MSG>");
////		System.out.println(o);
//		
//
//		ReportFeedBackErrField field = new ReportFeedBackErrField();
//		field.setErrDesc("haha");
//		
//		ReportFeedBackErrRec rec = new ReportFeedBackErrRec();
//		rec.setBussno("BUS0001");
//		rec.getErrFields().add(field);
//
//		ReportFeedBackInfo rfbi = new ReportFeedBackInfo();
//		rfbi.getErrRecords().add(rec);
//		rfbi.getFormats().add("format1");
//		rfbi.getFormats().add("format2");
//		parser.setBuffBeanId(ReportFeedBackInfo.ID);
//		System.out.println("INFO:\n\r"+parser.convert2String(rfbi));
//		
//		Object o2 = parser.convert2Bean("<MSG><APPTYPE></APPTYPE><CURRENTFILE></CURRENTFILE><INOUT></INOUT><FORMATERRS></FORMATERRS><FORMATS><FORMAT>format1</FORMAT><FORMAT>format2</FORMAT></FORMATS><TOTALRECORDS></TOTALRECORDS><SUCRECORDS></SUCRECORDS><FALRECORDS></FALRECORDS><ERRRECORDS><REC><BUSSNO>BUS0001</BUSSNO><ERRFIELDS><ERR><ERRFIELD>cn</ERRFIELD><ERRFIELDCN>中文</ERRFIELDCN><ERRDESC>haha</ERRDESC></ERR><ERR><ERRFIELD>cn</ERRFIELD><ERRFIELDCN>中文2</ERRFIELDCN><ERRDESC>haha2</ERRDESC></ERR></ERRFIELDS></REC><REC><BUSSNO>BUS0001</BUSSNO><ERRFIELDS><ERR><ERRFIELD>cn</ERRFIELD><ERRFIELDCN>中文</ERRFIELDCN><ERRDESC>haha</ERRDESC></ERR><ERR><ERRFIELD>cn</ERRFIELD><ERRFIELDCN>中文2</ERRFIELDCN><ERRDESC>haha2</ERRDESC></ERR></ERRFIELDS></REC></ERRRECORDS></MSG>");
//		ReportFeedBackInfo rs = (ReportFeedBackInfo) o2;
//		System.out.println(rs);
		
	}
}
