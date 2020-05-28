package com.company;

import com.sun.java.accessibility.util.EventQueueMonitor;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class printingHouse {
    private final double expectedProfit = 15000;
    private double profit = 0;
    private double expenses = 0;
    private double money = 1000;
    private List<Employee> employeeList;
    private List<Employee> operatorList;
    private List<Employee> managerList;
    private List<Item> itemList;
    private FileWriter fileWriter;

    public printingHouse() throws IOException {
        this.employeeList = new ArrayList<>();
        this.operatorList = new ArrayList<>();
        this.managerList = new ArrayList<>();
        this.itemList = new ArrayList<>();
        File file = new File("Summary.txt");
        file.createNewFile();
        this.fileWriter = new FileWriter(file);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
        String[] split = employee.getClass().getTypeName().split("\\.");
        if (split[2].equals("Operator")) {
            this.operatorList.add(employee);
        } else {
            this.managerList.add(employee);
        }
    }

    public double getMoney() {
        return money;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    private void calculateProfit() throws IOException {
        for (Item item : itemList) {
            profit += item.getCost() * item.getType();
        }
        if (money + profit >= expectedProfit){
            this.profit -= managerBonus();
            expenses += managerBonus();
        }
        this.money += this.profit;
        paySalaries();
        this.fileWriter.write("Total expenses: " + this.expenses + " leva" + "\n");
        this.fileWriter.write("Gross profit: " + this.profit + " leva" + "\n");
        this.fileWriter.write("Net profit: " + this.money  + " leva");
        this.fileWriter.close();
    }

    private void paySalaries(){
        for (Employee employee: employeeList){
            money-= employee.salary;
            expenses += employee.salary;
        }
    }

    private double managerBonus(){
        double procents = (this.profit/managerList.size() / managerList.size());
        return procents * managerList.size();
    }

    public double getExpenses() {
        return expenses;
    }

    public void startMachines() throws IOException {
        this.fileWriter.write("The shop started with " + this.money + " leva \n");
        for (int i = 0; i < this.itemList.size()-1 ; i++) {
            try {
                printMachine m1 = new printMachine(300, 30, true, "Thread 1", this.itemList.get(i), money);
                m1.start();
                this.fileWriter.write("Machine 1 printed: " + this.itemList.get(i).title + "\n");
                printMachine m2 = new printMachine(100, 10, false, "Thread 2", this.itemList.get(i), money);
                m2.start();
                this.fileWriter.write("Machine 2 printed: " + this.itemList.get(i).title + "\n");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        this.calculateProfit();
    }
}