package Hw1_21002139.ex2;

import java.util.Scanner;

public class Array<T> {
    T[] array;

    public Array() {
    }

    public Array(T[] array) {
        this.array = array;
    }

    public void inputArray() {
        System.out.print("Input number size of array: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = (T[]) new Object[n];
        System.out.print("Input values of array: ");
        for (int i = 0; i < n; i++){
            array[i] = (T) sc.next();
        }
        sc.close();
    }

    public void printArray() {
        System.out.print("Array is | ");
        for (T x : array){
            System.out.print(x + " | ");
        }
        System.out.println();
    }

    public int search(T number) {
        for (int i = 0; i < array.length; i++){
            if (array[i].toString().compareTo(number.toString()) == 0) { 
                return i;
            }
        }
        return -1;
    }

    public void sort() {
        //This is Insertion Sort
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            T key = array[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && (Float.parseFloat((String) array[j]) - Float.parseFloat((String) key) > 0)) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<Integer>();
        array.inputArray();
        array.printArray();

        System.out.println("Number " + 90 + " in index: ");
        System.out.println(array.search(90));

        System.out.println("After sort: ");
        array.sort();
        array.printArray();
    }
}