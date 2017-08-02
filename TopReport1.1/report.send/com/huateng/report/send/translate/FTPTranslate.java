package com.huateng.report.send.translate;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTPTranslate extends AbstractTranslate {

	private String url;
	private int port;
	private String username;
	private String password;
	private FTPClient ftpClient;
	private int fileType = FTP.ASCII_FILE_TYPE;
	private String ROOT = "/";

	public boolean init(String sourcePath, String destPath) {
		this.sourcePath = sourcePath;
		this.destPath = destPath;
		try {
			int reply;
			FTPClient ftp = new FTPClient();
			ftp.connect(url, port);
			ftp.setFileType(fileType);
			ftp.login(username, password);
			ftp.setListHiddenFiles(false);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				logger.warn("FTP server refused connection.");
				ftp.disconnect();
				return false;
			}
			ROOT = ftp.printWorkingDirectory();
			if (ROOT != null) {
				if (!ROOT.endsWith("/")) {
					ROOT += "/";
				}
			} else {
				ROOT = "/";
			}
			this.destPath = ROOT + destPath;
			logger.info("ftp connected, current work deirctory is "
					+ ftp.printWorkingDirectory());
			ftpClient = ftp;
		} catch (Exception e) {
			logger.error("create ftp failed", e);
			return false;
		}
		return true;
	}

	protected void lock() throws IOException {
		String dir = destPath + getDestSend();
		if (ftpClient.changeWorkingDirectory(dir)) {
			ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
			boolean s = ftpClient.storeFile(tokenName, in);
			setLocked(dir, true);
			logger.info("lock status " + s);
		} else {
			logger.error("CWD " + dir + " No such directory");
			throw new IOException("CWD " + dir + " No such directory");
		}
	}

	public void unlock(String destPath) throws Exception {
		String dir = destPath + getDestSend();
		if (lockMap.containsKey(dir)) {
			if (lockMap.get(dir)) {
				logger.info("unlock>>>>>>" + dir + tokenName);
				ftpClient.changeWorkingDirectory(dir);
				ftpClient.deleteFile(tokenName);
			}
			lockMap.put(dir, false);
		} else {
			for (String dir2 : lockMap.keySet()) {
				if (lockMap.get(dir2)) {
					logger.info("unlock>>>>>>" + dir2 + tokenName);
					ftpClient.changeWorkingDirectory(dir);
					ftpClient.deleteFile(tokenName);
				}
				lockMap.put(dir2, false);
			}
		}
	}

	public boolean send(String sourcePath, String destPath, String filePack,
			String fileName) {
		String src = this.sourcePath;
		String dest = this.destPath;
		this.sourcePath = sourcePath;
		this.destPath = ROOT + destPath;
		boolean flag = send(filePack, fileName);
		this.sourcePath = src;
		this.destPath = dest;
		return flag;
	}

	public boolean send(String filePack, String fileName) {
		logger.info("##########send begin#########");
		if (!isLocked(destPath + getDestSend())) {
			try {
				lock();
			} catch (Exception e) {
				return false;
			}
		}
		String pkgpath = getDestSend() + filePack;
		try {
			ftpClient.changeWorkingDirectory(destPath);
			ftpClient.makeDirectory(pkgpath);
			boolean f2 = ftpClient.changeWorkingDirectory(pkgpath);
			if (!f2) {
				return false;
			}
			logger.info("change to directory["
					+ ftpClient.printWorkingDirectory() + "]");
		} catch (IOException e1) {
			logger.error("create package work directory failed", e1);
			return false;
		}
		FileInputStream input = null;
		String sourceFilepath = sourcePath + getSourceSend() + filePack
				+ File.separator + fileName;
		File sourceFile = new File(sourceFilepath);
		boolean rs = false;
		if (sourceFile.exists()) {
			try {
				input = new FileInputStream(sourceFile);
				rs = ftpClient.storeFile(fileName, input);
			} catch (Exception e) {
				logger.error("file send by ftp failed", e);
				return false;
			} finally {
				try {
					input.close();
				} catch (IOException e) {
				}
			}
		} else {
			logger.error("file:" + sourceFilepath + " not exist");
			return false;
		}

		logger.info("##########send end#########");
		return rs;
	}

	public String feedBack(String sourcePath, String destPath, String packname) {
		String src = this.sourcePath;
		String dest = this.destPath;
		this.sourcePath = sourcePath;
		this.destPath = ROOT + destPath;
		String result = feedBack(packname);
		this.sourcePath = src;
		this.destPath = dest;
		return result;
	}

	public String feedBack(String packname) {
		logger.info("##########feedback begin#########");
		String result = RESCODE_FAILED;
		try {
			ftpClient.changeWorkingDirectory(destPath);
			ftpClient.changeWorkingDirectory(getDestFeedback());
		} catch (IOException e) {
			logger.error("CWD " + destPath + getDestFeedback()
					+ " No such directory", e);
			return "No such directory " + destPath + getDestFeedback();
		}
		try {
			FTPFile[] fs = ftpClient.listFiles(".");
			boolean hasRes = false;
			for (FTPFile f : fs) {
				if (tokenName.equals(f.getName())) {
					return RESCODE_PROCESS;
				}
				if (packname.equals(f.getName())) {
					hasRes = true;
				}
			}
			if (!hasRes) {
				return RESCODE_NOT_RES;
			}
		} catch (IOException e) {
			logger.error("ls failed:", e);
			return e.getMessage();
		}

		File sourceFile = null;
		FileOutputStream output = null;
		try {
			String srcfilepath = null;
			sourceFile = new File(sourcePath + getSourceFeedback() + packname);
			if (!sourceFile.exists()) {
				sourceFile.mkdirs();
			}
			FTPFile[] files = ftpClient.listFiles(packname);

			try {
				// 进入到回执文件目录
				ftpClient.changeWorkingDirectory(packname);
			} catch (IOException e) {
				logger.error("CWD " + packname + " No such directory", e);
				return "No such directory " + packname;
			}

			for (FTPFile file : files) {
				if (".".equals(file.getName()) || "..".equals(file.getName())) {
					continue;
				}
				srcfilepath = sourcePath + getSourceFeedback() + packname
						+ File.separator + file.getName();
				output = new FileOutputStream(srcfilepath);
				ftpClient.retrieveFile(file.getName(), output);
				output.close();
			}

			// ftpClient.changeToParentDirectory();
			result = RESCODE_SUCCESS;
		} catch (Exception e) {
			logger.error("get from ftp failed", e);
		} finally {
			try {
				if (output != null)
					output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.info("##########feedback end#########");
		return result;
	}

	public void close() {
		try {
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

}
