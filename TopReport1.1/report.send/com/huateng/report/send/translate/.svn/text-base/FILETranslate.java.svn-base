//package com.huateng.report.send.translate;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FilenameFilter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
////暂时不维护
//public class FILETranslate extends AbstractTranslate {
//
//	public boolean init(String sourcePath, String destPath) {
//		this.sourcePath = sourcePath;
//		this.destPath = destPath;
//		return true;
//	}
//
//	protected void lock() throws IOException {
//		String lockFileName = destPath + getDestSend() + tokenName;
//		logger.info("lock>>>>>>" + lockFileName);
//		File token = new File(lockFileName);
//		// if (!token.getParentFile().exists()) {
//		// token.getParentFile().mkdirs();
//		// }
//		if (!token.exists()) {
//			token.createNewFile();
//		}
//		setLocked(destPath + getDestSend(), true);
//	}
//
//	public void unlock() throws Exception {
//		for (String dir : lockMap.keySet()) {
//			if (lockMap.get(dir)) {
//				String lockFileName = dir + tokenName;
//				logger.info("unlock>>>>>>" + lockFileName);
//				File token = new File(lockFileName);
//				if (token.exists()) {
//					token.delete();
//				}
//			}
//			lockMap.put(dir, false);
//		}
//
//	}
//
//	protected boolean copy(File sourceFile, File destFile) {
//		FileInputStream input = null;
//		FileOutputStream output = null;
//		if (sourceFile.exists()) {
//			try {
//				input = new FileInputStream(sourceFile);
//				output = new FileOutputStream(destFile);
//				int b = 0;
//				byte[] buffer = new byte[1024];
//				while ((b = input.read(buffer)) != -1) {
//					output.write(buffer, 0, b);
//				}
//			} catch (IOException e) {
//				logger.error("copy failed:", e);
//				return false;
//			} finally {
//				if (input != null) {
//					try {
//						input.close();
//					} catch (IOException e) {
//					}
//				}
//				if (output != null) {
//					try {
//						output.close();
//					} catch (IOException e) {
//					}
//				}
//			}
//		} else {
//			logger.error("file:" + sourceFile.getAbsolutePath() + " not exist");
//			return false;
//		}
//		return true;
//	}
//
//	public boolean send(String sourcePath, String destPath, String filePack,
//			String fileName) {
//		String src = this.sourcePath;
//		String dest = this.destPath;
//		this.sourcePath = sourcePath;
//		this.destPath = destPath;
//		boolean flag = send(filePack, fileName);
//		this.sourcePath = src;
//		this.destPath = dest;
//		return flag;
//	}
//
//	public boolean send(String filePack, String fileName) {
//		logger.info("##########send begin#########");
//		if (!isLocked(destPath + getDestSend())) {
//			try {
//				lock();
//			} catch (Exception e) {
//				logger.error("lock failed", e);
//				return false;
//			}
//		}
//		if (!filePack.endsWith(File.separator)) {
//			filePack += File.separator;
//		}
//		String sourceFilepath = sourcePath + getSourceSend() + filePack
//				+ fileName;
//		logger.info("source file:" + sourceFilepath);
//		String destFilepath = destPath + getDestSend() + filePack + fileName;
//		logger.info("dest file  :" + destFilepath);
//
//		try {
//			File sourceFile = new File(sourceFilepath);
//			File destFile = new File(destFilepath);
//			if (!destFile.getParentFile().exists()) {
//				destFile.getParentFile().mkdirs();
//			}
//			return copy(sourceFile, destFile);
//		} catch (Exception e) {
//			return false;
//		} finally {
//			logger.info("##########send end#########");
//		}
//	}
//
//	public Map<String, List<String>> feedBack(String sourcePath,
//			String destPath, Map<String, List<String>> filterMap)
//			throws TokenLockException {
//		String src = this.sourcePath;
//		String dest = this.destPath;
//		this.sourcePath = sourcePath;
//		this.destPath = destPath;
//		Map<String, List<String>> map = feedBack(filterMap);
//		this.sourcePath = src;
//		this.destPath = dest;
//		return map;
//	}
//
//	public Map<String, List<String>> feedBack(
//			Map<String, List<String>> filterMap) throws TokenLockException {
//		logger.info("##########feedback begin#########");
//		String destFilepath = destPath + getDestFeedback();
//		logger.info("dest feedback filepath  :" + destFilepath);
//		String sourceFilepath = sourcePath + getSourceFeedback();
//		logger.info("source feedback filepath  :" + sourceFilepath);
//
//		File destFile = new File(destFilepath);
//		File[] tokens = destFile.listFiles(new FilenameFilter() {
//			public boolean accept(File dir, String name) {
//				return tokenName.equals(name);
//			}
//		});
//
//		Map<String, List<String>> map = new HashMap<String, List<String>>();
//		if (tokens.length == 0) {
//			File[] pkgFiles = destFile.listFiles(new _FilenameFilter(filterMap
//					.keySet()));
//			File[] files = null;
//			File target = null;
//			for (File pkgFile : pkgFiles) {
//				if (pkgFile.isDirectory()) {
//					files = pkgFile.listFiles(new _FilenameFilter(filterMap
//							.get(pkgFile.getName())));
//					target = new File(sourceFilepath + pkgFile.getName()
//							+ File.separator);
//					if (!target.exists()) {
//						target.mkdirs();
//					}
//					for (File file : files) {
//						target = new File(sourceFilepath + pkgFile.getName()
//								+ File.separator + file.getName());
//						if (copy(file, target)) {
//							if (!map.containsKey(pkgFile.getName())) {
//								map.put(pkgFile.getName(),
//										new ArrayList<String>());
//							}
//							map.get(pkgFile.getName()).add(file.getName());
//						} else {
//							// copy failed
//							logger.warn("feedback get filled");
//						}
//					}
//				} else {
//					logger.warn("feedback package is not a directory");
//				}
//			}
//		} else {
//			logger.error("dest feedback filepath  :" + destFilepath
//					+ " is locked!");
//			throw new TokenLockException();
//		}
//
//		logger.info("##########feedback end#########");
//		return map;
//	}
//
//	public void close() {
//		try {
//			unlock();
//		} catch (Exception e) {
//			logger.warn("unlock failed", e);
//		}
//	}
//
//	class _FilenameFilter implements FilenameFilter {
//		private Collection<String> fileNames;
//
//		public _FilenameFilter(Collection<String> fileNames) {
//			this.fileNames = fileNames;
//		}
//
//		public boolean accept(File dir, String name) {
//			return fileNames == null || fileNames.contains(name);
//		}
//	}
//}
