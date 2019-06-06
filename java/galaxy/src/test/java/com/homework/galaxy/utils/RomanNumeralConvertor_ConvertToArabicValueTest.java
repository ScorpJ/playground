package com.homework.galaxy.utils;

import com.homework.galaxy.IllegalRomanNumberException;
import com.homework.galaxy.IntergalacticConversionMainTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(value= Parameterized.class)
public class RomanNumeralConvertor_ConvertToArabicValueTest {

    public static final String EXCEPTION_CASE = "ExceptionCase";
    public static final String NORMAL_CASE = "NormalCase";


//    private List<Object> inputList;

    private String target;
    private String romanNumber;
    private double conversionRate;
    private double expectedValue;

    public RomanNumeralConvertor_ConvertToArabicValueTest(String target,
                                                          String romanNumber,
                                                          double conversionRate,
                                                          double expectedValue) {
        this.target = target;
        this.romanNumber = romanNumber;
        this.conversionRate = conversionRate;
        this.expectedValue = expectedValue;
    }

//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//
//        KnowledgeDao dao = KnowledgeDaoImpl.getInstance();
//
//        dao.addAssignedValue("i","I");
//        dao.addAssignedValue("v","V");
//        dao.addAssignedValue("x","X");
//        dao.addAssignedValue("l","L");
//        dao.addAssignedValue("c","C");
//        dao.addAssignedValue("d","D");
//        dao.addAssignedValue("m","M");
//
//        dao.addAssignedValue("Unit",10.0d);
//
//    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestCases() {

        List<Object[]> paras = new ArrayList<Object[]>();


        paras.add(new Object[]{NORMAL_CASE,"MMVI", -1d, 2006d});
        paras.add(new Object[]{NORMAL_CASE,"MMVI", 10d, 20060d});
        paras.add(new Object[]{NORMAL_CASE,"MCMXLIV", -1d,1944});
        paras.add(new Object[]{NORMAL_CASE,"MCMXLIV", 10d,19440});
        paras.add(new Object[]{NORMAL_CASE,"MCMIII", -1d,1903});
        paras.add(new Object[]{NORMAL_CASE,"MCMIII", 10d,19030});


        paras.add(new Object[]{NORMAL_CASE,"I", -1d,1});
        paras.add(new Object[]{NORMAL_CASE,"II", -1d,2});
        paras.add(new Object[]{NORMAL_CASE,"III", -1d,3});
        paras.add(new Object[]{NORMAL_CASE,"IV", -1d,4});
        paras.add(new Object[]{NORMAL_CASE,"V", -1d,5});
        paras.add(new Object[]{NORMAL_CASE,"VI", -1d,6});
        paras.add(new Object[]{NORMAL_CASE,"VII", -1d,7});
        paras.add(new Object[]{NORMAL_CASE,"VIII", -1d,8});
        paras.add(new Object[]{NORMAL_CASE,"IX", -1d,9});
        paras.add(new Object[]{NORMAL_CASE,"X", -1d,10});
        paras.add(new Object[]{NORMAL_CASE,"XI", -1d,11});
        paras.add(new Object[]{NORMAL_CASE,"XII", -1d,12});
        paras.add(new Object[]{NORMAL_CASE,"XIII", -1d,13});
        paras.add(new Object[]{NORMAL_CASE,"XIV", -1d,14});
        paras.add(new Object[]{NORMAL_CASE,"XV", -1d,15});
        paras.add(new Object[]{NORMAL_CASE,"XVI", -1d,16});
        paras.add(new Object[]{NORMAL_CASE,"XVII", -1d,17});
        paras.add(new Object[]{NORMAL_CASE,"XVIII", -1d,18});
        paras.add(new Object[]{NORMAL_CASE,"XIX", -1d,19});
        paras.add(new Object[]{NORMAL_CASE,"XX", -1d,20});

        paras.add(new Object[]{NORMAL_CASE,"XXI", -1d,21});
        paras.add(new Object[]{NORMAL_CASE,"XXII", -1d,22});
        paras.add(new Object[]{NORMAL_CASE,"XXIII", -1d,23});
        paras.add(new Object[]{NORMAL_CASE,"XXIV", -1d,24});
        paras.add(new Object[]{NORMAL_CASE,"XXV", -1d,25});
        paras.add(new Object[]{NORMAL_CASE,"XXVI", -1d,26});
        paras.add(new Object[]{NORMAL_CASE,"XXVII", -1d,27});
        paras.add(new Object[]{NORMAL_CASE,"XXVIII", -1d,28});
        paras.add(new Object[]{NORMAL_CASE,"XXIX", -1d,29});
        paras.add(new Object[]{NORMAL_CASE,"XXX", -1d,30});

        paras.add(new Object[]{NORMAL_CASE,"LXXXVIII", -1d,88});



        /*Below id for illegal Roman Number*/

        paras.add(new Object[]{EXCEPTION_CASE,"IIIIIIIIIIIIIIII", -1d, -1});
        paras.add(new Object[]{EXCEPTION_CASE,"VVVVVVVVVVVVVVVV", -1d, -1});
        paras.add(new Object[]{EXCEPTION_CASE,"XXXXXXXXXXXXXXXX", -1d, -1});
        paras.add(new Object[]{EXCEPTION_CASE,"LLLLLLLLLLLLLLLL", -1d, -1});
        paras.add(new Object[]{EXCEPTION_CASE,"CCCCCCCCCCCCCCCC", -1d, -1});
        paras.add(new Object[]{EXCEPTION_CASE,"DDDDDDDDDDDDDDDD", -1d, -1});
        paras.add(new Object[]{EXCEPTION_CASE,"MMMMMMMMMMMMMMMM", -1d, -1});
        paras.add(new Object[]{EXCEPTION_CASE,"ABC", -1d, -1});

//        String invalidRomanPath =
//                RomanNumeralConvertor_ConvertToArabicValueTest.class.getClassLoader()
//                        .getResource("p089_roman.txt").getFile();
//
//        String inValidRoman;
//        try(BufferedReader reader = new BufferedReader(new FileReader(invalidRomanPath))){
//            while((inValidRoman = reader.readLine()) != null) {
//                paras.add(new Object[]{EXCEPTION_CASE,inValidRoman, -1d, -1});
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        return paras;

    }

    @Test
    public void convertToArabicValue() {

        if(NORMAL_CASE.equals(this.target)){
            double arabicValue = -1;

            try{
                arabicValue = RomanNumeralConvertor.convertToArabicValue(this.getConvertList(this.romanNumber, this.conversionRate));
            }catch(IllegalRomanNumberException e){
                //NO thing;
                arabicValue = -2;
            }
            assertEquals(romanNumber+ "_" + conversionRate + "_"+ expectedValue,this.expectedValue,arabicValue, 0.000001);
        }
    }


    @Test(expected = IllegalRomanNumberException.class)
    public void convertWrongRomanNumber() {
        if(EXCEPTION_CASE.equals(this.target)){
            RomanNumeralConvertor.convertToArabicValue(this.getConvertList(this.romanNumber, this.conversionRate));
        }else{
            throw new IllegalRomanNumberException("Test stack");
        }
    }


    private List<Object> getConvertList(String romanNumber, double conversionRate){
        List<Object> inputList = new ArrayList<>();


        romanNumber.chars().forEach(val -> {
            String symbol = String.valueOf((char)val);
            inputList.add(symbol);
        });

        if(conversionRate != -1d){
            inputList.add(conversionRate);
        }


        return inputList;

    }
}