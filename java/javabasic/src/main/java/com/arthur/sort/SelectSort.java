package com.arthur.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectSort {


    public static void main(String[] args){
        SelectSort sortObj = new SelectSort();

//        int[] arr = {5};
        int[] arr = {5, 12, 3, 8, 9, 10, 10};
        System.out.println("Before:"+ Arrays.toString(arr));
        sortObj.sort(arr);
        System.out.println("After:"+ Arrays.toString(arr));

    }

    public void sort(int[] arr){

        int i,j, minIdx, tmp;

        for(i = 0; i < arr.length - 1; i++){
            minIdx = i;
//            min = arr[minIdx];
            for(j = i+1; j < arr.length ; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            if(minIdx != i){
                tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }

            System.out.println("step "+ i +":"+ Arrays.toString(arr));
        }

    }
}
