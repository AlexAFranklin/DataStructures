package com.mycompany.finalroundqueue;

import java.util.Iterator;

public class RoundFIFOQueue<T extends Comparable> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            T[] theArray = toArray();
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return theArray[index++];
            }

        };
    }


    private class Node {

        T value;
        Node next;
        int debugId; // optional, for debugging only
    }

    private Node enqueue;
    Node dequeue;
    Node previousEnqueue;
    int size;
    int maxSize; // maxSize will never change once assigned in the constructor
    T[] template;

    public RoundFIFOQueue(int maxSize, T[] template) {
        this.maxSize = maxSize;
        this.template = template;
        size = 0;

        Node current = new Node();
        current.debugId = 0;
        enqueue = current;
        dequeue = current;

        for (int i = 1; i < maxSize; i++) {
            Node newNode = new Node();
            newNode.debugId = i;
            current.next = newNode;
            current = newNode;
        }

        current.next = enqueue;

    }

    public void printQueue() {

        Node current = enqueue;
        for (int i = 0; i <= maxSize; i++) {
            System.out.println("Node: " + current.debugId + " Value: " + current.value);
            if (current.next == null) {
                throw new RuntimeException("Internal error: queue may not be circular");
            }
            current = current.next;
        }

    }

    public void enqueue(T value, boolean grow) {
        if (size == maxSize) {
            if (grow) {
                Node newNode = new Node();
                newNode.debugId = size;
                previousEnqueue.next = newNode;
                newNode.next = enqueue;
                enqueue = newNode;
                maxSize++;
            } else {
                throw new RuntimeException("No space in the queue");
            }
        }
        previousEnqueue = enqueue;
        Node current = enqueue;
        current.value = value;
        size++;
        enqueue = current.next;
    }

    public T dequeue() {
        if (size == 0){
            throw new RuntimeException("The queue is empty");
        }
       
        T returnVal = dequeue.value;
        dequeue.value = null;
        dequeue = dequeue.next;
        size--;
        return returnVal;
        
    }
    
    public int size(){
        return size;
    }
    
    public T[] toArray() { 
        T[] result = (T[]) java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), size);
        Node current = dequeue;
        for (int i = 0; i < size; i++){
            result[size - 1 - i] = current.value;
            current = current.next;
        }
        return result;
    }
    
    public int countValues(T value) { 
        int found = 0;
        Node current = enqueue.next;
        for (int i = 0; i < size; i++){
            if (current.value.compareTo(value) == 0) found++;
            current = current.next;
        }
        return found;
    }

}
