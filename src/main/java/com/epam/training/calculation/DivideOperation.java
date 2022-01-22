package com.epam.training.calculation;

import com.epam.training.exception.CustomComponentException;

public class DivideOperation implements Operation {
    @Override
    public void operate(Context context) throws CustomComponentException {
        Integer secondArgument = context.pop();
        Integer firstArgument = context.pop();
        if(secondArgument == 0){
            throw new CustomComponentException("Error: dividing in zero");
        }
        context.push(firstArgument/secondArgument);
    }
}
