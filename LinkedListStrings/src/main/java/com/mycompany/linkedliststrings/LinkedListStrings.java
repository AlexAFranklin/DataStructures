/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.linkedliststrings;

/**
 *
 * @author alexandrafranklin
 */
public class LinkedListStrings {

    public static void main(String[] args) {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int size = 0;
        for (int i = 0; i < 10; i++){
            array.add(String.valueOf(i));
            size++;
        }
        System.out.println(array.toString());
        array.deleteByIndex(array.getSize()-1);
        System.out.println(array.toString());
        array.add("Alex");
         System.out.println(array.toString());
 

    }
}
