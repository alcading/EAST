package com.huateng.report.send.translate;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huateng.report.utils.ReportUtils;

public abstract class AbstractTranslate implements ITranslate {

	protected Logger logger = Logger.getLogger(getClass());

	/**
	 * 本地目录(源) 如:D:/datas/Send/
	 */
	protected String sourcePath = "/";
	/**
	 * 本地发送文件夹
	 */
	private String sourceSend;
	/**
	 * 本地反馈文件夹
	 */
	private String sourceFeedback;

	/**
	 * 目标目录 如: /ACCData/
	 */
	protected String destPath = "/";

	/**
	 * 目标发送文件夹
	 */
	private String destSend;
	/**
	 * 目标反馈文件夹
	 */
	private String destFeedback;

	/**
	 * 锁
	 */
	protected String tokenName = "Token.lock";

	protected Map<String, Boolean> lockMap = new HashMap<String, Boolean>();

	protected abstract void lock() throws Exception;

	public String getTokenName() {
		return tokenName;
	}

	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}

	protected String getSourceSend() {
		if (sourceSend == null) {
			try {
				sourceSend = ReportUtils.getSysParamsValue(REPORT_DIR, LOCAL_SEND, "Send/");
			} catch (Exception e) {
				logger.warn("PARAM[" + REPORT_DIR + "][" + LOCAL_SEND + "] " + e.getMessage());
				sourceSend = "Send/";
			}
		}
		return sourceSend;
	}

	protected String getSourceFeedback() {
		if (sourceFeedback == null) {
			try {
				sourceFeedback = ReportUtils.getSysParamsValue(REPORT_DIR, LOCAL_FEEDBACK, "Feedback/");
			} catch (Exception e) {
				logger.warn("PARAM[" + REPORT_DIR + "][" + LOCAL_FEEDBACK + "] " + e.getMessage());
				sourceFeedback = "Feedback/";
			}
		}
		return sourceFeedback;
	}

	protected String getDestSend() {
		if (destSend == null) {
			try {
				destSend = ReportUtils.getSysParamsValue(REPORT_DIR, REMOTE_SEND, "Send/");
			} catch (Exception e) {
				logger.warn("PARAM[" + REPORT_DIR + "][" + REMOTE_SEND + "] " + e.getMessage());
				destSend = "Send/";
			}
		}
		return destSend;
	}

	protected String getDestFeedback() {
		if (destFeedback == null) {
			try {
				destFeedback = ReportUtils.getSysParamsValue(REPORT_DIR, REMOTE_FEEDBACK, "Feedback/");
			} catch (Exception e) {
				logger.warn("PARAM[" + REPORT_DIR + "][" + REMOTE_FEEDBACK + "] " + e.getMessage());
				destFeedback = "Feedback/";
			}
		}
		return destFeedback;
	}

	protected boolean isLocked(String dir) {
		return lockMap.containsKey(dir) && lockMap.get(dir);
	}

	protected void setLocked(String dir, boolean locked) {
		lockMap.put(dir, locked);
	}
	
}
