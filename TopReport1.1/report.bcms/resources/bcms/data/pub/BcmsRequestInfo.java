package resources.bcms.data.pub;

import resources.bcms.data.base.BaseBcmsRequestInfo;

public class BcmsRequestInfo extends BaseBcmsRequestInfo{

	public BcmsRequestInfo() {
		super();
	}
	
	/**
	 * Constructor for primary key
	 */
	public BcmsRequestInfo (String deliveryType) {
		super(deliveryType);
	}
	
}
