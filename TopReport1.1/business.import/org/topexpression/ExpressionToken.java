
package org.topexpression;

import org.topexpression.datameta.Constant;
import org.topexpression.datameta.Reference;
import org.topexpression.datameta.Variable;
import org.topexpression.datameta.BaseDataMeta.DataType;
import org.topexpression.op.Operator;

/**
 * Expression analytical word meta object 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class ExpressionToken {
	

	//Word yuan grammar type 
	public enum ETokenType{
		//constants 
		ETOKEN_TYPE_CONSTANT ,
		//variables 
		ETOKEN_TYPE_VARIABLE ,	
		//operators 
		ETOKEN_TYPE_OPERATOR ,
		//function 
		ETOKEN_TYPE_FUNCTION ,
		//separator 
		ETOKEN_TYPE_SPLITOR ,
		;
	}
	
	//Token word yuan type: constants, variables, operators, function, separator 
	private ETokenType tokenType ;
	//When TokenType = ETOKEN_TYPE_CONSTANT, of storage constants description 
	private Constant constant;
	//When TokenType = ETOKEN_TYPE_VARIABLE, variable storage variable description 
	private Variable variable ;
	//When TokenType = ETOKEN_TYPE_OPERATOR, operator storage fuck do operator description 
	private Operator operator;
	//Storage character description 
	private String tokenText ;
	//Word in the starting position of $expression 
	private int startPosition = -1;
	
	public static ExpressionToken createConstantToken(DataType dataType , Object dataValue){
		ExpressionToken instance = new ExpressionToken();
		instance.constant = new Constant(dataType , dataValue);
		instance.tokenType = ETokenType.ETOKEN_TYPE_CONSTANT;
		if(dataValue != null){
			instance.tokenText=  instance.constant.getDataValueText();
		}
		return instance;
	}
	
	public static ExpressionToken createConstantToken(Constant constant) throws IllegalExpressionException{
		if(constant == null){
			throw new IllegalExpressionException("非法参数异常：常量为null" );
		}
		ExpressionToken instance = new ExpressionToken();
		instance.constant = constant;
		instance.tokenType = ETokenType.ETOKEN_TYPE_CONSTANT;
		if(constant.getDataValue() != null){
			instance.tokenText=  constant.getDataValueText();
		}
		return instance;
	}
	
	public static ExpressionToken createVariableToken(String variableName){
		ExpressionToken instance = new ExpressionToken();
		instance.variable = new Variable(variableName);
		instance.tokenType = ETokenType.ETOKEN_TYPE_VARIABLE;
		instance.tokenText = variableName;
		return instance;
	}
	
	public static ExpressionToken createReference(Reference ref){
		ExpressionToken instance = new ExpressionToken();
		instance.constant = new Constant(ref);
		instance.tokenType = ETokenType.ETOKEN_TYPE_CONSTANT;
		if(ref != null){
			instance.tokenText=  instance.constant.getDataValueText();
		}
		return instance;
	}	
	
	public static ExpressionToken createFunctionToken(String functionName) throws IllegalExpressionException{
		if(functionName == null){
			throw new IllegalExpressionException("非法参数：函数名称为空");
		}
		ExpressionToken instance = new ExpressionToken();
		instance.tokenText = functionName;
		instance.tokenType = ETokenType.ETOKEN_TYPE_FUNCTION;
		return instance;
	}
	
	public static ExpressionToken createOperatorToken(Operator operator) throws IllegalExpressionException{
		if(operator == null){
			throw new IllegalExpressionException("非法参数：操作符为空");
		}
		ExpressionToken instance = new ExpressionToken();
		instance.operator = operator;
		instance.tokenText = operator.getToken();
		instance.tokenType = ETokenType.ETOKEN_TYPE_OPERATOR;
		return instance;
	}
	
	public static ExpressionToken createSplitorToken(String splitorText) throws IllegalExpressionException{
		if(splitorText == null){
			throw new IllegalExpressionException("非法参数：分隔符为空");
		}
		ExpressionToken instance = new ExpressionToken();
		instance.tokenText = splitorText;
		instance.tokenType = ETokenType.ETOKEN_TYPE_SPLITOR;
		return instance;
	}
	
	/**
	 * Private constructor 
	 * @param tokenText
	 * @param tokenType
	 * @param dataType
	 */
	private ExpressionToken(){
	}
	
	/**
	 * Access Token word yuan type 
	 * @return
	 */
	public ETokenType getTokenType() {
		return tokenType;
	}

	
	/**
	 * Access Token constants description 
	 * @return
	 */
	public Constant getConstant(){
		return this.constant;
	}

	/**
	 * Access Token of variable description 
	 * @return
	 */
	public Variable getVariable(){
		return this.variable;
	}
	
	/**
	 * Access Token operators type values 
	 * @return
	 */
	public Operator getOperator(){
		return this.operator;
	}
	
	/**
	 * Access Token method name type values 
	 * @return
	 */
	public String getFunctionName(){
		//TODO 考虑后期直接return Method
		return this.tokenText;
	}
	
	/**
	 * Access Token of separator type values 
	 * @return
	 */	
	public String getSplitor(){
		return this.tokenText;
	}

	public int getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}
	
	@Override
	public String toString(){
		return tokenText;
	}
}
