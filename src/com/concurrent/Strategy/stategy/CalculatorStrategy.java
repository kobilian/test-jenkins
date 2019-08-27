package com.concurrent.Strategy.stategy;

@FunctionalInterface
public interface CalculatorStrategy {

    double taxCalculation(double salary, double bonus);

}
