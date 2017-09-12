
package org.topexpression.format;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.topexpression.ExpressionToken;
import org.topexpression.IllegalExpressionException;
import org.topexpression.ExpressionToken.ETokenType;
import org.topexpression.datameta.BaseDataMeta.DataType;
import org.topexpression.format.Element.ElementType;
import org.topexpression.op.Operator;

/**
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class ExpressionParser {
	
private static Map<String, Operator> operators = new HashMap<String, Operator>();
	
	static{
		operators.put(Operator.MUTI.getToken(), Operator.MUTI);
		operators.put(Operator.DIV.getToken(), Operator.DIV);
		operators.put(Operator.MOD.getToken(), Operator.MOD);
		operators.put(Operator.PLUS.getToken(), Operator.PLUS);
		operators.put(Operator.MINUS.getToken(), Operator.MINUS);

	}
	
	/**
	 * Through the name obtain operators 
	 * @param name
	 * @return
	 */
	public Operator getOperator(String name) {
		return operators.get(name);
	}

	private Stack<String> parenthesis = new Stack<String>();//Matching parentheses stack 
	
	public List<ExpressionToken> getExpressionTokens(String expression) throws IllegalExpressionException {
		ExpressionReader eReader = new ExpressionReader(expression);
		List<ExpressionToken> list = new ArrayList<ExpressionToken>();
		ExpressionToken expressionToken = null;//The last time the ExpressionToken read 
		ExpressionToken tempExpressionToken = null;
		Element ele = null;
		try {
			while ((ele = eReader.readToken()) != null) {
				tempExpressionToken=expressionToken;
				expressionToken = changeToToken(expressionToken, ele);
				//If is parentheses, the recording, the last final match 
				pushParenthesis(ele);
				if((tempExpressionToken!=null && expressionToken!=null && "(".equals(tempExpressionToken.getSplitor()) && ",".equals(expressionToken.getSplitor())) ||
					(tempExpressionToken!=null && expressionToken!=null && ",".equals(tempExpressionToken.getSplitor()) && ",".equals(expressionToken.getSplitor())) ||
					(tempExpressionToken!=null && expressionToken!=null && ",".equals(tempExpressionToken.getSplitor()) && ")".equals(expressionToken.getSplitor()))
				){
					list.add(ExpressionToken.createConstantToken(DataType.DATATYPE_NULL, null));
				}
				list.add(expressionToken);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
			throw new IllegalExpressionException("表达式词元格式异常",ele.getIndex());
		}
		if(!parenthesis.isEmpty()) {
			throw new IllegalExpressionException("括号匹配出错",ele.getIndex());
		}

		return list;
	}
	
	/**
	 * If is parentheses, the recording, the last final match 
	 * @param ele
	 * @throws AntipathicException 
	 */
	public void pushParenthesis(Element ele) throws IllegalExpressionException {
		if (ElementType.SPLITOR == ele.getType()) {
			if (ele.getText().equals("(")) {
				parenthesis.push("(");
			} else if (ele.getText().equals(")")) {
				if (parenthesis.isEmpty() || !parenthesis.peek().equals("(")) {
					throw new IllegalExpressionException("括号匹配出错",ele.getIndex());
				} else {
					parenthesis.pop();
				}
			}
		}
	}
	
	/**
	 * Will ExpressionToken syncopated elements into, and validation minus or minus 
	 * @param previousToken
	 * @param ele
	 * @return
	 * @throws ParseException 
	 * @throws IllegalExpressionException 
	 */
	public ExpressionToken changeToToken(ExpressionToken previousToken, Element ele) throws ParseException, IllegalExpressionException {
		if (ele == null) {
			throw new IllegalExpressionException();
		}
		ExpressionToken token = null;
		
		//into ExpressionToken
		if (ElementType.NULL == ele.getType()) {
			token =  ExpressionToken.createConstantToken(DataType.DATATYPE_NULL, null);
		} else if (ElementType.BOOLEAN == ele.getType()) {
			token =  ExpressionToken.createConstantToken(DataType.DATATYPE_BOOLEAN, Boolean.valueOf(ele.getText()));
		}  else if (ElementType.STRING == ele.getType()) {
			token =  ExpressionToken.createConstantToken(DataType.DATATYPE_STRING, ele.getText());
		} else if (ElementType.INT == ele.getType()) {
			token =  ExpressionToken.createConstantToken(DataType.DATATYPE_INT, Integer.valueOf(ele.getText()));
		} else if (ElementType.LONG == ele.getType()) {
			token =  ExpressionToken.createConstantToken(DataType.DATATYPE_LONG, Long.valueOf(ele.getText()));
		} else if (ElementType.FLOAT == ele.getType()) {
			token =  ExpressionToken.createConstantToken(DataType.DATATYPE_FLOAT, Float.valueOf(ele.getText()));
		} else if (ElementType.DOUBLE == ele.getType()) {
			token =  ExpressionToken.createConstantToken(DataType.DATATYPE_DOUBLE, Double.valueOf(ele.getText()));
		} else if (ElementType.VARIABLE == ele.getType()) {
			token =  ExpressionToken.createVariableToken(ele.getText());
		} else if (ElementType.OPERATOR == ele.getType()) {
			//Distinguish between minus 
			if (ele.getText().equals("-") && (
					previousToken == null //With "-" beginning affirmation is a minus 
					|| previousToken.getTokenType() == ETokenType.ETOKEN_TYPE_OPERATOR //Operators behind affirmation is a minus 
					|| previousToken.getTokenType() == ETokenType.ETOKEN_TYPE_SPLITOR //"(" or", "behind affirmation is a minus 
					&& !")".equals(previousToken.getSplitor())
				)) {
					token = ExpressionToken.createOperatorToken(Operator.NG);
			} else {
				token =  ExpressionToken.createOperatorToken(getOperator(ele.getText()));
			}
		} else if (ElementType.FUNCTION == ele.getType()) {
			token =  ExpressionToken.createFunctionToken(ele.getText());
		} else if (ElementType.SPLITOR == ele.getType()) {
			token =  ExpressionToken.createSplitorToken(ele.getText());
		}
		token.setStartPosition(ele.getIndex());
		
		return token;
	}
}
