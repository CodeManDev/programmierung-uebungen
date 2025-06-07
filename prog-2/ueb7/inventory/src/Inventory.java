import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Inventory {

    // K: productId, V: Product
    private final LinkedHashMap<Integer, Product> inventory; // LinkedHashMap sortierbar, Operationen in O(1)

    public Inventory() {
        this.inventory = new LinkedHashMap<>();
    }

    public void addProduct(Product product) {
        this.inventory.put(product.getProductId(), product);
    }

    public boolean removeProduct(int productId) {
        if (this.inventory.containsKey(productId)) {
            this.inventory.remove(productId);
            return true;
        }
        return false;
    }

    public Product findProductById(int productId) {
        return this.inventory.get(productId);
    }

    public List<Product> findProductsByCategory(String category) {
        return this.inventory.values().stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    public List<Product> getAllProducts() {
        return this.inventory.values().stream().toList();
    }

    public void sortProducts(Comparator<Product> comparator) {
        List<Product> sortedProducts = this.inventory.values().stream()
                .sorted(comparator)
                .toList();
        this.inventory.clear();
        for (Product product : sortedProducts) {
            this.inventory.put(product.getProductId(), product);
        }
    }

    public void sortProductsByPrice() {
        sortProducts(Comparator.comparingDouble(Product::getPrice));
    }

    public void sortProductsByName() {
        sortProducts(Comparator.comparing(Product::getName));
    }

    public List<Product> filterProducts(Predicate<Product> predicate) {
        return this.inventory.values().stream()
                .filter(predicate)
                .toList();
    }

    public List<Product> getLowStockProducts(int threshold) {
        return filterProducts(product -> product.getQuantity() < threshold);
    }

    public void applyToProducts(Consumer<Product> action) {
        this.inventory.values().forEach(action);
    }
}
