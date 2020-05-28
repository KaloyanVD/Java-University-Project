package com.company;

public class printMachine implements Runnable {
    private int maxPaperCount;
    private int papersPerMinute;
    private double money;
    private boolean colored;
    private Thread t;
    private String threadName;
    private Item item;

    public printMachine(int maxPaperCount, int papersPerMinute, boolean colored, String threadName, Item item, double money) {
        this.maxPaperCount = maxPaperCount;
        this.papersPerMinute = papersPerMinute;
        this.colored = colored;
        this.threadName = threadName;
        this.item = item;
        this.money = money;
    }


    @Override
    public void run() {
        if (this.maxPaperCount < this.item.getCount()) {
            throw new InvalidPrint("Not Enough paper");
        }
        if (this.money < this.item.getCost()) {
            throw new InvalidPrint("Not Enough money");
        }
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}