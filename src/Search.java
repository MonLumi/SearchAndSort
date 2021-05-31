public class Search {

    public static int linerSearch(double[] array, double value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(double[] array, double value) {
        return binarySearchHelper(array, 0, array.length-1, value);
    }

    public static int binarySearchHelper(double[] array, int lowerIndex, int higherIndex, double value) {
        if (lowerIndex > higherIndex) return -1;
        else {
            int midIndex = lowerIndex + (higherIndex-lowerIndex)/2;
            if (array[midIndex] == value) {
                return midIndex;
            } else if (array[midIndex] < value) {
                return binarySearchHelper(array, midIndex, higherIndex, value);
            } else return binarySearchHelper(array, lowerIndex, midIndex, value);
        }
    }
}
