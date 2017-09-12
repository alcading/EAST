package com.huateng.ebank.framework.web.struts;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * 接收上传文件的Form. 此类中提供基本的输入域(上传文件). 
 * @author liuwen
 * @since  2006-3-9
 * @version $Revision: 1.1 $
 */
public class UploadForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	/**
	 * The file that the user has uploaded
	 */
	protected FormFile theFile;

	public FormFile getTheFile() {
		return theFile;
	}

	public void setTheFile(FormFile theFile) {
		this.theFile = theFile;
	}
}
