package com.geekbrains.backend.exception;

import java.util.Arrays;

public class ApplicationException extends RuntimeException{

    private static final String MESSAGE = "Oops, something wrong! Please, contact with administrator. %s";

    public ApplicationException(Object... objects) {
        super(String.format(MESSAGE, Arrays.toString(objects)));
    }

    @Override
    public String toString() {
        return getMessage();
    }

}
