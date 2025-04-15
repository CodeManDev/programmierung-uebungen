package animals;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public void eat() {
        System.out.printf("%s is eating.%n", this.name);
    }

    public String getName() {
        return this.name;
    }
}
