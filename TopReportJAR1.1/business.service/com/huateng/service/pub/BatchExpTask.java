/**
 * 
 */
package com.huateng.service.pub;

import org.apache.log4j.Logger;

import com.huateng.ebank.entity.data.mng.TblCSFileExportTskInf;

/**
 * 批量导出任务
 * @author wangpeng
 * @version 1.0
 */
public class BatchExpTask implements Runnable {
	private static Logger logger = Logger.getLogger(BatchExpTask.class);
	private TblCSFileExportTskInf tskInf = null;
	
	/**
	 * 
	 * @param tsk
	 */
	public BatchExpTask(TblCSFileExportTskInf tsk){
		this.tskInf = tsk;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		Long beginTime = System.nanoTime();
		QryExpService service = new QryExpService();
		service.genExportBatch(tskInf);
		logger.info(">>批量查询打印生成文件用时"+((float)(System.nanoTime()-beginTime)/1000000000)+"秒");
	}
}
