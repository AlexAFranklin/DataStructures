package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    static class Pets {
        String name;
        int age;
        String animal;

        public Pets(String name, int age, String animal){
            this.name = name;
            this.age = age;
            this.animal = animal;
        }


    }


    static LinkedList<String> strList = new LinkedList();
    static LinkedList<Integer> intList = new LinkedList();
    static LinkedList<Pets> petList = new LinkedList();

    static String [] strArr = {
            "Dogs",
            "Cats",
            "Guinea Pigs",
            "Budgies",
            "Rats",
            "Hamsters",
            "Ferrets",
            "Snakes",
            "Fish"
    };

    static Integer [] intArray = {
            2343,
            34652,
            10001,
            23,
            -234,
            -24,
            0,
            80008
    };

    static Pets harold = new Pets("Harold", 5, "cat");
    static Pets pete = new Pets("Pete", 2, "dog");
    static Pets stimpy = new Pets("Stimpy", 10, "cat");
    static Pets edgar = new Pets("Edgar", 1, "hamster");
    static Pets eeyore = new Pets("Eeyore", 1, "rat");

    static Pets [] thePets = {
            harold,
            pete,
            stimpy,
            edgar,
            eeyore
    };
    @BeforeAll
    static public void createArrays() {


        for (String animal : strArr){
            strList.add(animal);
        }

        for (Integer numbers : intArray){
            intList.add(numbers);
        }

        for (Pets pet : thePets){
            petList.add(pet);
        }

    }


    @Test
    void addInts() {
        LinkedList<Integer> addIntList = new LinkedList();
        addIntList.add(4564);
        assertEquals(4564, addIntList.get(0));
        assertEquals(1, addIntList.getSize());
        addIntList.clear();
        assertEquals(0,addIntList.getSize());
        addIntList.add(1000000);
        assertEquals(1000000, addIntList.get(0));
    }

    @Test
    void addPets() {
        Pets bob = new Pets("Bob", 8, "cat");
        petList.add(bob);
        Pets copy = (Pets) petList.get(petList.getSize() - 1);
        assertEquals(8, copy.age);
        assertEquals("Bob", copy.name);

    }

    @Test
    void getSize() {
        assertEquals(intArray.length, intList.getSize());
        assertEquals(strArr.length, strList.getSize());
        assertEquals(thePets.length, petList.getSize());
        Pets bob = new Pets("Bob", 8, "cat");
        petList.add(bob);
        assertEquals(thePets.length, petList.getSize() -1);
        petList.deleteByIndex(0);
        assertEquals(thePets.length, petList.getSize());
        petList.add(bob);
        assertEquals(thePets.length, petList.getSize() -1);
        petList.deleteByValue(bob);
        assertEquals(thePets.length, petList.getSize());

    }

    @Test
    void get() {
       Pets copy = (Pets) petList.get(0);
       assertEquals(thePets[0].name, copy.name);
       assertEquals(strArr[strArr.length-1], strList.get(strList.getSize()-1));
       assertEquals(80008, intList.get(7));


    }

    @Test
    void insertValueAtIndex() {
        Pets bob = new Pets("Bob", 8, "cat");
        petList.insertValueAtIndex(bob, 0);
        Pets copy = (Pets) petList.get(0);
        assertEquals("Bob", copy.name);

        int newIndex = petList.getSize();
        Pets zoe = new Pets("Zoe", 18, "cat");
        petList.insertValueAtIndex(zoe, newIndex);
        assertEquals(zoe, petList.get(newIndex));

        Pets alex = new Pets("Alex", 2, "chinchilla");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            petList.insertValueAtIndex(alex, petList.getSize() + 1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            petList.insertValueAtIndex(alex, -1);
        });



    }

    @Test
    void replaceValueAtIndex() {
        int originalSize = petList.getSize();
        Pets zoe = new Pets("Zoe", 18, "cat");
        petList.replaceValueAtIndex(zoe, petList.getSize() - 1);
        assertEquals(originalSize, petList.getSize());
        assertEquals(zoe, petList.get(petList.getSize()-1));

        Pets bob = new Pets("Bob", 8, "cat");
        petList.replaceValueAtIndex(bob, 0);
        assertEquals(originalSize, petList.getSize());
        assertEquals(bob, petList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            petList.replaceValueAtIndex(zoe, petList.getSize());
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            petList.insertValueAtIndex(bob, -1);
        });


    }

    @Test
    void deleteByIndex() {
        int originalSize = petList.getSize();
        petList.deleteByIndex(originalSize-1);
        assertEquals(originalSize-1, petList.getSize());
        petList.deleteByIndex(0);
        assertEquals(pete, petList.get(0));
        assertEquals(originalSize-2, petList.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            petList.deleteByIndex(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            petList.deleteByIndex(petList.getSize());
        });

    }

    @Test
    void deleteByValue() {
        int originalSize = petList.getSize();
        Pets bob = new Pets("Bob", 8, "cat");
        petList.deleteByValue(bob);
        assertEquals(originalSize, petList.getSize());
        petList.deleteByValue(eeyore);
        assertEquals(originalSize - 1, petList.getSize());
        assertEquals(edgar, petList.get(petList.getSize()-1));
        petList.deleteByValue((Pets) petList.get(0));
        assertEquals(pete, petList.get(0));
        assertEquals(originalSize - 2, petList.getSize());

    }

    @Test
    void testToString() {
        LinkedList<String> strPets = new LinkedList();
        for (int i = 0; i < petList.getSize(); i++){
            Pets pet = (Pets) petList.get(i);
            strPets.add(pet.name);
        }
        assertEquals("[Harold, Pete, Stimpy, Edgar, Eeyore]", strPets.toString());
        assertEquals("[2343, 34652, 10001, 23, -234, -24, 0, 80008]", intList.toString());
        assertEquals("[Dogs, Cats, Guinea Pigs, Budgies, Rats, Hamsters, Ferrets, Snakes, Fish]", strList.toString());

    }

    @Test
    void toArray() {
    }
}