import animals.Dragon;
import animals.canines.Dog;
import animals.canines.Wolf;
import animals.felines.Cat;
import animals.felines.Lion;
import animals.robots.RoboDog;

public class AnimalTestDrive {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Lion lion = new Lion();
        lion.setName("Simba");
        lion.makeSound();
        lion.eat();

        Cat cat = new Cat();
        cat.setName("Garfield");
        cat.makeSound();
        cat.eat();
        cat.play();

        Dog dog = new Dog();
        dog.setName("Rex");
        dog.makeSound();
        dog.eat();
        dog.play();

        Wolf wolf = new Wolf();
        wolf.setName("Wolfgang");
        wolf.makeSound();
        wolf.eat();

        Dragon dragon = new Dragon();
        dragon.setName("Smaug");
        dragon.makeSound();
        dragon.eat();

        RoboDog roboDog = new RoboDog();
        roboDog.setModel("Rex 2.0");
        roboDog.play();
        roboDog.performTask();

        roboDog.setCharged(true);

        System.out.printf("Charging %s...%n", roboDog.getModel());

        roboDog.play();
        roboDog.performTask();
    }
}