public class CustomArrayOfInts {
    private int [] data = new int[2]; // only grows by doubling size, never shrinks
    private int size = 0; // how many items do you really have

    public int size() {
        return size;
    }
    public void add(int value) {
        if (size == data.length) {
             int [] tempData = new int[data.length * 2];
            for (int i = 0; i < size; i++) {
                tempData[i] = data[i];
            }
            data = tempData;
        }
        data[size] = value;
        size++;
    }
    public void deleteByIndex(int index) {

        if (index >= size || index < 0) {
            return;
        }
        size--;
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        data[size] = 0;

        if (data.length/2 >= size) {
            int [] tempData = new int[data.length / 2];
            for (int i = 0; i < size; i++) {
                tempData[i] = data[i];
            }
            data = tempData;
        }

    }
    public boolean deleteByValue(int value) {
        int loop = 0;
        boolean match = false;

        while (loop < size && !match) {
            if (value == data[loop]) {
                deleteByIndex(loop);
                match = true;
            }
            loop++;
        }
        return match;
    }


    public void insertValueAtIndex(int value, int index) {
        if (index > size || index < 0) {
            return;
        }
        if (index == size) {
            add(value);
            return;
        }

        if (size == data.length) {
            int [] tempData = new int[data.length * 2];
            for (int i = 0; i < size; i++) {
                tempData[i] = data[i];
            }
            data = tempData;
        }
        size++;

        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;

    }
    public void clear() {
        size = 0;
        data =  new int[2];
    }
    public int get(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("That index does not exist in this array");
        }
        return data[index];
    }
    public int[] getSlice(int startIdx, int length) {
        if (startIdx + length > size) {
            throw new ArrayIndexOutOfBoundsException("Selection exceeds the length of the array.");
        }
        if (startIdx < 0) {
            throw new IndexOutOfBoundsException("That index does not exist in this array");
        }
        int[] slice = new int[length];
        for (int i = 0; i < length; i++) {
            slice[i] = data[startIdx++];
        }
        return slice;
    }

    @Override
    public String toString() {
        return "";
    } // returns String similar to: [3, 5, 6, -23]

    public void printArray() {
        for (int i = 0; i < size; i++) {
            String comma = (1 + i == size) ? "\n" : ",";
            System.out.print(data[i] + comma + " ");
        }
    }
}
