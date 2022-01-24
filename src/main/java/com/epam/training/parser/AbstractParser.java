package com.epam.training.parser;

import com.epam.training.component.Component;
import com.epam.training.component.Composite;

public abstract class AbstractParser implements Parser {

    private final Parser successor;

    protected AbstractParser(Parser successor) {
        this.successor = successor;
    }

    public AbstractParser() {
        successor = null;
    }

    public Parser getSuccessor() {
        return successor;
    }

    public Composite templateParse(String text, String delimiterRegex){
        Composite resultComposite = new Composite();
        String[] textWithDelimiter = text.split(delimiterRegex);
        for (String textElement : textWithDelimiter){
            Component textElementComposite = getSuccessor().parse(textElement);
            resultComposite.add(textElementComposite);
        }
        return resultComposite;
    }
}
