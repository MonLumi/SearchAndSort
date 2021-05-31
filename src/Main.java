import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner keyboard = new Scanner(System.in);
    static File file;

    public static double[] importArray() throws IOException {
        file = new File("INPUT.TXT");

        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader input = new BufferedReader(inputStreamReader);
        String s = input.readLine();
        String[] stringArray = s.split(" ");
        double[] array = new double[stringArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(stringArray[i]);
        }
        input.close();
        return array;
    }

    public static void exportArray(double[] array, String fileName) throws IOException {
        file = new File(fileName + ".TXT");
        if (!file.exists()) file.createNewFile();


        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter out = new BufferedWriter(outputStreamWriter);

        for (double value : array) {
            out.append(String.valueOf(value)).append(" ");
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {
        int choice;
        do {
            menu();
            choice = Integer.parseInt(keyboard.nextLine());
            switch (choice) {
                //Input double number to database
                case 1 -> {
                    System.out.print("How many elements do you want to add?: ");
                    int length = Integer.parseInt(keyboard.nextLine());
                    double[] array = new double[length];

                    // add number to array
                    for (int i = 0; i < length; i++) {
                        switch (i) {
                            case 0 -> System.out.print("1st number: ");
                            case 1 -> System.out.print("2nd number: ");
                            case 2 -> System.out.print("3rd number: ");
                            default -> System.out.print(i+1 + "th number: ");
                        }
                        array[i] = Double.parseDouble(keyboard.nextLine());
                    }
                        exportArray(array, "INPUT");

                    System.out.println("You've successfully added " + length + " numbers");
                }

                //Display all number from database
                case 2 -> {
                    double[] array = importArray();
                    System.out.println(Arrays.toString(array));
                }

                //Bubble Sort
                case 3 -> {
                    double[] array = importArray();
                    Sort.bubbleSort(array);
                    exportArray(array, "OUTPUT1");
                }

                //Selection Sort
                case 4 -> {
                    double[] array = importArray();
                    Sort.selectionSort(array);
                    exportArray(array, "OUTPUT2");
                }

                //Insertion Sort
                case 5 -> {
                    double[] array = importArray();
                    Sort.insertionSort(array);
                    exportArray(array, "OUTPUT3");
                }

                //Liner Search
                case 6 -> {
                    System.out.print("Type number: ");
                    double value = Double.parseDouble(keyboard.nextLine());
                    double[] array = importArray();

                    array = Search.linerSearch(array, value);
                    exportArray(array, "OUTPUT4");
                }

                //Binary Search
                case 7 -> {
                    System.out.print("Type number: ");
                    double value = Double.parseDouble(keyboard.nextLine());
                    double[] array = importArray();

                    int index = Search.binarySearch(array, value);

                    //It's only for one String output
                    if(index >= 0) {
                        String result = "Index " + index + " has value: " + array[index];
                        System.out.println(result);
                        file = new File("OUTPUT5.TXT");
                        if (!file.exists()) file.createNewFile();

                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                        BufferedWriter out = new BufferedWriter(outputStreamWriter);
                        out.write(result);
                        out.close();
                    } else {
                        System.out.println("There are no value in the array!");
                    }
                }
            }

            if (choice < 8) {
                lineBreak();
                System.out.print("Try again? (\"1\" for yes): ");
                choice = Integer.parseInt(keyboard.nextLine());
            }
        } while (choice == 1);
    }

    public static void menu() {
        System.out.println("--------Menu--------");
        System.out.println("1. Input");
        System.out.println("2. Output");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Selection Sort");
        System.out.println("5. Insertion Sort");
        System.out.println("6. Liner Search");
        System.out.println("7. Binary Search");
        System.out.println("8. Exit");
        lineBreak();
        System.out.print("Your choice: ");
    }

    public static void lineBreak() {
        System.out.println("--------------------");
    }

}
