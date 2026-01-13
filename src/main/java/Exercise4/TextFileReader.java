package Exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class TextFileReader {

    public static void displayFileContent(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        if (!file.isFile()) {
            System.out.println("Path is not a file");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path to a text file: ");
        String filePath = scanner.nextLine().trim();
        scanner.close();

        displayFileContent(filePath);
    }
}