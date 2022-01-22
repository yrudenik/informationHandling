package com.epam.training.component;

import java.util.List;

public interface Component {

    List<Component> getComponents();

    void add(Component textComponent);

    void remove(Component textComponent);

    int size();



}
