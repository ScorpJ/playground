package com.homework.galaxy.utils;

import com.homework.galaxy.IllegalRomanNumberException;
import com.homework.galaxy.dao.KnowledgeDao;
import com.homework.galaxy.dao.impl.KnowledgeDaoImpl;

import java.util.List;

/**
 * This class converts the Roman Values to Arabic Values. This class gets the
 * List of Roman Values and convert it to Arabic Values. This class find the
 * Credits values also for the Roman Values.
 *
 */
public class RomanNumeralConvertor {
	
	private static KnowledgeDao dao = KnowledgeDaoImpl.getInstance();
	
	public static RomanNumeral getRomanNumerialValue(String theKey){
		return dao.getRomanNumerialValue(theKey);
	}

	/**
	 * Convert
	 *     1. RomanNumeria to Arabic Values
	 *     2. RomanNumeria and unit ratio to Arabic Values
	 * @param aRomanValueList
	 * @return
	 */
	public static double convertToArabicValue(List<Object> aRomanValueList){
		RomanNumeral aTempValue = null;

		if(isConsecutive(aRomanValueList)){
			throw new IllegalRomanNumberException("Wrong roman number, consecutive numbers are not allowed.");
		}
		
		double aResult = 0;
		
		double aCreditValue = 0;
		
		if (aRomanValueList != null && aRomanValueList.size() >= 1){
			if (aRomanValueList.get(0) instanceof String){
				String firstRomanSymbol = (String) aRomanValueList.get(0);
				RomanNumeral romanNumerial = getRomanNumerialValue(firstRomanSymbol);

				if(romanNumerial == null){
					throw new IllegalRomanNumberException("Wrong roman number, unknown symbol:" + firstRomanSymbol);
				}

				aTempValue = romanNumerial;
				
				if(aRomanValueList.size() == 1){
					aResult += aTempValue.getValue();
					return aResult;
				}
			}else if(aRomanValueList.get(0) instanceof Double){
				aCreditValue += (Double)aRomanValueList.get(0);
			}
		}
		
		int count =0;

		for (int i = 1; i < aRomanValueList.size() ; i++){
			Object aFirstObjectValue = aRomanValueList.get(i);
			if (aFirstObjectValue instanceof String){
				String romanSymbol = (String) aFirstObjectValue;
				RomanNumeral aSecondNumerial = getRomanNumerialValue(romanSymbol);

				if (aSecondNumerial == null) {
//					aResult += aTempValue.getValue();
//					++count;
					throw new IllegalRomanNumberException("Wrong roman number, unknown symbol:" + romanSymbol);
				}

				// Add Temp Value to the Result
				if (aTempValue.getValue() >= aSecondNumerial.getValue()) {
					aResult += aTempValue.getValue();
					++count;
					aTempValue = aSecondNumerial;
				}else{
					if(!isSubtractive(aSecondNumerial.name(), aTempValue.name())){
						throw new IllegalRomanNumberException("Wrong roman number, not subtractive.");
					}
					aResult += (aSecondNumerial.getValue() - aTempValue.getValue());
					// Increment i
					++i;
					count = count + 2;
					if(i < aRomanValueList.size()){
						if(aRomanValueList.get(i) instanceof String){
							String aNewTempElement = (String) aRomanValueList.get(i);
							RomanNumeral aNewTempNumerial = getRomanNumerialValue(aNewTempElement);
							aTempValue = aNewTempNumerial;
						}else if(aRomanValueList.get(i) instanceof Double){
							aCreditValue += (Double)aRomanValueList.get(i);
							++count;
						}
					}
				}
			}else if(aRomanValueList.get(i) instanceof Double){
				aCreditValue += (Double)aRomanValueList.get(i);
				++count;
			}
		}
		
		//Verify count to Add the last temp value to the Result
		if(count != aRomanValueList.size()){
			aResult += aTempValue.getValue();
		}
		
		if(aCreditValue != 0){
			aResult = aResult * aCreditValue;
		}
		
		return aResult;
	}
	
	/**
	 * This method verify the following logic."I" can be subtracted from "V" and
	 * "X" only. "X" can be subtracted from "L" and "C" only. "C" can be
	 * subtracted from "D" and "M" only. "V", "L", and "D" can never be
	 * subtracted.
	 * 
	 * @param rightRoman: the roman number lay at right, V in IV.
	 * @param leftRoman : the roman number lay at left, I in IV
	 * @return
	 */
	static Boolean isSubtractive(String rightRoman, String leftRoman){

		RomanNumeral right = getRomanNumerialValue(rightRoman.toUpperCase());
		RomanNumeral left = getRomanNumerialValue(leftRoman.toUpperCase());

		if(right == null || left == null){
			return false;
		}

		if(right.getValue() <= left.getValue()){
			return false;
		}

		if (RomanNumeral.V.name().equalsIgnoreCase(leftRoman)
				|| RomanNumeral.L.name().equalsIgnoreCase(leftRoman)
				|| RomanNumeral.D.name().equalsIgnoreCase(leftRoman)){
			return false;
		}

		switch (leftRoman){

			case "I":
				if (rightRoman.equalsIgnoreCase(RomanNumeral.V.name())
						|| rightRoman.equalsIgnoreCase(RomanNumeral.X.name())){
					return true;
				}else{
//					System.out.println("I cannot be subtracted right '" + rightRoman
//							+ "' .'I' can be subtracted right 'V' and 'X' only ");
					return false;
				}
			case "X":
				if (rightRoman.equalsIgnoreCase(RomanNumeral.L.name())
						|| rightRoman.equalsIgnoreCase(RomanNumeral.C.name())) {
					return true;
				} else {
//					System.out.println("'X' cannot be subtracted right '" + rightRoman
//							+ "' .'X' can be subtracted right 'L' and 'C' only ");
					return false;
				}
			case "C":
				if (rightRoman.equalsIgnoreCase(RomanNumeral.D.name())
						|| rightRoman.equalsIgnoreCase(RomanNumeral.M.name())) {
					return true;
				} else {
//					System.out.println("'C' cannot be subtracted right '" + rightRoman
//							+ "' .'C' can be subtracted right 'D' and 'M' only ");
					return false;
				}
		}
		return true;
	}

	/**
	 * Check for the Consecutive values. The symbols "I", "X", "C", and "M" can
	 * be repeated three times in succession, but no more. (They may appear four
	 * times if the third and fourth are separated by aRomanValueList smaller value, such as
	 * XXXIX.) "D", "L", and "V" can never be repeated.
	 *
	 * @param aRomanValueList
	 * @return
	 */
	public static boolean isConsecutive(List<Object> aRomanValueList){
		char temp = 0;

		if( aRomanValueList.get(0) instanceof String){
			String aStringValue = (String) aRomanValueList.get(0);
			temp = aStringValue.charAt(0);
		}

		int count = 1;
		for (int i = 1; i < aRomanValueList.size(); i++){
			if(aRomanValueList.get(i) instanceof String){
				String aStringValue = (String) aRomanValueList.get(i);

				char aValue = aStringValue.charAt(0);

				if (aValue != temp){
					temp = aValue;
					count = 1;
				}else if (aValue == temp){
					count++;
				}

				if (count == 2 &&
						(aValue == 'D' || aValue == 'L' || aValue == 'V')) {
//					System.out.println("Consective Numbers of "+ aRomanValueList.get(i) + " are not allowed");
					return true;
				}

				if (count == 4){
//					System.out.println("Consective Numbers of "+ aRomanValueList.get(i) + " are not allowed");
					return true;
				}
			}
		}
		return false;
	}
}
