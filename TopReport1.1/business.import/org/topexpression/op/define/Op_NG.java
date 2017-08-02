
package org.topexpression.op.define;


import org.topexpression.IllegalExpressionException;
import org.topexpression.datameta.BaseDataMeta;
import org.topexpression.datameta.Constant;
import org.topexpression.datameta.Reference;
import org.topexpression.op.IOperatorExecution;
import org.topexpression.op.Operator;

/**
 * Arithmetic take negative operation 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class Op_NG implements IOperatorExecution {

	public static final Operator THIS_OPERATOR = Operator.NG;
	
	
	public Constant execute(Constant[] args) throws IllegalExpressionException {

		if(args == null || args.length != 1){
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "参数个数不匹配");
		}

		Constant first = args[0];
		if(null == first || null == first.getDataValue()){
			//Cast NULL abnormalities 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数为空");
		}
		
		//If the first parameter for reference, it is executed by reference 
		if(first.isReference()){
			Reference firstRef = (Reference)first.getDataValue();
			first = firstRef.execute();
		}		
		
		if(BaseDataMeta.DataType.DATATYPE_DOUBLE == first.getDataType()){			
			Double result = 0 - first.getDoubleValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_DOUBLE , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == first.getDataType()){			
			Float result = 0 - first.getFloatValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_FLOAT , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_LONG == first.getDataType()){
			Long result = 0 - first.getLongValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_LONG , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_INT == first.getDataType()){	
			Integer result = 0 - first.getIntegerValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_INT , result);
		
		}else {
			//Cast abnormal 
			throw new IllegalArgumentException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数类型错误");

		}
		
	}
	
	public Constant executeExp(Constant[] args) throws IllegalExpressionException {

		if(args == null || args.length != 1){
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "参数个数不匹配");
		}

		Constant first = args[0];
		if(null == first || null == first.getDataValue()){
			//Cast NULL abnormalities 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数为空");
		}
		
		//If the first parameter for reference, it is executed by reference 
		if(first.isReference()){
			Reference firstRef = (Reference)first.getDataValue();
			first = firstRef.executeExp();
		}		
		
		if(BaseDataMeta.DataType.DATATYPE_DOUBLE == first.getDataType()){			
			Double result = 0 - first.getDoubleValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_DOUBLE , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == first.getDataType()){			
			Float result = 0 - first.getFloatValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_FLOAT , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_LONG == first.getDataType()){
			Long result = 0 - first.getLongValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_LONG , result);
			
		}else if(BaseDataMeta.DataType.DATATYPE_INT == first.getDataType()){	
			Integer result = 0 - first.getIntegerValue();
			return new Constant(BaseDataMeta.DataType.DATATYPE_INT , result);
		
		}else {
			//Cast abnormal 
			throw new IllegalArgumentException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数类型错误");

		}
		
	}

	
	public Constant verify(int opPositin, BaseDataMeta[] args)
			throws IllegalExpressionException {

		if(args == null){
			throw new IllegalExpressionException("运算操作符参数为空",opPositin);
		}
		if(args.length != 1){
			//Cast abnormal 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数个数不匹配"
						, THIS_OPERATOR.getToken()
						, opPositin
					);
		}
		
		BaseDataMeta first = args[0];
		if(first == null){
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数为空",opPositin);
		}		

		if(BaseDataMeta.DataType.DATATYPE_DOUBLE == first.getDataType()){			
			return new Constant(BaseDataMeta.DataType.DATATYPE_DOUBLE , Double.valueOf(0.0));
			
		}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == first.getDataType()){			
			return new Constant(BaseDataMeta.DataType.DATATYPE_FLOAT , Float.valueOf(0F));
			
		}else if(BaseDataMeta.DataType.DATATYPE_LONG == first.getDataType()){
			return new Constant(BaseDataMeta.DataType.DATATYPE_LONG , Long.valueOf(0l));
			
		}else if(BaseDataMeta.DataType.DATATYPE_INT == first.getDataType()){	
			return new Constant(BaseDataMeta.DataType.DATATYPE_INT , Integer.valueOf(0));
		
		}else {
			//Cast abnormal 
			throw new IllegalExpressionException("操作符\"" + THIS_OPERATOR.getToken() + "\"参数类型错误"
					, THIS_OPERATOR.getToken()
					, opPositin
					);

		}				
	}

}
