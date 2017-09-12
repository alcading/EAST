
package org.topexpression.op.define;

import org.topexpression.IllegalExpressionException;
import org.topexpression.datameta.BaseDataMeta;
import org.topexpression.datameta.Constant;
import org.topexpression.datameta.Reference;
import org.topexpression.op.IOperatorExecution;
import org.topexpression.op.Operator;


/**
 * Plus operation realize 
 * Plus operation includes mathematics addition and rotative string connection 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class Op_PLUS implements IOperatorExecution {

	public static final Operator THIS_OPERATOR = Operator.PLUS;
	
	public Constant execute(Constant[] args) throws IllegalExpressionException{
		
		if(args == null || args.length != 2){
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "参数个数不匹配");
		}

		Constant first = args[1];
		Constant second = args[0];
		if(first == null || second == null){
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数为空");
		}
		
		//If the first parameter for reference, it is executed by reference 
		if(first.isReference()){
			Reference firstRef = (Reference)first.getDataValue();
			first = firstRef.execute();
		}
		//If the second parameter for reference, it is executed by reference 
		if(second.isReference()){
			Reference secondRef = (Reference)second.getDataValue();
			second = secondRef.execute();
		}		
		
		//Collection types PLUS operations treated separately 
		if(BaseDataMeta.DataType.DATATYPE_STRING ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_STRING == second.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_NULL ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_NULL ==  second.getDataType()
																				){
			String firstString = "";
			String secondString = "";
			//Rotative string connection operations, if the parameter is null, regard as empty rotative string processing 
			if(null != first.getStringValue()){
				firstString = first.getStringValue();
			}
			if(null != second.getStringValue()){
				secondString = second.getStringValue();
			}
			String result = firstString + secondString;
			return new Constant(BaseDataMeta.DataType.DATATYPE_STRING , result);
			
		}else if(null == first.getDataValue() || null == second.getDataValue()){
			//Cast NULL abnormalities 
			throw new NullPointerException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数为空");
		
		}else if(BaseDataMeta.DataType.DATATYPE_DOUBLE == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_DOUBLE == second.getDataType()){
			
			Double result = first.getDoubleValue() + second.getDoubleValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_DOUBLE , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_FLOAT == second.getDataType()){
			
			Float result = first.getFloatValue() + second.getFloatValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_FLOAT , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_LONG == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_LONG == second.getDataType()){

			Long result = first.getLongValue() + second.getLongValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_LONG , result);
			
		}else {
	
			Integer result = first.getIntegerValue() + second.getIntegerValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_INT , result);
		}

	}
	
	public Constant executeExp(Constant[] args) throws IllegalExpressionException{
		
		if(args == null || args.length != 2){
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "参数个数不匹配");
		}

		Constant first = args[1];
		Constant second = args[0];
		if(first == null || second == null){
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数为空");
		}
		
		//If the first parameter for reference, it is executed by reference 
		if(first.isReference()){
			Reference firstRef = (Reference)first.getDataValue();
			first = firstRef.executeExp();
		}
		//If the second parameter for reference, it is executed by reference 
		if(second.isReference()){
			Reference secondRef = (Reference)second.getDataValue();
			second = secondRef.executeExp();
		}		
		
		//Collection types PLUS operations treated separately 
		if(BaseDataMeta.DataType.DATATYPE_STRING ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_STRING == second.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_NULL ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_NULL ==  second.getDataType()
																				){
			String firstString = "";
			String secondString = "";
			//Rotative string connection operations, if the parameter is null, regard as empty rotative string processing 
			if(null != first.getStringValue()){
				firstString = first.getStringValue();
			}
			if(null != second.getStringValue()){
				secondString = second.getStringValue();
			}
			String result = firstString + secondString;
			return new Constant(BaseDataMeta.DataType.DATATYPE_STRING , result);
			
		}else if(null == first.getDataValue() || null == second.getDataValue()){
			//Cast NULL abnormalities 
			throw new NullPointerException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数为空");
		
		}else if(BaseDataMeta.DataType.DATATYPE_DOUBLE == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_DOUBLE == second.getDataType()){
			
			Double result = first.getDoubleValue() + second.getDoubleValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_DOUBLE , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_FLOAT == second.getDataType()){
			
			Float result = first.getFloatValue() + second.getFloatValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_FLOAT , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_LONG == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_LONG == second.getDataType()){

			Long result = first.getLongValue() + second.getLongValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_LONG , result);
			
		}else {
	
			Integer result = first.getIntegerValue() + second.getIntegerValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_INT , result);
		}

	}

	public Constant verify(int opPositin, BaseDataMeta[] args)
			throws IllegalExpressionException {
		
		if(args == null){
			throw new IllegalExpressionException("运算操作符参数为空",opPositin);
		}
		if(args.length != 2){
			//Cast abnormal 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数个数不匹配"
						, THIS_OPERATOR.getToken()
						, opPositin
					);
		}
		
		BaseDataMeta first = args[1];
		BaseDataMeta second = args[0];
		if(first == null || second == null){
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数为空",opPositin);
		}
		

		if(BaseDataMeta.DataType.DATATYPE_STRING ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_STRING == second.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_NULL ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_NULL ==  second.getDataType()
																				){
			
			return new Constant(BaseDataMeta.DataType.DATATYPE_STRING , null);
			
		}else if(BaseDataMeta.DataType.DATATYPE_DOUBLE == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_DOUBLE == second.getDataType()){
			return new Constant(BaseDataMeta.DataType.DATATYPE_DOUBLE , Double.valueOf(0.0));
			
		}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_FLOAT == second.getDataType()){
			return new Constant(BaseDataMeta.DataType.DATATYPE_FLOAT , Float.valueOf(0.0f));
			
		}else if(BaseDataMeta.DataType.DATATYPE_LONG == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_LONG == second.getDataType()){
			return new Constant(BaseDataMeta.DataType.DATATYPE_LONG , Long.valueOf(0l));
			
		}else {
			return new Constant(BaseDataMeta.DataType.DATATYPE_INT , Integer.valueOf(0));
		}
	}
	
}
