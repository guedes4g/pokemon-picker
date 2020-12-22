package com.company.exception;

import com.company.model.Direction;

public class IllegalDirectionInputException extends RuntimeException {
    public IllegalDirectionInputException() {
        super("Input must contain '" + Direction.getValidDirectionsString("', '") + "' characters only");
    }
}
