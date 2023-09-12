package org.example;

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

    public LinkedListArrayOfStrings(int size){
        this.size = size;
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
        Container next = start;
        String result ="";

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                result = next.value;
            }
            next = next.next;
        }
        return result;
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
        while (container.next.value != null && !found) {
            if (container.next.value.equals(value)) {
                found = true;
                size--;
                if (container.next.next != null){
                    container.next = container.next.next;
                } else {
                    container.next = null;
                    end = container;
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
    Container next = start;

    for (int i = 0; i < size; i++) {
        newString.append(next.value).append(", ");
        next = next.next;

    }

    return newString.toString();

    } // comma-separated values list similar to: [5,8,11]

    public String[] toArray() {
        throw new RuntimeException();
    } // could be used for Unit testing
}
