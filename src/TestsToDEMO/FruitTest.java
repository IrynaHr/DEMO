package TestsToDEMO;

import com.company.Citrus;
import com.company.Fruit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class FruitTest {

    @BeforeMethod
    public static List<Fruit> getFruits() {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("apple", "yellow"));
        fruits.add(new Fruit("cherry", "black"));
        fruits.add(new Fruit("banana", "yellow"));

        return fruits;
    }

    @Test
    public void testGetYellow() {
        //arrange
        List<Fruit> fruits = getFruits();

        //act
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("apple", "yellow"));
        expected.add(new Fruit("banana", "yellow"));

        //assert
        assertEquals(Fruit.getYellowFruit(fruits), expected);
    }

    @Test
    public void testInput() {
//      arrange
        Fruit actual = new Fruit();
        Fruit expected = new Fruit("apple", "red");

//      act
        System.setIn(new StringBufferInputStream("apple red"));
        actual.input();

//      assert
        assertEquals(actual, expected);
    }

    @Test
    public void testSort() {
//    arrange
        List<Fruit> actual = getFruits();
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("apple", "yellow"));
        expected.add(new Fruit("banana", "yellow"));
        expected.add(new Fruit("cherry", "black"));

//    act

//    assert
        assertEquals(Fruit.sort(actual), expected);
    }

    @Test
    public void testSaveFruitInXMLFile() {
//    arrange
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("banana", "yellow"));
        expected.add(new Fruit("apple", "green"));
        expected.add(new Fruit("grape", "red"));

//    act
        try {
            Fruit.saveFruitInXMLFile(expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Fruit> actual = new ArrayList<>();
        try {
            actual.addAll(Fruit.readFruitFromXMLFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

//    assert
        assertEquals(actual, expected);
    }
}