/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.framework.util.tags;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.util.MessageResources;

/**
 * 基于struts的标准bean:wirite标签，增加字符串长度属性支持，在长度不足时，输出html的空格代码(&nbsp;)填充。
 *
 * @author Henry Huang
 */
public class WriteTag extends TagSupport {

    /**
     * The key to search default format string for java.sql.Timestamp in resources.
     */
    public static final String SQL_TIMESTAMP_FORMAT_KEY =
        "org.apache.struts.taglib.bean.format.sql.timestamp";

    /**
     * The key to search default format string for java.sql.Date in resources.
     */
    public static final String SQL_DATE_FORMAT_KEY =
        "org.apache.struts.taglib.bean.format.sql.date";

    /**
     * The key to search default format string for java.sql.Time in resources.
     */
    public static final String SQL_TIME_FORMAT_KEY =
        "org.apache.struts.taglib.bean.format.sql.time";

    /**
     * The key to search default format string for java.util.Date in resources.
     */
    public static final String DATE_FORMAT_KEY =
        "org.apache.struts.taglib.bean.format.date";

    /**
     * The key to search default format string for int (byte, short, etc.) in resources.
     */
    public static final String INT_FORMAT_KEY =
        "org.apache.struts.taglib.bean.format.int";

    /**
     * The key to search default format string for float (double, BigDecimal) in
     * resources.
     */
    public static final String FLOAT_FORMAT_KEY =
        "org.apache.struts.taglib.bean.format.float";

    /**
     * The message resources for this package.
     */
    protected static MessageResources messages =
        MessageResources.getMessageResources(
            "org.apache.struts.taglib.bean.LocalStrings");

    // ------------------------------------------------------------- Properties

    /**
     * Filter the rendered output for characters that are sensitive in HTML?
     */
    protected boolean filter = true;

