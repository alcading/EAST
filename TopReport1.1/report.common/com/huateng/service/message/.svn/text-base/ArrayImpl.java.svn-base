package com.huateng.service.message;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Node;

import com.huateng.exception.AppException;
import com.huateng.service.message.base.IMessage;
import com.huateng.service.message.base.IStrutBuffer;
import com.huateng.util.ContextUtil;

public class ArrayImpl extends Array {
	@Override
	public void loadObject(Object obj) throws AppException {
		if (obj instanceof Collection) {
			Iterator it = ((Collection) obj).iterator();
			Object subBuffObj;
			while (it.hasNext()) {
				subBuffObj = it.next();
				IStrutBuffer array_element = (IStrutBuffer) ContextUtil
						.getContext().getBean(getBuffBean());
				array_element.loadObject(subBuffObj);

				addChildBuffer(array_element);
			}
		} else {
			logger.error("Array.loadObject Error: Object must be Collection");
			throw new AppException("Array[" + getId()
					+ "]　传入Object必须是Collection类型");

		}

	}

	/**
	 * 添加basic属性, 标志循环体的父节点是否输出
	 * 
	 * @see com.huateng.service.message.Array#outputString()
	 */
	@Override
	public String outputString() throws AppException {
		StringBuffer sb = new StringBuffer();
		if (logger.isDebugEnabled()) {
			logger.debug("Array[" + getName() + "] <<");
		}
		if (StringUtils.equalsIgnoreCase(getType(), BUFFER_TYPE_XML)) {
			if (isBasic()) {
				sb.append("<" + getName() + ">");
			}
			Iterator it = getBufferList().iterator();
			IStrutBuffer message;
			while (it.hasNext()) {
				message = (IStrutBuffer) it.next();
				if (message.getParent() == null) {
					message.setParent(this);
				}
				sb.append(message.outputString());
			}
			if (isBasic()) {
				sb.append("</" + getName() + ">");
			}
		} else if (StringUtils.equalsIgnoreCase(getType(), BUFFER_TYPE_STRUCT)) {
			if (isBasic()) {
				sb.append("<" + getName() + ">");
			}
			Iterator it = getBufferList().iterator();
			IMessage message;
			while (it.hasNext()) {
				message = (IMessage) it.next();
				message.setAnyValue("basic", String.valueOf(false));
				sb.append(message.outputString());
			}
			if (isBasic()) {
				sb.append("</" + getName() + ">");
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Array[" + getName() + "] >>");
		}
		return sb.toString();

	}

	/**
	 * 支持LIST
	 * 
	 * @see com.huateng.service.message.Array#init(org.dom4j.Node)
	 */
	@Override
	public void init(Node element) throws AppException {
		if (StringUtils.equalsIgnoreCase(getType(), BUFFER_TYPE_XML)) {
			IStrutBuffer array_element;
			Node node;
			List l = element.selectNodes("*");
			if (l != null) {
				for (int i = 0; i < l.size(); i++) {
					node = (Node) l.get(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						array_element = (IStrutBuffer) ContextUtil.getContext()
								.getBean(getBuffBean());
						if (array_element != null)
							array_element.init(node);
						addChildBuffer(array_element);
					}
				}
			}
		} else if (StringUtils.equalsIgnoreCase(getType(), BUFFER_TYPE_STRUCT)) {
			String str = element.getText();
			init(str);
		}
	}
}
