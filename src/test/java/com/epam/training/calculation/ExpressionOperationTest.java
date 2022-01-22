package com.epam.training.calculation;

import com.epam.training.exception.CustomComponentException;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionOperationTest {

    private static final double DELTA = 0.001;
    private static final ExpressionOperation EXPRESSION_OPERATION = new ExpressionOperation();
    private static final double x = 2.0;

    @Test
    public void testCalculateShouldReturnCorrectDoubleSumWhenExpressionIsCorrect() throws CustomComponentException {
        //given
        String expression = "[8 x +]";
        //when
        double actual = EXPRESSION_OPERATION.calculate(expression);
        //then
        double expected = 10.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCalculateShouldReturnCorrectDoubleSubtractionWhenExpressionIsCorrect() throws CustomComponentException {
        //given
        String expression = "[8 x -]";
        //when
        double actual = EXPRESSION_OPERATION.calculate(expression);
        //then
        double expected = 6.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCalculateShouldReturnCorrectDoubleDividingWhenExpressionIsCorrect() throws CustomComponentException {
        //given
        String expression = "[8 x /]";
        //when
        double actual = EXPRESSION_OPERATION.calculate(expression);
        //then
        double expected = 4.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCalculateShouldReturnCorrectDoubleMultiplyingWhenExpressionIsCorrect() throws CustomComponentException {
        //given
        String expression = "[8 x *]";
        //when
        double actual = EXPRESSION_OPERATION.calculate(expression);
        //then
        double expected = 16.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    //then
    @Test(expected = CustomComponentException.class)
    public void testCalculateShouldThrowExceptionWhenExpressionHasUnknownVariable() throws CustomComponentException {
        //given
        String expression = "[8 y *]";
        //when
        double actual = EXPRESSION_OPERATION.calculate(expression);
    }


}
