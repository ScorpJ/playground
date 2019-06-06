package com.homework.galaxy.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(value= Parameterized.class)
public class RomanNumeralConvertor_IsSubtractableTest {


    private String left;
    private String right;
    private boolean expectedBoolean;

    public RomanNumeralConvertor_IsSubtractableTest(String from, String to, boolean expectedBoolean) {
        this.left = from;
        this.right = to;
        this.expectedBoolean = expectedBoolean;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestCases() {

        List<Object[]> paras = new ArrayList<Object[]>();


        paras.add(new Object[]{"I","I", false});
        paras.add(new Object[]{"I","V", true});
        paras.add(new Object[]{"I","X", true});
        paras.add(new Object[]{"I","L", false});
        paras.add(new Object[]{"I","C", false});
        paras.add(new Object[]{"I","D", false});
        paras.add(new Object[]{"I","M", false});

        paras.add(new Object[]{"V","I", false});
        paras.add(new Object[]{"V","V", false});
        paras.add(new Object[]{"V","X", false});
        paras.add(new Object[]{"V","L", false});
        paras.add(new Object[]{"V","C", false});
        paras.add(new Object[]{"V","D", false});
        paras.add(new Object[]{"V","M", false});

        paras.add(new Object[]{"X","I", false});
        paras.add(new Object[]{"X","V", false});
        paras.add(new Object[]{"X","X", false});
        paras.add(new Object[]{"X","L", true});
        paras.add(new Object[]{"X","C", true});
        paras.add(new Object[]{"X","D", false});
        paras.add(new Object[]{"X","M", false});

        paras.add(new Object[]{"L","I", false});
        paras.add(new Object[]{"L","V", false});
        paras.add(new Object[]{"L","X", false});
        paras.add(new Object[]{"L","L", false});
        paras.add(new Object[]{"L","C", false});
        paras.add(new Object[]{"L","D", false});
        paras.add(new Object[]{"L","M", false});

        paras.add(new Object[]{"C","I", false});
        paras.add(new Object[]{"C","V", false});
        paras.add(new Object[]{"C","X", false});
        paras.add(new Object[]{"C","L", false});
        paras.add(new Object[]{"C","C", false});
        paras.add(new Object[]{"C","D", true});
        paras.add(new Object[]{"C","M", true});

        paras.add(new Object[]{"D","I", false});
        paras.add(new Object[]{"D","V", false});
        paras.add(new Object[]{"D","X", false});
        paras.add(new Object[]{"D","L", false});
        paras.add(new Object[]{"D","C", false});
        paras.add(new Object[]{"D","D", false});
        paras.add(new Object[]{"D","M", false});

        paras.add(new Object[]{"M","I", false});
        paras.add(new Object[]{"M","V", false});
        paras.add(new Object[]{"M","X", false});
        paras.add(new Object[]{"M","L", false});
        paras.add(new Object[]{"M","C", false});
        paras.add(new Object[]{"M","D", false});
        paras.add(new Object[]{"M","M", false});

//        Only one small-value symbol may be subtracted left any large-value symbol.

        paras.add(new Object[]{"I","I", false});
        paras.add(new Object[]{"V","I", false});
        paras.add(new Object[]{"X","I", false});
        paras.add(new Object[]{"L","I", false});
        paras.add(new Object[]{"C","I", false});
        paras.add(new Object[]{"D","I", false});
        paras.add(new Object[]{"M","I", false});

        paras.add(new Object[]{"V","V", false});
        paras.add(new Object[]{"X","V", false});
        paras.add(new Object[]{"L","V", false});
        paras.add(new Object[]{"C","V", false});
        paras.add(new Object[]{"D","V", false});
        paras.add(new Object[]{"M","V", false});

        paras.add(new Object[]{"X","X", false});
        paras.add(new Object[]{"L","X", false});
        paras.add(new Object[]{"C","X", false});
        paras.add(new Object[]{"D","X", false});
        paras.add(new Object[]{"M","X", false});

        paras.add(new Object[]{"L","L", false});
        paras.add(new Object[]{"C","L", false});
        paras.add(new Object[]{"D","L", false});
        paras.add(new Object[]{"M","L", false});

        paras.add(new Object[]{"C","C", false});
        paras.add(new Object[]{"D","C", false});
        paras.add(new Object[]{"M","C", false});

        paras.add(new Object[]{"D","D", false});
        paras.add(new Object[]{"M","D", false});

        paras.add(new Object[]{"M","M", false});

        return paras;

    }

    @Test
    public void isSubtractive() {
        boolean isSubtractive = RomanNumeralConvertor.isSubtractive(right,left);
        assertEquals(left   +"_"+ right ,this.expectedBoolean,isSubtractive);
    }
}