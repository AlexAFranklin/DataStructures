/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.finalroundqueue.RoundFIFOQueue;

/**
 *
 * @author alexandrafranklin
 */
public class RoundFIFOQueueTest {

    public class Pet implements Comparable {

        @Override
        public int compareTo(Object o) {
            Pet otherPet = (Pet) o;

            int nameComp = name.compareTo(otherPet.name);
            if (nameComp == 0) {
                return animal.compareTo(otherPet.animal);
            } else {
                return nameComp;
            }
        }

        private String name;
        private String animal;

        public Pet(String name, String animal) {
            this.name = name;
            this.animal = animal;
        }

        @Override
        public String toString() {
            return "Animal: " + animal + ", Name: " + name;
        }

    }

    public RoundFIFOQueueTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        RoundFIFOQueue<Integer> intFifo = new RoundFIFOQueue(4, new Integer[0]);
        RoundFIFOQueue<String> strFifo = new RoundFIFOQueue(4, new String[0]);
        RoundFIFOQueue<Pet> petFifo = new RoundFIFOQueue(4, new Pet[0]);

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void addingInts() {
        RoundFIFOQueue<Integer> intFifo = new RoundFIFOQueue(4, new Integer[0]);
        intFifo.enqueue(634, true);
        intFifo.enqueue(1234, true);
        intFifo.enqueue(2038, true);
        intFifo.enqueue(12, true);
        assertEquals(4, intFifo.size());
        assertThrows(RuntimeException.class, () -> {
            intFifo.enqueue(132, false);
        });
        intFifo.enqueue(101, true);
        assertEquals(5, intFifo.size());
        assertEquals(634, intFifo.dequeue());
        assertEquals(1234, intFifo.dequeue());
        intFifo.enqueue(800, true);
        intFifo.enqueue(387, true);
        assertThrows(RuntimeException.class, () -> {
            intFifo.enqueue(1000, false);
        });
        intFifo.enqueue(1000, true);
        assertEquals(6, intFifo.size());

    }

    @Test
    public void addingString() {
        RoundFIFOQueue<String> strFifo = new RoundFIFOQueue(3, new String[0]);
        strFifo.enqueue("Buffy", true);
        strFifo.enqueue("Xander", true);
        strFifo.enqueue("Giles", true);
        assertThrows(RuntimeException.class, () -> {
            strFifo.enqueue("Spike", false);
        });
        assertEquals(3, strFifo.size());
        int count = 0;
        for (String character : strFifo) {
            if (character != null) {
                count++;
            }
        }
        assertEquals(count, strFifo.size());

    }

    @Test
    void deleteInts() {
        RoundFIFOQueue<Integer> intFifo = new RoundFIFOQueue(4, new Integer[0]);
        assertThrows(RuntimeException.class, () -> {
            intFifo.dequeue();
        });
        intFifo.enqueue(384, true);
        intFifo.enqueue(342, true);
        intFifo.enqueue(42, true);
        intFifo.enqueue(100, true);
        int[] deleted = {384, 342, 42, 100};
        for (int i = 0; i < deleted.length; i++) {
            assertEquals(deleted[i], intFifo.dequeue());
        }
        assertEquals(0, intFifo.size());
        assertThrows(RuntimeException.class, () -> {
            intFifo.dequeue();
        });

    }

    @Test
    public void deleteString() {
        RoundFIFOQueue<String> strFifo = new RoundFIFOQueue(3, new String[0]);
        strFifo.enqueue("Buffy", true);
        strFifo.enqueue("Xander", true);
        strFifo.enqueue("Giles", true);
        assertEquals("Buffy", strFifo.dequeue());
        strFifo.enqueue("Willow", true);
        strFifo.enqueue("Tara", true);
        strFifo.enqueue("Anya", true);
        assertEquals("Xander", strFifo.dequeue());
        assertEquals(4, strFifo.size());
        String[] deleted = {"Giles", "Willow", "Tara", "Anya"};
        for (int i = 0; i < deleted.length; i++) {
            assertEquals(deleted[i], strFifo.dequeue());
        }
        assertEquals(0, strFifo.size());
        assertThrows(RuntimeException.class, () -> {
            strFifo.dequeue();
        });
        strFifo.enqueue("Buffy", true);
        strFifo.enqueue("Xander", true);
        strFifo.enqueue("Giles", true);
        assertEquals(3, strFifo.size());
        assertEquals("Buffy", strFifo.dequeue());
        assertEquals(2, strFifo.size());
        assertEquals("Xander", strFifo.dequeue());
        assertEquals(1, strFifo.size());
        assertEquals("Giles", strFifo.dequeue());
        assertEquals(0, strFifo.size());

    }

    @Test
    public void arrayOfInts() {
        RoundFIFOQueue<Integer> intFifo = new RoundFIFOQueue(4, new Integer[0]);
        intFifo.enqueue(874, true);
        intFifo.enqueue(354, true);
        intFifo.enqueue(342, true);
        intFifo.enqueue(734, true);
        intFifo.enqueue(237, true);
        intFifo.enqueue(186, true);
        intFifo.enqueue(349, true);
        intFifo.enqueue(10, true);
        int[] expected1 = {
            10, 349, 186, 237, 734, 342, 354, 874};
        Integer[] lifoArray = intFifo.toArray();
        int iterator = 0;
        for (Integer num : lifoArray) {
            assertEquals(expected1[iterator++], num);
        }
        iterator = 0;
        for (Integer num : intFifo) {
            assertEquals(expected1[iterator++], num);
        }
        intFifo.dequeue();
        intFifo.dequeue();
        intFifo.dequeue();
        intFifo.dequeue();
        intFifo.dequeue();
        int[] expected2 = {10, 349, 186};
        Integer[] lifoArray2 = intFifo.toArray();
        iterator = 0;
        for (Integer num : lifoArray2) {
            assertEquals(expected2[iterator++], num);
        }
        iterator = 0;
        for (Integer num : intFifo) {
            assertEquals(expected2[iterator++], num);
        }
    }
    
    @Test
    public void arrayOfStrings(){
        RoundFIFOQueue<String> strFifo = new RoundFIFOQueue(3, new String[0]);
        strFifo.enqueue("Buffy", true);
        strFifo.enqueue("Xander", true);
        strFifo.enqueue("Giles", true);
        assertEquals("Buffy", strFifo.dequeue());
        strFifo.enqueue("Willow", true);
        strFifo.enqueue("Tara", true);
        strFifo.enqueue("Anya", true);
    }

}
