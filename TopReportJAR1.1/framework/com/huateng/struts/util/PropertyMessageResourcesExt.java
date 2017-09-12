package com.huateng.struts.util;

import java.util.Locale;

import org.apache.struts.util.MessageResourcesFactory;
import org.apache.struts.util.PropertyMessageResources;

import com.huateng.ebank.business.common.MessageResourceUtil;

public class PropertyMessageResourcesExt extends PropertyMessageResources {

	private static final long serialVersionUID = 1L;

	/**
	 * Construct a new PropertyMessageResources according to the specified
	 * parameters.
	 * 
	 * @param factory
	 *            The MessageResourcesFactory that created us
	 * @param config
	 *            The configuration parameter for this MessageResources
	 */
	public PropertyMessageResourcesExt(MessageResourcesFactory factory,
			String config) {

		super(factory, config);
		log.trace("Initializing, config='" + config + "'");

	}

	/**
	 * Construct a new PropertyMessageResources according to the specified
	 * parameters.
	 * 
	 * @param factory
	 *            The MessageResourcesFactory that created us
	 * @param config
	 *            The configuration parameter for this MessageResources
	 * @param returnNull
	 *            The returnNull property we should initialize with
	 */
	public PropertyMessageResourcesExt(MessageResourcesFactory factory,
			String config, boolean returnNull) {

		super(factory, config, returnNull);
		log.trace("Initializing, config='" + config + "', returnNull="
				+ returnNull);

	}

	/**
	 * Returns a text message for the specified key, for the default Locale. A
	 * null string result will be returned by this method if no relevant message
	 * resource is found for this key or Locale, if the <code>returnNull</code>
	 * property is set. Otherwise, an appropriate error message will be
	 * returned.
	 * <p>
	 * This method must be implemented by a concrete subclass.
	 * 
	 * @param locale
	 *            The requested message Locale, or <code>null</code> for the
	 *            system default Locale
	 * @param key
	 *            The message key to look up
	 * @return text message for the specified key and locale
	 */
	@Override
	public String getMessage(Locale locale, String key) {
		String exceptKey = "org.apache.struts.taglib";
		if (key.startsWith(exceptKey)) {
			return super.getMessage(locale, key);
		} else {
			String message = super.getMessage(MessageResourceUtil.isIl8n() ? locale : Locale.getDefault(), key);
			if (message == null || message.startsWith("???")) {
				return key;
			} else {
				return message;
			}
		}
	}

}
