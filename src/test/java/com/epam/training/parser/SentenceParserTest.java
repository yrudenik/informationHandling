package com.epam.training.parser;

import com.epam.training.component.Component;
import com.epam.training.component.Composite;
import com.epam.training.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;

public class SentenceParserTest {

    private static final String COMBINED_SENTENCE = "[5 x *] multiplying.";
    private static final String EXPRESSION = "[5 x *]";
    private static final String WORD = "multiplying.";
    private static final Component FIRST_COMPONENT = Lexeme.expression(EXPRESSION);
    private static final Component SECOND_COMPONENT = Lexeme.word(WORD);

    @Test
    public void testParseShouldReturnSentenceWhenSentenceIsCombined() {
        //given
        SentenceParser sentenceParser = new SentenceParser(null);
        Component expected = new Composite();
        expected.add(FIRST_COMPONENT);
        expected.add(SECOND_COMPONENT);
        //when
        Component actual = sentenceParser.parse(COMBINED_SENTENCE);
        //then
        Assert.assertEquals(expected, actual);
    }
}
