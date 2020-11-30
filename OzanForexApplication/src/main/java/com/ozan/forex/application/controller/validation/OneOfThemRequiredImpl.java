package com.ozan.forex.application.controller.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.ozan.forex.application.common.ApplicationConstants;

public class OneOfThemRequiredImpl implements ConstraintValidator<OneOfThemRequired, Object> {
	private String[] dependentFieldNames;

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		for (String dependentFieldName : dependentFieldNames) {
			String[] fieldsPath = dependentFieldName.split(ApplicationConstants.CUSTOM_ANNOTATION_SEPERATOR);
			Object currentFieldValue = value;
			for (int i = 0; i < fieldsPath.length; i++) {
				try {
					if (currentFieldValue != null) {
						currentFieldValue = FieldUtils.readDeclaredField(currentFieldValue, fieldsPath[i], true);
						if (currentFieldValue != null && fieldsPath.length == i + 1) {
							return true;
						}
					}
				} catch (IllegalAccessException e) {
					continue;
				}
			}
		}
		return false;
	}

	@Override
	public void initialize(OneOfThemRequired constraintAnnotation) {
		dependentFieldNames = constraintAnnotation.with();
	}
}
