package Lesson2_HomeWork;

public class Main {
    public static void main(String[] args) {
        String[][] array1 = new String[][]{ {"12", "25", "68", "87"},
                                            {"97", "48", "6", "78"},
                                            {"15", "37", "11", "89"},
                                            {"7", "3", "97", "14"}};

        convertingArray(array1);

    }
    public static void convertingArray (String[][] array){
        int[][] newArray = new int[4][4];
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4; j++) {
                newArray[i][j] = Integer.valueOf(array[i][j]);
                System.out.print(newArray[i][j]+" ");
            }
            System.out.println();
        }
    }
}
