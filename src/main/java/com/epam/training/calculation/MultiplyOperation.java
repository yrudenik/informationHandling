package com.epam.training.calculation;

public class MultiplyOperation implements Operation {
    @Override
    public void operate(Context context) {
        context.push(context.pop() * context.pop());
    }
}
