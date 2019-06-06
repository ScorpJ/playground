package com.homework.galaxy.dao;

import com.homework.galaxy.utils.RomanNumeral;

public interface KnowledgeDao {


    void addAssignedValue(String theKey, Object theValue);

    Object getAssignedValue(String aGalacticUnit);

    RomanNumeral getRomanNumerialValue(String value);

}
