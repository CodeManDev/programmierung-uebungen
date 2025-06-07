import java.util.List;
import java.util.Scanner;

public class CommandLineInterface implements Interface {

    private final Inventory inventory;
    private final Scanner scanner;

    public CommandLineInterface(Inventory inventory) {
        this.inventory = inventory;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Welcome to the Inventory Management System!");
        boolean running = true;

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Find Product by ID");
            System.out.println("4. Find Products by Category");
            System.out.println("5. Display All Products");
            System.out.println("6. Sort Products by Name");
            System.out.println("7. Sort Products by Price");
            System.out.println("8. Display Low Stock Products");
            System.out.println("9. Display Products with Filter");
            System.out.println("10. Increase Product Price");
            System.out.println("11. Exit");

            int choice = this.takeIntegerInput("Enter your choice: ");

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> findProductById();
                case 4 -> findProductsByCategory();
                case 5 -> displayAllProducts();
                case 6 -> sortProductsByName();
                case 7 -> sortProductsByPrice();
                case 8 -> displayLowStockProducts();
                case 9 -> displayProductsWithFilter();
                case 10 -> increaseProductPrice();
                case 11 -> running = false;
                default -> System.out.println("Invalid choice, please try again.");
            }
        }

        System.out.println("Thank you for using the Inventory Management System!");
    }

    @Override
    public void addProduct() {
        int productId = this.takeIntegerInput("Enter product ID: ");

        System.out.print("Enter product name: ");
        String name = this.scanner.nextLine();

        System.out.print("Enter product category: ");
        String category = this.scanner.nextLine();

        double price = this.takeDoubleInput("Enter product price: ");

        int quantity = this.takeIntegerInput("Enter product quantity: ");

        Product product = new Product(productId, name, category, price, quantity);
        this.inventory.addProduct(product);

        System.out.println("Product added successfully!");
    }

    @Override
    public void removeProduct() {
        int productId = this.takeIntegerInput("Enter product ID to remove: ");

        if (this.inventory.removeProduct(productId)) {
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    @Override
    public void findProductById() {
        int productId = this.takeIntegerInput("Enter product ID to find: ");

        Product product = this.inventory.findProductById(productId);
        if (product != null) {
            System.out.println("Product found: " + product.getName() + ", Category: " + product.getCategory() +
                               ", Price: " + product.getPrice() + ", Quantity: " + product.getQuantity());
        } else {
            System.out.println("Product not found.");
        }
    }

    @Override
    public void findProductsByCategory() {
        System.out.print("Enter category to find products: ");
        String category = this.scanner.nextLine();

        List<Product> products = this.inventory.findProductsByCategory(category);
        if (products.isEmpty()) {
            System.out.println("No products found with this category.");
        } else {
            System.out.println("Products in category '" + category + "':");
            for (Product product : products) {
                System.out.println("ID: " + product.getProductId() + ", Name: " + product.getName() +
                        ", Price: " + product.getPrice() + ", Quantity: " + product.getQuantity());
            }
        }
    }

    @Override
    public void displayAllProducts() {
        List<Product> products = this.inventory.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("All products in inventory:");
            for (Product product : products) {
                System.out.println("ID: " + product.getProductId() + ", Name: " + product.getName() +
                                   ", Category: " + product.getCategory() + ", Price: " + product.getPrice() +
                                   ", Quantity: " + product.getQuantity());
            }
        }
    }

    @Override
    public void sortProductsByName() {
        this.inventory.sortProductsByName();
        System.out.println("Products sorted by name.");
    }

    @Override
    public void sortProductsByPrice() {
        this.inventory.sortProductsByPrice();
        System.out.println("Products sorted by price.");
    }

    @Override
    public void displayLowStockProducts() {
        int threshold = this.takeIntegerInput("Enter low stock threshold: ");

        List<Product> lowStockProducts = this.inventory.getLowStockProducts(threshold);
        if (lowStockProducts.isEmpty()) {
            System.out.println("No products below the stock threshold.");
        } else {
            System.out.println("Products below the stock threshold:");
            for (Product product : lowStockProducts) {
                System.out.println("ID: " + product.getProductId() + ", Name: " + product.getName() +
                                   ", Category: " + product.getCategory() + ", Price: " + product.getPrice() +
                                   ", Quantity: " + product.getQuantity());
            }
        }
    }

    @Override
    public void displayProductsWithFilter() {
        String condition = this.takeStringInput("Enter filter: ", "price", "quantity");
        String operator = this.takeStringInput("Enter operator: ", ">", "<", "=");
        double value = this.takeDoubleInput("Enter value: ");

        List<Product> filteredProducts = this.inventory.filterProducts(product -> switch (condition) {
            case "price" -> switch (operator) {
                case ">" -> product.getPrice() > value;
                case "<" -> product.getPrice() < value;
                case "=" -> product.getPrice() == value;
                default -> false;
            };
            case "quantity" -> switch (operator) {
                case ">" -> product.getQuantity() > value;
                case "<" -> product.getQuantity() < value;
                case "=" -> product.getQuantity() == value;
                default -> false;
            };
            default -> false;
        });

        if (filteredProducts.isEmpty()) {
            System.out.println("No products match the filter criteria.");
        } else {
            System.out.println("Filtered products:");
            for (Product product : filteredProducts) {
                System.out.println("ID: " + product.getProductId() + ", Name: " + product.getName() +
                                   ", Category: " + product.getCategory() + ", Price: " + product.getPrice() +
                                   ", Quantity: " + product.getQuantity());
            }
        }
    }

    @Override
    public void increaseProductPrice() {
        double percentage = this.takeDoubleInput("Enter percentage to increase product prices by: ");
        this.inventory.applyToProducts(product -> {
            double newPrice = product.getPrice() * (1 + percentage / 100);
            product.setPrice(newPrice);
        });
    }

    private int takeIntegerInput(String prompt) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return value;
    }

    private double takeDoubleInput(String prompt) {
        double value = 0.0;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid double.");
            }
        }
        return value;
    }

    private String takeStringInput(String prompt, String... validOptions) {
        while (true) {
            System.out.print(prompt + " (" + String.join(", ", validOptions) + ") ");
            String input = scanner.nextLine().trim();
            if (validOptions.length == 0 || List.of(validOptions).contains(input)) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter one of: " + String.join(", ", validOptions));
            }
        }
    }
}
