package org.topexpression.function;

import org.topexpression.IllegalExpressionException;

/**
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 *
 */
public interface IMethod {

	public String getMethodName();
	
	public Object call(Object[] arg)  throws IllegalExpressionException;
	
	public Object compile(Object[] arg)  throws IllegalExpressionException;
}
