package com.huateng.report.send.translate;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.UserInfo;

public class SFTPTranslate extends AbstractTranslate {

	private String host = "127.0.0.1";
	private int port = 22;
	private String username;
	private String password;
	private String prvkey;
	private String passphrase = "111111";
	private String ROOT = "/";
	private JSch jsch;
	private Session session;
	private ChannelSftp sftp;

	public boolean init(String sourcePath, String destPath) {
		this.sourcePath = sourcePath;
		this.destPath = destPath;
		try {
			/*
			 * JSch.setLogger(new Logger() { public boolean isEnabled(int i) {
			 * return true; } public void log(int i, String s) {
			 * logger.info("Log(jsch," + i + "): " + s); } });
			 */
			jsch = new JSch();
			Session session = jsch.getSession(username, host, port);
			logger.info("sftp session created!");
			if (prvkey != null) {
				jsch.addIdentity(prvkey);
				UserInfo ui = new MyUserInfo(passphrase);
				session.setUserInfo(ui);
			} else {
				session.setPassword(password);
			}
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config); // 为Session对象设置properties
			session.connect();
			logger.info("sftp session connect!");
			Channel channel = session.openChannel("sftp");
			logger.info("sftp channel opened!");
			channel.connect();
			logger.info("Connected successfully to ftpHost = " + host
					+ ",as ftpUserName = " + username + ", returning: "
					+ channel);
			sftp = (ChannelSftp) channel;
			ROOT = sftp.pwd();
			if (ROOT != null) {
				if (!ROOT.endsWith("/")) {
					ROOT += "/";
				}
			} else {
				ROOT = "/";
			}
			this.destPath = ROOT + destPath;
			logger.info("sftp connected, current work deirctory is "
					+ sftp.pwd());
		} catch (Exception e) {
			logger.error("create sftp failed", e);
			return false;
		}
		return true;
	}

	protected void lock() throws Exception {
		String dir = destPath + getDestSend();
		try {
			sftp.cd(dir);
		} catch (SftpException e) {
			logger.error("CWD " + dir + " No such directory");
			throw e;
		}
		ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
		sftp.put(in, tokenName);
		setLocked(dir, true);
		logger.info("lock status " + true);
	}

	public void unlock(String destPath) throws Exception {
		String dir = destPath + getDestSend();
		if (lockMap.containsKey(dir)) {
			if (lockMap.get(dir)) {
				logger.info("unlock>>>>>>" + dir + tokenName);
				sftp.cd(dir);
				sftp.rm(tokenName);
			}
			lockMap.put(dir, false);
		} else {
			for (String dir2 : lockMap.keySet()) {
				if (lockMap.get(dir2)) {
					logger.info("unlock>>>>>>" + dir2 + tokenName);
					sftp.cd(dir2);
					sftp.rm(tokenName);
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
			sftp.cd(destPath);
			try {
				sftp.mkdir(pkgpath);
			} catch (SftpException e) {
			}
			sftp.cd(pkgpath);
			logger.info("change to directory[" + sftp.pwd() + "]");
		} catch (Exception e1) {
			logger.error("create package work directory failed", e1);
			return false;
		}
		FileInputStream input = null;
		String sourceFilepath = sourcePath + getSourceSend() + filePack
				+ File.separator + fileName;
		File sourceFile = new File(sourceFilepath);
		if (sourceFile.exists()) {
			try {
				input = new FileInputStream(sourceFile);
				sftp.put(input, fileName);
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
		return true;
	}

	public String feedBack(String sourcePath, String destPath, String packname) {
		String src = this.sourcePath;
		String dest = this.destPath;
		this.sourcePath = sourcePath;
		this.destPath = ROOT + destPath;
		String rs = feedBack(packname);
		this.sourcePath = src;
		this.destPath = dest;
		return rs;
	}

	public String feedBack(String packname) {
		logger.info("##########feedback begin#########");
		String result = RESCODE_FAILED;
		try {
			// 进入到feedback目录
			sftp.cd(destPath);
			sftp.cd(getDestFeedback());
		} catch (Exception e) {
			logger.error("CWD " + destPath + getDestFeedback()
					+ " No such directory", e);
			return "No such directory " + destPath + getDestFeedback();
		}
		try {
			Vector<LsEntry> v = sftp.ls(".");
			boolean hasRes = false;
			for (LsEntry vo : v) {
				if (tokenName.equals(vo.getFilename())) {
					return RESCODE_PROCESS;
				}
				if (packname.equals(vo.getFilename())) {
					hasRes = true;
				}
			}
			if (!hasRes) {
				return RESCODE_NOT_RES;
			}
		} catch (SftpException e) {
			logger.error("ls failed:", e);
			return e.getMessage();
		}

		try {
			// 进入到回执文件目录
			sftp.cd(packname);
		} catch (Exception e) {
			logger.error("CWD " + packname + " No such directory", e);
			return "No such directory " + packname;
		}

		File sourceFile = null;
		FileOutputStream output = null;
		try {
			String srcfilepath = null;
			sourceFile = new File(sourcePath + getSourceFeedback() + packname);
			if (!sourceFile.exists()) {
				sourceFile.mkdirs();
			}

			Vector<LsEntry> files = sftp.ls(".");
			for (LsEntry obj2 : files) {
				String fileName = obj2.getFilename();
				if (".".equals(fileName) || "..".equals(fileName)) {
					continue;
				}

				srcfilepath = sourcePath + getSourceFeedback() + packname
						+ File.separator + fileName;
				output = new FileOutputStream(srcfilepath);
				sftp.get(fileName, output);
				output.close();
			}
			result = RESCODE_SUCCESS;
		} catch (Exception e) {
			logger.error("get from sftp failed", e);
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
			if (sftp != null) {
				sftp.disconnect();
			}
			if (session != null) {
				session.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPrvkey(String prvkey) {
		this.prvkey = prvkey;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	class MyUserInfo implements UserInfo {
		private String passphrase = null;

		public MyUserInfo(String passphrase) {
			this.passphrase = passphrase;
		}

		public String getPassphrase() {
			return passphrase;
		}

		public String getPassword() {
			return password;
		}

		public boolean promptPassphrase(String s) {
			return true;
		}

		public boolean promptPassword(String s) {
			return true;
		}

		public boolean promptYesNo(String s) {
			return true;
		}

		public void showMessage(String s) {
			System.out.println(s);
		}

	}
}
