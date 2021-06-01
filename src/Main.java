/*Can lam them:
2. toi uu hoa thuat toan sap xep (neu co)
*/
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner keyboard = new Scanner(System.in);
    static File file;

    public static double[] importArray(String name) throws IOException {
        file = new File(name);

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
                    double[] array = importArray("INPUT.TXT");
                    System.out.println(Arrays.toString(array));
                }

                //Bubble Sort
                case 3 -> {
                    double[] array = importArray("INPUT.TXT");
                    Sort.bubbleSort(array, true);
                    exportArray(array, "OUTPUT1");
                }

                //Selection Sort
                case 4 -> {
                    double[] array = importArray("INPUT.TXT");
                    Sort.selectionSort(array, true);
                    exportArray(array, "OUTPUT2");
                }

                //Insertion Sort
                case 5 -> {
                    double[] array = importArray("INPUT.TXT");
                    Sort.insertionSort(array, true);
                    exportArray(array, "OUTPUT3");
                }

                //Liner Search
                case 6 -> {
                    System.out.print("Type number: ");
                    double value = Double.parseDouble(keyboard.nextLine());
                    double[] array = importArray("INPUT.TXT");

                    array = Search.linerSearch(array, value);
                    exportArray(array, "OUTPUT4");
                }

                //Binary Search
                case 7 -> {
                    System.out.print("Type number: ");
                    double value = Double.parseDouble(keyboard.nextLine());
                    double[] array = importArray("INPUT.TXT");

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
                        System.out.println("There are no matched value in the array!");
                    }
                }
                //sort compare
                case 8 -> {
                    int isRepeat;
                    do {
                        double[] checkArray = null;
                        //import data case
                        System.out.println("Which case do you want to compare?");
                        lineBreak();
                        System.out.println("1. Sorted data");
                        System.out.println("2. Reversed sort data");
                        System.out.println("3. Random data");
                        lineBreak();
                        int dataChoice;
                        do {
                            System.out.print("Your choice: ");
                            dataChoice = Integer.parseInt(keyboard.nextLine());
                            switch (dataChoice) {
                                case 1 -> {
                                    checkArray = importArray("Sorted.TXT");
                                    System.out.println("Sorted data check (Best case)");
                                }
                                case 2 -> {
                                    checkArray = importArray("ReverseSort.TXT");
                                    System.out.println("Reversed sort data check (Worse case)");
                                }
                                case 3 -> {
                                    checkArray = importArray("INPUT.TXT");
                                    System.out.println("Unsorted data check (Average case)");
                                }
                                default -> System.out.println("Not correct, please try again!");
                            }
                        } while (dataChoice > 3 || dataChoice < 1);

                        System.out.println("The compare function will run 10 times");
                        lineBreak();
                        Sort.timeCompare(checkArray, 10);

                        lineBreak();
                        System.out.print("Do you want to compare again (\"1\" for Yes): ");
                        isRepeat = Integer.parseInt(keyboard.nextLine());
                    } while (isRepeat == 1);
                }
            }

            if (choice < 9) {
                lineBreak();
                System.out.print("Exit program? (\"1\" for yes): ");
                choice = Integer.parseInt(keyboard.nextLine());
            }
        } while (choice != 1 && choice < 9);
        lineBreak();
        System.out.println("Good bye!");
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
        System.out.println("8. Compare Sort Algorithms");
        System.out.println("9. Exit");
        lineBreak();
        System.out.print("Your choice: ");
    }

    public static void lineBreak() {
        System.out.println("--------------------");
    }
}
