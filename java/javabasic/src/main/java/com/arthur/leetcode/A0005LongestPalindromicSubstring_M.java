package com.arthur.leetcode;


import java.util.*;

/**
 * 最长回文
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * Extend to : Longest common substring & Dynamic Programming
 *
 */
public class A0005LongestPalindromicSubstring_M {


    public String longestPalindrome(String s) {
//        return solution1(s);
        return solution2(s);
//        return solution3(s);
    }

    /**
     *  O(n^2)
     * @param s
     * @return
     */
    String solution4(String s){

        if(s == null){
            return null;
        }
        int len = s.length();
        if(len <= 1){
            return s;
        }

        String longestP = s.substring(0,1);

        for(int i = 0; i < len-1; i++){
            String p1 = expand(s, i, i);
            String p2 = expand(s, i, i+1);

            String tmp = (p1.length() >= p2.length())? p1 : p2;

            longestP = longestP.length() >= tmp.length()? longestP : tmp;
        }

        return longestP;
    }

    private String expand(String s, int c1, int c2){

        int leftBoundry = c1;
        int rightBoundry = c2;

        while(leftBoundry >=0 && rightBoundry <= s.length()-1 && s.charAt(leftBoundry) == s.charAt(rightBoundry)){
            leftBoundry--;
            rightBoundry++;
        }

        return s.substring(leftBoundry+1,rightBoundry);


    }


    /**
     * O(n^2) + space
     * @param s
     * @return
     */
    String solution2(String s){

        if(s == null){
            return null;
        }

        if(s.length() <= 1){
            return s;
        }

        Map<Character, List<Integer>> charIdxMap = new HashMap<>();
        List<List<Integer>> pairList = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            List<Integer> idxList = charIdxMap.get(s.charAt(i));
            if(idxList == null){
                idxList = new ArrayList<>();
                charIdxMap.put(s.charAt(i), idxList);
            }

            if(idxList.size() > 0){
                for(int j=0;j<idxList.size();j++){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(idxList.get(j));
                    pair.add(i);
                    pairList.add(pair);
                }
            }

            idxList.add(i);
        }

        if(charIdxMap.size() == 1){
            return s;
        }

        Collections.sort(pairList, (o1, o2) -> {
                 int len1,len2;
                 len1 = o1.get(1) - o1.get(0) + 1;
                 len2 = o2.get(1) - o2.get(0) + 1;
                return len2 - len1;
        });

        String rt = null;
        StringBuilder sb = new StringBuilder();

        for(List<Integer> pair: pairList){
            sb.setLength(0);
            sb.append(s.substring(pair.get(0),pair.get(1)+1));
            if(sb.toString().equals(sb.reverse().toString())){
                rt = sb.toString();
                break;
            }

        }

        return rt == null? s.substring(0,1) : rt;
    }

    /**
     * O(n^3)
     * @param s
     * @return
     */
    String solution1(String s){

        if(s == null){
            return null;
        }

        if(s.length() <= 1){
            return s;
        }

        int i=0;
        int j=0;
        int maxLen = -1;
        String rt = null;
        StringBuilder sb = new StringBuilder();

        for(i=0;i<s.length();i++){
            for(j=i+1;j<=s.length();j++){
                sb.setLength(0);
                sb.append(s.substring(i,j));
                if(sb.toString().equals(sb.reverse().toString()) && sb.toString().length() > maxLen){
                    rt = sb.toString();
                    maxLen = rt.length();
                }
            }
        }
        return rt;
    }
}
