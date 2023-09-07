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

//        printArray(findDuplicates1D(d1Data, d1Data2));


        int d2Data1[] = new int[2];
        int d2Data2[] = new int[3];
        int d2Data3[] = new int[4];
        int d2Data4[] = new int[2];

        int d2Data5[] = new int[4];
        int d2Data6[] = new int[2];
        int d2Data7[] = new int[3];
        int d2Data8[] = new int[2];
        int d2Data9[] = new int[4];
//
        int[][] d2Data = {d2Data1, d2Data2, d2Data3, d2Data4};
        int[][] d2DataSecond = {d2Data5, d2Data6, d2Data7, d2Data8, d2Data9};
        inputArray2D(d2Data);

        inputArray2D(d2DataSecond);
                printArray2D(d2Data);
        printArray2D(d2DataSecond);
        printArray(findDuplicates2D(d2Data, d2DataSecond));



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
        int duplicates[] = (a1.length <= a2.length) ? new int[a1.length] : new int[a2.length] ;
        int duplicateCount = 0;
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] == a2[j]) {
                    duplicates[duplicateCount++] = a1[i];
                }
            }
        }
        int duplicatesCopy[] = new int[duplicateCount];
        int duplicateStorage[] = new int[duplicateCount];
        duplicateCount = 0;

        for (int i = 0; i <duplicatesCopy.length; i++) {
            duplicatesCopy[i] = duplicates[i];
        }


        for (int i = 0; i < duplicatesCopy.length; i++) {
            int matchCount = 0;
            for (int j = 0; j < duplicateStorage.length; j++) {
                if (duplicatesCopy[i] == duplicateStorage[j]){
                    matchCount++;
                }
            }

            if (matchCount == 0) {
                duplicateStorage[duplicateCount++] = duplicatesCopy[i];
                System.out.println(duplicatesCopy[i]);
            }
        }

        int finalDuplicates[] = new int[duplicateCount];
        System.out.println(duplicateCount);


        for (int i = 0; i < finalDuplicates.length; i++) {
            finalDuplicates[i] = duplicateStorage[i];
        }



        return finalDuplicates;
    }

    static int[] findDuplicates2D(int[][] a1, int[][] a2){
        int a1Length = 0;
        int a2Length = 0;


        for (int i = 0; i < a1.length; i++) {
            a1Length += a1[i].length;
        }

        for (int i = 0; i < a2.length; i++) {
            a2Length += a2[i].length;
        }

        int a1Arr[] =  new int[a1Length];
        int a2Arr[] =  new int[a2Length];
        a1Length = 0;
        a2Length = 0;

        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[i].length; j++) {
                a1Arr[a1Length++] = a1[i][j];
            }
        }

        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2[i].length; j++) {
                a2Arr[a2Length++] = a2[i][j];
            }
        }


        return findDuplicates1D(a1Arr, a2Arr);
    }

}

