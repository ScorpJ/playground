package com.homework.galaxy.service.impl;

import com.homework.galaxy.utils.RomanNumeral;
import com.homework.galaxy.utils.RomanNumeralConvertor;
import com.homework.galaxy.utils.QuestionProcessor;
import com.homework.galaxy.dao.KnowledgeDao;
import com.homework.galaxy.dao.impl.KnowledgeDaoImpl;
import com.homework.galaxy.service.IntergalacticConversionService;
import com.homework.galaxy.utils.Constants;
import com.homework.galaxy.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class IntergalacticConversionServiceImpl implements IntergalacticConversionService {

    private QuestionProcessor qProcessor;

    private KnowledgeDao dao;

    public IntergalacticConversionServiceImpl(){
        this.dao = KnowledgeDaoImpl.getInstance();
        this.qProcessor = new QuestionProcessor();
    }

    @Override
    public String responseQuestions(String inputLine){
        String answer = qProcessor.processQuestion(inputLine);
        return answer;
    }

    @Override
    public void buildKnowledge(String inputLine){

        if (StringUtils.isNotBlank(inputLine)){
            String[] elements = inputLine.split(Constants.IS_VALUE);

            if (elements.length > 1 && StringUtils.isNotBlank(elements[1])){
                if (elements[1].endsWith(Constants.CREDITS)){
                    double aFinalCredits = 0;

                    String[] galacticUnits = elements[0].split(Constants.SPACE);
                    String aCreditName = null;

                    List<Object> aRomanValueList = new ArrayList<Object>();
                    for (String aGalacticUnit : galacticUnits){
                        // Get the Assigned Value for the Galactic unit

                        Object assignedValue = this.dao.getAssignedValue(aGalacticUnit);

                        if(assignedValue instanceof String){
                            String value = (String)this.dao.getAssignedValue(aGalacticUnit);

                            // Get the Roman Numeral for the Galactic unit.
                            RomanNumeral romanNumerial = this.dao.getRomanNumerialValue(value);
                            if (romanNumerial != null){
                                // Add Roman Numeral Name to the list
                                aRomanValueList.add(romanNumerial.name());
                            }else{
                                // Credit Name
                                aCreditName = aGalacticUnit;
                            }
                        }else{
                            aCreditName = aGalacticUnit;
                        }

                    }

                    String[] aCreditSplit = elements[1].split(Constants.SPACE);
                    if (aCreditSplit != null){
                        // Pass the Roman Values as a List to get the final Arabic value of the Roman values
                        double anArabicValue = RomanNumeralConvertor.convertToArabicValue(aRomanValueList);

                        /*
                         * We take only the First value of the Credit splits
                         * Array. Since we assume that we will have only one
                         * value as a credit name. eg: Silver Credits. here we
                         * omit the Credits value and find the Credits for
                         * Silver
                         */
                        aFinalCredits = (Double.parseDouble(aCreditSplit[0]) / anArabicValue);
                    }

                    // Add the Credit Name as key and Credit Value as Value
                    // if the aCreditName was existing, will not change it.
                    this.dao.addAssignedValue(aCreditName, aFinalCredits);
                }else{
                    // Add the Galactic name as key and assigned Roman value of it as value
                    this.dao.addAssignedValue(elements[0].trim(), elements[1].trim());
                }
            }else{
                throw new IllegalArgumentException("Invalid Input!\nPlease find the below Sample Input. All the values are case senstive. \nglob is I");
            }
        }

    }
}
