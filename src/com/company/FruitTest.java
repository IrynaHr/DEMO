package com.company;

import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FruitTest {

    @Test
    public void testGetYellow() {
        //arrange
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("name","yellow"));
        fruits.add(new Fruit("name2","black"));

        //act
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("name","yellow"));

        //assert
        assertSame(Fruit.getYellowFruit(fruits),expected);
//        assertEquals(Fruit.getYellow(fruits),expected );
//        assertNotNull(Fruit.getYellow(fruits));
    }

    @Test
    public void testGetFruitFromFile() {
    }

    @Test
    public void testInput() {
    }

    @Test
    public void testPrint() {

        String name ="Apple";
        String color = "red";

//        MessageUtil messageUtil = new MessageUtil(name+color);
//        String message = "Manisha";

//
//        @Test
//        public void testPrintMessage() {
//            System.out.println("Inside testPrintMessage()");
//            Assert.assertEquals(message, messageUtil.printMessage());
//        }
    }

    @Test
    public void testGetYellowFruit() {
    }

    @Test
    public void testSaveFruitInXMLFile() {
    }

    @Test
    public void testReadFruitFromXMLFile() {
    }

    @Test
    public void testGetFromTXTFile() {
    }

    @Test
    public void testSaveObjectInFile() {
    }
}