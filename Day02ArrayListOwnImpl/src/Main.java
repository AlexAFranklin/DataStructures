public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        CustomArrayOfInts array = new CustomArrayOfInts();

        array.printArray();
        array.add(6);
        array.add(654);
        array.add(8);
        array.add(643);
        array.add(23);
        array.add(8);
        array.add(3);
        array.printArray();
        array.deleteByValue(3);
        array.printArray();
        array.insertValueAtIndex(100, 4);
        array.printArray();


        try {
           int get =  array.get(10);
           System.out.println(get);
        } catch (IndexOutOfBoundsException ioob) {
            System.out.println(ioob.getLocalizedMessage());
        }

        try {
            int [] mySlice = array.getSlice(3, 5);
            for (int i = 0; i < mySlice.length; i++) {
                System.out.print(mySlice[i] + ",");
            }
        } catch (ArrayIndexOutOfBoundsException aioob) {
            System.out.println(aioob.getLocalizedMessage());
        }



    }


}