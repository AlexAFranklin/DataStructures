/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linkedliststrings;

/**
 *
 * @author alexandrafranklin
 */
public class LinkedListArrayOfStrings {
   
    private static class Container {
        Container next;
        String value;
    }

    private Container start;
    private Container end;

    public LinkedListArrayOfStrings(){
        size = 0;
    }


    private int size;

    public void add(String value) {
        Container newContainer = new Container();
        newContainer.next = null;
        newContainer.value = value;

        if (size == 0) {
            start = newContainer;
        } else {
            end.next = newContainer;
        }
        end = newContainer;
        size ++;

    }
    public String get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Not a valid index");
        }
        Container current = start;
       

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return current.value;
            }
            current = current.next;
        }
       return null;
    }
    public void insertValueAtIndex(String value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Not a valid index");
        }
        if (index == size) {
            add(value);
            return;
        }
        size++;
        Container newContainer = new Container();
        newContainer.value = value;
        Container next = start;
        if (index == 0) {
            newContainer.next = start;
            start = newContainer;
            return;
        }

        for (int i = 0; i < index; i++) {
            if (i + 1 == index) {
                newContainer.next = next.next;
                next.next = newContainer;
            }
           next = next.next;
        }

    }
    public void replaceValueAtIndex(String value, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Container next = start;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                next.value =value;
            }
            next = next.next;
        }

    } // put


    public void deleteByIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            start = start.next;
            size--;
            return;
        }
        // TODO write if size was 1. 
        

        Container nextContainer = start;
        for (int i = 0; i < index; i++) {
            if (i + 1 == index) {
                nextContainer.next = nextContainer.next.next;
                if (index + 1 == size) {
                    end = nextContainer;
                }
            }

            nextContainer = nextContainer.next;

        }
        size--;
    }
    public boolean deleteByValue(String value) {
        Container container = start;

        if (container.value.equals(value)){
            start = start.next;
            size--;
            return true;
        }

        boolean found = false;
        while (container.next != null && !found) {
            if (container.next.value.equals(value)) {
                found = true;
                size--;

                if (container.next == end){
                    end = container;
                    container.next = null;

                } else {
                    container.next = container.next.next;
                }
                return found;
            }
            container = container.next;
        }

        return found;
    } // delete first value found
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
    StringBuilder newString = new StringBuilder();
    newString.append("[");
    Container next = start;

    for (int i = 0; i < size; i++) {
        newString.append(next.value).append((next == end) ? "]" : ", ");
        next = next.next;

    }

    return newString.toString();

    } // comma-separated values list similar to: [5,8,11]

    public String[] toArray() {
        String [] strArray = new String[size];
        Container next = start;

        for (int i = 0; i < size; i++){
            strArray[i] = next.value;
            next = next.next;
        }

        return strArray;
    } // could be used for Unit testing
    
}
