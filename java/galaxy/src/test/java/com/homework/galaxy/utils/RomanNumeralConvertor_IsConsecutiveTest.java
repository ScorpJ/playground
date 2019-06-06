package com.homework.galaxy.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(value= Parameterized.class)
public class RomanNumeralConvertor_IsConsecutiveTest {

    private List<Object> inputList;
    private boolean expactedValue;


    public RomanNumeralConvertor_IsConsecutiveTest(List<Object> inputList, boolean expactedValue) {
        this.inputList = inputList;
        this.expactedValue = expactedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestCases()  {

        List<Object[]> paras = new ArrayList<Object[]>();

        paras.add(new Object[]{Arrays.asList("I","I","I","I"), true});
        paras.add(new Object[]{Arrays.asList("I","I","I"), false});
        paras.add(new Object[]{Arrays.asList("X","X","X","X"), true});
        paras.add(new Object[]{Arrays.asList("X","X","X"), false});
        paras.add(new Object[]{Arrays.asList("C","C","C","C"), true});
        paras.add(new Object[]{Arrays.asList("C","C","C"), false});
        paras.add(new Object[]{Arrays.asList("M","M","M","M"), true});
        paras.add(new Object[]{Arrays.asList("M","M","M"), false});
        paras.add(new Object[]{Arrays.asList("X","X","X","I","X"), false});

        paras.add(new Object[]{Arrays.asList("D","D"), true});
        paras.add(new Object[]{Arrays.asList("L","L"), true});
        paras.add(new Object[]{Arrays.asList("V","V"), true});

        paras.add(new Object[]{Arrays.asList("D"), false});
        paras.add(new Object[]{Arrays.asList("L"), false});
        paras.add(new Object[]{Arrays.asList("V"), false});


        paras.add(new Object[]{Arrays.asList("I","I","I","I", 10d), true});
        paras.add(new Object[]{Arrays.asList("I","I","I",10d), false});
        paras.add(new Object[]{Arrays.asList("X","X","X","X", 10d), true});
        paras.add(new Object[]{Arrays.asList("X","X","X",10d), false});
        paras.add(new Object[]{Arrays.asList("C","C","C","C", 10d), true});
        paras.add(new Object[]{Arrays.asList("C","C","C",10d), false});
        paras.add(new Object[]{Arrays.asList("M","M","M","M",10d), true});
        paras.add(new Object[]{Arrays.asList("M","M","M",10d), false});
        paras.add(new Object[]{Arrays.asList("X","X","X","I","X",10d), false});

        paras.add(new Object[]{Arrays.asList("D","D",10d), true});
        paras.add(new Object[]{Arrays.asList("L","L",10d), true});
        paras.add(new Object[]{Arrays.asList("V","V",10d), true});

        paras.add(new Object[]{Arrays.asList("D",10d), false});
        paras.add(new Object[]{Arrays.asList("L",10d), false});
        paras.add(new Object[]{Arrays.asList("V",10d), false});




        return paras;
    }

    @Test
    public void isConsecutive() {
        boolean isConsecutive = RomanNumeralConvertor.isConsecutive(this.inputList);
        assertEquals(this.expactedValue,isConsecutive);
    }
}