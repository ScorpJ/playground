package com.homework.galaxy;

import org.junit.Test;

public class IntergalacticConversionMainTest {

    @Test
    public void mainWithPth() {
        String path = IntergalacticConversionMainTest.class.getClassLoader().getResource("SampleInput2.txt").getFile();
        String[] args = {path};
        IntergalacticConversionMain.main(args);
    }



    @Test
    public void mainWithDefaultInput() {
        IntergalacticConversionMain.main(null);
    }
}