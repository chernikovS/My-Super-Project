package app;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int index;
    static int numberToFind;

    public static void main(String[] args) {

        int[] numbers = {33, 27, 16, 17, 45, 43, 56, 3, 59, 19,
                88, 9, 77, 14, 68};
        System.out.println("Початковий вигляд масиву: " +
                Arrays.toString(numbers));


        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = key;
        }
        System.out.print("Відсортований масив: " +
                Arrays.toString(numbers));


        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть число для пошуку: ");
        numberToFind = scanner.nextInt();

        index = binarySearch(numbers, numberToFind);
        if(index == -1) {
            System.out.println("Число не знайдено.");
        }
        else {
            System.out.println("Індекс числа " + numberToFind +
                    " у відсортованому масиві: " + index);
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}