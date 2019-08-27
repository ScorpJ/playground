package com.arthur.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import com.arthur.validation.BusinessRulesValidator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {BusinessRulesValidator.class})
public @interface BusinessRules {

    String message() default "BusinessRules Failed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    BusinessRule[] rules();
}
