/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.midtermdspristackgen;

/**
 *
 * @author alexandrafranklin
 */
public class MidtermDSPriStackGen {

    public static void main(String[] args) {
        
        PriorityStack<String> stack = new PriorityStack();
               
        
        stack.push("Steph");
        stack.push("Bob");
         stack.push("Alex", true);
        stack.push("Costa");
        stack.push("Lena");
      

        
//        String theString = stack.toString();
//        System.out.println(theString);
//        System.out.println(stack.pop());
        System.out.println(stack.toString());
        System.out.println(stack.popPriority());
        System.out.println(stack.toString());
       
        
        
        
        
        
        
        
        
    }
}
