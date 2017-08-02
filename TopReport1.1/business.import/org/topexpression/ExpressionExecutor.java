
package org.topexpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.topexpression.ExpressionToken.ETokenType;
import org.topexpression.datameta.BaseDataMeta;
import org.topexpression.datameta.Constant;
import org.topexpression.datameta.Reference;
import org.topexpression.datameta.Variable;
import org.topexpression.datameta.BaseDataMeta.DataType;
import org.topexpression.format.ExpressionParser;
import org.topexpression.function.FunctionExecution;
import org.topexpression.op.Operator;


/**
 * Expression actuators 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class ExpressionExecutor {
	
	/**
	 * An expression of grammatical analysis, converts it into Token object queue 
	 * @param expression
	 * @return
	 */
	public List<ExpressionToken> analyze(String expression)throws IllegalExpressionException{
		
		ExpressionParser expParser = new ExpressionParser();		
		List<ExpressionToken> list = null;
			list = expParser.getExpressionTokens(expression);
			return list;
	
		
	}
	
	/**
	 * Execute inverse Poland type 
	 * @return
	 * @throws IllegalExpressionException 
	 */
	public Constant execute(List<ExpressionToken> _RPNExpList) throws IllegalExpressionException{
		if(_RPNExpList == null || _RPNExpList.isEmpty()){
			throw new IllegalExpressionException("无法执行空的逆波兰式队列");
		}
		
		//Initialization compiler stack 
		Stack<ExpressionToken> compileStack = new Stack<ExpressionToken>();
		
		for(ExpressionToken expToken : _RPNExpList){
			
			if(ExpressionToken.ETokenType.ETOKEN_TYPE_CONSTANT == expToken.getTokenType()){
				//Read a constant, pressed into the stack 
				compileStack.push(expToken);
				
			}else if (ExpressionToken.ETokenType.ETOKEN_TYPE_VARIABLE == expToken.getTokenType()){
				//Reads a variable 
				//From the context of practical value, obtain variables can translate into constants Token, pressed into the stack 
				Variable varWithValue = VariableContainer.getVariable(expToken.getVariable().getVariableName());
				if(varWithValue != null){
					//Generate a value constants，varWithValue.getDataValue There may be null 
					ExpressionToken constantToken = ExpressionToken.createConstantToken(
										varWithValue.getDataType()
										, varWithValue.getDataValue());
					compileStack.push(constantToken);
					
				}else{				
					//If the variable no defined, considered null type 
					ExpressionToken constantToken = ExpressionToken.createConstantToken(
							DataType.DATATYPE_NULL
							, null);
					compileStack.push(constantToken);
				}
				
				
			}else if (ExpressionToken.ETokenType.ETOKEN_TYPE_OPERATOR == expToken.getTokenType()){
				Operator operator = expToken.getOperator();
				//Judge a few yuan operators 
				int opType = operator.getOpType();
				//Obtain corresponding parameters number 
				Constant[] args = new Constant[opType];
				ExpressionToken argToken = null;
				for(int i = 0 ; i < opType ; i++){					
					if(!compileStack.empty()){						
						argToken = compileStack.pop();						
						if(ExpressionToken.ETokenType.ETOKEN_TYPE_CONSTANT == argToken.getTokenType()){
							args[i] = argToken.getConstant();							
						}else{
							//If remove the Token is not constant, then throw mistake 
							throw new IllegalExpressionException("操作符" + operator.getToken() + "找不到相应的参数，或参数个数不足;位置：" + expToken.getStartPosition(),expToken.getStartPosition());						
						}
					}else{
						//Stack has been playing an empty, without via operators corresponding operands 
						throw new IllegalExpressionException("操作符" + operator.getToken() + "找不到相应的参数，或参数个数不足;位置：" + expToken.getStartPosition(),expToken.getStartPosition());						
					}
				}
				//Tectonic quoted constants object 
				Reference ref=null;
				try {
					ref = new Reference(expToken , args);
				} catch (IllegalExpressionException e) {
					if(e.getErrorPosition()==-1){
						e.setErrorPosition(ref.getToken().getStartPosition());
					}
					throw e;
				}
				ExpressionToken resultToken =  ExpressionToken.createReference(ref);
				//Citations object pressed into the stack 
				compileStack.push(resultToken);
				
			}else if (ExpressionToken.ETokenType.ETOKEN_TYPE_FUNCTION == expToken.getTokenType()){
				
				if(!compileStack.empty()){
					
					ExpressionToken onTop = compileStack.pop();
					//Check to meet a function word yuan, execution in a stack of the popup first word yuan whether for “）”
					if(")".equals(onTop.getSplitor())){
						boolean doPop = true;
						List<Constant> argsList = new ArrayList<Constant>();
						ExpressionToken parameter = null;
						//Popup the parameters of the function, until encounter "(" to end 
						while(doPop && !compileStack.empty()){
							parameter = compileStack.pop();
							if(ExpressionToken.ETokenType.ETOKEN_TYPE_CONSTANT == parameter.getTokenType()){
								argsList.add(parameter.getConstant());
							}else if("(".equals(parameter.getSplitor())){
								doPop = false;
							}else{
								//In a function meet neither constants, also not "(", the error occurs 
								throw new IllegalExpressionException("函数" + expToken.getFunctionName() + "执行时遇到非法参数" + parameter.toString(),expToken.getStartPosition());						
							}
						}
						
						if(doPop && compileStack.empty()){
							//Operation with empty, find no stack () function left brace ( 
							throw new IllegalExpressionException("函数" + expToken.getFunctionName() + "执行时没有找到应有的\"(\"" ,expToken.getStartPosition());						
						}
						
						//Executive function 
						Constant[] arguments = new Constant[argsList.size()];
						arguments = argsList.toArray(arguments);						
						//Tectonic quoted constants object 
						Reference ref=null;
						try {
							ref = new Reference(expToken , arguments);
						} catch (IllegalExpressionException e) {
							if(e.getErrorPosition()==-1){
								e.setErrorPosition(ref.getToken().getStartPosition());
							}
							throw e;
						}
						ExpressionToken resultToken =  ExpressionToken.createReference(ref);
						//Citations object pressed into the stack 
						compileStack.push(resultToken);
						
					}else{
						//Find no should exist right brace 
						throw new IllegalExpressionException("函数" + expToken.getFunctionName() + "执行时没有找到应有的\")\"" ,expToken.getStartPosition());						
					
					}
					
				}else{
					//Find no should exist right brace 
					throw new IllegalExpressionException("函数" + expToken.getFunctionName() + "执行时没有找到应有的\")\"" ,expToken.getStartPosition());						
				}

			}else if (ExpressionToken.ETokenType.ETOKEN_TYPE_SPLITOR == expToken.getTokenType()){
				//Reading a separator, pressed into the stack, usually are "(" and")" 
				compileStack.push(expToken);

			}			
		}
		
		//Expression compiler completion, it is compiled within only a compiler should stack results 
		if(compileStack.size() == 1){
			ExpressionToken token = compileStack.pop();
			Constant result = token.getConstant();
			//Execute instead constants 
			if(result.isReference()){
				Reference resultRef = (Reference)result.getDataValue();				
				try {
					return resultRef.execute();
				} catch (IllegalExpressionException e) {
					if(e.getErrorPosition()==-1){
						e.setErrorPosition(resultRef.getToken().getStartPosition());
					}
					throw e;
				}
				
			}else{
				//Return to normal constants 
				return result;
			}
		}else{
			StringBuffer errorBuffer = new StringBuffer("\r\n");
			while(!compileStack.empty()){
				ExpressionToken onTop = compileStack.pop();
				errorBuffer.append("\t").append(onTop.toString()).append("\r\n");
			}
			throw new IllegalExpressionException("表达式不完整.\r\n 结果状态异常:" + errorBuffer);						
		}
	}	
	
	public Constant compileExp(List<ExpressionToken> _RPNExpList) throws IllegalExpressionException{
		if(_RPNExpList == null || _RPNExpList.isEmpty()){
			throw new IllegalExpressionException("无法执行空的逆波兰式队列");
		}
		
		//Initialization compiler stack 
		Stack<ExpressionToken> compileStack = new Stack<ExpressionToken>();
		
		for(ExpressionToken expToken : _RPNExpList){
			
			if(ExpressionToken.ETokenType.ETOKEN_TYPE_CONSTANT == expToken.getTokenType()){
				//Read a constant, pressed into the stack 
				compileStack.push(expToken);
				
			}else if (ExpressionToken.ETokenType.ETOKEN_TYPE_VARIABLE == expToken.getTokenType()){
				//Reads a variable 
				//From the context of practical value, obtain variables can translate into constants Token, pressed into the stack 
				Variable varWithValue = VariableContainer.getVariable(expToken.getVariable().getVariableName());
				if(varWithValue != null){
					//Generate a value constants，varWithValue.getDataValue There may be null 
					ExpressionToken constantToken = ExpressionToken.createConstantToken(
										varWithValue.getDataType()
										, varWithValue.getDataValue());
					compileStack.push(constantToken);
					
				}else{				
					//If the variable no defined, considered null type 
					ExpressionToken constantToken = ExpressionToken.createConstantToken(
							DataType.DATATYPE_NULL
							, null);
					compileStack.push(constantToken);
				}
				
				
			}else if (ExpressionToken.ETokenType.ETOKEN_TYPE_OPERATOR == expToken.getTokenType()){
				Operator operator = expToken.getOperator();
				//Judge a few yuan operators 
				int opType = operator.getOpType();
				//Obtain corresponding parameters number 
				Constant[] args = new Constant[opType];
				ExpressionToken argToken = null;
				for(int i = 0 ; i < opType ; i++){					
					if(!compileStack.empty()){						
						argToken = compileStack.pop();						
						if(ExpressionToken.ETokenType.ETOKEN_TYPE_CONSTANT == argToken.getTokenType()){
							args[i] = argToken.getConstant();							
						}else{
							//If remove the Token is not constant, then throw mistake 
							throw new IllegalExpressionException("操作符" + operator.getToken() + "找不到相应的参数，或参数个数不足;位置：" + expToken.getStartPosition(),expToken.getStartPosition());						
						}
					}else{
						//Stack has been playing an empty, without via operators corresponding operands 
						throw new IllegalExpressionException("操作符" + operator.getToken() + "找不到相应的参数，或参数个数不足;位置：" + expToken.getStartPosition(),expToken.getStartPosition());						
					}
				}
				//Tectonic quoted constants object 
				Reference ref=null;
				try {
					ref = new Reference(expToken , args);
				} catch (IllegalExpressionException e) {
					if(e.getErrorPosition()==-1){
						e.setErrorPosition(ref.getToken().getStartPosition());
					}
					throw e;
				}
				ExpressionToken resultToken =  ExpressionToken.createReference(ref);
				//Citations object pressed into the stack 
				compileStack.push(resultToken);
				
			}else if (ExpressionToken.ETokenType.ETOKEN_TYPE_FUNCTION == expToken.getTokenType()){
				
				if(!compileStack.empty()){
					
					ExpressionToken onTop = compileStack.pop();
					//Check to meet a function word yuan, execution in a stack of the popup first word yuan whether for “）”
					if(")".equals(onTop.getSplitor())){
						boolean doPop = true;
						List<Constant> argsList = new ArrayList<Constant>();
						ExpressionToken parameter = null;
						//Popup the parameters of the function, until encounter "(" to end 
						while(doPop && !compileStack.empty()){
							parameter = compileStack.pop();
							if(ExpressionToken.ETokenType.ETOKEN_TYPE_CONSTANT == parameter.getTokenType()){
								argsList.add(parameter.getConstant());
							}else if("(".equals(parameter.getSplitor())){
								doPop = false;
							}else{
								//In a function meet neither constants, also not "(", the error occurs 
								throw new IllegalExpressionException("函数" + expToken.getFunctionName() + "执行时遇到非法参数" + parameter.toString(),expToken.getStartPosition());						
							}
						}
						
						if(doPop && compileStack.empty()){
							//Operation with empty, find no stack () function left brace ( 
							throw new IllegalExpressionException("函数" + expToken.getFunctionName() + "执行时没有找到应有的\"(\"" ,expToken.getStartPosition());						
						}
						
						//Executive function 
						Constant[] arguments = new Constant[argsList.size()];
						arguments = argsList.toArray(arguments);						
						//Tectonic quoted constants object 
						Reference ref=null;
						try {
							ref = new Reference(expToken , arguments);
						} catch (IllegalExpressionException e) {
							if(e.getErrorPosition()==-1){
								e.setErrorPosition(ref.getToken().getStartPosition());
							}
							throw e;
						}
						ExpressionToken resultToken =  ExpressionToken.createReference(ref);
						//Citations object pressed into the stack 
						compileStack.push(resultToken);
						
					}else{
						//Find no should exist right brace 
						throw new IllegalExpressionException("函数" + expToken.getFunctionName() + "执行时没有找到应有的\")\"" ,expToken.getStartPosition());						
					
					}
					
				}else{
					//Find no should exist right brace 
					throw new IllegalExpressionException("函数" + expToken.getFunctionName() + "执行时没有找到应有的\")\"" ,expToken.getStartPosition());						
				}

			}else if (ExpressionToken.ETokenType.ETOKEN_TYPE_SPLITOR == expToken.getTokenType()){
				//Reading a separator, pressed into the stack, usually are "(" and")" 
				compileStack.push(expToken);

			}			
		}
		
		//Expression compiler completion, it is compiled within only a compiler should stack results 
		if(compileStack.size() == 1){
			ExpressionToken token = compileStack.pop();
			Constant result = token.getConstant();
			//Execute instead constants 
			if(result.isReference()){
				Reference resultRef = (Reference)result.getDataValue();				
				try {
					return resultRef.executeExp();
				} catch (IllegalExpressionException e) {
					if(e.getErrorPosition()==-1){
						e.setErrorPosition(resultRef.getToken().getStartPosition());
					}
					throw e;
				}
				
			}else{
				//Return to normal constants 
				return result;
			}
		}else{
			StringBuffer errorBuffer = new StringBuffer("\r\n");
			while(!compileStack.empty()){
				ExpressionToken onTop = compileStack.pop();
				errorBuffer.append("\t").append(onTop.toString()).append("\r\n");
			}
			throw new IllegalExpressionException("表达式不完整.\r\n 结果状态异常:" + errorBuffer);						
		}
	}	
	
	/**
	 * The expression list for term into rotative string 
	 * @param tokenList
	 * @return
	 * @throws IllegalExpressionException 
	 */
	public String tokensToString(List<ExpressionToken> tokenList) throws IllegalExpressionException{
		if(tokenList == null){
			throw new IllegalExpressionException("参数tokenList为空");
		}
		
		StringBuffer expressionText = new StringBuffer();
		for(ExpressionToken token : tokenList){
			
			ExpressionToken.ETokenType tokenType = token.getTokenType();
			
			if(ETokenType.ETOKEN_TYPE_CONSTANT == tokenType){
				
				Constant c = token.getConstant();
				if(BaseDataMeta.DataType.DATATYPE_DOUBLE == c.getDataType()){
					expressionText.append(c.getDataValueText()).append(" ");

				}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == c.getDataType()){
					expressionText.append(c.getDataValueText()).append("F ");
					
				}else if(BaseDataMeta.DataType.DATATYPE_INT == c.getDataType()){
					expressionText.append(c.getDataValueText()).append(" ");
					
				}else if(BaseDataMeta.DataType.DATATYPE_LONG == c.getDataType()){
					expressionText.append(c.getDataValueText()).append("L ");

				}else if(BaseDataMeta.DataType.DATATYPE_NULL == c.getDataType()){
					expressionText.append(c.getDataValueText()).append(" ");
					
				}else if(BaseDataMeta.DataType.DATATYPE_STRING == c.getDataType()){
					expressionText.append("\"").append(c.getDataValueText()).append("\" ");
					
				}
				
			}else if(ETokenType.ETOKEN_TYPE_VARIABLE == tokenType){
				expressionText.append(token.getVariable().getVariableName()).append(" ");
				
			}else if( ETokenType.ETOKEN_TYPE_FUNCTION == tokenType){
				expressionText.append(token.getFunctionName()).append(" ");
				
			}else if( ETokenType.ETOKEN_TYPE_OPERATOR == tokenType ){
				expressionText.append(token.getOperator().toString()).append(" ");
				
			}else if( ETokenType.ETOKEN_TYPE_SPLITOR == tokenType ){
				expressionText.append(token.getSplitor()).append(" ");
				
			}			
		}		
		return expressionText.toString();
	}
	
	/**
	 * Will express distributed-group management.then channeling (formatting good), convert word yuan list 
	 * @param tokenExpression
	 * @return
	 */
	public List<ExpressionToken> stringToTokens(String tokenExpression) throws IllegalExpressionException{
		
		if(tokenExpression == null){
			throw new IllegalExpressionException("参数tokenExpression为空");
		}	
		
		List<ExpressionToken> tokens = new ArrayList<ExpressionToken>();
		
		char[] expChars = tokenExpression.toCharArray();
		//String scanning state, 0: ordinary, 2: string 3: escapes descriptor 
		int status = 0;
		StringBuffer tokenBuffer = new StringBuffer();
		for(int i = 0 ; i < expChars.length ; i++){
			//读入空格
			if(' ' == expChars[i]){				
				if(status == 0){
					//Normally, read Spaces, segmentation token 
					addToken(tokenBuffer.toString() , tokens);
					//Empty buffer 
					tokenBuffer = new StringBuffer();
				}else if(status ==2){
					tokenBuffer.append(expChars[i]);
				}else {
					throw new IllegalExpressionException("非法的转义符\"" + expChars[i] + "\" ，位置：" + i,i);
				}
			}else if('"' == expChars[i]){//read '"'
				if(status == 0){
					status = 2;//Enter rotative string 
					tokenBuffer.append(expChars[i]);
				}else if(status == 2){
					status = 0; //Leave rotative string 
					tokenBuffer.append(expChars[i]);
				}else{
					status = 2; //Escapes "date, leave escapes into string state 
					tokenBuffer.append(expChars[i]);
				}
				
			}else if('\\' == expChars[i]){//read '\'
				if(status == 0){
					throw new IllegalExpressionException("非法的字符\"" + expChars[i] + "\" ，位置：" + i,i);
				}else if(status == 2){
					status = 3; //Enter escapes state 
					tokenBuffer.append(expChars[i]);
				}else{
					status = 2; //Escapes \ number, leave escapes into string state 
					tokenBuffer.append(expChars[i]);
				}
				
			}else{//Read other characters 
				if(status == 0 || status == 2){
					tokenBuffer.append(expChars[i]);
				}else{
					throw new IllegalExpressionException("非法的转义符\"" + expChars[i] + "\" ，位置：" + i);
				}
			}

		}
		
		tokenBuffer.trimToSize();
		if(tokenBuffer.length() > 0 ){
			addToken(tokenBuffer.toString() , tokens);
		}
		return tokens;
	}	
	
	/**
	 * Will the son flee into Token and join the list 
	 * @param tokenString
	 * @param tokens
	 * @throws IllegalExpressionException 
	 */
	private void addToken(String tokenString , List<ExpressionToken> tokens) throws IllegalExpressionException{
		
		ExpressionToken token = null;
		//null
		if( ExpressionTokenHelper.isNull(tokenString)){
			token = ExpressionToken.createConstantToken(BaseDataMeta.DataType.DATATYPE_NULL , null);
			tokens.add(token);
			
		}else
		//integer
		if(ExpressionTokenHelper.isInteger(tokenString)){
			token = ExpressionToken.createConstantToken(BaseDataMeta.DataType.DATATYPE_INT , Integer.valueOf(tokenString));
			tokens.add(token);
			
		}else
		//long 
		if( ExpressionTokenHelper.isLong(tokenString)){
			token = ExpressionToken.createConstantToken(BaseDataMeta.DataType.DATATYPE_LONG , Long.valueOf(tokenString.substring(0 , tokenString.length() - 1)));
			tokens.add(token);
			
		}else
		//float 
		if( ExpressionTokenHelper.isFloat(tokenString)){
			token = ExpressionToken.createConstantToken(BaseDataMeta.DataType.DATATYPE_FLOAT , Float.valueOf(tokenString.substring(0 , tokenString.length() - 1)));
			tokens.add(token);
			
		}else
		//double
		if(ExpressionTokenHelper.isDouble(tokenString)){
			token = ExpressionToken.createConstantToken(BaseDataMeta.DataType.DATATYPE_DOUBLE , Double.valueOf(tokenString));
			tokens.add(token);

		}else				
		//String
		if(ExpressionTokenHelper.isString(tokenString)){
			token = ExpressionToken.createConstantToken(BaseDataMeta.DataType.DATATYPE_STRING , tokenString.substring(1 , tokenString.length() - 1));
			tokens.add(token);
		}else
		//separator 
		if(ExpressionTokenHelper.isSplitor(tokenString)){
			token = ExpressionToken.createSplitorToken(tokenString);
			tokens.add(token);

		}else			
		//function 
		if(ExpressionTokenHelper.isFunction(tokenString)){
			token = ExpressionToken.createFunctionToken(tokenString.substring(1 , tokenString.length()));
			tokens.add(token);
			
		}else		
		//operator 
		if(ExpressionTokenHelper.isOperator(tokenString)){
			Operator operator = Operator.valueOf(tokenString);
			token = ExpressionToken.createOperatorToken(operator);
			tokens.add(token);

		}else{
			//The rest should be variable, this judgment depends on generated RPN is correct premise 
			//Variables, in Boolean type and null type discriminant after, as long as it is not begin, behind the letters "(" is variable 
			token = ExpressionToken.createVariableToken(tokenString);
			tokens.add(token);
	
		}		
	}
	/**
	 * Normal expression for term sequence, convert inverse Poland type sequence 
	 * Meanwhile check expression grammar 
	 * @param expTokens
	 * @return
	 */
	public List<ExpressionToken> compile(List<ExpressionToken> expTokens) throws IllegalExpressionException{
		
		if(expTokens == null || expTokens.isEmpty()){
			throw new IllegalExpressionException("无法转化空的表达式");
		}
		
		//1.Initialize inverse Poland type queue and operators stack 
		List<ExpressionToken> _RPNExpList = new ArrayList<ExpressionToken>();
		Stack<ExpressionToken> opStack = new Stack<ExpressionToken>();
		//Initialize check stack 
		Stack<ExpressionToken> verifyStack = new Stack<ExpressionToken>();
		
		//2.The queue from left to right in turn convenient token 
		//2-1. Declare a storage function word yuan temporary variables 
		ExpressionToken _function = null;
	
		for(ExpressionToken expToken : expTokens){
			
			if(ExpressionToken.ETokenType.ETOKEN_TYPE_CONSTANT == expToken.getTokenType()){
				//Reads a constants, pressed into the inverse Poland type queue 
				_RPNExpList.add(expToken);
				//Meanwhile pressed into the calibration stack 
				verifyStack.push(expToken);
				
			} else if (ExpressionToken.ETokenType.ETOKEN_TYPE_VARIABLE == expToken.getTokenType()){
				//Validation variable declarations 
				Variable var = VariableContainer.getVariable(expToken.getVariable().getVariableName());
				if(var == null){
					//If the variable no defined, considered null type 
					expToken.getVariable().setDataType(DataType.DATATYPE_NULL);
					
				}else if(var.getDataType() == null){
					throw new IllegalExpressionException("表达式不合法，变量\"" + expToken.toString() + "\"缺少定义;位置:" + expToken.getStartPosition()
								, expToken.toString()
								, expToken.getStartPosition());						
				}else{
					//Set of variable type definition Token 
					expToken.getVariable().setDataType(var.getDataType());
				}
				
				//Read a variable, pressed into the inverse Poland type queue 
				_RPNExpList.add(expToken);
				//Meanwhile pressed into the calibration stack 
				verifyStack.push(expToken);
				
				
			} else if  (ExpressionToken.ETokenType.ETOKEN_TYPE_OPERATOR == expToken.getTokenType()){		
				//Reads a operators 
				if(opStack.empty()){//If the operation stack is empty 
						//一般操作符，则压入栈内；
						opStack.push(expToken);
				}else{
					boolean doPeek = true;
					while(!opStack.empty() && doPeek){
						//If the stack not null, however, have a stack of operator precedence 
						ExpressionToken onTopOp = opStack.peek();
						
						//If the stack elements are functions, direct will operators pressed into the stack 
						if( ExpressionToken.ETokenType.ETOKEN_TYPE_FUNCTION == onTopOp.getTokenType() ){
													
								opStack.push(expToken);
								doPeek = false;
							
						}else if( ExpressionToken.ETokenType.ETOKEN_TYPE_SPLITOR == onTopOp.getTokenType()
									&& "(".equals(onTopOp.getSplitor())){//If the stack element is (for directly operators pressed into the stack 							
							
								opStack.push(expToken);
								doPeek = false;
							
						}else if(ExpressionToken.ETokenType.ETOKEN_TYPE_OPERATOR == onTopOp.getTokenType()){
							//If the stack element is operator 						
							if(expToken.getOperator().getPiority() > onTopOp.getOperator().getPiority()){
								
									//The current operator precedence > stack operator precedence, will the current operator into the station 
									opStack.push(expToken);
									doPeek = false;
								
							}else if(expToken.getOperator().getPiority() == onTopOp.getOperator().getPiority()){							
									//The current operator precedence = stack operator precedence, and executing order from left to right, will stack operators popup 
									//Execute operators calibration 
									ExpressionToken result = verifyOperator(onTopOp, verifyStack);
									//The calibration results inspection push-up stack 
									verifyStack.push(result);
									//Calibration through, pop-up stack operators, joining the inverse Poland type queue 
									opStack.pop();
									_RPNExpList.add(onTopOp);
							
							}else {
								//The current operator precedence < stack operator precedence, will stack operators popup 
								//Execute operators calibration 
								ExpressionToken result = verifyOperator(onTopOp, verifyStack);
								//The calibration results inspection push-up stack 
								verifyStack.push(result);								
								//Calibration through, pop-up stack operators, joining the inverse Poland type queue 
								opStack.pop();
								_RPNExpList.add(onTopOp);
								
							}
						}
					}
					//The current operator precedence < = stack in all the operator precedence 
					if(doPeek && opStack.empty()){
						opStack.push(expToken);
					}
				}
				
			} else if (ExpressionToken.ETokenType.ETOKEN_TYPE_FUNCTION == expToken.getTokenType()){
				//Meet the function name, then use a temporary variable temporary down and wait (comes 
				_function = expToken;
	
			} else if (ExpressionToken.ETokenType.ETOKEN_TYPE_SPLITOR == expToken.getTokenType()){
				//Handle the reader "(" 
				if("(".equals(expToken.getSplitor())){
					//If the _function! = null, the specification is function of left brace 
					if(_function != null){
						//To the inverse Poland type queue pressed into the "(" 
						_RPNExpList.add(expToken);
						//To calibration stack pressed into the 
						verifyStack.push(expToken);
						
						//Will "(" and temporary buffer function pressed into the operator stacks, in parentheses before 
						opStack.push(expToken);
						opStack.push(_function);
						
						//Empty temporary variables 
						_function = null;
						
					}else{
						//Explain is common expressions left brace 
						//Will "(" pressed into the operator stack 
						opStack.push(expToken);						
					}
					
				//Treatment of ") "read 	
				}else if(")".equals(expToken.getSplitor())){
					
					boolean doPop = true;
	
					while(doPop && !opStack.empty()){						
						// From operators stack popup operator or functions 
						ExpressionToken onTopOp = opStack.pop();						
						if(ExpressionToken.ETokenType.ETOKEN_TYPE_OPERATOR == onTopOp.getTokenType()){							
													
							//If the stack element is ordinary operators, executive operators calibration 
							ExpressionToken result = verifyOperator(onTopOp, verifyStack);
							//The calibration results inspection push-up stack 
							verifyStack.push(result);
	
							// Calibration through, then added to the inverse Poland type of columns 
							_RPNExpList.add(onTopOp);
							
							
						}else if(ExpressionToken.ETokenType.ETOKEN_TYPE_FUNCTION == onTopOp.getTokenType()){
							// If meet the function, then explaining ") "is the function of right brace 
							//Executive function calibration 
							ExpressionToken result = verifyFunction(onTopOp , verifyStack);
							//The calibration results inspection push-up stack 
							verifyStack.push(result);
							
							//Calibration through, adding ") "to the inverse Poland type 
							_RPNExpList.add(expToken);
							//Will function join inverse Poland type 
							_RPNExpList.add(onTopOp);							
							
						}else if("(".equals(onTopOp.getSplitor())){
							// If encounter "(", the operation over 
							doPop = false;
						}					
					}
					
					if(doPop && opStack.empty()){
						throw new IllegalExpressionException("在读入\")\"时，操作栈中找不到对应的\"(\" "
								, expToken.getSplitor()
								, expToken.getStartPosition());
					}
				
				//Read the ", "handle 
				}else if(",".equals(expToken.getSplitor())){
					//Ordinal popup operators stack of all operators, pressed into the inverse Poland type queue, until I met function word yuan 
					boolean doPeek = true;
					
					while(!opStack.empty() && doPeek){
						ExpressionToken onTopOp = opStack.peek();
						
						if(ExpressionToken.ETokenType.ETOKEN_TYPE_OPERATOR == onTopOp.getTokenType()){
													
							//Popup operators stack operators 
							opStack.pop();
							//Execute operators calibration 
							ExpressionToken result = verifyOperator(onTopOp, verifyStack);
							//The calibration results inspection push-up stack 
							verifyStack.push(result);
							//Calibration through, and pressed into the inverse Poland type queue 
							_RPNExpList.add(onTopOp);
							
						}else if(ExpressionToken.ETokenType.ETOKEN_TYPE_FUNCTION == onTopOp.getTokenType()){
							//Meet function word yuan, end popup 
							doPeek = false;
							
						}else if(ExpressionToken.ETokenType.ETOKEN_TYPE_SPLITOR == onTopOp.getTokenType() 
									&& "(".equals(onTopOp.getSplitor())){
							//In reads ",", operators stack for"(", the error occurs 
							throw new IllegalExpressionException("在读入\",\"时，操作符栈顶为\"(\",,(函数丢失) 位置：" + onTopOp.getStartPosition()
									, expToken.getSplitor()
									, expToken.getStartPosition());
						}
					}
					//Stack all pop-up, but not meet function word yuan 
					if(doPeek && opStack.empty()){
						throw new IllegalExpressionException("在读入\",\"时，操作符栈弹空，没有找到相应的函数词元 " 
								, expToken.getSplitor()
								, expToken.getStartPosition());
					}					
				}				
			}	
		}
		
		//Will operate within the rest of the operator - accessor to one popup, and pressed into the inverse Poland type queue 
		while(!opStack.empty()){
			ExpressionToken onTopOp = opStack.pop();
		
			if(ExpressionToken.ETokenType.ETOKEN_TYPE_OPERATOR == onTopOp.getTokenType() ){		
						
				//Execute operators calibration 
				ExpressionToken result = verifyOperator(onTopOp, verifyStack);
				//The calibration results inspection push-up stack 
				verifyStack.push(result);
					
				//Calibration success, operators to join inverse Poland type 			
				_RPNExpList.add(onTopOp);
			
			}else if(ExpressionToken.ETokenType.ETOKEN_TYPE_FUNCTION == onTopOp.getTokenType()){
				//If the surplus is function, the function lack right brace ")" 
				throw new IllegalExpressionException("函数" + onTopOp.getFunctionName() + "缺少\")\"" 
						, onTopOp.getFunctionName()
						, onTopOp.getStartPosition());						
				
			}else if("(".equals(onTopOp.getSplitor())){
				//The rest of the only have "(", then explaining expression formula lack right brace")" 
				throw new IllegalExpressionException("左括号\"(\"缺少配套的右括号\")\"" 
						, onTopOp.getFunctionName()
						, onTopOp.getStartPosition());						
			}			
		}
		
		//Expression calibration completion, it is only a stack should be within calibration results, otherwise as expressions don't finish 
		if(verifyStack.size() != 1){
	
			StringBuffer errorBuffer = new StringBuffer("\r\n");
			while(!verifyStack.empty()){
				ExpressionToken onTop = verifyStack.pop();
				errorBuffer.append("\t").append(onTop.toString()).append("\r\n");
			}
			throw new IllegalExpressionException("表达式不完整.\r\n 校验栈状态异常:" + errorBuffer);						
	
		}
		
		return _RPNExpList;
	}

	/**
	 * Execute operators calibration 
	 * @param op
	 * @param verifyStack
	 * @return
	 */
	private ExpressionToken verifyOperator(ExpressionToken opToken , Stack<ExpressionToken> verifyStack)throws IllegalExpressionException{
		//Judge a few yuan operators 
		Operator op = opToken.getOperator();
		int opType = op.getOpType();
		//Obtain corresponding parameters number 
		BaseDataMeta[] args = new BaseDataMeta[opType];
		ExpressionToken argToken = null;
		for(int i = 0 ; i < opType ; i++){			
			if(!verifyStack.empty()){				
				argToken = verifyStack.pop();
				
				if(ExpressionToken.ETokenType.ETOKEN_TYPE_CONSTANT == argToken.getTokenType()){
					args[i] = argToken.getConstant();
					
				}else if(ExpressionToken.ETokenType.ETOKEN_TYPE_VARIABLE == argToken.getTokenType()){
					args[i] = argToken.getVariable();
					
				}else{
					//If you take the Token is not constant, nor variables, then throw mistake 
					throw new IllegalExpressionException("表达式不合法，操作符\"" + op.getToken() + "\"参数错误;位置：" + argToken.getStartPosition()
							, opToken.toString()
							, opToken.getStartPosition());						
				}
				
			}else{
				//Stack has been playing an empty, without via operators corresponding operands 
				throw new IllegalExpressionException("表达式不合法，操作符\"" + op.getToken() + "\"找不到相应的参数，或参数个数不足;"					
								, opToken.toString()
								, opToken.getStartPosition());						
			}
		}
		//Execute operators calibration, and returns calibration 
		Constant result = op.verify(opToken.getStartPosition() , args);
		return ExpressionToken.createConstantToken(result);		 

	}

	/**
	 * Executive function calibration 
	 * @param op
	 * @param verifyStack
	 * @return
	 */
	private ExpressionToken verifyFunction(ExpressionToken funtionToken , Stack<ExpressionToken> verifyStack)throws IllegalExpressionException{
		
		if(!verifyStack.empty()){

			boolean doPop = true;
			List<BaseDataMeta> args = new ArrayList<BaseDataMeta>();
			ExpressionToken parameter = null;
			//Popup the parameters of the function, until encounter "(" to end 
			while(doPop && !verifyStack.empty()){
				parameter = verifyStack.pop();
				
				if(ExpressionToken.ETokenType.ETOKEN_TYPE_CONSTANT == parameter.getTokenType()){
					//constants 
					args.add(parameter.getConstant());
					
				}else if(ExpressionToken.ETokenType.ETOKEN_TYPE_VARIABLE == parameter.getTokenType()){
					args.add(parameter.getVariable());
					
				}else if("(".equals(parameter.getSplitor())){
					doPop = false;
					
				}else{
					//Find no should exist right brace 
					throw new IllegalExpressionException("表达式不合法，函数\"" + funtionToken.getFunctionName()+ "\"遇到非法参数" + parameter.toString() + ";位置:" + parameter.getStartPosition()
							, funtionToken.toString()
							, funtionToken.getStartPosition());						
				}
			}
			
			if(doPop && verifyStack.empty()){
				//Operation with empty, find no stack () function left brace ( 
				throw new IllegalExpressionException("表达式不合法，函数\"" + funtionToken.getFunctionName() + "\"缺少\"(\"；位置:" + (funtionToken.getStartPosition() + funtionToken.toString().length())
						, funtionToken.toString()
						, funtionToken.getStartPosition());						
			}
			
			//Calibration function 
			BaseDataMeta[] arguments = new BaseDataMeta[args.size()];
			arguments = args.toArray(arguments);
			Constant result = FunctionExecution.varify(funtionToken.getFunctionName(), funtionToken.getStartPosition() , arguments);
			return ExpressionToken.createConstantToken(result);
				
			
		}else{
			//Find no should exist right brace 
			throw new IllegalExpressionException("表达式不合法，函数\"" + funtionToken.getFunctionName() + "\"不完整" 
					, funtionToken.toString()
					, funtionToken.getStartPosition());
		}
	}
	
}
