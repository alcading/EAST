
package org.topexpression.format.reader;

import java.io.IOException;

import org.topexpression.IllegalExpressionException;
import org.topexpression.format.Element;
import org.topexpression.format.ExpressionReader;
import org.topexpression.format.Element.ElementType;


/**
 * Read a word segment 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class VariableTypeReader implements ElementReader {

	public static final String STOP_CHAR = "+-*/%^<>=&|!?:#(),[]'\" \r\n\t";//Word segment of the end operator 
	
	public static final String TRUE_WORD = "true";
	public static final String FALSE_WORD = "false";
	
	public static final String NULL_WORD = "null";
	/**
	 * 
	 * @param sr
	 * @return
	 * @throws FormatException
	 */
	private String readWord(ExpressionReader sr) throws IllegalExpressionException, IOException {
		StringBuffer sb = new StringBuffer();
		boolean readStart = true;
		int b = -1;
		while ((b = sr.read()) != -1) {
			char c = (char)b;
			if (STOP_CHAR.indexOf(c) >= 0 && !readStart) {//Word stop identifier, and to ignore the first character 
				sr.reset();
				return sb.toString();
			}
			if (!Character.isJavaIdentifierPart(c)) {
				throw new IllegalExpressionException("名称不能为非法字符：" + c,sr.getCurrentIndex());
			}
			if (readStart) {
				if (!Character.isJavaIdentifierStart(c)) {
					throw new IllegalExpressionException("名称开头不能为字符：" + c,sr.getCurrentIndex());
				}
				readStart = false;
			}
			sb.append(c);
			sr.mark(0);
		}
		return sb.toString();
	}
	
	public Element read(ExpressionReader sr) throws IllegalExpressionException, IOException {
		int index = sr.getCurrentIndex();
		String word = readWord(sr);

		if (TRUE_WORD.equals(word) || FALSE_WORD.equals(word)) {
			return new Element(word, index, ElementType.BOOLEAN);
		} else if (NULL_WORD.equals(word)) {
			return new Element(word, index, ElementType.NULL);
		} else {
			return new Element(word, index, ElementType.VARIABLE);
		}
	}
	
}
