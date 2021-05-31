import java.util.Arrays;

public class Sort {

    public static void bubbleSort(double[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    //swap 2 adjacent number
                    double tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
            display(array,i);
        }
    }

    public static void selectionSort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // swap min Number to i
            if (minIndex != i) {
                double tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
            display(array,i);
        }
    }

    public static void insertionSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
            display(array,i);
        }
    }

    public static void display(double[] array, int step) {
        System.out.print ("Step " + (step+1) + ": ");
        for (double value: array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
