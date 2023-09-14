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
        
                stack.push("Steve", true);
        stack.push("Bill");
         stack.push("Mark", true);
        stack.push("Aneka");
        stack.push("Luna", true);
      

        
//        String theString = stack.toString();
//        System.out.println(theString);
//        System.out.println(stack.pop());
        System.out.println(stack.toString());
       // System.out.println(stack.popPriority());
       // int value = stack.hasValue("Steph");
      //  System.out.println(stack.removeValue("Tim"));
      stack.reorderByPriority();
        System.out.println(stack.toString());
       
        
        
        
        
        
        
        
        
    }
}
