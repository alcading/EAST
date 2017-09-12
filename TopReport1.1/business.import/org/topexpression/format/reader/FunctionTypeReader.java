
package org.topexpression.format.reader;

import java.io.IOException;

import org.topexpression.IllegalExpressionException;
import org.topexpression.format.Element;
import org.topexpression.format.ExpressionReader;
import org.topexpression.format.Element.ElementType;


/**
 * Read function.each 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class FunctionTypeReader implements ElementReader {
	public static final char END_MARK = '(';//Function over 
	
	/**
	 * From flow reads function.each ExpressionToken 
	 * @param sr
	 * @return
	 * @throws FormatException
	 * @throws IOException
	 * @throws IllegalExpressionException 
	 */
	public Element read(ExpressionReader sr) throws IOException, IllegalExpressionException {
		int index = sr.getCurrentIndex();
		StringBuffer sb = new StringBuffer();
		int b=-1;
		boolean readStart = true;
		while ((b = sr.read()) != -1) {
			char c = (char)b;
			if (c == FunctionTypeReader.END_MARK) {
				if (sb.length() == 0) {
					throw new IllegalExpressionException("函数名称不能为空",sr.getCurrentIndex());
				}
				sr.reset();
				return new Element(sb.toString(), index, ElementType.FUNCTION);
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
		throw new IllegalExpressionException("不是有效的函数结束",sr.getCurrentIndex());
	}
}
