import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search {

    public static double[] linerSearch(double[] array, double value) {
        boolean isMatched = false;
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > value) {
                isMatched = true;
                System.out.println("The index " + i + " have the value " + array[i] + ".");
                list.add(array[i]);
            }
        }
        if (!isMatched) {
            System.out.println("The array doesn't have any matched value");
            return null;
        }
        else {
            double[] exportArray = new double[list.size()];
            for (int i = 0; i < list.size(); i++) {
                exportArray[i] = list.get(i);
            }
            return exportArray;
        }
    }

    public static int binarySearch(double[] array, double value) {
        //I use insertion sort to sort the array
        for (int i = 1; i < array.length; i++) {
            double key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        System.out.println("Sorted array: " + Arrays.toString(array));

        return binarySearchHelper(array, 0, array.length-1, value);
    }

    public static int binarySearchHelper(double[] array, int lowerIndex, int higherIndex, double value) {
        if (lowerIndex <= higherIndex) {
            int midIndex = lowerIndex + (higherIndex-lowerIndex)/2;
            if (array[midIndex] == value) {
                return midIndex;
            }
            if (array[midIndex] < value) {
                return binarySearchHelper(array, midIndex + 1, higherIndex, value);
            }
            return binarySearchHelper(array, lowerIndex, midIndex - 1, value);
        }
        else return -1;
    }
}
