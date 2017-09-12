
package org.topexpression.datameta;

/**
 * Expression context variable 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class Variable extends BaseDataMeta{

	//Variable names
	String variableName;
	
	/**
	 * According to the alias and parameter values, the tectonic Variable examples 
	 * @param variableName
	 * @param variableValue
	 * @return Variable
	 */
	public static Variable createVariable(String variableName , Object variableValue){

		if(variableValue instanceof Double){
			return new Variable(variableName , DataType.DATATYPE_DOUBLE , variableValue);
						
		}else if(variableValue instanceof Float){
			return new Variable(variableName , DataType.DATATYPE_FLOAT , variableValue);
						
		}else if(variableValue instanceof Integer){
			return new Variable(variableName , DataType.DATATYPE_INT , variableValue);
						
		}else if(variableValue instanceof Long){
			return new Variable(variableName , DataType.DATATYPE_LONG , variableValue);
						
		}else if(variableValue instanceof String){
			return new Variable(variableName , DataType.DATATYPE_STRING , variableValue);
						
		}else if(variableValue instanceof Object){
			return new Variable(variableName , DataType.DATATYPE_OBJECT , variableValue);
			
		}else if(variableValue == null){
			return new Variable(variableName , DataType.DATATYPE_NULL , variableValue);
			
		}else {
			throw new IllegalArgumentException("非法参数：无法识别的变量类型");
		}

	}	

	public Variable(String variableName){
		this(variableName , null , null);	
	}
	
	public Variable(String variableName , DataType variableDataType , Object variableValue){
		super(variableDataType , variableValue);

		if(variableName == null){
			throw new IllegalArgumentException("非法参数：变量名为空");
		}
		
		this.variableName = variableName ;
	}

	public String getVariableName() {
		return variableName;
	}


	public void setVariableValue(Object variableValue) {
		this.dataValue = variableValue;
		//Type parameters calibration 
		verifyDataMeta();
	}
	
	public void setDataType(DataType dataType){
		this.dataType = dataType;
		//Type parameters calibration 
		verifyDataMeta();
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this){
			return true;
			
		}else if(o instanceof Variable 
				&& super.equals(o)){
			
			Variable var = (Variable)o;
			if(variableName != null 
					&& variableName.equals(var.variableName)){
				return true;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
	}

}
