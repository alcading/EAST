
package org.topexpression.function;


import java.text.ParseException;

import org.topexpression.IllegalExpressionException;
import org.topexpression.datameta.BaseDataMeta;
import org.topexpression.datameta.Constant;
import org.topexpression.datameta.Reference;

/**
 * Operators and embedded method calls 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class FunctionExecution {
	
	private FunctionExecution(){		
	}
	
	/**
	 * According to the function name, parameter arrays, implement operation, and return the results Token 
	 * @param functionName The function name 
	 * @param position
	 * @param args Note the parameters from args due order according to the stack LIFO pop-up, so must take number from the tail backwards 
	 * @return
	 * @throws IllegalExpressionException 
	 */
	@SuppressWarnings("unchecked")
	public static Constant execute(String functionName , int position , Constant[] args) throws IllegalExpressionException{
		if(functionName == null){
			//throw new IllegalExpressionException("函数名为空",position);
		}
		if(args == null){
			//throw new IllegalExpressionException("函数参数列表为空",position);
		}
		for(int i = 0 ; i < args.length ; i++){
			//If parameters as a reference type, it is executed by reference 
			if(args[i].isReference()){
				Reference ref = (Reference)args[i].getDataValue();
				try {
					args[i] = ref.execute();
				} catch (IllegalExpressionException e) {
					if(e.getErrorPosition()==-1){
						e.setErrorPosition(position);
					}
					throw e;
				}
			}			
		}
		
		//Transformation method parameters 
		Object[] parameters;
		parameters = convertParameters(functionName , position , args);
	
		
		try {
			
			Object result = FunctionLoader.invokeFunction(functionName, parameters);
			
			if(result instanceof Boolean){
				return new Constant(BaseDataMeta.DataType.DATATYPE_BOOLEAN, result);
			
			}else if(result instanceof Double){
				return new Constant(BaseDataMeta.DataType.DATATYPE_DOUBLE, result);
							
			}else if(result instanceof Float){
				return new Constant(BaseDataMeta.DataType.DATATYPE_FLOAT, result);
							
			}else if(result instanceof Integer){
				return new Constant(BaseDataMeta.DataType.DATATYPE_INT, result);
							
			}else if(result instanceof Long){
				return new Constant(BaseDataMeta.DataType.DATATYPE_LONG, result);
							
			}else if(result instanceof String){
				return new Constant(BaseDataMeta.DataType.DATATYPE_STRING , result);
							
			}else {
				return new Constant(BaseDataMeta.DataType.DATATYPE_OBJECT , result);	
				
			}
		}catch (Exception e) {			
			throw new IllegalExpressionException("函数" + functionName + "错误" + e.getMessage(),position);
			
		}
	}
	
	public static Constant executeExp(String functionName , int position , Constant[] args) throws IllegalExpressionException{
		if(functionName == null){
			//throw new IllegalExpressionException("函数名为空",position);
		}
		if(args == null){
			//throw new IllegalExpressionException("函数参数列表为空",position);
		}
		for(int i = 0 ; i < args.length ; i++){
			//If parameters as a reference type, it is executed by reference 
			if(args[i].isReference()){
				Reference ref = (Reference)args[i].getDataValue();
				try {
					args[i] = ref.executeExp();
				} catch (IllegalExpressionException e) {
					if(e.getErrorPosition()==-1){
						e.setErrorPosition(position);
					}
					throw e;
				}
			}			
		}
		
		//Transformation method parameters 
		Object[] parameters;
		parameters = convertParameters(functionName , position , args);
	
		
		try {
			
			Object result = FunctionLoader.invokeFunctionExp(functionName, parameters);
			
			if(result instanceof Boolean){
				return new Constant(BaseDataMeta.DataType.DATATYPE_BOOLEAN, result);
			
			}else if(result instanceof Double){
				return new Constant(BaseDataMeta.DataType.DATATYPE_DOUBLE, result);
							
			}else if(result instanceof Float){
				return new Constant(BaseDataMeta.DataType.DATATYPE_FLOAT, result);
							
			}else if(result instanceof Integer){
				return new Constant(BaseDataMeta.DataType.DATATYPE_INT, result);
							
			}else if(result instanceof Long){
				return new Constant(BaseDataMeta.DataType.DATATYPE_LONG, result);
							
			}else if(result instanceof String){
				return new Constant(BaseDataMeta.DataType.DATATYPE_STRING , result);
							
			}else {
				return new Constant(BaseDataMeta.DataType.DATATYPE_OBJECT , result);	
				
			}
		}catch (Exception e) {			
			e.printStackTrace();
			throw new IllegalExpressionException("函数" + functionName + "错误" + e.getMessage(),position);
			
		}
	}
	
	/**
	 * Check function and parameter is legal, is an executable 
	 * If legitimate, return contains implement results of types of Token 
	 * If not lawful, null 
	 * @param functionName
	 * @param position
	 * @param args Note the parameters from args due order according to the stack LIFO pop-up, so must take number from the tail backwards 
	 * @return
	 * @throws IllegalExpressionException 
	 */
	public static Constant varify(String functionName , int position ,  BaseDataMeta[] args) throws IllegalExpressionException{
		if(functionName == null){
			throw new IllegalExpressionException("函数名为空",position);
		}		

		//Through the method name and parameter arrays, acquisition method, and methods of the return value, which translates into ExpressionToken 
		try {
			
			return new Constant(BaseDataMeta.DataType.DATATYPE_OBJECT , null);	
				
			
			
		} catch (SecurityException e) {
			//Cast abnormal 
			throw new IllegalExpressionException("函数\"" + functionName + "\"不存在或参数类型不匹配"
					, functionName
					, position
					);
		} 
	}

	/**
	 * Function parameter transformation 
	 * @param args
	 * @return
	 * @throws IllegalExpressionException 
	 */
	private static Object[] convertParameters(String functionName , int position  , Constant[] args ) throws IllegalExpressionException{
		//Is null, the return value is null array 
		if(args == null){
			return new Object[0];
		}
		
		//Transformation method type parameters array 
		Object[] parameters = new Object[args.length];
		for(int i = args.length - 1 ; i >= 0 ; i--){
			try {
				parameters[args.length - 1 - i] = args[i].toJavaObject();
			} catch (ParseException e1) {
				//Cast abnormal 
				throw new IllegalExpressionException("函数\"" + functionName + "\"参数转化Java对象错误",position);
			}
		}		
		return parameters;
	}

}
