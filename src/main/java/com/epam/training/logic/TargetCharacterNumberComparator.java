package com.epam.training.logic;

import com.epam.training.component.Lexeme;

import java.util.Comparator;

public class TargetCharacterNumberComparator implements Comparator<Lexeme> {

    private final char targetCharacter;

    public TargetCharacterNumberComparator(char targetCharacter) {
        this.targetCharacter = targetCharacter;
    }

    @Override
    public int compare(Lexeme firstObject, Lexeme secondObject) {
        int targetCharacterNumberDifference = targetCharacterCount(firstObject.getValue()) - targetCharacterCount(secondObject.getValue());
        if (targetCharacterNumberDifference != 0) {
            return targetCharacterNumberDifference;
        }
        return firstObject.getValue().compareToIgnoreCase(secondObject.getValue());
    }

    private int targetCharacterCount(String lexeme) {
        int counter = 0;
        for (int i = 0; i < lexeme.length(); i++) {
            if (lexeme.charAt(i) == targetCharacter) {
                counter++;
            }
        }
        return counter;
    }
}
