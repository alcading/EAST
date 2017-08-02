
package org.topexpression.format;

import java.io.IOException;
import java.io.StringReader;
import java.nio.CharBuffer;

import org.topexpression.IllegalExpressionException;
import org.topexpression.format.reader.ElementReader;
import org.topexpression.format.reader.ElementReaderFactory;


/**
 * Expression read device 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class ExpressionReader extends StringReader {
	
	private static final String IGNORE_CHAR = " \r\n\t";//Word yuan between ignore character 
	
	private int currentIndex = 0;//The current index 
	
	private int markIndex = 0;//Mark after index 
	
	private boolean prefixBlank = false;//With a read between ElementToken whether have space 
	
	public ExpressionReader(String s) {
		super(s);
	}
	
	 /**
	  * Obtain the current position 
	  * @return
	  */
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	/**
	 * Whether Element before have space 
	 * @return
	 */
	public boolean isPrefixBlank() {
		return prefixBlank;
	}

	public void setPrefixBlank(boolean prefixBlank) {
		this.prefixBlank = prefixBlank;
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		if (c != -1) {
			currentIndex++;
			markIndex++;
		}
		return c;
	}
	
	@Override
	public int read(char[] cbuf) throws IOException {
		int c = super.read(cbuf);
		if (c > 0) {
			currentIndex += c;
			markIndex += c;
		}
		return c;
	}
	
	@Override
	public int read(CharBuffer target) throws IOException {
		int c = super.read(target);
		if (c > 0) {
			currentIndex += c;
			markIndex += c;
		}
		return c;
	}
    
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int c = super.read(cbuf, off, len);
		if (c > 0) {
			currentIndex += c;
			markIndex += c;
		}
		return c;
	}
	
	@Override
	public void reset() throws IOException {
		super.reset();
		currentIndex = currentIndex - markIndex;
	}
	
	@Override
	public void mark(int readAheadLimit) throws IOException {
		super.mark(readAheadLimit);
		markIndex = 0;
	}
	 
	/**
	 * Read ExpressionToken flow form 
	 * @return ExpressionToken
	 * @throws IOException
	 * @throws FormatException
	 * @throws AntipathicException
	 */
	public Element readToken() throws IOException, IllegalExpressionException {
		prefixBlank = false;
		while (true) {
			//Remove Spaces 
			mark(0);//markers 
			int b = read();
			if (b == -1) {
				return null;
			}
			char c = (char)b;
			if (IGNORE_CHAR.indexOf(c) >= 0) {//Remove began Spaces 
				prefixBlank = true;
				continue;
			}
			reset();//reset 
			
			//Construct a word yuan read device 
			ElementReader er = ElementReaderFactory.createElementReader(this);
			
			return er.read(this);
		}
	}
}
