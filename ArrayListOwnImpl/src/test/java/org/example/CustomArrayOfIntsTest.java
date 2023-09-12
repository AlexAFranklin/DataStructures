package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayOfIntsTest {

    @Test
    void add() {
        CustomArrayOfInts array = new CustomArrayOfInts();
        array.add(3);
        array.add(5);
        array.add(7);
        assertEquals(7, array.get(2));

    }
    @Test
    void add2() {
        CustomArrayOfInts array = new CustomArrayOfInts();
        array.add(3);
        array.add(5);
        array.add(7);
        assertEquals(5, array.get(1));
    }

    @Test
    void sizeTest() {
        CustomArrayOfInts array = new CustomArrayOfInts();
        int size = 0;
        for (int i = 0; i < 10; i++) {
            array.add(i);
            size++;
        }
        assertEquals(size, array.size());

    }

    @Test
    void deleteByIndex() {
        CustomArrayOfInts array = new CustomArrayOfInts();
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        array.deleteByIndex(8);
        assertEquals(9, array.get(8));
    }

    @Test
    void deleteByIndexOutOfBounds() {
        CustomArrayOfInts array = new CustomArrayOfInts();
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        array.deleteByIndex(10);
        assertEquals(8, array.get(8));
    }

    @Test
    void deleteByValueBoolean() {
        CustomArrayOfInts array = new CustomArrayOfInts();
        for (int i = 0; i < 10; i++) {
            array.add(i + 10);
        }
        assertFalse(array.deleteByValue(8));
    }

    @Test
    void deleteByValueBooleanTrue() {
        CustomArrayOfInts array = new CustomArrayOfInts();
        for (int i = 0; i < 10; i++) {
            array.add(i + 10);
        }
        assertTrue(array.deleteByValue(12));
    }

    @Test
    void deleteByValue() {
        CustomArrayOfInts array = new CustomArrayOfInts();
        for (int i = 0; i < 10; i++) {
            array.add(i + 10);
        }
        array.deleteByValue(10);
        assertEquals(11, array.get(0));
    }

    @Test
    void deleteByValueSize() {
        CustomArrayOfInts array = new CustomArrayOfInts();
        int size =0;
        for (int i = 0; i < 10; i++) {
            array.add(i + 10);
            size ++;
        }
        array.deleteByValue(10);
        assertEquals(size-1, array.size());
    }

    @Test
    void insertValueAtIndexSize() {
        CustomArrayOfInts array = new CustomArrayOfInts();
        int size =0;
        for (int i = 0; i < 10; i++) {
            array.add(i);
            size ++;
        }
        array.insertValueAtIndex(5, 4);
        assertEquals(size + 1, array.size());
    }

    @Test
    void sizeFalse() {
        CustomArrayOfInts array = new CustomArrayOfInts();
        int size =0;
        for (int i = 0; i < 10; i++) {
            array.add(i);
            size ++;
        }
        array.add(5);
        assertEquals(size, array.size());
    }

    @Test
    void clear() {
    }

    @Test
    void get() {
    }

    @Test
    void getSlice() {
    }

    @Test
    void testToString() {
    }

    @Test
    void printArray() {
    }
}