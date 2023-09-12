package org.example;

public class Main {
    public static void main(String[] args) {

        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int size = 0;
        for (int i = 0; i < 10; i++){
            array.add(String.valueOf(i));
            size++;
        }
        System.out.println(array.toString());
        String [] newArray = array.toArray();
        for (int i = 0; i < newArray.length; i++){
            System.out.println(newArray[i]);
        }

//        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
//        array.add("Zero");
//        array.add("One");
//        array.add("Two");
//        array.add("Three");
//        array.add("Four");
//        array.add("Five");
//        array.add("Six");
//        array.add("Seven");
//        System.out.println(array.toString());
//
//
//
//        try {
//            array.insertValueAtIndex("HELLO", 1);
//            System.out.println(array.toString());
//            System.out.println(array.get(1));
//            array.replaceValueAtIndex("TWO", 2);
//            System.out.println(array.toString());
//            array.replaceValueAtIndex("ZERO", 0);
//            System.out.println(array.toString());
//            array.replaceValueAtIndex("SEVEN", 7);
//            System.out.println(array.toString());
//            array.replaceValueAtIndex("TWO", 2);
//            array.insertValueAtIndex("start", 0);
//            System.out.println(array.toString());
//            array.insertValueAtIndex("10000", 7);
//            array.deleteByIndex(0);
//            System.out.println(array.toString());
//            array.replaceValueAtIndex("SIX", 6);
//            System.out.println(array.toString());
//            array.add("END");
//            System.out.println(array.toString());
//            System.out.println(array.getSize());
//            array.deleteByValue("Zero");
//            System.out.println(array.toString());
//            System.out.println(array.getSize());
//            array.deleteByValue("END");
//            System.out.println(array.toString());
//            System.out.println(array.getSize());
//            array.deleteByValue("One");
//            System.out.println(array.toString());
//            System.out.println(array.getSize());
//            array.deleteByValue("Four");
//            System.out.println(array.toString());
//            System.out.println(array.getSize());



//           System.out.println(array.toString());
//            System.out.println("final string: " +  array.get(array.getSize() - 1));
//            array.add("hello");
//            System.out.println("final string: " +  array.get(array.getSize() - 1));
//            System.out.println(array.toString());
//        } catch (IndexOutOfBoundsException iob) {
//            System.out.println(iob.getLocalizedMessage());
//        }


    }
}