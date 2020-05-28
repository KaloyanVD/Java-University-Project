package com.company;

public abstract class Employee{
    double salary;

    public double getSalary() {
        return salary;
    }

    public Employee(double salary) {
        this.salary = salary;
    }
}
