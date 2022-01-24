package com.epam.training.calculation;

import com.epam.training.exception.CustomComponentException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ExpressionInterpreterTest {

    private static final ExpressionInterpreter EXPRESSION_OPERATION = new ExpressionInterpreter();
    private static final Map<String, Double> parameters = new HashMap<String, Double>() {
        {
            put("x", 3.0);
        }
    };
    private static final double DELTA = 0.001;

    @Test
    public void testInterpretShouldSummarizeWhenArgumentsAreValid() throws CustomComponentException {
        //given
        String expression = "[5 x +]";
        //when
        double actual = EXPRESSION_OPERATION.calculate(expression, parameters);
        //then
        double expected = 8.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testInterpretShouldSubtractWhenArgumentsAreValid() throws CustomComponentException {
        //given
        String expression = "[x 1 -]";
        //when
        double actual = EXPRESSION_OPERATION.calculate(expression, parameters);
        //then
        double expected = 2.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testInterpretShouldDivideWhenArgumentsAreValid() throws CustomComponentException {
        //given
        String expression = "[12 x /]";
        //when
        double actual = EXPRESSION_OPERATION.calculate(expression, parameters);
        //then
        double expected = 4.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test(expected = CustomComponentException.class)
    public void testInterpretShouldThrowExceptionWhenSecondArgumentIsZero() throws CustomComponentException {
        //given
        String expression = "[x 0 /]";
        //when
        double actual = EXPRESSION_OPERATION.calculate(expression, parameters);
    }

    @Test
    public void testInterpretShouldMultiplyWhenArgumentsAreValid() throws CustomComponentException {
        //given
        String expression = "[x 2 *]";
        //when
        double actual = EXPRESSION_OPERATION.calculate(expression, parameters);
        //then
        double expected = 6.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    //then
    @Test(expected = CustomComponentException.class)
    public void testInterpretShouldThrowExceptionWhenVariableIsInvalid() throws CustomComponentException {
        //given
        String expression = "[15 z *]";
        //when
        double actual = EXPRESSION_OPERATION.calculate(expression, parameters);
    }
}
