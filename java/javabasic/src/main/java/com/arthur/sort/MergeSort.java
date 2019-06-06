package com.arthur.sort;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args){
        MergeSort sortObj = new MergeSort();

        int[] arr = { 10, 5, 12, 3, 9, 8,  10};
        System.out.println("Before:"+ Arrays.toString(arr));
        sortObj.mergeSort(arr);
        System.out.println("After:"+ Arrays.toString(arr));
    }




    public void mergeSort(int[] src){
        doMergeSort(src, new int[src.length],0, src.length-1);
    }


    private void doMergeSort(int[] src, int[] tmpArray, int start, int end){

        if(start < end){
            int mid = (start + end) / 2;
            doMergeSort(src, tmpArray, start, mid);
            doMergeSort(src, tmpArray, mid+1, end);
            merge(src, tmpArray, start, mid+1, end);
        }


    }

    private void merge(int[] src, int[] tmpArray, int leftPos, int rightPos, int end) {

        int l = leftPos;
        int r = rightPos;
        int i = 0;

        while(l <= (rightPos -1) && r <= end){
            if(src[l] <= src[r]){
                tmpArray[i++] = src[l++];
            }else{
                tmpArray[i++] = src[r++];
            }
        }

        while(l <= (rightPos-1)){
            tmpArray[i++] = src[l++];
        }

        while(r <= end){
            tmpArray[i++] = src[r++];
        }

        /**
         * sorted elements in this round of merge.
         */
        int numOfEle = end - leftPos + 1;

        for(int j = 0; j < numOfEle; j++){
            src[leftPos + j] = tmpArray[j];
        }

    }
}
