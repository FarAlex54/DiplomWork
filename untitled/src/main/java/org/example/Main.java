package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[20];
        int valueStart = 10;
        int valueEnd = 13;

            if (array.length % 2 > 0){
                System.out.println(array.length/2);
                Arrays.fill(array,0,array.length/2,valueStart);
                Arrays.fill(array,array.length/2 ,array.length,valueEnd);
            }
            else{
                Arrays.fill(array,0,array.length/2,valueEnd);
                Arrays.fill(array,array.length/2,array.length,valueStart);
            }
            System.out.println(Arrays.toString(array));

    }
}