package com.arthur.jmockit;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Test;


import static org.junit.Assert.*;


public class TargetCodeTest {


    @Tested
    TargetCode target;




    @Test
    public void testMatchOnMockInstance(@Mocked Dependency d1, @Mocked Dependency d2){


       new Expectations(){{

           d1.doSomeThing(); result = 100;

       }};

        int value1 = d1.doSomeThing();
        assertEquals(100, value1);

       int value2 =  target.doSomeThing();

        assertEquals(0, value2);



    }
}