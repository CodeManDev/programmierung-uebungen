package animals.felines;

import animals.Animal;

public abstract class Feline extends Animal {

    public void eat() {
        super.eat();
        System.out.printf("%s licks its paws after eating.%n", this.getName());
    }

}