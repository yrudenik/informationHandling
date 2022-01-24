package com.epam.training.logic;

import com.epam.training.component.Component;
import com.epam.training.component.Composite;
import com.epam.training.component.Lexeme;

import java.util.ArrayList;
import java.util.List;

public class SentenceLogic {

    public Composite sortCharCount(Composite sentence, char givenChar) {
        List<Lexeme> lexemes = new ArrayList<>();
        for (Component component : sentence.getChildren()){
            lexemes.add((Lexeme) component);
        }
        lexemes.sort(new CharCounterComparator(givenChar));
        return new Composite(lexemes);
    }
}
