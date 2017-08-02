
package org.topexpression.format.reader;

import java.io.IOException;

import org.topexpression.IllegalExpressionException;
import org.topexpression.format.Element;
import org.topexpression.format.ExpressionReader;
import org.topexpression.format.Element.ElementType;


/**
 * Reads digital type 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class NumberTypeReader implements ElementReader {
	public static final String NUMBER_CHARS = "01234567890.";//Represent the value of characters 
	public static final String LONG_MARKS = "lL";//Long ending sign 
	public static final String FLOAT_MARKS = "fF";//Float ending sign 
	public static final String DOUBLE_MARKS = "dD";//Double ending sign 
	
	/**
	 * From the flow of ExpressionToken reads digital type 
	 * @param sr
	 * @return
	 * @throws IllegalExpressionException 
	 * @throws FormatException Not a legal thrown when numeric types 
	 */
	public Element read(ExpressionReader sr) throws IOException, IllegalExpressionException {
		int index = sr.getCurrentIndex();
		StringBuffer sb = new StringBuffer();
		int b = -1;
		while ((b = sr.read()) != -1) {
			char c = (char)b;
			if (NUMBER_CHARS.indexOf(c) == -1) {
				if (LONG_MARKS.indexOf(c) >= 0) {
					if (sb.indexOf(".") >= 0) {//Have the decimal point 
						throw new IllegalExpressionException("long类型不能有小数点",sr.getCurrentIndex());
					}
					return new Element(sb.toString(), index, ElementType.LONG);
				} else if (FLOAT_MARKS.indexOf(c) >= 0) {
					checkDecimal(sb,sr);
					return new Element(sb.toString(), index, ElementType.FLOAT);
				} else if (DOUBLE_MARKS.indexOf(c) >= 0) {
					checkDecimal(sb,sr);
					return new Element(sb.toString(), index, ElementType.DOUBLE);
				} else {
					sr.reset();
					if (sb.indexOf(".") >= 0) {//No end logo, have a decimal amount, for double 
						checkDecimal(sb,sr);
						return new Element(sb.toString(), index, ElementType.DOUBLE);
					} else {//No sign, no decimal point, the end for int 
						return new Element(sb.toString(), index, ElementType.INT);
					}
				}
			}
			sb.append(c);
			sr.mark(0);
		}
		//Read to the end 
		if (sb.indexOf(".") >= 0) {//No end logo, have a decimal amount, for double 
			checkDecimal(sb,sr);
			return new Element(sb.toString(), index, ElementType.DOUBLE);
		} else {//No sign, no decimal point, the end for int 
			return new Element(sb.toString(), index, ElementType.INT);
		}
	}
	
	/**
	 * Check whether only a decimal point 
	 * @param sb
	 * @throws FormatException
	 */
	public static void checkDecimal(StringBuffer sb,ExpressionReader sr) throws IllegalExpressionException {
		if (sb.indexOf(".") != sb.lastIndexOf(".")) {
			throw new IllegalExpressionException("数字最多只能有一个小数点",sr.getCurrentIndex());
		}
	}
}
