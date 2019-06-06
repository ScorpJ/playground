package com.arthur.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class A0003LongestSubstring_M {


    /**
     * slide window optimized
     *
     * The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps.
     * Instead of using a set to tell if a character exists or not, we could define a mapping of the characters
     * to its index. Then we can skip the characters immediately when we found a repeated character.
     *
     * The reason is that if s[j] have a duplicate in the range [i, j) with index j',
     * we don't need to increase ii little by little. We can skip all the elements in the range [i, j']
     *  ] and let i to be j' + 1 directly.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    /**
     * slide window
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }
        int rt = 0, i = 0, j = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();
        while(i < len && j< len){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                rt = Math.max(rt, j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }



        return rt;
    }


    /**
     *  Runtime: 152 ms, faster than 10.45% of Java online submissions for Longest Substring Without Repeating Characters.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        int len = s.length();

        char c;
        String subStr = s.substring(0,1);
        for(int i = 0; i < len; i++){
            sb.append(s.charAt(i));
            for(int j = i+1; j < len; j++){
                c = s.charAt(j);
                if(sb.toString().contains(String.valueOf(c))){
                    if(subStr.length() < sb.length()){
                        subStr = sb.toString();
                    }
                    sb.setLength(0);
                    break;
                }else{
                    sb.append(c);
                }

                if(j == len - 1){
                    if(subStr.length() < sb.length()){
                        subStr = sb.toString();
                    }
                    sb.setLength(0);
                }
            }
        }


        return subStr.length();
    }

//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        int ans = 0;
//        for (int i = 0; i < n; i++)
//            for (int j = i + 1; j <= n; j++)
//                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
//        return ans;
//    }
//
//    public boolean allUnique(String s, int start, int end) {
//        Set<Character> set = new HashSet<>();
//        for (int i = start; i < end; i++) {
//            Character ch = s.charAt(i);
//            if (set.contains(ch)) return false;
//            set.add(ch);
//        }
//        return true;
//    }


    public static void main(String[] args){

        A0003LongestSubstring_M t = new A0003LongestSubstring_M();

        int rt = t.lengthOfLongestSubstring("");

        System.out.println(rt);
    }







}
