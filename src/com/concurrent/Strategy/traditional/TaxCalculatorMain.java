package com.concurrent.Strategy.traditional;

public class TaxCalculatorMain {

    public static void main(String[] args) {
        TaxCalculator tax = new TaxCalculator(10000d, 3000d){
            @Override
            protected double taxCalculation() {
                return getSalary() * 0.1 + getBonus() * 0.2;
            }
        };
        double result = tax.getResult();
        System.out.println(result);
    }

}
