package com.epam.training.calculation;

public class SumOperation implements Operation {
    @Override
    public void operate(Context context) {
        context.push(context.pop() + context.pop());
    }
}
