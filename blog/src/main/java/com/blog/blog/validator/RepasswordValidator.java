/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.validator;

/**
 *
 * @author petroff
 */
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;

public class RepasswordValidator implements ConstraintValidator<Repassword, Object> {

	private String repass_f;
	private String pass_f;
	private String errorMessagename;

	@Override
	public void initialize(final Repassword constraintAnnotation) {
		repass_f = constraintAnnotation.repass();
		pass_f = constraintAnnotation.pass();
		errorMessagename = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(final Object value, ConstraintValidatorContext ctx) {
		boolean toReturn = false;

		try {

			final Object repassObj = BeanUtils.getProperty(value, repass_f);
			final Object passObj = BeanUtils.getProperty(value, pass_f);
			toReturn = repassObj == null && passObj == null || repassObj != null && repassObj.equals(passObj);

		} catch (final Exception ignore) {
			return false;
		}

		//If the validation failed
		if (!toReturn) {
			ctx.disableDefaultConstraintViolation();
			//In the initialiaze method you get the errorMessage: constraintAnnotation.message();
			ctx.buildConstraintViolationWithTemplate(errorMessagename).addNode(repass_f).addConstraintViolation();
		}
		return toReturn;
	}
}
