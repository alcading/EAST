
package org.topexpression.datameta;

import java.text.ParseException;



/**
 * Basic data to describe object 
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public abstract class BaseDataMeta {
	
	//data types 
	public enum DataType {

		//Null types
		DATATYPE_NULL ,
		//String types
		DATATYPE_STRING ,
		//Boolean types
		DATATYPE_BOOLEAN ,
		//Int types
		DATATYPE_INT ,
		//Long types
		DATATYPE_LONG ,
		//Float types
		DATATYPE_FLOAT ,
		//Double types
		DATATYPE_DOUBLE ,
		//Common object types 
		DATATYPE_OBJECT
		;

	}
	
	//data types
	DataType dataType;
	//value
	Object dataValue;
	//A reference type identifier 
	private boolean isReference;
	
	public BaseDataMeta(DataType dataType , Object dataValue){
		this.dataType = dataType;
		this.dataValue = dataValue; 
		//Type parameters calibration 
		verifyDataMeta();		
		
	}

	public DataType getDataType() {
		if(isReference){
			return this.getReference().getDataType();
		}else{
			return dataType;
		}
	}	
	
	public Object getDataValue() {
		return dataValue;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String getDataValueText() {
		if(dataValue == null){
			return null;
			
		}else{
			return dataValue.toString();
		}
	}
	
	/**
	 * Access Token rotative string type values 
	 * @return
	 */
	public String getStringValue(){
		return getDataValueText();
	}

	
	/**
	 * Access Token int type of value 
	 * @return
	 */
	public Integer getIntegerValue(){
		
		if(DataType.DATATYPE_INT != this.dataType){
			throw new UnsupportedOperationException("当前常量类型不支持此操作");
		}
		return (Integer)dataValue;
	}
	
	/**
	 * Access Token boolean type of value 
	 * @return
	 */
	public Boolean getBooleanValue(){
		if(DataType.DATATYPE_BOOLEAN != this.dataType){
			throw new UnsupportedOperationException("当前常量类型不支持此操作");
		}		
		return (Boolean)dataValue;
	}
	
	/**
	 * Access Token long type of value 
	 * @return
	 */
	public Long getLongValue(){
		
		if(DataType.DATATYPE_INT != this.dataType 
				&& DataType.DATATYPE_LONG != this.dataType){
			throw new UnsupportedOperationException("当前常量类型不支持此操作");
		}
		if(dataValue == null){
			return null;
		}
		return Long.valueOf(dataValue.toString());
	}
	
	/**
	 * Access Token float type of value 
	 * @return
	 */
	public Float getFloatValue(){
		
		if(DataType.DATATYPE_INT != this.dataType 
				&& DataType.DATATYPE_FLOAT != this.dataType
				&& DataType.DATATYPE_LONG != this.dataType){
			throw new UnsupportedOperationException("当前常量类型不支持此操作");
		}
		if(dataValue == null){
			return null;
		}
		return Float.valueOf(dataValue.toString());
	}
	
	/**
	 * Access Token of double type values
	 * @return
	 */
	public Double getDoubleValue(){		
		if(DataType.DATATYPE_INT != this.dataType 
				&& DataType.DATATYPE_LONG != this.dataType
				&& DataType.DATATYPE_FLOAT != this.dataType
				&& DataType.DATATYPE_DOUBLE != this.dataType){
			throw new UnsupportedOperationException("当前常量类型不支持此操作");
		}
		if(dataValue == null){
			return null;
		}
		return Double.valueOf(dataValue.toString());
	}
	
	
	
	
	/**
	 * Access Token reference object 
	 * @return
	 */
	public Reference getReference() {
		if(!this.isReference){
			throw new UnsupportedOperationException("当前常量类型不支持此操作");
		}
		return (Reference)dataValue;
	}
			
	
	@Override
	public boolean equals(Object o){
		
		if( o == this ){
			return true;
			
		}else if(o instanceof BaseDataMeta){
			
			BaseDataMeta bdo = (BaseDataMeta)o;
			if(this.isReference() && bdo.isReference){
				return this.getReference() == bdo.getReference();
			}
			
			if(bdo.dataType == dataType){
				if(bdo.dataValue != null 
						&& bdo.dataValue.equals(dataValue)){
					return true;
				}else if(bdo.dataValue == null 
						&& dataValue == null){
					return true;
				}else{
					return false;
				}				
			}else{
				return false;
			}
			
		}else{
			return false;
		}
	}
	
	/**
	 * Calibration data types and worth legitimacy
	 */
	protected void verifyDataMeta(){
		if(dataType != null && dataValue !=null){
			if(DataType.DATATYPE_NULL == dataType && dataValue != null){
				throw new IllegalArgumentException("数据类型不匹配; 类型：" + dataType + ",值不为空");
				
			}else if(DataType.DATATYPE_DOUBLE == dataType){
				try {
					getDoubleValue();
				} catch (UnsupportedOperationException e) {
					throw new IllegalArgumentException("数据类型不匹配; 类型：" + dataType + ",值:" + dataValue);
				}

			}else if(DataType.DATATYPE_FLOAT == dataType){
				try {
					getFloatValue();
				} catch (UnsupportedOperationException e) {
					throw new IllegalArgumentException("数据类型不匹配; 类型：" + dataType + ",值:" + dataValue);
				}
				
			}else if(DataType.DATATYPE_INT == dataType){
				try {
					getIntegerValue();
				} catch (UnsupportedOperationException e) {
					throw new IllegalArgumentException("数据类型不匹配; 类型：" + dataType + ",值:" + dataValue);
				}
				
			}else if(DataType.DATATYPE_LONG == dataType){
				try {
					getLongValue();
				} catch (UnsupportedOperationException e) {
					throw new IllegalArgumentException("数据类型不匹配; 类型：" + dataType + ",值:" + dataValue);
				}

			}else if(DataType.DATATYPE_STRING == dataType){
				try {
					getStringValue();
				} catch (UnsupportedOperationException e) {
					throw new IllegalArgumentException("数据类型不匹配; 类型：" + dataType + ",值:" + dataValue);
				}
				
			}else if(this.isReference){
				try {
					getReference();
				} catch (UnsupportedOperationException e) {
					throw new IllegalArgumentException("数据类型不匹配; 类型：" + dataType + ",值:" + dataValue);
				}

			}else if(DataType.DATATYPE_OBJECT == dataType){
				try {
					getDataValue();
				} catch (UnsupportedOperationException e) {
					throw new IllegalArgumentException("数据类型不匹配; 类型：" + dataType + ",值:" + dataValue);
				}

			}
		}
	}
	
	
	/**
	 * Convert Java objects
	 * @return
	 */
	public Class<?> mapTypeToJavaClass(){
		
		if(BaseDataMeta.DataType.DATATYPE_DOUBLE == this.getDataType()){
			return double.class;
			
		}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == this.getDataType()){
			return float.class;
			
		}else if(BaseDataMeta.DataType.DATATYPE_INT == this.getDataType()){
			return int.class;
			
		}else if(BaseDataMeta.DataType.DATATYPE_LONG == this.getDataType()){
			return long.class;
			
		}else if(BaseDataMeta.DataType.DATATYPE_STRING == this.getDataType()){
			return String.class;
			
		}else if(BaseDataMeta.DataType.DATATYPE_OBJECT == this.getDataType()){
			return Object.class;
			
		}else if(BaseDataMeta.DataType.DATATYPE_NULL == this.getDataType()){
			return null;
			
		}
		throw new RuntimeException("映射Java类型失败：无法识别的数据类型");
	}
	
	/**
	 * Check data types of compatibility 
	 * Same as the type must be compatible 
	 * Type is different, compatible data types including int ，long ，float ， double
	 * null Type and all types of compatible 
	 * @param another
	 * @return
	 */
	private boolean isCompatibleType(BaseDataMeta another){
		
		if(DataType.DATATYPE_NULL == this.getDataType() 
				|| DataType.DATATYPE_NULL == another.getDataType()){
			return true;
			
		}else if(this.getDataType() == another.getDataType()){
			return true;
			
		}else if(DataType.DATATYPE_INT != this.getDataType() 
				&& DataType.DATATYPE_LONG != this.getDataType()
				&& DataType.DATATYPE_FLOAT != this.getDataType()
				&& DataType.DATATYPE_DOUBLE != this.getDataType()){
			return false;
			
		}else if(DataType.DATATYPE_INT != another.getDataType() 
				&& DataType.DATATYPE_LONG != another.getDataType()
				&& DataType.DATATYPE_FLOAT != another.getDataType()
				&& DataType.DATATYPE_DOUBLE != another.getDataType()){
			return false;
			
		}else{
			return true;
		}
	}
	
	/**
	 * Obtain two Numbers of compatible type 
	 * If two data type can't compatible, returns null
	 * @param another
	 * @return
	 */
	public DataType getCompatibleType(BaseDataMeta another){
		
		if(isCompatibleType(another)){
			if(DataType.DATATYPE_NULL == this.getDataType()){
				return another.getDataType();
				
			}else if(DataType.DATATYPE_NULL == another.getDataType()){
				return this.getDataType();
				
			}else if(this.getDataType() == another.getDataType()){
				return this.getDataType();
				
			}else if(DataType.DATATYPE_DOUBLE == this.getDataType() 
						|| DataType.DATATYPE_DOUBLE == another.getDataType()){
				return DataType.DATATYPE_DOUBLE;
				
			}else if(DataType.DATATYPE_FLOAT == this.getDataType() 
					|| DataType.DATATYPE_FLOAT == another.getDataType()){
				return DataType.DATATYPE_FLOAT;
				
			}else if(DataType.DATATYPE_LONG == this.getDataType() 
					|| DataType.DATATYPE_LONG == another.getDataType()){
				return DataType.DATATYPE_LONG;
				
			}else{
				return DataType.DATATYPE_INT;
			}
		}else{
			return null;
		}
	}
	
	/**
	 * @throws ParseException
	 * 
	 */
	public Object toJavaObject() throws ParseException{
		if(null == this.dataValue){
			return null;
		}
		
		if(BaseDataMeta.DataType.DATATYPE_BOOLEAN == this.getDataType()){
			return getBooleanValue();
			
		}else if(BaseDataMeta.DataType.DATATYPE_DOUBLE == this.getDataType()){
			return getDoubleValue();
			
		}else if(BaseDataMeta.DataType.DATATYPE_FLOAT == this.getDataType()){
			return getFloatValue();
			
		}else if(BaseDataMeta.DataType.DATATYPE_INT == this.getDataType()){
			return getIntegerValue();
			
		}else if(BaseDataMeta.DataType.DATATYPE_LONG == this.getDataType()){
			return getLongValue();
			
		}else if(BaseDataMeta.DataType.DATATYPE_STRING == this.getDataType()){
			return getStringValue();
			
		}else if(BaseDataMeta.DataType.DATATYPE_OBJECT == this.getDataType()){			
			return getDataValue();

		}else {
			throw new RuntimeException("映射Java类型失败：无法识别的数据类型");
		}	
	}

	public boolean isReference() {
		return isReference;
	}

	void setReference(boolean isReference) {
		this.isReference = isReference;
	}	
	
}
