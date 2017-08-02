package com.huateng.report.send.translate;


public interface ITranslate {

	/**
	 * @param sourcePath
	 *            源根目录
	 * @param destPath
	 *            目标根目录
	 *
	 * <pre>
	 * 从本地 D:/send/向远程/CFADatas/Send发送文件 则
	 * sourcePath是 D:/
	 * destPath  是 CFADatas/
	 * </pre>
	 * @return
	 */
	boolean init(String sourcePath, String destPath);

	/**
	 * @param filePack
	 *            包名
	 * @param fileName
	 *            文件名
	 * @return
	 */
	boolean send(String filePack, String fileName);

	boolean send(String sourcePath, String destPath, String filePack, String fileName);


	String RESCODE_SUCCESS = "00";
	String RESCODE_NOT_RES = "01";
	String RESCODE_PROCESS = "02";
	String RESCODE_FAILED = "99";

	/**
	 * @param packname
	 *            包名
	 * @return 	00 - 成功
	 * 			01 - 未回执
	 * 			02 - 回执处理中
	 * 			99 - 失败
	 * 			其它 - 错误信息
	 * @throws TokenLockException
	 */
	String feedBack(String packname);


	String feedBack(String sourcePath, String destPath, String packname);

	/**
	 * 解锁Token.lock
	 * @throws Exception
	 */
	void unlock(String destPath) throws Exception;

	/**
	 * 关闭
	 */
	void close();

	/**
	 * 报文导出路径参数KEY
	 */
	String REPORT_DIR = "DIR";

	String REMOTE_CFA = "0001";
	String REMOTE_ACC = "0002";
	String REMOTE_SEND = "0003";
	String REMOTE_FEEDBACK = "0004";

	String LOCAL_CFA = "0101";
	String LOCAL_ACC = "0102";
	String LOCAL_SEND = "0103";
	String LOCAL_FEEDBACK = "0104";

}
