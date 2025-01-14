package animals.canines;

import animals.Animal;

public abstract class Canine extends Animal {

    public void eat() {
        super.eat();
        System.out.printf("%s howls after eating.%n", this.getName());
    }

}
