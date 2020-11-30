package com.ozan.forex.application.controller.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

@Documented
@Constraint(validatedBy = {OneOfThemRequiredImpl.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@ReportAsSingleViolation
public @interface OneOfThemRequired {
	
	String[] with();
	
	String message() default "Value is not valid";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
