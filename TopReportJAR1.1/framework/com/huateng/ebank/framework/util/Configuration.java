/*
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2003-2004 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */

package com.huateng.ebank.framework.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.SystemConstant;

/**
 * 用于在中文或英文平台上读取配置文件，文件内容可为中文或英文
 *
 * @author Henry Huang
 */

public class Configuration extends Properties {
	private static Logger log =
		Logger.getLogger(Configuration.class.getName());

	public Configuration(String fn) throws IOException {
		super();
		readConfigFile(fn);
	}

	public Configuration() throws IOException {
		super();
		readConfigFile(SystemConstant.CONFFILENAME);
	}

	private String fn; //Configuration file name

	public String get(String key, String defaultValue) {
		return getProperty(key, defaultValue);
	}

	/**
	 * Read a config file.
	 */
	public void readConfigFile(String fn) throws IOException {
		this.fn = fn;
		String rootDir = "/";
		try {
			InputStream stream =
				this.getClass().getResourceAsStream(rootDir + fn);
			super.load(stream);
			stream.close();
		} catch (FileNotFoundException e) {
			throw new IOException("Config file not found");
		}
	}

	public static void main(String[] args) {

		String fn = "";

		BufferedReader in = null;
		BufferedWriter out = null;
		String aline = "";
		long lSsn = 0;
		Configuration cfg;

		try {
			cfg = new Configuration();
			fn = cfg.get("haas_Location", "");
		} catch (Exception ex) {
			log.debug("get Config error,ex.getMessage():" + ex.getMessage());
			System.exit(0);
		}
		log.debug("Config haas_Location:" + fn);
	} //end of main
}
