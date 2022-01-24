package com.epam.training.logic;

import com.epam.training.component.Lexeme;

import java.util.Comparator;

public class CharCounterComparator implements Comparator<Lexeme> {

    private final char givenChar;

    public CharCounterComparator(char givenChar) {
        this.givenChar = givenChar;
    }

    @Override
    public int compare(Lexeme firstObject, Lexeme secondObject) {
        int charCountDifference = givenCharCount(firstObject.getValue()) - givenCharCount(secondObject.getValue());
        if (charCountDifference != 0) {
            return charCountDifference;
        }
        return firstObject.getValue().compareToIgnoreCase(secondObject.getValue());
    }

    private int givenCharCount(String lexeme) {
        int counter = 0;
        for (int i = 0; i < lexeme.length(); i++) {
            if (lexeme.charAt(i) == givenChar) {
                counter++;
            }
        }
        return counter;
    }
}
