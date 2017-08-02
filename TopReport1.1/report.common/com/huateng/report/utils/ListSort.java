package com.huateng.report.utils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ¶Ôlist½øÐÐÅÅÐò
 *
 * @author NING-PENG
 * @date 2011-6-24
 * @version
 * @modify
 * @Description
 * @param <E>
 */
public class ListSort<E> {


	@SuppressWarnings("unchecked")
	public void Sort(List<E> list, final String method, final String sort) {
		Collections.sort(list, new Comparator() {
			public int compare(Object arg0, Object arg1) {
				int ret = 0;
				try {
					Method m1 = ((E) arg0).getClass().getMethod(method, null);
					Method m2 = ((E) arg1).getClass().getMethod(method, null);
					Object obj1 = m1.invoke(((E) arg0), null);
					Object obj2 = m2.invoke(((E) arg1), null);

					if (obj1 instanceof BigDecimal || obj1 instanceof Double || obj1 instanceof Float || obj1 instanceof Integer) {
						double d1 = Double.valueOf(obj1.toString());
						double d2 = Double.valueOf(obj2.toString());
						if (sort != null && "desc".equalsIgnoreCase(sort)) {// µ¹Ðò
							if (d1>d2) {
								ret = -1;
							}else if (d1<d2) {
								ret = 1;
							}
						} else {
							if (d1>d2) {
								ret = 1;
							}else if (d1<d2) {
								ret = -1;
							}
						}
					}else{
						String s1 = obj1.toString();
						String s2 = obj2.toString();
						if (sort != null && "desc".equalsIgnoreCase(sort)) {// µ¹Ðò
							ret = s2.compareTo(s1);
						} else {
							ret = s1.compareTo(s2);
						}
					}
				} catch (Exception e) {

					e.printStackTrace();
				}
				return ret;
			}
		});
	}
}
