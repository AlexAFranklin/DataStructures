public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int[][] data2D = {
                {1, 3, 6, 8},
                {7, 1, 2, 3},
                {8, 3, 2, 1},
                {1, 7, 1, 9},
        };

        // System.out.println(getIfExists(data2D, 0, 4));
        // print2D(data2D);
//        duplicateJaggedArray(data2D);
//        smallestSum(data2D);
   // sumOfCross(data2D, 3, 3);

//        print2D(data2D);
//        print2D(data2DSums(data2D));

    }

//    static int getIfExists(int[][] data, int row, int col){
//        if (data.length >= row + 1 && row >= 0) {
//            if(data[row].length >= col + 1 && col >=0){
//                return data[row][col];
//            }
//        }
//        return 0;
//    }
        static int getIfExists(int[][] data, int row, int col){
        try {
            return data[row][col];
        } catch (IndexOutOfBoundsException iob) {
            return 0;
        }
    }

    // - also try/catch - avoid ifs.
    // performance vs. clean code - does not really matter (performance)
    // we only fix performance when it becomes an issue. - not before.

    static int sumOfCross(int[][] data, int row, int col){
        int sum = 0;
        sum += 2 * getIfExists(data, row, col);
        sum += getIfExists(data, row + 1, col);
        sum += getIfExists(data, row -1, col);
        sum += getIfExists(data, row, col + 1);
        sum += getIfExists(data, row, col - 1);
        return sum;
    }

    static void print2D(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                String comma = (1 + j == data[i].length) ? "\n" : ", ";
                System.out.print(data[i][j] + comma);
            }
        }
    }

    static int[][] duplicateJaggedArray(int [][] orig2d) {
        int duplicate2d[][] = new int[orig2d.length][];
        for (int i = 0; i < duplicate2d.length; i++) {
            duplicate2d[i] = new int[orig2d[i].length];
        }
        return duplicate2d;
    }

    static int[] smallestSum(int[][] data) {
        int[] smallestLocation = {0,0};
        int smallestInt = sumOfCross(data, 0, 0);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int newInt = sumOfCross(data, i, j);
                if (newInt < smallestInt) {
                    smallestLocation[0] = i;
                    smallestLocation[1] = j;
                    smallestInt = newInt;
                }
            }
        }
        return smallestLocation;
    }
    // return 3 length array (val, row, col) = or could make a return class for different data types.

    // Integer.MAX_VALUE = max value that Java can express. Alternative to minimum. (reverse exists too)

    static int[][] data2DSums(int[][] data) {
        int duplicate2d[][] = new int[data.length][];
        for (int i = 0; i < duplicate2d.length; i++) {
            duplicate2d[i] = new int[data[i].length];
        }
        for (int i = 0; i < duplicate2d.length; i++) {
            for (int j = 0; j < duplicate2d[i].length; j++) {
                duplicate2d[i][j] = sumOfCross(data, i, j);
            }
        }
        return duplicate2d;
    }
}