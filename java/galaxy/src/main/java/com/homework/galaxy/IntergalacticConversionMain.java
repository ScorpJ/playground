package com.homework.galaxy;

import com.homework.galaxy.service.IntergalacticConversionService;
import com.homework.galaxy.service.impl.IntergalacticConversionServiceImpl;
import com.homework.galaxy.utils.Constants;
import com.homework.galaxy.utils.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * Main entrance of this intergalactic conversion application.
 * This application helps user to query build there knowledge on:
 * 1. What intergalactic number means for arabic number.
 * 2. How to convert intergalactic number and unit into arabic Credits
 *
 * This application use text file as input.
 * Each line of input is a parse unit.
 * The parse unit should be separated by Space (" ") properly. *
 * All the value in the inputs are case-sensitive.
 *
 * Input of below format is used for build knowledge (the term Credits used in the input is Case-Sensitive):
 * intergalactic number is Roman number
 * intergalactic number unit is arabic number Credits
 *
 * e.g.
 * glob is I
 * glob glob Silver is 34 Credits
 *
 * Duplicate knowledge will be discarded.
 *
 * Input of below format is used for query conversion:
 * how much is intergalactic number ?
 * how many Credits is intergalactic number unit ?
 *
 * "how much" is used to ask the converted arabic number of the intergalactic number.
 * "how many" is used to ask the converted arabic number Credits of the intergalactic unit.
 *
 * e.g.
 * how much is pish tegj glob glob ?
 * how many Credits is glob prok Silver ?
 *
 *
 * Sample Input:
 * glob is I
 * prok is V
 * pish is X
 * tegj is L
 * glob glob Silver is 34 Credits
 * glob prok Gold is 57800 Credits
 * pish pish Iron is 3910 Credits
 * how much is pish tegj glob glob ?
 * how many Credits is glob prok Silver ?
 * how many Credits is glob prok Gold ?
 * how many Credits is glob prok Iron ?
 * how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
 *
 * *************************************************************************
 * Sample out put:
 * *************************************************************************
 * pish tegj glob glob is 42
 * glob prok Silver is 68 Credits
 * glob prok Gold is 57800 Credits
 * glob prok Iron is 782 Credits
 * I have no idea what you are talking about
 */
public class IntergalacticConversionMain {


    private IntergalacticConversionService service;

    public IntergalacticConversionMain(){
        this.service = new IntergalacticConversionServiceImpl();
    }


    public static void main(String[] args){

        IntergalacticConversionMain application = new IntergalacticConversionMain();

        File inputFile;

        if(args != null && args.length > 0 && args[0] != null){
            inputFile = new File(args[0]);
        }else{
            String defaultFile = IntergalacticConversionMain.class.getClassLoader().getResource("SampleInput.txt").getFile();
            inputFile = new File(defaultFile, "");
        }

        application.processInput(inputFile);
    }


    public void processInput(File file){

        String inputLine;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while((inputLine = reader.readLine()) != null){
                if (StringUtils.isNotBlank(inputLine)){
                    try{
                        this.responseParseUnit(inputLine);
                    }catch (Exception e){
//                        System.out.println("******Error message********");
//                        System.out.println(e.getClass().getName());
                        System.out.println(e.getMessage());
//                        System.out.println("******Error message end********");
//                        e.printStackTrace();
                    }
                }
            }
        }catch (Exception e){
            System.out.println("******Error message********");
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            System.out.println("******Error message end ********");
        }
    }



    private void responseParseUnit(String parseUnit){
        if (parseUnit.startsWith(Constants.HOW)){
            System.out.println(this.service.responseQuestions(parseUnit));
        }else{
            this.service.buildKnowledge(parseUnit);
        }
    }


}
