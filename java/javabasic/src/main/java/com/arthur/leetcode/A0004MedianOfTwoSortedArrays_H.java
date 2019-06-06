package com.arthur.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class A0004MedianOfTwoSortedArrays_H {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        return solutionOne(nums1,nums2);
          return solutionTwo(nums1,nums2);
    }



    /**
     * O(m+n), and liner space cost
     * @param nums1
     * @param nums2
     * @return
     */
    private double solutionOne(int[] nums1, int[] nums2){
        int[] mergedArry = new int[nums1.length + nums2.length];

        int i=0;
        int j=0;
        int m=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] <= nums2[j]){
                mergedArry[m++] = nums1[i++];
            }else{
                mergedArry[m++] = nums2[j++];
            }
        }

        while(i<nums1.length){
            mergedArry[m++] = nums1[i++];
        }

        while(j<nums2.length){
            mergedArry[m++] = nums2[j++];
        }

        int midianIndex = (mergedArry.length - 1) / 2;

        if(mergedArry.length % 2 == 0){
            return (mergedArry[midianIndex] + mergedArry[midianIndex + 1]) * 1.0d / 2;
        }else{
            return mergedArry[midianIndex] * 1.0d;
        }
    }


    public double solutionTwo(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length;
//        int n = nums2.length;
//
//        int nums = m+n;
//
//        int midianIndex = (nums - 1)/2;
//
//        if(nums % 2 == 0){
//            double m1 = findMthValue(nums1, nums2, midianIndex);
//            double m2 = findMthValue(nums1, nums2, midianIndex + 1);
//            return (m1+ m2)/2;
//        }else{
//            return findMthValue(nums1, nums2, midianIndex);
//        }
//
//    }


//    private double findMthValue(int[] left, int[] right, int mth){
//
//        if(left.length == 0){
//            return right[mth] * 1.0d;
//        }
//
//        if(right.length == 0){
//            return left[mth] * 1.0d;
//        }
//
//        if(mth == 0){
//            return Math.min(left[0], right[0]) * 1.0d;
//        }
//
//        if(left[0] >= right[right.length-1]){
//            if(mth <= right.length-1){
//                return right[mth] * 1.0d;
//            }else{
//                return left[mth - right.length]  * 1.0d;
//            }
//        }
//
//        if(right[0] >= left[left.length-1]){
//            if(mth <= left.length-1){
//                return left[mth] * 1.0d;
//            }else{
//                return right[mth - left.length]  * 1.0d;
//            }
//        }
//
//
//        int targetL, targetR;
//        targetL = left.length - 1;
//        targetR = right.length - 1;
//        /* Number of elements that not bigger than current element */
//        int leftMost = Integer.MAX_VALUE;
//        boolean pointAtLeft = true;
//
//        while(leftMost != mth){
//            if(left[targetL] >= right[targetR]){
//                pointAtLeft = true;
//                leftMost = (targetL - 0) + (targetR - 0 + 1);
//                if(leftMost > mth){
//                   // go lower half
//                    targetL = targetL / 2;
//                }else if(leftMost < mth){
//                   // go upper half
//                    targetL = ( (targetL  + 1) + (left.length - 1)) / 2;
//                }
//
//            }else{
//                pointAtLeft = false;
//                leftMost = (targetR - 0) + (targetL - 0 + 1);
//                if(leftMost > mth){
//                    // go lower half
//                    targetR = targetR / 2;
//                }else if(leftMost < mth){
//                    // go upper half
//                    targetR = ( (targetR  + 1) + (right.length - 1)) / 2;
//                }
//            }
//
//        }
//
//        return pointAtLeft? left[targetL] * 1.0d : right[targetR] * 1.0d;
//    }

}
