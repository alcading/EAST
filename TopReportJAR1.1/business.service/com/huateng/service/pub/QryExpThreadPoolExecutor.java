/**
 * 
 */
package com.huateng.service.pub;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.huateng.ebank.entity.data.mng.TblCSFileExportTskInf;

/**
 * 批量导出线程池
 * @author wangpeng
 * @version 1.0
 */
public class QryExpThreadPoolExecutor {
	 private static ThreadPoolExecutor producerPool;
	 /**
	  * 线程池维护线程的最少数量
	  */
	 public static int corePoolSize = 1;
	 /**
	  * 线程池维护线程的最大数量
	  */
	 public static int maximumPoolSize = 5;
	 /**
	  * 线程池维护线程所允许的空闲时间
	  * 如果池中当前有多于 corePoolSize 的线程，则这些多出的线程在空闲时间超过 keepAliveTime 时将会终止
	  */
	 public static long keepAliveTime = 0;
	 /**
	  *  线程池所使用的缓冲队列
	  */
	 public static int waitingQueue = 100;

	 /**
	  * 初始化线程池
		*corePoolSize： 线程池维护线程的最少数量
		*maximumPoolSize：线程池维护线程的最大数量
		*keepAliveTime： 线程池维护线程所允许的空闲时间
		*unit： 线程池维护线程所允许的空闲时间的单位
		*workQueue： 线程池所使用的缓冲队列
		*handler： 线程池对拒绝任务的处理策略
	  */

	 public static void initThreadPool(){
		 //构造一个线程池
		 if(producerPool ==null){
	 		    producerPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                TimeUnit.SECONDS, new ArrayBlockingQueue(waitingQueue),
                new ThreadPoolExecutor.CallerRunsPolicy());
		 }
	 }

	 public static void addTask(TblCSFileExportTskInf tskInf){
		 try{
			//System.out.println("...."+producerPool.getCorePoolSize()+producerPool.getMaximumPoolSize()+producerPool.getQueue().remainingCapacity());
			 if(producerPool ==null){
				 initThreadPool();
			 }
			 producerPool.execute(new BatchExpTask(tskInf));
		 }catch (Exception e) {
			   e.printStackTrace();

		 }
	 }
	 /**
	  * 依据web.xml 中的配置来加载对线程池的设置
	  * @param corePoolSize
	  * @param maximumPoolSize
	  * @param keepAliveTime
	  */
	public static void setProducerPool(int corePoolSize,int maximumPoolSize,long keepAliveTime,int waitingQueue){

		 try {
				   if(producerPool ==null){
					 producerPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
				                TimeUnit.SECONDS, new ArrayBlockingQueue(waitingQueue),
				     new ThreadPoolExecutor.CallerRunsPolicy());
				   }else{
					 producerPool.setCorePoolSize(corePoolSize);
					 producerPool.setMaximumPoolSize(maximumPoolSize);
					 producerPool.setKeepAliveTime(keepAliveTime, TimeUnit.SECONDS);
				}
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	 }
	
	/**
	 * 关闭线程池
	 */
	public static void shutdown(){
		if(producerPool !=null){
			producerPool.shutdown();
		}
	}
}
