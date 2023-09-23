package org.example;

import org.example.Calculator;

public class IntegerCalculator implements Calculator<Integer, Integer,Number> {


    @Override
    public Number divide (Integer number1, Integer number2) {


        if (number2.equals(0))
        {
            throw new ArithmeticException("Divisão por zero!");
        }

        return  number1 / (double) number2;

    }

    @Override
    public Number subtract(Integer number1, Integer number2) {


        return number1 - number2;
    }

    @Override
    public Number multiply(Integer number1, Integer number2) {


        return number1 * number2;
    }

    @Override
    public Number add(Integer number1, Integer number2) {

        return number1 + number2;
    }
}