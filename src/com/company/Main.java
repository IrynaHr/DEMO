package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        List<Fruit> fruits = new ArrayList<>();


        for (int i = 0; i < 2; i++) {
            Fruit fruit = new Fruit();
            fruit.input();
            fruits.add(fruit);
            fruit.print();
        }

        System.out.println(" ");
        System.out.println("Sort method");
        Fruit.sort(fruits);
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println(" ");
        System.out.println("Yellow fruits");
        System.out.println(Fruit.getYellowFruit(fruits));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fruits.txt"));
        for (Fruit f: fruits) {
            f.saveObjectInTXTFile(bufferedWriter);
        }
        bufferedWriter.close();

        BufferedReader br = new BufferedReader(new FileReader("fruits.txt"));
        System.out.println(" ");
        System.out.println("Get fruit from TXT file");

        Fruit fruit = new Fruit();
        while (fruit.getFromTXTFile(br)){
            fruits.add(fruit);
            fruit = new Fruit();
        }
        for(Fruit f:fruits){
            System.out.println(f);
        }

        Fruit.saveFruitInXMLFile(fruits);
        System.out.println(" ");
        System.out.println("Get fruit from xml");
         List<Fruit> lists = Fruit.readFruitFromXMLFile();
        for (Fruit f : lists) {
            System.out.println(f);
        }
    }
}
