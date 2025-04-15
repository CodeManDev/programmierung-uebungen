import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarSerializer {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "A4", "black", 250));
        cars.add(new ElectricCar("Tesla", "Model S", "red", 250, 100));
        cars.add(new Car("BMW", "M3", "blue", 280));

        System.out.println("cars before serialization:");
        for (Car car : cars) {
            car.printInfo();
            System.out.println();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cars.ser"))) {
            oos.writeObject(cars);
        } catch (IOException e) {
            System.out.printf("An error occurred: %s%n", e.getMessage());
            return;
        }

        System.out.println("saved cars to cars.ser");
    }

}
