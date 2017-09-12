
package org.topexpression.op.define;

import org.topexpression.IllegalExpressionException;
import org.topexpression.datameta.BaseDataMeta;
import org.topexpression.datameta.Constant;
import org.topexpression.datameta.Reference;
import org.topexpression.op.IOperatorExecution;
import org.topexpression.op.Operator;

/**
 * Arithmetic division operation 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class Op_DIV implements IOperatorExecution {

	public static final Operator THIS_OPERATOR = Operator.DIV;
	
	
	public Constant execute(Constant[] args) throws IllegalExpressionException {

		if(args == null || args.length != 2){
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "参数个数不匹配");
		}		
		Constant first = args[1];
		if(null == first || null == first.getDataValue()){
			//Cast NULL abnormalities 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数为空");
		}		
		Constant second = args[0];
		if(null == second || null == second.getDataValue()){
			//Cast NULL abnormalities 
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

		if( BaseDataMeta.DataType.DATATYPE_NULL ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_NULL ==  second.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_STRING ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_STRING ==  second.getDataType()
			){
			//Cast abnormal 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数类型错误"	);

		}else if(Double.compare(second.getDoubleValue(), 0) == 0){
			//Judgment divisor 0 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"除数为零"	);
		
		}else if(BaseDataMeta.DataType.DATATYPE_DOUBLE == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_DOUBLE == second.getDataType()){

			Double result = first.getDoubleValue() / second.getDoubleValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_DOUBLE , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_FLOAT == second.getDataType()){

			Float result = first.getFloatValue() / second.getFloatValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_FLOAT , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_LONG == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_LONG == second.getDataType()){

			Long result = first.getLongValue() / second.getLongValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_LONG , result);
			
		}else {

			Integer result = first.getIntegerValue() / second.getIntegerValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_INT , result);
		}			
		
	}
	
	public Constant executeExp(Constant[] args) throws IllegalExpressionException {

		if(args == null || args.length != 2){
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "参数个数不匹配");
		}		
		Constant first = args[1];
		if(null == first || null == first.getDataValue()){
			//Cast NULL abnormalities 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数为空");
		}		
		Constant second = args[0];
		if(null == second || null == second.getDataValue()){
			//Cast NULL abnormalities 
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

		if( BaseDataMeta.DataType.DATATYPE_NULL ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_NULL ==  second.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_STRING ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_STRING ==  second.getDataType()
			){
			//Cast abnormal 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数类型错误"	);

		}else if(Double.compare(second.getDoubleValue(), 0) == 0){
			//Judgment divisor 0 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"除数为零"	);
		
		}else if(BaseDataMeta.DataType.DATATYPE_DOUBLE == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_DOUBLE == second.getDataType()){

			Double result = first.getDoubleValue() / second.getDoubleValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_DOUBLE , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_FLOAT == second.getDataType()){

			Float result = first.getFloatValue() / second.getFloatValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_FLOAT , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_LONG == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_LONG == second.getDataType()){

			Long result = first.getLongValue() / second.getLongValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_LONG , result);
			
		}else {

			Integer result = first.getIntegerValue() / second.getIntegerValue();
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

		if( BaseDataMeta.DataType.DATATYPE_NULL ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_NULL ==  second.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_STRING ==  first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_STRING ==  second.getDataType()
			){
			//Cast abnormal 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数类型错误"
					, THIS_OPERATOR.getToken()
					, opPositin
					);
		}else if(BaseDataMeta.DataType.DATATYPE_DOUBLE == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_DOUBLE == second.getDataType()){
			return new Constant(BaseDataMeta.DataType.DATATYPE_DOUBLE , Double.valueOf(0.0));
			
		}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_FLOAT == second.getDataType()){
			return new Constant(BaseDataMeta.DataType.DATATYPE_FLOAT , Float.valueOf(0.0f));
			
		}else if(BaseDataMeta.DataType.DATATYPE_LONG == first.getDataType()
				|| BaseDataMeta.DataType.DATATYPE_LONG == second.getDataType()){
			return new Constant(BaseDataMeta.DataType.DATATYPE_LONG , Long.valueOf(0L));
			
		}else {
			return new Constant(BaseDataMeta.DataType.DATATYPE_INT , Integer.valueOf(0));
		}	
		
	}

}
