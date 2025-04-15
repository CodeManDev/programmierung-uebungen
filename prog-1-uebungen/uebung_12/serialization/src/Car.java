import java.io.Serializable;

public class Car implements Serializable {

    private final String brand, model, color;
    private final int maxSpeed;

    public Car(String brand, String model, String color, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public Car(String brand, String model) {
        this(brand, model, "black", 200);
    }

    public void printInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Max speed: " + maxSpeed + " km/h");
    }

}
