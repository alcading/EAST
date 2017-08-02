package com.huateng.report.genupreportfile.utils;

import org.springframework.context.ApplicationEvent;

/**
 * 触发事件实体类
 * @author NING-PENG
 *
 */
public class SubFileEventBean extends ApplicationEvent {

	private static final long serialVersionUID = 5667993264878189755L;

	public SubFileEventBean(Object source) {
		super(source);
	}

}
