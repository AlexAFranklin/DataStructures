import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int d1Data[] = new int[6];
        int d1Data2[] = new int [6];
        inputArray(d1Data);
        inputArray(d1Data2);
        printArray(d1Data);
        printArray(d1Data2);

        findDuplicates1D(d1Data, d1Data2);


//        int d2Data1[] = new int[2];
//        int d2Data2[] = new int[3];
//        int d2Data3[] = new int[4];
//        int d2Data4[] = new int[2];
//
//        int[][] d2Data = {d2Data1, d2Data2, d2Data3, d2Data4};
//        inputArray2D(d2Data);
//        printArray2D(d2Data);



    }

    static Scanner scanner = new Scanner(System.in);

    static void inputArray(int[] data) {

        for (int i = 0; i < data.length; i++) {
            System.out.println("Enter value for column " + (i + 1) + ": ");
            data[i] = scanner.nextInt();
        }
    }

    static void inputArray2D(int[][] data) {

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("Enter value for row " + (i + 1) + " column: " + (j + 1) + ": ");
                data[i][j] = scanner.nextInt();
                System.out.print("\n");
            }
        }
    }

    static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            String comma = (1 + i == data.length) ? "." : ",";
            System.out.print(data[i] + comma + " ");
        }
    }

    static void printArray2D(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                String comma = (1 + j == data[i].length) ? "\n" : ", ";
                System.out.print(data[i][j] + comma);
            }
        }
    }

    static int[] findDuplicates1D(int[] a1, int[] a2) {
        String duplicates = "";

        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                String jString = Integer.toString(a2[j]);
                if (a1[i] == a2[j] && !duplicates.contains(jString)) {
                    duplicates += jString + "-";
                }
            }
        }

        String [] duplicateArr = duplicates.split("-", -2);
//        System.out.println(duplicates + " the duplicates");
//        System.out.println(duplicateArr.length + " the length");
        int finalInt[] = new int[duplicateArr.length - 1];

        for (int i = 0; i < finalInt.length; i++) {
            finalInt[i] = Integer.parseInt(duplicateArr[i]);
        }
       // System.out.println(Arrays.toString(finalInt) + " final array");
        // used Arrays to test in console only
        return finalInt;


    }
}

