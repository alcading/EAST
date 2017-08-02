
package org.topexpression.datameta;

import org.topexpression.ExpressionToken;
import org.topexpression.IllegalExpressionException;
import org.topexpression.ExpressionToken.ETokenType;
import org.topexpression.datameta.BaseDataMeta.DataType;
import org.topexpression.function.FunctionExecution;
import org.topexpression.op.Operator;



/**
 * Reference object 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class Reference {
	
	private ExpressionToken token;
	
	private Constant[] arguments;
	//Reference object actual data types 
	private DataType dataType;
	
	public Reference(ExpressionToken token , Constant[] args) throws IllegalExpressionException{
		this.token = token;
		this.arguments = args;
		//Record the actual instead of the data type 
		if(ExpressionToken.ETokenType.ETOKEN_TYPE_FUNCTION == token.getTokenType()){
			Constant result = FunctionExecution.varify(token.getFunctionName(), token.getStartPosition() , args);
			dataType = result.getDataType();
		}else if(ExpressionToken.ETokenType.ETOKEN_TYPE_OPERATOR == token.getTokenType()){
			Operator op = token.getOperator();
			Constant result = op.verify(token.getStartPosition() , args);
			dataType = result.getDataType();
		}
	}
	
	public DataType getDataType() {
		return dataType;
	}

	public Constant[] getArgs() {
		return arguments;
	}
	
	public void setArgs(Constant[] args) {
		this.arguments = args;
	}
	
	public ExpressionToken getToken() {
		return token;
	}

	public void setToken(ExpressionToken token) {
		this.token = token;
	} 
	
	/**
	 * Execute quoted object refers to stay expression (operators or functions) 
	 * @return
	 * @throws IllegalExpressionException 
	 */
	public Constant execute() throws IllegalExpressionException{
		
		if(ETokenType.ETOKEN_TYPE_OPERATOR == token.getTokenType()){
			//Execute operators 
			Operator op = token.getOperator();
			try {
				return op.execute(arguments);
			} catch (IllegalExpressionException e) {
				if(e.getErrorPosition()==-1){
					e.setErrorPosition(token.getStartPosition());
				}
				throw e;
			}
			
		}else if(ETokenType.ETOKEN_TYPE_FUNCTION == token.getTokenType()){
			//Executive function 
			try {
				return	FunctionExecution.execute(token.getFunctionName(), token.getStartPosition() , arguments);
			} catch (IllegalExpressionException e) {
				if(e.getErrorPosition()==-1){
					e.setErrorPosition(token.getStartPosition());
				}
				throw e;
			}
			
		}else{
			throw new IllegalExpressionException("不支持的Reference执行异常",token.getStartPosition() );
		}
	}
	
	public Constant executeExp() throws IllegalExpressionException{
		
		if(ETokenType.ETOKEN_TYPE_OPERATOR == token.getTokenType()){
			//Execute operators 
			Operator op = token.getOperator();
			try {
				return op.executeExp(arguments);
			} catch (IllegalExpressionException e) {
				if(e.getErrorPosition()==-1){
					e.setErrorPosition(token.getStartPosition());
				}
				throw e;
			}
			
		}else if(ETokenType.ETOKEN_TYPE_FUNCTION == token.getTokenType()){
			//Executive function 
			try {
				return	FunctionExecution.executeExp(token.getFunctionName(), token.getStartPosition() , arguments);
			} catch (IllegalExpressionException e) {
				if(e.getErrorPosition()==-1){
					e.setErrorPosition(token.getStartPosition());
				}
				throw e;
			}
			
		}else{
			throw new IllegalExpressionException("不支持的Reference执行异常",token.getStartPosition() );
		}
	}
	
}
