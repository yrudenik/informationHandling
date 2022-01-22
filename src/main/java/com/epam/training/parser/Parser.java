package com.epam.training.parser;

import com.epam.training.component.Composite;

public interface Parser {

    Composite parse(String text);
}
