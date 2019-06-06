package com.homework.galaxy.utils;

import com.homework.galaxy.dao.KnowledgeDao;
import com.homework.galaxy.dao.impl.KnowledgeDaoImpl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class QuestionProcessor {

	public static final String NO_ANSWER = "I have no idea what you are talking about";
	public static final String WRONG_ROMAN_NUMBER = "Wrong roman number, consecutive numbers are not allowed.";


	private KnowledgeDao dao = KnowledgeDaoImpl.getInstance();
	DecimalFormat df = new DecimalFormat("#.##");

	public String processQuestion(String inputLine){

    	StringBuilder sb = new StringBuilder();

		if ((inputLine.startsWith(Constants.HOW_MUCH) || inputLine.startsWith(Constants.HOW_MANY))){
			double arabicValue = 0;

			List<String> galacticElements = this.parseGalacticElements(inputLine);
			List<Object> aRomanValueList = new ArrayList<Object>();

			if(galacticElements == null || galacticElements.size() == 0){
				return NO_ANSWER;
			}else{
				for(String ele: galacticElements){
					sb.append(ele).append(" ");
					Object anAssignedValue = this.dao.getAssignedValue(ele);

					if(anAssignedValue != null){
						aRomanValueList.add(anAssignedValue);
					}
				}
				sb.append("is ");
			}

			if(RomanNumeralConvertor.isConsecutive(aRomanValueList)){
				return WRONG_ROMAN_NUMBER;
			}

			arabicValue = RomanNumeralConvertor.convertToArabicValue(aRomanValueList);

			sb.append(df.format(arabicValue));
		}else{
			sb.append(NO_ANSWER);
		}

		return sb.toString();
	}

	/**
	 * Parser elements in the question that need to be converted.
	 * @param inputLine
	 * @return
	 */
	private List<String> parseGalacticElements(String inputLine){

		if(!StringUtils.isNotBlank(inputLine)){
			return null;
		}

		if(!inputLine.contains(Constants.QUESTION_MARK)){
			throw new IllegalArgumentException("Invalid Question. ' ?' is missing from question !!");
		}

		inputLine = inputLine.trim().substring(0, inputLine.indexOf('?'));

		String[] words = inputLine.split(Constants.IS_VALUE);

		List<String> galacticElements = new ArrayList<String>();

		if (words.length > 1){
			String word = words[1];
			if (!word.isEmpty()){
				// Convert to Char Array to check for ConsecutiveNumbers
				StringTokenizer aTokenizer = new StringTokenizer(word, Constants.SPACE);
				while (aTokenizer.hasMoreElements()){
					String anIntergalacticName = (String)aTokenizer.nextElement();
					galacticElements.add(anIntergalacticName);
				}

				if(galacticElements.isEmpty()){
					return null;
				}

			}
		}


		return galacticElements;

	}


}
