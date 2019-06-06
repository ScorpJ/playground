package com.arthur.basic.j8f;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UseOptional {

    List<String> strList;

    @Before
    public void setUp() throws Exception {
        strList = Arrays.asList("abc1", "abc2", "abc3");
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testOf2Create(){
        Optional<String> optVal = Optional.of("value");
        assertThat(optVal.isPresent()).isTrue();
    }

    @Test(expected= NullPointerException.class)
    public void testOf2Create2(){
        Optional<String> optVal = Optional.of(null);
    }

    @Test
    public void testOfNullable(){
        Optional<String> optVal = Optional.ofNullable("value");
        assertThat(optVal.isPresent()).isTrue();
        optVal = Optional.ofNullable(null);
        assertThat(optVal.isPresent()).isFalse();
        assertThat(optVal).isEmpty();
    }

    @Test
    public void testOrElseGetAndOrElse(){
       Optional<String> optVal =  strList.stream().filter(ele -> ele.contains("target")).findAny();
       assertThat(optVal.orElseGet(() -> "Not Found.")).isEqualTo("Not Found.");
       assertThat(optVal.orElse("Not Found2.")).isEqualTo("Not Found2.");
    }


    @Test
    public void testFilter(){

        Optional<String> optVal =  strList.stream().findFirst().filter(ele -> ele.contains("abc"));
        assertThat(optVal.isPresent()).isTrue();
        optVal =  strList.stream().findFirst().filter(ele -> ele.contains("Not Found"));
        assertThat(optVal.isPresent()).isFalse();
    }

    /**
     * The map method of Optional will take care of the Optional object creation.
     */
    @Test
    public void testMap(){
        Optional<Integer> intOpt = strList.stream().filter(ele -> ele.contains("abc"))
                .findFirst().map(str -> str.length());
        assertThat(intOpt.orElse(0)).isEqualTo(4);
    }

    /**
     *  the mapper will take care of the creation of Optional object
     */
    @Test
    public void testFlatMap(){
        Optional<Integer> intOpt = strList.stream().filter(ele -> ele.contains("abc"))
                .findFirst().flatMap(str -> Optional.ofNullable(str.length()));
        assertThat(intOpt.isPresent()).isTrue();
        assertThat(intOpt.orElse(0)).isEqualTo(4);
        Objects.isNull(null);
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testGetEmptyWithException(){
        strList.stream().filter(ele -> ele.contains("5")).findFirst().get();
    }
}
