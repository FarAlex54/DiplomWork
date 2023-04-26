package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Demo2Application {
    public static int[] array = new int[20];
    public static int valueStart = 10;
    public static int valueEnd = 13;

    public static void main(String[] args) {
        if (array.length % 2 == 0){
            Arrays.fill(array,0,10,valueStart);
            Arrays.fill(array,11,20,valueEnd);
        }
        else{
            Arrays.fill(array,11,20,valueStart);
            Arrays.fill(array,0,10,valueEnd);
        }
        System.out.println(Arrays.toString(array));
    }

}
