
package org.topexpression.format;

/**
 * Expression for term 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class Element {
	
	public enum ElementType {
		//Null types
		NULL ,
		//String types
		STRING ,
		//Int types
		INT ,
		BOOLEAN ,
		//Long types
		LONG ,
		//Float types
		FLOAT ,
		//Double types
		DOUBLE ,
		//variables
		VARIABLE ,
		//operators 
		OPERATOR ,
		//function 
		FUNCTION ,
		//separator 
		SPLITOR
	}
	
	private String text;
	private ElementType type;//type 
	private int index;//The elements in the expression starting the index number, from 0 counting 
	
	/**
	 * tectonic 
	 * @param text
	 * @param index
	 * @param type
	 */
	public Element(String text, int index, ElementType type) {
		this.text = text;
		this.index = index;
		this.type = type;
	}
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ElementType getType() {
		return type;
	}

	public void setType(ElementType type) {
		this.type = type;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
