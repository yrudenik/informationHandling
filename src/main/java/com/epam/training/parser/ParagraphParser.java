package com.epam.training.parser;

import com.epam.training.component.Composite;

public class ParagraphParser extends AbstractParser{

    private static final String SENTENCE_DELIMITER = "(?<=[\\.\\?\\![\\.]{3}])\\s";

    protected ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String text) {
        return templateParse(text, SENTENCE_DELIMITER);
    }
}
