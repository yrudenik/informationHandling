package com.epam.training.calculation;

public class MultiplyInterpreter implements Interpreter {
    @Override
    public void interpret(Context context) {
        context.push(context.pop() * context.pop());
    }
}
