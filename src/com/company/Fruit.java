package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Fruit {

    private String name;
    private String color;


    public Fruit() {

    }

    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void input() {

        System.out.println("Enter fruit name");
        name = Main.scanner.next();

        System.out.println("Enter fruit color");
        color = Main.scanner.next();
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return  "Fruit{" + "name='" + name + '\'' + ", color='" + color + '\'' + '}';
    }

    public static List<Fruit> getYellowFruit(List<Fruit> fruits) {

        List<Fruit> result = new LinkedList<>();

        for (Fruit fruit : fruits) {
            if (fruit.getColor().equals("yellow")) {
                result.add(fruit);
            }
        }
        return result;
    }

    public static void saveFruitInXMLFile(List<Fruit> fruits) throws IOException {
        FileOutputStream fos = new FileOutputStream("fruits.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(fruits);
        encoder.close();
        fos.close();
    }


    public static List<Fruit> readFruitFromXMLFile() throws IOException {
        FileInputStream fis = new FileInputStream("fruits.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        List<Fruit> decodedFruits = (List<Fruit>) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedFruits;
    }

    public boolean getFromTXTFile(BufferedReader br) throws IOException {

        String line = "";
        if ((line = br.readLine()) == null) {
            return false;
        }

        String[] data = line.split(" ");

        this.name = data[0];
        this.color = data[1];

        return true;
    }
    public void saveObjectInFile(BufferedWriter bw)  {

        String data = this.name + " " + this.color + "\n";
        try {
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

