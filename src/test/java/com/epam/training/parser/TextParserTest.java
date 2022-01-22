package com.epam.training.parser;

import com.epam.training.component.Component;
import com.epam.training.component.Composite;
import com.epam.training.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TextParserTest {

    private static final String VALID_TEXT = "First paragraph! Still first.\nSecond Paragraph.";
    private static final String FIRST_PARAGRAPH = "First paragraph! Still first.";
    private static final String SECOND_PARAGRAPH = "Second Paragraph.";
    private static final Component FIRST_COMPONENT = Lexeme.word(FIRST_PARAGRAPH);
    private static final Component SECOND_COMPONENT = Lexeme.word(SECOND_PARAGRAPH);

    @Test
    public void testParseShouldReturnCorrectComponentWhenTextIsValid() {
        //given
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        Mockito.when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn((Composite) FIRST_COMPONENT);
        Mockito.when(paragraphParser.parse(SECOND_PARAGRAPH)).thenReturn((Composite) SECOND_COMPONENT);
        TextParser textParser = new TextParser(paragraphParser);

        //when
        Component actual = textParser.parse(VALID_TEXT);

        //then
        Component expected = new Composite();
        expected.add(FIRST_COMPONENT);
        expected.add(SECOND_COMPONENT);

        Assert.assertEquals(expected, actual);
    }


}
