package com.arthur.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

public class ProxyInvocationValidator implements ConstraintValidator<BusinessRule, Object>{


    private BusinessRule rule;
    private BeanFactroyProvider beanFactroy;

    public ProxyInvocationValidator(BusinessRule rule){
        this.rule = rule;
        this.beanFactroy = new DefaultBeanFactoryProvider();
    }
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(rule.message())
                .addConstraintViolation();

        String beanName = rule.validateBean();
        String methodName = rule.validateMethod();
        Object validationBean = beanFactroy.getBean(beanName);

        if(validationBean == null){
            throw new RuntimeException("Can not obtain validation bean with name " + beanName);
        }
        try {
            Method validationMethod = validationBean.getClass().getMethod(methodName, o.getClass());
            return (boolean)validationMethod.invoke(validationBean, o);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Can not obtain validation bean with name " + beanName, e);
        }  catch (Exception e) {
            throw new RuntimeException("Can not do validation.", e);
        }
    }


}
