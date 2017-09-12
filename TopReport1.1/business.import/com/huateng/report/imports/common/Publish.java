package com.huateng.report.imports.common;

import java.util.HashMap;
import java.util.Map;

import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;

import com.huateng.report.imports.bean.ProcessVar;
import com.huateng.report.imports.model.Constant;

public class Publish {
	public static void push(String subject, Map<String, String> map) {
		Event event = Event.createDataEvent(subject, map);
		Dispatcher.getInstance().multicast(event);
	}
	public static void push(String subject, ProcessVar var) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("currentFile", var.currentFile);
		Event event = Event.createDataEvent(subject, map);
		Dispatcher.getInstance().multicast(event);
	}

	public static void push(String subject, Constant var) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", var.id);
		map.put("progress", var.progress);
		map.put("errorMessage", var.errorMessage);
		Event event = Event.createDataEvent(subject, map);
		Dispatcher.getInstance().multicast(event);
	}
}
