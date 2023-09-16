/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarysearchtree;

/**
 *
 * @author alexandrafranklin
 */
public class Tree {
    
    private class Container {
        int key;
        Container right;
        Container left;
    }
    
    Container head;

    
    public void insertValue(int newKey) {
        if (head == null){
            Container newInsert = new Container();
            newInsert.key = newKey;
            head = newInsert;
            return;
        }
       
        computeInsert(newKey, head);
        
    }
    
    private Container computeInsert(int newKey, Container current){  
        if (current == null){
            Container newInsert = new Container();
            newInsert.key = newKey;        
            return newInsert;
            
        }
        if (current.key >= newKey) {
            current.left = computeInsert(newKey, current.left);
            System.out.println("left");
        } else {
            current.right = computeInsert(newKey, current.right);
             System.out.println("right");
        }
        return current;    
    }
    
}
