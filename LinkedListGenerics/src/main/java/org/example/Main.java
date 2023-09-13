package org.example;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> intArray = new LinkedList();
        intArray.add(78);
        intArray.add(90);
        intArray.add(100);
        intArray.add(34895);
//        System.out.println( intArray.get(0));
//        intArray.insertValueAtIndex(800, 0);
//        System.out.println( intArray.get(0));
//        intArray.replaceValueAtIndex(1000, 0);
//        System.out.println( intArray.get(0));
//        System.out.println( intArray.get(2));

        System.out.println( intArray.toString());
        Integer [] intTemplate = new Integer[intArray.getSize()];
        Integer [] intArray2 =  intArray.toArray(intTemplate);

        System.out.println("Below is array");

        for (Integer theInt : intArray2){
            System.out.println(theInt);
        }


        LinkedList<String> strArray = new LinkedList();
        strArray.add("A");
        strArray.add("B");
        strArray.add("C");
        strArray.add("D");
        strArray.add("E");
        strArray.add("F");
//        System.out.println( strArray.get(0));

        System.out.println( strArray.toString());
        String[] strTemplate = new String[strArray.getSize()];
        String [] strArray2 =  strArray.toArray(strTemplate);;
    System.out.println("Below is the string array");
        for (String theString : strArray2){
            System.out.println(theString);
        }
//        strArray.insertValueAtIndex("C", 0);
//        System.out.println( strArray.get(0));
//        System.out.println( strArray.get(2));
//        strArray.replaceValueAtIndex("Beginning", 0);
//        System.out.println( strArray.get(0));
//        System.out.println( strArray.get(2));




    }
}