public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CommandLineInterface cli = new CommandLineInterface(inventory);

        cli.run();
    }

}