package com.huateng.struts.util;

import org.apache.struts.util.MessageResources;
import org.apache.struts.util.MessageResourcesFactory;

public class PropertyMessageResourcesFactory extends MessageResourcesFactory {

	private static final long serialVersionUID = 1L;

	@Override
	public MessageResources createResources(String config) {
		return new PropertyMessageResourcesExt(this, config, this.returnNull);
	}

}
