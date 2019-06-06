package com.arthur.lintcode;

/**
 * Count the number of k's between 0 and n. k can be 0 - 9.
 * if n = 12, k = 1 in
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
 *  
 * we have FIVE 1's (1, 10, 11, 12)
 * 
 * Medium
 * 
 * @author jiey
 *
 */

public class Algo0003DigitCounts {

	
	
	
	public int digitCounts(int k, int n) {
		int counter = 0;
		for (int i = 0; i <= n; i++) {
			int m = i;
			if (m==0 && k== 0){
				counter++;
				continue;
			}
			
			while (m > 0){
				if (m%10 == k){
					counter++;					
				}
			    m = m/10;				
			}
		}
	    return counter;
		
	}

	
	public static void main(String[] args){
		Algo0003DigitCounts solution = new Algo0003DigitCounts();
		int c = solution.digitCounts(1, 12);
		System.out.print(c);
		
		
	}
}
