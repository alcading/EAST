
package org.topexpression;

import java.util.Collection;
import java.util.List;

import org.topexpression.datameta.Constant;
import org.topexpression.datameta.Variable;

/**
 * Expression parser (main entrance procedures) 
 * ExpressionEvaluator Is multi-threaded safe 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class ExpressionEvaluator {
	
	/**
	 * Validation expression 
	 * @param expression
	 * @return
	 * @throws IllegalExpressionException 
	 */
	public static Object compile(String expression) throws IllegalExpressionException{
		return compile(expression , null);
	}
	
	/**
	 * Validation expression 
	 * @param expression
	 * @param variables
	 * @return
	 * @throws IllegalExpressionException 
	 * @throws IllegalExpressionException 
	 */
	public static Object compile(String expression, Collection<Variable> variables) throws IllegalExpressionException{
		if (expression == null) {
			throw new IllegalExpressionException("表达式为空");
		}
		
		ExpressionExecutor ee = new ExpressionExecutor();
		try{
			//Obtain the context of variables, setting the script actuators 
			if(variables != null && variables.size() > 0){						
				for(Variable var : variables ){
					//Add change came to script variable containers 
					VariableContainer.addVariable(var);
				}
			}
			//Analytical expressions for term 
			List<ExpressionToken> expTokens = ee.analyze(expression);
			//Conversion RPN, and verification 
			expTokens = ee.compile(expTokens);	
			//In string form output RPN 
//			return ee.tokensToString(expTokens);
			Constant constant = ee.compileExp(expTokens);	
			return constant.toJavaObject();
		} catch(IllegalExpressionException e1){
			throw e1;
		}catch(Exception e2){
			throw new IllegalExpressionException(e2.getMessage());
		}finally{
			//Release script variable containers 
			VariableContainer.removeVariableMap();
		}
	}
	
	
	/**
	 * Execute no variable expression 
	 * @param expression
	 * @return
	 * @throws IllegalExpressionException 
	 */
	public static Object evaluate(String expression) throws IllegalExpressionException{
		return evaluate(expression , null);
	}
	
	/**
	 * According to the process execution context, the formula of language 
	 * @param expression
	 * @param variables
	 * @return
	 * @throws IllegalExpressionException 
	 */
	public static Object evaluate(String expression, Collection<Variable> variables) throws IllegalExpressionException {
		if (expression == null) {
			return null;
		}
		
		ExpressionExecutor ee = new ExpressionExecutor();
		try{
			//Obtain the context of variables, setting the script actuators 
			if(variables != null && variables.size() > 0){						
				for(Variable var : variables ){
					//Add change came to script variable containers 
					VariableContainer.addVariable(var);
				}
			}
			//Analytical expressions for term 
			List<ExpressionToken> expTokens = ee.analyze(expression);
			//Conversion RPN, and verification 
			expTokens = ee.compile(expTokens);
			//Execution RPN 
			Constant constant = ee.execute(expTokens);	
			return constant.toJavaObject();

		}catch(IllegalExpressionException e1){
			throw e1;
		}catch(Exception e2){
			throw new IllegalExpressionException(e2.getMessage());
		}finally{
			//Release script variable containers 
			VariableContainer.removeVariableMap();
		}
	}
	
	/**
	 * Region.then add expression context variable 
	 * @param variable
	 */
	public static void addVarible(Variable variable){
		//Add change came to script variable containers 
		VariableContainer.addVariable(variable);
	}	
	
	/**
	 * Batch add expression context variable 
	 * @param variables
	 */
	public static void addVaribles(Collection<Variable> variables){
		//Obtain the context of variables, setting the script actuators 
		if(variables != null && variables.size() > 0){						
			for(Variable var : variables ){
				//Add change came to script variable containers 
				VariableContainer.addVariable(var);
			}
		}		
	}

	
}
