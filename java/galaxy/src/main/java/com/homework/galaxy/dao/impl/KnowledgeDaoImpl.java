package com.homework.galaxy.dao.impl;

import com.homework.galaxy.utils.RomanNumeral;
import com.homework.galaxy.dao.KnowledgeDao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Knowledge in mem for the intergalactic conversion.
 */
public class KnowledgeDaoImpl implements KnowledgeDao {


    public Map<String, RomanNumeral> romanNumerialsMap;


    /**
     *  Map to hold:
     * 1.	Intergalactic and its equivalent roman symbo. E.g. “glob” -> “I”
     * 2.	Intergalactic unit and its equivalent Arabic number. E.g “Silver” -> 17
     * */
    public Map<String, Object> assignedValueMap;

    private static KnowledgeDaoImpl instance = new KnowledgeDaoImpl();


    public static KnowledgeDaoImpl getInstance(){
        return instance;
    }


    private KnowledgeDaoImpl(){
        romanNumerialsMap = new ConcurrentHashMap<String, RomanNumeral>();
        assignedValueMap = new ConcurrentHashMap<String, Object>();
        loadRomanNumerials();
    }

    private void loadRomanNumerials(){
        RomanNumeral[] romanNumerials = RomanNumeral.values();
        for (RomanNumeral romanNumerial : romanNumerials){
            romanNumerialsMap.put(romanNumerial.name(), romanNumerial);
        }
    }


    @Override
    public void addAssignedValue(String key, Object value) {
        assignedValueMap.putIfAbsent(key, value);
    }

    @Override
    public Object getAssignedValue(String key) {
        return (key == null?null:assignedValueMap.get(key));
    }

    @Override
    public RomanNumeral getRomanNumerialValue(String key) {
        return (key == null? null:romanNumerialsMap.get(key));
    }
}
