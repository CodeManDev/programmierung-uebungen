package animals.canines;

import animals.Animal;

public abstract class Canine extends Animal {

    public Canine(String name) {
        super(name);
    }

    public void eat() {
        super.eat();
        System.out.printf("%s howls after eating.%n", this.getName());
    }

}
