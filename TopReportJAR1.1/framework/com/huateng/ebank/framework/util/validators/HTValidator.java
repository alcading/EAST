package com.huateng.ebank.framework.util.validators;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.FieldChecks;
import org.apache.struts.validator.Resources;
import org.apache.struts.validator.validwhen.ValidWhen;
import org.apache.struts.validator.validwhen.ValidWhenLexer;
import org.apache.struts.validator.validwhen.ValidWhenParser;

import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.framework.session.SessionManager;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * Struts校验器扩展。
 *
 * @author Henry Huang
 */
public class HTValidator extends FieldChecks {

	private static Logger log = Logger.getLogger(HTValidator.class);

	public static boolean validateLength(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		HttpServletRequest request) {
		int length = 0;

		if (isString(bean)) {
			return false;
		} else {
			String stringS[] =field.getVarValue("length").split(",");
			length =
			ValidatorUtils
					.getValueAsString(bean, field.getProperty())
					.trim()
					.length();
			String errorFlag="Y";
			for(int i=0;i<stringS.length;i++){
				int fixLength=Integer.parseInt(stringS[i]);
				if (fixLength == length) {
					errorFlag="N";
					break;
				}
			}
			if(errorFlag.equals("Y")){
				errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
				return false;
			}
		}
			return true;
	}

