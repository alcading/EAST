
package org.topexpression.function;

import java.lang.reflect.InvocationTargetException;
import javax.xml.parsers.ParserConfigurationException;

import org.topexpression.IllegalExpressionException;



/**
 * Expressions function loader 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class FunctionLoader {
	
	private static FunctionLoader single = new FunctionLoader();
	
	private BaseMethodFactory factoryMap;
	
	
	/**
	 * A private, prohibit external new construction 
	 */
	private FunctionLoader() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize, parse XML config 
	 * @throws ParserConfigurationException 
	 * @throws Exception 
	 */
	private void init() throws Exception {
		    factoryMap = new MethodImpl();
		
	}
	

	/**
	 * Executive method 
	 * @param functionName
	 * @param parameters
	 * @return
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IllegalExpressionException 
	 */
	public static Object invokeFunction(String functionName, Object[] parameters)  
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IllegalExpressionException {
		IMethod mehtod=single.factoryMap.get(functionName);
		if (mehtod == null) {
			throw new NoSuchMethodException();
		}
		return mehtod.call(parameters);
	}
	
	public static Object invokeFunctionExp(String functionName, Object[] parameters)  
		throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IllegalExpressionException {
		IMethod mehtod=single.factoryMap.get(functionName);
		if (mehtod == null) {
			throw new NoSuchMethodException();
		}
		return mehtod.compile(parameters);
	}

}
