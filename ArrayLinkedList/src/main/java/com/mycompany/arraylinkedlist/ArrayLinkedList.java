/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arraylinkedlist;

/**
 *
 * @author alexandrafranklin
 */
public class ArrayLinkedList {

    public static void main(String[] args) {
              LinkedList<Integer> intArray = new LinkedList();
        intArray.add(78);
        intArray.add(90);
        System.out.println( intArray.get(0));
//        intArray.insertValueAtIndex(800, 0);
//        System.out.println( intArray.get(0));
//        intArray.replaceValueAtIndex(1000, 0);
//        System.out.println( intArray.get(0));
//        System.out.println( intArray.get(2));

        System.out.println( intArray.toString());


        LinkedList<String> strArray = new LinkedList();
        strArray.add("A");
        strArray.add("B");
        System.out.println( strArray.get(0));
//        strArray.insertValueAtIndex("C", 0);
//        System.out.println( strArray.get(0));
//        System.out.println( strArray.get(2));
//        strArray.replaceValueAtIndex("Beginning", 0);
//        System.out.println( strArray.get(0));
//        System.out.println( strArray.get(2));

        System.out.println( strArray.toString());



    }
}
