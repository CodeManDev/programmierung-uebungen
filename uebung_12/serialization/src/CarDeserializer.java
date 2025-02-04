import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class CarDeserializer {

    public static void main(String[] args) {
        List<Car> cars;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cars.ser"))) {
            cars = (List<Car>) ois.readObject();
        } catch (Exception e) {
            System.out.printf("An error occurred: %s%n", e.getMessage());
            return;
        }

        System.out.println("cars after deserialization:");
        for (Car car : cars) {
            car.printInfo();
            System.out.println();
        }
    }

}
