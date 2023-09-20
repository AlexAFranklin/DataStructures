/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.binarytreekeyvalue.TreeKeyValue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author alexandrafranklin
 */
public class KeyValueStringIntTest {

    public KeyValueStringIntTest() {

    }
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testPutAndSize() {
        TreeKeyValue bts = new TreeKeyValue();
        assertEquals(0, bts.getSize());
        bts.put("Alex", 30);
        bts.put("Tim", 61);
        bts.put("Sharon", 60);
        bts.put("Stephanie", 30);
        assertEquals(4, bts.getSize());
        bts.put("Alex", 31);
        bts.put("Tim", 62);
        bts.put("Sharon", 61);
        bts.put("Stephanie", 31);
        assertEquals(4, bts.getSize());
    }

    @Test
    public void testKeyGet() {
        TreeKeyValue bts = new TreeKeyValue();
        bts.put("Alex", 30);
        bts.put("Tim", 61);
        bts.put("Sharon", 60);
        bts.put("Stephanie", 30);
        assertEquals(30, bts.getValByKey("Alex"));
        assertEquals(30, bts.getValByKey("Stephanie"));
        assertEquals(60, bts.getValByKey("Sharon"));
        assertEquals(61, bts.getValByKey("Tim"));
        bts.put("Alex", 31);
        bts.put("Tim", 62);
        bts.put("Sharon", 61);
        bts.put("Stephanie", 31);
        assertEquals(31, bts.getValByKey("Alex"));
        assertEquals(31, bts.getValByKey("Stephanie"));
        assertEquals(61, bts.getValByKey("Sharon"));
        assertEquals(62, bts.getValByKey("Tim"));

    }

    @Test
    public void printOut() {

    TreeKeyValue bts = new TreeKeyValue();

    bts.put ("Alex", 30);
    bts.put ("Tim", 61);
    bts.put ("Sharon", 60);
    bts.put ("Stephanie", 30);
        
    bts.printValuesInOrder ();

    assertEquals("""
                 Key => Alex, Value => 30
                 Key => Sharon, Value => 60
                 Key => Stephanie, Value => 30
                 Key => Tim, Value => 61""", outputStreamCaptor.toString().trim());
}
}
