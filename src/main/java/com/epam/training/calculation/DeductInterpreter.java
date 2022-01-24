package com.epam.training.calculation;

public class DeductInterpreter implements Interpreter {
    @Override
    public void interpret(Context context) {
        context.push(-context.pop()+context.pop());
    }
}
