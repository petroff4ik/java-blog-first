/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.validator;

/**
 *
 * @author petroff
 */
import com.blog.blog.entity.User;
import com.blog.blog.service.UserService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqValidator implements ConstraintValidator<Uniq, Object> {

	@Autowired
	UserService userService;
	private String uniq_field;
	private String errorMessagename;

	@Override
	public void initialize(final Uniq constraintAnnotation) {
		uniq_field = constraintAnnotation.uniq_field();

		errorMessagename = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(final Object value, ConstraintValidatorContext ctx) {
		boolean toReturn = false;

		try {

			final Object uniqfieldObj = BeanUtils.getProperty(value, uniq_field);
			User u = userService.getByUserName(uniqfieldObj.toString());
			toReturn = uniqfieldObj == null || uniqfieldObj != null && u == null;

		} catch (final Exception ignore) {
			return false;
		}

		//If the validation failed
		if (!toReturn) {
			ctx.disableDefaultConstraintViolation();
			//In the initialiaze method you get the errorMessage: constraintAnnotation.message();
			ctx.buildConstraintViolationWithTemplate(errorMessagename).addNode(uniq_field).addConstraintViolation();
		}
		return toReturn;
	}
}
