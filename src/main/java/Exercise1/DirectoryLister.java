package Exercise1;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DirectoryLister {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String directoryPath = sc.nextLine().trim();

        File directory = new File(directoryPath);

        System.out.println("Enter a directory path");

        //Dosn't exist
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            sc.close();
            return;
        }

        //Is not a directory
        if (!directory.isDirectory()) {
            System.out.println("Path is not a directory");
            sc.close();
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Error reading directory");
            sc.close();
            return;
        }

        Arrays.sort(files, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (File file : files) {
            System.out.println(file.getName());
        }

        sc.close();
    }
}
