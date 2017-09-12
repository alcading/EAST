package com.huateng.service.message;

import java.beans.PropertyDescriptor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;

import com.huateng.exception.AppException;
import com.huateng.service.message.base.IStrutBuffer;

public class BufferImpl extends Buffer {

	@Override
	public void loadObject(Object obj) throws AppException {
		if (obj instanceof Map) {
			super.loadObject(obj);
		} else {
			PropertyUtilsBean pub = new PropertyUtilsBean();
			PropertyDescriptor descriptors[] = pub.getPropertyDescriptors(obj);
			String key;
			Object sub = null;
			IStrutBuffer subBuf;
			for (int i = 0; i < descriptors.length; i++) {
				key = descriptors[i].getName();
				if (descriptors[i].getReadMethod() != null) {
					subBuf = getAbstractBufferByID(key);
					if (subBuf == null) {
						logger.warn("Buffer[" + getId() + "]." + sub
								+ " not found in Buffer");
					} else {
						try {
							sub = pub.getNestedProperty(obj, key);
						} catch (Exception e) {
							logger.warn("取值失败", e);
						}
						subBuf.loadObject(sub);
					}
				}
			}
		}

	}
	

	/**
	 * 修改键值为属性ID(原来是XML节点的名称)
	 * @see com.huateng.service.message.Buffer#printObject()
	 */
	public Object printObject() throws AppException {
		Map bufMap = new LinkedHashMap();
		Iterator it = getChildBuffers().keySet().iterator();
		String id;
		IStrutBuffer subBuf;
		Object obj;
		Object bean = getReflectCls();
		while (it.hasNext()) {
			id = (String)it.next();
			subBuf = this.getAbstractBufferByID(id);
			obj = subBuf.printObject();
			bufMap.put(subBuf.getId(), obj);
		}
		
		//TODO
		if (bean != null) {
			try {
				BeanUtils.copyProperties(bean, bufMap);
				return bean;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return bufMap;
	}
	
	/**
	 * 获取反射对象类型
	 * @return
	 */
	private Object getReflectCls() {
		String className = getAnyValue("reflectCls");
		Object bean = null;
		try {
			bean = Class.forName(className).newInstance();
		} catch (Exception e) {
		}
		return bean;
	}
	
	/**
	 * 根据KEY值取BUF,忽略大小写
	 * @see com.huateng.service.message.Buffer#getAbstractBufferByID(java.lang.String)
	 */
	@Override
	public IStrutBuffer getAbstractBufferByID(String Id) {
		Set keys = getChildBuffers().keySet();
		String key;
		for (Object k : keys) {
			key = (String) k;
			if (key.equalsIgnoreCase(Id)) {
				return super.getAbstractBufferByID(key);
			}
		}
		return null;
	}
}
