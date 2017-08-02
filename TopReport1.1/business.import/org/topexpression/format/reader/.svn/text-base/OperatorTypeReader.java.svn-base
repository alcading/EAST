
package org.topexpression.format.reader;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.topexpression.IllegalExpressionException;
import org.topexpression.format.Element;
import org.topexpression.format.ExpressionReader;
import org.topexpression.format.Element.ElementType;


/**
 * Read operators type
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class OperatorTypeReader implements ElementReader {
	
private static final Set<String> OPERATOR_WORDS = new HashSet<String>();
	
	static{
		OPERATOR_WORDS.add("+");
		OPERATOR_WORDS.add("-");
		OPERATOR_WORDS.add("*");
		OPERATOR_WORDS.add("/");
		OPERATOR_WORDS.add("%");
	}
	
	/**
	 * Judge whether string legal operators 
	 * @param tokenText
	 * @return
	 */
	public static boolean isOperatorWord(String tokenText){
		return OPERATOR_WORDS.contains(tokenText);
	}
	
	/**
	 * From the stream read operators types of ExpressionToken 
	 * @param sr
	 * @return
	 * @throws FormatException Not a legal operators type thrown when 
	 * @throws IOException
	 */
	public Element read(ExpressionReader sr) throws IllegalExpressionException, IOException {
		int index = sr.getCurrentIndex();
		StringBuffer sb = new StringBuffer();
		int b = sr.read();
		if (b == -1) {
			throw new IllegalExpressionException("表达式已结束",sr.getCurrentIndex());
		}
		char c = (char)b;
		sb.append(c);
		if (isOperatorWord(sb.toString())) {
			if (sb.length() == 1) {//Two symbols operators of priority, such as < =, should not be considered < operator 
				sr.mark(0);
				b = sr.read();
				if (b != -1) {
					if (isOperatorWord(sb.toString() + (char)b)) {
						return new Element(sb.toString() + (char)b, index,
								ElementType.OPERATOR);
					}
				}
				sr.reset();
			}
			return new Element(sb.toString(), index,
					ElementType.OPERATOR);
		}
		
		while ((b = sr.read()) != -1) {
			c = (char)b;
			sb.append(c);
			if (isOperatorWord(sb.toString())) {
				return new Element(sb.toString(), index,
						ElementType.OPERATOR);
			}
			if (VariableTypeReader.STOP_CHAR.indexOf(c) >= 0) {//Word stop operator 
				throw new IllegalExpressionException("不是有效的运算符：" + sb.toString(),sr.getCurrentIndex());
			}
		}
		throw new IllegalExpressionException("不是有效的运算符结束",sr.getCurrentIndex());
	}
	
	/**
	 * To test whether for operators 
	 * @param sr
	 * @return
	 * @throws IOException
	 */
	public static boolean isOperatorStart(ExpressionReader sr) throws IOException {
		sr.mark(0);
		try {
			StringBuffer sb = new StringBuffer();
			int b = sr.read();
			if (b == -1) {
				return false;
			}
			char c = (char)b;
			sb.append(c);
			if (isOperatorWord(sb.toString())) {
				return true;
			}
			while ((b = sr.read()) != -1) {
				c = (char)b;
				sb.append(c);
				if (isOperatorWord(sb.toString())) {
					return true;
				}
				if (VariableTypeReader.STOP_CHAR.indexOf(c) >= 0) {//Word stop operator 
					return false;
				}
				
			}
			return false;
		} finally{
			sr.reset();
		}
		
	}
}
