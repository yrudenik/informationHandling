package com.epam.training.parser;

import com.epam.training.component.Composite;
import com.epam.training.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class TextParserTest {

    private static final String FULL_TEXT = "Walk on, walk on. With hope in your heart!\nAnd you'll never walk alone!";
    private static final String FIRST_PARAGRAPH = "Walk on, walk on. With hope in your heart!";
    private static final String SECOND_PARAGRAPH = "And you'll never walk alone!";
    private static final Composite EXPECTED_FIRST_PARAGRAPH = new Composite(Arrays.asList(Lexeme.expression("Walk on, walk on."), Lexeme.expression("With hope in your heart!")));
    private static final Composite EXPECTED_SECOND_PARAGRAPH = new Composite(Arrays.asList(Lexeme.expression("Second Paragraph."), Lexeme.expression("Second yet.")));
    private static final Composite EXPECTED_TEXT = new Composite(Arrays.asList(EXPECTED_FIRST_PARAGRAPH, EXPECTED_SECOND_PARAGRAPH));

    @Test
    public void testParseShouldReturnCorrectTextWhenTextIsParagraphComposite() {
        //given
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        Mockito.when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn(EXPECTED_FIRST_PARAGRAPH);
        Mockito.when(paragraphParser.parse(SECOND_PARAGRAPH)).thenReturn(EXPECTED_SECOND_PARAGRAPH);
        TextParser textParser = new TextParser(paragraphParser);
        //when
        Composite actual = textParser.parse(FULL_TEXT);
        //then
        Assert.assertEquals(EXPECTED_TEXT, actual);
    }
}
