import animals.Dragon;
import animals.canines.Dog;
import animals.canines.Wolf;
import animals.felines.Cat;
import animals.felines.Lion;
import animals.robots.RoboDog;

public class AnimalTestDrive {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Lion lion = new Lion("Simba");
        lion.makeSound();
        lion.eat();

        Cat cat = new Cat("Tom");
        cat.makeSound();
        cat.eat();
        cat.play();

        Dog dog = new Dog("Rex");
        dog.makeSound();
        dog.eat();
        dog.play();

        Wolf wolf = new Wolf("Wolfgang");
        wolf.makeSound();
        wolf.eat();

        Dragon dragon = new Dragon("Smaug");
        dragon.makeSound();
        dragon.eat();

        RoboDog roboDog = new RoboDog("Rex 2.0");
        roboDog.play();
        roboDog.performTask();

        roboDog.charge();

        System.out.printf("Charging %s...%n", roboDog.getModel());

        roboDog.performTask();
    }
}