package org.topexpression.function;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 *
 */
public class BaseMethodFactory {
	/**
	 * Mapping global cache.
	 */
	public final Map<String, IMethod> methodMap = new HashMap<String, IMethod>();

	
	public boolean add(IMethod methodImpl)
	{
		if(methodMap.containsKey(methodImpl.getMethodName()))
			return false;
		else
		{
			methodMap.put(methodImpl.getMethodName(), methodImpl);
			return true;
		}	
	}
	
	public IMethod get(String methodName)
	{
		if(!methodMap.containsKey(methodName))
			throw new IllegalStateException("尚未实现的方法："+methodName);
		return methodMap.get(methodName);
	}
}
