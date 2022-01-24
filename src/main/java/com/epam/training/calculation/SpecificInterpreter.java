package com.epam.training.calculation;

public class SpecificInterpreter implements Interpreter {

    private final Double number;

    public SpecificInterpreter(Double number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.push(number);
    }
}
