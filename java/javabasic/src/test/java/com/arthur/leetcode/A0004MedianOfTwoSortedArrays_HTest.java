package com.arthur.leetcode;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
//import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


//@RunWith(SpringRunner.class)
@RunWith(value= Parameterized.class)
public class A0004MedianOfTwoSortedArrays_HTest {

    A0004MedianOfTwoSortedArrays_H test;
    int[] nums1, nums2;
    double expected, result;


    @Before
    public void setUp() throws Exception {
        test = new A0004MedianOfTwoSortedArrays_H();

    }

    @After
    public void tearDown() throws Exception {
    }


    public A0004MedianOfTwoSortedArrays_HTest(int[] nums1, int[] nums2, double expected){
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> buildTestCases() {
        List<Object[]> testCases = new ArrayList<>();
        testCases.add(new Object[]{new int[]{1,3}, new int[]{2}, 2.0d});
        testCases.add(new Object[]{new int[]{1,2}, new int[]{3,4}, 2.5d});
        testCases.add(new Object[]{new int[]{1,1,3,3}, new int[]{1,1,3,3}, 2.0d});
        testCases.add(new Object[]{new int[]{100001}, new int[]{100000}, 100000.5d});
        testCases.add(new Object[]{new int[]{4}, new int[]{1,2,3,5}, 3.0d});

        testCases.add(new Object[]{new int[]{10,30,50,70,90}, new int[]{20,40}, 40.0d});
        testCases.add(new Object[]{new int[]{10,30,50,70,90}, new int[]{20,40,50}, 45.0d});
        testCases.add(new Object[]{new int[]{0,2,4,6,8}, new int[]{1,3,5,7,9}, 4.5d});
        testCases.add(new Object[]{new int[]{0,2,4,6,8}, new int[]{1,3,5,7}, 4.0d});
        testCases.add(new Object[]{new int[]{0,2,4,6,8}, new int[]{1,3}, 3.0d});
        return testCases;
    }


    @Test
    public void findMedianSortedArrays() {
        result = test.findMedianSortedArrays(nums1,nums2);
        assertThat(result).isEqualTo(expected);
        result = test.findMedianSortedArrays(nums2,nums1);
        assertThat(result).isEqualTo(expected);
    }
}