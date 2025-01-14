package animals.felines;

import animals.Pet;

public class Cat extends Feline implements Pet {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s meows.%n", this.getName());
    }

    @Override
    public void play() {
        System.out.printf("%s plays with a ball of yarn.%n", this.getName());
    }
}
