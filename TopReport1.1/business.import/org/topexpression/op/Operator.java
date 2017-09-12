
package org.topexpression.op;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.topexpression.IllegalExpressionException;
import org.topexpression.datameta.BaseDataMeta;
import org.topexpression.datameta.Constant;
import org.topexpression.op.define.Op_DIV;
import org.topexpression.op.define.Op_MINUS;
import org.topexpression.op.define.Op_MOD;
import org.topexpression.op.define.Op_MUTI;
import org.topexpression.op.define.Op_NG;
import org.topexpression.op.define.Op_PLUS;
/**
 * Expression operator interface 
 * Operator precedence numerical is bigger, the higher priorities 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public enum Operator{
	

	//Take negative 
	NG("-" , 80 , 1),
	//Arithmetic by 
	MUTI("*" , 70 , 2),
	//Arithmetic except 
	DIV("/" , 70 , 2),
	//arithmetic mould 
	MOD("%" , 70, 2),
	//Arithmetic add 
	PLUS("+" , 60 , 2),
	//Arithmetic minus 
	MINUS("-" , 60 , 2)
	;
	
	private static final Set<String> OP_RESERVE_WORD = new HashSet<String>();
	
	static{

		OP_RESERVE_WORD.add(NG.getToken());
		OP_RESERVE_WORD.add(MUTI.getToken());
		OP_RESERVE_WORD.add(DIV.getToken());
		OP_RESERVE_WORD.add(MOD.getToken());
		OP_RESERVE_WORD.add(PLUS.getToken());
		OP_RESERVE_WORD.add(MINUS.getToken());
	}
	
	private static final HashMap<Operator , IOperatorExecution> OP_EXEC_MAP 
					= new HashMap<Operator , IOperatorExecution>();
	
	static{
	
		OP_EXEC_MAP.put(NG, new Op_NG());		
		OP_EXEC_MAP.put(DIV, new Op_DIV());	
		OP_EXEC_MAP.put(MUTI, new Op_MUTI());
		OP_EXEC_MAP.put(MOD, new Op_MOD());

		OP_EXEC_MAP.put(PLUS, new Op_PLUS());
		OP_EXEC_MAP.put(MINUS, new Op_MINUS());
	}
	
	
	
	/**
	 * Judge whether string legal operators 
	 * @param tokenText
	 * @return
	 */
	public static boolean isLegalOperatorToken(String tokenText){
		return OP_RESERVE_WORD.contains(tokenText);
	}
	
	private String token;
	
	private int priority;
	
	private int opType;
	
	Operator(String token , int priority , int opType){
		this.token = token;
		this.priority = priority;
		this.opType = opType;
	}
	
	/**
	 * Obtain operators character says 
	 * For example：+  - equals && ==
	 * @return String Operators of characters form 
	 */
	public String getToken(){
		return this.token;
	}
	/**
	 * Obtain operator precedence 
	 * @return int Operator precedence 
	 */
	public int getPiority(){
		return this.priority;
	}

	/**
	 * Operators type 
	 * @return int Operators type (a few yuan operation) 
	 */
	public int getOpType(){
		return this.opType;
	}
	
	/**
	 * Implement operation, and return the results Token 
	 * @param args Note the parameters from args due order according to the stack LIFO pop-up, so must take number from the tail backwards 
	 * @return Constant Constant type to implement results 
	 */
	public Constant execute(Constant[] args) throws IllegalExpressionException{
		
		IOperatorExecution opExec = OP_EXEC_MAP.get(this);
		if(opExec == null){
			throw new IllegalExpressionException("系统内部错误：找不到操作符对应的执行定义");
		}
		return opExec.execute(args);
	}
	
	public Constant executeExp(Constant[] args) throws IllegalExpressionException{
		
		IOperatorExecution opExec = OP_EXEC_MAP.get(this);
		if(opExec == null){
			throw new IllegalExpressionException("系统内部错误：找不到操作符对应的执行定义");
		}
		return opExec.executeExp(args);
	}
	
	/**
	 * I operators and parameter is legal, is an executable 
	 * If legitimate, return contains implement results of types of Token 
	 * If not lawful, null 
	 * @param opPositin Operator position 
	 * @param args Note the parameters from args due order according to the stack LIFO pop-up, so must take number from the tail backwards 
	 * @return Constant Constant type to implement results 
	 */
	public Constant verify(int opPositin , BaseDataMeta[] args)throws IllegalExpressionException{
		
		IOperatorExecution opExec = OP_EXEC_MAP.get(this);
		if(opExec == null){
			throw new IllegalExpressionException("系统内部错误：找不到操作符对应的执行定义");
		}
		return opExec.verify(opPositin, args);
	}

}
