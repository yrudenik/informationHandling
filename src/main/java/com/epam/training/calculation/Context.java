package com.epam.training.calculation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {

    private final Deque<Double> arrayDeque = new ArrayDeque<>();

    public void push(Double value) {
        arrayDeque.push(value);
    }

    public Double pop() {
        return arrayDeque.pop();
    }
}
