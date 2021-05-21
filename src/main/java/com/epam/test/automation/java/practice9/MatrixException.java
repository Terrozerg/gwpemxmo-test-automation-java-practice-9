package com.epam.test.automation.java.practice9;

public class MatrixException extends Exception {
    public static final String MATRIX_SIZE = "Incompatible matrix sizes";
    public MatrixException(String message) {
        super(message);
    }
}
