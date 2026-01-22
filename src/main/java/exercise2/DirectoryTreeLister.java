package exercise2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class DirectoryTreeLister {

    public static void listDirectoryTree(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files == null) {
            return;
        }

        Arrays.sort(files, (file1, file2) -> file1.getName().compareTo(file2.getName()));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (File file : files) {
            String type = file.isDirectory() ? "D" : "F";
            String lastModified = dateFormat.format(file.lastModified());
            System.out.println(indent + file.getName() + " (" + type + ") - Last modified: " + lastModified);

            if (file.isDirectory()) {
                listDirectoryTree(file, indent + "  ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a directory path: ");
        String path = scanner.nextLine().trim();
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

        System.out.println("Directory tree for: " + directory.getAbsolutePath());
        listDirectoryTree(directory, "");
    }
}