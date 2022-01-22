package com.epam.training.parser;

import com.epam.training.component.Component;
import com.epam.training.component.Composite;
import com.epam.training.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;

public class SentenceParserTest {

    private static final String VALID_SENTENCE = "[10 x /] word!";
    private static final String PHRASE = "[10 x /]";
    private static final String WORD = "word!";
    private static final Component FIRST_COMPONENT = Lexeme.phrase(PHRASE);
    private static final Component SECOND_COMPONENT = Lexeme.word(WORD);

    @Test
    public void testParseShouldReturnCorrectComponentWhenSentenceIsValid() {
        //given
        SentenceParser sentenceParser = new SentenceParser(null);

        //when
        Component actual = sentenceParser.parse(VALID_SENTENCE);

        //then
        Component expected = new Composite();
        expected.add(FIRST_COMPONENT);
        expected.add(SECOND_COMPONENT);
        Assert.assertEquals(expected, actual);
    }
}
