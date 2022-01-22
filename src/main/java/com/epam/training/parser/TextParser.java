package com.epam.training.parser;

import com.epam.training.component.Composite;

public class TextParser extends AbstractParser {

    private static final String PARAGRAPH_DELIMITER = "\n";

    protected TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String text) {
        return templateParse(text, PARAGRAPH_DELIMITER);
    }
}
