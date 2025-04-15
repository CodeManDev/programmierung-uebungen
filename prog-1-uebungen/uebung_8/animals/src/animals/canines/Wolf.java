package animals.canines;

public class Wolf extends Canine {
    @Override
    public void makeSound() {
        System.out.printf("%s howls.%n", this.getName());
    }
}
