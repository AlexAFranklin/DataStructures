package org.example;

import java.lang.reflect.Array;
import java.util.Objects;

public class LinkedList<T> {



    private class Container {
        Container next;
        T value;
    }

    private Container start;
    private Container end;

    public LinkedList(){
        size = 0;
    }
    private int size;

    public void add(T value) {
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
    public int getSize() {
        return size;
    }

    public <T> Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Not a valid index");
        }
        Container next = start;
        T result = (T) next.value;

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                result = (T) next.value;
            }
            next = next.next;
        }
        return result;
    }

    public void insertValueAtIndex(T value, int index) {
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

    public void replaceValueAtIndex(T value, int index) {
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

    public boolean deleteByValue(T value) {
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

    }

    class LinkedListArray<T> {
        private T[] genArray;
        public final int length;

        LinkedListArray(Class<T> tClass, int size) {
            genArray = (T[]) Array.newInstance(tClass, size);
            length = size;
        }

        public T get(int index){
            return genArray[index];
        }

        public void set(int index, T element){
            genArray[index] = element;
        }

    }

    public T[] toArray(T[] template) {

        Container next = start;
            for (int i = 0; i < size; i++){
            template[i] = next.value;
            next = next.next;
        }

            return template;
    } // could be used for Unit testing



}
