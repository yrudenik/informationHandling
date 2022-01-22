package com.epam.training.parser;

import com.epam.training.component.Composite;
import com.epam.training.component.Lexeme;

public class SentenceParser extends AbstractParser{

    private static final String LEXEME_TYPES_DELIMITER = "\\s(?=\\[)|(?<=])\\s";
    private static final String WORD_DELIMITER = "\\s";

    protected SentenceParser(Parser successor) {
        super(successor);
    }

    public SentenceParser() {
        super();
    }

    @Override
    public Composite parse(String text) {
        Composite composite = new Composite();
        String[] lexemes = text.split(LEXEME_TYPES_DELIMITER);
        for (String lexeme : lexemes){
            if (lexeme.contains("[")){
                composite.add(Lexeme.phrase(lexeme));
            } else {
                parseWordsToComposites(lexeme, composite);
            }
        }
        return composite;
    }

    private void parseWordsToComposites(String words, Composite composite) {
        String[] splitWords = words.split(WORD_DELIMITER);
        for (String word : splitWords){
            composite.add(Lexeme.word(word));
        }
    }
}
