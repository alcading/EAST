package com.huateng.ebank.framework.util.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;

import sun.net.TelnetInputStream;
import sun.net.ftp.FtpClient;

/**
 * ftp上传，下载
 *  
 * @author jonay
 * 
 */
public class FtpUtil {

	private String ip = "";

	private String username = "";

	private String password = "";

	private int port = -1;

	private int TIMEOUT = 600000;

	private String path = "";

	private FtpClient ftpClient = null;

	private OutputStream os = null;

	private FileInputStream is = null;

	public FtpUtil(String serverIP, String username, String password) {
		this.ip = serverIP;
		this.username = username;
		this.password = password;
	}

	public FtpUtil(String serverIP, int port, String username, String password) {
		this.ip = serverIP;
		this.username = username;
		this.password = password;
		this.port = port;
	}

	/**
	 * 连接ftp服务器
	 * 
	 * @throws IOException
	 */
	public boolean connectServer(int ftpMode) {
//		ftpClient = new FtpClient();
//		try {
//			ftpClient.setReadTimeout(TIMEOUT);
//			if (this.port != -1) {
//				ftpClient.openServer(this.ip, this.port);
//			} else {
//				ftpClient.openServer(this.ip);
//			}
//			ftpClient.login(this.username, this.password);
//			if (this.path.length() != 0) {
//				ftpClient.cd(this.path);// path是ftp服务下主目录的子目录
//			}
//			
//			if (FTP.BINARY_FILE_TYPE == ftpMode) {//2  二进制 
//				ftpClient.binary();
//			} else if (FTP.ASCII_FILE_TYPE == ftpMode){//0 ASCII码
//				ftpClient.ascii();
//			}
//			System.out.println("已登录到\"" + ftpClient.pwd() + "\"目录");
//			return true;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return false;
//		}
		return true; //Add by dxb
	}

	/**
	 * 断开与ftp服务器连接
	 * 
	 * @throws IOException
	 */
	public boolean closeServer() {
//		try {
//			if (is != null) {
//				is.close();
//			}
//			if (os != null) {
//				os.close();
//			}
//			if (ftpClient != null) {
//				ftpClient.closeServer();
//			}
//			System.out.println("已从服务器断开");
//			return true;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return false;
//		}
		return true; //Add by dxb
	}

	/**
	 * 从ftp下载文件到本地
	 * 
	 * @param filename
	 *            服务器上的文件名
	 * @param newfilename
	 *            本地生成的文件名
	 * @return
	 * @throws Exception
	 */
	public long downloadFile(String filename, String newfilename) {
		long result = 0;
//		TelnetInputStream is = null;
//		FileOutputStream os = null;
//		try {
//			is = ftpClient.get(filename);
//			File outfile = new File(newfilename);
//			if (!outfile.getParentFile().exists()) {
//				outfile.getParentFile().mkdirs();
//			}
//			os = new FileOutputStream(outfile);
//			byte[] bytes = new byte[1024];
//			int c;
//			while ((c = is.read(bytes)) != -1) {
//				os.write(bytes, 0, c);
//				result = result + c;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (is != null) {
//					is.close();
//				}
//				if (os != null) {
//					os.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		return result;
	}

	public static void main(String[] args) {
		FtpUtil ftp = new FtpUtil("127.0.0.1", 21,"test1", "test");
		ftp.connectServer(FTP.BINARY_FILE_TYPE);
		System.out.println(ftp.downloadFile("upload/test你好吗.xls", "f:/upload/test你好吗.xls")); 
		ftp.closeServer();
		/**
		 * FTP远程命令列表 USER PORT RETR ALLO DELE SITE XMKD CDUP FEAT PASS PASV STOR
		 * REST CWD STAT RMD XCUP OPTS ACCT TYPE APPE RNFR XCWD HELP XRMD STOU
		 * AUTH REIN STRU SMNT RNTO LIST NOOP PWD SIZE PBSZ QUIT MODE SYST ABOR
		 * NLST MKD XPWD MDTM PROT
		 * 在服务器上执行命令,如果用sendServer来执行远程命令(不能执行本地FTP命令)的话，所有FTP命令都要加上\r\n
		 * ftpclient.sendServer("XMKD /test/bb\r\n"); //执行服务器上的FTP命令
		 * ftpclient.readServerResponse一定要在sendServer后调用
		 * nameList("/test")获取指目录下的文件列表 XMKD建立目录，当目录存在的情况下再次创建目录时报错 XRMD删除目录
		 * DELE删除文件
		 */
	}

}