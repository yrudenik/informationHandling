package com.epam.training.calculation;

import com.epam.training.exception.CustomComponentException;

public class DivideInterpreter implements Interpreter {
    @Override
    public void interpret(Context context) throws CustomComponentException {
        Double secondArgument = context.pop();
        Double firstArgument = context.pop();
        if(secondArgument == 0){
            throw new CustomComponentException("Error: dividing in zero");
        }
        context.push(firstArgument/secondArgument);
    }
}
