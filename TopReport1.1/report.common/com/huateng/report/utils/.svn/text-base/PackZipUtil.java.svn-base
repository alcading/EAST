package com.huateng.report.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import com.huateng.ebank.framework.report.common.ReportConstant;

public class PackZipUtil {

	/**
	 * 创建ZIP文件
	 *
	 * @param sourcePath
	 *            文件或文件夹路径
	 * @param zipPath
	 *            生成的zip文件存在路径（包括文件名）
	 * @throws Exception
	 */
	public void createZip(String packPath, String[] packs, String zipPath) throws Exception {
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(zipPath);
			zos = new ZipOutputStream(fos);
			for (int i = 0; i < packs.length; i++) {
				String sourcePath = packPath + packs[i] + File.separator;
				this.writeZip(new File(sourcePath), "", zos);
			}
		} catch (FileNotFoundException e) {
			throw new Exception("文件或目录不存在：" + e.getMessage());
		} finally {
			if (zos != null) {
				zos.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}

	public void createZip(List<String> filePathList, String zipPath) throws Exception {
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(zipPath);
			zos = new ZipOutputStream(fos);
			for (int i = 0; i < filePathList.size(); i++) {
				this.writeZip(new File(filePathList.get(i)), "", zos);
			}
		} catch (FileNotFoundException e) {
			throw new Exception("文件或目录不存在：" + e.getMessage());
		} finally {
			if (zos != null) {
				zos.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}

	private void writeZip(File file, String parentPath, ZipOutputStream zos) throws Exception {
		if (file.exists()) {
			if (file.isDirectory()) {// 处理文件夹
				parentPath += file.getName() + File.separator;
				File[] files = file.listFiles();
				for (File f : files) {
					this.writeZip(f, parentPath, zos);
				}
			} else {
				FileInputStream fis = null;
				DataInputStream dis = null;
				try {
					fis = new FileInputStream(file);
					dis = new DataInputStream(new BufferedInputStream(fis));
					ZipEntry ze = new ZipEntry(parentPath + file.getName());
					zos.putNextEntry(ze);
					byte[] content = new byte[1024];
					int len;
					while ((len = fis.read(content)) != -1) {
						zos.write(content, 0, len);
					}
					zos.flush();
				} catch (Exception e) {
					throw e;
				} finally {
					if (dis != null) {
						dis.close();
					}
					if (fis != null) {
						fis.close();
					}
				}
			}
		}
	}

	public Map<String,String> unZip(String zipFilePath, String saveFilePath,String appName) throws Exception {
		File zipFile = new File(zipFilePath);
		if (!zipFile.exists()) {
			throw new Exception("文件不存在：" + zipFilePath);
		}
		File sf = new File(saveFilePath);
		if (!sf.isDirectory()) {
			sf.mkdirs();
		}
		Map<String,String> fileMap = new HashMap<String,String>();
		ZipEntry zipEntry = null;
		ZipInputStream zipInputStream = null;
		FileOutputStream os = null;
		FileInputStream fis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(zipFile);
			zipInputStream = new ZipInputStream(new BufferedInputStream(fis));
			while ((zipEntry = zipInputStream.getNextEntry()) != null) {
				String fileName = zipEntry.getName();

				String tableName = fileName.replaceAll(ReportConstant.BAK_FILE_EXT, "");

				if (appName!=null) {
					fileName=appName+fileName;
				}
				File saveFile = new File(saveFilePath + fileName);
				os = new FileOutputStream(saveFile);
				bos = new BufferedOutputStream(os);
				byte[] content = new byte[1024];
				int len;
				while ((len = zipInputStream.read(content)) != -1) {
					bos.write(content, 0, len);
				}
				bos.flush();
				bos.close();
				os.close();
				bos = null;
				os = null;
				fileMap.put(tableName,saveFile.getPath());
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (bos != null) {
				bos.close();
			}
			if (os != null) {
				os.close();
			}
			if (zipInputStream != null) {
				zipInputStream.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return fileMap;
	}

}
