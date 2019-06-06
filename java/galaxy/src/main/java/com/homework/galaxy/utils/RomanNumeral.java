package com.homework.galaxy.utils;

/**
 * Enum holds the roman symbols
 *
 */
public enum RomanNumeral
{
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    int value;

    RomanNumeral(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
};
