package Exercise3;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class DirectoryTreeToFile {

    public static void listDirectoryTreeToFile(File directory, String indent, PrintWriter writer) {
        File[] files = directory.listFiles();

        if (files == null) {
            return;
        }

        Arrays.sort(files, (file1, file2) -> file1.getName().compareTo(file2.getName()));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (File file : files) {
            String type = file.isDirectory() ? "D" : "F";
            String lastModified = dateFormat.format(file.lastModified());
            writer.println(indent + file.getName() + " (" + type + ") - Last modified: " + lastModified);

            if (file.isDirectory()) {
                listDirectoryTreeToFile(file, indent + "  ", writer);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a directory path: ");
        String path = scanner.nextLine().trim();

        System.out.print("Enter output file name (e.g., output.txt): ");
        String outputFileName = scanner.nextLine().trim();
        scanner.close();

        File directory = new File(path);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Path is not a directory");
            return;
        }

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(outputFileName));
            writer.println("Directory tree for: " + directory.getAbsolutePath());
            listDirectoryTreeToFile(directory, "", writer);
            writer.close();
            System.out.println("Directory tree saved to: " + outputFileName);
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