	public static boolean validateLengthIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateLength(bean, va, field, errors, request);
	}

	public static boolean validateAmount(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		HttpServletRequest request) {

		String value = null;
		if (isString(bean)) {
			value = (String) bean;
		} else {
			value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		}

		if (!GenericValidator.isBlankOrNull(value)) {
			try {
				DataFormat.currencyToDouble(value);
			} catch (Exception e) {
				errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
				return false;
			}
		}else{
			errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
			return false;
		}

		return true;
	}

	public static boolean validateAmountIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateAmount(bean, va, field, errors, request);
	}

	public static boolean validateAmountRange(Object bean,
											 ValidatorAction va, Field field,
											 ActionMessages errors,
											 HttpServletRequest request) {

		String value = null;
		if (isString(bean)) {
			value = (String) bean;
		} else {
			value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		}

		if (!GenericValidator.isBlankOrNull(value)) {
			try {
				double doubleValue = DataFormat.currencyToDouble(value)/100.0; //以元为单位
				double min = Double.parseDouble(field.getVarValue("min"));
				double max = Double.parseDouble(field.getVarValue("max"));

				if (!GenericValidator.isInRange(doubleValue, min, max)) {
					errors.add(field.getKey(), Resources.getActionMessage(request, va, field));

					return false;
				}
			} catch (Exception e) {
				errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
				return false;
			}
		}

		return true;
	}

	public static boolean validateAmountRangeIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateAmountRange(bean, va, field, errors, request);
	}

	public static boolean validateMustLaterThanToday(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		HttpServletRequest request) {

		String today;
		String datePatternStrict;
		String compareTxdate;//N:取系统当前日期 !N:取当前会计日

		if (isString(bean)) {
			return false;
		}

		datePatternStrict = field.getVarValue("datePatternStrict");
		if (null == datePatternStrict || "".equals(datePatternStrict))
			datePatternStrict = "yyyy-MM-dd";
		//log.debug("datePattern is [" + datePatternStrict + "]");

		compareTxdate = DataFormat.trim(field.getVarValue("compareTxdate"));
		if (!compareTxdate.equals("N")) {
			UserSessionInfo userSessionInfo =
				(UserSessionInfo) SessionManager
					.getInstance()
					.getSessionObject(
					request,
					SystemConstant.OUT_USER_SESSION_INFO);
			if (userSessionInfo != null) {
				today = DataFormat.dateToString(userSessionInfo.getTxDate());
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat(datePatternStrict);
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(System.currentTimeMillis());
				today = sdf.format(cal.getTime());
			}

		} else {
			if (null == datePatternStrict || "".equals(datePatternStrict))
				datePatternStrict = "yyyy-MM-dd";
			SimpleDateFormat sdf = new SimpleDateFormat(datePatternStrict);

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(System.currentTimeMillis());
			today = sdf.format(cal.getTime());
		}

		String dt = ValidatorUtils.getValueAsString(bean, field.getProperty()).trim();
		if (null == dt || "".equals(dt)) {
			return true;
		}

		if (today.compareTo(dt) > 0) {
			errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
			return false;
		}

		return true;

	}

	public static boolean validateMustLaterThanTodayIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateMustLaterThanToday(bean, va, field, errors, request);
	}


	public static boolean validateMustEarlierThanToday(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		HttpServletRequest request) {

		String today;
		String datePatternStrict;
		String compareTxdate;//N:取系统当前日期 !N:取当前会计日

		if (isString(bean)) {
			return false;
		}

		datePatternStrict = field.getVarValue("datePatternStrict");
		if (null == datePatternStrict || "".equals(datePatternStrict))
			datePatternStrict = "yyyy-MM-dd";
		//log.debug("datePattern is [" + datePatternStrict + "]");

		compareTxdate = DataFormat.trim(field.getVarValue("compareTxdate"));
		if (!compareTxdate.equals("N")) {
			UserSessionInfo userSessionInfo =
				(UserSessionInfo) SessionManager
					.getInstance()
					.getSessionObject(
					request,
					SystemConstant.OUT_USER_SESSION_INFO);
			if (userSessionInfo != null) {
				today = DataFormat.dateToString(userSessionInfo.getTxDate());
			} else {
				System.out.println("***:" +"null uerssioninfo");
				SimpleDateFormat sdf = new SimpleDateFormat(datePatternStrict);
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(System.currentTimeMillis());
				today = sdf.format(cal.getTime());
			}

		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(datePatternStrict);

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(System.currentTimeMillis());
			today = sdf.format(cal.getTime());
		}

		String dt =
			ValidatorUtils.getValueAsString(bean, field.getProperty()).trim();
		if (null == dt || "".equals(dt)) {
			return true;
		}

		if (today.compareTo(dt) < 0) {
			errors.add(
				field.getKey(),
				Resources.getActionMessage(request, va, field));
			return false;
		}

		return true;
	}

	public static boolean validateMustEarlierThanTodayIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateMustEarlierThanToday(bean, va, field, errors, request);
	}

	public static boolean validateSpace(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		HttpServletRequest request) {

		String value = null;
		if (isString(bean)) {
			value = (String) bean;
		} else {
			value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		}

		if (null == value) {
			return true;
		}

		if (value.indexOf(' ') != -1) {
			errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
			return false;
		} else {
			return true;
		}

	}

	public static boolean validateSpaceIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateSpace(bean, va, field, errors, request);
	}

	public static boolean validateMaxByteLength(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		HttpServletRequest request) {

		String value = null;
		if (isString(bean)) {
			value = (String) bean;
		} else {
			value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		}
		String sMaxLength = field.getVarValue("maxbytelength");

		if (value != null) {
			try {
				int max = Integer.parseInt(sMaxLength);

				int length = value.getBytes("GBK").length;
				log.debug("length of value is " + length);
				if (length > max) {
					errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
					return false;
				}
			} catch (Exception e) {
				errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
				return false;
			}
		}

		return true;
	}

	public static boolean validateMaxByteLengthIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateMaxByteLength(bean, va, field, errors, request);
	}

	public static boolean validateMinByteLength(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		HttpServletRequest request) {

		String value = null;
		if (isString(bean)) {
			value = (String) bean;
		} else {
			value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		}
		String sMinLength = field.getVarValue("minbytelength");

		if (value != null) {
			try {
				int min = Integer.parseInt(sMinLength);

				int length = value.getBytes("GBK").length;
				log.debug("length of value is " + length);
				if (length < min) {
					errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
					return false;
				}
			} catch (Exception e) {
				errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
				return false;
			}
		}

		return true;
	}

	public static boolean validateMinByteLengthIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateMinByteLength(bean, va, field, errors, request);
	}

	final private static boolean checkPrecondition(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		Object form = validator.getParameterValue(Validator.BEAN_PARAM);
		String value = null;
		boolean valid = false;
		int index = -1;

		if (field.isIndexed()) {
			String key = field.getKey();

			final int leftBracket = key.indexOf("[");
			final int rightBracket = key.indexOf("]");

			if ((leftBracket > -1) && (rightBracket > -1)) {
				index =
					Integer.parseInt(key.substring(leftBracket + 1, rightBracket));
			}
		}

		if (isString(bean)) {
			value = (String) bean;
		} else {
			value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		}

		String test = field.getVarValue("precondition");
		if (test == null) {
			return true;
		}

		ValidWhenLexer lexer = new ValidWhenLexer(new StringReader(test));

		ValidWhenParser parser = new ValidWhenParser(lexer);

		parser.setForm(form);
		parser.setIndex(index);
		parser.setValue(value);

		try {
			parser.expression();
			valid = parser.getResult();

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

		if (!valid) {
			return false;
		}

		return true;
	}

	public static boolean validateRequiredIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateRequired(bean, va, field, errors, request);
	}

	public static boolean validateValidWhenIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return ValidWhen.validateValidWhen(bean, va, field, errors, validator, request);
	}

	public static boolean validateMinLengthIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateMinLength(bean, va, field, errors, request);
	}

	public static boolean validateMaxLengthIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateMaxLength(bean, va, field, errors, request);
	}

	public static boolean validateMaskIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {
		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateMask(bean, va, field, errors, request);
	}

	public static Object validateByteIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return Boolean.TRUE;;

		return validateByte(bean, va, field, errors, request);
	}

	public static Object validateShortIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return Boolean.TRUE;;

		return validateShort(bean, va, field, errors, request);
	}

	public static Object validateIntegerIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return Boolean.TRUE;;

		return validateInteger(bean, va, field, errors, request);
	}

	public static Object validateLongIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return Boolean.TRUE;;

		return validateLong(bean, va, field, errors, request);
	}

	public static Object validateFloatIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return Boolean.TRUE;;

		return validateFloat(bean, va, field, errors, request);
	}

	public static Object validateDoubleIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return Boolean.TRUE;;

		return validateDouble(bean, va, field, errors, request);
	}


	public static Object validateDateIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return Boolean.TRUE;

		return validateDate(bean, va, field, errors, request);
	}

	public static boolean validateIntRangeIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateIntRange(bean, va, field, errors, request);
	}

	public static boolean validateFloatRangeIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateFloatRange(bean, va, field, errors, request);
	}

	public static Object validateCreditCardIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return Boolean.TRUE;

		return validateCreditCard(bean, va, field, errors, request);
	}

	public static boolean validateEmailIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateEmail(bean, va, field, errors, request);
	}

	public static boolean validateUrlIf(
		Object bean,
		ValidatorAction va,
		Field field,
		ActionMessages errors,
		Validator validator,
		HttpServletRequest request) {

		if(!checkPrecondition(bean, va, field, errors, validator, request)) return true;

		return validateUrl(bean, va, field, errors, request);
	}


	/**
	 * if(property == compared) return true
	 * else return false
	 * @return
	 */
	public static boolean validateNotEqual(
		   Object bean,
		   ValidatorAction va,
		   Field field,
		   ActionMessages errors,
		   Validator validator,
		   HttpServletRequest request) {

		   String value = null,compared = null;
		   boolean valid = false;

		   if (isString(bean)) {
			   value = (String) bean;
		   } else {
			   value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		   }

		   compared = ValidatorUtils.getValueAsString(bean, field.getVarValue("compared"));
		   if (compared == null) {
			errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
			   return false;
		   }

           if(!value.equals(compared)){
			errors.add(field.getKey(), Resources.getActionMessage(request, va, field));
           	return false;
           }

		   return true;
	   }

}
