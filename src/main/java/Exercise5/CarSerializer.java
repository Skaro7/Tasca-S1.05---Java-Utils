package Exercise5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class CarSerializer {

    public static void serializeCar(Car car, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(car);
            System.out.println("Car serialized and saved to " + filename);
        } catch (Exception e) {
            System.out.println("Error saving car");
        }
    }

    public static Car deserializeCar(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Car car = (Car) ois.readObject();
            return car;
        } catch (Exception e) {
            System.out.println("Error loading car");
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter car details:");
        System.out.print("Brand: ");
        String brand = scanner.nextLine().trim();

        System.out.print("Model: ");
        String model = scanner.nextLine().trim();

        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(brand, model, year);
        System.out.println("\nOriginal car created: " + car);

        System.out.print("\nEnter filename to save (e.g., car.ser): ");
        String filename = scanner.nextLine().trim();

        // SERIALIZE (save to file)
        serializeCar(car, filename);

        // DESERIALIZE (load from file)
        Car loadedCar = deserializeCar(filename);

        if (loadedCar != null) {
            System.out.println("Car deserialized from " + filename);
            System.out.println("Loaded car: " + loadedCar);
        }
        scanner.close();
    }
}
