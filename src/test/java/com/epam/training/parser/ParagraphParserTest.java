package com.epam.training.parser;

import com.epam.training.component.Component;
import com.epam.training.component.Composite;
import com.epam.training.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class ParagraphParserTest {

    private static final String FIRST_SENTENCE = "Walk on, walk on.";
    private static final String SECOND_SENTENCE = "With hope in your heart!";
    private static final String VALID_PARAGRAPH = "Walk on, walk on. With hope in your heart!";
    private static final Composite EXPECTED_FIRST_SENTENCE = new Composite(Arrays.asList(Lexeme.word("Walk"), Lexeme.word("on,"), Lexeme.word("walk"), Lexeme.word("on.")));
    private static final Composite EXPECTED_SECOND_SENTENCE = new Composite(Arrays.asList(Lexeme.word("With"), Lexeme.word("hope"), Lexeme.word("in"), Lexeme.word("your"), Lexeme.word("heart!")));

    @Test
    public void testParseShouldReturnCorrectComponentWhenParagraphIsValid() {
        //given
        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
        Mockito.when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn(EXPECTED_FIRST_SENTENCE);
        Mockito.when(sentenceParser.parse(SECOND_SENTENCE)).thenReturn(EXPECTED_SECOND_SENTENCE);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        //when
        Component actual = paragraphParser.parse(VALID_PARAGRAPH);
        //then
        Component expected = new Composite();
        expected.add(EXPECTED_FIRST_SENTENCE);
        expected.add(EXPECTED_SECOND_SENTENCE);
        Assert.assertEquals(expected, actual);
    }
}
