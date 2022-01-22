package com.epam.training.parser;

import com.epam.training.component.Component;
import com.epam.training.component.Composite;
import com.epam.training.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ParagraphParserTest {

    private static final String FIRST_SENTENCE = "First sentence.";
    private static final String SECOND_SENTENCE = "Second sentence!";
    private static final String VALID_PARAGRAPH = "First sentence. Second sentence!";
    private static final Component FIRST_COMPONENT = Lexeme.word(FIRST_SENTENCE);
    private static final Component SECOND_COMPONENT = Lexeme.word(SECOND_SENTENCE);

    @Test
    public void testParsShouldReturnCorrectComponentWhenParagraphIsValid() {
        //given
        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
        Mockito.when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn((Composite) FIRST_COMPONENT);
        Mockito.when(sentenceParser.parse(SECOND_SENTENCE)).thenReturn((Composite) SECOND_COMPONENT);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);

        //when
        Component actual = paragraphParser.parse(VALID_PARAGRAPH);

        //then
        Component expected = new Composite();
        expected.add(FIRST_COMPONENT);
        expected.add(SECOND_COMPONENT);
        Assert.assertEquals(expected, actual);
    }

}