    public boolean getFilter() {
        return (this.filter);
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    /**
     * Should we ignore missing beans and simply output nothing?
     */
    protected boolean ignore = false;

    public boolean getIgnore() {
        return (this.ignore);
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    /**
     * Name of the bean that contains the data we will be rendering.
     */
    protected String name = null;

    public String getName() {
        return (this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Name of the property to be accessed on the specified bean.
     */
    protected String property = null;

    public String getProperty() {
        return (this.property);
    }

    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * The scope to be searched to retrieve the specified bean.
     */
    protected String scope = null;

    public String getScope() {
        return (this.scope);
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * The format string to be used format to convert
     * value to String.
     */
    protected String formatStr = null;

    public String getFormat() {
        return (this.formatStr);
    }

    public void setFormat(String formatStr) {
        this.formatStr = formatStr;
    }

    /**
     * The key to search format string in applciation resources
     */
    protected String formatKey = null;

    public String getFormatKey() {
        return (this.formatKey);
    }

    public void setFormatKey(String formatKey) {
        this.formatKey = formatKey;
    }

	/**
	 * The length controls the whole length of the output string.
	 */
	protected int length = 0;

	public int getLength() {
		return (this.length);
	}

	public void setLength(int length) {
		this.length = length;
	}

    /**
     * The session scope key under which our Locale is stored.
     */
    protected String localeKey = null;

    public String getLocale() {
        return (this.localeKey);
    }

    public void setLocale(String localeKey) {
        this.localeKey = localeKey;
    }

    /**
     * The servlet context attribute key for our resources.
     */
    protected String bundle = null;

    public String getBundle() {
        return (this.bundle);
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    // --------------------------------------------------------- Public Methods

    /**
     * Process the start tag.
     *
     * @exception JspException if a JSP exception has occurred
     */
    @Override
	public int doStartTag() throws JspException {

        // Look up the requested bean (if necessary)
        if (ignore) {
            if (TagUtils.getInstance().lookup(pageContext, name, scope) == null) {
                return (SKIP_BODY); // Nothing to output
            }
        }

        // Look up the requested property value
        Object value = TagUtils.getInstance().lookup(pageContext, name, property, scope);

        if (value == null) {
            return (SKIP_BODY); // Nothing to output
        }

        // Convert value to the String with some formatting
        String output = formatValue(value);

        // Print this property value to our output writer, suitably filtered
        if (filter) {
			TagUtils.getInstance().write(pageContext, HTTagUtils.getInstance().filter(output));
        } else {
			TagUtils.getInstance().write(pageContext, output);
        }

        // Continue processing this page
        return (SKIP_BODY);

    }

    /**
     * Retrieve format string from message bundle and return null if
     * message not found or message string.
     *
     * @param formatKey value to use key to search message in bundle
     * @exception JspException if a JSP exception has occurred
     */
    protected String retrieveFormatString(String formatKey) throws JspException {
        String result =
            TagUtils.getInstance().message(
                pageContext,
                this.bundle,
                this.localeKey,
                formatKey);

        if ((result != null)
            && !(result.startsWith("???") && result.endsWith("???"))) {

            return result;

        } else {
            return null;
        }

    }
	
    /**
     * Format value according to specified format string (as tag attribute or
     * string from message resources) or to current user locale.
     *
     * When a format string is retrieved from the message resources,
     * <code>applyLocalizedPattern</code> is used. For more about localized
     * patterns, see
     * <http://www.dei.unipd.it/corsi/fi2ae-docs/source/jdk1.1.7/src/java/text/resources/>.
     * (To obtain the correct value for some characters, you may need to view
     * the file in a hex editor and then use the Unicode escape form in the
     * property resources file.)
     *
     * @param valueToFormat value to process and convert to String
     * @exception JspException if a JSP exception has occurred
     */
    protected String formatValue(Object valueToFormat) throws JspException {
        Format format = null;
        Object value = valueToFormat;
        Locale locale = TagUtils.getInstance().getUserLocale(pageContext, this.localeKey);
        boolean formatStrFromResources = false;
        String formatString = formatStr;
        String result = null;

        // Return String object is.
        if (value instanceof java.lang.String) {
            return toFixedLengthString((String) value);
        } else {

            // Try to retrieve format string from resources by the key from formatKey.
            if ((formatString == null) && (formatKey != null)) {
                formatString = retrieveFormatString(this.formatKey);
                if (formatString != null) {
                    formatStrFromResources = true;
                }
            }

            // Prepare format object for numeric values.
            if (value instanceof Number) {

                if (formatString == null) {
                    if ((value instanceof Byte)
                        || (value instanceof Short)
                        || (value instanceof Integer)
                        || (value instanceof Long)
                        || (value instanceof BigInteger)) {

                        formatString = retrieveFormatString(INT_FORMAT_KEY);

                    } else if (
                        (value instanceof Float)
                            || (value instanceof Double)
                            || (value instanceof BigDecimal)) {

                        formatString = retrieveFormatString(FLOAT_FORMAT_KEY);
                    }

                    if (formatString != null) {
                        formatStrFromResources = true;
                    }
                }

                if (formatString != null) {
                    try {
                        format = NumberFormat.getNumberInstance(locale);
                        if (formatStrFromResources) {
                            ((DecimalFormat) format).applyLocalizedPattern(
                                formatString);
                        } else {
                            ((DecimalFormat) format).applyPattern(formatString);
                        }

                    } catch (IllegalArgumentException e) {
                        JspException ex =
                            new JspException(
                                messages.getMessage("write.format", formatString));
                        TagUtils.getInstance().saveException(pageContext, ex);
                        throw ex;
                    }
                }

            } else if (value instanceof java.util.Date) {

                if (formatString == null) {

                    if (value instanceof java.sql.Timestamp) {
                        formatString =
                            retrieveFormatString(SQL_TIMESTAMP_FORMAT_KEY);

                    } else if (value instanceof java.sql.Date) {
                        formatString = retrieveFormatString(SQL_DATE_FORMAT_KEY);

                    } else if (value instanceof java.sql.Time) {
                        formatString = retrieveFormatString(SQL_TIME_FORMAT_KEY);

                    } else if (value instanceof java.util.Date) {
                        formatString = retrieveFormatString(DATE_FORMAT_KEY);
                    }

                }

                if (formatString != null) {
                        format = new SimpleDateFormat(formatString, locale);
                }
            }
        }

        if (format != null) {
            return toFixedLengthString(format.format(value));
        } else {
            return toFixedLengthString(value.toString());
        }

    }

	protected String toFixedLengthString(String inString){
		String _inString = inString.trim();
		if(this.length == 0) return _inString;
		if(this.length <= _inString.length()){
			return _inString;
		}else{
			StringBuffer sb = new StringBuffer(_inString);
			for(int i=0; i<this.length-_inString.length(); i++) sb.append(" ");
			return sb.toString();
		}
	}

    /**
     * Release all allocated resources.
     */
    @Override
	public void release() {

        super.release();
        filter = true;
        ignore = false;
        name = null;
        property = null;
        scope = null;
        formatStr = null;
        formatKey = null;
        localeKey = null;
        bundle = null;

    }

}
