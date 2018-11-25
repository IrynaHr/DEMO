package TestsToDEMO;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

public class PrintTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeMethod
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterMethod
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrint() {
//        arrange
        System.out.print("Fruit{name='apple', color='red'}");
//        act

//        assert
        assertEquals("Fruit{name='apple', color='red'}", outContent.toString());
    }
}