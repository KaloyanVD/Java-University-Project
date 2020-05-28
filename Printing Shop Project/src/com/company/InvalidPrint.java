package com.company;

public class InvalidPrint extends RuntimeException{
    public InvalidPrint(String message) {
        super(message);
    }
}