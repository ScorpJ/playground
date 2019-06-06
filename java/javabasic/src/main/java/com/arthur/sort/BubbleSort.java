package com.arthur.sort;

import java.util.Arrays;

public class BubbleSort {


    public static void main(String[] args){
        BubbleSort sortObj = new BubbleSort();

        int[] arr = { 10, 5, 12, 3, 9, 8,  10};
        System.out.println("Before:"+ Arrays.toString(arr));
        sortObj.sort(arr);
        System.out.println("After:"+ Arrays.toString(arr));
    }

    public void sort(int[] arr){

        int i,j,tmp;

        for(i = arr.length-1; i > 0; i--){
            for(j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                     tmp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = tmp;
                }
            }
            System.out.println("out loop " + i + ": "+ Arrays.toString(arr));
        }

    }
}
