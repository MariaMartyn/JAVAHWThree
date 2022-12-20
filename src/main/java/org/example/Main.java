package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        task1();
        //deleteEvenFromArray();
        //task3();
    }
    /**
     * 1. Реализовать алгоритм сортировки слиянием
     */
    public static void task1() {
        int[] result = new int[] {20, 56, 30, 64, 10, 99, 1, 5, 90, 83, 47, 73};
        System.out.println("Первоначальный список: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("\n");
        System.out.println("Отсортированный список: ");
        System.out.println(Arrays.toString(sortArray(result)));
    }

    public static int[] sortArray(int[] array1) {
        if (array1 == null) {
            return null;
        }
        int len = array1.length / 2;
        if (array1.length < 2) {
            return array1;
        }
        if (array1.length % 2 != 0) {
            len += 1;
        }
        int[] arrayRight = new int[len];
        int[] arrayLeft = new int[array1.length / 2];
        for (int i = 0; i < array1.length / 2; i++) {
            arrayLeft[i] = array1[i];
            //System.out.println(arrayLeft[i] + " ");
        }
        for (int i = array1.length / 2; i < array1.length; i++) {
            arrayRight[i - array1.length / 2] = array1[i];
        }
        arrayLeft = sortArray(arrayLeft);
        arrayRight = sortArray(arrayRight);
        return mergeArray(arrayLeft, arrayRight);
    }

    public static int[] mergeArray(int[] arrayLeft, int[] arrayRight) {
        int[] array3 = new int[arrayLeft.length + arrayRight.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < array3.length ; i++) {
            if(index1 < arrayLeft.length && index2 < arrayRight.length) {
                if(arrayLeft[index1] < arrayRight[index2]) {
                array3[i] = arrayLeft[index1];
                index1++;
                } else {
                    array3[i] = arrayRight[index2];
                    index2++;
                }
            }
            else if (index1 == arrayLeft.length && index2 < arrayRight.length) {
                array3[i] = arrayRight[index2];
                index2++;
            }
            else if (index1 < arrayLeft.length && index2 == arrayRight.length) {
                array3[i] = arrayLeft[index1];
                index1++;
            }
            else {
                array3[i] = 0;
            }
        }
    return array3;
    }


    /**
    * 2. Пусть дан произвольный список целых чисел, удалить из него четные числа
     */
    private static void deleteEvenFromArray() {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Random random = new Random();
            int val = random.nextInt(0, 100);
            array.add(val);
        }
        System.out.println("Первоначальный список: " + array);

        for (int i = 0; i < array.size(); ) {
            if (array.get(i) % 2 == 0) {
                array.remove(i);
            } else {
                i++;
            }
        }

        System.out.println("Список после удаления четных чисел: " + array);
    }

    /**
    *3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
     */
    private static void task3() {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            int val = random.nextInt(0, 100);
            array.add(val);
        }
        System.out.println("Cписок: " + array);
        System.out.println(Collections.max(array) + " - максимальное значение");
        System.out.println(Collections.min(array) + " - минимальное значение");

        int sum = 0;
        for (int i = 0; i <array.size(); i++) {
            sum += array.get(i);
        }
        int middle = sum / array.size();
        System.out.println(middle + " - среднее значение");
    }


}


