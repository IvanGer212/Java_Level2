package Lesson5_HomeWork;

public class Main {
    public static void main(String[] args) {
        final int size = 100000000;
        final int half = size / 2;
        float[] array = new float[size];
        long startTime = 0, endTime = 0;
        float[] fullArray;
        fullArray = fillArray(array);
        countTimeForProgramInOneStream(fullArray, startTime, endTime);
        fullArray = fillArray(array);
        countTimeForProgramInTwoStream(fullArray,startTime,endTime,half);

    }

    static float[] fillArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }
        return array;
    }

    static float[] doOperationArray(float[] inArray, int startNum) {
        for (int i = 0; i < inArray.length; i++) {
            inArray[i] = (float) (inArray[i] * Math.sin(0.2f + (i+startNum) / 5) * Math.cos(0.2f + (i+startNum) / 5) * Math.cos(0.4f + (i+startNum) / 2));
        }
        return inArray;
    }

    static void countTimeForProgramInOneStream(float[] array, long startTime, long endTime) {
        startTime = System.currentTimeMillis();
        doOperationArray(array,0);
        endTime = System.currentTimeMillis();
        System.out.println("Time for do program in 1 stream = " + (endTime - startTime));

    }

    static void countTimeForProgramInTwoStream(float[] array, long startTime, long endTime, int size) {
        float[] a1 = new float[size];
        float[] a2 = new float[size];
        startTime = System.currentTimeMillis();
        System.arraycopy(array,0,a1,0,size);
        System.arraycopy(array,size,a2,0,size);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                doOperationArray(a1,0);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                doOperationArray(a2,size);
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new ConcatArray().get(a1,a2,size);

        endTime = System.currentTimeMillis();
        System.out.println("Time for do program in 2 stream = "+(endTime-startTime));
    }
}