
package org.topexpression.format.reader;

import java.io.IOException;

import org.topexpression.IllegalExpressionException;
import org.topexpression.format.Element;
import org.topexpression.format.ExpressionReader;
import org.topexpression.format.Element.ElementType;


/**
 * Read rotative string types 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class StringTypeReader implements ElementReader {
	public static final char START_MARK = '"';//Rotative string began to sign 
	public static final char END_MARK = '"';//Rotative string end symbol 	
	public static final char ESCAPE_MARK = '\\';//Symbols denoting 
	/**
	 * From flow reads rotative string types of ExpressionToken 
	 * @param sr
	 * @return ExpressionToken
	 * @throws FormatException Not a legal rotative string type thrown when 
	 * @throws IOException
	 */
	public Element read(ExpressionReader sr) throws IllegalExpressionException, IOException {
		int index = sr.getCurrentIndex();
		StringBuffer sb = new StringBuffer();
		int b = sr.read();
		if (b == -1 || b != START_MARK) {
			throw new IllegalExpressionException("不是有效的字符窜开始",sr.getCurrentIndex());
		}
		
		while ((b = sr.read()) != -1) {
			char c = (char)b;
			if (c == ESCAPE_MARK) {//Meet escapes characters 
				c = getEscapeValue((char)sr.read(),sr);
			} else if (c == END_MARK) {//Meet the escapes the quotation 
				return new Element(sb.toString(), index, ElementType.STRING);
			}
			sb.append(c);
		}
		throw new IllegalExpressionException("不是有效的字符窜结束",sr.getCurrentIndex());
	}
	
	/**
	 * Can escape character has \"nt
	 * @param c
	 * @return
	 * @throws FormatException
	 */
	private static char getEscapeValue(char c,ExpressionReader src) throws IllegalExpressionException {
		if (c == '\\' || c == '\"') {
			return c;
		} else if (c == 'n') {
			return '\n';
		} else if (c == 'r') {
			return '\r';
		} else if (c == 't') {
			return '\t';
		}
		throw new IllegalExpressionException("字符转义出错",src.getCurrentIndex());
	}
}
