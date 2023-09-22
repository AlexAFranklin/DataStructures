/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doublylinkedlists;

import java.util.Iterator;

/**
 *
 * @author alexandrafranklin
 */
public class VisitableLinkedList<V> implements Iterable<V> {
    Visitor<Container> visitor;
    
    public void  setVisitor(Visitor<Container> visitor){
        this.visitor = visitor;
    }
    
    public void travsereAllToVisit(){
        Container current = start;
        while(current != null){
            visitor.visit(current);
            current = current.next;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            
            V[] theArray = toArray();
            int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public V next() {
                return theArray[index++];
            }

        };
    }

    public class Container {

        V value;
        Container previous;
        Container next;

    }

    Container start = null;
    Container end = null;
    int count = 0;
    V[] template;

    public VisitableLinkedList(V[] template) {
        this.template = template;
    }

    public void add(V value) {
        Container newCon = new Container();
        newCon.value = value;

        if (count == 0) {
            start = newCon;
            end = newCon;
            count++;
            return;
        }

        newCon.previous = end;
        end.next = newCon;
        end = newCon;
        count++;

    }

    public V get(int index) {

        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Not a valid index");
        }

        int midway = count / 2;
        Container current = null;
        if (index < midway) {
            current = start;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = end;
            for (int i = count - 1; i > index; i--) {
                current = current.previous;
            }

        }
        return current.value;
    }

    public void replaceValueAtIndex(V value, int index) {

        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Not a valid index");
        }

        int midway = count / 2;
        Container current = null;

        if (index < midway) {
            current = start;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = end;
            for (int i = count - 1; i > index; i--) {
                current = current.previous;
            }
        }
        current.value = value;

    }

    public void deleteByIndex(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            if (count == 1) {
                start = null;
                end = null;
                count = 0;
                return;
            }
            start = start.next;
            start.previous = null;
            count--;
            return;
        }

        if (index == count - 1) {
            end = end.previous;
            end.next = null;
            count--;
            return;
        }
        double midway = count / 2;
        Container current = null;

        if ((double) index < midway) {
            current = start;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

        } else {
            current = end;
            for (int i = count - 1; i > index; i--) {
                current = current.previous;
            }
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
        count--;
    }

    public String toString() {
        StringBuilder newString = new StringBuilder();
        newString.append("[");
        Container next = start;

        for (int i = 0; i < count; i++) {
            newString.append(next.value).append((next == end) ? "]" : ", ");
            next = next.next;

        }

        return newString.toString();
    }

    public String toStringReverse() {
        StringBuilder newString = new StringBuilder();
        newString.append("[");
        Container next = end;

        for (int i = count - 1; i >= 0; i--) {
            newString.append(next.value).append((next == start) ? "]" : ", ");
            next = next.previous;

        }

        return newString.toString();
    }

    public boolean deleteByValue(V value) {

        if (start.value.equals(value)) {
            if (count == 1) {
                start = null;
                end = null;
                count = 0;
                return true;
            }
            start = start.next;
            start.previous = null;
            count--;
            return true;
        }

        if (end.value.equals(value)) {
            end = end.previous;
            end.next = null;
            count--;
            return true;
        }

        Container current = start.next;

        while (current.next != null) {
            if (current.value.equals(value)) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                count--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public V[] toArray() {
        V[] result = (V[]) java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), count);
        Container current = start;
        for (int i = 0; i < count; i++) {
            result[i] = current.value;
            current = current.next;
        }
        return result;
    }
}
