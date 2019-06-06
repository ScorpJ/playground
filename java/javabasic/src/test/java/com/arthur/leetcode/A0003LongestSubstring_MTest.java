package com.arthur.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
public class A0003LongestSubstring_MTest {


    A0003LongestSubstring_M solution;

    @Before
    public void setUp() throws Exception {
        solution = new A0003LongestSubstring_M();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void lengthOfLongestSubstring() {
        int rt;
        rt = solution.lengthOfLongestSubstring("abcabcbb");
        assertThat(rt).isEqualTo(3);

        rt = solution.lengthOfLongestSubstring("bbbbb");
        assertThat(rt).isEqualTo(1);

        rt = solution.lengthOfLongestSubstring("pwwkew");
        assertThat(rt).isEqualTo(3);

    }
}