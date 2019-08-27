package com.concurrent.Strategy.stategy;

public class TaxCalculator {

    private double salary;

    private double bonus;

    private CalculatorStrategy calculatorStrategy;

    public TaxCalculator(double salary, double bonus, CalculatorStrategy calculatorStrategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.calculatorStrategy = calculatorStrategy;
    }

    public double taxCalcute(){
        return calculatorStrategy.taxCalculation(salary,bonus);
    }

    public double getResult(){
        return this.taxCalcute();
    }
}
