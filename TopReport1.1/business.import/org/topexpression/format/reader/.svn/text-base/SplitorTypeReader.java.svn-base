
package org.topexpression.format.reader;

import java.io.IOException;

import org.topexpression.IllegalExpressionException;
import org.topexpression.format.Element;
import org.topexpression.format.ExpressionReader;
import org.topexpression.format.Element.ElementType;


/**
 * Read separator type 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class SplitorTypeReader implements ElementReader {

	public static final String SPLITOR_CHAR ="(),";//All separator 
	
	/**
	 * From flow reads separator types of ExpressionToken 
	 * @param sr
	 * @return
	 * @throws FormatException Not a legal separator type thrown when 
	 * @throws IOException
	 */
	public Element read(ExpressionReader sr) throws IllegalExpressionException, IOException {
		int index = sr.getCurrentIndex();
		int b = sr.read();
		char c = (char)b;
		if (b == -1 || SPLITOR_CHAR.indexOf(c) == -1) {
			throw new IllegalExpressionException("不是有效的分割字符",sr.getCurrentIndex());
		}
		return new Element(Character.toString(c), index,
				ElementType.SPLITOR);
	}
}
