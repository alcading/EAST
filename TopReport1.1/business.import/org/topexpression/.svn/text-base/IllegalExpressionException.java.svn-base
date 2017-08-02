
package org.topexpression;

/**
 * Illegal expression abnormalities 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class IllegalExpressionException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -382075370364295450L;
	
	/**
	 * Error identification 
	 */
	private String errorTokenText;
	/**
	 * Error position  
	 */
	private int errorPosition = -1;

	public IllegalExpressionException(){
		super();
	}
	
	public IllegalExpressionException(String msg){
		super(msg);
	}
	
	public IllegalExpressionException(String msg , String errorTokenText ){
		super(msg);
		this.errorTokenText = errorTokenText;
	}
	
	public IllegalExpressionException(String msg , String errorTokenText , int errorPosition){
		super(msg);
		this.errorPosition = errorPosition;
		this.errorTokenText = errorTokenText;
	}	
	
	public IllegalExpressionException(String msg  , int errorPosition){
		super(msg);
		this.errorPosition = errorPosition;
	}	
	
	public String getErrorTokenText() {
		return errorTokenText;
	}
	public void setErrorTokenText(String errorTokenText) {
		this.errorTokenText = errorTokenText;
	}
	public int getErrorPosition() {
		return errorPosition;
	}
	public void setErrorPosition(int errorPosition) {
		this.errorPosition = errorPosition;
	}

	public String toString(){
		StringBuffer sb = new StringBuffer(this.getMessage());
		sb.append("\r\n处理对象：").append(errorTokenText);
		sb.append("\r\n处理位置：").append(errorPosition == -1 ? " unknow " : errorPosition);
		return sb.toString();
	}
}
