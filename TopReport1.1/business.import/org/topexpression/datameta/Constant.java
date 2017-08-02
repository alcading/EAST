
package org.topexpression.datameta;


/**
 * Constants data to describe
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 */
public class Constant extends BaseDataMeta {
	
	public Constant(DataType dataType , Object value){
		super(dataType , value);
		
		if(dataType == null){
			throw new IllegalArgumentException("非法参数：数据类型为空");
		}

	}
	
	
	public Constant(Reference ref){
		super(null , ref);
		this.setReference(true);
	}
}
