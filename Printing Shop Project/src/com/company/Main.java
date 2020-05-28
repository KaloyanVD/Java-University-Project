package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        printingHouse printingHouse = new printingHouse();
        Employee operator = new Operator(10);
        Employee manager = new Manager(30);

        printingHouse.addEmployee(operator);
        printingHouse.addEmployee(manager);

        Item item1 = new Item(Item.type.book, "Harry Potter", 100, Item.size.A1, Item.paperType.glossy);
        Item item2 = new Item(Item.type.book, "Lord of the rings", 10, Item.size.A2, Item.paperType.normal);
        Item newspapaper = new Item(Item.type.newspaper, "BBC", 20, Item.size.A5, Item.paperType.newsprint);

        printingHouse.addItem(item1);
        printingHouse.addItem(item2);
        printingHouse.addItem(newspapaper);

        printingHouse.startMachines();
    }
}