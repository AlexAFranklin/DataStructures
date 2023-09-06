import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


//        int d1Data[] = new int[6];
//        int d1Data2[] = new int [6];
//        inputArray(d1Data);
//        inputArray(d1Data2);
//        printArray(d1Data);
//        printArray(d1Data2);

//        findDuplicates1DV2(d1Data, d1Data2);


        int d2Data1[] = new int[2];
        int d2Data2[] = new int[3];
        int d2Data3[] = new int[4];
        int d2Data4[] = new int[2];

        int d2Data5[] = new int[4];
        int d2Data6[] = new int[2];
        int d2Data7[] = new int[3];
        int d2Data8[] = new int[2];
        int d2Data9[] = new int[4];

        int[][] d2Data = {d2Data1, d2Data2, d2Data3, d2Data4};
        int[][] d2DataSecond = {d2Data5, d2Data6, d2Data7, d2Data8, d2Data9};
        inputArray2D(d2Data);
        printArray2D(d2Data);
        inputArray2D(d2DataSecond);
        printArray2D(d2DataSecond);
        findDuplicates2D(d2Data, d2DataSecond);



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

    static int[] findDuplicates1DV2(int[] a1, int[] a2) {
        String a1String = "";
        String duplicates = "";

        for (int i = 0; i < a1.length; i++) {
          a1String += Integer.toString(a1[i]);
          // TODO - add duplicates - this would go here. - also change the second loop to include the top portion?
            // add a1String content after checking against it. to check for every array - incomplete 
        }
        for (int j = 0; j < a2.length; j++) {
            String jString = Integer.toString(a2[j]);
           if (!duplicates.contains(jString) && a1String.contains(jString)) {
               duplicates += jString + "-";
           }
        }

        String [] duplicateArr = duplicates.split("-", -2);
        int finalInt[] = new int[duplicateArr.length - 1];

        for (int i = 0; i < finalInt.length; i++) {
            finalInt[i] = Integer.parseInt(duplicateArr[i]);
        }
        System.out.println(Arrays.toString(finalInt) + " final array");
        return finalInt;


    }

    static int[] findDuplicates2D(int[][] a1, int[][] a2) {
        String a1String = "";
        String duplicates = "";

        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j <a1[i].length; j++) {
                a1String += Integer.toString(a1[i][j]) + "-";
                System.out.println(a1String);
            }
        }
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j <a2[i].length; j++) {
                String jString = Integer.toString(a2[i][j]);
                if (!duplicates.contains(jString) && a1String.contains(jString)) {
                    duplicates += jString + "-";
                }
            }
        }

        String [] duplicateArr = duplicates.split("-", -2);
        int finalInt[] = new int[duplicateArr.length - 1];

        for (int i = 0; i < finalInt.length; i++) {
            finalInt[i] = Integer.parseInt(duplicateArr[i]);
        }
        System.out.println(Arrays.toString(finalInt) + " final array");
        return finalInt;


    }
}

