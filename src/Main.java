import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner keyboard = new Scanner(System.in);
    static File file = new File("INPUT.TXT");

    public static double[] importArray() throws IOException {
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

    public static void exportArray(double[] array) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter out = new BufferedWriter(outputStreamWriter);

        for (double value : array) {
            out.append(value + " ");
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {
        if (!file.exists()) file.createNewFile();

        int choice;
        do {
            menu();
            choice = Integer.parseInt(keyboard.nextLine());
            switch (choice) {
                //Input double number to database
                case 1 -> {
                    write();
                }

                //Display all number from database
                case 2 -> {
                    double[] array = importArray();
                    for (double value : array) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }

                //Bubble Sort
                case 3 -> {}

                //Selection Sort
                case 4 -> {}

                //Insertion Sort
                case 5 -> {}

                //Liner Search
                case 6 -> {}

                //Binary Search
                case 7 -> {}
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

    public static void write() {
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
        try {
            exportArray(array);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("You've successfully added " + length + " numbers");
    }

}
