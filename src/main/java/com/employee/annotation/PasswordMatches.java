package com.employee.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.employee.validator.PasswordMatchesValidator;

// this annotation checks wether or not password
// and confirmPassword fields are equal
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
public @interface PasswordMatches {
	String message() default "Password and confirmPassword field does not match";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
