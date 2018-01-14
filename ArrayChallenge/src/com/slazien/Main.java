package com.slazien;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] inputArray = getIntegers(5);
        System.out.println("Sorted array:");
        int[] sortedArray = insertionSort(inputArray);
        printArray(reverseArray(sortedArray));
        System.out.println("Reversed sorted array:");
        printArray(reverseArray(sortedArray));
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        int[] out = new int[number];

        for(int i=0; i<number; i++) {
            out[i] = scanner.nextInt();
        }

        return out;
    }

    public static void printArray(int[] inputArray) {
        for(int i=0; i<inputArray.length; i++) {
            System.out.println(inputArray[i]);
        }
    }

    public static int[] insertionSort(int[] inputArray) {
        for(int i=1; i<inputArray.length; i++) {
            int currentElem = inputArray[i];
            int j = i - 1;
            while(j >= 0 && inputArray[j] > currentElem) {
                inputArray[j+1] = inputArray[j];
                j = j - 1;
            }
            inputArray[j+1] = currentElem;

        }

        return inputArray;
    }

    public static int[] reverseArray(int[] inputArray) {
        for(int i=0; i<inputArray.length/2; i++) {
            int temp = inputArray[i];
            inputArray[i] = inputArray[inputArray.length-i-1];
            inputArray[inputArray.length-i-1] = temp;
        }

        return inputArray;
    }

    private static Scanner scanner = new Scanner(System.in);
}
