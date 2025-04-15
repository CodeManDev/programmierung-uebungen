package animals.felines;

public class Lion extends Feline {
    @Override
    public void makeSound() {
        System.out.printf("%s roars.%n", this.getName());
    }
}
