package org.example;
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        CustomArrayOfInts array = new CustomArrayOfInts();

        for (int i = 0; i < 20; i++) {
            array.add((int) Math.floor(Math.random() * (100 + 100 + 1) -100));
        }

        System.out.println("Original Array");
        array.printArray();
        //DELETE BY INDEX
//        for (int i = 0; i < 20; i++) {
//            int x = (int) Math.floor(Math.random() * (25 + 5) + 1)  -5;
//            System.out.println(" X = " + x);
//            array.deleteByIndex(x);
//            array.printArray();
//
//        }

        //  DELETE BY VALUE
//        for (int i = 0; i < 20; i++) {
//            int x = (int) Math.floor(Math.random() * (12 + 12 ) + 1)  -10;
//            System.out.println(" X = " + x);
//            array.deleteByValue(x);
//            array.printArray();
//
//        }

        // INSERT AT INDEX
//        for (int i = 0; i < 20; i++) {
//            int x = (int) Math.floor(Math.random() * (25 + 5) + 1)  -5;
//            int y = 1000;
//            System.out.println(" X = " + x);
//            array.insertValueAtIndex(y, x);
//            array.printArray();
//
//        }


        // GET
//            for (int i = 0; i < 20; i++) {
//                int x = (int) Math.floor(Math.random() * (25 + 5) + 1) - 5;
//                System.out.println(" X = " + x);
//
//                try {
//                    int y = array.get(x);
//                    System.out.println("GOT = " + y);
//                } catch (IndexOutOfBoundsException ioob) {
//                    System.out.println(ioob.getLocalizedMessage());
//                }
//
//                array.printArray();
//            }

        // GET SLICE

//            for (int i = 0; i < 20; i++) {
//                int x = (int) (int) (Math.random() * 23) - 10;
//                int y = (int) (Math.random() * 16) - 5;
//                System.out.println(" index = " + x + ", length = " + y);
//
//                try {
//                    int [] mySlice = array.getSlice(x, y);
//                    for (int j = 0; j < mySlice.length; j++) {
//                        System.out.print(mySlice[j] + ",");
//                    }
//                    System.out.print("\n");
//                } catch (IndexOutOfBoundsException iob) {
//                    System.out.println(iob.getLocalizedMessage());
//                } catch (NegativeArraySizeException nas) {
//                    System.out.println(nas.getLocalizedMessage());
//                }
//
//            }





    }




}