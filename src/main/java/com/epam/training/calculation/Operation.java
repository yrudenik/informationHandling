package com.epam.training.calculation;

import com.epam.training.exception.CustomComponentException;

public interface Operation {

    void operate (Context context) throws CustomComponentException;
}
