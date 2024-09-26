package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {64, 25, 12, 22, 11};
        int[] arr2 = {64, 25, 12, 22, 11};
        int[] arr3 = {64, 25, 12, 22, 11};
        selectionSort(arr1);
        insertionSort(arr2);
        mergeSort(arr3, 0, arr3.length-1);
        System.out.println("Selection Sorted array: " + Arrays.toString(arr1));
        System.out.println("Insert Sorted array: " + Arrays.toString(arr2));
        System.out.println("Merge Sorted array: " + Arrays.toString(arr3));

        int[] numb1 = new int[2000];
        int[] numb2 = new int[2000];
        int[] numb3 = new int[2000];
        Random rand = new Random();
        for (int a=0; a< numb1.length;a++){
            numb1[a] = rand.nextInt(100);
            numb2[a] = rand.nextInt(100);
            numb3[a] = rand.nextInt(100);
        }
        final long startTime1 = System.currentTimeMillis();
        selectionSort(numb1);
        final long endTime1 = System.currentTimeMillis();
        System.out.println("Total time selection sort: " + (endTime1 - startTime1));

        final long startTime2 = System.currentTimeMillis();
        insertionSort(numb2);
        final long endTime2 = System.currentTimeMillis();
        System.out.println("Total time insertion sort: " + (endTime2 -startTime2));

        final long startTime3 = System.currentTimeMillis();
        mergeSort(numb3, 0, numb3.length-1);
        final long endTime3 = System.currentTimeMillis();
        System.out.println("Total time merge sort: " + (endTime3 -startTime3));


        System.out.println("Selection Sorted array: " + Arrays.toString(arr1));
        System.out.println("Insert Sorted array: " + Arrays.toString(arr2));
        System.out.println("Merge Sorted array: " + Arrays.toString(arr3));

        int[] arr4 = {64, 25, 12, 22, 11};
        int target = 22;
        int index = linearSearch(arr4, target);
        System.out.println("index: " +index);

        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target2 = 7;
        int result = binarySearch(sortedArray, target2);
        System.out.println("index: " +result);


    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i +1; j< n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex= j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i <arr.length; i++) {
            int key= arr[i];
            int j =i -1;
            while (j >=0 && arr[j] > key) {
                arr[j +1]= arr[j];
                j--;
            }
            arr[j +1] = key;
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array,left,middle,right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int n1= middle - left + 1;
        int n2 =right - middle;
        int[] leftArray =new int[n1];
        int[] rightArray= new int[n2];
        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[middle +1 +j];
        int i =0;
        int j =0;
        int k =left;
        while (i <n1 && j< n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k]= leftArray[i];
                i++;
            } else {
                array[k] =rightArray[j];
                j++;
            }
            k++;
        }
        while (i <n1) {
            array[k]= leftArray[i];
            i++;
            k++;
        }
        while (j <n2) {
            array[k] =rightArray[j];
            j++;
            k++;
        }
    }
    public static int linearSearch(int[] array, int target) {
        for (int i = 0;i <array.length; i++) {
            if (array[i]==target) {
                return i;
            }
        }
        return -1;
    }


    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }



}
