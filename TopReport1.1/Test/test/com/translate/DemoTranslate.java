package test.com.translate;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.huateng.ebank.business.common.ConfigReader;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.exception.AppException;
import com.huateng.report.send.translate.FTPTranslate;
import com.huateng.report.send.translate.TokenLockException;
import com.huateng.report.send.translate.TransFactory;


    
public class DemoTranslate {
    
	//FTP的使用
	@Test
	public void testFTP() throws SocketException, IOException, AppException, TokenLockException {		
		ApplicationContextUtils.init("com/huateng/report/system/services.xml");
		FTPTranslate translate =(FTPTranslate)TransFactory.getInstence();
		
		String url=ConfigReader.getProperty("afterAnalyze_ip");
		int port=Integer.parseInt(ConfigReader.getProperty("afterAnalyze_port"));
		String username=ConfigReader.getProperty("afterAnalyze_username");
		String password=ConfigReader.getProperty("afterAnalyze_password");
		String ftpPath=ConfigReader.getProperty("afterAnalyze_ftpPath");
		String sourcePath=ConfigReader.getProperty("afterAnalyze_path");
		
		Map map=new HashMap();
		map.put("url", url);
		map.put("port", port);
		map.put("username",username);
		map.put("password", password);
		map.put("ftpPath", ftpPath);
		map.put("sourcePath", sourcePath);
		
		//translate.init(map);
		Map fileMap=new HashMap();
		List fileName=new ArrayList();
		fileName.add("person1.xml");
		fileName.add("person2.xml");
		fileName.add("person3.xml");
		fileName.add("person4.xml");
		fileMap.put("fileName", fileName);
//		try {
//		//	translate.send(fileMap);
//		} catch (TokenLockException e) {
//			System.out.print("文件正处于操作状态!");
//			e.printStackTrace();
//		}
		Map files=new HashMap();
		files.put("files", fileName);
		files.put("feedBackPath", "e:/feedBack/");
//		try {
//			translate.feedBack(files);
//		} catch (TokenLockException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}   
	
	//文件夹的使用
//	@Test
//	public void testFiles() throws SocketException, IOException, AppException {
//		ApplicationContextUtils.init("com/huateng/report/system/services.xml");
//		FILETranslate translate=(FILETranslate)ContextUtil.getBean(FILETranslate.class.getName());
//		
//		String targetPath = ConfigReader.getProperty("move_path");
//		String sourcePath = ConfigReader.getProperty("afterAnalyze_path");
//		
//		Map map=new HashMap();
//		map.put("targetPath", targetPath);
//		map.put("sourcePath", sourcePath);
//				
//	//	translate.init(map);
//		Map fileMap=new HashMap();
//		List fileName=new ArrayList();
//		fileName.add("person1.xml");
//		fileName.add("person2.xml");
//		fileName.add("person3.xml");
//		fileName.add("person4.xml");
//		fileMap.put("fileName", fileName);
////		try {
//		//	translate.send(fileMap);
////		} catch (TokenLockException e) {
////			System.out.println("有文件正处于操作状态！");
////			e.printStackTrace();
////			return;
////		}
//		Map files=new HashMap();
//		files.put("files", fileName);
//		files.put("feedBackPath", "e:/feedBack/");
//		Map aa=new HashMap();
//		try {
//			aa=translate.feedBack(files);
//		} catch (TokenLockException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}	
}   
