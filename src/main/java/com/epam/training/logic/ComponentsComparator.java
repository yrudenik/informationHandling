package com.epam.training.logic;

import com.epam.training.component.Composite;

import java.util.Comparator;

public class ComponentsComparator implements Comparator<Composite> {

    @Override
    public int compare(Composite firstObject, Composite secondObject) {
        return firstObject.getChildrenNumber() - secondObject.getChildrenNumber();
    }
}
