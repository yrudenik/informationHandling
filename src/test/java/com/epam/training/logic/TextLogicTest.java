package com.epam.training.logic;

import com.epam.training.component.Composite;
import com.epam.training.component.Lexeme;
import com.epam.training.exception.CustomComponentException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TextLogicTest {

    private static final String FULL_TEXT = "Walk on. Walk on. With hope in your heart!\nAnd you'll never walk alone! You'll never walk alone!";
    private static final Composite FIRST_PARAGRAPH = new Composite(Arrays.asList(Lexeme.expression("Walk on."), Lexeme.expression("Walk on."), Lexeme.expression("With hope in your heart!")));
    private static final Composite SECOND_PARAGRAPH = new Composite(Arrays.asList(Lexeme.expression("And you'll never walk alone!"), Lexeme.expression("You'll never walk alone!")));
    private static final Composite EXPECTED_FULL_TEXT = new Composite(Arrays.asList(FIRST_PARAGRAPH, SECOND_PARAGRAPH));

    private final TextLogic textLogic = new TextLogic();

    @Test
    public void testParseShouldRestoreTextWhenCompositeIsValid() throws CustomComponentException {
        //given
        //when
        String actualTextOfComposite = textLogic.parsedTextToString(EXPECTED_FULL_TEXT);
        //then
        Assert.assertEquals(FULL_TEXT, actualTextOfComposite);
    }

    @Test
    public void testSortShouldParagraphsBySentenceNumberWhenCompositeIsValid() {
        //given
        Composite expected = new Composite();
        expected.add(SECOND_PARAGRAPH);
        expected.add(FIRST_PARAGRAPH);
        //when
        Composite actualTextWithSortedParagraphs = textLogic.sortParagraphsBySentenceNumber(EXPECTED_FULL_TEXT);
        //then
        Assert.assertEquals(expected, actualTextWithSortedParagraphs);
    }
}

