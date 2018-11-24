package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Citrus extends Fruit {

    private double amountVitaminC;

    public Citrus() {

    }

    public Citrus(String name, String color, double amountVitaminC) {
        super(name, color);
        this.amountVitaminC = amountVitaminC;
    }

    public double getAmountVitaminC() {
        return amountVitaminC;
    }

    public void setAmountVitaminC(double amountVitaminC) {
        this.amountVitaminC = amountVitaminC;
    }


    @Override
    public String toString() {
        return super.toString() + "Vitamin C " + amountVitaminC;
    }


    @Override
    public void input() {
        super.input();

        System.out.println("Enter amount of C vitamin");
        amountVitaminC = Main.scanner.nextDouble();
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean getFromTXTFile(BufferedReader br) throws IOException {

        String line = "";
        if ((line = br.readLine()) == null) {
            return false;
        }

        String[] data = line.split(" ");

        super.getFromTXTFile(br);
        this.amountVitaminC = Double.parseDouble(data[2]);


        return true;
    }


}
