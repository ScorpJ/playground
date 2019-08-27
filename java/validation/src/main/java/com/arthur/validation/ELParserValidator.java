package com.arthur.validation;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ELParserValidator implements ConstraintValidator<BusinessRule, Object> {

    private ExpressionParser parser = new SpelExpressionParser();
    private BusinessRule rule;

    public ELParserValidator(BusinessRule rule){
        this.rule = rule;
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        boolean passed = parser.parseExpression(rule.predicate()).getValue(o,Boolean.class);
        if(!passed){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(rule.message())
                    .addConstraintViolation();
        }
        return passed;
    }
}
