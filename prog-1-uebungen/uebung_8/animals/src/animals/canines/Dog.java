package animals.canines;

import animals.Pet;

public class Dog extends Canine implements Pet {
    @Override
    public void makeSound() {
        System.out.printf("%s barks.%n", this.getName());
    }

    @Override
    public void play() {
        System.out.printf("%s plays fetch.%n", this.getName());
    }
}
