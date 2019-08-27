package com.arthur.validation;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({  })
@Retention(RUNTIME)
@Documented
public @interface BusinessRule {
    /**
     * Describe the purpose of this rule
     * @return
     */
    String description() default "";

    /**
     * Validate type
     * @return
     */
    ValidateType validateType() default ValidateType.EXPRESS_PREDICATE;

    /**
     * Rule trigger predicate expression
     * @return
     */
    String onCondition() default "";

    /**
     * Predicate used for validate, only effect when type is  ValidateType.EXPRESS_PREDICATE
     * @return
     */
    String predicate() default "";

    /**
     * validateBean and validateMethod are used to indicate
     * @return
     */
    String validateBean() default "";
    String validateMethod() default "";

    String message() default "";


}
