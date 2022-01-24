package com.epam.training.parser;

public class TextBuilder {

    public Parser build(){
        return new TextParser(new ParagraphParser(new SentenceParser()));
    }
}
