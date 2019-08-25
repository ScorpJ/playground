package com.arthur.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class  BusinessRulesValidator implements ConstraintValidator<BusinessRules, Object> {



    public void initialize(BusinessRules constraintAnnotation) {

    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return false;
    }


}
