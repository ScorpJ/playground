package com.arthur.basic.j8f;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
public class JodaTimeAPI {

    @Test
    public void testLocalDate2String(){
        LocalDate date = LocalDate.parse("2019-07-12");
        LocalDate date2 = LocalDate.parse("2019-07-12", DateTimeFormatter.ISO_DATE);

        System.out.println(date.toString());
        System.out.println(date2.toString());
    }


}
