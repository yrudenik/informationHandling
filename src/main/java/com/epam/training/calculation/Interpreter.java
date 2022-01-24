package com.epam.training.calculation;

import com.epam.training.exception.CustomComponentException;

public interface Interpreter {

    void interpret(Context context) throws CustomComponentException;
}
