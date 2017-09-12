package resource.bean.pub;

import resource.bean.pub.base.BaseBhProcStep;




public class BhProcStep extends BaseBhProcStep {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BhProcStep () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BhProcStep (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BhProcStep (
		java.lang.Integer id,
		java.lang.Integer jobno,
		java.lang.Integer step,
		java.lang.Integer subStep,
		java.lang.String processFunction) {

		super (
			id,
			jobno,
			step,
			subStep,
			processFunction);
	}

/*[CONSTRUCTOR MARKER END]*/


}