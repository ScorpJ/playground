package com.arthur.sort;

import java.util.Arrays;

public class InsertSort {



    public static void main(String[] args){
        InsertSort sortObj = new InsertSort();

        int[] arr = { 10, 5, 12, 3, 9, 8,  10};
        System.out.println("Before:"+ Arrays.toString(arr));
        sortObj.sort(arr);
        System.out.println("After:"+ Arrays.toString(arr));
    }

    public void sort(int[] arr){

        int i,j,tmp;

        if(arr.length <= 1){
            return ;
        }

        for(i = 1; i <= arr.length-1; i++){
            tmp = arr[i];
            j = i-1;
            while( j >= 0
                    && arr[j] > tmp){
                arr[j+1] = arr[j--];
            }

            arr[j+1] = tmp;

            System.out.println("Step " + i + ":"+ Arrays.toString(arr));

        }



    }
}
