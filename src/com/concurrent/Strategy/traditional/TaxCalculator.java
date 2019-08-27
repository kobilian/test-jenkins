package com.concurrent.Strategy.traditional;

public class TaxCalculator {

    private double salary;

    private double bonus;

    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    // 相当于 run()
    protected double taxCalculation(){
        return 0.0d;
    }

    // 相当于 start()
    public double getResult(){
        return this.taxCalculation();
    }

}
