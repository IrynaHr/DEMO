package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        List<Fruit> fruits = new ArrayList<>();
        List<Citrus> citruses = new ArrayList<>();

//      Creation fruts from console
        for (int i = 0; i < 2; i++) {
            Fruit fruit = new Fruit();
            fruit.input();
            fruits.add(fruit);
        }

//      Method getYellowFruit
//        System.out.println(Fruit.getYellowFruit(fruits));

//       Method Sort
//        fruits.sort(new NameComparator());
//        for (Fruit fruit : fruits) {
//            System.out.println(fruit);
//        }
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));

//      Reading fruit from TXT file
        Fruit fruit = new Fruit();
//
//        while (fruit.getFromTXTFile(br)){
//            fruits.add(fruit);
//            fruit = new Fruit();
//        }
//        for(Fruit f:fruits){
//
//            System.out.println(f);
//        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fruits.txt"));
        for (Fruit f: fruits) {
            f.saveObjectInFile(bufferedWriter);
        }
        bufferedWriter.close();

//      Reading cirtuses from XML file
//        Citrus citrus = new Citrus();
//
//        while (citrus.getFromTXTFile(br)) {
//            citruses.add(citrus);
//            citrus = new Citrus();
//
//        }
//        for (Citrus c : citruses) {
//
//            System.out.println(c);
//        }

//        Fruit.saveFruitInXMLFile(fruits);
//        System.out.println(Fruit.readFruitFromXMLFile());

    }
}
