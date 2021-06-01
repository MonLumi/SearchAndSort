import java.util.Arrays;

public class Sort {

    public static void bubbleSort(double[] array, boolean isDisplay) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    //swap 2 adjacent number
                    double tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
            if(isDisplay) display(array,i);
        }
    }

    public static void selectionSort(double[] array, boolean isDisplay) {
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
            if(isDisplay) display(array,i);
        }
    }

    public static void insertionSort(double[] array, boolean isDisplay) {
        for (int i = 1; i < array.length; i++) {
            double key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
            if (isDisplay) display(array,i);
        }
    }

    public static void display(double[] array, int step) {
        System.out.print ("Step " + (step+1) + ": ");
        System.out.println(Arrays.toString(array));
    }

    public static void timeCompare(double[] array, int loop) {
        double bubbleSortTime = 0;
        double selectionSortTime = 0;
        double insertionSortTime = 0;

        for (int times = 0; times < loop; times++) {
            long begin, end;
            double runTime;

            //bubble sort
            double[] bubbleArray = array.clone();
            begin = System.nanoTime();
            bubbleSort(bubbleArray, false);
            end = System.nanoTime();
            runTime = ((double)(end - begin))/1000;
            bubbleSortTime += runTime;

            //selection sort
            double[] selectionArray = array.clone();
            begin = System.nanoTime();
            selectionSort(selectionArray, false);
            end = System.nanoTime();
            runTime = ((double)(end - begin))/1000;
            selectionSortTime += runTime;

            //insertion sort
            double[] insertionArray = array.clone();
            begin = System.nanoTime();
            insertionSort(insertionArray, false);
            end = System.nanoTime();
            runTime = ((double)(end - begin))/1000;
            insertionSortTime += runTime;
        }

        System.out.println("Average BubbleSort time: " + (bubbleSortTime/loop) + "ms");
        System.out.println("Average SelectionSort time: " + (selectionSortTime/loop) + "ms");
        System.out.println("Average InsertionSort time: " + (insertionSortTime/loop) + "ms");
    }
}
