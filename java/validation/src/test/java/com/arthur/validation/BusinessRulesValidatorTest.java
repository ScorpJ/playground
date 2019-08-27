package com.arthur.validation;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class BusinessRulesValidatorTest {


    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validateCar(){

        Car car = new Car(null, null, 0);

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate( car );

        assertEquals( 1, constraintViolations.size() );
        constraintViolations.forEach(e -> System.out.println(e.getMessage()));
        System.out.println("-------------------");

        car = new Car(null, null, 1);

        constraintViolations = validator.validate( car );

        assertEquals( 2, constraintViolations.size() );
        constraintViolations.forEach(e -> System.out.println(e.getMessage()));
        System.out.println("Done!");
    }
}