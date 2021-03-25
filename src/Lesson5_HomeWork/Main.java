package Lesson5_HomeWork;

public class Main {
    public static void main(String[] args) {
        final int size = 10000000;
        final int half = size / 2;
        float[] array = new float[size];
        long startTime = 0, endTime = 0;
        float[] fullArray;
        fullArray = fillArray(array);
        System.out.println();
        startTime = System.currentTimeMillis();
        doOperationArray(fullArray);
        endTime = System.currentTimeMillis();
        System.out.println("Time for do program in 1 stream = "+(endTime-startTime));



    }
    static float[] fillArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
            //System.out.print(array[i] + " ");
        }
        return array;
    }

    static float[] doOperationArray(float[] inArray){
        for (int i = 0; i <inArray.length ; i++) {
            inArray[i] = (float)(inArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            //System.out.print(inArray[i]+" ");
        }
        //System.out.println();
        return inArray;
    }

}
