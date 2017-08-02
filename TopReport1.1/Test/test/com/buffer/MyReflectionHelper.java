package test.com.buffer;

import java.lang.reflect.Field;

/**
 * 自定义的反射工具封装类 cn.iamsese.prj.db.helper 
 * Author: vb2005xu [JAVA菜鸟]
 */
public class MyReflectionHelper {

	/**
	 * 返回指定对象的类全称[包括包名]
	 * 支持传入这样的参数: JDKLoggerHelper.class
	 * @param o
	 * @return className
	 */
	public static String getClassName(Object o) {
		if (o == null)
			throw new NullPointerException("传入的对象为null " + o);
		String className = o.getClass().getName();
		return className;
	}
	

	/* -------- 与 类属性相关的[现在定义的方法只能输出类自身的属性,不包括继承来的属性] --------- **/	
	
	/**
	 * 返回指定对象的的指定字段
	 * 
	 * @param owner
	 * @param fieldName
	 * @return Field
	 */
	public static Field getField(Object owner, String fieldName) {
		Field f = null;
		try {
			f = owner.getClass().getDeclaredField(fieldName);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return f;
	}

	/**
	 * 设置指定对象的指定字段的值
	 * @param owner
	 * @param tf
	 * @param value
	 */
	public static void setField(Object owner, Field tf, Object value) {
		try {
			tf.set(owner, value);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置指定对象的指定字段的值
	 * @param owner
	 * @param fieldName
	 * @param value
	 */
	public static void setField(Object owner, String fieldName, Object value) {
		Field f = getField(owner, fieldName);
		setField(owner, f, value);// 调用上边的那个此函数的另一种多态形式
	}
	
	/**
	 * 返回指定对象的指定字段的值
	 * @param owner
	 * @param tf
	 * @return Object
	 */
	public static Object getFieldValue(Object owner, Field tf) {
		Object v = null;
		try {
			v = tf.get(owner);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return v;
	}
	/**
	 * 返回指定对象的指定字段的值
	 * @param owner
	 * @param fieldName
	 * @return Object
	 */
	public static Object getFieldValue(Object owner, String fieldName) {
		Field f = getField(owner, fieldName);
		return getFieldValue(owner, f);// 调用上边的那个此函数的另一种多态形式
	}
	
	/**
	 * 命令行输出指定对象,指定属性的值
	 * @param owner
	 * @param f
	 */
	public static void printFieldValue(Object owner, Field f) {
		System.out.println(getFieldValue(owner, f));
	}
	/**
	 * 命令行输出指定对象,指定属性的值
	 * @param owner
	 * @param fieldName
	 */
	public static void printFieldValue(Object owner, String fieldName) {
		System.out.println(getFieldValue(owner, fieldName));
	}
	
	public static void printFieldInfo(Object owner, Field f) {
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("**当前字段信息 [开始]**\n");
		sbuf.append("Field name: " + f.getName());
		sbuf.append("\n");
		sbuf.append("Field type: " + f.getType().getName());
		sbuf.append("\n");
		sbuf.append("Field value: " + getFieldValue(owner, f));
		sbuf.append("\n");
		sbuf.append("**当前字段信息 [结束]**\n");

		System.out.println(sbuf.toString());
	}

	public static void printFieldInfo(Object owner, String fieldName) {
		Field f = getField(owner, fieldName);
		printFieldInfo(owner, f);
	}

	public static void printObjectFieldsInfo(Object owner) {
		System.out.println("+++++" + owner.getClass().getName() + "++++开始\n");
		Field[] fields = owner.getClass().getDeclaredFields();
		for (Field field : fields) {
			printFieldInfo(owner, field);
		}
		System.out.println("+++++" + owner.getClass().getName() + "++++结束");
	}

	public String toString() {
		return "自定义的反射工具封装类";
	}
}
