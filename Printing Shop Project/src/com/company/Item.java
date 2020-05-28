package com.company;

public class Item {
    private double cost;
    String title;
    int count;
    private size Size;
    private paperType PaperType;
    private type Type;

    enum type {
        book, poster, newspaper
    }

    enum size {
        A1, A2, A3, A4, A5
    }

    enum paperType {
        normal, glossy, newsprint
    }


    public Item(type type, String title, int count, size size, paperType paperType) {
        Type = type;
        this.title = title;
        this.count = count;
        Size = size;
        PaperType = paperType;
    }

    public paperType getPaperType() {
        return PaperType;
    }

    public int getCount() {
        return count;
    }

    public double getCost() {
        switch (PaperType) {
            case normal:
                cost = count * 0.1;
                break;
            case glossy:
                cost = count * 0.2;
                break;
            case newsprint:
                cost = count * 0.3;
                break;
        }
        return cost;
    }
    public double getType() {
        double price;
        switch (Type) {
            case book:
                price = 2;
                break;
            case poster:
                price = 3;
                break;
            case newspaper:
                price = 4;
                break;
        }
        return cost;
    }
}