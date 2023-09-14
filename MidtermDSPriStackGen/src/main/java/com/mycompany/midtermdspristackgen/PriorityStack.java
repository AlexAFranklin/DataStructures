/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.midtermdspristackgen;

import java.util.Iterator;



/**
 *
 * @author alexandrafranklin
 */
public class PriorityStack<T> implements Iterable{


    
    @Override
    public Iterator<T> iterator() {

// TODO - maybe figure out how to do this with array - seems hopeless. 
    return new Iterator<T>() {
    
     
        T[] theArray = (T[]) new Object[size];
        T[] iterationArray = toArrayReversed(theArray);
        int index = 0;


        @Override
        public boolean hasNext() {
            return (index < iterationArray.length);
        }

        @Override
        public T next() {
            return iterationArray[index++];
        }
    
        };
        
    }

    
        private class Container {

        T value;
        boolean hasPriority;
        Container nextBelow;
// you are NOT allowed to add "previousAbove" reference
    }
        
        
        

        
       private Container top;
       private int size;
       private T[] arrayTemplate;
//       private int reversedCount;
       
       

       
        public void push(T value, boolean hasPriority) {
            Container newContainer = new Container();
            newContainer.hasPriority = hasPriority;
            newContainer.value = (T) value;
            newContainer.nextBelow = top;
            top = newContainer;
            size++;
            
    }
        public void push(T value){
           push(value, false);
       }
        
         public T pop() {
             if (top == null){
                 throw new NoSuchElementException("There is nothing in the stack.");
             }
             Container popped = top;
             top = top.nextBelow;
             size--;
             return popped.value;
         }
         
         
         public T popPriority(){
             Container current = top;
             Container previous = new Container();
             if (top == null){
              throw new NoSuchElementException("There is nothing in the stack.");
             }
             
             if (current.hasPriority){
                 return pop();
             }
             for (int i = 0; i < size; i++){
                 if (current.hasPriority){
                     previous.nextBelow = current.nextBelow;
                     size--;
                    return current.value;
                 }
                 previous = current;
                 current = current.nextBelow;
             }
             return pop();
         }
        
         
         public int hasValue(T value){
             int increment = -1;
             Container current = top;
             for (int i = 0; i < size; i++){
                 if (value.equals(current.value)){
                     increment = i;
                     return increment;
                 }
                 current = current.nextBelow;
             }
             return increment;
         }
        
         public T removeValue(T value){
             if (top == null){
                 throw new NoSuchElementException("That value does not exist in the stack.");
             }
       
             if (top.value.equals(value) ){
                 T result = top.value;
                 top = top.nextBelow;
                 size--;
                 return result;
             }
             Container current = top;
             Container previous = new Container();
             for (int i = 0; i < size; i++){
                 if (value.equals(current.value)){
                    previous.nextBelow = current.nextBelow;
                     size--;
                     return current.value;
                 }
                 previous = current;
                 current = current.nextBelow;
             }
             throw new NoSuchElementException("That value does not exist in the stack.");
         }
        
         
         public void reorderByPriority() {
         PriorityStack noPriority = new PriorityStack();
         PriorityStack priority = new PriorityStack();
         Container current = top;
         for (int i = 0; i < size; i++){
             if (current.hasPriority) {
                 priority.push(current.value, true);
             } else {
                noPriority.push(current.value);
             }
             current = current.nextBelow;
            }
         
         PriorityStack newStack = new PriorityStack();
         current = noPriority.top;
         for (int i = 0; i < noPriority.size; i++){
             newStack.push(current.value);
             current = current.nextBelow;
         }
         current = priority.top;
         for (int i = 0; i < priority.size; i++){
           newStack.push(current.value, true);
           current = current.nextBelow;
         }
         top = newStack.top;
         
         
         }
 
        //TODO create toString method for cutom object. 
        @Override public String toString(){
            Container current = top;
            StringBuilder addString = new StringBuilder();
            addString.append("[");
            for (int i = 0; i < size; i++){
                addString.append(current.value.toString()).append(":");
                addString.append((current.hasPriority) ? "P" : "N");
                addString.append((i + 1 == size) ? "" : ",");
                current = current.nextBelow;
            }
            addString.append("]");
            return addString.toString();
        }
        
        public int getSize(){
            return size;
        }
        
        

       // I tried 
        
      public T[] toArrayReversed(T[] template) {
           int reversedCount = 0;
           if (top == null){
               return null;
           }

            return computeArray(reversedCount, template);
    } 
       
 
       private T[] computeArray(int reversedCount, T[] template){
            if (reversedCount == size) {
               return template;
           }
           Container current = top;
           for (int i = 0; i < size - reversedCount -1; i++) {
               current = current.nextBelow;
           }
           template[reversedCount++] = current.value;
           return computeArray(reversedCount, template);
       }
        

}