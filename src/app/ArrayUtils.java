package app;

public class ArrayUtils {

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // перевіряємо чи треба взагалі сортування (більше 2 елементів у масиві?)
        }

        // Ділимо масив навпіл
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Копіюємо основний масив у 2 масиви: лівий та правий
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        /*
        В методі викликаємо той же метод (рекурсія) для розділення до тих пір,
        доки масив не розділиться на безліч одновимірних масивів
        "Розділяй і володарюй"
         */
        mergeSort(left);
        mergeSort(right);

        // Зливаємо вже сортовані дані
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int a = 0, l = 0, r = 0; // індекси для кожного масиву

        // Цикл буде тривати доти, доки один з масивів буде мати непройдені елементи
        while (l < left.length && r < right.length) {
            /* перевіряємо чи елемент з left більший, чим з right і відповідно
             до умови додаємо його у відповідну частину загального масиву
             */
            if (left[l] <= right[r]) {
                array[a++] = left[l++];
            } else {
                array[a++] = right[r++];
            }
        }

        // перевіряємо сторони/залишки і додаємо їх у масив
        while (l < left.length) {
            array[a++] = left[l++];
        }

        while (r < right.length) {
            array[a++] = right[r++];
        }
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Перевіряємо, чи знайшли шукане значення
            if (array[mid] == target) {
                return mid;
            }

            // Якщо шукане значення менше середнього, змінюємо праву границю
            if (array[mid] < target) {
                left = mid + 1;
            }
            // Інакше змінюємо ліву границю
            else {
                right = mid - 1;
            }
        }

        // Якщо шукане значення не знайдено, повертаємо -1
        return -1;
    }
}
