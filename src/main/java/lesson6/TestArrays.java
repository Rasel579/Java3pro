package lesson6;

import java.util.Arrays;

public class TestArrays {
    public  int[] checkElements(int[] arr){
        int[] newArr = new int[0];
        int container = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4){
                newArr = Arrays.copyOfRange(arr, ++i, arr.length );
                container++;
            }
        }
        if (container == 0) throw new RuntimeException();
        return newArr;
    }

    public boolean isContain(int[] arr){
        for (int i : arr) {
            if (i == 1 || i == 4) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {54,23,433,3, 4, 5, 6, 6};
        TestArrays testArrays = new TestArrays();
        System.out.println(Arrays.toString(testArrays.checkElements(arr)));
    }
}
