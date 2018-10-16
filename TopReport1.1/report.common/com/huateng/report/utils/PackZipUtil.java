package com.huateng.report.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

import com.huateng.ebank.framework.report.common.ReportConstant;

import east.dao.JBDao;

public class PackZipUtil {
	
	private static final Logger logger = Logger.getLogger(JBDao.class);
	static int k = 1; // 定义递归次数变量
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
	
	 /**
     * 压缩指定的单个或多个文件，如果是目录，则遍历目录下所有文件进行压缩
     * @param zipFileName ZIP文件名包含全路径
     * @param files  文件列表
     */
    public static boolean zip(String zipFileName, File... files) {
        logger.info("压缩: "+zipFileName);
        ZipOutputStream out = null;
        BufferedOutputStream bo = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(zipFileName));
            for (int i = 0; i < files.length; i++) {
                if (null != files[i]) {
                    zip(out, files[i], files[i].getName());
                }
            }
            out.close(); // 输出流关闭
            logger.info("压缩完成");
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
 
    /**
     * 执行压缩
     * @param out ZIP输入流
     * @param f   被压缩的文件
     * @param base  被压缩的文件名
     */
    private static void zip(ZipOutputStream out, File f, String base) { // 方法重载
        try {
            if (f.isDirectory()) {//压缩目录
                try {
                    File[] fl = f.listFiles();
                    if (fl.length == 0) {
                        out.putNextEntry(new ZipEntry(base + "/"));  // 创建zip实体
                        logger.info(base + "/");
                    }
                    for (int i = 0; i < fl.length; i++) {
                        zip(out, fl[i], base + "/" + fl[i].getName()); // 递归遍历子文件夹
                    }
                    //System.out.println("第" + k + "次递归");
                    k++;
                } catch (IOException e) {
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }
            }else{ //压缩单个文件
                logger.info(base);
                out.putNextEntry(new ZipEntry(base)); // 创建zip实体
                FileInputStream in = new FileInputStream(f);
                BufferedInputStream bi = new BufferedInputStream(in);
                int b;
                while ((b = bi.read()) != -1) {
                    out.write(b); // 将字节流写入当前zip目录
                }
                out.closeEntry(); //关闭zip实体
                in.close(); // 输入流关闭
            }
 
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
 
 
}
