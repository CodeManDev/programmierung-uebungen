public class ElectricCar extends Car {

    private int batteryCapacity;

    public ElectricCar(String brand, String model, String color, int maxSpeed, int batteryCapacity) {
        super(brand, model, color, maxSpeed);

        this.batteryCapacity = batteryCapacity;
    }

    public ElectricCar(String brand, String model) {
        super(brand, model);

        this.batteryCapacity = 60;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Battery capacity: " + batteryCapacity + " kWh");
    }

}
