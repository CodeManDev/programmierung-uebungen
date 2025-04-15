package animals;

public class Dragon extends Animal {
    public Dragon(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s roars breathes fire!%n", this.getName());
    }
}
