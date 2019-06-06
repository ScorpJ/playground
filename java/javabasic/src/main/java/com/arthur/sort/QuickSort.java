package com.arthur.sort;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args){
        QuickSort quickSort = new QuickSort();

//        int[] arr = {5};
        int[] arr = {5, 12, 3, 8, 9, 10, 10};
        System.out.println("Before:"+ Arrays.toString(arr));
        quickSort.sort(arr);
        System.out.println("After:"+ Arrays.toString(arr));

    }

    public void sort(int[] arr) {
        doQuickSort(arr, 0, arr.length-1);
    }


    private void doQuickSort(int[] src, int leftIdx, int rightIdx){

        if(leftIdx >= rightIdx){
            return ;
        }

        if((rightIdx - leftIdx + 1) <= 3){
            manualSort(src, leftIdx, rightIdx);
        }else{
            int pivot  = getPivotMedianOfThree(src, leftIdx, rightIdx);
            int pivotIdx = partition(src, leftIdx, rightIdx, pivot);
            doQuickSort(src, leftIdx, pivotIdx - 1);
            doQuickSort(src, pivotIdx + 1, rightIdx);
        }


    }

    /**
     * /**
     *  get pivot by media of 3, put the pivot at index rightIdx-1
     *
     * @param src
     * @param leftIdx
     * @param rightIdx
     * @return pivot value
     */
    private int getPivotMedianOfThree(int[] src, int leftIdx, int rightIdx){

        int midIdx = (leftIdx + rightIdx)/2;

        if(src[leftIdx] > src[midIdx]){
            swap(src, leftIdx, midIdx);
        }

        if(src[leftIdx] > src[rightIdx]){
            swap(src, leftIdx, rightIdx);
        }

        if(src[midIdx] > src[rightIdx]){
            swap(src, midIdx, rightIdx);
        }

        swap(src, midIdx, rightIdx - 1);

        return src[rightIdx - 1];
    }

    /**
     *
     * @param src
     * @param leftIdx
     * @param rightIdx
     * @return index of pivot value
     */
    private int partition(int[] src, int leftIdx, int rightIdx, int pivot){

        System.out.println("Before partition:"+leftIdx + "-" + rightIdx + " pivot:"+ pivot + "-" +  Arrays.toString(src));

        int l = leftIdx;
        int r = rightIdx-1;

        while(true){
            while(src[++l] < pivot){
                //nothing;
            }

            while(src[--r] > pivot){
                // nothing;
            }

            if(l >= r){
                break;
            }else{
                swap(src, l, r);
            }
        }

        swap(src, l, rightIdx - 1);

        System.out.println("After partition:" +leftIdx + "-" + rightIdx + " pivot idx-"+ l + " pivot value-" + src[l] + "-"  +  Arrays.toString(src));


        return l;
    }


    private void swap(int[] src, int idxA, int idxB){
        int tmp = src[idxA];
        src[idxA] = src[idxB];
        src[idxB] = tmp;
    }


    private void manualSort(int[] src, int leftIdx, int rightIdx){

        int size = rightIdx - leftIdx + 1;

        if(size == 1){
            return ;
        }
        if(size == 2){
            if(src[leftIdx] > src[rightIdx])
                swap(src, leftIdx, rightIdx);
            return ;
        }

        if(src[leftIdx] > src[rightIdx])
            swap(src, leftIdx, rightIdx);
        if(src[leftIdx] > src[rightIdx - 1])
            swap(src, leftIdx, rightIdx -1);
        if(src[rightIdx - 1] > src[rightIdx])
            swap(src, rightIdx - 1, rightIdx);

        return ;


    }
}
