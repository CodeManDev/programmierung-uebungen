package animals.felines;

public class Lion extends Feline {
    public Lion(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s roars.%n", this.getName());
    }
}
