package com.arthur.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class  BusinessRulesValidator implements ConstraintValidator<BusinessRules, Object> {

    private ExpressionParser parser = new SpelExpressionParser();
    private BusinessRule[] rules;

    public void initialize(BusinessRules constraintAnnotation) {
       this.rules = constraintAnnotation.rules();
       if(rules == null || rules.length <= 0 ){
           throw new IllegalArgumentException("rules is required in @BusinessRules");
       }
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        List<ConstraintValidator<BusinessRule, Object>> validatorList =
                Arrays.stream(rules)
                        .filter(rule -> {
                            String onPredicate = rule.onCondition();
                            if(StringUtils.isBlank(onPredicate)){
                                return true;
                            }
                            return parser.parseExpression(onPredicate).getValue(value,Boolean.class);
                        })
                        .map(e -> {
                            switch (e.validateType()){
                                case EXPRESS_PREDICATE:
                                    return new ELParserValidator(e);
                                case METHOD_INVOCATION:
                                    return new ProxyInvocationValidator(e);
                            }
                            return null;
                        })
                      .collect(Collectors.toList());

        List<Boolean> validationResults =
                validatorList.stream()
                              .map(validator -> validator.isValid(value, context))
                              .filter(passed -> !passed)
                              .collect(Collectors.toList());

        return (validationResults.size() == 0);
    }


}
