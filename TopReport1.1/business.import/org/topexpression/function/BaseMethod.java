package org.topexpression.function;

/**
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 *
 */
public abstract class BaseMethod implements IMethod{

	private String methodName;
	
	public BaseMethod(String methodName)
	{
		this.methodName = methodName;
	}
	
	public String getMethodName()
	{
		return methodName;
	}


}
