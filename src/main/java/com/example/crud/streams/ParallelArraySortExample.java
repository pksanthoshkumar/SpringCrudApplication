package com.example.crud.streams;

import java.util.Arrays;
import java.util.Random;

public class ParallelArraySortExample {
    public static void main(String[] args) {
        // Create an array of integers with a large number of elements
        int[] numbers = new int[1000000];
        Random random = new Random();

        // Fill the array with random integers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000000);
        }

        // Measure the start time
        long startTime = System.currentTimeMillis();

        // Sort the array in parallel
        Arrays.parallelSort(numbers);

        // Measure the end time
        long endTime = System.currentTimeMillis();

        // Calculate and print the time taken for sorting
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken for parallel sorting: " + elapsedTime + " milliseconds");
    }
}
