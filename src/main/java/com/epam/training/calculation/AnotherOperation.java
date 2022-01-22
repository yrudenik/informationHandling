package com.epam.training.calculation;

public class AnotherOperation implements Operation {

    private final int number;

    public AnotherOperation(int number) {
        this.number = number;
    }

    @Override
    public void operate(Context context) {
        context.push(number);
    }
}
