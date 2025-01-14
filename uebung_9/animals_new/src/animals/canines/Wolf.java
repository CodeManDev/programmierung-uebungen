package animals.canines;

public class Wolf extends Canine {
    public Wolf(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s howls.%n", this.getName());
    }
}
