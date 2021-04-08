package Lesson5_HomeWork;

public class ConcatArray {

    public float[] get(float[] a1, float[] a2, int size){
        float[] array = new float[2*size];
        System.arraycopy(a1,0,array,0,size);
        System.arraycopy(a2,0,array,size,size);
        return array;
    }
}
