package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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
        return String.format("%sVitamin C %s", super.toString(), amountVitaminC);
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
        String line;

        if ((line = br.readLine()) == null) {
            return false;
        } else {
            String[] data = line.split(" ");

            this.setName(data[0]);
            this.setColor(data[1]);
            this.amountVitaminC = Double.parseDouble(data[2]);
            return true;
        }
    }

    public void saveObjectInFile(BufferedWriter bw) {

        String data = getName() + " " + getColor() + " " + amountVitaminC + "\n";
        try {
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
