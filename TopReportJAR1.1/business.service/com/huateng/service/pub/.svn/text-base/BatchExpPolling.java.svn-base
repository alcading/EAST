/**
 *
 */
package com.huateng.service.pub;

import java.net.InetAddress;

import org.apache.log4j.Logger;

/**
 * 扫描批量导出任务表
 * @author wangpeng
 * @author jonay
 * @version 1.0
 */
public class BatchExpPolling extends Thread {
	private static Logger logger = Logger.getLogger(BatchExpPolling.class);

	private int tskCountOneTime = 1;
	private boolean runningFlag=false;

	/**
	 * 运行标志
	 * @return
	 */
	public boolean isRunningFlag() {
		return runningFlag;
	}

	/**
	 * 设置运行标志
	 * @param runningFlag
	 */
	public void setRunningFlag(boolean runningFlag) {
		this.runningFlag = runningFlag;
	}

	/**
	 * 获取每次扫描的记录数
	 * @return
	 */
	public int getTskCountOneTime() {
		return tskCountOneTime;
	}

	private static BatchExpPolling instance;
	public static BatchExpPolling getInstance(){
		if(instance == null){
			instance = new BatchExpPolling();
		}
		return instance;
	}

	protected BatchExpPolling(){
		this.setName("BatchExpPolling");
	}
	/**
	 * 设置每次扫描的记录数
	 * @param tskCountOneTime
	 */
	public void setTskCountOneTime(int tskCountOneTime) {
		this.tskCountOneTime = tskCountOneTime;
	}

	@Override
	public void run() {
		QryExpService service = new QryExpService();
		try{
			this.sleep(2000);
			while(runningFlag){
				try{
					//mod by zhaozhiguo begin
					String ownerName = InetAddress.getLocalHost().getHostName()+System.currentTimeMillis();
					service.expTskProcess(tskCountOneTime, ownerName);
					//mod by zhaozhiguo end
				}
				catch(Exception e){
					e.printStackTrace();
					shutdown();
				}
				this.sleep(10000*3);
			}
		}catch(Throwable e){
			logger.error(e);
		}
	}

	public void shutdown(){
		this.runningFlag = false;
	}
}
