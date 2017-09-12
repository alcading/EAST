package com.huateng.service.message;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.CommonFunction;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.exception.AppException;

public class FieldImpl extends Field {
	/**
	 * 加载对象
	 * @see com.huateng.service.message.Field#loadObject(java.lang.Object)
	 */
	@Override
	public void loadObject(Object obj) throws AppException {
		 if( obj == null){
			 logger.warn("Field[" + getId() + "]loadObject Object is null");
		 }else{
			 setAnyValue("value", filter(obj.toString()));
		 }
	}
	/**
	 * 控制小数点位数
	 * type:	N
	 * scale:	2
	 * @see com.huateng.service.message.Field#outputString()
	 */
	@Override
	public String outputString() throws AppException {
		String value = StringUtils.defaultString(getValue(),"");
		String prefix = getName();
		if( StringUtils.isEmpty(getStatus()) ||
			StringUtils.equalsIgnoreCase(getStatus(), STATUS_M) ||
			(StringUtils.equalsIgnoreCase(getStatus(), STATUS_O) && !StringUtils.isEmpty(getValue()) )){
			if( StringUtils.isEmpty(getType()) || StringUtils.equalsIgnoreCase(getType(), FIELD_TYPE_STRING )){ //字符串类型

			}else if( StringUtils.equalsIgnoreCase(getType(), FIELD_TYPE_RIGHT_BLANK_STRING ) ){ //右补空字符串类型
				value = CommonFunction.rightPadByte(value,this.getLength(),' ',false);
			}else if( StringUtils.equalsIgnoreCase(getType(), FIELD_TYPE_RIGNT_BLANK_NUMBER_STRING) ){ //右补空数字字符串类型
				value = StringUtils.rightPad(value, getLength(), ' ');
			}else if( StringUtils.equalsIgnoreCase(getType(), FIELD_TYPE_NUMBER) ){ //数字类型
				String scaleStr = this.getAnyValue("scale");
				if(StringUtils.isNotEmpty(scaleStr)) {
					int scale = this.getScale();
					java.text.DecimalFormat df = new java.text.DecimalFormat(
							StringUtils.rightPad("0.", scale + 2, '0'));
					Double d = null;
					try {
						d = Double.parseDouble(value);
					} catch (Exception e) {
						logger.warn("outputstring failed", e);
					}
					value = d == null ? "" : df.format(d);
				}
			}else if( StringUtils.equalsIgnoreCase(getType(), FIELD_TYPE_LEFT_ZERO_NUMBER) ){ //左补零数字类型
				value = StringUtils.leftPad(value, getLength(), '0');
			}else if( StringUtils.equalsIgnoreCase(getType(), FIELD_TYPE_LEFT_ZERO_CURRENCY) ){ //数值类型
				int scale = this.getScale();
				if( StringUtils.isEmpty(value) ){
					value = "0";
				}
				BigDecimal bigDecimal = new  BigDecimal(value);
				BigDecimal tenDecimal = new BigDecimal( Math.pow(10,scale));
				bigDecimal =  bigDecimal.multiply(tenDecimal);
				value = StringUtils.leftPad(String.valueOf(bigDecimal.longValue()), getLength(), '0');
			}else if( StringUtils.equalsIgnoreCase(getType(), FIELD_TYPE_S_LEFT_ZERO_CURRENCY)){//带符号的数值类型(负数需要加符号、正数不用加)
				int scale = this.getScale();
				if( StringUtils.isEmpty(value) ){
					value = "0";
				}
				BigDecimal bigDecimal = new  BigDecimal(value);
				BigDecimal tenDecimal = new BigDecimal( Math.pow(10,scale));
				bigDecimal =  bigDecimal.multiply(tenDecimal);
				long lv = bigDecimal.longValue();
				long lvAbS = Math.abs(lv);
				//value = StringUtils.leftPad(String.valueOf(lvAbS), getLength()-1, '0');
				if(lv>=0){
					value = StringUtils.leftPad(String.valueOf(lvAbS), getLength(), '0');
					//value = "+" + value;
				}else{
					value = StringUtils.leftPad(String.valueOf(lvAbS), getLength()-1, '0');
					value = "-" + value;
				}
			}else{
				logger.error("Field[" + getId() + "] type no support");
			}
			if( value.length() > getLength()){
				logger.error("Field[" + getId() + "] length too long");
				throw new AppException(Module.SYSTEM_MODULE,Rescode.PARSE_BUFFER_ERROR,"Field[" + getId() + "] length too long , " + value.length() + ">" + getLength());
			}
			
			if(this.getParent() != null && StringUtils.equalsIgnoreCase(this.getParent().getType(),BUFFER_TYPE_STRUCT) ) {
				return value;
			}else{
				Object[] it = getProperty().keySet().toArray();
				String propStr = "";
				Object key;
				for( int i=0;i<it.length;i++){
					key = it[i];
					propStr += " " + key.toString() + "=\"" + getProperty().get(key) + "\" ";
				}
				return "<" + prefix + propStr + ">" + StringUtils.defaultString(value,"") + "</" + prefix + ">";
			}
		}
		return "";
	
	}
	
	/**
	 * 将XML保留字符进行替换
	 * <	&lt;
	 * &	&amp;
	 * >	&gt;
	 * "	&quot;
	 * '	&apos;
	 * @param value
	 * @return
	 */
	private String filter(String value) {
		return value.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;");
	}
}
