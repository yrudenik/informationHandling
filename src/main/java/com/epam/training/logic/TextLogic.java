package com.epam.training.logic;

import com.epam.training.calculation.ExpressionOperation;
import com.epam.training.component.Component;
import com.epam.training.component.Composite;
import com.epam.training.component.Lexeme;
import com.epam.training.component.LexemeType;
import com.epam.training.exception.CustomComponentException;
import com.epam.training.parser.Parser;
import com.epam.training.parser.TextBuilder;

import java.util.ArrayList;
import java.util.List;

public class TextLogic {

    private static final String PARAGRAPHS_DELIMITER = "\n";
    private static final String LEXEMES_AND_SENTENCES_DELIMITER = " ";

    private final ExpressionOperation expressionOperation;

    public TextLogic() {
        expressionOperation = new ExpressionOperation();
    }

    public TextLogic(ExpressionOperation expressionOperation) {
        this.expressionOperation = expressionOperation;
    }

    public Composite parse(String text) {
        TextBuilder textBuilder = new TextBuilder();
        Parser parser = textBuilder.build();
        return parser.parse(text);
    }

    public String parsedTextToString(Component text, String delimiterComponent) throws CustomComponentException {
        StringBuilder resultString = new StringBuilder();
        if (text.getClass() == Composite.class) {
            Composite compositeText = (Composite) text;
            List<Component> componentsList = compositeText.getChildren();
            for (Component component : componentsList) {
                resultString.append(parsedTextToString(component, LEXEMES_AND_SENTENCES_DELIMITER));
                if (componentsList.indexOf(component) != componentsList.size() - 1) {
                    resultString.append(delimiterComponent);
                }
            }
            return resultString.toString();
        }
        if (text.getClass() == Lexeme.class) {
            Lexeme textAsLexeme = (Lexeme) text;
            String lexemeText = textAsLexeme.getValue();
            resultString.append(lexemeText);
            return resultString.toString();
        }
        throw new CustomComponentException("Illegal text component(Parse to String)");
    }

    public Composite calculateExpressionsInText(Composite text) throws CustomComponentException {
        List<Component> calculatedTextComponents = new ArrayList<>();
        List<Component> textComponents = text.getChildren();
        for (Component component : textComponents) {
            Component calculatedComponent;
            try {
                calculatedComponent = calculateExpressionsInComponent(component);
            } catch (CustomComponentException e) {
                throw new CustomComponentException(e);
            }
            calculatedTextComponents.add(calculatedComponent);
        }
        return new Composite(calculatedTextComponents);
    }

    private Component calculateExpressionsInComponent(Component component) throws CustomComponentException {
        if (component.getClass() == Composite.class) {
            Composite composite = (Composite) component;
            List<Component> calculatedComponents = new ArrayList<>();
            List<Component> components = composite.getChildren();
            for (Component componentIterator : components) {
                Component calculatedComponentIterator = calculateExpressionsInComponent(componentIterator);
                calculatedComponents.add(calculatedComponentIterator);
            }
            return new Composite(calculatedComponents);
        }
        if (component.getClass() == Lexeme.class) {
            Lexeme lexeme = (Lexeme) component;
            String lexemeValue = lexeme.getValue();
            String calculatedValue;
            if (lexeme.getLexemeType() == LexemeType.PHRASE) {
                calculatedValue = Integer.toString(expressionOperation.calculate(lexemeValue));
            } else {
                calculatedValue = lexemeValue;
            }
            return Lexeme.word(calculatedValue);
        }
        throw new CustomComponentException("Illegal text component(Parse to Component)");
    }

    public Composite sortParagraphsBySentenceNumber(Composite text) {
        List<Composite> paragraphs = new ArrayList<>();
        for (Component component : text.getChildren()) {
            paragraphs.add((Composite) component);
        }
        paragraphs.sort(new ChildComponentsComparator());
        return new Composite(paragraphs);
    }
}

