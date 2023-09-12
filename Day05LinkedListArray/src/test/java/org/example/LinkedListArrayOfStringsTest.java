package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListArrayOfStringsTest {

    @Test
    void add() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int size = 0;
        for (int i = 0; i < 100; i++){
            array.add("Add " + i);
            size++;
        }
        assertEquals(size, array.getSize());
    }

    @Test
    void get() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        array.add("hello");
        array.add("my");
        array.add("name");
        array.add("is");
        array.add("Alex");
        assertEquals("Alex", array.get(4));
    }

    @Test
    void getTo0Big() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        array.add("hello");
        array.add("my");
        array.add("name");
        array.add("is");
        array.add("Alex");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.get(5);
        });
    }
    @Test
    void getOutOfBoundsNegative() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        array.add("hello");
        array.add("my");
        array.add("name");
        array.add("is");
        array.add("Alex");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.get(-5);
        });
    }

    @Test
    void insertValueAtIndex() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        array.add("Hello");
        array.add("World");
        array.insertValueAtIndex("There", 1);
        assertEquals("There", array.get(1));
    }
    @Test
    void insertValueAtIndexEnd() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        array.add("Hello");
        array.add("World");
        array.insertValueAtIndex("My name is Alex.", (array.getSize()));
        assertEquals("My name is Alex.", array.get(array.getSize()-1));
    }

    @Test
    void insertValueAtIndexStart() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        array.add("Hello");
        array.add("World");
        array.insertValueAtIndex("HOWDY", 0);
        assertEquals("HOWDY", array.get(0));
    }

    @Test
    void insertValueAtIndexStartLastIndex() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        array.add("Hello");
        array.add("World");
        array.insertValueAtIndex("HOWDY", 0);
        assertEquals("World", array.get(array.getSize() - 1));
    }

    @Test
    void insertValueAtIndexNegative() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        for (int i = 0; i < 10; i++){
            array.add("Add " + i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.insertValueAtIndex("out of bounds", -1);
        });
    }

    @Test
    void insertValueAtIndexTooBig() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        for (int i = 0; i < 10; i++){
            array.add("Add " + i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.insertValueAtIndex("out of bounds", array.getSize() + 1);
        });
    }


    @Test
    void insertValueEnd() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int size = 0;
        for (int i = 0; i < 10; i++){
            size++;
            array.add(String.valueOf(size));
        }
        array.replaceValueAtIndex("TWO", 2);
        assertEquals(String.valueOf(size), array.get(array.getSize() -1));
    }

    @Test
    void replaceValueAtIndexEnd() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        for (int i = 0; i < 10; i++){
            array.add("hi");
        }
        array.replaceValueAtIndex("hello", 9);
        assertEquals("hello", array.get(9));
    }

    @Test
    void replaceValueAtIndexEndSizeChange() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int size = 0;
        for (int i = 0; i < 10; i++){
            array.add("hi");
            size++;
        }
        array.replaceValueAtIndex("hello", 9);
        array.replaceValueAtIndex("howdy", 0);
        array.replaceValueAtIndex("bonjour", 5);

        assertEquals(size, array.getSize());
    }

    @Test
    void replaceValueIndexTooBig() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int size = 0;
        for (int i = 0; i < 10; i++){
            array.add("hi");
            size++;
        }
        int theSize = size;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.replaceValueAtIndex("OUT OF BOUNDS", theSize);
        });
    }

    @Test
    void replaceValueIndexNegative() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        for (int i = 0; i < 10; i++){
            array.add("hi");
        }
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.replaceValueAtIndex("OUT OF BOUNDS", -1);
        });
    }

    @Test
    void deleteByIndexEnd() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int index = -1;
        for (int i = 0; i < 10; i++){
            index++;
            array.add(String.valueOf(index));
        }
        array.deleteByIndex(index--);
        assertEquals(String.valueOf(index), array.get(index));
    }

    @Test
    void deleteByIndexZero() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        for (int i = 0; i < 10; i++){
            array.add(String.valueOf(i));
        }
        array.deleteByIndex(0);
        assertEquals("1" , array.get(0));
    }

    @Test
    void deleteByIndexNegative() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        for (int i = 0; i < 10; i++){
            array.add(String.valueOf(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.deleteByIndex(-1);
        });
    }

    @Test
    void deleteByIndexTooLarge() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int index = 0;
        for (int i = 0; i < 10; i++){
            index++;
            array.add(String.valueOf(index));
        }
       int finalIndex = index;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.deleteByIndex(finalIndex);
        });
    }


    @Test
    void deleteByValueZero() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int index = -1;
        for (int i = 0; i < 10; i++){
            index++;
            array.add(String.valueOf(index));
        }
        array.deleteByValue("0");
        assertEquals("1" , array.get(0));
    }
    @Test
    void deleteByValueEndChange() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int index = -1;
        for (int i = 0; i < 10; i++){
            index++;
            array.add(String.valueOf(index));
        }
        array.deleteByValue(String.valueOf(index));
        array.add("the end");
        assertEquals("the end", array.get(index));
    }

    @Test
    void deleteByValueEnd() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int index = -1;
        for (int i = 0; i < 10; i++){
            index++;
            array.add(String.valueOf(index));
        }
        array.deleteByValue(String.valueOf(index--));
        assertEquals(String.valueOf(index), array.get(index));
    }

    @Test
    void deleteByValueTooBig() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int index = 0;
        for (int i = 0; i < 10; i++){
            index++;
            array.add(String.valueOf(i));
        }
        assertFalse(array.deleteByValue(String.valueOf(index)));
    }
    @Test
    void getSizeZero() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        assertEquals(0, array.getSize());
    }

    @Test
    void getSize100() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int size = 0;
        for (int i = 0; i < 100; i++){
            array.add("Add " + i);
            size++;
        }
        assertEquals(size, array.getSize());
    }

    @Test
    void getSizeBuildDelete() {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int size = 0;
        for (int i = 0; i < 10; i++){
            array.add("Add " + i);
            size++;
        }
        array.deleteByValue("Add 7");
        array.deleteByIndex(0);
        array.deleteByIndex(array.getSize() -1);
        array.add("the end");
        assertEquals(size - (3 - 1), array.getSize());
    }



    @Test
    void testToString() {
    }

    @Test
    void toArray() {
    }
}