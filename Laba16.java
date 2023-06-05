package com.company;
import java.util.Scanner;
import java.util.Arrays;

public class Laba16{
    interface Operationable {
        boolean calculate(int x, int y);
    }

    private static void selectionSort(int [] array, Operationable u) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (u.calculate(array[j], array[minIndex])) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размерность массива:");
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        System.out.println("Начальный массив: ");
        System.out.println(Arrays.toString(array));
        System.out.println("По возрастанию: ");
        selectionSort(array, ((x, y) -> x < y));
        System.out.println(Arrays.toString(array));
        System.out.println("По убыванию: ");
        selectionSort(array, ((x, y) -> x > y));
        System.out.println(Arrays.toString(array));

    }
}
