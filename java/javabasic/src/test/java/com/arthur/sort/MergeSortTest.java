package com.arthur.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
public class MergeSortTest {

    MergeSort test;

    @Before
    public void setUp() throws Exception {
        test = new MergeSort();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void mergeSort() {

        int[] src = {1, 4, 9, 7, 0};
        test.mergeSort(src);
        assertThat(src).containsSubsequence(0,1,4,7,9);

        src = new int[]{1, 3, 5, 7, 9, 11};
        test.mergeSort(src);
        assertThat(src).containsSubsequence(1,3,5,7,9,11);


        src = new int[]{9,7,5,3,1};
        test.mergeSort(src);
        assertThat(src).containsSubsequence(1,3,5,7,9);


        src = new int[]{1,4,1,6,5,7,3};
        test.mergeSort(src);
        assertThat(src).containsSubsequence(1,1,3,4,5,6,7);
    }
}