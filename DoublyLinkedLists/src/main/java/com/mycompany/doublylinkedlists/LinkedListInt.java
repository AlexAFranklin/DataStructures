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
public class LinkedListInt implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            int[] theArray = toArray();
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public Integer next() {
                return theArray[index++];
            }
        };
    }

    private class Container {

        int value;
        Container previous;
        Container next;

    }

    Container start = null;
    Container end = null;
    int count = 0;

    public void add(int value) {
        Container newCon = new Container();
        newCon.value = value;

        if (count == 0) {
            start = newCon;
            end = newCon;
            count++;
            return;
        }
        Container current = start;
        Container previous = null;
        while (current != null) {
            previous = current;
            current = current.next;
        }
        newCon.previous = previous;
        previous.next = newCon;
        end = newCon;
        count++;
    }

    public int getSize() {
        return count;
    }

    public int get(int index) {

        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Not a valid index");
        }

        int midway = count / 2;

        if (index < midway) {
            Container current = start;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        } else {
            Container current = end;
            for (int i = count - 1; i > index; i--) {
                current = current.previous;
            }
            return current.value;
        }

    }

    public void replaceValueAtIndex(int value, int index) {

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

    public void insertValueAtIndex(int value, int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Not a valid index");
        }
        if (index == 0) {
            Container newCon = new Container();
            newCon.value = value;
            newCon.next = start;
            start = newCon;
            count++;
            return;
        }

        if (index == count) {
            add(value);
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
        Container newCon = new Container();
        newCon.value = value;
        current.previous.next = newCon;
        newCon.previous = current.previous;

        current.previous = newCon;
        newCon.next = current;
        count++;
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

    public boolean deleteByValue(int value) {

        if (start.value == value) {
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

        if (end.value == value) {
            end = end.previous;
            end.next = null;
            count--;
            return true;
        }

        Container current = start.next;

        while (current.next != null) {
            if (current.value == value) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                count--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int[] toArray() {
        int[] result = new int[count];
        Container current = start;
        for (int i = 0; i < count; i++) {
            result[i] = current.value;
            current = current.next;
        }
        return result;
    }
}
