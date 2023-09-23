package org.example;

public interface Calculator<T, U, R>  {

    R add(T number1, U number2);


    R divide (T number1, U number2);

    R subtract(T number1, U number2);


    R multiply (T number1, U number2);





}
