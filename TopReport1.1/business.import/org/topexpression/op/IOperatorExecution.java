
package org.topexpression.op;

import org.topexpression.IllegalExpressionException;
import org.topexpression.datameta.BaseDataMeta;
import org.topexpression.datameta.Constant;

/**
 * Operator interface implementation 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public interface IOperatorExecution {
	/**
	 * Execute operators operations 
	 * @param args Note the parameters from args due order according to the stack LIFO pop-up, so must take number from the tail backwards 
	 * @return Constant Constant type to implement results 
	 * @throws IllegalExpressionException
	 */
	public Constant execute(Constant[] args) throws IllegalExpressionException;
	
	public Constant executeExp(Constant[] args) throws IllegalExpressionException;
	
	/**
	 * Validation operators parameters are legitimate 
	 * @param opPositin
	 * @param args Note the parameters from args due order according to the stack LIFO pop-up, so must take number from the tail backwards 
	 * @return Constant Constant type to implement results 
	 * @throws IllegalExpressionException
	 */
	public Constant verify(int opPositin , BaseDataMeta[] args) throws IllegalExpressionException;
}
