package org.topexpression;

import org.topexpression.op.Operator;

/**
 * Expression rotative string word yuan handling auxiliary class 
 * This class, considering the performance factors, lyric yuan type, just discern simply, word yuan integrity dependent on RPN has legally calibration 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class ExpressionTokenHelper {

	
	public static boolean isNull(String s){
		return "null".equals(s);
	}
	
	public static boolean isBoolean(String s){
		return  "true".equals(s) || "false".equals(s) ;
	}
	
	/**
	 * Judgment is an integer 
	 * @param s
	 * @return
	 */
	public static  boolean isInteger(String s){
		if(s != null && s.length() > 0){
			if(s.length() == 1){
				return isNumber(s.charAt(0)) && '.' != s.charAt(0);
			}else{
				return (isNumber(s.charAt(0)) && isNumber(s.charAt(s.length() - 1)) && s.indexOf('.') < 0);
			}
		}else {
			return false;
		}	
	}
	
	/**
	 * Judge a man double-precision floating-point Numbers 
	 * @param s
	 * @return
	 */
	public static boolean isDouble(String s){
		if(s != null && s.length() > 1){
			return (isNumber(s.charAt(0)) && isNumber(s.charAt(s.length() - 1)) && s.indexOf('.') >= 0);
		}else {
			return false;
		}			
	}	
	
	/**
	 * Judge a man long integers 
	 * @param s
	 * @return
	 */
	public static boolean isLong(String s){
		if(s != null && s.length() > 1){
			return (isNumber(s.charAt(0)) && s.endsWith("L"));	
		}else {
			return false;
		}			
		
	}	
	
	/**
	 * Judge a man to floating-point number 
	 * @param s
	 * @return
	 */
	public static boolean isFloat(String s){
		if(s != null && s.length() > 1){
			return (isNumber(s.charAt(0)) && s.endsWith("F"));	
		}else {
			return false;
		}
		
	}	
	
	public static boolean isString(String s){
		if(s != null && s.length() > 1){
			return (s.charAt(0) == '"');
		}else {
			return false;
		}		
	
	}
	
	public static boolean isDateTime(String s){
		if(s != null && s.length() > 1){
			return (s.charAt(0) == '[');
		}else {
			return false;
		}
	}	
	
	/**
	 * Whether separator word yuan 
	 * @param s
	 * @return
	 */
	public static boolean isSplitor(String s){
		return ",".equals(s) || "(".equals(s) || ")".equals(s); 
	}
		
	/**
	 * Whether the function word yuan 
	 * @param s
	 * @return
	 */
	public static boolean isFunction(String s){
		if(s != null && s.length() > 1){
			return (s.charAt(0) == '$');
		}else {
			return false;
		}
	}
	
	/**
	 * Whether the operator 
	 * @param s
	 * @return
	 */
	public static boolean isOperator(String s){
		if(s != null){
			try{
				Operator.valueOf(s);
				return true;
			}catch(IllegalArgumentException e){
				return false;
			}
		}else {
			return false;
		}
	}
	
	private static boolean isNumber(char c){
		if((c >= '0' && c <= '9') || c == '.'){
			return true;
		}else{
			return false;
		}
	}

}
