package app;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] someArray = {10, 45, 64, 10, 456, 96, 3, 15, 40, 38, 123, 7, 56, 12, 1};
        Scanner scanner = new Scanner(System.in);
        ArrayUtils arrayUtils = new ArrayUtils();
        int[] sortedArray = arrayUtils.getMergeSort(someArray);

        System.out.println("\nПочатковий вигляд масиву: " + Arrays.toString(someArray) +
                "\nВідсортований масив: " + Arrays.toString(sortedArray));

        System.out.print("\nВведіть шукане значення: ");
        int target;

        try {
            target = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("[Помилка] Вказано не числове/не цілочисельне значення!");
            scanner.nextLine();
            return;
        }

        int searchedNumber = arrayUtils.getBinarySearch(sortedArray, target);

        if (searchedNumber != -1) {
            System.out.println("Знайдено число " + target + " за індексом " + searchedNumber);
        } else {
            System.out.println("Число " + target + " не знайдено в масиві :(");
        }
    }
}
