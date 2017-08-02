package com.huateng.report.send.parse;

import java.io.IOException;

public interface BeanOutput {
	
	String REPORTBEAN = "REPORTBEAN";

	void setValue(String key, Object value);

	void open() throws IOException;

	void write(String content) throws IOException;;

	String newNextFile() throws IOException;

	void close() throws IOException;

}
