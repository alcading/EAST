/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.framework.util.tags;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Provides helper methods for JSP tags.
 *
 * @version $Revision: 1.1 $
 * @since Struts 1.2
 */
public class HTTagUtils {

    /**
     * The Singleton instance.
     */
    private static final HTTagUtils instance = new HTTagUtils();

    /**
     * Commons logging instance.
     */
    private static final Log log = LogFactory.getLog(HTTagUtils.class);

    /**
     * Constructor for HTTagUtils.
     */
    protected HTTagUtils() {
        super();
    }

    /**
     * Returns the Singleton instance of HTTagUtils.
     */
    public static HTTagUtils getInstance() {
        return instance;
    }

    /**
     * Filter the specified string for characters that are senstive to
     * HTML interpreters, returning the string with these characters replaced
     * by the corresponding character entities.
     *
     * @param value The string to be filtered and returned
     */
    public String filter(String value) {

        if (value == null) {
            return (null);
        }

        char content[] = new char[value.length()];
        value.getChars(0, value.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);

        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                case '&':
                    result.append("&amp;");
                    break;
                case '"':
                    result.append("&quot;");
                    break;
                case '\'':
                    result.append("&#39;");
                    break;
				case ' ':
				   result.append("&nbsp;");
				   break;
               default:
                    result.append(content[i]);
            }
        }

        return result.toString();
    }
}
