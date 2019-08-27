package com.concurrent.Strategy.stategy;

public class TaxCalculatorMain {

    public static void main(String[] args) {

        SimpleCalculatorStrategy strategy = new SimpleCalculatorStrategy();
        TaxCalculator calculator = new TaxCalculator(10000d, 3000d, strategy);
        System.out.println(calculator.getResult());
    }

}

class SimpleCalculatorStrategy implements CalculatorStrategy{

    private static final double SALARY_RATE = 0.1;

    private static final double BONUS_RATE= 0.2;

    @Override
    public double taxCalculation(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}