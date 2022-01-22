package com.epam.training.calculation;

import com.epam.training.exception.CustomComponentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionOperation {

    private static final String LEXEME_DELIMITER = " ";

    private final List<Operation> operationList = new ArrayList<>();

    public Integer calculate(String phrase) throws CustomComponentException {
        //operationList.clear();
        for (String lexeme : phrase.split(LEXEME_DELIMITER)) {
            if (lexeme.isEmpty() || lexeme.length() > 1 && addIntegerToPhrase(lexeme)) {
                continue;
            }
            switch (lexeme.charAt(0)) {
                case '+':
                    operationList.add(new SumOperation());
                    break;
                case '-':
                    operationList.add(new DeductOperation());
                    break;
                case '*':
                    operationList.add(new MultiplyOperation());
                    break;
                case '/':
                    operationList.add(new DivideOperation());
                    break;
                default:
                    addIntegerToPhrase(lexeme);
            }
        }
        return finishCalculation();
    }

    private Integer finishCalculation() throws CustomComponentException {
        Context context = new Context();
        for (Operation operation : operationList){
            operation.operate(context);
        }
        return context.pop();
    }

    private boolean addIntegerToPhrase(String lexeme) {
        Scanner scanner = new Scanner(lexeme);
        if (scanner.hasNext()) {
            operationList.add(new AnotherOperation(scanner.nextInt()));
        } else {
            return false;
        }
        return true;
    }
}
