public class CarTestDrive {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Car car = new Car("VW", "Golf", "blue", 180);
        System.out.println(car);
        car.printInfo();

        Car car2 = new Car("Audi", "A3");
        System.out.println(car2);
        car2.printInfo();

        ElectricCar electricCar = new ElectricCar("Tesla", "Model S", "red", 250, 100);
        System.out.println(electricCar);
        electricCar.printInfo();
    }

}
