package com.epam.training.calculation;

import com.epam.training.exception.CustomComponentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpressionOperation {
    private static final String EXPRESSION_SEPARATOR = "\\p{Blank}+";

    public double calculate(String expression, Map<String, Double> parameters) throws CustomComponentException {
        List<Interpreter> expressions = parse(expression, parameters);
        Context context = new Context();
        for (Interpreter terminal : expressions) {
            terminal.interpret(context);
        }
        return context.pop();
    }

    private List<Interpreter> parse(String expression, Map<String, Double> parameters) throws CustomComponentException {
        List<Interpreter> expressions = new ArrayList<>();
        String expressionValue = expression.replaceAll("[\\[\\]]", "");
        for (String part : expressionValue.split(EXPRESSION_SEPARATOR)) {
            if (!part.isEmpty()) {
                switch (part) {
                    case "+":
                        expressions.add(new SumInterpreter());
                        break;
                    case "-":
                        expressions.add(new DeductInterpreter());
                        break;
                    case "*":
                        expressions.add(new MultiplyInterpreter());
                        break;
                    case "/":
                        expressions.add(new DivideInterpreter());
                        break;
                    default:
                        Scanner scanner = new Scanner(part);
                        if (scanner.hasNextDouble()) {
                            Double number = scanner.nextDouble();
                            expressions.add(new SpecificInterpreter(number));
                        } else {
                            String key = scanner.next();
                            if (parameters.containsKey(key)) {
                                Double number = parameters.get(key);
                                expressions.add(new SpecificInterpreter(number));
                            } else {
                                throw new CustomComponentException("There is unknown variable in expression: " + key);
                            }
                        }
                }
            }
        }
        return expressions;
    }
}
