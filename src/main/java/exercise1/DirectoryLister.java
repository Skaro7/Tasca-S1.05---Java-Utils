package exercise1;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class DirectoryLister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a directory path:");

        String directoryPath = scanner.nextLine().trim();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            scanner.close();
            return;
        }


        if (!directory.isDirectory()) {
            System.out.println("Path is not a directory");
            scanner.close();
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Error reading directory");
            scanner.close();
            return;
        }

        Arrays.sort(files, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (File file : files) {
            System.out.println(file.getName());
        }

        scanner.close();
    }
}
