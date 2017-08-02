
package org.topexpression.format.reader;

import java.io.IOException;

import org.topexpression.IllegalExpressionException;
import org.topexpression.format.ExpressionReader;


/**
 * Word yuan read device factory 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class ElementReaderFactory {
	
	/**
	 * According to flow beginning texturally different words yuan read 
	 * Flow should not Spaces beginning 
	 * @param reader
	 * @return ElementReader
	 * @throws IOException
	 * @throws FormatException
	 * @throws IllegalExpressionException 
	 */
	public static ElementReader createElementReader(ExpressionReader reader) throws IOException, IllegalExpressionException {
		//读一个char
		reader.mark(0);
		int b = reader.read();
		reader.reset();
		if (b != -1) {
			char c = (char)b;
			try{	
				if (c == StringTypeReader.START_MARK) {//"Beginning, tectonic string read device 
					return StringTypeReader.class.newInstance();
				} else if (SplitorTypeReader.SPLITOR_CHAR.indexOf(c) >= 0) {//If is separators, tectonic separator read device  
					return SplitorTypeReader.class.newInstance();
				} else if (NumberTypeReader.NUMBER_CHARS.indexOf(c) >= 0) {//In digital beginning, tectonic numeric types read device 
					return NumberTypeReader.class.newInstance();
				} else if (OperatorTypeReader.isOperatorStart(reader)) {//If the prefix is operator, the tectonic operators read device 
					return OperatorTypeReader.class.newInstance();
				} else {
					return valInstance(reader);
				}
			} catch (Exception e) {
				throw new IllegalExpressionException(e.getMessage(),reader.getCurrentIndex());
			}
			
		} else {
			throw new IllegalExpressionException("流已结束",reader.getCurrentIndex());
		}
	}
	
	public static ElementReader valInstance(ExpressionReader reader) throws IOException, InstantiationException, IllegalAccessException{
		int b=-1;
		reader.mark(0);
		while ((b = reader.read()) != -1) {
			char c = (char)b;
			if (c == FunctionTypeReader.END_MARK) {
				reader.reset();
				return FunctionTypeReader.class.newInstance();
			}else if(VariableTypeReader.STOP_CHAR.indexOf(c) >= 0 || b==-1){
				reader.reset();
				return VariableTypeReader.class.newInstance();
			}
		}
		reader.reset();
		return VariableTypeReader.class.newInstance();
	}
}
