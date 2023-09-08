import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


//        int d1Data[] = new int[6];
//        int d1Data2[] = new int [6];
//        inputArray(d1Data);
//        inputArray(d1Data2);
//        findDuplicates1D(d1Data, d1Data2);
//        printArray(d1Data);
//        printArray(d1Data2);

//        printArray(findDuplicates1D(d1Data, d1Data2));


        int d2Data1[] = new int[2];
        int d2Data2[] = new int[3];
        int d2Data3[] = new int[4];
        int d2Data4[] = new int[2];
//
        int d2Data5[] = new int[4];
        int d2Data6[] = new int[2];
        int d2Data7[] = new int[3];
        int d2Data8[] = new int[2];
//        int d2Data9[] = new int[4];
//
        int[][] d2Data = {d2Data1, d2Data2, d2Data3, d2Data4};
        int[][] d2DataSecond = {d2Data5, d2Data6, d2Data7, d2Data8};
        inputArray2D(d2Data);

     //   printRightJustified(d2Data);

        inputArray2D(d2DataSecond);
        System.out.println("FIRST");
        printArray2D(d2Data);
        System.out.println("SECOND");
        printArray2D(d2DataSecond);
        System.out.println("Duplicates");
        findDuplicates2D(d2Data, d2DataSecond);
//                printArray2D(d2Data);
//        printArray2D(d2DataSecond);
//        printArray(findDuplicates2D(d2Data, d2DataSecond));



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
                   boolean unique = true;
                   for (int k = 0; k < duplicateCount; k++) {
                       if (a1[i] == duplicates[k]) {
                           unique = false;
                           break;
                       }
                   }
                   if (unique) {
                       duplicates[duplicateCount++] = a1[i];
                   }
                }
            }
        }

        int finalDuplicates[] = new int[duplicateCount];

        for (int i = 0; i < finalDuplicates.length; i++) {
            finalDuplicates[i] = duplicates[i];
        }
        printArray(finalDuplicates);
        return finalDuplicates;
    }

    static int[] findDuplicates2D(int[][] a1, int[][] a2){
        int a1Length = 0;
        int a2Length = 0;
        int duplCount = 0;


        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[i].length; j++) {
                a1Length++;
            }
        }

        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2[i].length; j++) {
                a2Length++;
            }
        }

        int duplicates[] = (a1Length <= a2Length) ? new int[a1Length] : new int[a2Length] ;


        for (int a1Row = 0; a1Row < a1.length; a1Row++){
            for (int a1Col = 0; a1Col < a1[a1Row].length; a1Col++) {
                for (int a2Row = 0; a2Row < a2.length; a2Row++){
                    for (int a2Col = 0; a2Col < a2[a2Row].length; a2Col++) {

                        if (a1[a1Row][a1Col] == a2[a2Row][a2Col]) {
                            boolean unique = true;
                            for (int k = 0; k < duplCount; k++) {
                                if (a1[a1Row][a1Col] == duplicates[k]) {
                                    unique = false;
                                    break;
                                }
                            }
                            if (unique) {
                                duplicates[duplCount++] = a1[a1Row][a1Col];
                            }
                        }

                    }
                }
            }
        }

        int finalDuplicates[] = new int[duplCount];

        for (int i = 0; i < finalDuplicates.length; i++) {
            finalDuplicates[i] = duplicates[i];
        }
        printArray(finalDuplicates);
        return finalDuplicates;

    }

    static void printRightJustified(int[][]data) {
        int rowsAmount = data.length;
        int [] colLength = new int[rowsAmount];
        int [] charLength = new int[rowsAmount];

        for (int i = 0; i < data.length; i++) {
            colLength[i] = data[i].length;
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < colLength[i]; j++) {
                String strEval = String.valueOf(data[i][j]);
                if (strEval.length() > charLength[j]) {
                    charLength[j] = strEval.length();
                }
            }
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int x = charLength[j];
                System.out.printf((data[i].length - 1 == j) ? "%" + x + "d%n" : "%" + x +"d, " ,  data[i][j]);
            }
        }

    }

}

