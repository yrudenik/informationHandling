package com.epam.training.reader;

import com.epam.training.exception.CustomComponentException;
import org.junit.Assert;
import org.junit.Test;

public class TextReaderTest {

    private static final String VALID_FILE_PATH = "src/main/resources/text.txt";
    private static final String INVALID_FILE_PATH = "somethingWentWrongPath";
    private static final String EXPECTED = "It has survived - not only (five) centuries, but also the leap into [13  2 +] electronic typesetting, remaining [3  5 +] essentially [15  3 /] unchanged. It was popularised in the [5 x *] with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
            "\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using [2 3 * y +] Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here, making it look like readable English." +
            "\nIt is a [1200  5 /] established fact that a reader will be of a page when looking at its layout." +
            "\nBye.";

    @Test
    public void testReadShouldReturnCorrectTextWhenFileIsValid() throws CustomComponentException {
        //given
        TextReader textReader = new TextReader();
        //when
        String actual = textReader.read(VALID_FILE_PATH);
        //then
        Assert.assertEquals(EXPECTED, actual);
    }

    //then
    @Test(expected = CustomComponentException.class)
    public void testReadShouldThrowExceptionWhenFilePathIsNull() throws CustomComponentException {
        //given
        TextReader textReader = new TextReader();
        //when
        String actual = textReader.read(null);
    }

    //then
    @Test(expected = CustomComponentException.class)
    public void testReadShouldThrowExceptionWhenFilePathIsEmpty() throws CustomComponentException {
        //given
        TextReader textReader = new TextReader();
        //when
        String actual = textReader.read("");
    }

    //then
    @Test(expected = CustomComponentException.class)
    public void testReadShouldThrowExceptionWhenFilePathIsInvalid() throws CustomComponentException {
        //given
        TextReader textReader = new TextReader();
        //when
        String actual = textReader.read(INVALID_FILE_PATH);
    }

}
