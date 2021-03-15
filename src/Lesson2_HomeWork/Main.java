package Lesson2_HomeWork;

public class Main {
    public static void main(String[] args) {
        String[][] array1 =  { {"12", "25", "68", "87"},
                               {"97", "48", "6", "14"},
                               {"15", "37", "11", "Arr"},
                               {"7", "3", "97", "37"},
                               {"6","4","56","8"}};

        convertingArray(array1);

    }
    public static void convertingArray (String[][] array){
        int[][] newArray = new int[4][4];
        int sum = 0;
        try {
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length; j++) {
                try {
                newArray[i][j] = Integer.valueOf(array[i][j]);
                }
                catch (NumberFormatException ex){
                    throw new MyArrayDataException("Data type not legal. Cell ["+i+"]"+"["+j+"]" , ex);
                }
                sum +=newArray[i][j];
                System.out.print(newArray[i][j]+" ");
            }
            System.out.println();
        }
            System.out.println("Summa = "+sum);
        }
        catch (IndexOutOfBoundsException ex){
            throw new MyArraySizeException("Array size not legal",ex);
        }
        finally {
            System.out.println("End");

        }
    }
}
