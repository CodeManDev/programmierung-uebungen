package animals;

public class Dragon extends Animal {
    @Override
    public void makeSound() {
        System.out.printf("%s roars breathes fire!%n", this.getName());
    }
}
