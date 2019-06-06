package com.arthur.lintcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Given an array of integers, the majority number is the number that occurs more than half of the size of the array.
 * Find it.
 * 
 * You may assume that the array is non-empty and the majority number always exist in the array.
 * 
 * Given [1, 1, 1, 1, 2, 2, 2], return 1
 * 
 * Challenge: O(n) time and O(1) extra space
 * 
 * @author jiey
 *
 */		
public class Algo0046MajorityElement {

	public Algo0046MajorityElement() {
		// TODO Auto-generated constructor stub
	}
	
	public int majorityNumber(List<Integer> nums){
		
		
		Collections.sort(nums);
		
		int i = 1;
		int majorEle = nums.get(0); 
		int majorOccurs = 1;
		int lastEle = nums.get(0);
		int counter = 1;
		while(i < nums.size()){
			if(nums.get(i) == lastEle){
				i++;
				counter++;
			}else{
				if (counter >= majorOccurs){
					majorEle = lastEle;
					majorOccurs = counter;					
				}
				lastEle = nums.get(i);
				counter = 1;
				i++;				
			}
		}
		
		if (counter >= majorOccurs){
			majorEle = lastEle;
			majorOccurs = counter;					
		}
		
		
		return majorEle;
	}
	
	
	public static void main(String[] args){
		Algo0046MajorityElement solution = new Algo0046MajorityElement();
		int c = solution.majorityNumber(Arrays.asList(2,2,2,1));
		System.out.print(c);
		
		
		
		
	}

	

}
