package com.huateng.ebank.business.common.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import com.huateng.common.CommonFunction;
import com.huateng.ebank.business.common.BaseGlobalData;


/**
 * 线程池初始化和设置
 * @author abudual add at 2010-08-19
 * @version 1.0
 */
public class BizLogThreadPoolExecutor  {

	 private static ThreadPoolExecutor producerPool;
	 /**
	  * 线程池维护线程的最少数量
	  */
	 public static int corePoolSize = 1;
	 /**
	  * 线程池维护线程的最大数量
	  */
	 public static int maximumPoolSize = 1;
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

	 public static void addTask(BaseGlobalData globalInfo,String sequence,String s,String txnLogFlag,String uuId,String oprTxnCd){
		 try{
			//System.out.println("...."+producerPool.getCorePoolSize()+producerPool.getMaximumPoolSize()+producerPool.getQueue().remainingCapacity());
			 if(producerPool ==null){
				 initThreadPool();
			 }
			 producerPool.execute(new BizLogTask(globalInfo,s,txnLogFlag,uuId,oprTxnCd,sequence));
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
	public static void setProducerPool(String corePoolSize,String maximumPoolSize,String keepAliveTime,String waitingQueue){

		 try {
			   Integer corePoolSize1 = Integer.parseInt(CommonFunction.getAnyValueDefault(corePoolSize,"1"));
			   Integer maximumPoolSize1 =  Integer.parseInt(CommonFunction.getAnyValueDefault(maximumPoolSize,"1"));
			   Long keepAliveTime1 = Long.parseLong(CommonFunction.getAnyValueDefault(keepAliveTime,"0"));
			   Integer waitingQueue1 = Integer.parseInt(CommonFunction.getAnyValueDefault(waitingQueue,"100"));
				   if(producerPool ==null){
					 producerPool = new ThreadPoolExecutor(corePoolSize1, maximumPoolSize1, keepAliveTime1,
				                TimeUnit.SECONDS, new ArrayBlockingQueue(waitingQueue1),
				     new ThreadPoolExecutor.CallerRunsPolicy());
				   }else{
					 producerPool.setCorePoolSize(corePoolSize1);
					 producerPool.setMaximumPoolSize(maximumPoolSize1);
					 producerPool.setKeepAliveTime(keepAliveTime1, TimeUnit.SECONDS);
				}
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	 }
}
